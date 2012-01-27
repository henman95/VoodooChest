package com.h1723.org.voodoochestplugin;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;

public class VoodooBase {
	VoodooChestPlugin plugin;
	
	public VoodooBase( VoodooChestPlugin instance ) {
		plugin = instance;
	}
	
	public VoodooChestPlugin getPlugin() {
		return plugin;
	}
	
	public void log( String text ) {
		plugin.log( text );
	}
	
	public FileConfiguration getConfig() {
		return plugin.getConfig();
	}
}
