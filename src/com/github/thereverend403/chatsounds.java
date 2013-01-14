package com.github.thereverend403;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class chatsounds extends JavaPlugin {
    public final ChatSoundsPlayerListener pl = new ChatSoundsPlayerListener(this);
	@Override
	public void onEnable(){
		FileConfiguration config = this.getConfig();
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new ChatSoundsPlayerListener(this), this);
		config = getConfig();
		config.addDefault("chatsounds.global", true);
        config.addDefault("chatsounds.aliases.cat", "meow");
        config.addDefault("chatsounds.aliases.catpurr", "purr");
        config.addDefault("chatsounds.aliases.dog", "woof");
        config.addDefault("chatsounds.aliases.doggrowl", "grrr");
        config.addDefault("chatsounds.aliases.pig", "oink");
        config.addDefault("chatsounds.aliases.chicken", "cluck");
        config.addDefault("chatsounds.aliases.cow", "moo");
        config.addDefault("chatsounds.aliases.sheep", "baaa");
        config.addDefault("chatsounds.aliases.creeper", "hiss");
        config.addDefault("chatsounds.aliases.enderman", "slender");
        config.addDefault("chatsounds.aliases.explosion", "boom");
        config.addDefault("chatsounds.aliases.dragondeath", "dragondeath");
		config.options().copyDefaults(true);
		saveConfig();
        getLogger().info("ChatSounds has successfully enabled");
		}

	@Override
	public void onDisable(){
		//Do more things.
		getLogger().info("ChatSounds has successfully disabled");
	}

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if(cmd.getName().equalsIgnoreCase("chatsounds")){
                 if(args.length < 1){
                    sender.sendMessage(ChatColor.RED + "Not enough arguments.");
                    return true;
                 }
                 if(args.length > 1){
                    sender.sendMessage(ChatColor.RED + "Too many arguments.");
                    return true;
                 }
            if(args[0].equalsIgnoreCase("reload") && sender.hasPermission("chatsounds.reload")){
                reloadConfig();
                sender.sendMessage(ChatColor.GREEN + "Config reloaded.");
                return true;
        }else{
            sender.sendMessage(ChatColor.RED + "You do not have permission to do that");
            return true;
        }
    }
        return false;
    }
}
//