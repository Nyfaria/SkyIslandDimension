package com.nyfaria.skyislanddimension.events;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.nyfaria.skyislanddimension.SkyIslandDimension;
import com.nyfaria.skyislanddimension.cap.caps.BuffCapability;
import com.nyfaria.skyislanddimension.entity.canon.SkyCannonEntity;
import com.nyfaria.skyislanddimension.portal.SkyPortal;
import net.minecraft.command.impl.TeleportCommand;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.world.Dimension;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ITeleporter;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityMountEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SkyIslandDimension.MOD_ID)
public class CommonEvents {


    @SubscribeEvent
    public static void onPlayerMount(EntityMountEvent e){
        if(e.getEntityMounting() instanceof PlayerEntity && e.getEntityBeingMounted() instanceof SkyCannonEntity){

            if(e.isMounting()){
                e.getEntityMounting().setInvisible(true);
            }else{
                e.getEntityMounting().setInvisible(false);
            }

        }
    }

    @SubscribeEvent
    public static void tickEvent(TickEvent.PlayerTickEvent e){
        if(e.player.level.isClientSide)return;
        Vector3d pos = e.player.position();
            if(e.player.level.dimension()== World.OVERWORLD){
                if(pos.y >= 320) {
                    ITeleporter teleporter = new SkyPortal(false);
                    //e.player.changeDimension(e.player.level.getServer().getLevel(DimensionInit.SKY.key), teleporter);
                    try {
                        TeleportCommand.performTeleport(null, e.player, DimensionInit.SKY.getWorld(),e.player.getX(),200,e.player.getZ(),null,0,0,null);
                    } catch (CommandSyntaxException commandSyntaxException) {
                        commandSyntaxException.printStackTrace();
                    }
                }
            }
            if(e.player.level.dimension() == DimensionInit.SKY.key){
                if(pos.y < 0)
                {
                    try {
                        TeleportCommand.performTeleport(null, e.player, e.player.level.getServer().getLevel(World.OVERWORLD) ,e.player.getX(),310,e.player.getZ(),null,0,0,null);
                    } catch (CommandSyntaxException commandSyntaxException) {
                        commandSyntaxException.printStackTrace();
                    }
                }


            }

    }
}
