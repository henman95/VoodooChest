package com.h1723.org.voodoochestplugin;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.event.Listener;


public class VoodooChestPlugin extends JavaPlugin {

		Logger log = Logger.getLogger( "minecraft.voodoochest" );

		public void onEnable() {
			PluginDescriptionFile pdf = this.getDescription();
			
			log( "Enabled" );
			log( "  Version: " + pdf.getVersion() );
			
			
			List<Listener> listeners = new ArrayList<Listener>();
			//listeners.add( new SandTransformer( this ) );
			listeners.add( new PlayerInteraction( this ) );
			
			this.getConfig().options().copyDefaults( true );
			saveConfig();
			}
		
		public void onDisable() {
			log( "Disabled" );
		}
		
		public void log( String message ) {
			PluginDescriptionFile pdf = this.getDescription();
			String name = pdf.getName();
			
			log.info( String.format( "[%s] - %s", name, message ) );
		}
}
