package com.nyfaria.skyislanddimension.cap;

import com.nyfaria.skyislanddimension.network.NetworkHandler;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.network.PacketDistributor;

public abstract class EntityCapability implements ISyncableCapability {
    protected final Entity entity;

    protected EntityCapability(Entity entity) {
        this.entity = entity;
    }

    @Override
    public void updateTracking() {
        if (this.entity.level.isClientSide)
            return;
        NetworkHandler.INSTANCE.send(PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> this.entity), this.createUpdatePacket());
    }
}
