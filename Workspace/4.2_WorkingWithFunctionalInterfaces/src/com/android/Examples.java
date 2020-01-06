package com.android;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/*
 * DOBLE COLON OPERATOR
 * 
 * ::
 * 
 * Can be used for a static method, and instance method or a constructor
 */

public class Examples {
	
	Manners<String>m1=(m)->"manners lambda m1"; //lambda from Manners interface
	
	//Manners
	
	
	static void ex1() {
		Consumer<String>consumeStr=(s)->System.out.println("s is: " + s); //(s) arg is a string, as defined by the generic bracket
		consumeStr.accept("This is my string"); //consumeStr accepts variable of type t (defined as string)
		
		
		//DOUBLE COLON EXAMPLE WITH CONSUMER +++++++++++++++++++++++++++++++++++
		
		/*
		 * Instead of using the full lambda notation you can use the :: double colon operator
		 * The right hand side sees that this is a consumer object of type string. 
		 So we can omit the (s) as it knows it takes an object of type String from the left hand side.
		 Note how you DO NOT use brackets after "println".
		 */
		Consumer<String>consumerStr = System.out::println;
		consumerStr.accept("Here is another string");
		
		//------------------------
		//DOUBLE COLON EXAMPLE WITH SUPPLIER +++++++++++++++++++++++++++++++++++
		
		/*
		 * Supplier has a method:
		 * T get(){
		 * return object of type T
		 * }
		 * 
		 * Here we are implementing the get method that takes nothing and returns a new Dog
		 */
		Supplier<Dog>supplyDog =()->new Dog();
		//this is exactly the same as the above
		supplyDog = Dog::new;
		
		supplyDog.get(); //create a dog with the consumer
		
		//--------------------------------------
		
		/*
		 * This will take nothing and return an integer:
		 */
		Supplier<Integer>supplyInt=()->new Dog().eat(); //dog method returns an int.
		supplyInt.get();
		
		Supplier<Integer>supplierInt=new Dog()::eat; //double colon operator example ++++++++++++++++++++++++++
	}
	
	
	

	static void ex2() {
		
		System.out.println("\nex2()");
		
		/*
		 * Functional interfaces sre interfaces that only have one abstract method (they can have static or defaults too)
		 * From functional interfaces we crearte lambdas. We can also create our own unctional inrterface. 
		 */
		
		/*
		 * Behaviour is a functional interface:
		 * 
		 * public interface Behaviour<T,U,V,R> {

			R happy(T t, U u, V v);
		 */
		
		//takes (T t, U u, V v) and returns R
		//Behaviour<T,U,V,R>
		Behaviour<String, Integer, List<Dog>,Double>behaveLamb;
		
		behaveLamb=(t,u,v)->{
			System.out.println("t is a: " + t.getClass().getSimpleName());
			t.charAt(0); //has all methods of the String class
			System.out.println("u is a: " + u.getClass().getSimpleName());
			u.intValue(); //has all methods of the Integer class
			System.out.println("v is a: " + v.getClass().getSimpleName());
			v.get(0); //has access to all methods of the List interface
			return 12.5;
		};
		
		behaveLamb.happy("apple", 33, Arrays.asList(new Dog(), new Dog()));
	}

	
	static void ex3() {
		
		System.out.println("\nex3()");
	
		//BIG COMMENT HERE (TO GET FROM MASTER COPY) ++++++++++++++++++++++++++++++++
	
	
	
	}
	
	
	

}


class Dog{
	
	Dog() {
		System.out.println("Dog created");
	}
	
	int eat() {
		System.out.println("Dog eat method that returns an int");
		return 0;
	}
}

















@FunctionalInterface
interface Manners<T>{
	T sad(T t);
}