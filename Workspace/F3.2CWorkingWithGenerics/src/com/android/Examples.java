package com.android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Examples {
	
	static void ex1() {
		System.out.println("using bounds ");
		/*
		 * List is an interface and arraylist is a class that implements the List
		 * interface
		 */
		List<String>keywords=new ArrayList<>();
		keywords.addAll(Arrays.asList("pat","mary","harry","scarlett"));
		/*
		 * this will NOT compile as it's not TYPESAFE, the types of the list in the
		 * method signature HAVE TO MATCH
		 */
	//	printList(keywords);
		List<Object>objList=new ArrayList<>();
		//you can add anything to this list
		objList.add(new Dog());
		objList.add("hello there");
		objList.add(new Goose());
		printList(objList);
		Monkey<Goose>monkeyGoose=new Monkey<>(new Goose());
		/*
		 * this compile as the this only takes Monkeys that were created with the
		 * Glider data type, it does not matter that Goose implements Glider, it still
		 * will NOT compile
		 */
		//takeMonkey(monkeyGoose);
		Monkey<Glider>monkeyGlider=new Monkey<>(new Goose());
		takeMonkey(monkeyGlider);
		
		List<Dog>dogList=Arrays.asList(new Dog(),new Poodle());
		/*
		 * takeAnimal() can only take a list of type Animal, it cannot take any other
		 * type, even if that type is a sub class of Animal, as Dog is
		 */
	//	takeAnimal(dogList);//will not compile
		List<Animal>allAnimals=Arrays.asList(new Animal(),new Dog(),new Cat(),
				new Poodle());
		takeAnimal(allAnimals);
		
	}
	/*
	 * this will only take a list of objects
	 */
	static void printList(List<Object>list) {
		System.out.println("printList method called");
		for(Object x:list)
			System.out.println(x);
	}
	/*
	 * this will only take a Monkey created with the generic type said to be a 
	 * <Glider>
	 */
	static void takeMonkey(Monkey<Glider>myMonkey) {
		System.out.println("takeMonkey with Glider called");
	}
	/*
	 * this will only take a list of type Animal, and not a sub class of type Animal
	 */
	static void takeAnimal(List<Animal>list) {
		System.out.println("takeAnimal called");
		for(Animal a:list)
			System.out.println(a);
	}
	
	static void ex2() {
		System.out.println("unbounded wildcards");
		//a list of strings
		List<String>keywords=new ArrayList<>();
		keywords.add("apple");
		keywords.add("orange");
		keywords.add("beef");
		//this uses a unbounded wildcard in the method signature, so it can take
		//a list of any type
		printUnbound(keywords);
		List<Animal>animalList=Arrays.asList(new Animal(),new Dog(),new Cat());
		printUnbound(animalList);
		
		List<Double>doubles=Arrays.asList(2.32,5.56,102.1,23.45);
		printUnbound(doubles);
		/*
		 * unBoundMonkey can take any Monkey created with a Goose or Hanglider,
		 * it's not the wildcard that puts on this condition its the monkey class
		 * as the class defination of monkey is 
		 * class Monkey<T extends Glider>
		 */
		Monkey<Goose>gooseMonkey=new Monkey<>(new Goose());
		unBoundMonkey(gooseMonkey);
		Monkey<Hanglider>hangMonkey=new Monkey<>(new Hanglider());
		unBoundMonkey(hangMonkey);
		
	}
	/*
	 * the question mark here represents a unbounded wildcard, which means that this
	 * method can take a list of ANY type, this is a unbounded wildcard
	 */
	static void printUnbound(List<?>myList) {
		for(Object x:myList) {
			System.out.println(x);
			
		}		
	}
	/*
	 * the monkey object can only be created with a Goose or hanglider, so its the 
	 * monkey that is putting a limit on what this can accept, not the wildcard 
	 * itself
	 */
	static void unBoundMonkey(Monkey<?>myMonkey) {
		System.out.println("unBoundMonkey method called");
	}
	
	static void ex3() {
		System.out.println("Upper bounded wildcards");
		List<Animal>animalList=Arrays.asList(new Animal(),new Dog(),new Cat());
		printUpperBound(animalList);	
		List<Dog>dogs=Arrays.asList(new Dog(),new Dog(),new Poodle());
		printUpperBound(dogs);
	}
	/*
	 * this is a upper bounded wildcard, it can take a list of Animals or any 
	 * list of subclass of Animals. A list produced by a wildcard is immutable
	 * and cannot change, you can't add to the list
	 */
	static void printUpperBound(List<? extends Animal>animals) {
		System.out.println("print Upper Bound ");
		for(Animal a:animals) {
			System.out.println(a);
			//only have access to methods of the Animal class
			a.move();
		}
			
		/*
		 * this will not compile as a list produced by a upper bounded wildcard is
		 * immutable and you can't add to this list
		 */
		//animals.add(new Animal());//will not compile
		//also cannot modify elements in the list
	}
	
	static void ex4() {
		System.out.println("printing numbers of all types");
		List<Integer>ints=new ArrayList<>();
		
		ints.addAll(Arrays.asList(23,34,567,899,200));
		printUpperNumbers(ints);
		List<Double>doubles=Arrays.asList(2.34,5.2,67.8,8.99,10.91,2.34);
		printUpperNumbers(doubles);
		List<Number>numbers=Arrays.asList(2,2.34,1_000_000_000);
		printUpperNumbers(numbers);
		
	}
	/*
	 * upper bounded for classes and they're sub classes, here is the Number super 
	 * class and the sub classes of Integer, Double, Short, Byte, etc, but not 
	 * apparently Long
	 */
	static void printUpperNumbers(List<? extends Number>numbers) {
		System.out.println("print upper numbers");
		double sum=0;
		for(Number n:numbers) {
			System.out.println(n);
			
		}
	}
	static void ex5() {
		/*
		 * upperBounded wildcards are also used when you want to create a list
		 * of objects that implement a particular interface, you still use the 
		 * keyword extends 
		 */
		//this list can only take planes
		List<Plane>planes=Arrays.asList(new Plane(),new Plane());
		//this list can only take Geese
		List<Goose>geese=Arrays.asList(new Goose(),new Goose(),new Goose());
		//this list can only take Hangliders
		List<Hanglider>hangliders=Arrays.asList(new Hanglider(),new Hanglider());
		/*
		 * this list can take Geese,Planes,Hangliders, anonymous class implementations
		 * of the Flyer interface and Lambdas that implements the Flyer interface
		 */
		List<Flyer>flyers=Arrays.asList(new Goose(),new Hanglider(),new Plane()
				,()->System.out.println("lambda fly method"));
		takeFlyer(planes);
		takeFlyer(geese);
		takeFlyer(hangliders);
		takeFlyer(flyers);
		/*
		 * all gliders also implement the Flyer interface, so you can pass
		 * this list to the takeFlyer method. however each of the items of the list
		 * still only have access to the methods of Flyer interface
		 */
		List<Glider>gliders=Arrays.asList(new Goose(),new Hanglider());
		takeFlyer(gliders);
	}
	/*
	 * this method takes a list of objects that implement the Flyer interface
	 */
	static void takeFlyer(List<? extends Flyer>flyers) {
		System.out.println("takeFlyer method ");
		for(Flyer f:flyers) {
			f.fly();
			System.out.println(f);
		}
			
	}
	
	static void ex6() {
		System.out.println("lower bounded wildcards");
		/*
		 * lowerbounded wildcards  use the word "super" and list produced is 
		 * MUTABLE
		 */
		List<Dog>dogs=new ArrayList<>();
				dogs.addAll(Arrays.asList(new Dog(),new Dog(),new Dog(), new Poodle()));
		/*
		 * this method can take lists of type Dog  and superclasses of Dog, so
		 * it can take a list of Dogs, Animals and Objects.
		 */
				takeLowerBound(dogs);
		List<Animal>animals=new ArrayList<>();
		/*
		 * the types of the list HAS to be the same type or a superclass, in this
		 * case has to be of type Dog or a super class of Dog. However the list
		 * itself can take sub classes, i.e this is a list of type <Animal> so the 
		 * list itself can contain Dogs, Poodles, and even Cats.
		 */
		animals.addAll(Arrays.asList(new Dog(),new Animal(),new Poodle(),new Cat()));
		takeLowerBound(animals);
		//the method can take a list of objects
		//if you leave out <Object> and have nothing there,its default type is still Object
		List<Object>objects=new ArrayList<>();
		//the list itself can take ANY object of ANY type
		objects.addAll(Arrays.asList(new Object(),new Animal(),new Dog(), new Poodle(),
				new Cat(),"hello"));
		takeLowerBound(objects);
		/*
		 * it CANNOT take a list of Poodles, as the Poodle type is a sub class of
		 * Dog
		 */
		List<Poodle>poodles=new ArrayList<>();
		poodles.addAll(Arrays.asList(new Poodle(),new Poodle(),new Poodle()));
		//this will NOT compile
	//	takeLowerBound(poodles);
	}
	/*
	 * this method takes a loweBounded wildcard and uses the keyword SUPER, this 
	 * method takes a list of Dogs or objects that are super classes of Dog, So this
	 * can take a list of Dogs, Animals and objects
	 */
	static void takeLowerBound(List<? super Dog>list) {
		/*
		 * you can add objects to thist list, HOWEVER you can only add the type
		 * mentioned in the method signature, so here we can only add Dogs
		 */
		System.out.println("takeLowerBound called");
		list.add(new Dog());
		for(Object o:list)
			System.out.println(o);
		//cannot add a Animal or Object as explained in Video 3.2G
		//list.add(new Animal());
		//you can try and Cast 
		//Dog spot=(Dog)new Animal();
	//	list.add((Dog)new Animal());
	}
	
	static void ex7() {
		/*
		 * this creates an Employee and type V will now be a Animal
		 * so pay method can only take a bank created with a Animal or subclass 
		 * of Animal
		 */
		Employee<Animal>emp1=new Employee<>(new Animal());
		//first four banks can be used with pay() method
		Bank<Animal>bank1=new Bank<>(new Animal());
		Bank<Dog>bank2=new Bank<>(new Dog());
		Bank<Cat>bank3=new Bank<>(new Cat());
		Bank<Poodle>bank4=new Bank<>(new Poodle());
		//this bank CANNOT BE USED with pay method
		Bank<String>bank5=new Bank<>("hello there");
		emp1.pay(bank1);
		emp1.pay(bank2);
		emp1.pay(bank3);
		emp1.pay(bank4);
		//will not compile
		//emp1.pay(bank5);
	}
	
	static void ex8() {
		System.out.println("general generics");
		/*
		 * this is an immutable arrayList, you can't add to it and you can't 
		 * modify any of the itmes in the list
		 */
		List<?>list=new ArrayList<>();
		//list.add("hello");
		/*
		 * this list is immutable and you can't add or take away any objects
		 * you can't modify any items on the list
		 */
		List<?>things=Arrays.asList(12,"hello",2.4,new Animal(),new ArrayList());
		//can't change elements, will not compile
		//things.set(0, 14);
		//can't add elements, will not compile
		//things.add("banana");
		System.out.println(things);
		/*
		 * this is a runtimeexception, so it will compile, but crash 
		 */
	//	things.remove(1);
	//	System.out.println(things);
		/*
		 * you can assing a new list to things, as soon you, this new list ALSO becomes
		 * immutable
		 */
		things=new ArrayList<>();
		//things.add("hello");//won't compile
		List<Integer>numbers=new ArrayList<>();
		/*
		 * one list of numbers and you have a mutable reference to it
		 * numbers
		 * and a immutable reference to it
		 * things
		 */
		numbers.addAll(Arrays.asList(12,34,77,1,4));
		numbers.add(489);
		things=numbers;
		//can't add as things is a immutable reference
		//things.add(45);
		//but we can add using the mutable reference numbers
		numbers.add(18999);
		//now we see the list has 18999 addedd to is
		System.out.println(things);
		/*
		 * this will produce a List of objects that is immutable and also  you
		 * CANNOT reassign this reference to another list
		 * it is possible to change the age of the Dog in this list, but you could
		 * only do this via one of the overriden methods of the Object class that
		 * is contained in the Dog class (see toString where we change the age of
		 * the Dog). if all of our variables are private and final and none of the 
		 * public methods access the variables of the Dog class, then the Dog would be 
		 * immutable
		 */
		final List<?>immutes=Arrays.asList(12,2.3,new Dog(),"hello",new ArrayList<>());
		/*
		 * can't reassign immutes as this is final
		 */
	//	immutes=new ArrayList<>();
	//	System.out.println(immutes.get(2));
		/*
		 * if you initialise a list with an array, as we have done here,  you 
		 * can't add or remove elements to a list
		 * however we can CHANGE elements in the list
		 */
		List<Integer>numbers2=Arrays.asList(34,567,99,100,1000,5);
		/*
		 * this generates a runtimeException
		 * UnsupportedOperationException
		 */
	//	numbers2.add(23456);
		/*
		 * this generates a runtimeException
		 * UnsupportedOperationException
		 */
		//numbers2.remove(1);
		numbers2.set(0, 1_000_000);
		System.out.println(numbers2);
		
		List<Integer>ints=new ArrayList<>();
		ints.addAll(Arrays.asList(33,444,555,6777,8));
		
		Integer[]integerArray= {34,67,888,99};
		/*
		 * addAll only takes objects of classes that implement the Collection interface
		 * List, Sets and Map all are sub interfaces of Collection, so all of these
		 * implement the Collection interface, so addAll can take lists, sets and maps
		 * it cannot take arrays
		 */
		//ints.addAll(integerArray);
		ints.addAll(Arrays.asList(integerArray));
		//this is still a List of Objects, type is not determined if you 
		//DO NOT PUT IN A TYPE ON THE LEFT HAND SIDE
		List someNumbers=new ArrayList<Integer>();
		someNumbers.add("hello");
		System.out.println(someNumbers);
		/*
		 * we created this as a list of Numbers reference to a ArrayList object
		 */
		System.out.println(numbers);
		/*
		 * numbers is a list with a generic of Integer 
		 * List<Integer>numbers;
		 * so this reference can only be assigned to compatible object, ie.
		 * if it's assigned like below to an new ArrayList<>();, this new arraylist
		 * can ONLY take integers
		 * if you put nothing in the <>diamond operators, the type is assumed to 
		 * be an arrayList<Integer>
		 * put in anything else besides a blank <> or <Integer> and you will get an 
		 * error and it will not compile
		 */
		numbers=new ArrayList<>();
		numbers=new ArrayList<Integer>();
		//numbers=new ArrayList<Number>();//will not compile
		
		
		
		
		
		
	}
	
	

}
/*
 * you can create your own Number wrapper class
 * however you can't create your own, for instance, Integer class, as each of the 
 * numeric wrapper types are final
 */
class myNumber extends Number{

	@Override
	public double doubleValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float floatValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int intValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long longValue() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
