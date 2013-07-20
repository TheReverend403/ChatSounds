/*
 * ChatSounds - a Bukkit plugin to allow sounds effects in chat
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package uk.co.revthefox.chatsounds;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bukkit.Sound;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.java.JavaPlugin;
import org.mcstats.MetricsLite;

public class ChatSounds extends JavaPlugin
{

    private final ChatSoundsListener listener = new ChatSoundsListener(this);
    private final ChatSoundsCommand executor = new ChatSoundsCommand(this);
    private final Map<String, Sound> soundAliases = new LinkedHashMap<>();

    @Override
    public void onEnable()
    {
        this.saveDefaultConfig();
        this.loadAliases();

        try
        {
            MetricsLite metrics = new MetricsLite(this);
            metrics.start();
        }
        catch (IOException ex)
        {
            // Oh no!
        }

        getServer().getPluginManager().registerEvents(listener, this);
        getCommand("chatsounds").setExecutor(executor);
    }

    public void loadAliases()
    {
        this.soundAliases.clear();

        ConfigurationSection aliasSection = this.getConfig().getConfigurationSection("aliases");

        for (String aliasTitle : aliasSection.getKeys(false))
        {
            try
            {
                Sound sound = Sound.valueOf(aliasTitle);
                List<String> aliases = aliasSection.getStringList(aliasTitle);

                for (String alias : aliases)
                {
                    this.soundAliases.put(alias, sound);
                }
            }
            catch (NullPointerException ex)
            {
            }
        }
    }

    public Set<String> getAliases()
    {
        return this.soundAliases.keySet();
    }

    public Sound getSound(String alias)
    {
        return this.soundAliases.get(alias);
    }
}
