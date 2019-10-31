package com.android;

import java.util.concurrent.SynchronousQueue;

public class Examples {
	/*
	 * Singleton Pattern
	 * create a single object in memory  that is
	 * shared accross multiple classes. this can remove a large amount of confusion (several different objects that 
	 * are essentially the same object but can have different properties)
	 * in our case a HayStorage object and a MeatStorage object
	 * our Zooe and each of the Animal classes uses the same HayStorage and MeatStorage object to keep track of 
	 * how much hay and meat we have in stock.
	 * Singleton removes the need to pass around the object
	 */
	static void ex1() {
		System.out.println("****Singleton Pattern");
		/*
		 * our HayStorage class and MeatStorage class are used to created our singleton object
		 * the first time we use any static method in a class, all the statics are created
		 * so this creates a new HayStorage object, if we comment out these two HayStorage references the 
		 * object is created when the ZooKeeper zed calls the feedElephant() method
		 */
		HayStorage hayStorage=HayStorage.getInstance();
		/*
		 * so even if we have a new reference it's still referring to the same static HayStorage object
		 * not how the static intialiser, intialisers and constructors are all only called once
		 * even the object referred to in ZooKeeper method feedElephant(), where we reference a HayStorage object, 
		 * this is the same object as this HayStorage object
	
		 */
		HayStorage hayStorage2=HayStorage.getInstance();
		
		ZooKeeper zed=new ZooKeeper();
		
		
		zed.feedElephant(10);
		/*
		 * we can use any reference to access the amount of hay in the store, but this is still the same store
		 * of hay we are referring too
		 */
		System.out.println("amount of hay in store is "+hayStorage2.getHayQuantity());	
		/*
		 * it's possible to use some inheritance as long as you remember that you can't inherit private members
		 * and you can't override static methods (although sub classes do have access to public static members of 
		 * the super class, if we have a static method of the same method signature in the sub class then the
		 * sub class object will use that static method). you could have your base class as abstract or you could 
		 * have a base class that is NOT a singleton the classes that inherit are Singletons. Frameworks such as
		 * Spring can manage your singletons for you, and very good at doing it they are too.
		 */
	}
	
	static void ex2() {
		System.out.println("*****SINGLETON 2");
		/*
		 * calling this static method creates the all the statics variables in the class
		 * So our final static Haystorage singleton is created when we call this method
		 */
		HayStorage.method1();
		/*
		 * this is getting the existing HayStorage singleton and assigning it to the myHayStorage objec
		 */
		HayStorage myHayStorage=HayStorage.getInstance();
		
		System.out.println("Quantity of hay in store is "+myHayStorage.getHayQuantity());
		
		/*
		 * the MeatStorage singleton is initialised in a static initialisation block
		 */
		MeatStorage myMeatStorage=MeatStorage.getInstance();
		/*
		 * VegetableStorage uses Lazy Instantiation of Singleton
		 * which is delaying the instantiation of the singleton until the static getInstance() method is called
		 */
		
	}
	
	static void ex3() {
		System.out.println("****CREATING IMMUATBLE OBJECTS");
	}

}
