package io.github.haykam821.pling.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.github.haykam821.pling.Pling;
import net.minecraft.client.network.ClientPlayNetworkHandler;

@Mixin(ClientPlayNetworkHandler.class)
public class ClientPlayNetworkHandlerMixin {
	@Inject(method = "onGameJoin", at = @At("TAIL"))
	private void plingWhenWorldLoaded(CallbackInfo ci) {
		if (Pling.getConfig().playWhenWorldLoaded) {
			Pling.playEffects();
		}
	}
}