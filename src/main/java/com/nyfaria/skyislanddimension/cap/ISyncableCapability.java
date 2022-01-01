package com.nyfaria.skyislanddimension.cap;

import com.nyfaria.skyislanddimension.network.CapabilityStatusPacket;
import com.nyfaria.skyislanddimension.network.NetworkHandler;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.fml.network.PacketDistributor;

public interface ISyncableCapability extends INBTSavable<CompoundNBT> {
    void updateTracking();

    CapabilityStatusPacket createUpdatePacket();

    default void sendUpdatePacketToPlayer(ServerPlayerEntity serverPlayer) {
        NetworkHandler.INSTANCE.send(PacketDistributor.PLAYER.with(() -> serverPlayer), this.createUpdatePacket());
    }
}
