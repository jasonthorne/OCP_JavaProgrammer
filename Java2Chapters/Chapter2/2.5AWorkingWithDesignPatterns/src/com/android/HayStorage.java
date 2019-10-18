package com.android;

public class HayStorage {
	static int counter=0;
	int id;
	{
		System.out.println("non static intialiser called");
	}
	
	static {
		System.out.println("static initialser created");
	}
	/*
	 * the amount of hay we have in store at any one time
	 * we will start off with a quantity of 100 (we could get this intial value from a database to start off if
	 * we desire and at the end of the day this value will be stored in the database so this new value will be used
	 * again at the start of the next day)
	 */
	private int quantity=100;
	/*
	 * private constructor ensures we can't create a new singleton object outside of the class as this is the 
	 * only way to create a HayStorage obejct, which means we can't create a HayStorage object directly outside
	 * of this class
	 */
	private HayStorage() {
		System.out.println("HayStorage object created");
		counter++;
		id=counter;	}
	/*
	 * this is a final object which means you can't change what the myHay object refers to.
	 * it will aways refer to the same HayStorage() object instance. However we can change the variables
	 * of a final object, so we CAN change the quantity of this HayStorage object
	 * here we are instantiated the HayStorage singleton directly
	 * As you can't create an instance of this class outside of HayStorage, we can't access this variable via a
	 * instance method, as instance methods only word if we can create a instance of class. So we can only access
	 * this variable through a static method. we dont' need to create a member of the HayStorage class to then
	 * access this variable
	 */

	private static final HayStorage instance=new HayStorage();//you can call the variable anything you like
	/*
	 * this will return the singleton that we cannot change 
	 */
	public static HayStorage getInstance() {
		return instance;
	}
	/*
	 * This method adds the more hay to the amount of hay we have
	 * synchronized is for use in threads and ensures that no two threads can access the same method at the 
	 * same time (threads are covered in chapter 7, threads are lines of control that run through your program,
	 * up to this we have used singles threads, but you can have multiple lines of control going through your
	 * program at the one time).
	 * this also means that the object calling this method is locked and can't be accesed by other methods when 
	 * this method is in progress, meanin the amount can't be modified while this method is using the object.
	 * If a static method is synchronized it means that the static variables and static methods used by it are 
	 * locked, NOT the non static variables and not static methods
	 */
	public synchronized void addHay(int amount) {
		System.out.println(amount+"Hay added");
		quantity+=amount;
	}
	/*
	 * When a zookeeper gives some hay to one of the Animals this method is called.
	 * if the amount the zookeeper wants to use is greater than the quantity of hay in the our store, then this will 
	 * return false and the Zookeeper will not be allowed to take out that amount of Hay
	 */
	public synchronized boolean removeHay(int amount) {
		if(quantity<amount) {
			System.out.println("there is not enough hay in the store for the amount you requested");
			return false;
		}
		/*
		 * if the amount of hay the zookeeper wants does not exceed the amount of hay in the store then he 
		 * takes that amount of hay from the amount of hay in the store
		 */
		quantity-=amount;
		System.out.println(amount+" hay removed");
		return true;
	}
	/*
	 * return the quantity of hay in the store
	 */
	public synchronized int getHayQuantity() {
		return quantity;
	}
	
	public static void method1() {
		System.out.println("doing anying with the class creates the statics in the class");
	}
	
	
	


}

	



