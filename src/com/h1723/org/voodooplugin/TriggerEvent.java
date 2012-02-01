package com.h1723.org.voodooplugin;

import org.bukkit.block.Block;
import org.bukkit.event.player.PlayerInteractEvent;

public class TriggerEvent {
	private String name;
	private Block target;
	private PlayerInteractEvent piEvent;
	
	public TriggerEvent() {
		name    = "";
		target  = null;
		piEvent = null;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName( String name ) {
		this.name = name;
	}
	
	public PlayerInteractEvent getPlayerInteractEvent() {
		return piEvent;
	}
	
	public void setPlayerInteractEvent( PlayerInteractEvent event ) {
		piEvent = event;
	}
	
	public Block getTarget() {
		return target;
	}
	
	public void setTarget( Block block ) {
		target = block;
	}
	
	
}
