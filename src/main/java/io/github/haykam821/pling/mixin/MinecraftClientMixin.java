package io.github.haykam821.pling.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.SplashScreen;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.sound.SoundEvents;

@Mixin(SplashScreen.class)
public class MinecraftClientMixin {
	@Redirect(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screen/Screen;init(Lnet/minecraft/client/MinecraftClient;II)V"))
	public void plingOnResourceReloadDone(Screen screen, MinecraftClient client, int width, int height) {
		PositionedSoundInstance sound = PositionedSoundInstance.master(SoundEvents.BLOCK_NOTE_BLOCK_PLING, 1.0F);
		MinecraftClient.getInstance().getSoundManager().play(sound);

		screen.init(client, width, height);
	}
}