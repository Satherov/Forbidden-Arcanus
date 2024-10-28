package com.stal111.forbidden_arcanus.core.init;

import com.mojang.serialization.MapCodec;
import com.stal111.forbidden_arcanus.ForbiddenArcanus;
import com.stal111.forbidden_arcanus.client.particle.EssenceDropParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.valhelsia.valhelsia_core.api.common.registry.RegistryClass;
import net.valhelsia.valhelsia_core.api.common.registry.RegistryEntry;
import net.valhelsia.valhelsia_core.api.common.registry.helper.MappedRegistryHelper;
import org.jetbrains.annotations.NotNull;

public class ModParticles implements RegistryClass {

    public static final MappedRegistryHelper<ParticleType<?>> HELPER = ForbiddenArcanus.REGISTRY_MANAGER.getHelper(Registries.PARTICLE_TYPE);

    public static final RegistryEntry<ParticleType<?>, SimpleParticleType> SOUL = HELPER.register("soul", () -> new SimpleParticleType(false));
    public static final RegistryEntry<ParticleType<?>, SimpleParticleType> AUREAL_MOTE = HELPER.register("aureal_mote", () -> new SimpleParticleType(false));
    public static final RegistryEntry<ParticleType<?>, SimpleParticleType> MAGIC_EXPLOSION = HELPER.register("magic_explosion", () -> new SimpleParticleType(true));
    public static final RegistryEntry<ParticleType<?>, SimpleParticleType> HUGE_MAGIC_EXPLOSION = HELPER.register("magic_explosion_emitter", () -> new SimpleParticleType(true));
    public static final RegistryEntry<ParticleType<?>, SimpleParticleType> MAGNETIC_GLOW = HELPER.register("magnetic_glow", () -> new SimpleParticleType(true));
    public static final RegistryEntry<ParticleType<?>, ParticleType<EssenceDropParticleOption>> AUREAL_DROP = register("aureal_drop", true, EssenceDropParticleOption.CODEC, EssenceDropParticleOption.STREAM_CODEC);
    public static final RegistryEntry<ParticleType<?>, ParticleType<EssenceDropParticleOption>> SOULS_DROP = register("souls_drop", true, EssenceDropParticleOption.CODEC, EssenceDropParticleOption.STREAM_CODEC);
    public static final RegistryEntry<ParticleType<?>, ParticleType<EssenceDropParticleOption>> BLOOD_DROP = register("blood_drop", true, EssenceDropParticleOption.CODEC, EssenceDropParticleOption.STREAM_CODEC);
    public static final RegistryEntry<ParticleType<?>, ParticleType<EssenceDropParticleOption>> EXPERIENCE_DROP = register("experience_drop", true, EssenceDropParticleOption.CODEC, EssenceDropParticleOption.STREAM_CODEC);

    private static <T extends ParticleOptions> RegistryEntry<ParticleType<?>, ParticleType<T>> register(String name, boolean overrideLimiter, MapCodec<T> codec, StreamCodec<? super RegistryFriendlyByteBuf, T> streamCodec) {
        return HELPER.register(name, () -> new ParticleType<>(overrideLimiter) {
            public @NotNull MapCodec<T> codec() {
                return codec;
            }

            public @NotNull StreamCodec<? super RegistryFriendlyByteBuf, T> streamCodec() {
                return streamCodec;
            }
        });
    }
}
