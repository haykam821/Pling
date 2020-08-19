package io.github.haykam821.pling.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.github.haykam821.pling.Pling;
import net.minecraft.client.MinecraftClientGame;

@Mixin(MinecraftClientGame.class)
public class MinecraftClientGameMixin {
	@Inject(method = "onStartGameSession", at = @At("HEAD"))
	private void plingWhenWorldLoaded(CallbackInfo ci) {
		if (Pling.getConfig().playWhenWorldLoaded) {
			Pling.playLoadingSound();
		}
	}
}