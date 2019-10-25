package com.android;
/*
 * this class is going to be used in conjuction with Comparator to sort a list of Ducks
 */
public class DuckHelper {
	
	static int compareByWeight(Duck d1,Duck d2) {
		/*
		 * either of these methods will return the same answer
		 * -a number
		 * 1 or a positive number
		 * 0
		 * this way uses the compareTo() method of the Integer wrapper class
		 */
	/*	Integer d1Weight=d1.getWeight();
		Integer d2Weight=d2.getWeight();
		return d1Weight.compareTo(d2Weight);*/
		return d1.getWeight()-d2.getWeight();
	}
	
	static int compareByName(Duck d1,Duck d2) {
		//this uses the compareTo() method of the String class
		return d1.getName().compareTo(d2.getName());
	}
	
	static Duck consumerDuck() {
		System.out.println("duck consumerDuck method called");
		return new Duck(55, "dolores");
	}

}
