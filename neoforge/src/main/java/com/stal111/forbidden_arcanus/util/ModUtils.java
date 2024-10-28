package com.stal111.forbidden_arcanus.util;

import com.google.common.collect.Maps;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ModUtils {

    public static void addStrippable(Block block, Block strippedBlock) {
        AxeItem.STRIPPABLES = Maps.newHashMap(AxeItem.STRIPPABLES);
        AxeItem.STRIPPABLES.put(block, strippedBlock);
    }

    //    public static Collection<Recipe<?>> getRecipesByOutput(ItemStack targetOutput, Collection<RecipeSerializer<?>> recipeSerializer) {
//        return Minecraft.getInstance().level.getRecipeManager().getRecipes().stream()
//                .filter(r -> {
//                    boolean flag = false;
//                    for (RecipeSerializer<?> serializer : recipeSerializer) {
//                        if (serializer == r.getSerializer()) {
//                            flag = true;
//                        }
//                    }
//                    return !r.isSpecial() && flag && ItemStack.isSameIgnoreDurability(targetOutput, r.getResultItem());
//                }).collect(Collectors.toList());
//    }

//    public static Collection<Recipe<?>> getCraftingRecipesByOutput(@Nonnull ItemStack targetOutput) {
//        return Minecraft.getInstance().level.getRecipeManager().getRecipes().stream()
//                .filter(r -> !r.isSpecial() && (r.getSerializer() == RecipeSerializer.SHAPED_RECIPE || r.getSerializer() == RecipeSerializer.SHAPELESS_RECIPE) && ItemStack.isSameIgnoreDurability(targetOutput, r.getResultItem())).collect(Collectors.toList());
//    }
//
//    public static Collection<Recipe<?>> getSmeltingRecipesByOutput(@Nonnull ItemStack targetOutput) {
//        return Minecraft.getInstance().level.getRecipeManager().getRecipes().stream()
//                .filter(r -> !r.isSpecial() && r.getSerializer() == RecipeSerializer.SMELTING_RECIPE && ItemStack.isSameIgnoreDurability(targetOutput, r.getResultItem())).collect(Collectors.toList());
//    }

    public static boolean hasBlockEnoughSolidSite(VoxelShape shape, LevelReader world, BlockPos pos, Direction direction) {
        BlockState state = world.getBlockState(pos);
        if (direction == Direction.DOWN && state.is(BlockTags.UNSTABLE_BOTTOM_CENTER)) {
            return false;
        } else {
            return !Shapes.joinIsNotEmpty(state.getBlockSupportShape(world, pos).getFaceShape(direction), shape, BooleanOp.ONLY_SECOND);
        }
    }

    public static Vec3 blockPosToVector(BlockPos pos) {
        return blockPosToVector(pos, 0);
    }

    public static Vec3 blockPosToVector(BlockPos pos, double offset) {
        return new Vec3(pos.getX() + offset, pos.getY() + offset, pos.getZ() + offset);
    }
}
