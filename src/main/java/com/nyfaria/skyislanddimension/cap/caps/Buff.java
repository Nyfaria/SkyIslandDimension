package com.nyfaria.skyislanddimension.cap.caps;

import com.nyfaria.skyislanddimension.cap.PlayerCapability;
import com.nyfaria.skyislanddimension.network.BuffStatusPacket;
import com.nyfaria.skyislanddimension.network.CapabilityStatusPacket;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;

public class Buff extends PlayerCapability {

    private boolean isCanon = false;

    protected Buff(PlayerEntity player) {
        super(player);
    }

    @Override
    public CompoundNBT serializeNBT(boolean savingToDisk) {
        CompoundNBT tag = new CompoundNBT();
        tag.putBoolean("iscanon", isCanon);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt, boolean readingFromDisk) {
        isCanon = nbt.getBoolean("iscanon");
    }


    public boolean getCanon(){
        return isCanon;
    }

    public void setCanon(boolean isCanon){
        this.isCanon = isCanon;
        this.updateTracking();
    }



    @Override
    public CapabilityStatusPacket createUpdatePacket() {
        return new BuffStatusPacket(player.getId(),this);
    }
}
