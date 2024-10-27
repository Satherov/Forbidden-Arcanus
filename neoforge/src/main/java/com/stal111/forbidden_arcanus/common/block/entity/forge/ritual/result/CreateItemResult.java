package com.stal111.forbidden_arcanus.common.block.entity.forge.ritual.result;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.stal111.forbidden_arcanus.core.init.ModRitualResultTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/**
 * @author stal111
 * @since 2023-02-05
 */
public record CreateItemResult(ItemStack result) implements RitualResult {

    public static final MapCodec<CreateItemResult> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            ItemStack.CODEC.fieldOf("result_item").forGetter(CreateItemResult::result)
    ).apply(instance, CreateItemResult::new));

    @Override
    public ItemStack apply(Level level, BlockPos pos, int forgeTier) {
        return this.result.copy();
    }

    @Override
    public RitualResultType<? extends RitualResult> getType() {
        return ModRitualResultTypes.CREATE_ITEM.get();
    }
}
