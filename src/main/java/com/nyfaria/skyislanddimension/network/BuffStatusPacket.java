package com.nyfaria.skyislanddimension.network;

import com.nyfaria.skyislanddimension.cap.caps.Buff;
import com.nyfaria.skyislanddimension.cap.caps.BuffCapability;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class BuffStatusPacket extends CapabilityStatusPacket{

    protected BuffStatusPacket(int entityId, CompoundNBT tag) {
        super(entityId, tag);
    }
    public BuffStatusPacket(int entityId, Buff capability) {
        super(entityId, capability);
    }
    @Override
    public void handle(NetworkEvent.Context context) {
        context.enqueueWork(() -> ClientPacketHandler.handleCapabilityStatus(this, BuffCapability::getBuffUnwrap));
    }
    public static void register(SimpleChannel channel, int id) {
        register(channel, id, BuffStatusPacket.class, buf -> read(buf, BuffStatusPacket::new));
    }
}
