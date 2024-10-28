package com.stal111.forbidden_arcanus.common.item;

import com.stal111.forbidden_arcanus.common.item.component.ToggleableState;
import com.stal111.forbidden_arcanus.core.init.ModDataComponents;
import com.stal111.forbidden_arcanus.core.init.ModMobEffects;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class SpectralEyeAmuletItem extends Item {

	public SpectralEyeAmuletItem(Item.Properties properties) {
		super(properties);
	}
	
	@Override
	public void inventoryTick(ItemStack stack, Level level, Entity entity, int itemSlot, boolean isSelected) {
		if (isActive(stack) && entity instanceof LivingEntity livingEntity) {
			livingEntity.addEffect(new MobEffectInstance(BuiltInRegistries.MOB_EFFECT.wrapAsHolder(ModMobEffects.SPECTRAL_VISION.get()), 80, 0, false, false, true));
		}
		super.inventoryTick(stack, level, entity, itemSlot, isSelected);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		ItemStack stack = player.getItemInHand(hand);

		stack.update(ModDataComponents.TOGGLEABLE_STATE, ToggleableState.DEFAULT, ToggleableState::toggle);

		return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
		stack.addToTooltip(ModDataComponents.TOGGLEABLE_STATE, context, tooltipComponents::add, tooltipFlag);
	}

	public static boolean isActive(ItemStack stack) {
		return stack.getOrDefault(ModDataComponents.TOGGLEABLE_STATE, ToggleableState.DEFAULT).active();
	}
}