package com.h1723.org.voodoochestplugin;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class VoodooChestPlugin extends JavaPlugin {

		Logger log = Logger.getLogger( "minecraft.voodoochest" );

		public void onEnable() {
			PluginDescriptionFile pdf = this.getDescription();
			
			log( "Enabled" );
			log( "Version: " + pdf.getVersion() );
	
		}
		
		public void onDisable() {
			log( "Disabled" );
		}
		
		private void log( String message ) {
			PluginDescriptionFile pdf = this.getDescription();
			String name = pdf.getName();
			
			log.info( String.format( "[%s] - %s", name, message ) );
		}
}
