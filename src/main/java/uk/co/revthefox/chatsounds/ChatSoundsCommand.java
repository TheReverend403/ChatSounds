package uk.co.revthefox.chatsounds;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatSoundsCommand implements CommandExecutor
{

    private final ChatSounds plugin;

    public ChatSoundsCommand(ChatSounds plugin)
    {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args)
    {
        if (args.length == 0)
        {
            sender.sendMessage(String.format("%s=== ChatSounds v%s, developed by TheReverend403 ===", (sender instanceof Player ? ChatColor.GOLD : ""), plugin.getDescription().getVersion()));
            sender.sendMessage(String.format("%s%s", (sender instanceof Player ? ChatColor.GOLD : ""), plugin.getDescription().getDescription()));
            return true;
        }

        if (args[0].equalsIgnoreCase("reload"))
        {
            if (sender instanceof Player && !((Player) sender).hasPermission("chatsounds.reload"))
            {
                sender.sendMessage(ChatColor.RED + "You do not have permission to perform this command!");
                return true;
            }

            plugin.reloadConfig();
            plugin.loadAliases();
            sender.sendMessage(String.format("%sChatSounds config successfully reloaded!", (sender instanceof Player ? ChatColor.GREEN : "")));
            return true;
        }
        else
        {
            sender.sendMessage(String.format("%sCommand not recognised!", (sender instanceof Player ? ChatColor.RED : "")));
            return true;
        }
    }
}
