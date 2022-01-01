package com.nyfaria.skyislanddimension.events;

import com.google.common.collect.HashBiMap;
import com.nyfaria.skyislanddimension.SkyIslandDimension;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@Mod.EventBusSubscriber(modid = SkyIslandDimension.MOD_ID)
public class DimensionInit {
    private static final HashBiMap<RegistryKey<World>, HeroDimension> dimTypeMap = HashBiMap.create(25);

    public static final DimensionContainer SKY = new DimensionContainer("sky_dimension_two", HeroDimension.SKY);

    @Nullable
    public static HeroDimension getDim(@Nonnull RegistryKey<World> key) {
        return dimTypeMap.get(key);
    }

    @Nullable
    public static RegistryKey<World> getWorldKey(@Nonnull HeroDimension dim) {
        return dimTypeMap.inverse().get(dim);
    }

    public static class DimensionContainer {
        public final RegistryKey<World> key;
        public final HeroDimension dim;
        private ServerWorld world = null;

        private DimensionContainer(RegistryKey<World> key, HeroDimension dim) {
            this.key = key;
            this.dim = dim;

            dimTypeMap.put(key, dim);
        }

        private DimensionContainer(String dimId, HeroDimension dim) {
            this(RegistryKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(SkyIslandDimension.MOD_ID, dimId)), dim);
        }

        @Nullable
        public ServerWorld getWorld() {
            if (this.world != null)
                return this.world;

            if (ServerLifecycleHooks.getCurrentServer() == null)
                return null;

            this.world = ServerLifecycleHooks.getCurrentServer().getLevel(key);

            return this.world;
        }
    }


    public enum HeroDimension {
        SKY
    }
}
