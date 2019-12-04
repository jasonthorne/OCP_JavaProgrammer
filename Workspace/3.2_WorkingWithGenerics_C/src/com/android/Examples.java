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
		
		List<Plane>planes = Arrays.asList(new Plane(), new Plane()); //this list can only take planes
		List<Goose>goose = Arrays.asList(new Goose(), new Goose(), new Goose()); //this list can only take geese
		List<Handlider>handGlider = Arrays.asList(new Handlider(), new Handlider(), new Handlider()); //this list can only take handgliders
		//list of an INTERFACE TYPE allows creation of any objects that implement this interface: 
		List<Flyer>flyers = Arrays.asList(new Handlider(), new Goose(), new Plane(), ()->System.out.println("Lambda fly method")); //can take anything that implements this interface
		takeFlyer(planes);
		takeFlyer(handGlider);
		takeFlyer(planes);
		takeFlyer(flyers);
		
	}
	
	/*
	 * This method takes a list of objects that implement the Flyer interface:
	 */
	static void takeFlyer(List<? extends Flyer>flyers) {
		for(Flyer f:flyers) {
			f.fly();
			System.out.println(f);
		}
	}
	
	//----------------------------------------------------------------------------------
	
	static void ex6() {
		System.out.println("\nEx6:");
		//LOWER BOUNDED WILDCARDS: ++++++++++++++++++++++++++++++++++++++
		System.out.println("lower bounded wildcards");
		
		
		/*
		 * These use the word "super" and list produced is MUTABLE
		 */
		
		//-----The method can take a list of Dogs:
		List<Dog>dogs = new ArrayList<>();
		dogs.addAll(Arrays.asList(new Dog(), new Dog(), new Dog()));
		
		takeLowerBound(dogs); //pass dogs into lowerBound method
		
		//-----The method can take a list of Animals:
		List<Animal>animals = new ArrayList<>();
		animals.addAll(Arrays.asList(new Dog(), new Animal(), new Poodle(), new Cat()));
		
		System.out.println();
		takeLowerBound(animals); //pass Animals into list
		
		//-----The method can take a list of Objects:
		List<Object>objects = new ArrayList<>();
		objects.addAll(Arrays.asList(new Object(), new Animal(), new Dog(), new Cat()));
		
		System.out.println();
		takeLowerBound(objects); //pass objects into list
		
		//-----------
		//THis wont work because takeLowerBound cant take a TYPE which is a subclass of Dog.
		List<Poodle>poodles = new ArrayList<>();
		poodles.addAll(Arrays.asList(new Poodle(), new Poodle(), new Poodle(), new Poodle()));
		
		System.out.println();
		//takeLowerBound(poodles); //wont compile as poodle is a subclass of Dog
		
		
	}
	
	/*
	 * This method takes a lower bounded wildcard and uses the keyword "super".
	 * This one takes a list of Dogs or objects that are superclasses of Dog.
	 * So this can tkae a list of Dogs, Animals or Objects. 
	 */
	static void takeLowerBound(List<? super Dog>list) { //THIS CAN TAKE DOGS OR ANY SUPERCLASS OF DOG +++++++++++++++++++
		/*
		 * You can add objects to this list. HOWEVER you can only add the type mentioned in the method signature. So here we can only add Dogs.
		 */
		list.add(new Dog());
		
		
		//loop through list:
		for(Object o:list) //have to loop through OBJECTS because there could be an object in here ++++++
			System.out.println(o);
		
	
		
		//list.add(new Animal());
		
	}
	
	
	//----------------------------------------------------------------------------------
	
	static void ex7() {
		System.out.println("\nEx7:");
		
		Employee<Animal>emp1 = new Employee<>(new Animal()); //create an Employee of type Animal
		
		//banks created with Animal or subclass of Animal:
		Bank<Animal>bank1=new Bank(new Animal()); 
		Bank<Dog>bank2=new Bank(new Dog());
		Bank<Cat>bank3=new Bank(new Cat());
		Bank<Poodle>bank4=new Bank(new Poodle());
		
		/*Bank created with a type which is NOT an Animal or suclass.
		Meaning pay() method WONT work. (as its arg is set to ONLY take Animal tyupe or subclass types).
		*/
		Bank<String>bank5=new Bank("sup, world!");
		
		
		emp1.pay(bank1); 
		emp1.pay(bank2);
		emp1.pay(bank3);
		emp1.pay(bank4);
		//emp1.pay(bank5);
		
	}
	
	//----------------------------------------------------------------------------------
	
	static void ex8() {
		System.out.println("\nEx8:");
		
		System.out.println("General Generics:");
		
		/*
		 * This is an IMMUTABLe arraylist.
		 * You cant add to it, and you cant modify the items in the list.
		 */
		List<?>list = new ArrayList<>();
		
		/*
		 * The below list is immutable, and you cant add or remove any objects. You cant modify any items on the list.
		 */
		List<?>things=Arrays.asList(12, "yo", 3.3, new Animal(), new ArrayList()); //creating an immutable list
		
		//can't change elements:
		//things.set(0, 14);
		
		//can't add elements:
		//things.add("word");
		
		//can't remove elements:
		//things.remove(1); //this WILL compile, but gives a runtime exception
		
		
		//You can assign an ew list to things. as soon as you do this new list also becomes immutable
		things=new ArrayList<>();
		
		
		//if you make a FINAL list that includes an immutable wildcard, then this cant be modified AND it cant be reassigned.
		final List<?>immutes=Arrays.asList(12.33, new Dog(), new ArrayList());
		
		
		//-----------------------------
		//initialising a list with an array.
		/*
		 * If you initialise a list with an array you cant add or remove elements to a list. However you can CHANGE elements in a list. 
		 */
		List<Integer>numbers=Arrays.asList(3,33,333,3333);
		
		//cant add anything to this list:
		//numbers.add(3333333); //this generates a runtime exception.
		
		//cant remove anything to this list:
		//numbers.remove(3); //this generates a runtime exception.
		
		//you CAN however change elements in the list:
		numbers.set(0, 1_00000);
		System.out.println(numbers);
		
		
		//-------------------------
		
		List<Integer>ints=new ArrayList<>();
		ints.addAll(Arrays.asList(33,44,555,666,77865)); //addAll only takes objects that implement the COLLECTIONS interface (Maps, sets & lists).
		
		Integer[]integerArray = {34,67,888,99};
		
		//this doesnt compile, as addAll only takes objects of classes that implement the collection interface. 
		//ints.addAll(integerArray) //wont compile as its an ARRAY
		
		ints.addAll(Arrays.asList(integerArray)); //"Arrays.AsList" takes an array and converts it into a List. ++++++++++++++++++++
		
		//This is STILL a list of Objects, type is not determined if you DO NOT put in a type on the LEFT hand side. 
		List someNumbers = new ArrayList<Integer>();
		someNumbers.add("yo");
		System.out.println(someNumbers);
		
		
		//------------------------
		/*
		 * We created this as a list of Numbers reference to an ArrayList object.
		 */
		System.out.println(numbers);
		/*
		 * numbers is a list with a generic type of Integer. 
		 * So this reference can only be assigned to a compatible object. 
		 * IE if it's assigned like below to a new ArrayList, this new ArrayList can only take integers.
		 * If you put nothing in the diamond operators,the type is assumed to be an arraylist<Integer>
		 * Put anything else other thanb bliank in it and it wont compile.
		 */
		
		numbers = new ArrayList<>(); //fine
		numbers = new ArrayList<Integer>(); //fine
		//numbers = new ArrayList<Number>(); //computer say's no
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
