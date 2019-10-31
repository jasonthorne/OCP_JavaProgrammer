package com.android;

public class ZooKeeper {
	/*
	 * method that will use the HayStorage singleton to see if we have enough feed for each of our Elephants
	 * count is the amount of elephants we have to feed
	 * will return true if enough hay in storage and the elephants are fed, false if not
	 */
	public boolean feedElephant(int count) {
		/*
		 * each elephant eats 15 kilos of hay a day
		 * so amount * 15 is the amount in kilos we need for the day
		 */
		int amountNeeded=count*15;
		/*
		 * first time we create a Haystorage object the private static final HayStorage object is created 
		 * so each time we use the getInstance() method, we are going to be referring to the SAME HayStorage
		 * object
		 */
		HayStorage hayStorage=HayStorage.getInstance();//object x created in examples.ex1
		hayStorage=HayStorage.getInstance();//still object x created in examples.ex1
		/*
		 * if the quantity of hay in the storage is less than the amount the zookeeper wants to feed his 
		 * elephants then twice that amount of hay will be added to the store. this adds any additional hay that
		 * may be need to the store
		 */
		if(hayStorage.getHayQuantity()<amountNeeded) {
			hayStorage.addHay(amountNeeded*2);
		}
		/*
		 * this takes the hay from the store
		 * this returns true if the hay is taken from the store and fed to the Animals
		 * this returns false is the amount of hay requested is greater than the amount in the store and the hay
		 * is not removed from the store (this is essentially a double check as the above should ensure there
		 * is always enough hay in the store)
		 */
		boolean fed=hayStorage.removeHay(amountNeeded);
		/*
		 * if fed is true, means elephants are fed and hay was sucessfully removed from the store
		 */
		if(fed) {
			System.out.println("Elephants have been fed");
		}
		return fed;
	}

}
