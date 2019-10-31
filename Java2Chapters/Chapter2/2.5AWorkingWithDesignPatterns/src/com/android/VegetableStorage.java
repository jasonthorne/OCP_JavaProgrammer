package com.android;
/*
 * VegetableStorage uses Lazy Instantiation of Singleton
 * which is delaying the instantiation of the singleton until the static getInstance() method is called
 */
public class VegetableStorage {
	
	/*
	 * can't make this final, as can only make it final if you can DEFINATELY SAY that this variable will
	 * be given a value.
	 * If you are relying on a method call to give a value to a variable, it means that this variable might 
	 * not be given a value as the method might not be called
	 */
	private static VegetableStorage instance;
	/*
	 * can't create a instance of this class outside of the class
	 */
	private VegetableStorage() {
		System.out.println("VegetableStorage Object Created");
	}
	/*
	 * if our method calls is NOT synchronized then this is not thread safe as two different threads could then
	 * call the same method at the same time and this could result in two different singletons being created
	 * synchronized ensures that this is a UNIQUE SINGLETON
	 */
	public static synchronized VegetableStorage getInstance() {
		/*
		 * first time we call this method instance will be null, so if instance is null it will create our
		 * VegetableStorage singletion, otherwise if it's not null will return the VegetableStorage singletion that
		 * is already created
		 */
		if(instance==null) {
			System.out.println("lazy instantiation of the VegetableStorage singleton");
			instance=new VegetableStorage();
		}
		return instance;
	}
	/*
	 *  * in practise the above method can be a memory intensive as you only really
	 * have to call synchronisation for the above when first creating the singleton object
	 * we do this by the following, as if we used the getInstance method a few thousand time
	 * that means with the previous  version we would have to use synchronised methods thousands
	 * of times as opposed to this just a few times when first creating a singleton
	 * THIS IS CALLED DOUBLE CHECKED LOCKING AND IS NOT ON THE EXAM
	 * see the link
	 * https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples
	 * for additional ways to create a singleton
	 */
	public static VegetableStorage getInstance2() {
		if(instance == null) {
			/*
			 * we use the following syntax if we want a static method to put a lock on the object so it 
			 * cannot be accessed by another thread, this is much more efficient than using synchronized for 
			 * the whole method. so the synchronization will only happen first time when our instance a value of 
			 * null
			 */
			synchronized(VegetableStorage.class) {
				if(instance == null) {
					instance = new VegetableStorage();
				}
			}
		}
		return instance;
	}
	/*
	 * if we synchronizing a block of code inside a instance method we use this syntax
	 */
	public VegetableStorage thisInstance() {
		/*
		 * refers to this object that has a lock and is thread safe and cannot be accessed by another thread
		 */
		synchronized(this) {
			System.out.println("whatever code you have in here is thread safe");
		}
		return instance;
	}
	
	ZooKeeper zebbie=new ZooKeeper() {
		
	};
	

}
