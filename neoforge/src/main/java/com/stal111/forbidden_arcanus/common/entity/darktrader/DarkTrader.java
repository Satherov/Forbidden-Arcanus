package com.stal111.forbidden_arcanus.common.entity.darktrader;

import com.mojang.serialization.Dynamic;
import com.stal111.forbidden_arcanus.common.entity.QuantumLightDoorAnimationProvider;
import com.stal111.forbidden_arcanus.core.init.other.ModEntityDataSerializers;
import com.stal111.forbidden_arcanus.core.registry.FARegistries;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Unit;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

/**
 * @author stal111
 * @since 2023-08-11
 */
public class DarkTrader extends Mob implements VariantHolder<Holder<DarkTraderVariant>>, QuantumLightDoorAnimationProvider {

    private static final EntityDataAccessor<Holder<DarkTraderVariant>> DATA_VARIANT_ID = SynchedEntityData.defineId(DarkTrader.class, ModEntityDataSerializers.DARK_TRADER_VARIANT.get());

    public final AnimationState portalAnimationState = new AnimationState();
    public final AnimationState spawnAnimationState = new AnimationState();

    public DarkTrader(EntityType<? extends Mob> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 14.0D).add(Attributes.MOVEMENT_SPEED, 0.3D);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.@NotNull Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_VARIANT_ID, DarkTraderVariant.BROOK);
    }

    @Override
    protected @NotNull Brain<?> makeBrain(@NotNull Dynamic<?> dynamic) {
        return DarkTraderAI.makeBrain(this, dynamic);
    }

    @Override
    public @NotNull Brain<DarkTrader> getBrain() {
        return (Brain<DarkTrader>) super.getBrain();
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType reason, @Nullable SpawnGroupData spawnData) {
        if (reason == MobSpawnType.MOB_SUMMONED) {
            this.setPose(Pose.EMERGING);
            this.getBrain().setMemoryWithExpiry(MemoryModuleType.IS_EMERGING, Unit.INSTANCE, DarkTraderAI.SPAWN_DURATION);
        }

        return super.finalizeSpawn(level, difficulty, reason, spawnData);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()) {
            this.spawnAnimationState.animateWhen(this.getPose() == Pose.EMERGING && this.portalAnimationState.getAccumulatedTime() > 600, this.tickCount);
        }
    }

    @Override
    public void onSyncedDataUpdated(@NotNull EntityDataAccessor<?> key) {
        if (DATA_POSE.equals(key)) {
            if (this.getPose() == Pose.EMERGING) {
                this.portalAnimationState.start(this.tickCount);
            }
        }
        super.onSyncedDataUpdated(key);
    }

    @Override
    public @NotNull Holder<DarkTraderVariant> getVariant() {
        return this.entityData.get(DATA_VARIANT_ID);
    }

    @Override
    public void setVariant(@NotNull Holder<DarkTraderVariant> variant) {
        this.entityData.set(DATA_VARIANT_ID, variant);
    }

    @Override
    protected void customServerAiStep() {
        this.level().getProfiler().push("darkTraderBrain");
        this.getBrain().tick((ServerLevel) this.level(), this);
        this.level().getProfiler().pop();

        DarkTraderAI.updateActivity(this);
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag tag) {
        super.addAdditionalSaveData(tag);

        tag.putString("variant", FARegistries.DARK_TRADER_VARIANT_REGISTRY.getKey(this.getVariant().value()).toString());
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag tag) {
        super.readAdditionalSaveData(tag);

        Optional.ofNullable(ResourceLocation.tryParse(tag.getString("variant")))
                .flatMap(FARegistries.DARK_TRADER_VARIANT_REGISTRY::getHolder)
                .ifPresent(this::setVariant);
    }

    @Override
    public AnimationState getAnimationState() {
        return this.portalAnimationState;
    }
}
