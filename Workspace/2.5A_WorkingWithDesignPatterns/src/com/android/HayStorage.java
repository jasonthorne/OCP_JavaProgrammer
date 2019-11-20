package com.android;

public class HayStorage {
	
	//this will show how many hayStorage objects have been created
	static int counter=0;
	int id; //uniquely id the singleton.
	//non static initialiser. Runs evertime a HayStorage object is created. it runs BEFORE constructor
	{
		System.out.println("non static initialiser called"); //runs everytime a HayStorage obj is created 
	}
	
	/*
	 * the amount of hay we have in store in any one time.
	 * We will start off with the quantity of 100. 
	 * We could get this initial value from a db to start off at start of day, and the value at the end of the day will be stored in the db.
	 * This is the quantity at the start of the day. 
	 */
	private int quantity = 100; 
	
	
	/*
	 * A private constructor ensures that you cant create a new singleton object outside of the class. 
	 * As this is now the ONLY way to create a Haystorage object, we cant create a HayStorage object directly outside of the class. 
	 */
	private HayStorage() {
		//If this is a true singleton, we should only see this message once.
		System.out.println("Haystorage object created");
		counter++; //Implements the counter and sets the id of the singleton. So if the id of the singleton is more than 1, it means more than 1 obj has been created.
		id=counter;
	}
	
	
	/*
	 * this is a final object, which means you cant change what the instance object refers to. It will always refer to the same HayStorage() object instance.
	 * However we can change the vars of a final object, so we CAN change quantity of the HayStorage object. 
	 * Here we are instansiating the HayStorage singleton directly.
	 * It's private, which means we cant access it ourtside of the class. 
	 * It's static, which means when we poke the class for the first time, this static will be given a value, however this happens ONCE and obly ONCE,
	 *  as this is a static initialised value it will run the first time the class is accessed in any way and will  NOT run again. 
	 *  
	 *  Another rweason to make it static, is you cant create an instance outside this class, so we cant access this variable via an instance method. 
	 *  As instance methods can only be accessed by objects of the HayStorage class.
	 *  So we are accessing this via a static method. 
	 */
	private static final HayStorage instance = new HayStorage();
	
	/*
	 * When accessing by atyatic method for the first time, we go:
	 * HayStorage.instance()
	 * this causes ALL statics inthis class to be given values, including our dude here: private static final HayStorage instance = new HayStorage();
	 * 
	 * Every subsequent call of HayStorage.instance() will NOT cause the statics to be given values, it will use whatever values the static currently have.
	 * 
	 * Your singleton has to have 3 things to work:
	 * Constructor needs to be private,
	 * You have to vcreate an obj of the class inside the singleton class that is: priavte, static and final
	 * You have to have a static method that access the private static final variavle (first time it runs it will create a singleton. Other times it doesnt)
	 */
	
	
	public static HayStorage getInstance() {
		System.out.println("getInstance() called");
		System.out.println("id of object is: " + counter); //this will show the amount of objects created. 
		return instance;
	}
	
	
	//this initialiser can only access statics directly, and will ALWAYS only run once. ANY interaction with the hayStorage class for the first time will cause this initialiser to run.
	static { //ALWAYS runs ONLY once.
		System.out.println("Static initialiser called");
	}
	
	//-----------------
	
	/*
	 * This method adds more hay to the qty of hay already in the hay storage obj.
	 * Syncronized is for use in threads and ensures that mo 2 threads can access the same method at the same time. 
	 */
	public synchronized void addHay(int amount) {
		System.out.println(amount+ " hay added");
		quantity+=amount;
	}
	
	
	/*
	 * when a zookeeper removes some hay, this method is called. If the need is > quantity, then this will return false. 
	 */
	public synchronized boolean removeHay(int amount) {
		
		if(quantity<amount) {
			System.out.println("There is not anough hay in the store for the amount requested");
			return false;
		}else { //if qty to be removed dosent exceed the amount of hay then remove and return true.
			quantity-=amount;
			System.out.println(amount+ " removed");
			return true;
		}
	}
	
	//--------------
	
	static void statMethod() {
		System.out.println("StatMethod called");
	}
	
	
	
	
	
	
	
	
}
