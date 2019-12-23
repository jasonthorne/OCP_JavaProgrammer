package com.android;

public class ZooKeeper {
	/*
	 * method that will use the HayStorage singleton to see if we have
	 * enough feed for each of our elephants.
	 * count is the amount of elephants we have to feed
	 * will return true if enough hay in shed and the elephants are fed,
	 * false if not
	 */
	public boolean feedElephant(int count) {
		/*
		 * each elephant eats 5 bales of hay a day, so amount *5 is the 
		 * amount of bales we need for the day
		 */
		int amountNeed=count*5;
		/*
		 * this may or may not create out HayStorage object, if its the first
		 * time the HayStorage class is being accessed then the hayStorage object
		 * called INSTANCE is created. if it was already created then this is just
		 * accessing the same object.
		 */
		HayStorage hayStorage=HayStorage.getInstance();
		hayStorage=HayStorage.getInstance();
		return false;
	}

}
