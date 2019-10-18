package com.android;
/*
 * JavaBean is a standard for creating classes taht store data and adhere to the principles of the Encapsulation
 * The rules are as follows:
 * Properties are private
 * getter for non boolean properties begin with "get"
 * getter for boolean properties may begin with "is" or "get"
 * setter method begins with set
 * the method name for a getter or setter must have a prefix of set/get/is followed by the first letter of 
 * property in uppercase by the rest of the property name
 * this is just a standard that is used widely in software developement, eclipse does most of this automatically
 * for you
 */
public class JavaBean {
	private boolean playing;
	private int id;
	private double weight;
	private Boolean running;
	
	//playing is a boolean so we use get or is
	public boolean isPlaying() {
		return playing;
	}

	public double getWeight() {
		return weight;
	}
	//this is a BOOLEAN wrapper object so the correct format is getRunning()
	public Boolean getRunning() {
		return running;
	}
}
