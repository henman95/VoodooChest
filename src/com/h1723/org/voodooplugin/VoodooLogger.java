package com.h1723.org.voodooplugin;

import java.util.logging.Logger;

public class VoodooLogger {
	Logger  logger = null;
	String	prefix = "";
	Integer	level  = 0;	 
	
	public VoodooLogger( VoodooPlugin plugin ) {
		if( plugin != null ) {
			logger = Logger.getLogger( "minecraft.voodoo" );
		
			if( plugin.getDescription() != null )
				setPrefix( plugin.getDescription().getName() );
		}
	}
	
	public void setPrefix( String text ) {
		this.prefix = text;
	}
	
	public void setLevel( Integer level ) {
		this.level = level;
	}
	
	public void log( Integer textLevel, String text ) {
		if (logger != null & textLevel <= level )
			logger.info( String.format( "[%s]: %s", this.prefix, text ) );
	}
	
	public void log( String text ) {
		log( 0, text);
	}

}
