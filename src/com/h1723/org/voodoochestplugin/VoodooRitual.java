package com.h1723.org.voodoochestplugin;

import java.util.HashMap;

public class VoodooRitual {
	public enum Type {
		NONE,
		CONVERSION,
		THUNDER
	}
	
	Type ritualType = Type.NONE;
	
	private HashMap<String,String> props;
	
	public VoodooRitual() {
		props = new HashMap<String,String>();
	}
	
	public void setName( String value ) {
		setProp( "name", value );
	}
	
	public String getName() {
		return getProp( "name" );
	}
	
	public void setType( Type type ) {
		ritualType = type;
	}
	
	public Type getType() {
		return ritualType;
	}
	
	public void setProp( String name, String value ) {
		props.put( name, value);
	}
	
	public String getProp( String name ) {
		String value = null;
		if( props.containsKey( name ) ) {
			value = props.get( name );
		}
		
		return name;
	}
	
	public String toString() {
		String output = "";
		
		if( ritualType == Type.NONE ) output += "None";
		if( ritualType == Type.CONVERSION ) output += "Conversion";
		if( ritualType == Type.THUNDER ) output += "Thunder Maker";
		
		return output;
	}

}
