package com.h1723.org.voodoochestplugin;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;

import org.bukkit.event.Listener;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.block.BlockPlaceEvent;

public class SandTransformer extends VoodooListener {
	public SandTransformer( VoodooChestPlugin instance ) {
		super( instance );
	}
	
	@EventHandler( priority = EventPriority.NORMAL )
	public void placeBlock( BlockPlaceEvent event ) {
		Block block = event.getBlock();
		
		if( block.getType() == Material.SAND ) {
			
			//Turn Adjacent non-air block to Wood
			Material material = Material.DIAMOND_BLOCK;
			
			setNonAirBlock( block.getRelative( BlockFace.NORTH )      , material );
			setNonAirBlock( block.getRelative( BlockFace.NORTH_EAST ) , material );
			setNonAirBlock( block.getRelative( BlockFace.EAST )       , material );
			setNonAirBlock( block.getRelative( BlockFace.SOUTH_EAST ) , material );
			setNonAirBlock( block.getRelative( BlockFace.SOUTH )      , material );
			setNonAirBlock( block.getRelative( BlockFace.SOUTH_WEST ) , material );
			setNonAirBlock( block.getRelative( BlockFace.WEST )       , material );
			setNonAirBlock( block.getRelative( BlockFace.NORTH_WEST ) , material );
		}
	}
	
	private void setNonAirBlock( Block block, Material mat) {
		Material current = block.getType();
		
		if( block.getType() != Material.AIR )
			block.setType( mat );
	}
	
}
