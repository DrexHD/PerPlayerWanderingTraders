package me.drex.ppwt;

import net.fabricmc.api.ModInitializer;
import net.minecraft.server.level.ServerPlayer;

import java.lang.ScopedValue;

public class PerPlayerWanderingTraders implements ModInitializer {

    public static final ScopedValue<ServerPlayer> PLAYER_ARG = ScopedValue.newInstance();

    @Override
    public void onInitialize() {
    }
}