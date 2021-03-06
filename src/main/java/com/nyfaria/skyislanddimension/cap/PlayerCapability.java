package com.nyfaria.skyislanddimension.cap;

import net.minecraft.entity.player.PlayerEntity;

public abstract class PlayerCapability extends EntityCapability {
    protected final PlayerEntity player;

    protected PlayerCapability(PlayerEntity player) {
        super(player);
        this.player = player;
    }
}
