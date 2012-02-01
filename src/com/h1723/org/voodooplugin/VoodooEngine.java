package com.h1723.org.voodooplugin;

public interface VoodooEngine {
	public VoodooPlugin getPlugin();
	public VoodooLogger getLogger();
	
	public void setDebug();
	public void setDebug( Integer level );
	public void clearDebug();
	
	public void initialize();
	
	public void onTrigger( TriggerEvent event );
}
