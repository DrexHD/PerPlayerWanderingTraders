package me.drex.ppwt.data;

import net.minecraft.core.UUIDUtil;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.level.gamerules.GameRules;
import net.minecraft.world.level.storage.ServerLevelData;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.level.timers.TimerQueue;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.UUID;

public class PlayerWanderingTraderData implements ServerLevelData {

    private int wanderingTraderSpawnDelay = 0;
    private int wanderingTraderSpawnChance = 0;
    @Nullable
    private UUID wanderingTraderId = null;

    @Override
    public String getLevelName() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setThundering(boolean bl) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getRainTime() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setRainTime(int i) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setThunderTime(int i) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getThunderTime() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getClearWeatherTime() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setClearWeatherTime(int i) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getWanderingTraderSpawnDelay() {
        return this.wanderingTraderSpawnDelay;
    }

    @Override
    public void setWanderingTraderSpawnDelay(int i) {
        this.wanderingTraderSpawnDelay = i;
    }

    @Override
    public int getWanderingTraderSpawnChance() {
        return this.wanderingTraderSpawnChance;
    }

    @Override
    public void setWanderingTraderSpawnChance(int i) {
        this.wanderingTraderSpawnChance = i;
    }

    @Override
    @Nullable
    public UUID getWanderingTraderId() {
        return this.wanderingTraderId;
    }

    @Override
    public void setWanderingTraderId(UUID uUID) {
        this.wanderingTraderId = uUID;
    }

    @Override
    public GameType getGameType() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<WorldBorder.Settings> getLegacyWorldBorderSettings() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setLegacyWorldBorderSettings(Optional<WorldBorder.Settings> optional) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isInitialized() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setInitialized(boolean bl) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isAllowCommands() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setGameType(GameType gameType) {
        throw new UnsupportedOperationException();
    }

    @Override
    public TimerQueue<MinecraftServer> getScheduledEvents() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setGameTime(long l) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setDayTime(long l) {
        throw new UnsupportedOperationException();
    }

    @Override
    public GameRules getGameRules() {
        throw new UnsupportedOperationException();
    }

    @Override
    public RespawnData getRespawnData() {
        throw new UnsupportedOperationException();
    }

    @Override
    public long getGameTime() {
        throw new UnsupportedOperationException();
    }

    @Override
    public long getDayTime() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isThundering() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isRaining() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setRaining(boolean bl) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isHardcore() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Difficulty getDifficulty() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isDifficultyLocked() {
        throw new UnsupportedOperationException();
    }

    public void saveData(ValueOutput valueOutput) {
        valueOutput.putInt("WanderingTraderSpawnDelay", this.wanderingTraderSpawnDelay);
        valueOutput.putInt("WanderingTraderSpawnChance", this.wanderingTraderSpawnChance);
        if (this.wanderingTraderId != null) {
            valueOutput.store("WanderingTraderId", UUIDUtil.CODEC, this.wanderingTraderId);
        }
    }

    public void loadData(ValueInput valueInput) {
        this.wanderingTraderSpawnDelay = valueInput.getIntOr("WanderingTraderSpawnDelay", 0);
        this.wanderingTraderSpawnChance = valueInput.getIntOr("WanderingTraderSpawnChance", 0);
        valueInput.read("WanderingTraderId", UUIDUtil.CODEC).ifPresent(uuid -> {
            this.wanderingTraderId = uuid;
        });
    }

    @Override
    public void setSpawn(RespawnData respawnData) {
        throw new UnsupportedOperationException();
    }
}
