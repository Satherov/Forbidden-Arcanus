package com.stal111.forbidden_arcanus.common.entity.lostsoul;

import com.stal111.forbidden_arcanus.core.init.ModEntities;
import com.stal111.forbidden_arcanus.core.init.ModItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class CorruptLostSoul extends AbstractLostSoul {

    public CorruptLostSoul(EntityType<? extends AbstractLostSoul> entityType, Level level) {
        super(entityType, level, Vec3.fromRGB24(68 << 16 | 83 << 8 | 149).toVector3f());
    }

    @Override
    protected InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack stack = player.getMainHandItem();

        if (stack.is(ModItems.AUREAL_BOTTLE)) {
            this.convertTo(ModEntities.LOST_SOUL.get(), true);

            return InteractionResult.sidedSuccess(this.level().isClientSide());
        }

        return super.mobInteract(player, hand);
    }
}
