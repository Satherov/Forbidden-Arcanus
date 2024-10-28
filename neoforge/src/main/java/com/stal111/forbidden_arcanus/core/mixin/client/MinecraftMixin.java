package com.stal111.forbidden_arcanus.core.mixin.client;

import com.stal111.forbidden_arcanus.core.init.ModMobEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Minecraft.class)
public class MinecraftMixin {

    @Shadow @Nullable
    public LocalPlayer player;

    @Inject(method = "shouldEntityAppearGlowing", at = @At("HEAD"), cancellable = true)
    private void forbiddenArcanus_shouldEntityAppearGlowing$handleSpectralEyeAmulet(Entity entity, CallbackInfoReturnable<Boolean> callback) {
        if (this.player != null && this.player.hasEffect(ModMobEffects.SPECTRAL_VISION)) {
            callback.setReturnValue(true);
        }
    }
}
