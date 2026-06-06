package me.drex.ppwt.data;

import me.drex.ppwt.mixin.WanderingTraderSpawnerAccessor;
import net.minecraft.world.entity.npc.wanderingtrader.WanderingTraderSpawner;
import net.minecraft.world.level.saveddata.WanderingTraderData;

public class PlayerWanderingTraderSpawner extends WanderingTraderSpawner {
    public PlayerWanderingTraderSpawner() {
        super(null);
        // initialize default
        ((WanderingTraderSpawnerAccessor) this).setTraderData(new WanderingTraderData());

    }
}
