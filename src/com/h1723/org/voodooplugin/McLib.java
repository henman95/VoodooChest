package com.h1723.org.voodooplugin;

import org.bukkit.Location;
import org.bukkit.block.Block;

public class McLib {
	public static Block getBlockRelRef( Block target, Location reference, int x, int y, int z ) {
		Location dLoc = getLocRelRef( target.getLocation(), reference, x, y, z );
		
		return target.getRelative( dLoc.getBlockX(), dLoc.getBlockY(), dLoc.getBlockZ() );
	}
	
	public static Location getLocRelRef( Location t, Location r, int x, int y, int z ) {
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
	
	public static boolean isSquared( Location r, Location t ) {
		int rx = r.getBlockX();int rz = r.getBlockZ();
		int tx = t.getBlockX();int tz = t.getBlockZ();

		if( rx!=tx && rz!=tz ) return false;
		if( rx==tx && rz==tz ) return false;
		
		return true;
	}

}
