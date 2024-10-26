package com.stal111.forbidden_arcanus.common.integration.hephaestus_forge;

import com.stal111.forbidden_arcanus.ForbiddenArcanus;
import com.stal111.forbidden_arcanus.common.block.entity.forge.TierPredicate;
import com.stal111.forbidden_arcanus.common.block.entity.forge.ritual.Ritual;
import com.stal111.forbidden_arcanus.common.block.entity.forge.ritual.RitualRequirements;
import com.stal111.forbidden_arcanus.common.block.entity.forge.ritual.result.CreateItemResult;
import com.stal111.forbidden_arcanus.common.integration.ForbiddenArcanusJEIPlugin;
import it.unimi.dsi.fastutil.ints.IntIntPair;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/**
 * @author stal111
 * @since 2023-06-05
 */
public class SmithingCategory extends HephaestusForgeCategory<CreateItemResult> {

    private static final String NAME = "hephaestus_smithing";
    private static final ResourceLocation TEXTURE = ForbiddenArcanus.location("textures/gui/jei/hephaestus_forge/smithing.png");

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
    protected void buildRecipe(@NotNull IRecipeLayoutBuilder builder, @NotNull RitualRequirements requirements, @NotNull CreateItemResult result) {
        TierPredicate tierPredicate = requirements.tier();

        builder.addSlot(RecipeIngredientRole.OUTPUT, OUTPUT_POSITION.firstInt(), OUTPUT_POSITION.secondInt())
                .addItemStack(result.getResult());

        builder.addSlot(RecipeIngredientRole.RENDER_ONLY, FORGE_TIER_POSITION.firstInt(), FORGE_TIER_POSITION.secondInt())
                .addItemStack(getForgeItem(tierPredicate.tier() - 1))
                .addRichTooltipCallback((recipeSlotView, tooltip) -> tooltip.add(tierPredicate.getDescription()));
    }
}
