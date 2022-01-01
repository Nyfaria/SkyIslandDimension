package com.nyfaria.skyislanddimension.events;

import com.nyfaria.skyislanddimension.SkyIslandDimension;
import com.nyfaria.skyislanddimension.entity.canon.SkyCannonRenderer;
import com.nyfaria.skyislanddimension.init.EntityInit;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = SkyIslandDimension.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientModEvents {
    @SubscribeEvent
    public static void init(final FMLClientSetupEvent event) {

        RenderingRegistry.registerEntityRenderingHandler(EntityInit.SKY_CANNON.get(), SkyCannonRenderer::new);
        KeybindEvents.init();
    }
}
