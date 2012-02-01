package com.h1723.org.voodooplugin;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class BoneTrigger extends BaseTrigger {
	
	public BoneTrigger( VoodooEngine engine ) {
		super( engine, "bonetrigger" );
		
		log( 3,  "  You go  " + getName() );
	}

	@EventHandler()
	public void onPlayerInteract( PlayerInteractEvent event ) {
		Action action = event.getAction();
		Block  block  = event.getClickedBlock();
		Player player = event.getPlayer();
		
		if( action == Action.LEFT_CLICK_BLOCK )
			if( block.getType() == Material.LOG )
				if( player.getItemInHand().getType()== Material.BONE ) {
					TriggerEvent tevent = new TriggerEvent();
					
					tevent.setPlayerInteractEvent( event );
					tevent.setTarget( event.getClickedBlock() );
					
					trigger( tevent );
				}
			
	}
	
}
