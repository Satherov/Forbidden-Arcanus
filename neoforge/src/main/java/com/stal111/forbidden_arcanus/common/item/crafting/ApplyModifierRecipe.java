package com.stal111.forbidden_arcanus.common.item.crafting;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.stal111.forbidden_arcanus.common.item.modifier.ItemModifier;
import com.stal111.forbidden_arcanus.common.item.modifier.ModifierHelper;
import com.stal111.forbidden_arcanus.core.init.ModRecipeSerializers;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SmithingRecipe;
import net.minecraft.world.item.crafting.SmithingRecipeInput;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

public record ApplyModifierRecipe(Ingredient template,
                                  Ingredient addition,
                                  Holder<ItemModifier> modifier) implements SmithingRecipe {

    @Override
    public boolean matches(@NotNull SmithingRecipeInput recipeInput, @NotNull Level level) {
        return this.isTemplateIngredient(recipeInput.template()) && this.isAdditionIngredient(recipeInput.addition()) && this.isBaseIngredient(recipeInput.base());
    }

    @NotNull
    @Override
    public ItemStack assemble(@NotNull SmithingRecipeInput recipeInput, @NotNull HolderLookup.Provider provider) {
        ItemStack stack = recipeInput.base().copyWithCount(1);

        ModifierHelper.setModifier(stack, this.modifier);

        return stack;
    }

    @NotNull
    @Override
    public ItemStack getResultItem(@NotNull HolderLookup.Provider provider) {
        return ItemStack.EMPTY;
    }

    @NotNull
    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipeSerializers.APPLY_MODIFIER.get();
    }


    @Override
    public boolean isTemplateIngredient(@NotNull ItemStack stack) {
        return this.template.test(stack);
    }

    @Override
    public boolean isBaseIngredient(@NotNull ItemStack stack) {
        return this.modifier.value().isValidItem(stack);
    }

    @Override
    public boolean isAdditionIngredient(@NotNull ItemStack stack) {
        return this.addition.test(stack);
    }

    @Override
    public boolean isIncomplete() {
        return Stream.of(this.template, this.addition).anyMatch(Ingredient::hasNoItems);
    }

    public static class Serializer implements RecipeSerializer<ApplyModifierRecipe> {

        private static final MapCodec<ApplyModifierRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                Ingredient.CODEC_NONEMPTY.fieldOf("template").forGetter(ApplyModifierRecipe::template),
                Ingredient.CODEC_NONEMPTY.fieldOf("addition").forGetter(ApplyModifierRecipe::addition),
                ItemModifier.CODEC.fieldOf("modifier").forGetter(ApplyModifierRecipe::modifier)
        ).apply(instance, ApplyModifierRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, ApplyModifierRecipe> STREAM_CODEC = StreamCodec.composite(
                Ingredient.CONTENTS_STREAM_CODEC,
                ApplyModifierRecipe::template,
                Ingredient.CONTENTS_STREAM_CODEC,
                ApplyModifierRecipe::addition,
                ItemModifier.STREAM_CODEC,
                ApplyModifierRecipe::modifier,
                ApplyModifierRecipe::new
        );

        @Override
        public @NotNull MapCodec<ApplyModifierRecipe> codec() {
            return CODEC;
        }

        @Override
        public @NotNull StreamCodec<RegistryFriendlyByteBuf, ApplyModifierRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
