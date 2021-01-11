package me.jacktym.shouttimer;

import java.io.File;

import me.jacktym.shouttimer.commands.ShoutCommand;
import me.jacktym.shouttimer.commands.ShoutTimerCommand;
import me.jacktym.shouttimer.config.ConfigHandler;
import me.jacktym.shouttimer.gui.ConfigGui;
import me.jacktym.shouttimer.util.ColorUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.command.ICommand;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CommandEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;



@Mod(modid = "ShoutTimer", name = "ShoutTimer", version = "1.1.2", acceptedMinecraftVersions = "1.8.9")
public class ShoutTimer extends Event {


	private Minecraft mc;
	private int tick = 0;
	private int second = 0;
	private ConfigHandler config;
	private boolean mainGuiOpened;

	public ICommand command;

	public static int textColor = 0xffffff;

	boolean running = false;
	boolean sleeping = false;
	boolean countdown = false;


	@SubscribeEvent
	public void CommandSent(CommandEvent event) {

		this.command = event.command;

	}

	@SubscribeEvent
	public void tickTimer(ClientTickEvent e){
		if(tick < 30 && running){
			tick++;
			return;
		} else if(running) {
			tick = 0;
			second++;
		}
	}


	@SubscribeEvent
	public void serverConnectionEvent(FMLNetworkEvent.ClientConnectedToServerEvent event) {
		running = false;
		command = null;

		tick = 0;
		second = 0;
	}

	@SubscribeEvent
	public void worldConnectionEvent(PlayerLoggedInEvent event) {
		running = false;
		command = null;

		tick = 0;
		second = 0;
	}

	public void openMainGui() {
		this.mainGuiOpened = true;
	}

	@SubscribeEvent
	public void onClientTick(TickEvent.ClientTickEvent event) {
		if (this.mainGuiOpened) {
			mc.getMinecraft().displayGuiScreen(new ConfigGui());
			this.mainGuiOpened = false;
			return;
		}
	}

	@EventHandler
	public void onInit(FMLInitializationEvent event) {
		ClientCommandHandler.instance.registerCommand(new ShoutCommand());
		ClientCommandHandler.instance.registerCommand(new ShoutTimerCommand(this));
		mc = Minecraft.getMinecraft();
		MinecraftForge.EVENT_BUS.register(this);

		String hex = String.format("%02x%02x%02x", ConfigHandler.getLabelRedColor(), ConfigHandler.getLabelBlueColor(), ConfigHandler.getLabelBlueColor());  
		textColor = Integer.parseInt(hex, 16);
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		File configDir = new File(event.getModConfigurationDirectory() + "/ShoutTimer");
		configDir.mkdirs();
		System.out.println(configDir.getAbsolutePath());
		ConfigHandler.init(new File(configDir.getPath(), "ShoutTimer.cfg"));
	}
	
	@SubscribeEvent
	public void onRender(RenderGameOverlayEvent.Text event) {
		FontRenderer shoutTimer = mc.fontRendererObj;
		if(ConfigHandler.isEnableLabel()) {
			if(!running) {
				shoutTimer.drawStringWithShadow("You can shout!", ConfigHandler.getLabelX(), ConfigHandler.getLabelY(), ConfigHandler.isEnableRainbow() ? ColorUtil.getRainbow(ConfigHandler.getRainbowSeconds(), ConfigHandler.getRainbowSaturation() / 10f, ConfigHandler.getRainbowBrightness() / 10f) : textColor);
			}
			if(command != null && command.getCommandName().equals("shout")) {

				running = true;

				shoutTimer.drawStringWithShadow("You can shout in " + (60 - second), ConfigHandler.getLabelX(), ConfigHandler.getLabelY(), ConfigHandler.isEnableRainbow() ? ColorUtil.getRainbow(ConfigHandler.getRainbowSeconds(), ConfigHandler.getRainbowSaturation() / 10f, ConfigHandler.getRainbowBrightness() / 10f) : textColor);

				if(second == 60) {

					running = false;
					command = null;

					second = 0;
				}

			}
		}
	}
}
