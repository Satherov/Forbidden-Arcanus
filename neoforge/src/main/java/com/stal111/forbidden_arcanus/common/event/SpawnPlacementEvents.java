package com.stal111.forbidden_arcanus.common.event;

import com.stal111.forbidden_arcanus.common.entity.lostsoul.AbstractLostSoul;
import com.stal111.forbidden_arcanus.core.init.ModEntities;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

/**
 * @author stal111
 * @since 2022-11-01
 */
public class SpawnPlacementEvents {

    @SubscribeEvent
    public void registerSpawnPlacements(RegisterSpawnPlacementsEvent event) {
        event.register(ModEntities.LOST_SOUL.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AbstractLostSoul::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(ModEntities.CORRUPT_LOST_SOUL.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AbstractLostSoul::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(ModEntities.ENCHANTED_LOST_SOUL.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AbstractLostSoul::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
    }
}
