package me.drex.ppwt.mixin;

import com.mojang.authlib.GameProfile;
import me.drex.ppwt.data.PlayerWanderingTraderData;
import me.drex.ppwt.util.IServerPlayer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.npc.WanderingTraderSpawner;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayer.class)
public class ServerPlayerMixin implements IServerPlayer {

    @Unique
    private WanderingTraderSpawner wanderingTraderSpawner;

    @Unique
    private PlayerWanderingTraderData wanderingTraderData;

    @Unique
    private static final String NBT_KEY = "per_player_wandering_traders";

    @Inject(method = "<init>", at = @At("RETURN"))
    private void addWanderingTraderSpawner(MinecraftServer minecraftServer, ServerLevel serverLevel, GameProfile gameProfile, CallbackInfo ci) {
        this.wanderingTraderData = new PlayerWanderingTraderData();
        this.wanderingTraderSpawner = new WanderingTraderSpawner(wanderingTraderData);
    }

    @Override
    public WanderingTraderSpawner perPlayerWanderingTraders$getWanderingTraderSpawner() {
        return wanderingTraderSpawner;
    }

    @Inject(method = "readAdditionalSaveData", at = @At("RETURN"))
    private void loadWanderingTraderData(CompoundTag compoundTag, CallbackInfo ci) {
        if (compoundTag.contains(NBT_KEY)) {
            wanderingTraderData.loadFromTag(compoundTag.getCompound(NBT_KEY));
        }
    }

    @Inject(method = "addAdditionalSaveData", at = @At(value = "RETURN"))
    private void saveWanderingTraderData(CompoundTag compoundTag, CallbackInfo ci) {
        compoundTag.put(NBT_KEY, wanderingTraderData.createTag());
    }

}
