package com.android;

public class Seagull implements Comparable<Seagull>{
	private String name;
	
	Seagull(String name){
		this.name=name;
	}

	@Override
	public int compareTo(Seagull s) {
		//calls the compareTo() method of the String class
		return name.compareTo(s.name);
	}

	@Override
	public String toString() {
		return "Seagull [name=" + name + "]";
	}


}
