package com.android;
/**
 * Virtual Method Invocation
 * A virtual method is a method you expect to be redefined in a derived class
 * The feed method in the Animal class is an abstract method, so this HAS TO be overriden in a dervied class
 * So virtual method invocation is the calling of the overriden method at runtime.
 * So the feed() method is the static feedAnimal() method in the Animal class will always call a derived
 * feed() method
 * @author noelf
 *
 */
public class Main {

	public static void main(String[] args) {
		/*
		 * both of these methods is calling the static method feedAnimal() in a static way, which is recommended
		 */
		/*
		 * you can call a static method of an abstract class by using the name of the abstract class, this works
		 * as a static method is not tied to an individual object but instead is tied to the class 
		 * this method takes a sub class of Animal (can't take a Animal as Animal is a Abstract class), which in turn
		 * call the right feed object, which in turn calls a private method of that class
		 */
		Animal.feedAnimal(new Cow());
		Animal.feedAnimal(new Fish());
		/*
		 * can also call this static method by using the name of the sub classes of Animal
		 */
		Bird.feedAnimal(new Bird());
		

	}

}
