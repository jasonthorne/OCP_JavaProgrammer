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
	
	/*The monkey class can only be created with a Goose or HandGlider, 
	 * so the Monkey class is putting a limit onto what this can accept, NOT the wildcard
	 */
	static void takeMonkey(Monkey<Glider>myMonkey) { //can only pass objects with a Glider data type defined 
		System.out.println("takeMonkey with Glider callled");
	}
	
	//unbounded wildCard works though:
	//unBoundMonkey(monkeyGlider); ++++++++++SHOULD WORK ++++++++++++++++++
	
	static void unBoundMonkey(Monkey<?>myMonkey) { //can only pass objects with a Glider data type defined 
		System.out.println("unBoundMonkey with wildcard called");
	}
	
	
	//------------
	
	List<Dog>dogList = Arrays.asList(new Dog(), new Dog());
	//takeAnimal(dogList); //WONT WORK as this list can only take the EXACT TYPE of type Animal. 
	
	//if you give the list a generic type of Animal then this will work: 
	List<Animal>allAnimals= Arrays.asList(new Animal(), new Dog(), new Cat(), new Poodle());
	//takeAnimal(allAnimals); //+++++++SHOULD WORK +++++++++++++++ :(
	
	/*
	 * Can only take the EXACT TYPE of type Animal. Even if it's a subtype of Animal (as dog is)
	 */
	static void takeAnimal(List<Animal>list) {
		System.out.println("takeAnimal called");
		
		for(Animal a: list) {
			System.out.println(a);
		}		
	}
	
	
	static void ex2() {
		System.out.println("\nEx2:");
		System.out.println("Unbounded WildCards");
		
		//A list of Strings:
		List<String>keyWords = new ArrayList<>();
		keyWords.add("apple");
		keyWords.add("orange");
		keyWords.add("beef");
		
		
		printUnbound(keyWords); //passing in the list of strings to a method that uses an unbounded wildcard in it's method signiature
		
		//A list of Doubles:
		List<Double>doubles = Arrays.asList(3.3, 33.3, 3.33);
		System.out.println();
		printUnbound(doubles); //passing lisf doubles into unbounded wildcard sigged method below:
	}
	
	/* +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * The queston mark here represents an unbounded wildcard.
	 * Which means that this method can take a list of any type. 
	 * HOWEVER each of the objects in the method can only call the methods of the object class. 
	 */
	static void printUnbound(List<?>myList) { //this can take objects of any type, but will receive them as objects. 
		for(Object x: myList) {
				System.out.println(x);
		}
	}
	
	
	
	static void ex3() {
		System.out.println("\nEx3:");
		
		System.out.println("Upperbounded Wildcards:");
		
		List<Animal>animalList= Arrays.asList(new Animal(), new Dog(), new Cat(), new Poodle());
		printUpperBound(animalList); //passing list of animals into printUpperBound
		
		List<Dog>dogsList = Arrays.asList(new Dog(), new Poodle(), new Dog());
		printUpperBound(dogsList); //passing list of Dogs into printUpperBound
		
	}
	
	/* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * This is an upperbounded wildcard. It can take a list of Animals or any List of a subclass of Animals.
	 * A list produced by a wildCard is immutable, and cannot change. (you cant add. remove etc  to the list)
	 */
	static void printUpperBound(List<? extends Animal>animals) {
		System.out.println("Print upper bound");
		
		for(Animal a: animals)
				System.out.println(a);
		
		
		/*
		 * Below will not compile as a list produced by an upper bounded wild card is immutable.
		 * Also you cannot modify elements in the list.
		 */
		
		//animals.add(new Animal());
	}
	
	/*
	 * Upperbounded for classes and their subclasses. Here is tje Number super class and the sub classes of Integer and Double:
	 */
	static void ex4() {
		System.out.println("\nEx4:");
		System.out.println("Printing numbers of all types:");
		
		List<Integer>ints = new ArrayList<>();
		ints.addAll(Arrays.asList(33,34,56,45,89));
		
		List<Double>doubles = new ArrayList<>();
		doubles.addAll(Arrays.asList(33.3,34.3,56.3,45.3,89.3));
		
		//pass both Number lists to method below:
		printUpperNumbers(ints);
		printUpperNumbers(doubles);
	
	}
	
	
	static void printUpperNumbers(List<? extends Number>numbers) { //takes a lsit of any type that extends Numbers
		System.out.println("print upper numbers:");
		
		for(Number n:numbers) {
			System.out.println(n);
			
		}
		System.out.println();
	}
	
	
	
	//---------------------------------------
	static void ex5() {
		System.out.println("\nEx5:");
	
		System.out.println("Upper bounded wild cards using implemented interface.");
		
		List<Plane>planes = Arrays.asList(new Plane(), new Plane());
		List<Goose>goose = Arrays.asList(new Goose(), new Goose(), new Goose());
		List<Handlider>handGlider = Arrays.asList(new Handlider(), new Handlider(), new Handlider());
		List<Flyer>flyers = Arrays.asList(new Handlider(), new Goose(), new Plane(), ()->System.out.println("Lambda fly method"));
		takeGlider(planes);
		takeGlider(handGlider);
		takeGlider(planes);
		takeGlider(flyers);
		
	}
	
	/*
	 * This method takes a list of objects that implement the Flyer interface:
	 */
	static void takeGlider(List<? extends Flyer>flyers) {
		for(Flyer f:flyers) {
			f.fly();
			System.out.println(f);
		}
	}
	
	//----------------------------------------------------------------------------------
	
	static void ex6() {
		System.out.println("\nEx6:");
		
		System.out.println("lower bounded wildcards");
		//LOWER BOUNDED WILDCARDS:
		
		/*
		 * These use the word "super" and list produced is MUTABLE
		 */
		
		List<Dog>dogs = new ArrayList<>();
		dogs.addAll(Arrays.asList(new Dog(), new Dog(), new Dog()));
		
		takeLowerBound(dogs); //pass dogs into lowerBound method
	}
	
	/*
	 * This method takes a lower bounded wildcard and uses the keyword "super".
	 * This one takes a list of Dogs or objects that are superclasses of Dog.
	 * So this can tkae a list of Dogs, Animals or Objects. 
	 */
	static void takeLowerBound(List<? super Dog>list) {
		/*
		 * You can add objects to this list. HOWEVER you can only add the type mentioned in the method signature. So here we can only add Dogs.
		 */
		list.add(new Dog());
		
		//list.add(new Animal());
		
	}
	
}
