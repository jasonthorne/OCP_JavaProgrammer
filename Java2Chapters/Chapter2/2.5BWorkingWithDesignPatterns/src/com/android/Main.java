package com.android;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

/**
 * CREATING IMMUTABLE OBJECTS
 * create objects that can be shared across multiple classes but do not want they're values modified
 * you can copy the object and send it to a method, however this creates a large overhaed that you have
 * duplicates of objects every time a method is called. Also this is not thread safe
 * five rules
 * use a constructor to set all properties of the object
 * mark all of the instance variables private and final
 * don't define any setter methods
 * don't allow referenced mutable object to be modified or accessed directly
 * prevent method from being overriden
 * 
 */
public class Main {
	public static void main(String[]args) {
		System.out.println("***Creating Immutable object");
		List<String>foods=new ArrayList<String>();
		foods.add("apple");
		foods.add("orange");
		foods.add("banana");
		foods.add("mango");
		
		
		Animal monkey=new Animal("Monkey",4,foods);
		//this returns a copy of the list of foods, not the actual list
		System.out.println(monkey.getFavouriteFoods());
		//returns the primitve int age, primitives are passed by value and not by reference
		System.out.println(monkey.getAge());
		//returns the String name, which is itself immutable, so can be returned and displayed
		System.out.println(monkey.getName());
		//have all the getters in the toString method, so we can put the Animal object called "monkey" in print statement
		System.out.println(monkey);
		/*
		 * creates a shallow copy of the favouritefoods list of foods the monkey likes which is
		 * Apple,Orange,Banana,Mango
		 */
		List<String>copyList=monkey.getFavouriteFoods();
		//has the same values
		System.out.println(copyList);
		//change one of the values in the copied list
		copyList.set(0, "tomato");
		//values are now [tomato, orange, banana, mango] in the copied list
		System.out.println(copyList);
		//still [apple, orange, banana, mango] in the original list
		System.out.println(monkey.getFavouriteFoods());
		/*
		 * this creates a deep copy which means that copyList is the same List as the favouriteFoods array
		 *so if you are going to send a copy of a list back to method, and you want that list to be immutable, make
		 *sure its a SHALLOW COPY you are sending back to the method
		 */
		copyList=monkey.getFavouriteFoods2();
		System.out.println("copyList2 is "+copyList);
		System.out.println("original list is "+monkey.getFavouriteFoods());
		System.out.println("change the deep copied list");
		copyList.set(0, "tomato");
		/*
		 * the orignal list is changed as copyList2 and favouriteFoods are the same list with the same 
		 * references
		 */
		System.out.println("copyList2 is now "+copyList);
		System.out.println("original list is now "+monkey.getFavouriteFoods());
	}

}
