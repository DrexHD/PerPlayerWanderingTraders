package me.drex.ppwt.mixin;

import net.minecraft.world.entity.npc.wanderingtrader.WanderingTraderSpawner;
import net.minecraft.world.level.saveddata.WanderingTraderData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(WanderingTraderSpawner.class)
public interface WanderingTraderSpawnerAccessor {
    @Accessor
    void setTraderData(WanderingTraderData traderData);
}
