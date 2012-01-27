package com.h1723.org.voodoochestplugin;

import java.util.HashMap;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class VoodooChest extends VoodooBase {
	Chest chest;
	
	private HashMap< BlockFace, Material> checkListTop;
	private HashMap< BlockFace, Material> checkListMiddle;
	private HashMap< BlockFace, Material> checkListBottom;
	
	public VoodooChest( Chest pChest, VoodooChestPlugin instance ) {
		super( instance );
		
		chest = pChest;
		
		checkListTop    = getCheckList( "area_top"    );
		checkListMiddle = getCheckList( "area_middle" );
		checkListBottom = getCheckList( "area_bottom" );
	}
	
	private HashMap<BlockFace,Material> getCheckList( String key ) {
		HashMap<BlockFace,Material>checklist = new HashMap<BlockFace,Material>();
		
		List<String> area = getConfig().getStringList( key );
		
		if( area.size() != 9 ) {
			log( "Area " + key + " has an error in the configuration file. Ignoring" );
			return checklist;
		}
		if( !area.get( 0 ).equals( "none" ) ) checklist.put( BlockFace.SELF      , Material.getMaterial( area.get( 0 ) ) );
		if( !area.get( 1 ).equals( "none" ) ) checklist.put( BlockFace.NORTH     , Material.getMaterial( area.get( 1 ) ) );
		if( !area.get( 2 ).equals( "none" ) ) checklist.put( BlockFace.NORTH_EAST, Material.getMaterial( area.get( 2 ) ) );
		if( !area.get( 3 ).equals( "none" ) ) checklist.put( BlockFace.EAST      , Material.getMaterial( area.get( 3 ) ) );
		if( !area.get( 4 ).equals( "none" ) ) checklist.put( BlockFace.SOUTH_EAST, Material.getMaterial( area.get( 4 ) ) );
		if( !area.get( 5 ).equals( "none" ) ) checklist.put( BlockFace.SOUTH     , Material.getMaterial( area.get( 5 ) ) );
		if( !area.get( 6 ).equals( "none" ) ) checklist.put( BlockFace.SOUTH_WEST, Material.getMaterial( area.get( 6 ) ) );
		if( !area.get( 7 ).equals( "none" ) ) checklist.put( BlockFace.WEST      , Material.getMaterial( area.get( 7 ) ) );
		if( !area.get( 8 ).equals( "none" ) ) checklist.put( BlockFace.NORTH_WEST, Material.getMaterial( area.get( 8 ) ) );
		
		return checklist;
	}
	
	public VoodooRitual getRitual() {
		VoodooRitual ritual = new VoodooRitual();
		Inventory inventory = chest.getInventory();
		
		log( "---Voodoo Analysis---" );
		
		ritual.setType( VoodooRitual.Type.CONVERSION );
		
		if( inventory.contains( Material.SULPHUR) ) 
			ritual.setType( VoodooRitual.Type.THUNDER );

		return ritual;
	}
	
	public boolean isVoodooChest() {
		Block middle = chest.getBlock();
		Block top    = middle.getRelative( BlockFace.UP );
		Block bottom = middle.getRelative( BlockFace.DOWN );
		
		return checkArea( top, checkListTop) & checkArea( middle, checkListMiddle ) & checkArea( bottom, checkListBottom );  
	}
	
	private boolean checkArea( Block block, HashMap<BlockFace,Material> checklist ) {
		boolean isOK = true;
		
		for( BlockFace face: checklist.keySet() ) {
			Material material = checklist.get( face );
	
			if( block.getRelative( face ).getType() != material ) {
				isOK = false;
				break;
			}
		}
		
		return isOK;
	}
	
	public void convertMaterials( Material source, Material destination, int ratio ) {
		Inventory inventory = chest.getInventory();
		
		int sCount = 0;
		for( ItemStack stack: inventory.getContents() ) {
			if( stack != null && stack.getType() == source ) {
				sCount += stack.getAmount();
			}
		}
		
		int dCount = sCount / ratio;
		int rCount = sCount - dCount * ratio;
		
		if( dCount > 0 ) {
			log( "  Converting " + (dCount*ratio) + " of " + source + " into " + dCount + " " + destination );
			
			removeMaterial( source );
			addMaterial( destination, dCount );
			addMaterial( source, rCount );
		}
	}
	public void removeMaterial( Material material ) {
		Inventory inventory = chest.getInventory();
		
		inventory.remove( material );
	}
	
	public void addMaterial( Material material, int amount ) {
		Inventory inventory = chest.getInventory();
		
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
