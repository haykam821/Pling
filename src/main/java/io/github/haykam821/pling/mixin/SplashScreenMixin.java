package io.github.haykam821.pling.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import io.github.haykam821.pling.config.ModConfig;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.SplashScreen;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

@Mixin(SplashScreen.class)
public class SplashScreenMixin {
	ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();

	@Redirect(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screen/Screen;init(Lnet/minecraft/client/MinecraftClient;II)V"))
	public void plingOnResourceReloadDone(Screen screen, MinecraftClient client, int width, int height) {
		Identifier soundId = new Identifier(config.sound);
		SoundEvent soundEvent = Registry.SOUND_EVENT.get(soundId);
	
		if (soundEvent != null) {
			PositionedSoundInstance sound = PositionedSoundInstance.master(soundEvent, config.pitch);
			MinecraftClient.getInstance().getSoundManager().play(sound);
		}

		screen.init(client, width, height);
	}
}