package com.stal111.forbidden_arcanus.data.worldgen.placement;

import com.stal111.forbidden_arcanus.ForbiddenArcanus;
import com.stal111.forbidden_arcanus.core.init.world.ModConfiguredFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.valhelsia.valhelsia_core.api.common.registry.helper.datapack.DatapackRegistryClass;
import net.valhelsia.valhelsia_core.api.common.registry.helper.datapack.DatapackRegistryHelper;

/**
 * Mod Tree Placements <br>
 * Forbidden Arcanus - com.stal111.forbidden_arcanus.data.worldgen.placement.ModTreePlacements
 *
 * @author stal111
 * @since 2021-12-29
 */
public class ModTreePlacements extends DatapackRegistryClass<PlacedFeature> {

    public static final DatapackRegistryHelper<PlacedFeature> HELPER = ForbiddenArcanus.REGISTRY_MANAGER.getHelper(Registries.PLACED_FEATURE);

    public static final PlacementModifier TREE_THRESHOLD = SurfaceWaterDepthFilter.forMaxDepth(0);

    public static final ResourceKey<PlacedFeature> EDELWOOD_TREES = HELPER.createKey("edelwood_trees");
    public static final ResourceKey<PlacedFeature> AURUM_TREES = HELPER.createKey("aurum_trees");

    public ModTreePlacements(BootstrapContext<PlacedFeature> context) {
        super(context);
    }

    @Override
    public void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatureRegistry = context.lookup(Registries.CONFIGURED_FEATURE);

        PlacementUtils.register(context, EDELWOOD_TREES, configuredFeatureRegistry.getOrThrow(ModConfiguredFeatures.EDELWOOD), InSquarePlacement.spread(), TREE_THRESHOLD, PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.countExtra(18, 0.25F, 3), BiomeFilter.biome());
        PlacementUtils.register(context, AURUM_TREES, configuredFeatureRegistry.getOrThrow(ModConfiguredFeatures.AURUM), InSquarePlacement.spread(), TREE_THRESHOLD, PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.countExtra(1, 0.2F, 1), BiomeFilter.biome());
    }
}
