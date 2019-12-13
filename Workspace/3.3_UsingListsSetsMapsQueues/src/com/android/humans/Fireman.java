package com.android.humans;

public class Fireman {
	
	private String name;
	private int id;
	private static int counter = 0;
	
	public Fireman(String name) {
		this.name=name;
		counter++;
		id=counter;
	}
	
	@Override
	public String toString() {
		return "fireman name is: " + name + ". id is: " + id;
	}
	
	public Fireman() {
		counter++;
		id=counter;
	}
	
}
