package com.android;

public class Animal {
/*
 * checks to see if the animal sent to this method is only of one of
 * the designated subclasses of Animal. if it is a designated
 * Animal it then calls the appropriate method for that object
 */
	/*
	 * this method can ONLY take a Animal or sub class of
	 * Animal
	 */
	static void moveAnimal(Animal myAnimal) {
		/*
		 * if this Animal is a Dog, this is a Animal reference to a 
		 * Dog object. So this object has no access to the bark()
		 * method, so we can cast this object to a Dog reference to
		 * a Dog object 
		 */
		//if a dog, cast reference to be a Dog and call bark method
		if(myAnimal instanceof Dog)
			((Dog)myAnimal).bark();
		else if(myAnimal instanceof Cat)
			((Cat)myAnimal).purr();
		else if(myAnimal instanceof Fish)
			((Fish)myAnimal).swim();
		else if(myAnimal instanceof Bird)
			((Bird)myAnimal).fly();
		else
			System.out.println("Animal not supported");
		//	throw new RuntimeException("unsupported Animal");
		
		
	}
}

class Dog extends Animal{
	void bark() {
		System.out.println("dog barking");
	}
}
class Cat extends Animal{
	void purr() {
		System.out.println("cat purring");
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
class Lizard extends Animal{
	
}
