package io.github.haykam821.pling.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.github.haykam821.pling.config.ModConfig;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.SplashScreen;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

@Mixin(SplashScreen.class)
public class SplashScreenMixin {
	@Unique
	private static ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();

	@Inject(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screen/Screen;init(Lnet/minecraft/client/MinecraftClient;II)V"))
	public void plingWhenResourcesReloaded(CallbackInfo ci) {
		Identifier soundId = new Identifier(config.sound);
		SoundEvent soundEvent = Registry.SOUND_EVENT.get(soundId);
	
		if (soundEvent != null) {
			PositionedSoundInstance sound = PositionedSoundInstance.master(soundEvent, config.pitch);
			MinecraftClient.getInstance().getSoundManager().play(sound);
		}
	}
}