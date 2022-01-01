package com.nyfaria.skyislanddimension.cap.caps;

import com.nyfaria.skyislanddimension.SkyIslandDimension;
import com.nyfaria.skyislanddimension.cap.CapabilityAttacher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class BuffCapability extends CapabilityAttacher {

    private static final Class<Buff> CAPABILITY_CLASS = Buff.class;
    @CapabilityInject(Buff.class) // HAS to be public!
    public static final Capability<Buff> BUFF_CAPABILITY = null;
    private static final ResourceLocation BUFF_RL = new ResourceLocation(SkyIslandDimension.MOD_ID, "buff");

    public static Buff getBuffUnwrap(PlayerEntity player)
    {
        return getBuff(player).orElse(null);
    }
    public static LazyOptional<Buff> getBuff(PlayerEntity player)
    {
        return player.getCapability(BUFF_CAPABILITY);
    }

    private static void attach(AttachCapabilitiesEvent<Entity> event, PlayerEntity player) {
        genericAttachCapability(event, new Buff(player), BUFF_CAPABILITY, BUFF_RL);
    }

    public static void register() {
        CapabilityAttacher.registerCapability(CAPABILITY_CLASS);
        CapabilityAttacher.registerPlayerAttacher(BuffCapability::attach, BuffCapability::getBuff);
    }
    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {
        PlayerEntity oldPlayer = event.getOriginal();
        PlayerEntity newPlayer = event.getPlayer();

        // So we can copy capabilities
        oldPlayer.revive();

        getBuff(oldPlayer).ifPresent(oldAbilityHolder -> getBuff(newPlayer)
                .ifPresent(newAbilityHolder -> newAbilityHolder.deserializeNBT(oldAbilityHolder.serializeNBT(false), false)));
    }
}
