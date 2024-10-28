package com.stal111.forbidden_arcanus.common.item.enhancer;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.stal111.forbidden_arcanus.common.item.enhancer.effect.ConditionalEnhancerEffect;
import com.stal111.forbidden_arcanus.common.item.enhancer.effect.EnhancerEffect;
import com.stal111.forbidden_arcanus.core.registry.FARegistries;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistryCodecs;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.RegistryFileCodec;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author stal111
 * @since 2023-02-19
 */
public record EnhancerDefinition(Map<EnhancerTarget, Component> description, Holder<Item> displayItem, List<ConditionalEnhancerEffect<? extends EnhancerEffect>> effects) {

    public static final Codec<EnhancerDefinition> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.simpleMap(EnhancerTarget.CODEC, ComponentSerialization.CODEC, StringRepresentable.keys(EnhancerTarget.values())).fieldOf("description").forGetter(EnhancerDefinition::description),
            ItemStack.ITEM_NON_AIR_CODEC.fieldOf("display_item").forGetter(EnhancerDefinition::displayItem),
            EnhancerEffect.DIRECT_CODEC.listOf().fieldOf("effects").forGetter(EnhancerDefinition::effects)
    ).apply(instance, EnhancerDefinition::new));

    public static final Codec<Holder<EnhancerDefinition>> REFERENCE_CODEC = RegistryFileCodec.create(FARegistries.ENHANCER_DEFINITION, CODEC);
    public static final Codec<HolderSet<EnhancerDefinition>> LIST_CODEC = RegistryCodecs.homogeneousList(FARegistries.ENHANCER_DEFINITION, CODEC);

    public static final Codec<EnhancerDefinition> NETWORK_CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.simpleMap(EnhancerTarget.CODEC, ComponentSerialization.CODEC, StringRepresentable.keys(EnhancerTarget.values())).fieldOf("description").forGetter(EnhancerDefinition::description),
            ItemStack.ITEM_NON_AIR_CODEC.fieldOf("display_item").forGetter(EnhancerDefinition::displayItem)
    ).apply(instance, (description, item) -> {
        return new EnhancerDefinition(description, item, ImmutableList.of());
    }));

    public static final StreamCodec<RegistryFriendlyByteBuf, Holder<EnhancerDefinition>> STREAM_CODEC = ByteBufCodecs.holderRegistry(FARegistries.ENHANCER_DEFINITION);

    @SafeVarargs
    public static EnhancerDefinition create(Map<EnhancerTarget, Component> description, Item item, ConditionalEnhancerEffect<EnhancerEffect>... effects) {
        return new EnhancerDefinition(description, BuiltInRegistries.ITEM.wrapAsHolder(item), List.of(effects));
    }

    public Stream<? extends EnhancerEffect> getEffects(EnhancerTarget target) {
        return this.effects.stream().map(ConditionalEnhancerEffect::effect).filter(effect -> effect.getType().target() == target);
    }
}
