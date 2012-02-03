package com.h1723.org.voodooplugin;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class TestEngine extends BaseEngine {
	
	public TestEngine( VoodooPlugin plugin ) {
		super( plugin );
	}
	
	public void initialize() {
		log( 1, "Initializing Voodoo Engine" );
		
		//Initialize Triggers
		addTrigger( new BoneTrigger( this ) );
		
		//Initialize Locations
		addLocation( new SandTowerLocation( this ) );
		addLocation( new WoodTeeLocation( this )   );
		
	}
	
	public void onTrigger( TriggerEvent event ) {
		log( 3, "Engine Triggered by " + event.getName() + " for Player " + event.getPlayerInteractEvent().getPlayer().getName() );
			
		VoodooLocation location = findVoodooLocation( event );
		
		if( location == null ) {
			log( 3, "No location found" );
			return;
		}
		
		String         name     = location.getName();
		
		if( name == "sandtower" ) {
			log( "Executing Sandtown Voodoo - " + name );
			
			Player player = event.getPlayerInteractEvent().getPlayer();
			
			//player.getWorld().strikeLightningEffect( player.getLocation() );
			player.getWorld().createExplosion( player.getLocation(), 4 );
		}
		
		if( name == "woodtee" ) {
			log( "Executing WoodTee Voodoo - " + name );
			Player player = event.getPlayerInteractEvent().getPlayer();
			
			Inventory inventory = player.getInventory();
			
			if( ! inventory.contains(Material.WOOD_AXE) ) inventory.addItem( new ItemStack(Material.WOOD_AXE, 1) );
			if( ! inventory.contains(Material.WOOD_PICKAXE) ) inventory.addItem( new ItemStack(Material.WOOD_PICKAXE, 1) );
			if( ! inventory.contains(Material.WOOD_HOE) ) inventory.addItem( new ItemStack(Material.WOOD_HOE, 1) );
			if( ! inventory.contains(Material.WOOD_SWORD) ) inventory.addItem( new ItemStack(Material.WOOD_SWORD, 1) );
			if( ! inventory.contains(Material.WOOD_SPADE) ) inventory.addItem( new ItemStack(Material.WOOD_SPADE, 1) );
			
			location.destroy( event );
		}
	}
	
	private VoodooLocation findVoodooLocation( TriggerEvent event ) {
		for( VoodooLocation location: getLocations() ) {
			log( 3, "Checking location - " + location.getName() );
			if( location.isVoodooLocation( event ) ) {
				log( 3, "  is location" );
				return location;
			} else {
				log( 3, "  is NOT location" );
			}
		}
		
		return null;
	}
}
