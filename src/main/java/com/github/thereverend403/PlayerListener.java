package com.github.thereverend403;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerListener implements Listener
{

    public ChatSounds plugin;
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
    public int amount;
    static float pitch = 1;
    static float volume = 10;

    public PlayerListener(ChatSounds instance)
    {
        plugin = instance;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event)
    {

        /* There has to be a more efficient way to do this...
         Only triggering if the player has permission, but still checking on
         every chat event... */

        Player player = event.getPlayer();
        if (player.hasPermission("ChatSounds.allow")) {
            amount = 0;
            cat = plugin.getConfig().getString("ChatSounds.aliases.cat");
            cat_purr = plugin.getConfig().getString("ChatSounds.aliases.cat-purr");
            dog = plugin.getConfig().getString("ChatSounds.aliases.dog");
            dog_growl = plugin.getConfig().getString("ChatSounds.aliases.dog-growl");
            chicken = plugin.getConfig().getString("ChatSounds.aliases.chicken");
            cow = plugin.getConfig().getString("ChatSounds.aliases.cow");
            sheep = plugin.getConfig().getString("ChatSounds.aliases.sheep");
            pig = plugin.getConfig().getString("ChatSounds.aliases.pig");
            creeper = plugin.getConfig().getString("ChatSounds.aliases.creeper");
            ender = plugin.getConfig().getString("ChatSounds.aliases.enderman");
            explosion = plugin.getConfig().getString("ChatSounds.aliases.explosion");
            dragon_death = plugin.getConfig().getString("ChatSounds.aliases.dragon-death");
            ghast_screech = plugin.getConfig().getString("ChatSounds.aliases.ghast-screech");
            global = plugin.getConfig().getBoolean("ChatSounds.global");
            String message = event.getMessage().toLowerCase();
            if (message.contains(cat)) {
                amount++;
                Sound sound = Sound.CAT_MEOW;
                if (global) {
                    for (Player online : Bukkit.getOnlinePlayers()) {
                        if (online.hasPermission("ChatSounds.hear")) {
                            playSound(online, sound);
                        }
                    }
                } else {
                    playSound(player, sound);
                }
            }
            if (message.contains(cat_purr)) {
                amount++;
                Sound sound = Sound.CAT_PURR;
                if (global) {
                    for (Player online : Bukkit.getOnlinePlayers()) {
                        if (online.hasPermission("ChatSounds.hear")) {
                            playSound(online, sound);
                        }
                    }
                } else {
                    playSound(player, sound);
                }
            }
            if (message.contains(dog)) {
                amount++;
                Sound sound = Sound.WOLF_BARK;
                if (global) {
                    for (Player online : Bukkit.getOnlinePlayers()) {
                        if (online.hasPermission("ChatSounds.hear")) {
                            playSound(online, sound);
                        }
                    }
                } else {
                    playSound(player, sound);
                }
            }
            if (message.contains(dog_growl)) {
                amount++;
                Sound sound = Sound.WOLF_GROWL;
                if (global) {
                    for (Player online : Bukkit.getOnlinePlayers()) {
                        if (online.hasPermission("ChatSounds.hear")) {
                            playSound(online, sound);
                        }
                    }
                } else {
                    playSound(player, sound);
                }
            }
            if (message.contains(creeper)) {
                amount++;
                Sound sound = Sound.FUSE;
                if (global) {
                    for (Player online : Bukkit.getOnlinePlayers()) {
                        if (online.hasPermission("ChatSounds.hear")) {
                            playSound(online, sound);
                        }
                    }
                } else {
                    playSound(player, sound);
                }
            }
            if (message.contains(cow)) {
                amount++;
                Sound sound = Sound.COW_HURT;
                if (global) {
                    for (Player online : Bukkit.getOnlinePlayers()) {
                        if (online.hasPermission("ChatSounds.hear")) {
                            playSound(online, sound);
                        }
                    }
                } else {
                    playSound(player, sound);
                }
            }
            if (message.contains(chicken)) {
                amount++;
                Sound sound = Sound.CHICKEN_IDLE;
                if (global) {
                    for (Player online : Bukkit.getOnlinePlayers()) {
                        if (online.hasPermission("ChatSounds.hear")) {
                            playSound(online, sound);
                        }
                    }
                } else {
                    playSound(player, sound);
                }
            }
            if (message.contains(ender)) {
                amount++;
                Sound sound = Sound.ENDERMAN_STARE;
                if (global) {
                    for (Player online : Bukkit.getOnlinePlayers()) {
                        if (online.hasPermission("ChatSounds.hear")) {
                            playSound(online, sound);
                        }
                    }
                } else {
                    playSound(player, sound);
                }
            }
            if (message.contains(pig)) {
                amount++;
                Sound sound = Sound.PIG_IDLE;
                if (global) {
                    for (Player online : Bukkit.getOnlinePlayers()) {
                        if (online.hasPermission("ChatSounds.hear")) {
                            playSound(online, sound);
                        }
                    }
                } else {
                    playSound(player, sound);
                }
            }
            if (message.contains(sheep)) {
                amount++;
                Sound sound = Sound.SHEEP_IDLE;
                if (global) {
                    for (Player online : Bukkit.getOnlinePlayers()) {
                        if (online.hasPermission("ChatSounds.hear")) {
                            playSound(online, sound);
                        }
                    }
                } else {
                    playSound(player, sound);
                }
            }
            if (message.contains(explosion)) {
                amount++;
                Sound sound = Sound.EXPLODE;
                if (global) {
                    for (Player online : Bukkit.getOnlinePlayers()) {
                        if (online.hasPermission("ChatSounds.hear")) {
                            playSound(online, sound);
                        }
                    }
                } else {
                    playSound(player, sound);
                }
            }
            if (message.contains(dragon_death)) {
                amount++;
                Sound sound = Sound.ENDERDRAGON_DEATH;
                if (global) {
                    for (Player online : Bukkit.getOnlinePlayers()) {
                        if (online.hasPermission("ChatSounds.hear")) {
                            playSound(online, sound);
                        }
                    }
                } else {
                    playSound(player, sound);
                }
            }
            if (message.contains(ghast_screech)) {
                amount++;
                Sound sound = Sound.GHAST_SCREAM;
                if (global) {
                    for (Player online : Bukkit.getOnlinePlayers()) {
                        if (online.hasPermission("ChatSounds.hear")) {
                            playSound(online, sound);
                        }
                    }
                } else {
                    playSound(player, sound);
                }
            }
        }
    }

    public void playSound(Player online, Sound sound)
    {
        if (amount > 1) {
            return;
        } else {
            online.playSound(online.getLocation(), sound, volume, pitch);
        }
    }
}
