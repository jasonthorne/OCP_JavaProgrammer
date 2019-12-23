package com.android.humans;

public class Fireman {
	private String name;
	private int id;
	//used to given firemen an id
	private static int counter=0;
	//constructor that takes a string
	public Fireman(String name) {
		this.name=name;
		counter++;
		id=counter;
	}
	//blank constructor
	public Fireman() {
		counter++;
		id=counter;
	}
	
	@Override
	public String toString() {
		return "fireman name is "+name+" id is "+id;
	}

}
