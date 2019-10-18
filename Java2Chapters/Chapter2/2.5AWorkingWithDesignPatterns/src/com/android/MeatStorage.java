package com.android;

public class MeatStorage {
	/*
	 * creating our MeatStorage Singleton reference and using a static initalisation block to give it a 
	 * value
	 */
	private static final MeatStorage instance;
	static {
		System.out.println("creating our MeatStorage singleton in a static initialiser");
		//calling our private MeatStorage constructor
		instance=new MeatStorage();
		/*
		 * this is allowed, but you can only access this instance variable inside of this initialiser
		 */
		int num=6;
		/*
		 * this is NOT allowed as statNum is only available inside this block of code and you can't have a 
		 * "local" static variable. A static variable is a CLASS variable which means it's not tied to any
		 * individual object and there is only one of them per class and if you could do this you could not go
		 * MeatStorage.statNum as this can't be accessed outside of this curly brackets
		 */
	//	static int statNum=6;
	}
	
	private MeatStorage() {
		System.out.println("MeatStorage object created");
	}
	
	public static MeatStorage getInstance() {
		return instance;
	}

}
