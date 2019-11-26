package com.android;

public class MeatStorage {
	
	/*
	 * create out meatStorage singleton reference and using a static initialisation block to give it a value.
	 */
	
	//this is final, so needs a value
	private static final MeatStorage instance;
	static {
		
		/*
		 * If you want to do something before you give this a value =, i.e get values from a db or do some calculation base on some other value.
		 */
		System.out.println("Creating our MeatStorage singlton in a static initialiser");
		instance=new MeatStorage(); //this initialises our private static final MeatStorage variable
	}
	
	private MeatStorage() {
		System.out.println("MeatStorage object created.");
	}
	
	public synchronized void addMeat(int amount) {
		
	}
	
	public static MeatStorage getInstance() {
		System.out.println("getInstance ");
		return null;
	}

}
