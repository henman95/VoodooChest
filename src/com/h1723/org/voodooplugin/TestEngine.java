package com.h1723.org.voodooplugin;

import org.bukkit.entity.Player;

public class TestEngine extends BaseEngine {
	
	public TestEngine( VoodooPlugin plugin ) {
		super( plugin );
	}
	
	public void initialize() {
		log( 1, "Initializing Voodoo Engine" );
		addTrigger( new BoneTrigger( this ) );
		addLocation( new SandTowerLocation( this ) );
		
	}
	
	public void onTrigger( TriggerEvent event ) {
		log( 3, "Engine Triggered by " + event.getName() + " for Player " + event.getPlayerInteractEvent().getPlayer().getName() );
			
		String name = findVoodooLocation( event );
		
		if( name != null ) {
			log( "Found Voodoo location - " + name );
			
			Player player = event.getPlayerInteractEvent().getPlayer();
			
			//player.getWorld().strikeLightningEffect( player.getLocation() );
			player.getWorld().createExplosion( player.getLocation(), 4 );
			
		}
	}
	
	private String findVoodooLocation( TriggerEvent event ) {
		String name = null;
		for( VoodooLocation location: getLocations() ) {
			if( location.isVoodooLocation( event ) ) {
				name = location.getName();
				break;
			}
		}
		
		return name;
	}
}
