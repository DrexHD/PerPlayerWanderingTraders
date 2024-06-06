package me.drex.ppwt;

import net.fabricmc.api.ModInitializer;
import net.minecraft.server.level.ServerPlayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PerPlayerWanderingTraders implements ModInitializer {


    public static final Logger LOGGER = LoggerFactory.getLogger("perplayerwanderingtraders");

    public static final ThreadLocal<ServerPlayer> PLAYER_ARG = new ThreadLocal<>();

    @Override
    public void onInitialize() {
    }
}