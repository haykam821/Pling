package io.github.haykam821.pling.config;

import io.github.prospector.modmenu.api.ConfigScreenFactory;
import io.github.prospector.modmenu.api.ModMenuApi;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;

@Environment(EnvType.CLIENT)
public class ModMenuCompatibility implements ModMenuApi {
	@Override
	public String getModId() {
		return "pling";
	}

	@Override
	public ConfigScreenFactory<Screen> getModConfigScreenFactory() {
		return screen -> AutoConfig.getConfigScreen(ModConfig.class, screen).get();
	}
}
