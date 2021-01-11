package me.jacktym.shouttimer.commands;

import java.util.ArrayList;
import java.util.List;

import me.jacktym.shouttimer.ShoutTimer;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class ShoutTimerCommand extends CommandBase {

	private ShoutTimer mod;

	public ShoutTimerCommand(ShoutTimer mod) {
		this.mod = mod;
	}

	@Override
	public String getCommandName() {

		return "shouttimer";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {

		return "";
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) throws CommandException {
		if(args.length == 0 || args.toString().equals("help")) {
			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "Incorrect Usage"));
			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.GOLD + "/shouttimer gui " + EnumChatFormatting.WHITE + "Displays ShoutTimer Gui."));
		//	Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.GOLD + "/shouttimer load " + EnumChatFormatting.WHITE + "Loads ShoutTimer config (.minecraft/config/ShoutTimer)."));
			//			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.GOLD + "/shouttimer config [setting] [value] " + EnumChatFormatting.WHITE + "Edits a config value and saves it."));
		}else if(args.length == 1) {
			if(args[0].equalsIgnoreCase("gui")) {
			this.mod.openMainGui();
		//}else if(args[0].equalsIgnoreCase("load")) {
			//ConfigHandler.config.load();
			//Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.GOLD + "Successfully loaded config!"));
		}else {
			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "Incorrect Usage"));
			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.GOLD + "/shouttimer gui " + EnumChatFormatting.WHITE + "Displays ShoutTimer Gui."));
		//	Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.GOLD + "/shouttimer load " + EnumChatFormatting.WHITE + "Loads ShoutTimer config (.minecraft/config/ShoutTimer)."));
		}
		}//else if(args.toString().equals("config")) {
			//Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "Incorrect Usage: /shouttimer config [setting] [value]"));
		//}
	}

	@Override
	public int getRequiredPermissionLevel() {
		return 0;
	}
	
	@Override
	public List<String> getCommandAliases(){
		List l = new ArrayList<String>();
		l.add("st");
		l.add("ShoutTimer");
		return l;
	}

}
