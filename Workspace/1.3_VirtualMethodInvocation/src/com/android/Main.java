package com.android;

/*
 * Virtual Method Invocation
 * 
 * A virtual method is a method that you expect to be redefined in a derived class. (A method that's going to be overridden)
 * 
 */

public class Main {

	public static void main(String[] args) {
		
		
		/*
		 * You can call a static method of an abstract class by using the name of the abstract class, 
		 * as a static method is not tied to any individual object, but is instead tied to the class.
		 * This method takes a sub class of Animal (cant take an animal as Animal is an abstract class),
		 * which in turn calls the right feed method for a Cow, a fish or a bird, which in turn also calls a private method in each one of the cow or fish or bird class
		 */
		
		Animal.feedAnimal(new Cow());
		Animal.feedAnimal(new Fish());
		Animal.feedAnimal(new Bird());
		
		//You can also call a static method by using the name of the subclasses of the Animal class.
		Bird.feedAnimal(new Cow());

	}

}
