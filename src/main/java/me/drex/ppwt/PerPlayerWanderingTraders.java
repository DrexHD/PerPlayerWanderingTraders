package me.drex.ppwt;

import net.fabricmc.api.ModInitializer;
import net.minecraft.server.level.ServerPlayer;

public class PerPlayerWanderingTraders implements ModInitializer {

    public static final ThreadLocal<ServerPlayer> PLAYER_ARG = new ThreadLocal<>();

    @Override
    public void onInitialize() {
    }
}