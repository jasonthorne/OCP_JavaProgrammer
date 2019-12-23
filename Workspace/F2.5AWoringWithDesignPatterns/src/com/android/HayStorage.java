package com.android;

public class HayStorage {
	//this will show how many HayStorage objects have been created
	static int counter=0;
	int id;//uniquely identify the singleton
	//non static initialiser runs every time a HayStorage object is created
	//runs BEFORE constructor, we have this to show that only ONE HayStorage
	//object is created
	{
		System.out.println("non static initialiser called");
	}
	/*
	 * this initialiser can only access statics directly and will ALWAYS onlye
	 * run ONCE. Any interaction with the HayStorage class, for the first time,
	 *  will cause this initialiser to run
	 */
	static {
		System.out.println("static initialiser called");
	}
	/*
	 * the amount of Hay we have in store at any one time.
	 * we will start off with the quantity of 100 (we could get this initial
	 * value from a database to start off at start of the day and the value
	 * at the end of the day will be stored in the database)
	 * this is the quantity at the start of the day
	 */
	private int quantity=100;
	/*
	 * private constructor ensures we can't create a new singleton object 
	 * outside of the class. As this is now the ONLY way to create a HayStorage
	 * object we can't create a HayStorage object directly outside of the class
	 */
	private HayStorage() {
		//if this is a true singleton, we should only see this message ONCE
		System.out.println("HayStorage object created");
		/*
		 * this increments our counter, and sets the id of singleton to be
		 * whatever the counter is. so if the id of the singleton is more than
		 * 1, its means more than one object has been created and it's 
		 * not a singleton
		 */
		counter++;
		//id should be 1
		id=counter;
	}
	/*
	 * this is a final object, which means you can't change what the instance
	 * object refers too. it will always refere to the same HayStorage()
	 * object instance. However we can change the the vaiables of a Final
	 * object, so we CAN change the quantity of the HayStorage object.
	 * here we are instantiating the HayStorage singleton directly.
	 * it private, which means we can't access it outside of the class, so
	 * we won't be able to modify it outside of the class. Its static so
	 * when we access the class, for the very first time, this static will
	 * be given a value, however this happens ONCE and only ONCE. as this is a
	 * static initialised value it will run the first time the class is accessed
	 * in any way. this will NOT run again.
	 * another reason to make it static is you can't create an instance outside
	 * of this class, so we can't access this variable via an instance method,
	 * as instance methods can only be access by objects of the HayStorage class.
	 * So we are accessing this via a static method
	 */
	private static final HayStorage instance=new HayStorage();
	/*
	 * when accessing via a static method,for the first time, we go
	 * HayStorage.getInstance()
	 * this causes ALL the statics in this class to be given values, including
	 * private static final HayStorage instance=new HayStorage();
	 * every subsequent call of 
	 * HayStorage.getInstance() 
	 * will NOT cause the statics in the class to be given values, it will
	 * use whatever values the statics currently  have
	 * your singleton needs to have three things to work
	 * **Constructor must be private
	 * **you have to create an object of the class inside the singleton class
	 * that is private static and final
	 * **you have to have a static method that access the private static final
	 * variable (first time it runs it will create singleton, subsequent times
	 * it is run it will just access the singletong
	 */
	public static HayStorage getInstance() {
		System.out.println("getInstance called");
		//this wil show amount of objects created
		System.out.println("id of object is "+counter);
		return instance;
	}
	/*
	 * this method adds more hay to the quantity of hay already in the 
	 * HayStorage object.
	 * synchronized is for use in Threads and ensures that no two threads can
	 * access the same method at the same time
	 * (threads are covered in chapter 7, threads are lines of control 
	 * that run through your program,
	 * up to this we have used singles threads, but you can have multiple 
	 * lines of control going through your
	 * program at the one time).
	 * this also means that the object calling this method is 
	 * locked and can't be accesed by other methods when 
	 * this method is in progress, meanin the amount can't be 
	 * modified while this method is using the object.
	 * If a static method is synchronized it means that the static 
	 * variables and static methods used by it are 
	 * locked, NOT the non static variables and not static methods
	 */
	public synchronized void addHay(int amount) {
		System.out.println(amount+" hay added");
		quantity+=amount;	
	}
	/*
	 * when a zookeeper gives some hay to one of the Animals this method 
	 * is called. If the amount the Zookeeper wants to use is greater than the
	 * quantity of hay in our shed, then this will return false and the 
	 * Zookeeper will not be allowed to take out that amount of Hay.
	 * 
	 */
	public synchronized boolean removeHay(int amount) {
		if(quantity<amount) {
			System.out.println("there is not enough hay in the store for "
					+ "the amount requested");
			return false;
		}
		/*
		 * if the amount of ahy the zookeeper wants does NOT EXCEED the amount
		 * of hay in the shed then he takes that amount from the hay in the
		 * shed and returns true
		 */
		quantity-=amount;
		System.out.println(amount+" hay removed");
		return true;
	}
	
	
	static void statMethod() {
		System.out.println("statMethod called");

	}

}
