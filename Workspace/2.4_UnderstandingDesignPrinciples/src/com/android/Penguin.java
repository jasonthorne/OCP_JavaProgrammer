package com.android;


/*
 * This is a class that is purely made out of other objects, so this class is made purely of OBJECT COMPOSITION
 */

public class Penguin {
	
	private Flippers myFlippers[]; //a penguin has 2 flippers
	private WebbedFeet myWebbedFeet[]; //a penguin has 2 webbed feet
	
	Penguin(){
		myFlippers=new Flippers[]{new Flippers(),new Flippers()};
		myWebbedFeet = new WebbedFeet[]{new WebbedFeet(),new WebbedFeet()};
	}

}


class Flippers{
	public void flap() {
		System.out.println("flapping my flippers to swim");
	}
}


class WebbedFeet{
	public void kick() {
		System.out.println("kicking feet to swim");
	}
}