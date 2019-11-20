package com.android;

public class ZooKeeper {

	/*
	 * method that will use the hay storage singleton to see if we have enough feed for each of our elephants.
	 * Count is the amount of elephants we have to feed.
	 * Will return true if enough hay in shed, and the elephants are fed. False if not.
	 */
	
	public boolean feedElephant(int count) {
		
		/*
		 * each elephant eats 5 bales of hay a day, so amount *5 is the amount of bales we need for the day.
		 */
		int amountNeeded = count*5;
		
		/*
		 * below may or may not create our hay storage object. 
		 * If its the first time the hayStorage class is being accessed, then it is, otherwise its just accessing the same obj.
		 */
		HayStorage hayStorage = HayStorage.getInstance(); 
		
		return false;
	}
}
