package com.android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Examples {
	
	static void ex1() {
		System.out.println("Ex1:");
		
		System.out.println("Using Bounds:");
		
		/*
		 * List is an interface and ArrayList is a class that implements the List interface.
		 */
		
		List<String>keyWords = new ArrayList<>();
		keyWords.addAll(Arrays.asList("bill", "ben", "bob", "barney"));
		
		/*
		 * below will not compile as it's mnot type safe. 
		 * The types of the list in the method signature have to match. 
		 */
		///printList(keyWords);
		Monkey<Goose>monkeyGoose = new Monkey<>(new Goose());
		
		/*
		 * below will not compile, as this only takes monkeys that were created with the Glider data type. 
		 * It doesnt matter that goose implements Glider, it still will not compile.
		 */
		//takeMonkey(monkeyGoose);
		
		Monkey<Glider>monkeyGlider = new Monkey<Glider>(new Goose());
		takeMonkey(monkeyGlider);
		
		
		//----------------
		
		List<Object>objList = new ArrayList<>();
		objList.add(new Dog());
		objList.add("yo dawg!");
		
		printList(objList);
		
	}
	
	//static method that prints a list of objects. Will ONLY accept objects that have a generic type of Object defined
	static void printList(List<Object>list) {
		for(Object x: list)
			System.out.println(x);
	}
	
	
	static void takeMonkey(Monkey<Glider>myMonkey) { //can only pass objects with a Glider data type defined 
		System.out.println("takeMonkey with Glider callled");
		
	}
	
	
	//------------
	
	List<Dog>dogList = Arrays.asList(new Dog(), new Dog());
	//takeAnimal(dogList); //WONT WORK as this list can only take the EXACT TYPE of type Animal. 
	
	/*
	 * Can only take the EXACT TYPE of type Animal. Even if it's a subtype of Animal (as dog is)
	 */
	static void takeAnimal(List<Animal>list) {
		System.out.println("takeAnimal called");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
