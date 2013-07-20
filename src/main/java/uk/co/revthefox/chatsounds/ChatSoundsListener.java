package uk.co.revthefox.chatsounds;

import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatSoundsListener implements Listener
{

    private final ChatSounds plugin;

    public ChatSoundsListener(ChatSounds plugin)
    {
        this.plugin = plugin;
    }

    @EventHandler(ignoreCancelled = true)
    public void onAsyncPlayerChat(AsyncPlayerChatEvent event)
    {
        if (!event.getPlayer().hasPermission("chatsounds.send"))
        {
            return;
        }

        String trigger = "";

        for (String alias : this.plugin.getAliases())
        {
            if (event.getMessage().contains(alias))
            {
                trigger = alias;
                break;
            }
        }

        if (!trigger.isEmpty())
        {
            Sound sound = this.plugin.getSound(trigger);
            this.playSound(event.getPlayer(), sound);
        }
    }

    public void playSound(Player player, Sound sound)
    {
        double range = this.plugin.getConfig().getDouble("range");
        float pitch = Float.parseFloat(this.plugin.getConfig().getString("pitch"));
        float volume = Float.parseFloat(this.plugin.getConfig().getString("volume"));

        if (range == -1)
        {
            for (Player oPlayer : this.plugin.getServer().getOnlinePlayers())
            {
                if (oPlayer.hasPermission("chatsounds.receive"))
                {
                    oPlayer.playSound(oPlayer.getLocation(), sound, volume, pitch);
                }
            }
        }
        else if (range == 0)
        {
            player.playSound(player.getLocation(), sound, volume, pitch);
        }
        else
        {
            for (Entity entity : player.getNearbyEntities(range, range, range))
            {
                if (entity instanceof Player)
                {
                    Player ePlayer = (Player) entity;
                    if (ePlayer.hasPermission("chatsounds.receive"))
                    {
                        ePlayer.playSound(ePlayer.getLocation(), sound, volume, pitch);
                    }
                }
            }
        }
    }
}
