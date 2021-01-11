package me.jacktym.shouttimer.config;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import java.io.File;

public class ConfigHandler {

	public static Configuration config;

	// Settings
	private static Property labelX;
	private static Property labelY;
	private static Property labelRedColor;
	private static Property labelGreenColor;
	private static Property labelBlueColor;
	private static Property enableLabel;
	
	private static Property rainbowSeconds;
	private static Property rainbowSaturation;
	private static Property rainbowBrightness;
	private static Property enableRainbow;

	public static void init(File file) {
		config = new Configuration(file);
		config.load();
		
		String category ;
		
		category = "Label";
		config.addCustomCategoryComment(category, "Label Settings");

		labelX = config.get(category, "labelX", 0, "Sets the X value of the text label on screen");
		labelY = config.get(category, "labelY", 0, "Sets the Y value of the text label on screen");
		labelRedColor = config.get(category, "labelRedColor", 0, "Sets the red RGB value of the text label on screen");
		labelGreenColor = config.get(category, "labelGreenColor", 255, "Sets the green RGB value of the text label on screen");
		labelBlueColor = config.get(category, "labelBlueColor", 255, "Sets the blue RGB value of the text label on screen");
		enableLabel = config.get(category, "enableLabel", true, "Toggles the text label on screen");
		
		labelX.setMaxValue(7680);
		labelX.setMinValue(0);
		labelY.setMaxValue(7680);
		labelY.setMinValue(0);
		labelRedColor.setMaxValue(255);
		labelRedColor.setMinValue(0);
		labelGreenColor.setMaxValue(255);
		labelGreenColor.setMinValue(0);
		labelBlueColor.setMaxValue(255);
		labelBlueColor.setMinValue(0);
		
		category = "Rainbow";
		config.addCustomCategoryComment(category, "Rainbow Settings");
		
		enableRainbow = config.get(category, "enableRainbow", false, "Toggles rainbow text for labels");
		rainbowSeconds = config.get(category, "rainbowSeconds", 50, "How much time each rainbow cycle takes");
		rainbowSaturation = config.get(category, "rainbowSaturation", 10, "Changes saturation of rainbow colors");
		rainbowBrightness = config.get(category, "rainbowBrightness", 10, "Changes brightness of rainbow colors");
		
		rainbowSeconds.setMaxValue(100);
		rainbowSeconds.setMinValue(1);
		rainbowSaturation.setMaxValue(10);
		rainbowSaturation.setMinValue(1);
		rainbowBrightness.setMaxValue(10);
		rainbowBrightness.setMinValue(1);
	}

	public static int getLabelY() {
		return labelY.getInt();
	}

	public static void setLabelY(int value) {
		labelY.set(value);
	}

	public static int getLabelRedColor() {
		return labelRedColor.getInt();
	}

	public static void setLabelRedColor(int value) {
		labelRedColor.set(value);;
	}

	public static int getLabelGreenColor() {
		return labelGreenColor.getInt();
	}

	public static void setLabelGreenColor(int value) {
		labelGreenColor.set(value);;
	}

	public static int getLabelBlueColor() {
		return labelBlueColor.getInt();
	}

	public static void setLabelBlueColor(int value) {
		labelBlueColor.set(value);
	}

	public static boolean isEnableLabel() {
		return enableLabel.getBoolean();
	}

	public static void setEnableLabel(boolean value) {
		enableLabel.set(value);
	}

	public static void saveConfig() {
		config.save();
	}

	public static int getLabelX() {
		return labelX.getInt();
	}

	public static void setLabelX(int label) {
		labelX.set(label);
	}

	public static int getRainbowSeconds() {
		return rainbowSeconds.getInt();
	}

	public static void setRainbowSeconds(int label) {
		rainbowSeconds.set(label);
	}

	public static int getRainbowSaturation() {
		return rainbowSaturation.getInt();
	}

	public static void setRainbowSaturation(int label) {
		rainbowSaturation.set(label);
	}

	public static int getRainbowBrightness() {
		return rainbowBrightness.getInt();
	}

	public static void setRainbowBrightness(int label) {
		rainbowBrightness.set(label);
	}

	public static void setEnableRainbow(boolean value) {
		enableRainbow.set(value);
	}
	
	public static boolean isEnableRainbow() {
		return enableRainbow.getBoolean();
	}
}
