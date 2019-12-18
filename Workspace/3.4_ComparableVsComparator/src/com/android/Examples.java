package com.android;

import java.util.Set;
import java.util.TreeSet;

public class Examples {
	
	/*
	 * The comparable interface as one method 
	 * compareTo()
	 * Here we will be implementing the comparable interface 
	 * and overriding the compareTo() method. 
	 * comparable interface looks like: 
	 * interface Comparable<T>{
	 * 		int compareTo(T arg)
	 * }
	 * 
	 * Comparable is a functional interface, so we can create lambdas from this interface. 
	 * Comparator is a SEPERATE interface and has a COMPARE() METHOD
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
		
		//COMPARETO ++++++++++++++++++
		
		System.out.println("strings");
	
		System.out.println("adam".compareTo("betty")); //negative number (number returned is the difference between them)
		System.out.println("betty".compareTo("adam")); //positive number (number returned is the difference between them)
		System.out.println("betty".compareTo("betty")); // returns 0

		System.out.println("adam".compareTo("Zee")); //returns a positive number, as Capital Z comes before lower case a
		
		/*
		 * Can't use null with compateTo, as null has no value, and you cant compare nothing with something. 
		 * If you cant use null with compareTo, that means you cant add null to a TreeSet or as a key in a TreeMap. 
		 */
		Set<Integer>mySet=new TreeSet<>();
		
		//Integers NOT ints: 
		Integer one = 1;
		Integer two = 2;
		Integer twentyTwo = 22;
		Integer minusFive = -5;
		
		//Just gives a -1,0 or 1, NOT the amount of difference between them.
		System.out.println(one.compareTo(two)); // -1
		System.out.println(twentyTwo.compareTo(one)); //1
		System.out.println(twentyTwo.compareTo(minusFive)); //1
		System.out.println(one.compareTo(one)); //0
		
	}
	
	
	static void ex2() {
		System.out.println("ex2:");
		
		
		
	}
}
