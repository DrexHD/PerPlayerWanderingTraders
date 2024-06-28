package me.drex.ppwt.data;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.level.storage.ServerLevelData;
import net.minecraft.world.level.timers.TimerQueue;
import org.jetbrains.annotations.Nullable;

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
    public void setWorldBorder(WorldBorder.Settings settings) {
        throw new UnsupportedOperationException();
    }

    @Override
    public WorldBorder.Settings getWorldBorder() {
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
    public boolean getAllowCommands() {
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
    public void setXSpawn(int i) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setYSpawn(int i) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setZSpawn(int i) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setSpawnAngle(float f) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setSpawn(BlockPos blockPos, float f) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getXSpawn() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getYSpawn() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getZSpawn() {
        throw new UnsupportedOperationException();
    }

    @Override
    public float getSpawnAngle() {
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
    public GameRules getGameRules() {
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

    public CompoundTag createTag() {
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.putInt("WanderingTraderSpawnDelay", this.wanderingTraderSpawnDelay);
        compoundTag.putInt("WanderingTraderSpawnChance", this.wanderingTraderSpawnChance);
        if (this.wanderingTraderId != null) {
            compoundTag.putUUID("WanderingTraderId", this.wanderingTraderId);
        }
        return compoundTag;
    }

    public void loadFromTag(CompoundTag compoundTag) {
        this.wanderingTraderSpawnDelay = compoundTag.getInt("WanderingTraderSpawnDelay");
        this.wanderingTraderSpawnChance = compoundTag.getInt("WanderingTraderSpawnChance");
        compoundTag.putInt("WanderingTraderSpawnChance", this.wanderingTraderSpawnChance);
        if (compoundTag.contains("WanderingTraderId")) {
            this.wanderingTraderId = compoundTag.getUUID("WanderingTraderId");
        }
    }
}
