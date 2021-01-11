package me.jacktym.shouttimer.commands;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

public class ShoutCommand extends CommandBase {

	@Override
    public String getCommandName() {
        return "shout";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
    	Minecraft.getMinecraft().thePlayer.sendChatMessage("/shout " + String.join(" ", args));
    	}
    
    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

}
