package com.android;

public class Animal {
	
 /*
  * checks to see if the animal sent to this method is only of one of the designated subclasses of Animal.
  * If it is a designated animal, it then calls the appropriate method for that object.
  */
	
	//this method an ONLY take an Animal or subclass of Animal
	static void moveAnimal(Animal myAnimal) { //when an x object passed in here the object is an Animal reference to an x object (denying access to its own methods).
		
		/*
		 * if this animal is a Dog, this is an Animal reference to a Dog object. So this object has no access to the bark() method. 
		 * So we need to cast this object back to being a Dog reference to a Dog object.
		 */
		
		if(myAnimal instanceof Dog)
			((Dog)myAnimal).bark(); //cast Animal obj to be a Dog, and call it's bark method
		else if(myAnimal instanceof Cat)
			((Cat)myAnimal).purr();
		else if(myAnimal instanceof Fish)
			((Fish)myAnimal).swim();
		else if(myAnimal instanceof Bird)
			((Bird)myAnimal).fly();
		else 
			throw new RuntimeException("unsupported Animal");
	}
	
}


//subclasses of Animal: 

class Dog extends Animal{
	void bark() {
		System.out.println("Dog barking");
	}
}

class Cat extends Animal{
	void purr() {
		System.out.println("Cat purring");
	}
}

class Fish extends Animal{
	void swim() {
		System.out.println("Fish swimming");
	}
}

class Bird extends Animal{
	void fly() {
		System.out.println("Bird flying");
	}
}

class Lizard extends Animal{
	
}

