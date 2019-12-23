package com.android;
/*
 * this is a class that is made purely out of a other objects, so this class
 * if made purely out of OBJECT COMPOSITION
 */
public class Penguin {
	private Flippers myFlippers[];//a penguin has two flippers
	private WebbedFeet myWebbedFeet[];//a penguin has two webbedFeet
	
	Penguin(){
		//an array of two flippers
		myFlippers=new Flippers[]{new Flippers(),new Flippers()};
		myWebbedFeet=new WebbedFeet[] {new WebbedFeet(),new WebbedFeet()};
				
	}
}//end of Penguin class

class Flippers{
	
	public void flap() {
		System.out.println("flapping my flippers to swim");
	}
}//end of Flipper class

class WebbedFeet{
	public void kick() {
		System.out.println("kicking feet to swim");
	}
}//end of WebbedFeet class
