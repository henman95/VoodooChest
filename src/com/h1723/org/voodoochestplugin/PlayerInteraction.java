package com.h1723.org.voodoochestplugin;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class PlayerInteraction extends VoodooBase implements Listener {
	
	public PlayerInteraction( VoodooChestPlugin instance ) {
		super( instance );
		
		instance.getServer().getPluginManager().registerEvents( this, plugin );
	}
	
	@EventHandler()
	public void onPlayerInteract( PlayerInteractEvent event ) {
		Player player = event.getPlayer();
		Block  block  = event.getClickedBlock();
		Action action = event.getAction();
		
		if( action == Action.RIGHT_CLICK_BLOCK ) {
			if( block.getType() == Material.CHEST ) {
				
				VoodooChest chest = new VoodooChest( (Chest)block.getState(), getPlugin() );
				
				if( chest.isVoodooChest() ) {
					performRitual( player, chest );
				}
			}
		}
	}
	
	private void performRitual( Player player, VoodooChest chest ) {
		VoodooRitual ritual = chest.getRitual();
		
		log( "Ritual : " + ritual );
		
		if( ritual.getType() == VoodooRitual.Type.CONVERSION ) {
			chest.convertMaterials( Material.GRAVEL, Material.DIRT, 2 );
			chest.convertMaterials( Material.COAL  , Material.DIAMOND, 4 );
		}
		
		if( ritual.getType() == VoodooRitual.Type.ANGER ) {
			player.chat( "You have angered the Gods" );
			log( "You have angered the Gods" );
			
			//chest.emptyMaterials();
			
			
			
			//player.setFireTicks( 100 );
			World world = player.getWorld();
			
			Location pLocation = player.getLocation();
			Location cLocation = chest.getLocation();
			
			
			Double delta;
			Double dX = 0.0;
			Double dY = 0.0;
			Double margin = 0.3;
			
			
			delta = cLocation.getX() - pLocation.getX();
			if( delta >  margin ) dX =  1.0;
			if( delta < -margin ) dX = -1.0;
			
			delta = cLocation.getY() - pLocation.getY();
			if( delta >  margin ) dY =  1.0;
			if( delta < -margin ) dY = -1.0;
	
			log( "dX " + dX );
			log( "dY " + dY );
			
			
			Location sLocation = new Location(world, cLocation.getX() + dX * -2, cLocation.getY() + dY * -2, pLocation.getZ() );
			
			log( pLocation.toString() );
			log( cLocation.toString() );
			log( sLocation.toString() );
			
			Block block = world.getBlockAt( sLocation );
			
			block.setType( Material.GRAVEL );
			//world.spawnCreature( sLocation, CreatureType.CHICKEN );
			//player.setFireTicks( 100 );
			//world.createExplosion( pLocation, (float) 0.5 );
			world.strikeLightningEffect( pLocation );
			
		}
		
		if( ritual.getType() == VoodooRitual.Type.THUNDER ) {
			log( "BOOOOM" );
			
			//getPlugin().getServer().getWorld( "World" ).setThunderDuration( 1000 );
		}
		
		if( ritual.getType() == VoodooRitual.Type.CREATEWOODEQUIPMENT ) {
			player.chat( "You have given the Gods wood and shaw be rewarded" );
			
			chest.emptyMaterials();
			chest.addMaterial( Material.WOOD_AXE, 1 );
			chest.addMaterial( Material.WOOD_HOE, 1 );
			chest.addMaterial( Material.WOOD_PICKAXE, 1 );
			chest.addMaterial( Material.WOOD_SWORD, 1 );
			chest.addMaterial( Material.WOOD_SPADE, 1 );
			chest.addMaterial( Material.WOOD, 2 );
			chest.addMaterial( Material.STICK, 1 );	
		}
	}
}

