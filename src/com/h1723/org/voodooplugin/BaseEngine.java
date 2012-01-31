package com.h1723.org.voodooplugin;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.event.Listener;

public abstract class BaseEngine implements VoodooEngine{
	private VoodooPlugin plugin;
	private VoodooLogger logger;
	private Integer      debug = 0;
	
	private List<VoodooTrigger> triggers;
	
	public BaseEngine( VoodooPlugin plugin ) {
		this.plugin   = plugin;
		this.logger   = plugin.getVoodooLogger();
		this.triggers = new ArrayList<VoodooTrigger>();
	}
	
	public VoodooPlugin getPlugin() {
		return plugin;
	}
	
	public VoodooLogger getLogger() {
		return logger;
	}
	
	public void setDebug() {
		debug = 1;
	}
	public void setDebug( Integer level ) {
		debug = level;
	}
	
	public void clearDebug() {
		debug = 0;
	}
	
	protected void addTrigger( VoodooTrigger trigger ) {
		triggers.add( trigger );
		registerListener( trigger ) ;
		log( 3,"  Registering Trigger - " + trigger.getName() );
	}
	
	private void registerListener( Listener trigger ) {
		plugin.getServer().getPluginManager().registerEvents( trigger, plugin );
	}
	
	protected void log( String text ) {
		if( logger != null )
			logger.log( text );
	}
	
	protected void log( Integer level, String text ) {
		if( logger != null )
			logger.log( level, text );
	}
}
