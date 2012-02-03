package com.h1723.org.voodooplugin;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

public class SandTowerLocation extends BaseLocation {
	public SandTowerLocation( VoodooEngine engine ) {
		super( engine, "sandtower" );
		
		log( 3, "Creating the SandTower Location" );
	}

	public boolean isVoodooLocation( TriggerEvent tEvent) {
		boolean retval = false;
		
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
		if( pLocation.getBlockY() != tLocation.getBlockY() ) {
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
		if( retval && McLib.getBlockRelRef( target, pLocation,  1,  0,  0).getType() != Material.SAND ) retval = false;
		if( retval && McLib.getBlockRelRef( target, pLocation,  0,  0,  0).getType() != Material.LOG  ) retval = false;
		if( retval && McLib.getBlockRelRef( target, pLocation, -1,  0,  0).getType() != Material.SAND ) retval = false;
		if( retval && McLib.getBlockRelRef( target, pLocation,  1,  1,  0).getType() != Material.SAND ) retval = false;
		if( retval && McLib.getBlockRelRef( target, pLocation,  0,  1,  0).getType() != Material.AIR  ) retval = false;
		if( retval && McLib.getBlockRelRef( target, pLocation, -1,  1,  0).getType() != Material.SAND ) retval = false;
		if( retval && McLib.getBlockRelRef( target, pLocation,  1,  2,  0).getType() != Material.SAND ) retval = false;
		if( retval && McLib.getBlockRelRef( target, pLocation,  0,  2,  0).getType() != Material.LOG  ) retval = false;
		if( retval && McLib.getBlockRelRef( target, pLocation, -1,  2,  0).getType() != Material.SAND ) retval = false;
		
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
	
	public void destroy( TriggerEvent tEevent) {
		
	}
}
