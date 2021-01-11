package me.jacktym.shouttimer.gui;

import java.io.File;
import java.io.IOException;

import me.jacktym.shouttimer.ShoutTimer;
import me.jacktym.shouttimer.config.ConfigHandler;
import me.jacktym.shouttimer.util.ColorUtil;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigGui extends GuiScreen {
	
	int tempLabelX = 0;
	int tempLabelY = 0;
	int tempLabelRedColor = 0;
	int tempLabelGreenColor = 0;
	int tempLabelBlueColor = 0;
	
	int tempRainbowSeconds = 0;
	int tempRainbowSaturation = 0;
	int tempRainbowBrightness = 0;

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		drawDefaultBackground();
		
		drawString(mc.fontRendererObj, "Label Config Settings", width / 2 - 320 / 2, 10, 0xffffff);
		
		drawString(mc.fontRendererObj, "X Label Value:", width / 2 - 350 / 2, 30, 0xffffff);
		drawString(mc.fontRendererObj, "Y Label Value:", width / 2 - 350 / 2, 50, 0xffffff);
		drawString(mc.fontRendererObj, "Red RBG Value:", width / 2 - 350 / 2, 70, 0xffffff);
		drawString(mc.fontRendererObj, "Green RBG Value:", width / 2 - 350 / 2, 90, 0xffffff);
		drawString(mc.fontRendererObj, "Blue RBG Value:", width / 2 - 350 / 2, 110, 0xffffff);
		drawString(mc.fontRendererObj, "Enabled:", width / 2 - 350 / 2, 130, 0xffffff);
		
		drawString(mc.fontRendererObj, Integer.toString(ConfigHandler.getLabelX() + tempLabelX), width / 2 - 155 / 2, 29, 0xffffff);
		drawString(mc.fontRendererObj, Integer.toString(ConfigHandler.getLabelY() + tempLabelY), width / 2 - 155 / 2, 49, 0xffffff);
		drawString(mc.fontRendererObj, Integer.toString(ConfigHandler.getLabelRedColor() + tempLabelRedColor), width / 2 - 149 / 2, 69, 0xffffff);
		drawString(mc.fontRendererObj, Integer.toString(ConfigHandler.getLabelGreenColor() + tempLabelGreenColor), width / 2 - 149 / 2, 89, 0xffffff);
		drawString(mc.fontRendererObj, Integer.toString(ConfigHandler.getLabelBlueColor() + tempLabelBlueColor), width / 2 - 149 / 2, 109, 0xffffff);
		
		drawString(mc.fontRendererObj, "Rainbow Config Settings", width / 2 - 50 / 2, 10, ColorUtil.getRainbow(ConfigHandler.getRainbowSeconds(), ConfigHandler.getRainbowSaturation() / 10f, ConfigHandler.getRainbowBrightness() / 10f));
		
		drawString(mc.fontRendererObj, "Seconds:", width / 2 - 50 / 2, 30, 0xffffff);
		drawString(mc.fontRendererObj, "Saturation:", width / 2 - 50 / 2, 50, 0xffffff);
		drawString(mc.fontRendererObj, "Brightness:", width / 2 - 50 / 2, 70, 0xffffff);
		drawString(mc.fontRendererObj, "Enabled:", width / 2 - 50 / 2, 90, 0xffffff);
		
		drawString(mc.fontRendererObj, Integer.toString(ConfigHandler.getRainbowSeconds() + tempRainbowSeconds), width / 2 + 45, 29, 0xffffff);
		drawString(mc.fontRendererObj, Integer.toString(ConfigHandler.getRainbowSaturation() + tempRainbowSaturation), width / 2 + 47, 49, 0xffffff);
		drawString(mc.fontRendererObj, Integer.toString(ConfigHandler.getRainbowBrightness() + tempRainbowBrightness), width / 2 + 47, 69, 0xffffff);
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException{
		
		if(button.id == 5 && !(ConfigHandler.getLabelX() + tempLabelX < 1)) {
			tempLabelX--;
		}else if(button.id == 6 && !(ConfigHandler.getLabelX() + tempLabelX > 254)) {
			tempLabelX++;
		}else if(button.id == 7 && !(ConfigHandler.getLabelY() + tempLabelY < 1)) {
			tempLabelY--;
		}else if(button.id == 8 && !(ConfigHandler.getLabelY() + tempLabelY > 254)) {
			tempLabelY++;
		}else if(button.id == 9 && !(ConfigHandler.getLabelRedColor() + tempLabelRedColor < 1)) {
			tempLabelRedColor--;
		}else if(button.id == 10 && !(ConfigHandler.getLabelRedColor() + tempLabelRedColor > 254)) {
			tempLabelRedColor++;
		}else if(button.id == 11 && !(ConfigHandler.getLabelGreenColor() + tempLabelGreenColor < 1)) {
			tempLabelGreenColor--;
		}else if(button.id == 12 && !(ConfigHandler.getLabelGreenColor() + tempLabelGreenColor > 254)) {
			tempLabelGreenColor++;
		}else if(button.id == 13 && !(ConfigHandler.getLabelBlueColor() + tempLabelBlueColor < 1)) {
			tempLabelBlueColor--;
		}else if(button.id == 14 && !(ConfigHandler.getLabelBlueColor() + tempLabelBlueColor > 254)) {
			tempLabelBlueColor++;
		}else if(button.id == 15) {
			ConfigHandler.setEnableLabel(!ConfigHandler.isEnableLabel());
		}else if(button.id == 16) {
			tempLabelX = 0;
			tempLabelY = 0;
			tempLabelRedColor = 0;
			tempLabelGreenColor = 0;
			tempLabelBlueColor = 0;
			
			tempRainbowSeconds = 0;
			tempRainbowSaturation = 0;
			tempRainbowBrightness = 0;
			
			ConfigHandler.setLabelX(ConfigHandler.getLabelX());
			ConfigHandler.setLabelY(ConfigHandler.getLabelY());
			ConfigHandler.setLabelRedColor(ConfigHandler.getLabelRedColor());
			ConfigHandler.setLabelGreenColor(ConfigHandler.getLabelGreenColor());
			ConfigHandler.setLabelBlueColor(ConfigHandler.getLabelBlueColor());
			ConfigHandler.setEnableLabel(ConfigHandler.isEnableLabel());
			
			ConfigHandler.setRainbowSeconds(ConfigHandler.getRainbowSeconds());
			ConfigHandler.setRainbowSaturation(ConfigHandler.getRainbowSaturation());
			ConfigHandler.setRainbowBrightness(ConfigHandler.getRainbowBrightness());
			ConfigHandler.setEnableRainbow(ConfigHandler.isEnableRainbow());
		}else if(button.id == 17 && !(ConfigHandler.getRainbowSeconds() + tempRainbowSeconds < 2)) {
			tempRainbowSeconds--;
		}else if(button.id == 18 && !(ConfigHandler.getRainbowSeconds() + tempRainbowSeconds > 99)) {
			tempRainbowSeconds++;
		}else if(button.id == 19 && !(ConfigHandler.getRainbowSaturation() + tempRainbowSaturation < 1)) {
			tempRainbowSaturation--;
		}else if(button.id == 20 && !(ConfigHandler.getRainbowSaturation() + tempRainbowSaturation > 9)) {
			tempRainbowSaturation++;
		}else if(button.id == 21 && !(ConfigHandler.getRainbowBrightness() + tempRainbowBrightness < 1)) {
			tempRainbowBrightness--;
		}else if(button.id == 22 && !(ConfigHandler.getRainbowBrightness() + tempRainbowBrightness > 9)) {
			tempRainbowBrightness++;
		}else if(button.id == 23) {
			ConfigHandler.setEnableRainbow(!ConfigHandler.isEnableRainbow());
		}
		super.actionPerformed(button);
	}
	
	@Override
	public void onGuiClosed() {
		
		ConfigHandler.setLabelX(ConfigHandler.getLabelX() + tempLabelX);
		ConfigHandler.setLabelY(ConfigHandler.getLabelY() + tempLabelY);
		ConfigHandler.setLabelRedColor(ConfigHandler.getLabelRedColor() + tempLabelRedColor);
		ConfigHandler.setLabelGreenColor(ConfigHandler.getLabelGreenColor() + tempLabelGreenColor);
		ConfigHandler.setLabelBlueColor(ConfigHandler.getLabelBlueColor() + tempLabelBlueColor);
		
		ConfigHandler.setRainbowSeconds(ConfigHandler.getRainbowSeconds() + tempRainbowSeconds);
		ConfigHandler.setRainbowSaturation(ConfigHandler.getRainbowSaturation() + tempRainbowSaturation);
		ConfigHandler.setRainbowBrightness(ConfigHandler.getRainbowBrightness() + tempRainbowBrightness);
		
		ConfigHandler.saveConfig();
		
		tempLabelX = 0;
		tempLabelY = 0;
		tempLabelRedColor = 0;
		tempLabelGreenColor = 0;
		tempLabelBlueColor = 0;
		
		tempRainbowSeconds = 0;
		tempRainbowSaturation = 0;
		tempRainbowBrightness = 0;
		
		String hex = String.format("%02x%02x%02x", ConfigHandler.getLabelRedColor(), ConfigHandler.getLabelBlueColor(), ConfigHandler.getLabelBlueColor());  
		ShoutTimer.textColor = Integer.parseInt(hex, 16);
	}
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		super.mouseClicked(mouseX, mouseY, mouseButton);
	}
	
	@Override
	public void initGui() {
		buttonList.add(new GuiButton(5, width / 2 - 180 / 2, 27, 12, 12, "<"));
		buttonList.add(new GuiButton(6, width / 2 - 105 / 2, 27, 12, 12, ">"));
		buttonList.add(new GuiButton(7, width / 2 - 180 / 2, 47, 12, 12, "<"));
		buttonList.add(new GuiButton(8, width / 2 - 105 / 2, 47, 12, 12, ">"));
		buttonList.add(new GuiButton(9, width / 2 - 180 / 2, 67, 12, 12, "<"));
		buttonList.add(new GuiButton(10, width / 2 - 105 / 2, 67, 12, 12, ">"));
		buttonList.add(new GuiButton(11, width / 2 - 180 / 2, 87, 12, 12, "<"));
		buttonList.add(new GuiButton(12, width / 2 - 105 / 2, 87, 12, 12, ">"));
		buttonList.add(new GuiButton(13, width / 2 - 180 / 2, 107, 12, 12, "<"));
		buttonList.add(new GuiButton(14, width / 2 - 105 / 2, 107, 12, 12, ">"));
		
		buttonList.add(new GuiButton(15, width / 2 - 180 / 2, 127, 40, 12, Boolean.toString(ConfigHandler.isEnableLabel())));
		
		buttonList.add(new GuiButton(17, width / 2 + 31, 27, 12, 12, "<"));
		buttonList.add(new GuiButton(18, width / 2 + 64, 27, 12, 12, ">"));
		buttonList.add(new GuiButton(19, width / 2 + 31, 47, 12, 12, "<"));
		buttonList.add(new GuiButton(20, width / 2 + 64, 47, 12, 12, ">"));
		buttonList.add(new GuiButton(21, width / 2 + 31, 67, 12, 12, "<"));
		buttonList.add(new GuiButton(22, width / 2 + 64, 67, 12, 12, ">"));
		
		buttonList.add(new GuiButton(23, width / 2 + 31, 87, 40, 12, Boolean.toString((ConfigHandler.isEnableRainbow()))));
		
		buttonList.add(new GuiButton(16, width / 2 - 90, 200, 200, 20, "Reset"));
		super.initGui();
	}
	
	@Override
	public void updateScreen() {
		super.updateScreen();
	}

}
