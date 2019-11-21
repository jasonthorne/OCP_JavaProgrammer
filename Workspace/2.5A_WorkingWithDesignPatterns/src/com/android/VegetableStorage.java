package com.android;

/*
 * VegetableStorage uses lazy instantiation of a singleton.
 * which is delaying the instantiation of the singleton until the static getInstance() method is called.
 */

public class VegetableStorage {
	
	/*
	 * A singleton using lazy instantiation CANNOT be final.
	 * Cant be final as only make final if you can definitely say that this variable will be given a value.
	 * We are relying on the getInstance method to give value to this variable. 
	 * If you are relying on a method call to give a value to a variable it means that this variable MIGHT NOT be given a value.
	 * As the method might not be called. 
	 */
	private static VegetableStorage instance;
	
	private VegetableStorage() {
		System.out.println("VegetableStorage object created");
	}
	
	/*
	 * If the method is not synchronised, then its not thread safe. THis ensures that it is a UNIQUE SINGETON.
	 */
	
	public static synchronized VegetableStorage getInstance() {
		
		/*
		 * first time we call this method, instance will be null. So if instnace is null, it will create our vegetable storage singleton. 
		 * Otherwise it's not null, and will return the VegetableStorage singleton that is already created.
		 */
		if(instance==null) {
			System.out.println("lazy instantiation of the VegetableStorage singleton");
			instance = new VegetableStorage();
		}
		return instance;
	}
	
	
	public static VegetableStorage getInstance2() {
		
		if(instance==null) {
			/*
			 * we will use the following syntax to put a lock on the object so it cant be accessed by another thread.
			 */
			synchronized(VegetableStorage.class) { //locks this object ("class") "VegetableStorage.class"
				if(instance==null) {
					instance = new VegetableStorage();
				}
			}//lock ends
		}
		
		return instance;
	}//end of method
	
	
	public void addVegetables(int amount) {
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
