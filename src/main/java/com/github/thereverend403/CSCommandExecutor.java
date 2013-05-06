package com.github.thereverend403;


import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CSCommandExecutor implements CommandExecutor
{

    private ChatSounds plugin;

    public CSCommandExecutor(ChatSounds plugin)
    {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (cmd.getName().equalsIgnoreCase("ChatSounds"))
        {
            if (args.length < 1)
            {
                sender.sendMessage(ChatColor.RED + "Not enough arguments!");
                return true;
            }
            if (args.length > 1)
            {
                sender.sendMessage(ChatColor.RED + "Too many arguments!");
                return true;
            }
            if (args[0].equalsIgnoreCase("reload") && sender.hasPermission("ChatSounds.reload"))
            {
                plugin.reloadConfig();
                sender.sendMessage(ChatColor.GREEN + "Config reloaded!");
                return true;
            } else
            {
                sender.sendMessage(ChatColor.RED + "You do not have permission to do that!");
                return true;
            }
        }
        return false;
    }
}
