package com.android;

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