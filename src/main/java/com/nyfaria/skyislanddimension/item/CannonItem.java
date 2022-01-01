package com.nyfaria.skyislanddimension.item;

import com.nyfaria.skyislanddimension.cap.caps.BuffCapability;
import com.nyfaria.skyislanddimension.entity.canon.SkyCannonEntity;
import com.nyfaria.skyislanddimension.init.EntityInit;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CannonItem extends Item {
    public CannonItem(Properties p_i48487_1_) {
        super(p_i48487_1_);
    }

    @Override
    public ActionResultType useOn(ItemUseContext pContext) {

        if(pContext.getClickedFace() == Direction.UP){
            BlockPos clickedPos = pContext.getClickedPos();
            SkyCannonEntity skyCannonEntity = new SkyCannonEntity(EntityInit.SKY_CANNON.get(),pContext.getLevel());
            skyCannonEntity.setPos(clickedPos.getX(),clickedPos.getY()+1,clickedPos.getZ());
            pContext.getLevel().addFreshEntity(skyCannonEntity);
            pContext.getPlayer().getItemInHand(pContext.getHand()).shrink(1);
        }


        return super.useOn(pContext);
    }
}
