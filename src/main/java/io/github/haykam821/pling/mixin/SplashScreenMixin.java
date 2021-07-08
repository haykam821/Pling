package io.github.haykam821.pling.mixin;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.github.haykam821.pling.Pling;
import net.minecraft.client.gui.screen.SplashScreen;

@Mixin(SplashScreen.class)
public class SplashScreenMixin {
	@Shadow
	@Final
	private boolean reloading;

	@Inject(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screen/Screen;init(Lnet/minecraft/client/MinecraftClient;II)V"))
	public void plingWhenResourcesReloaded(CallbackInfo ci) {
		if (!this.reloading || Pling.getConfig().playWhenResourcesReloaded) {
			Pling.playEffects();
		}
	}
}