package com.nyfaria.skyislanddimension.network;

import com.nyfaria.skyislanddimension.cap.caps.BuffCapability;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class ToggleCannonPacket implements IPacket {

    public ToggleCannonPacket() {
    }

    @Override
    public void handle(NetworkEvent.Context context) {
        ServerPlayerEntity player = context.getSender();
        if (player == null)
            return;
        context.enqueueWork(() -> {
            context.getSender().removeVehicle();
        });
    }

    @Override
    public void write(PacketBuffer packetBuf) {
    }

    public static ToggleCannonPacket read(PacketBuffer packetBuf) {
        return new ToggleCannonPacket();
    }

    public static void register(SimpleChannel channel, int id) {
        IPacket.register(channel, id, NetworkDirection.PLAY_TO_SERVER, ToggleCannonPacket.class, ToggleCannonPacket::read);
    }
}
