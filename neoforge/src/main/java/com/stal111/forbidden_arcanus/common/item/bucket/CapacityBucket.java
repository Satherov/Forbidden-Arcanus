package com.stal111.forbidden_arcanus.common.item.bucket;

import com.stal111.forbidden_arcanus.core.init.ModDataComponents;
import net.minecraft.util.Mth;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.Nullable;

/**
 * @author stal111
 * @since 15.12.2023
 */
public interface CapacityBucket {

    int getCapacity();
    BucketFamily getFamily();

    default Item getEmptyBucket() {
        return this.getFamily().fluidBuckets().get(Fluids.EMPTY).get();
    }

    @Nullable
    default Item getFilledBucket(Fluid fluid) {
        if (!this.getFamily().fluidBuckets().containsKey(fluid)) {
            return null;
        }
        return this.getFamily().fluidBuckets().get(fluid).get();
    }

    default Item getMilkBucket() {
        return this.getFamily().milkBucket().get();
    }

    default int getFullness(ItemStack stack) {
       return Math.max(1, stack.getOrDefault(ModDataComponents.STORED_FLUID_AMOUNT, 1));
    }

    default ItemStack setFullness(ItemStack stack, int fullness) {
        if (fullness <= 0) {
            return this.getEmptyBucket().getDefaultInstance();
        }

        stack.set(ModDataComponents.STORED_FLUID_AMOUNT, Mth.clamp(fullness, 1, this.getCapacity()));

        return stack;
    }

    default boolean isFull(ItemStack stack) {
        if (this.getCapacity() == 0) {
            return false;
        }
        return this.getFullness(stack) >= this.getCapacity();
    }
}
