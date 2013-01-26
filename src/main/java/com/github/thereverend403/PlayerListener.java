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
    String cat_purr;
    String dog;
    String dog_growl;
    String chicken;
    String cow;
    String sheep;
    String pig;
    String creeper;
    String ender;
    String explosion;
    String dragon_death;
    String ghast_screech;
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
            cat_purr = plugin.getConfig().getString("chatsounds.aliases.cat-purr");
            dog = plugin.getConfig().getString("chatsounds.aliases.dog");
            dog_growl = plugin.getConfig().getString("chatsounds.aliases.dog-growl");
            chicken = plugin.getConfig().getString("chatsounds.aliases.chicken");
            cow = plugin.getConfig().getString("chatsounds.aliases.cow");
            sheep = plugin.getConfig().getString("chatsounds.aliases.sheep");
            pig = plugin.getConfig().getString("chatsounds.aliases.pig");
            creeper = plugin.getConfig().getString("chatsounds.aliases.creeper");
            ender = plugin.getConfig().getString("chatsounds.aliases.enderman");
            explosion = plugin.getConfig().getString("chatsounds.aliases.explosion");
            dragon_death = plugin.getConfig().getString("chatsounds.aliases.dragon-death");
            ghast_screech = plugin.getConfig().getString("chatsounds.aliases.ghast-screech");
		    boolean global = plugin.getConfig().getBoolean("chatsounds.global");
			String message = event.getMessage();
			if (message.contains(cat)| (message.contains(cat_purr) || (message.contains(dog) || (message.contains(dog_growl) || (message.contains(creeper) || (message.contains(cow) || (message.contains(chicken) || (message.contains(ender) || (message.contains(pig) || (message.contains(sheep) || (message.contains(explosion) || (message.contains(dragon_death) || (message.contains(ghast_screech)))))))))))))) {
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
				if(message.contains(cat_purr)){
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
				if(message.contains(dog_growl)){
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
                if(message.contains(dragon_death)){
                    Sound sound = Sound.ENDERDRAGON_DEATH;
                    if(global){
                        for(Player online : Bukkit.getOnlinePlayers()){
                            playSound(online, sound);
                        }
                    }else{
                        playSound(player, sound);
                    }
                }
                if(message.contains(ghast_screech)){
                    Sound sound = Sound.GHAST_SCREAM;
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
//trolololololololol