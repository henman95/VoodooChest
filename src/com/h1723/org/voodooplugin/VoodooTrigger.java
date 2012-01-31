package com.h1723.org.voodooplugin;

import org.bukkit.event.Listener;

public interface VoodooTrigger extends Listener {
	public String getName();
		
	public void   log( String text );
}
