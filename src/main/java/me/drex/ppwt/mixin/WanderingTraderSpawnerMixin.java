package me.drex.ppwt.mixin;

import me.drex.ppwt.PerPlayerWanderingTraders;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.npc.WanderingTraderSpawner;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(WanderingTraderSpawner.class)
public abstract class WanderingTraderSpawnerMixin {

    @Redirect(
        method = "spawn",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/server/level/ServerLevel;getRandomPlayer()Lnet/minecraft/server/level/ServerPlayer;"
        )
    )
    private ServerPlayer usePlayerArgument(ServerLevel level) {
        ServerPlayer serverPlayer = PerPlayerWanderingTraders.PLAYER_ARG.get();
        if (serverPlayer != null && serverPlayer.serverLevel().equals(level)) {
            return serverPlayer;
        }
        return null;
    }

}
