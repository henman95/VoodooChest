package com.h1723.org.voodooplugin;

public abstract class BaseLocation implements VoodooLocation {
	private VoodooLogger logger = null;
	private VoodooEngine engine = null;
	private String       name   = "";
	
	public BaseLocation( VoodooEngine engine, String name) {
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
