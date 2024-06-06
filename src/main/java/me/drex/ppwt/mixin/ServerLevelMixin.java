package me.drex.ppwt.mixin;

import me.drex.ppwt.PerPlayerWanderingTraders;
import me.drex.ppwt.util.IServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(ServerLevel.class)
public abstract class ServerLevelMixin {

    @Shadow
    @Final
    List<ServerPlayer> players;

    @Inject(method = "tickCustomSpawners", at = @At("RETURN"))
    private void tickPerPlayerWanderingTradeSpawner(boolean spawnEnemies, boolean spawnFriendlies, CallbackInfo ci) {
        for (ServerPlayer player : this.players) {
            var previous = PerPlayerWanderingTraders.PLAYER_ARG.get();
            PerPlayerWanderingTraders.PLAYER_ARG.set(player);
            try {
                ((IServerPlayer) player).perPlayerWanderingTraders$getWanderingTraderSpawner().tick((ServerLevel) (Object) this, spawnEnemies, spawnFriendlies);
            } finally {
                PerPlayerWanderingTraders.PLAYER_ARG.set(previous);
            }
        }
    }

}
