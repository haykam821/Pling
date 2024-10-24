package io.github.haykam821.pling.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import io.github.haykam821.pling.Pling;
import net.minecraft.client.gui.screen.world.CreateWorldScreen;

@Mixin(CreateWorldScreen.class)
public class CreateWorldScreenMixin {
	@Inject(method = "show(Lnet/minecraft/client/MinecraftClient;Lnet/minecraft/client/gui/screen/Screen;Ljava/util/function/Function;Lnet/minecraft/client/world/GeneratorOptionsFactory;Lnet/minecraft/registry/RegistryKey;Lnet/minecraft/client/gui/screen/world/CreateWorldCallback;)V", at = @At("TAIL"))
	private static void plingWhenWorldCreationPrepared(CallbackInfo ci) {
		if (Pling.getConfig().playWhenWorldCreationPrepared) {
			Pling.playEffects();
		}
	}

	@Inject(method = "create", at = @At("TAIL"))
	private static void plingWhenWorldRead(CallbackInfoReturnable<CreateWorldScreen> ci) {
		if (Pling.getConfig().playWhenWorldCreationPrepared) {
			Pling.playEffects();
		}
	}
}
