package com.h1723.org.voodooplugin;

public class TestEngine extends BaseEngine {
	
	public TestEngine( VoodooPlugin plugin ) {
		super( plugin );
	}
	
	public void initialize() {
		log( 1, "Initializing Voodoo Engine" );
		addTrigger( new BoneTrigger( this ) );
	}
}
