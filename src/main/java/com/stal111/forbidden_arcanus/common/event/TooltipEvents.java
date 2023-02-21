package com.stal111.forbidden_arcanus.common.event;

import com.stal111.forbidden_arcanus.common.item.enhancer.EnhancerDefinition;
import com.stal111.forbidden_arcanus.common.item.enhancer.EnhancerTarget;
import com.stal111.forbidden_arcanus.core.registry.FARegistries;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;
import java.util.Map;

/**
 * @author stal111
 * @since 2023-02-19
 */
public class TooltipEvents {

    private static final ChatFormatting DESCRIPTION_FORMAT = ChatFormatting.BLUE;

    @SubscribeEvent
    public void onItemTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        Player player = event.getEntity();

        if (player == null) {
            return;
        }

        Level level = event.getEntity().getLevel();

        Registry<EnhancerDefinition> registry = level.registryAccess().registryOrThrow(FARegistries.ENHANCER_DEFINITION);

        registry.holders().map(Holder::get).forEach(definition -> {
            if (stack.is(definition.item())) {
                List<Component> tooltip = event.getToolTip();

                tooltip.add(tooltip.size() - 1, CommonComponents.EMPTY);

                for (Map.Entry<EnhancerTarget, Component> test : definition.description().entrySet()) {
                    tooltip.add(tooltip.size() - 1, test.getKey().getTitle());
                    tooltip.add(tooltip.size() - 1, Component.literal(" ").append(test.getValue()).withStyle(DESCRIPTION_FORMAT));
                }
            }
        });
    }
}
