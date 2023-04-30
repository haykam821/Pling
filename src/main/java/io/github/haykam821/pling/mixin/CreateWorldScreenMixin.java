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
	@Inject(method = "create(Lnet/minecraft/client/MinecraftClient;Lnet/minecraft/client/gui/screen/Screen;)V", at = @At("TAIL"))
	private static void plingWhenWorldCreationPrepared(CallbackInfo ci) {
		if (Pling.getConfig().playWhenWorldCreationPrepared) {
			Pling.playEffects();
		}
	}

	@Inject(method = "create(Lnet/minecraft/client/MinecraftClient;Lnet/minecraft/client/gui/screen/Screen;Lnet/minecraft/world/level/LevelInfo;Lnet/minecraft/client/world/GeneratorOptionsHolder;Ljava/nio/file/Path;)Lnet/minecraft/client/gui/screen/world/CreateWorldScreen;", at = @At("TAIL"))
	private static void plingWhenWorldRead(CallbackInfoReturnable<CreateWorldScreen> ci) {
		if (Pling.getConfig().playWhenWorldCreationPrepared) {
			Pling.playEffects();
		}
	}
}
