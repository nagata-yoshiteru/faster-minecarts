package com.philipzhan.fasterminecarts.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import net.minecraft.text.TranslatableText;

@Config(name = "fasterminecarts")
public class FasterMinecartsConfig implements ConfigData {

	@ConfigEntry.Gui.Tooltip()
	@ConfigEntry.Category("general")
	public boolean enableMod = true;

	@ConfigEntry.Gui.Tooltip()
	@ConfigEntry.Category("general")
    public boolean automaticMinecartSlowDown = true;

	@ConfigEntry.Gui.Tooltip()
	@ConfigEntry.Category("general")
	public boolean manualMinecartSlowDown = true;

	@ConfigEntry.Gui.Tooltip()
	@ConfigEntry.Category("general")
	public boolean storageMinecartSlowDown = true;
	
	@ConfigEntry.Gui.Tooltip(count = 2)
	@ConfigEntry.BoundedDiscrete(min = 8, max = 30)
	@ConfigEntry.Category("general")
    public int maxSpeed = 24;

	@ConfigEntry.Gui.Tooltip(count = 2)
	@ConfigEntry.Category("customControl")
	public int customSpeedOne = 15;

	@ConfigEntry.Gui.Tooltip(count = 2)
	@ConfigEntry.Category("customControl")
	public int customSpeedTwo = 20;

	@Override
	public void validatePostLoad() throws ValidationException {
		if (customSpeedOne <= 0) {
			throw new ValidationException(String.valueOf(new TranslatableText("Speed value must be an integer above 8.")));
		}
		if (customSpeedTwo <= 0) {
			throw new ValidationException(String.valueOf(new TranslatableText("Speed value must be an integer above 8.")));
		}
	}
}
