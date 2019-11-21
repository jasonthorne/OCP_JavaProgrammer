package com.android;

public class Examples {
	static void ex1() {
		
		/*
		 * Singleton pattern.
		 * Create a single object that is shared amongst multiple classes. 
		 * This can remove a large amount of confusion (several different objects that are essentially the same object but can have different properties).
		 * In our case a HayStorage and a MeatStorage object. 
		 * Our zoo has Animals and ZooKeepers and each of these classes uses the same HayStorage and MeatStorage object to keep track of how much meat and hay we have in stock.
		 * We can add meat and hay, and we can take away meat and hay.
		 * We can do the exact same process for the stock in a shop.
		 * Singleton removes the need to pass around the object.
		 */
		
		System.out.println("SINGLETON PATTERN");
		
		//HayStorage.statMethod(); //no object of this class has been created, however it's static initialiser is triggered by this static method call
		
		//HayStorage.getInstance(); //creates HayStorage instance obj
		//HayStorage.getInstance(); //merely accesses the instance object already created.
		
		ZooKeeper zed = new ZooKeeper();
		zed.feedElephant(10);
		zed.feedElephant(20);
	}

}
