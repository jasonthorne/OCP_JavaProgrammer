package com.android;

public class Examples {
	static void ex1() {
		/*
		 * Singleton pattern
		 * create a single object that is shared across multiple classes. this
		 * can remove a large amount of confusion (several different objects
		 * that are essentially the same object but can have different 
		 * properties)
		 * in our case a HayStorage and a MeatStorage object.
		 * Our zoo has Animals and ZooKeepers and each of these classes 
		 * uses the same HayStorage and MeatStorage object to keep track of
		 * how much hay and meat we have in stock. We can add meat and hay, and
		 * we can take away meat and hay
		 * we can do the exact same process for the stock in shop
		 * singleton remove the need to pass around the object
		 */
		System.out.println("SINGLETON PATTERN");
		//this creates the HayStorange instance object inside the HayStorage class
		HayStorage.getInstance();
		//this merely access the HayStorage instance object already created
		HayStorage.getInstance();
		HayStorage.getInstance();
	//	HayStorage.statMethod();
	//	HayStorage.statMethod();
	}

}
