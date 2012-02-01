package com.h1723.org.voodooplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class VoodooPlugin extends JavaPlugin {
	
	private VoodooLogger logger = null;
	private VoodooEngine engine = null;
	
	public VoodooPlugin() {
	}

	public void onEnable() {
		// Create Logger
		logger = new VoodooLogger( this );
		logger.setLevel( 5 );
		
		log( "Enabled" );
		log( "  Version: " + this.getDescription().getVersion() );
		
		engine = new TestEngine( this );
		engine.initialize();
	}
	
	public void onDisable() {
		log( "Disabled" );
	}
	
	private void log( String text ) {
		if( logger != null ) 
			logger.log( text );
	}
	
	public VoodooLogger getVoodooLogger() {
		return logger;
	}
}
