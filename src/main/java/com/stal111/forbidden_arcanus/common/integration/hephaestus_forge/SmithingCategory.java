package com.stal111.forbidden_arcanus.common.integration.hephaestus_forge;

import com.stal111.forbidden_arcanus.ForbiddenArcanus;
import com.stal111.forbidden_arcanus.common.block.HephaestusForgeBlock;
import com.stal111.forbidden_arcanus.common.block.entity.forge.ritual.Ritual;
import com.stal111.forbidden_arcanus.common.block.entity.forge.ritual.result.CreateItemResult;
import com.stal111.forbidden_arcanus.common.integration.ForbiddenArcanusJEIPlugin;
import com.stal111.forbidden_arcanus.core.init.ModBlocks;
import it.unimi.dsi.fastutil.ints.IntIntPair;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * @author stal111
 * @since 2023-06-05
 */
public class SmithingCategory extends HephaestusForgeCategory {

    private static final String NAME = "hephaestus_smithing";
    private static final ResourceLocation TEXTURE = new ResourceLocation(ForbiddenArcanus.MOD_ID, "textures/gui/jei/hephaestus_forge/smithing.png");

    private static final IntIntPair FORGE_TIER_POSITION = IntIntPair.of(122, 85);
    private static final IntIntPair OUTPUT_POSITION = IntIntPair.of(122, 35);

    public SmithingCategory(IGuiHelper guiHelper) {
        super(NAME, guiHelper, TEXTURE, 41, 83);
    }

    @Override
    public @NotNull RecipeType<Ritual> getRecipeType() {
        return ForbiddenArcanusJEIPlugin.HEPHAESTUS_SMITHING;
    }

    @Override
    protected void buildRecipe(@NotNull IRecipeLayoutBuilder builder, @NotNull Ritual ritual) {
        int requiredTier = ritual.requirements() == null ? 1 : ritual.requirements().tier();

        if (ritual.result() instanceof CreateItemResult result) {
            builder.addSlot(RecipeIngredientRole.OUTPUT, OUTPUT_POSITION.firstInt(), OUTPUT_POSITION.secondInt())
                    .addItemStack(result.getResult());
        }

        builder.addSlot(RecipeIngredientRole.RENDER_ONLY, FORGE_TIER_POSITION.firstInt(), FORGE_TIER_POSITION.secondInt())
                .addItemStack(HephaestusForgeBlock.setTierOnStack(new ItemStack(ModBlocks.HEPHAESTUS_FORGE.get()), requiredTier))
                .addTooltipCallback((recipeSlotView, tooltip) -> {
                    tooltip.clear();
                    tooltip.add(Component.translatable("jei.forbidden_arcanus.hephaestusSmithing.required_tier").append(": " + requiredTier));
                });
    }
}
