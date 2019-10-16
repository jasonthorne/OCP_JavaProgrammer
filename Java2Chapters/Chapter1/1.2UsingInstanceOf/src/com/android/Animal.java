package com.android;
/*
 * checks to see if the Animal sent to this method is only of the designated subclasses of Animal and if it is, 
 * runs the appropriate method for that class
 */
public class Animal {
	
	/*
	 * this method can ONLY TAKE a Animal or subclass of Animal
	 */
	static void moveAnimal(Animal myAnimal) {
		/*
		 * if this is a Dog, cast the object to be a Dog reference and then call
		 * the run() method that is ONLY available to Dog objects
		 */
		if(myAnimal instanceof Dog) {
			((Dog)myAnimal).run();
		}
		else if(myAnimal instanceof Bird) {
			((Bird)myAnimal).fly();
		}
		else if(myAnimal instanceof Fish) {
			((Fish)myAnimal).swim();
		}
		else if(myAnimal instanceof Cat) {
			((Cat)myAnimal).sneak();
		}
		else
		{
			throw new RuntimeException("unsupported Animal");
		}
		
	}
	

}

class Dog extends Animal{
	void run() {
		System.out.println("Dog running");
	}
}

class Cat extends Animal{
	
	void sneak() {
		System.out.println("A cat sneaking");
	}
}

class Fish extends Animal{
	void swim() {
		System.out.println("A fish swimming");
	}
}

class Bird extends Animal{
	void fly() {
		System.out.println("bird flying");
	}
}
/*
 * if we send a lizard the the else part of the if statement in the moveAnimal() will be called
 */
class Lizard extends Animal{
	
}