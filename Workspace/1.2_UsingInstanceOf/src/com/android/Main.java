package com.android;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("******InstanceOf*******");
		
		/*
		 * InstanceOf returns a boolean, but will ONLY COMPILE for something that COULD be true.
		 * There has to be some sort of relationship inorder for the code to compile.
		 * 
		 * Instanceof ONLY WORKS with objects. Doesn't work for primitives. eg:
		 * 
		 *System.out.println(1 instanceof Integer); //WILL NOT COMPILE 
		 *
		 *
		 *this WILL compile as the number 5 is autoboxed to become an Integer, which is an object and can be used with instanceof:
		 */
		Integer number = 5;
		System.out.println(number instanceof Integer);
		
		//--------------------------------------------------------------------------------
		
		HeavyAnimal heavyHippo = new Hippo(); //this is a heavyAnimal superclass reference to a subclass Hippo object.
		
		System.out.println(heavyHippo instanceof HeavyAnimal); //is heavyHippo a HeavyAnimal object
		
		System.out.println(heavyHippo instanceof Hippo); //is  heavyHippo a Hippo object
		
		
		//this is a HeavyAnimal reference o it COULD BE refering to an Elephant object, as an Elephant is a subclass of HeavyAnimal.
		//so there IS a relationship between this object and the Elephant class. However this particualr object is NOT AN ELEPHANT, so it will compile, but it will be false.
		System.out.println(heavyHippo instanceof Elephant); //is heavyHippo an Elephant object
		
		/*
		 * There is no relationship between a Cow and a Hippo or a HeavyAnimal so this will NOT compile. 
		 * instanceof can only be used for compatible types, or will only compile for something that COULD be true.
		 */
		
		//System.out.println(heavyHippo instanceof Cow);
		
		Hippo henry = new Hippo();
		
		//henry is a Hippo reference to a Hippo object, so this will not compile as henry could NEVER be an Elephant:
		//System.out.println(henry instanceof Elephant); ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
	
		//CAN check literal object, such as string "hello":
		System.out.println("hello" instanceof String); //true
		System.out.println(new Animal() instanceof Animal); //true
		
		
		//-----------------------------------------------------------------------------------
		
		/*
		 * All objects are instances of the Object class, as every object inherits from the Object class. 
		 * There is 1 case where some variable of object type instanceOf returns false, and that is where a variable is set to null.
		 */
		
		System.out.println("instanceof Object  class");
		
		System.out.println(henry instanceof Object); //true
		Animal nullAnimal = null; 
		
		//If you use instanceof with a null object, this is the only circumstance that will return false when checking to instanceof Object.

		System.out.println(nullAnimal instanceof Object); //false
		//Every other object will return true for instanceof Object:
		System.out.println(heavyHippo instanceof Object); //true
		System.out.println("nice day" instanceof Object); //true
		
		
		/*
		 * You cant have an object of an interface. IE new Behaviour(),
		 * However you can use instanceof with an interface.
		 * You can check to see if ANY class YOU CREATE implements ANY interface YOU CREATE.
		 */
		
		System.out.println(henry instanceof Behaviour); //false
		System.out.println(new Cow() instanceof Behaviour); //false
		System.out.println(new PygmyHippo() instanceof Behaviour); //true
		
		
		/*you CANT compare references of prebuilt objects (like String) against your own classes/interfaces 
		 * As the answer will always be false.
		 */
		//System.out.println("hello" instanceof Behaviour); //will not compile
		
		
		//======================================================================================
		
		//call moveAnimal method and pass it animals:
		
		System.out.println("");
		Animal.moveAnimal(new Dog());
		Animal.moveAnimal(new Cat());
		Animal.moveAnimal(new Fish());
		Animal.moveAnimal(new Bird());
		//Animal.moveAnimal(new Lizard()); //this will throw a runtime exception (but will compile)

	}

}
