package com.nyfaria.skyislanddimension.events;

import com.nyfaria.skyislanddimension.SkyIslandDimension;
import com.nyfaria.skyislanddimension.cap.caps.BuffCapability;
import com.nyfaria.skyislanddimension.entity.canon.SkyCannonModel;
import com.nyfaria.skyislanddimension.entity.canon.SkyCannonRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SkyIslandDimension.MOD_ID, value = Dist.CLIENT)
public class RenderEvents {

/*    @SubscribeEvent
    public static void renderCanon(RenderPlayerEvent e){
        BuffCapability.getBuff(e.getPlayer()).ifPresent(cap->{
            if(cap.getCanon()){
                SkyCannonRenderer werewolfRenderer2 = new SkyCannonRenderer(e.getRenderer().getDispatcher(), new SkyCannonModel(), 0);
                e.getMatrixStack().scale(.75f, .75f, .75f);
                werewolfRenderer2.render(e.getPlayer(), 0, e.getPartialRenderTick(), e.getMatrixStack(), e.getBuffers(), e.getLight());
                e.setCanceled(true);

            }
        });
    }*/

}
