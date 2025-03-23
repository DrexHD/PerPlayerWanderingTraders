package me.drex.ppwt.data;

import net.minecraft.core.BlockPos;
import net.minecraft.core.UUIDUtil;
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
    public void setSpawn(BlockPos blockPos, float f) {
        throw new UnsupportedOperationException();
    }

    @Override
    public BlockPos getSpawnPos() {
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
            compoundTag.store("WanderingTraderId", UUIDUtil.CODEC, this.wanderingTraderId);
        }
        return compoundTag;
    }

    public void loadFromTag(CompoundTag compoundTag) {
        this.wanderingTraderSpawnDelay = compoundTag.getIntOr("WanderingTraderSpawnDelay", 0);
        this.wanderingTraderSpawnChance = compoundTag.getIntOr("WanderingTraderSpawnChance", 0);
        compoundTag.putInt("WanderingTraderSpawnChance", this.wanderingTraderSpawnChance);
        compoundTag.read("WanderingTraderId", UUIDUtil.CODEC).ifPresent(uuid -> {
            this.wanderingTraderId = uuid;
        });
    }
}
