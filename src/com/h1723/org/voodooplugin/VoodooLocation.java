package com.h1723.org.voodooplugin;

public interface VoodooLocation {
	public String getName();
	
	public boolean isVoodooLocation( TriggerEvent tEvent );
	public void    destroy( TriggerEvent tEvent );
}
