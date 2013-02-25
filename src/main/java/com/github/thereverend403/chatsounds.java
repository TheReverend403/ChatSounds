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

package com.github.thereverend403;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.mcstats.MetricsLite;

import java.io.IOException;

public class chatsounds extends JavaPlugin {

    public final PlayerListener pl = new PlayerListener(this);

	@Override
	public void onEnable(){
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new PlayerListener(this), this);
        getCommand("chatsounds").setExecutor(new CSCommandExecutor(this));
		saveDefaultConfig();
        try {
            MetricsLite metrics = new MetricsLite(this);
            metrics.start();
        } catch (IOException e) {
            // Failed to submit the stats :-(
        }
        getLogger().info("ChatSounds has successfully enabled");
		}

	@Override
	public void onDisable(){
		//Do more things.
		getLogger().info("ChatSounds has successfully disabled");
	}

}