package com.android;

/*
 * JavaBean is a standard for creating classes that store data and adhere to the principles of Encapsulation.
 * 
 * The rules are as follows:
 * + Properties are private
 * + getter for properties and getters for non boolean properties begin with the word "get"
 * + getter for boolean properties may begin with "is" or "get"
 * + setter methods begin with set
 * The mathod name for a getter or setter must have the prefix of set/get/is followed by the first letter of the property in uppercase and rest of the property in lowercase
 * This is just a standard that is used widely in sw dev.
 */

public class JavaBean {
	
	//all properties private
	private boolean playing;
	private int id;
	private double weight;
	private Boolean running; //this is a boolean WRAPPER OBJECT, so the correct getter is getRunning()
	
	//playing is a boolean
	public boolean isPlaying() {
		return playing;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public boolean getRunning() {
		return running;
	}
	

}
