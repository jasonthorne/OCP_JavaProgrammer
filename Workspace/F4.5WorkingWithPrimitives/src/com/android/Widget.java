package com.android;

public class Widget {
	
	enum Colour{
		RED,BLUE,GREEN,BLACK,WHITE
	}
	
	private Colour colour;
	private int weight;
	
	public Colour getColour() {
		return colour;
	}

	public int getWeight() {
		return weight;
	}

	Widget(Colour colour,int weight){
		this.colour=colour;
		this.weight=weight;
	}

}
