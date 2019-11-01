package com.android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Examples {
	/*
	 * Using bounds
	 * type of list has to match type that a method takes
	 */
	static void ex1() {
		/*
		 * List is an interface that the Arraylist class implements, so you can't create a list object
		 */
		List<String>keywords=new ArrayList<>();
		/*
		 * this will NOT compile as printlist is not typesafe, the types of the list and the types in the method
		 * HAVE to match, printList takes an array of TYPE OBJECT
		 */
		//printList(keywords);
		List<Object>objects=new ArrayList<>();
		/*
		 * you can add anything to this list and this list can be sent to the printList() method
		 */
		objects.add("hello");//adding a string
		objects.add(keywords);//adding an existing list
		objects.add(new int[] {45,67,88,99});//adding a new array
		printList(objects);
		
	}
	/*
	 * this can only take a LIST OF TYPE OBJECT THE TYPES HAVE TO MATCH, if we sent it a list of any other type it will 
	 * NOT compile
	 */
	static void printList(List<Object>list) {
		for(Object x:list)
			System.out.println(x);
	}
	
	static void ex2() {
		System.out.println("ex2******");
		/*
		 * we can't send a list of type Dog to a method that is expecting an array of Animals. to fix this we need to have an
		 * array of Animals and we can then add only dogs to this if we want
		 */
		List<Dog>kennel=new ArrayList<>();
		//will not compile methods only accepts a list of type Animal
		//printAnimal(kennel);
		/*
		 * when we create a List of Animals we can add any animal we want to this list, so we can add both teh suepr class
		 * Animal and the sub class Dog,Cat and Poodle
		 */
		List<Animal>animals=new ArrayList<>();
		animals.add(new Dog());
		animals.add(new Cat());
		animals.add(new Poodle());
		animals.add(new Animal());
		/*
		 * this will work as this is a list of Animals, so it can be a Animal or
		 * subclass of Animals, but they TYPE defined when defined our list was
		 * ANIMAL
		 */
		printAnimal(animals);
	}
	/*
	 * this can ONLY TAKE A LIST OF TYPE ANIMAL THE TYPES HAVE TO MATCH
	 */
	static void printAnimal(List<Animal>animalLiist) {
		for(Animal a:animalLiist) {
			System.out.println("Animal is a "+a.getClass().getSimpleName());
			
		}
	}
	
	static void ex3() {
		System.out.println("ex3****");
		System.out.println("Unbounded wildcards");
		//a list of Strings
		List<String>keywords=new ArrayList<>();
		keywords.add("apple");
		keywords.add("orange");
		//this uses unbounded wildcard in method signature so can take list of any type
		printUnbound(keywords);
		//a list of arrays of ints
		List<int[]>arrays=new ArrayList<>();
		arrays.add(new int[] {4,5,6});
		arrays.add(new int[] {100,200,300});
		//this uses unbounded wildcard in method signature so can take list of any type
		printUnbound(arrays);
		//a list of Double wrapper objects
		List<Double>doubles=new ArrayList<>();
		doubles.add(2.33);
		doubles.add(3.145);
		//this uses unbounded wildcard in method signature so can take list of any type
		printUnbound(doubles);
	}
	
	/*
	 * the question mark here represtened a unbounded wildcard, which means that this method can take a List of ANY type
	 * this is an unbounded wildcard
	 */
	static void printUnbound(List<?>list) {
		for(Object x:list) {
			System.out.println(x);
		}
		//can't add anything to this list as when you use unbounded wildcards the list becomes immutable
	//	list.add(new Object());
	}
	
	static void ex4() {
		
		List<Animal>animalList=new ArrayList<>();
		animalList.add(new Animal());
		animalList.add(new Dog());
		animalList.add(new Cat());
		animalList.add(new Poodle());
		/*
		 * this uses an upper bounded wildcard
		 * this method can take any list as long as it's type is Animal or 
		 * a subclass of Animal
		 * */
		printUpperBound(animalList);
		List<Dog>kennel=new ArrayList<Dog>();
		kennel.add(new Dog());
		kennel.add(new Poodle());
		kennel.add(new Dog());
		printUpperBound(kennel);
			
	}
	/*
	 * this is a upper bounded wildcard, it can take an array of Animals or any subclass of Animal
	 * like bounded wildcards the list are immutable and cannot change
	 */
	static void printUpperBound(List<? extends Animal>list) {

				System.out.println("printUpperBound");//+list.;
		for(Animal a:list) {
			System.out.println(a);
		}
		//this will not compile as a list with upperbound generics is an immutable list
		//list.add(new Animal());
	}
	
	static void ex5() {
		System.out.println("ex5***");
		List<Integer>ints=new ArrayList<>();
		ints.addAll(Arrays.asList(56,78,99,100,345));
		/*
		 * this takes a upper bounded list <? extends Number> so this method can take any List of type Number or a sub class of
		 * Number, for example Integer, Double, Float, Byte, Short, etc
		 */
		printUpperNumbers(ints);
		List<Double>doubles=Arrays.asList(3.4,6.7,991.45,9.99);
		printUpperNumbers(doubles);
	}
	/*
	 * can take an array of any type of Number wrapper object or subclass of the Number wrapper class
	 */
	static void printUpperNumbers(List<? extends Number>numbers) {
		System.out.println("printUpperNumbers");
		for(Number n:numbers) {
			System.out.println(n);
		}
	}
	
	static void ex6() {
		System.out.println("ex6****");
		/*
		 * we can create lists by using wildcards, however when you create a list this way you can't add new elements to the list
		 * or change any items in the list, the list become immutable
		 */
		List<?>list=new ArrayList<>();
		//will not compile
		//list.add("apple");
		/*
		 * this creates a list with the number 56, the string "hello" and a Dog object
		 */
	//	List<?>listObj=Arrays.asList(56,"hello",new Dog());
		//this creates a list with four numbers
		List<?>listObj=Arrays.asList(1000,2000,3000,4000);
		System.out.println(listObj);
		/*
		 * can't add or change any object in this list
		 */
		//listObj.add(12);
		//listObj.set(0, 78);
		//listObj.set(1, 456);
		System.out.println(listObj.get(2));
		/*
		 * if you initialise a list with an array, you can't add more values to the list, it will compile but throw a 
		 * UnsupportedOperationException. you CAN change values though
		 */
		List<Integer>numbers=Arrays.asList(56,88,99,200,3456);
		//will throw exception
		//numbers.add(45);
		//you CAN CHANGE VALUES
		numbers.set(0, 200000);
		System.out.println(numbers);
		/*
		 * the reason you can't add any new numbers to this List is that the  underlying structure is an array and you can't 
		 * add new elements to an array once created
		 */
		try {
			/*
			 * this will throw UnsupportedOperationException
			 * neither of these operations will run, 
			 */
			numbers.add(789);
			numbers.addAll(Arrays.asList(999,888,777));
		}
		catch(Exception e) {
			System.out.println("exception is "+e);
		}
		//you do not have to put in the <Integer> part as numbers is a List<Integer> type
		//if we put nothing in <> it will still compile, if however we put in any other data type beside Integer it 
		//WILL NOT compile
		numbers=new ArrayList<Integer>();
		//you WILL be able to add numbers to this list as this list was not created with an array
		//each of these numbers are autoboxed to become integers
		numbers.addAll(Arrays.asList(333,444,555,666,777));
		numbers.add(100000);
		//add the list to itself
		numbers.addAll(numbers);
		System.out.println(numbers);
		//this is an array of ints
		int[]intArray= {51,52,53,54};
		//this will not compile as this in an array of ints, 
	//	numbers.addAll(Arrays.asList(intArray));
		Integer[]integerArray= {10000,10001,10002,1003};
		/*
		 * this will compile as we are adding an array of Integers, 
		 */
		numbers.addAll(Arrays.asList(integerArray));
		/*
		 * addAll only works on only works on objects that implment the Collection Interface, ArrayLists, HashMaps, Deques all 
		 * implement the Collection interface and will be covered in the next section
		 */
	//	numbers.addAll(integerArray);	
	}
	
	static void ex7() {
		/*
		 * Flyer is an interface in Flyer.java and also contains the class Plane, Goose and Hanglider class which both implement the
		 * Flyer interface
		 */
		List<Flyer>myFlyer=new ArrayList<>();
		myFlyer.addAll(Arrays.asList(new Goose(),new Plane(),new Hanglider()));
		System.out.println(myFlyer);
		
		 /* this can be sent to either method as the anyFlyer() method takes 
		 * list of objects that implement the Flyer interface
		 * the groupOfFlyers() method takes a list of object that also implements
		 * the flyer interface (we use the extends keyword for interfaces)
		 */
		//this method adds a Goose to this List
		anyFlyer(myFlyer);
		System.out.println(myFlyer);
		//you can't add any flyer object in this method as it uses a wildcard and the rule about not being able to 
		//add or change a list that has a wildcard holds true here
		groupOfFlyers(myFlyer);
		
	}
	
	static void anyFlyer(List<Flyer>flyer) {
		System.out.println("anyFlyer method called");
		//as there are no wildcards you can add items to this list
		flyer.add(new Goose());
		//System.out.println(flyer);
	}
	
	static void groupOfFlyers(List<? extends Flyer>flyer) {
		System.out.println("groupOfFlyers");
		/*
		 * neither of these lines of code will compile as we have set the type of list to be a upper bounded wildcard type
		 */
		//flyer.add(new Plane());
		//flyer.set(0, new Goose());
	}
	
	static void ex8() {
		System.out.println("***ex8");
		System.out.println("***Lower bound wildcard");
		/*
		 * Lower bound wildcard generic types uses the word "super" and makes the arrayList mutable
		 */
		List<Animal>animalList=new ArrayList<>();
		animalList.addAll(Arrays.asList(new Dog(),new Animal()));
		takeLowerBound(animalList);
		System.out.println("outside method "+animalList);
		/*
		 * this is a list of Type Dog, which the method takeLowerBound can take, all that matters is that the types 
		 * are compatible with the method
		 * static void takeLowerBound(List<? super Dog>list) 
		 */
		List<Dog>kennel=new ArrayList<>();
		/*
		 * the type of the list is a Dog, which this method can take, it does not matter that the list is populated with only
		 * poodles which are a sub class of Dog
		 */
		kennel.addAll(Arrays.asList(new Poodle(),new Poodle()));
		takeLowerBound(kennel);
		
		List<Poodle>poodleList=new ArrayList<>();
		poodleList.addAll(Arrays.asList(new Poodle(),new Poodle()));
		/*
		 * however you CANNOT sent a list of type POODLE to the method
		 * this will not compile
		 */
	//	takeLowerBound(poodleList);
	}
	/*
	 * this method can take a list of Dogs or a superclass of Dog, which is Animal or a Object which is a superclass of Animal
	 */
	static void takeLowerBound(List<? super Dog>list) {
		System.out.println(list);
		/*
		 * you can add object to this, but you can only add the type that is mentioned in the method signature, which is 
		 * Dog
		 */
		list.add(new Dog());
		//can't add animal, even though Animal is a super class of Dog
		//list.add(new Animal());
		/*
		 * can try to cast it but you will get a classCastException, as can't cast from super to sub
		 */
		//list.add((Dog)new Animal());
		System.out.println("list inside method is "+list);
	}


}



