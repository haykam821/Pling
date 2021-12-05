package io.github.haykam821.pling.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.github.haykam821.pling.Pling;
import net.minecraft.client.gui.screen.world.OptimizeWorldScreen;

@Mixin(OptimizeWorldScreen.class)
public class OptimizeWorldScreenMixin {
	@Inject(method = "tick", at = @At(value = "INVOKE", target = "Lit/unimi/dsi/fastutil/booleans/BooleanConsumer;accept(Z)V", remap = false))
	private void plingWhenWorldOptimized(CallbackInfo ci) {
		if (Pling.getConfig().playWhenWorldOptimized) {
			Pling.playEffects();
		}
	}
}
