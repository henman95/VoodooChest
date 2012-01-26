package com.h1723.org.voodoochestplugin;

import org.bukkit.event.Listener;

public class VoodooListener implements Listener {
	VoodooChestPlugin plugin;
	
	public VoodooListener( VoodooChestPlugin instance ) {
		plugin = instance;
		plugin.getServer().getPluginManager().registerEvents( this, plugin );
	}
	
	public void log( String text ) {
		plugin.log( text );
	}
}
