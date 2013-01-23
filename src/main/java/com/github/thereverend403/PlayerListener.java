package com.github.thereverend403;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerListener implements Listener {

	public chatsounds plugin;
	boolean global;
    String cat;
    String catpurr;
    String dog;
    String doggrowl;
    String chicken;
    String cow;
    String sheep;
    String pig;
    String creeper;
    String ender;
    String explosion;
    String dragondeath;
	static float pitch = 1;
	static float volume = 10;
	public PlayerListener(chatsounds instance) {
	plugin = instance;
	}

	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		// There has to be a more efficient way to do this...
		// Only triggering if the player has permission, but still checking on
		// every chat event...
		Player player = event.getPlayer();
        if (player.hasPermission("chatsounds.allow")) {
            cat = plugin.getConfig().getString("chatsounds.aliases.cat");
            catpurr = plugin.getConfig().getString("chatsounds.aliases.catpurr");
            dog = plugin.getConfig().getString("chatsounds.aliases.dog");
            doggrowl = plugin.getConfig().getString("chatsounds.aliases.doggrowl");
            chicken = plugin.getConfig().getString("chatsounds.aliases.chicken");
            cow = plugin.getConfig().getString("chatsounds.aliases.cow");
            sheep = plugin.getConfig().getString("chatsounds.aliases.sheep");
            pig = plugin.getConfig().getString("chatsounds.aliases.pig");
            creeper = plugin.getConfig().getString("chatsounds.aliases.creeper");
            ender = plugin.getConfig().getString("chatsounds.aliases.enderman");
            explosion = plugin.getConfig().getString("chatsounds.aliases.explosion");
            dragondeath = plugin.getConfig().getString("chatsounds.aliases.dragondeath");
		    boolean global = plugin.getConfig().getBoolean("chatsounds.global");
			String message = event.getMessage();
			if (message.contains(cat)| (message.contains(catpurr) || (message.contains(dog) || (message.contains(doggrowl) || (message.contains(creeper) || (message.contains(cow) || (message.contains(chicken) || (message.contains(ender) || (message.contains(pig) || (message.contains(sheep) || (message.contains(explosion) || (message.contains(dragondeath))))))))))))) {
				if(message.contains(cat)){
					Sound sound = Sound.CAT_MEOW;
					if(global){
						for(Player online : Bukkit.getOnlinePlayers()){
							playSound(online, sound);
						}
					}else{
						playSound(player, sound);
					}
				}
				if(message.contains(catpurr)){
					Sound sound = Sound.CAT_PURR;
					if(global){
						for(Player online : Bukkit.getOnlinePlayers()){
							playSound(online, sound);
						}
					}else{
						playSound(player, sound);
					}
				}
				if(message.contains(dog)){
					Sound sound = Sound.WOLF_BARK;
					if(global){
						for(Player online : Bukkit.getOnlinePlayers()){
							playSound(online, sound);
						}
					}else{
						playSound(player, sound);
					}
				}
				if(message.contains(doggrowl)){
					Sound sound = Sound.WOLF_GROWL;
					if(global){
						for(Player online : Bukkit.getOnlinePlayers()){
							playSound(online, sound);
						}
					}else{
						playSound(player, sound);
					}
				}
				if(message.contains(creeper)){
					Sound sound = Sound.FUSE;
					if(global){
						for(Player online : Bukkit.getOnlinePlayers()){
							playSound(online, sound);
						}
					}else{
						playSound(player, sound);
					}
				}
				if(message.contains(cow)){
					Sound sound = Sound.COW_HURT;
					if(global){
						for(Player online : Bukkit.getOnlinePlayers()){
							playSound(online, sound);
						}
					}else{
						playSound(player, sound);
					}
				}
				if(message.contains(chicken)){
					Sound sound = Sound.CHICKEN_IDLE;
					if(global){
						for(Player online : Bukkit.getOnlinePlayers()){
							playSound(online, sound);
						}
					}else{
						playSound(player, sound);
					}
				}
				if(message.contains(ender)){
					Sound sound = Sound.ENDERMAN_STARE;
					if(global){
						for(Player online : Bukkit.getOnlinePlayers()){
							playSound(online, sound);
						}
					}else{
						playSound(player, sound);
					}
				}
				if(message.contains(pig)){
					Sound sound = Sound.PIG_IDLE;
					if(global){
						for(Player online : Bukkit.getOnlinePlayers()){
							playSound(online, sound);
						}
					}else{
						playSound(player, sound);
					}
				}
				if(message.contains(sheep)){
					Sound sound = Sound.SHEEP_IDLE;
					if(global){
						for(Player online : Bukkit.getOnlinePlayers()){
							playSound(online, sound);
						}
					}else{
						playSound(player, sound);
					}
				}
                if(message.contains(explosion)){
                    Sound sound = Sound.EXPLODE;
                    if(global){
                        for(Player online : Bukkit.getOnlinePlayers()){
                            playSound(online, sound);
                        }
                    }else{
                        playSound(player, sound);
                    }
                }
                if(message.contains(dragondeath)){
                    Sound sound = Sound.ENDERDRAGON_DEATH;
                    if(global){
                        for(Player online : Bukkit.getOnlinePlayers()){
                            playSound(online, sound);
                        }
                    }else{
                        playSound(player, sound);
                    }
                }
			}
		}
	}
	public static void playSound(Player online, Sound sound){
        online.playSound(online.getLocation(), sound, volume, pitch);
	}
}

//irc test