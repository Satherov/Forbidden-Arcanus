package com.stal111.forbidden_arcanus.common.block.entity;

import com.stal111.forbidden_arcanus.common.block.entity.forge.essence.EssenceType;
import com.stal111.forbidden_arcanus.core.init.ModBlockEntities;
import com.stal111.forbidden_arcanus.core.init.other.ModPOITypes;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

/**
 * Arcane Crystal Obelisk Block Entity <br>
 * Forbidden Arcanus - com.stal111.forbidden_arcanus.common.block.entity.ArcaneCrystalObeliskBlockEntity
 *
 * @author stal111
 * @version 1.19 - 2.1.0
 * @since 2021-08-03
 */
public class ArcaneCrystalObeliskBlockEntity extends BlockEntity {

    public ArcaneCrystalObeliskBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ARCANE_CRYSTAL_OBELISK.get(), pos, state);
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, ArcaneCrystalObeliskBlockEntity blockEntity) {
        if (level.getGameTime() % 100 != 0  || !(level instanceof ServerLevel serverLevel)) {
            return;
        }

        serverLevel.getPoiManager()
                .findClosest(poiTypeHolder -> poiTypeHolder.value() == ModPOITypes.HEPHAESTUS_FORGE.get(), pos, 4, PoiManager.Occupancy.ANY)
                .flatMap(forgePos -> serverLevel.getBlockEntity(forgePos, ModBlockEntities.HEPHAESTUS_FORGE.get()))
                .ifPresent(forgeBlockEntity -> {
                    forgeBlockEntity.getEssenceManager().increaseEssence(EssenceType.AUREAL, 1);
                });
    }
}
