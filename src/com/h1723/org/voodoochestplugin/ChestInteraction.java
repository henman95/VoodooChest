package com.h1723.org.voodoochestplugin;


import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ChestInteraction extends VoodooListener {
	public ChestInteraction( VoodooChestPlugin instance ) {
		super( instance );
	}
	
	@EventHandler()
	public void onPlayerInteract( PlayerInteractEvent event ) {
		Block  block  = event.getClickedBlock();
		Action action = event.getAction();
		
		if( action == Action.RIGHT_CLICK_BLOCK & block.getType() == Material.CHEST ) {
			log( "  Checking Chest Inventory" );
			
			Chest chest = (Chest)block.getState();
			Inventory inventory = chest.getInventory();

			ConvertMaterials( inventory, Material.DIAMOND, Material.TNT, 4 );
			ConvertMaterials( inventory, Material.SAND, Material.DIAMOND, 3 );
			ConvertMaterials( inventory, Material.DIRT, Material.SAND   , 5 );
		}
	}
	
	@SuppressWarnings("unused")
	private void LogInventory( Inventory inventory ) {
		for( ItemStack stack: inventory.getContents() ) {
			if( stack != null )
				log( " - " + stack );
		}
	}
	
	private void ConvertMaterials( Inventory inventory, Material source, Material destination, int ratio ) {

		int sCount = 0;
		for( ItemStack stack: inventory.getContents() ) {
			if( stack != null && stack.getType() == source ) {
				sCount += stack.getAmount();
			}
		}
		
		
		int dCount = sCount / ratio;
		int rCount = sCount - dCount * ratio;
		
		inventory.remove( source );

		addMaterial( inventory, destination, dCount );
		addMaterial( inventory, source, rCount );
	}
	
	private void addMaterial( Inventory inventory, Material material, int amount ) {
		while( amount > 0 ) {
			int count = amount;
			if( count > 64 )
				count = 64;
			
			ItemStack newStack = new ItemStack( material, count );
			inventory.addItem( newStack );
			
			amount -= count;	
		}
	}
	
	
}
