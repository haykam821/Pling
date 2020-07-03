package io.github.haykam821.pling.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.github.haykam821.pling.Pling;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.SplashScreen;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.sound.SoundEvent;

@Mixin(SplashScreen.class)
public class SplashScreenMixin {
	@Inject(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screen/Screen;init(Lnet/minecraft/client/MinecraftClient;II)V"))
	public void plingWhenResourcesReloaded(CallbackInfo ci) {
		SoundEvent soundEvent = Pling.getLoadingSound();
		if (soundEvent != null) {
			PositionedSoundInstance sound = PositionedSoundInstance.master(soundEvent, Pling.getConfig().pitch);
			MinecraftClient.getInstance().getSoundManager().play(sound);
		}
	}
}