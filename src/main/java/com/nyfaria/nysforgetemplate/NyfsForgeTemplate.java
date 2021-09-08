package com.nyfaria.nysforgetemplate;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(NyfsForgeTemplate.MOD_ID)
public class NyfsForgeTemplate
{
    public static final String MOD_ID = "nyfsforgetemplate";

    private static final Logger LOGGER = LogManager.getLogger();

    public NyfsForgeTemplate() {

        MinecraftForge.EVENT_BUS.register(this);
    }

}
