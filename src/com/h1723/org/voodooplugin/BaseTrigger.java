package com.h1723.org.voodooplugin;

import org.bukkit.event.Listener;

@SuppressWarnings("unused")
public abstract class BaseTrigger implements VoodooTrigger {
	private VoodooLogger logger = null;
	private VoodooEngine engine = null;
	private String       name   = "";
	
	public BaseTrigger( VoodooEngine engine, String name) {
		this.engine = engine;
		this.logger = engine.getLogger();
		this.name   = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void log( String text ) {
		if( logger != null ) 
			logger.log( text );
	}

	public void log( Integer level, String text ) {
		if( logger != null ) 
			logger.log( level, text );
	}
	
	protected void trigger( TriggerEvent event) {
		event.setName( name );
		
		engine.onTrigger( event );
	}
}
