package me.drex.ppwt.mixin;

import com.mojang.authlib.GameProfile;
import me.drex.ppwt.data.PlayerWanderingTraderData;
import me.drex.ppwt.util.IServerPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ClientInformation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.npc.wanderingtrader.WanderingTraderSpawner;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
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
    private void addWanderingTraderSpawner(MinecraftServer minecraftServer, ServerLevel serverLevel, GameProfile gameProfile, ClientInformation clientInformation, CallbackInfo ci) {
        this.wanderingTraderData = new PlayerWanderingTraderData();
        this.wanderingTraderSpawner = new WanderingTraderSpawner(wanderingTraderData);
    }

    @Override
    public WanderingTraderSpawner perPlayerWanderingTraders$getWanderingTraderSpawner() {
        return wanderingTraderSpawner;
    }

    @Inject(method = "readAdditionalSaveData", at = @At("RETURN"))
    private void loadWanderingTraderData(ValueInput valueInput, CallbackInfo ci) {
        valueInput.child(NBT_KEY).ifPresent(child -> wanderingTraderData.loadData(child));
    }

    @Inject(method = "addAdditionalSaveData", at = @At(value = "RETURN"))
    private void saveWanderingTraderData(ValueOutput valueOutput, CallbackInfo ci) {
        wanderingTraderData.saveData(valueOutput.child(NBT_KEY));
    }

}
