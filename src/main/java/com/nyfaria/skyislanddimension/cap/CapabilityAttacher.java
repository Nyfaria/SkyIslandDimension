package com.nyfaria.skyislanddimension.cap;

import com.nyfaria.skyislanddimension.SkyIslandDimension;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

public abstract class CapabilityAttacher {
    @SuppressWarnings("rawtypes")
    private static final Capability.IStorage EMPTY_STORAGE = new Capability.IStorage() {
        @Nullable
        @Override
        public INBT writeNBT(Capability capability, Object instance, Direction side) {return null;}

        @Override
        public void readNBT(Capability capability, Object instance, Direction side, INBT nbt) {}
    };

    @SuppressWarnings("unchecked")
    protected static <T> void registerCapability(Class<T> capClass) {
        CapabilityManager.INSTANCE.register(capClass, (Capability.IStorage<T>) EMPTY_STORAGE, () -> null);
    }

    private static final List<BiConsumer<AttachCapabilitiesEvent<Entity>, Entity>> capAttachers = new ArrayList<>();
    private static final List<Function<Entity, LazyOptional<? extends ISyncableCapability>>> capRetrievers = new ArrayList<>();

    protected static <C extends ISyncableCapability> void registerPlayerAttacher(BiConsumer<AttachCapabilitiesEvent<Entity>, PlayerEntity> attacher,
                                                                                                               Function<PlayerEntity, LazyOptional<C>> capRetriever) {
        registerAttacher(PlayerEntity.class, attacher, capRetriever);
    }

    @SuppressWarnings("unchecked")
    protected static <E extends Entity, C extends ISyncableCapability> void registerAttacher(Class<E> entityClass, BiConsumer<AttachCapabilitiesEvent<Entity>, E> attacher,
                                                                                                                           Function<E, LazyOptional<C>> capRetriever) {
        capAttachers.add((event, entity) -> {
            if (entityClass.isInstance(entity))
                attacher.accept(event, (E) entity);
        });
        capRetrievers.add(entity -> entityClass.isInstance(entity) ? capRetriever.apply((E) entity) : LazyOptional.empty());
    }

    protected static <I extends INBTSerializable<T>, T extends INBT> void genericAttachCapability(AttachCapabilitiesEvent<?> event, I impl, Capability<I> capability, ResourceLocation location) {
        genericAttachCapability(event, impl, capability, location, true);
    }

    protected static <I extends INBTSerializable<T>, T extends INBT> void genericAttachCapability(AttachCapabilitiesEvent<?> event, I impl, Capability<I> capability, ResourceLocation location,
            boolean save) {
        LazyOptional<I> storage = LazyOptional.of(() -> impl);
        ICapabilityProvider provider = getProvider(impl, storage, capability, save);
        event.addCapability(location, provider);
        event.addListener(storage::invalidate);
    }

    protected static <I extends INBTSerializable<T>, T extends INBT> ICapabilityProvider getProvider(I impl, LazyOptional<I> storage, Capability<I> capability, boolean save) {
        if (capability == null)
            throw new NullPointerException();
        return save ? new ICapabilitySerializable<T>() {
            @Nonnull
            @Override
            public <C> LazyOptional<C> getCapability(@Nonnull Capability<C> cap, @Nullable Direction side) {
                return cap == capability ? storage.cast() : LazyOptional.empty();
            }

            @SuppressWarnings("unchecked")
            @Override
            public T serializeNBT() {
                return impl instanceof INBTSavable ? (T) ((INBTSavable<?>) impl).serializeNBT(true) : impl.serializeNBT();
            }

            @SuppressWarnings("unchecked")
            @Override
            public void deserializeNBT(T nbt) {
                if (impl instanceof INBTSavable) {
                    ((INBTSavable<T>) impl).deserializeNBT(nbt, true);
                } else {
                    impl.deserializeNBT(nbt);
                }
            }
        } : new ICapabilityProvider() {
            @Nonnull
            @Override
            public <C> LazyOptional<C> getCapability(@Nonnull Capability<C> cap, @Nullable Direction side) {
                return cap == capability ? storage.cast() : LazyOptional.empty();
            }
        };
    }

    @Mod.EventBusSubscriber(modid = SkyIslandDimension.MOD_ID)
    private static final class EventHandler {
        @SubscribeEvent
        public static void onAttachCapability(AttachCapabilitiesEvent<Entity> event) {
            // Attaches the capabilities
            capAttachers.forEach(attacher -> attacher.accept(event, event.getObject()));
        }

        @SubscribeEvent
        public static void onEntityJoinWorld(EntityJoinWorldEvent event) {
            if (event.getEntity() instanceof ServerPlayerEntity) {
                // Syncs a player's capabilities to themselves on world join (either joining server or switching worlds)
                ServerPlayerEntity serverPlayer = (ServerPlayerEntity) event.getEntity();
                capRetrievers.forEach(capRetriever -> capRetriever.apply(serverPlayer).ifPresent(cap -> cap.sendUpdatePacketToPlayer(serverPlayer)));
            }
        }

        @SubscribeEvent
        public static void onPlayerStartTracking(PlayerEvent.StartTracking event) {
            // Syncs an entity's capabilities to a player when they start tracking it
            ServerPlayerEntity currentPlayer = (ServerPlayerEntity) event.getPlayer();
            capRetrievers.forEach(capRetriever -> capRetriever.apply(event.getTarget()).ifPresent(cap -> cap.sendUpdatePacketToPlayer(currentPlayer)));
        }
    }
}
