package com.stal111.forbidden_arcanus.common.integration.hephaestus_forge;

import com.stal111.forbidden_arcanus.ForbiddenArcanus;
import com.stal111.forbidden_arcanus.common.block.entity.forge.ritual.Ritual;
import com.stal111.forbidden_arcanus.common.block.entity.forge.ritual.RitualRequirements;
import com.stal111.forbidden_arcanus.common.block.entity.forge.ritual.result.UpgradeTierResult;
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
public class UpgradeTierCategory extends HephaestusForgeCategory<UpgradeTierResult> {

    private static final String NAME = "hephaestus_forge_upgrading";
    private static final ResourceLocation TEXTURE = ForbiddenArcanus.location("textures/gui/jei/hephaestus_forge/forge_upgrading.png");

    private static final IntIntPair REQUIRED_TIER_POSITION = IntIntPair.of(7, 35);
    private static final IntIntPair UPGRADED_TIER_POSITION = IntIntPair.of(123, 36);

    public UpgradeTierCategory(IGuiHelper guiHelper) {
        super(NAME, guiHelper, TEXTURE, 41, 79);
    }

    @Override
    public @NotNull RecipeType<Ritual> getRecipeType() {
        return ForbiddenArcanusJEIPlugin.HEPHAESTUS_FORGE_UPGRADING;
    }

    @Override
    protected void buildRecipe(@NotNull IRecipeLayoutBuilder builder, @NotNull RitualRequirements requirements, @NotNull UpgradeTierResult result) {
        int tier = requirements.tier().tier();

        builder.addSlot(RecipeIngredientRole.INPUT, REQUIRED_TIER_POSITION.firstInt(), REQUIRED_TIER_POSITION.secondInt())
                .addItemStack(getForgeItem(tier - 1));

        builder.addSlot(RecipeIngredientRole.OUTPUT, UPGRADED_TIER_POSITION.firstInt(), UPGRADED_TIER_POSITION.secondInt())
                .addItemStack(getForgeItem(result.resultTier() - 1));
    }

    @Override
    protected boolean displayEnhancers() {
         return false;
    }
}
