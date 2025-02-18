package com.stal111.forbidden_arcanus.data.recipes;

import com.mojang.datafixers.util.Either;
import com.mojang.datafixers.util.Pair;
import com.stal111.forbidden_arcanus.common.block.entity.clibano.residue.ResidueChance;
import com.stal111.forbidden_arcanus.common.block.entity.clibano.residue.ResidueType;
import com.stal111.forbidden_arcanus.common.item.enhancer.EnhancerDefinition;
import com.stal111.forbidden_arcanus.core.init.ModItems;
import com.stal111.forbidden_arcanus.core.registry.FARegistries;
import com.stal111.forbidden_arcanus.data.enhancer.ModEnhancerDefinitions;
import com.stal111.forbidden_arcanus.data.recipes.builder.ClibanoRecipeBuilder;
import com.stal111.forbidden_arcanus.data.residue.ModResidueTypes;
import com.stal111.forbidden_arcanus.util.ModTags;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.valhelsia.valhelsia_core.datagen.recipes.RecipeSubProvider;
import net.valhelsia.valhelsia_core.datagen.recipes.ValhelsiaRecipeProvider;

/**
 * @author stal111
 * @since 2022-06-26
 */
public class ClibanoRecipeProvider extends RecipeSubProvider {

    public static final double CHANCE_65 = 0.65D;
    public static final double CHANCE_33 = 0.33D;
    public static final double CHANCE_20 = 0.2D;
    public static final double CHANCE_10 = 0.1D;
    public static final double CHANCE_05 = 0.05D;

    public ClibanoRecipeProvider(ValhelsiaRecipeProvider provider) {
        super(provider);
    }

    @Override
    protected void registerRecipes(HolderLookup.Provider lookupProvider) {
        HolderGetter<ResidueType> residueLookup = lookupProvider.lookupOrThrow(FARegistries.RESIDUE_TYPE);
        HolderGetter<EnhancerDefinition> enhancerLookup = lookupProvider.lookupOrThrow(FARegistries.ENHANCER_DEFINITION);

        this.add(this.clibanoRecipe(ModItems.ARCANE_CRYSTAL.get(), Ingredient.of(ModTags.Items.ARCANE_CRYSTAL_ORES), 1.0F, 100).residue(new ResidueChance(residueLookup.getOrThrow(ModResidueTypes.ARCANE_CRYSTAL), CHANCE_33)).unlockedBy("has_item", has(ModTags.Items.ARCANE_CRYSTAL_ORES)));
        this.add(this.clibanoRecipe(ModItems.ARCANE_CRYSTAL_DUST.get(), Ingredient.of(ModItems.ARCANE_CRYSTAL.get()), 0.4F, 80).residue(new ResidueChance(residueLookup.getOrThrow(ModResidueTypes.ARCANE_CRYSTAL), CHANCE_10)).unlockedBy("has_item", has(ModItems.ARCANE_CRYSTAL.get())));
        this.add(this.clibanoRecipe(ModItems.RUNE.get(), Ingredient.of(ModTags.Items.RUNIC_STONES), 0.5F, 100).residue(new ResidueChance(residueLookup.getOrThrow(ModResidueTypes.RUNE), CHANCE_10)).unlockedBy("has_item", has(ModTags.Items.RUNIC_STONES)));

        this.add(this.clibanoRecipe(Items.COAL, Ingredient.of(ItemTags.COAL_ORES), 0.05F, 100).residue(new ResidueChance(residueLookup.getOrThrow(ModResidueTypes.COAL), CHANCE_33)).unlockedBy("has_item", has(ItemTags.COAL_ORES)));
        this.add(this.clibanoRecipe(Items.IRON_INGOT, Ingredient.of(ItemTags.IRON_ORES), 0.35F, 100).residue(new ResidueChance(residueLookup.getOrThrow(ModResidueTypes.IRON), CHANCE_33)).unlockedBy("has_item", has(ItemTags.IRON_ORES)));
        this.add(this.clibanoRecipe(Items.GOLD_INGOT, Ingredient.of(ItemTags.GOLD_ORES), 0.5F, 100).residue(new ResidueChance(residueLookup.getOrThrow(ModResidueTypes.GOLD), CHANCE_20)).unlockedBy("has_item", has(ItemTags.GOLD_ORES)));
        this.add(this.clibanoRecipe(Items.COPPER_INGOT, Ingredient.of(ItemTags.COPPER_ORES), 0.35F, 100).residue(new ResidueChance(residueLookup.getOrThrow(ModResidueTypes.COPPER), CHANCE_33)).unlockedBy("has_item", has(ItemTags.COPPER_ORES)));
        this.add(this.clibanoRecipe(Items.LAPIS_LAZULI, Ingredient.of(ItemTags.LAPIS_ORES), 0.1F, 100).residue(new ResidueChance(residueLookup.getOrThrow(ModResidueTypes.LAPIS_LAZULI), CHANCE_20)).unlockedBy("has_item", has(ItemTags.LAPIS_ORES)));
        this.add(this.clibanoRecipe(Items.DIAMOND, Ingredient.of(ItemTags.DIAMOND_ORES), 0.5F, 100).residue(new ResidueChance(residueLookup.getOrThrow(ModResidueTypes.DIAMOND), CHANCE_10)).unlockedBy("has_item", has(ItemTags.DIAMOND_ORES)));
        this.add(this.clibanoRecipe(Items.EMERALD, Ingredient.of(ItemTags.EMERALD_ORES), 0.5F, 100).residue(new ResidueChance(residueLookup.getOrThrow(ModResidueTypes.EMERALD), CHANCE_10)).unlockedBy("has_item", has(ItemTags.EMERALD_ORES)));
        this.add(this.clibanoRecipe(Items.NETHERITE_SCRAP, Ingredient.of(Blocks.ANCIENT_DEBRIS), 1.0F, 100).residue(new ResidueChance(residueLookup.getOrThrow(ModResidueTypes.NETHERITE), CHANCE_05)).unlockedBy("has_item", has(Blocks.ANCIENT_DEBRIS)));

        this.add(this.clibanoRecipe(Items.IRON_INGOT, Ingredient.of(Tags.Items.RAW_MATERIALS_IRON), 0.35F, 100).residue(new ResidueChance(residueLookup.getOrThrow(ModResidueTypes.IRON), CHANCE_33)).unlockedBy("has_item", has(Tags.Items.RAW_MATERIALS_IRON)), "clibano_combustion/iron_ingot_from_clibano_combusting_raw_iron");
        this.add(this.clibanoRecipe(Items.GOLD_INGOT, Ingredient.of(Tags.Items.RAW_MATERIALS_GOLD), 0.5F, 100).residue(new ResidueChance(residueLookup.getOrThrow(ModResidueTypes.GOLD), CHANCE_20)).unlockedBy("has_item", has(Tags.Items.RAW_MATERIALS_GOLD)), "clibano_combustion/gold_ingot_from_clibano_combusting_raw_gold");
        this.add(this.clibanoRecipe(Items.COPPER_INGOT, Ingredient.of(Tags.Items.RAW_MATERIALS_COPPER), 0.35F, 100).residue(new ResidueChance(residueLookup.getOrThrow(ModResidueTypes.COPPER), CHANCE_33)).unlockedBy("has_item", has(Tags.Items.RAW_MATERIALS_COPPER)), "clibano_combustion/copper_ingot_from_clibano_combusting_raw_copper");

        Holder<EnhancerDefinition> artisanRelic = enhancerLookup.getOrThrow(ModEnhancerDefinitions.ARTISAN_RELIC);

        this.add(this.clibanoRecipe(ModItems.OBSIDIANSTEEL_INGOT.get(), Ingredient.of(Tags.Items.RAW_MATERIALS_IRON), Ingredient.of(Blocks.OBSIDIAN), 0.5F, 100).residue(new ResidueChance(residueLookup.getOrThrow(ModResidueTypes.COPPER), CHANCE_33)).enhancer(artisanRelic).unlockedBy("has_raw_iron", has(Tags.Items.RAW_MATERIALS_IRON)).unlockedBy("has_obsidian", has(Blocks.OBSIDIAN)));
    }

    @Override
    public void add(RecipeBuilder builder) {
        super.add(builder, "clibano_combustion/" + BuiltInRegistries.ITEM.getKey(builder.getResult()).getPath() + "_from_clibano_combustion");
    }

    private ClibanoRecipeBuilder clibanoRecipe(ItemLike result, Ingredient ingredient, float experience, int cookingTime) {
        return new ClibanoRecipeBuilder(RecipeCategory.MISC, CookingBookCategory.MISC, result.asItem().getDefaultInstance(), Either.left(ingredient), experience, cookingTime);
    }

    private ClibanoRecipeBuilder clibanoRecipe(ItemLike result, Ingredient firstIngredient, Ingredient secondIngredient, float experience, int cookingTime) {
        return new ClibanoRecipeBuilder(RecipeCategory.MISC, CookingBookCategory.MISC, result.asItem().getDefaultInstance(), Either.right(Pair.of(firstIngredient, secondIngredient)), experience, cookingTime);
    }
}
