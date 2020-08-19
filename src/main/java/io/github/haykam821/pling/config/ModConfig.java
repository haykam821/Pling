package io.github.haykam821.pling.config;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry;
import net.minecraft.sound.SoundEvents;

@Config(name = "pling")
@Config.Gui.Background("minecraft:textures/block/note_block.png")
public class ModConfig implements ConfigData {
	@ConfigEntry.Gui.Tooltip
	public String sound = SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP.getId().toString();

	@ConfigEntry.Gui.Tooltip
	public float pitch = 1.0F;

	@ConfigEntry.Gui.Tooltip(count = 2)
	public boolean playWhenWorldLoaded = false;
}
