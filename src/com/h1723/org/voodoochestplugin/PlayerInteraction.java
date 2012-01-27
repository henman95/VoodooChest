package com.h1723.org.voodoochestplugin;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteraction extends VoodooBase implements Listener {
	
	public PlayerInteraction( VoodooChestPlugin instance ) {
		super( instance );
		
		instance.getServer().getPluginManager().registerEvents( this, plugin );
	}
	
	@EventHandler()
	public void onPlayerInteract( PlayerInteractEvent event ) {
		Block  block  = event.getClickedBlock();
		Action action = event.getAction();
		
		if( action == Action.RIGHT_CLICK_BLOCK ) {
			if( block.getType() == Material.CHEST ) {
				
				VoodooChest chest = new VoodooChest( (Chest)block.getState(), getPlugin() );
				
				if( chest.isVoodooChest() ) {
					performRitual( chest );
				}
			}
		}
	}
	
	private void performRitual( VoodooChest chest ) {
		VoodooRitual ritual = chest.getRitual();
		
		log( "Ritual : " + ritual );
		
		if( ritual.getType() == VoodooRitual.Type.CONVERSION ) {
			chest.convertMaterials( Material.GRAVEL, Material.DIRT, 2 );
			chest.convertMaterials( Material.COAL  , Material.DIAMOND, 4 );
		}
		
		if( ritual.getType() == VoodooRitual.Type.THUNDER ) {
			log( "BOOOOM" );
			
			//getPlugin().getServer().getWorld( "World" ).setThunderDuration( 1000 );
			getPlugin().getServer().getWorld( "World" ).setTime( 0 );
			
		}
	}
}
