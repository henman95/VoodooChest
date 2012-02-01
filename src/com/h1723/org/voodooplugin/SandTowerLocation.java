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
		
		log( 3, "Check if SandTower Location" );
		
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
		
		if( ! isSquared( pLocation, tLocation) ) {
			log( "  Not Squared" );
			return false;
		}
		
		retval = true;
		// Back
		if( retval && getBlockRelativeReferenced( target, pLocation,  1,  0,  1).getType() != Material.AIR ) retval = false;
		if( retval && getBlockRelativeReferenced( target, pLocation,  0,  0,  1).getType() != Material.AIR ) retval = false;
		if( retval && getBlockRelativeReferenced( target, pLocation, -1,  0,  1).getType() != Material.AIR ) retval = false;
		if( retval && getBlockRelativeReferenced( target, pLocation,  1,  1,  1).getType() != Material.AIR ) retval = false;
		if( retval && getBlockRelativeReferenced( target, pLocation,  0,  1,  1).getType() != Material.AIR ) retval = false;
		if( retval && getBlockRelativeReferenced( target, pLocation, -1,  1,  1).getType() != Material.AIR ) retval = false;
		if( retval && getBlockRelativeReferenced( target, pLocation,  1,  2,  1).getType() != Material.AIR ) retval = false;
		if( retval && getBlockRelativeReferenced( target, pLocation,  0,  2,  1).getType() != Material.AIR ) retval = false;
		if( retval && getBlockRelativeReferenced( target, pLocation, -1,  2,  1).getType() != Material.AIR ) retval = false;
		
		// Middle
		if( retval && getBlockRelativeReferenced( target, pLocation,  1,  0,  0).getType() != Material.SAND ) retval = false;
		if( retval && getBlockRelativeReferenced( target, pLocation,  0,  0,  0).getType() != Material.LOG  ) retval = false;
		if( retval && getBlockRelativeReferenced( target, pLocation, -1,  0,  0).getType() != Material.SAND ) retval = false;
		if( retval && getBlockRelativeReferenced( target, pLocation,  1,  1,  0).getType() != Material.SAND ) retval = false;
		if( retval && getBlockRelativeReferenced( target, pLocation,  0,  1,  0).getType() != Material.AIR  ) retval = false;
		if( retval && getBlockRelativeReferenced( target, pLocation, -1,  1,  0).getType() != Material.SAND ) retval = false;
		if( retval && getBlockRelativeReferenced( target, pLocation,  1,  2,  0).getType() != Material.SAND ) retval = false;
		if( retval && getBlockRelativeReferenced( target, pLocation,  0,  2,  0).getType() != Material.LOG  ) retval = false;
		if( retval && getBlockRelativeReferenced( target, pLocation, -1,  2,  0).getType() != Material.SAND ) retval = false;
		
		// Front
		if( retval && getBlockRelativeReferenced( target, pLocation,  1,  0, -1).getType() != Material.AIR ) retval = false;
		if( retval && getBlockRelativeReferenced( target, pLocation,  0,  0, -1).getType() != Material.AIR ) retval = false;
		if( retval && getBlockRelativeReferenced( target, pLocation, -1,  0, -1).getType() != Material.AIR ) retval = false;
		if( retval && getBlockRelativeReferenced( target, pLocation,  1,  1, -1).getType() != Material.AIR ) retval = false;
		if( retval && getBlockRelativeReferenced( target, pLocation,  0,  1, -1).getType() != Material.AIR ) retval = false;
		if( retval && getBlockRelativeReferenced( target, pLocation, -1,  1, -1).getType() != Material.AIR ) retval = false;
		if( retval && getBlockRelativeReferenced( target, pLocation,  1,  2, -1).getType() != Material.AIR ) retval = false;
		if( retval && getBlockRelativeReferenced( target, pLocation,  0,  2, -1).getType() != Material.AIR ) retval = false;
		if( retval && getBlockRelativeReferenced( target, pLocation, -1,  2, -1).getType() != Material.AIR ) retval = false;
		return retval;
		
	}
	
	private boolean isSquared( Location r, Location t ) {
		int rx = r.getBlockX();int rz = r.getBlockZ();
		int tx = t.getBlockX();int tz = t.getBlockZ();

		if( rx!=tx && rz!=tz ) return false;
		if( rx==tx && rz==tz ) return false;
		
		return true;
	}
	
	private Block getBlockRelativeReferenced( Block target, Location reference, int x, int y, int z ) {
		Location dLoc = RelativeWithReference( target.getLocation(), reference, x, y, z );
		
		return target.getRelative( dLoc.getBlockX(), dLoc.getBlockY(), dLoc.getBlockZ() );
	}
	
	private Location RelativeWithReference( Location t, Location r, int x, int y, int z ) {
		int dx, dz;

		if( r.getBlockX() == t.getBlockX() ) {
			dx = x;
			dz = z;
		} else {
			dx = z;
			dz = x;
		}

		return new Location( null, Double.valueOf(dx),Double.valueOf(y),Double.valueOf(dz) );
	}

}
