package com.stal111.forbidden_arcanus.data;

import com.stal111.forbidden_arcanus.ForbiddenArcanus;
import com.stal111.forbidden_arcanus.data.client.ModSoundsProvider;
import com.stal111.forbidden_arcanus.data.particle.ParticleDataProvider;
import com.stal111.forbidden_arcanus.data.recipes.ApplyModifierRecipeProvider;
import com.stal111.forbidden_arcanus.data.recipes.ClibanoRecipeProvider;
import com.stal111.forbidden_arcanus.data.recipes.CraftingRecipeProvider;
import com.stal111.forbidden_arcanus.data.server.loot.ModLootModifierProvider;
import com.stal111.forbidden_arcanus.data.server.tags.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.valhelsia.valhelsia_core.api.datagen.DataProviderContext;
import net.valhelsia.valhelsia_core.api.datagen.recipes.ValhelsiaRecipeProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

/**
 * @author stal111
 * @since 2021-01-26
 */
@Mod.EventBusSubscriber(modid = ForbiddenArcanus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();

        DataProviderContext context = new DataProviderContext(event.getGenerator().getPackOutput(), event.getLookupProvider(), ForbiddenArcanus.REGISTRY_MANAGER);

        // Client Providers
        //TODO
        //generator.addProvider(event.includeClient(), new ModBlockStateProvider(context));
        //generator.addProvider(event.includeClient(), new ModItemModelProvider(context));

        generator.addProvider(event.includeClient(), new ModSoundsProvider(context, fileHelper));
        generator.addProvider(event.includeServer(), new ParticleDataProvider(context));

        // Server Providers
        generator.addProvider(event.includeServer(), new DatapackBuiltinEntriesProvider(output, lookupProvider, ForbiddenArcanus.REGISTRY_MANAGER.buildRegistrySet(), Set.of(ForbiddenArcanus.MOD_ID)));

        ModBlockTagsProvider blockTagsProvider = new ModBlockTagsProvider(context);
        generator.addProvider(event.includeServer(), blockTagsProvider);
        generator.addProvider(event.includeServer(), new ModItemTagsProvider(context, fileHelper, blockTagsProvider.contentsGetter()));
        generator.addProvider(event.includeServer(), new ModEnchantmentTagsProvider(context, fileHelper));
        generator.addProvider(event.includeServer(), new ModEntityTypeTagsProvider(context, fileHelper));
        generator.addProvider(event.includeServer(), new ModBiomeTagsProvider(context, fileHelper));
        generator.addProvider(event.includeServer(), new ModDamageTypeTagsProvider(context, fileHelper));

        //TODO
        //generator.addProvider(event.includeServer(), new LootTableProvider(output, Set.of(), List.of(new LootTableProvider.SubProviderEntry(ModBlockLootTables::new, LootContextParamSets.BLOCK))));

        generator.addProvider(event.includeServer(), new ValhelsiaRecipeProvider(context, CraftingRecipeProvider::new, ClibanoRecipeProvider::new, ApplyModifierRecipeProvider::new));

        generator.addProvider(event.includeServer(), new ModLootModifierProvider(output));
    }
}
