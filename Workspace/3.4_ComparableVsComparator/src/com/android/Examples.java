package com.android;

public class Examples {
	
	/*
	 * The comparable interface as one method 
	 * compareTo()
	 * Here we will be implementing the comparable interface 
	 * and overriding the compareTo() method. 
	 * comparable interface looks like: 
	 * interface Comparable<T>{
	 * 		int compare(T arg)
	 * }
	 * 
	 * comparable is a functional interface, so we can create lambdas from this interface. 
	 * These lambdas are called Comparators.
	 * 
	 * To explain how compareTo works, we will give the example of the String class. 
	 * String class implements the comparable interface.
	 * 
	 * Say we are calling the following:
	 * str1.compareTo(str2)
	 * 
	 * compareTo returns:
	 * + 0 if both are the same string. 
	 * eg: "apple".compareTo("apple");
	 * + a negative number if the string calling the method comes BEFORE the string senrt to the method. 
	 * eg: "apple".compareTo("berry");
	 * + a positive number if the string calling the method comes AFTER the string sent to the method. 
	 * eg: "berry".compareTo("apple");
	 * 
	 * Objects whose class implements Comparable can be used by ALL collection class and Maps to arrange the order of objects in any collection. 
	 * These objects are also the only objects that can be inserted into a TreeSet and the only objects that can be a key in a treeMap.
	 */
	
	static void ex1() {
		System.out.println("ex1:");
		
		System.out.println("strings");
		
		System.out.println("adam".compareTo("betty")); //negative number
		System.out.println("betty".compareTo("adam")); //positive number
		System.out.println("betty".compareTo("betty")); // returns 0
	}

}
