package com.android;
/*
 * JavaBean is a standard for creating classes that store data and adhere to
 * the principles of Encapsulation.
 * the rules are as follows:
 * properties are private
 * getter for properties and getters for not boolean properties begin with the
 * word "get"
 * getter for boolean properties may begin with "is" or "get"
 * setter methods begin with set
 * the method name for a getter or setter must have a prefix of set/get/is followed
 * by the first letter of the property in uppercase and rest of the property name
 * in lowercase
 * This is just a standard that is used widely in sofware development, eclipse
 * does most of this naturally for you.
 */
public class JavaBean {
//all properties private
	private boolean playing;
	private int id;
	private double weight;
	//this is a Boolean WRAPER OBJECT, so the correct getter is getRunning()
	private Boolean running;
	//playing is a boolean so we can use get or is
	public boolean isPlaying() {
		return playing;
	}
	
	public double getWeight() {
		return weight;
	}
	//this is a Boolean WRAPPER OBJECT, so it is GET, not is
	public boolean getRunning() {
		return running;
	}
}
