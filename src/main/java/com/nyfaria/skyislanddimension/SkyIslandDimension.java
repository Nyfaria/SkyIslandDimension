package com.nyfaria.skyislanddimension;

import com.nyfaria.skyislanddimension.cap.caps.BuffCapability;
import com.nyfaria.skyislanddimension.init.EntityInit;
import com.nyfaria.skyislanddimension.init.ItemInit;
import com.nyfaria.skyislanddimension.network.NetworkHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(SkyIslandDimension.MOD_ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SkyIslandDimension
{
    public static final String MOD_ID = "skyislanddimension";

    private static final Logger LOGGER = LogManager.getLogger();

    public SkyIslandDimension() {

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        ItemInit.ITEMS.register(bus);
        EntityInit.ENTITIES.register(bus);
    }
    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        BuffCapability.register();
        NetworkHandler.register();
    }
}
