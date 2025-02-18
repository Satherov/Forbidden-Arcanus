package com.stal111.forbidden_arcanus.common.block.pedestal.effect;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;

import java.util.List;

/**
 * @author stal111
 * @since 02.04.2024
 */
public abstract class PedestalEffect {

    private final List<PedestalEffectTrigger> triggers;

    protected PedestalEffect(PedestalEffectTrigger... triggers) {
        this.triggers = List.of(triggers);
    }

    public abstract void execute(ServerLevel level, BlockPos pos, ItemStack stack);

    public boolean shouldExecute(PedestalEffectTrigger trigger) {
        return triggers.contains(trigger);
    }
}
