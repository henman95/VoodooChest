package com.h1723.org.voodooplugin;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

public class WoodTeeLocation extends BaseLocation {

	public WoodTeeLocation( VoodooEngine engine ) {
		super( engine, "woodtee" );
		
		log( 3, "Creating the WoodTee Location" );
	}
	
	public boolean isVoodooLocation( TriggerEvent tEvent ) {
boolean retval = false;
		
		log( 3, "Check if WoodTee Location" );
		
		PlayerInteractEvent pievent = tEvent.getPlayerInteractEvent();
		Player player = tEvent.getPlayerInteractEvent().getPlayer();
		
		//The center should be the hit item
		Block target = tEvent.getTarget();
		
		if( target == null ) {
			log( 4, "  No Target" );
			return false;
		}
			
		Location pLocation = player.getLocation();
		Location tLocation = target.getLocation();
				
		// Check to see if level
		if( pLocation.getBlockY() != (tLocation.getBlockY()) ) {
			log( "  Not Level" );
			return false;
		}
		
		if( ! McLib.isSquared( pLocation, tLocation) ) {
			log( "  Not Squared" );
			return false;
		}
		
		retval = true;
		// Back
		if( retval && McLib.getBlockRelRef( target, pLocation,  1,  0,  1).getType() != Material.AIR ) retval = false;
		if( retval && McLib.getBlockRelRef( target, pLocation,  0,  0,  1).getType() != Material.AIR ) retval = false;
		if( retval && McLib.getBlockRelRef( target, pLocation, -1,  0,  1).getType() != Material.AIR ) retval = false;
		if( retval && McLib.getBlockRelRef( target, pLocation,  1,  1,  1).getType() != Material.AIR ) retval = false;
		if( retval && McLib.getBlockRelRef( target, pLocation,  0,  1,  1).getType() != Material.AIR ) retval = false;
		if( retval && McLib.getBlockRelRef( target, pLocation, -1,  1,  1).getType() != Material.AIR ) retval = false;
		if( retval && McLib.getBlockRelRef( target, pLocation,  1,  2,  1).getType() != Material.AIR ) retval = false;
		if( retval && McLib.getBlockRelRef( target, pLocation,  0,  2,  1).getType() != Material.AIR ) retval = false;
		if( retval && McLib.getBlockRelRef( target, pLocation, -1,  2,  1).getType() != Material.AIR ) retval = false;
		
		// Middle
		if( retval && McLib.getBlockRelRef( target, pLocation,  1,  0,  0).getType() != Material.AIR ) retval = false;
		if( retval && McLib.getBlockRelRef( target, pLocation,  0,  0,  0).getType() != Material.LOG ) retval = false;
		if( retval && McLib.getBlockRelRef( target, pLocation, -1,  0,  0).getType() != Material.AIR ) retval = false;
		if( retval && McLib.getBlockRelRef( target, pLocation,  1,  1,  0).getType() != Material.AIR ) retval = false;
		if( retval && McLib.getBlockRelRef( target, pLocation,  0,  1,  0).getType() != Material.LOG ) retval = false;
		if( retval && McLib.getBlockRelRef( target, pLocation, -1,  1,  0).getType() != Material.AIR ) retval = false;
		if( retval && McLib.getBlockRelRef( target, pLocation,  1,  2,  0).getType() != Material.LOG ) retval = false;
		if( retval && McLib.getBlockRelRef( target, pLocation,  0,  2,  0).getType() != Material.LOG ) retval = false;
		if( retval && McLib.getBlockRelRef( target, pLocation, -1,  2,  0).getType() != Material.LOG ) retval = false;
		
		// Front
		if( retval && McLib.getBlockRelRef( target, pLocation,  1,  0, -1).getType() != Material.AIR ) retval = false;
		if( retval && McLib.getBlockRelRef( target, pLocation,  0,  0, -1).getType() != Material.AIR ) retval = false;
		if( retval && McLib.getBlockRelRef( target, pLocation, -1,  0, -1).getType() != Material.AIR ) retval = false;
		if( retval && McLib.getBlockRelRef( target, pLocation,  1,  1, -1).getType() != Material.AIR ) retval = false;
		if( retval && McLib.getBlockRelRef( target, pLocation,  0,  1, -1).getType() != Material.AIR ) retval = false;
		if( retval && McLib.getBlockRelRef( target, pLocation, -1,  1, -1).getType() != Material.AIR ) retval = false;
		if( retval && McLib.getBlockRelRef( target, pLocation,  1,  2, -1).getType() != Material.AIR ) retval = false;
		if( retval && McLib.getBlockRelRef( target, pLocation,  0,  2, -1).getType() != Material.AIR ) retval = false;
		if( retval && McLib.getBlockRelRef( target, pLocation, -1,  2, -1).getType() != Material.AIR ) retval = false;
		return retval;
	}
	
	public void destroy( TriggerEvent tEvent) {
		PlayerInteractEvent pievent = tEvent.getPlayerInteractEvent();
		Player player = tEvent.getPlayerInteractEvent().getPlayer();
		
		//The center should be the hit item
		Block target = tEvent.getTarget();
		
		Location pLocation = player.getLocation();
		Location tLocation = target.getLocation();
				
		// Back
		McLib.getBlockRelRef( target, pLocation,  1,  0,  1).setType( Material.AIR );
		McLib.getBlockRelRef( target, pLocation,  0,  0,  1).setType( Material.AIR );
		McLib.getBlockRelRef( target, pLocation, -1,  0,  1).setType( Material.AIR );
		McLib.getBlockRelRef( target, pLocation,  1,  1,  1).setType( Material.AIR );
		McLib.getBlockRelRef( target, pLocation,  0,  1,  1).setType( Material.AIR );
		McLib.getBlockRelRef( target, pLocation, -1,  1,  1).setType( Material.AIR );
		McLib.getBlockRelRef( target, pLocation,  1,  2,  1).setType( Material.AIR );
		McLib.getBlockRelRef( target, pLocation,  0,  2,  1).setType( Material.AIR );
		McLib.getBlockRelRef( target, pLocation, -1,  2,  1).setType( Material.AIR );
		
		// Middle
		McLib.getBlockRelRef( target, pLocation,  1,  0,  0).setType( Material.AIR );
		McLib.getBlockRelRef( target, pLocation,  0,  0,  0).setType( Material.LEAVES );
		McLib.getBlockRelRef( target, pLocation, -1,  0,  0).setType( Material.AIR );
		McLib.getBlockRelRef( target, pLocation,  1,  1,  0).setType( Material.AIR );
		McLib.getBlockRelRef( target, pLocation,  0,  1,  0).setType( Material.LEAVES );
		McLib.getBlockRelRef( target, pLocation, -1,  1,  0).setType( Material.AIR );
		McLib.getBlockRelRef( target, pLocation,  1,  2,  0).setType( Material.LEAVES );
		McLib.getBlockRelRef( target, pLocation,  0,  2,  0).setType( Material.LEAVES );
		McLib.getBlockRelRef( target, pLocation, -1,  2,  0).setType( Material.LEAVES );
		
		McLib.getBlockRelRef( target, pLocation,  1,  3,  0).setType( Material.FIRE );
		McLib.getBlockRelRef( target, pLocation,  0,  3,  0).setType( Material.FIRE );
		McLib.getBlockRelRef( target, pLocation, -1,  3,  0).setType( Material.FIRE );
		
		
		// Front
		McLib.getBlockRelRef( target, pLocation,  1,  0, -1).setType( Material.AIR );
		McLib.getBlockRelRef( target, pLocation,  0,  0, -1).setType( Material.AIR );
		McLib.getBlockRelRef( target, pLocation, -1,  0, -1).setType( Material.AIR );
		McLib.getBlockRelRef( target, pLocation,  1,  1, -1).setType( Material.AIR );
		McLib.getBlockRelRef( target, pLocation,  0,  1, -1).setType( Material.AIR );
		McLib.getBlockRelRef( target, pLocation, -1,  1, -1).setType( Material.AIR );
		McLib.getBlockRelRef( target, pLocation,  1,  2, -1).setType( Material.AIR );
		McLib.getBlockRelRef( target, pLocation,  0,  2, -1).setType( Material.AIR );
		McLib.getBlockRelRef( target, pLocation, -1,  2, -1).setType( Material.AIR );
		
	}
	
}
