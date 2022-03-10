package com.scaler.conding.interview;

public final class CustomImmutableClass {
	
	private final int id;
	private String name;
	
	public CustomImmutableClass(int id, String name ) {
		this.id = id;
		this.name = name;
		
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	
	
	
}
