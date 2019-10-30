package com.android;
/**
 * Using InstanceOf
 * @author noelf
 *
 */
public class Main {
	
	public static void main(String args[]) {
		/*
		 * instanceOf returns a boolean, but it will only work for something that COULD be true, there has to
		 * be some sort of relationship in order for the code to compile
		 */
		/*
		 * this is a HeavyAnimal reference to a pointing to a Hippo object
		 * HeavyAnimal is a superclass of the Hippo class
		 */
		HeavyAnimal heavyHippo=new Hippo();
		/*
		 * will return true as this is a Hippo object
		 */
		System.out.println(heavyHippo instanceof Hippo);
		/*
		 * will also return true as HeavyHippo is a superclass of Hippo, so this is also a 
		 * HeavyAnimal object, so this will be true
		 */
		System.out.println(heavyHippo instanceof HeavyAnimal);
		/*
		 * this is a  heavyAnimal reference so it COULD BE a reference to a Elephant, as an Elephant is a sub class
		 * of HeavyAnimal.so there is a relationship between this object and the Elephant class
		 *  however this particular object is NOT an Elephant so this will compile but it will
		 * be false
		 */
		System.out.println(heavyHippo instanceof Elephant);
		/*
		 * there is no relationship between a cow and a hippo or heavyAnimal, so this will not compile and 
		 * instanceof can only be used for compatible types
		 */
		//System.out.println(heavyHippo instanceof Cow);
		//Hippo reference to a Hippo object
		Hippo henry=new Hippo();
		/*
		 *this is a Hippo reference to a  Hippo object, so this will NOT compile as a henry the hippo 
		 *could NEVER BE a Elephant, so this will not compile
		 */
	//	System.out.println(henry instanceof Elephant);
		/*
		 * can check literal objects such as the String "hello"
		 * instanceof ONLY works with Objects, not with primitives
		 */
		System.out.println("hello " instanceof String);//will return true
		/*
		 * all objects are instances of the object class, as every obejct inherits from the Object class. however
		 * there is one case where x instanceof object returns false and that is where a variable is set to null
		 */
		System.out.println("instanceof Object class");
		System.out.println(henry instanceof Object);//will return true
		System.out.println(heavyHippo instanceof Object);//will return true
		System.out.println(new Elephant() instanceof Object);//will return true
		System.out.println("hello" instanceof Object);//will return true
		/*
		 * you can't have a object of a interface i.e new Behaviour()
		 * however when you use instanceOf with an interface
		 * new Hippo() instanceof Behavoiur
		 * it will compile as the compiler is only here checking if the Hippo class implements the Behavoiur 
		 * interface
		 * you can use instanceof with a interface in combination with any class of your own creation. because it could
		 * have implemented this interface.
		 */
		System.out.println("instanceof Interface");
		System.out.println("hippos instanceof interface Behaviour "+(henry instanceof Behaviour));//false
		System.out.println("pygmyHippo instanceof interface Behaviour "+(new PygmyHippo() instanceof Behaviour));//true
		System.out.println(new Cow() instanceof Behaviour);//false
		int[]myArray=new int[] {56,78,99};
		//can't use instanceof with a interface and one of the classes java comes packaged with
		//System.out.println(new int[]{56,78} instanceof Behaviour);
		/*
		 * the instanceof operator is commonly used to determine if an instance is a subclass of a particualr object
		 * before applying an explicit cast
		 * the object HAS to be a subclass of Animal, anything else WILL NOT COMPILE, if the Animal is not a Dog, Cat or
		 * a Fish, then this will throw a runtimeExcpetion as we have set up our code that way
		 */
		Animal.moveAnimal(new Dog());
		Animal.moveAnimal(new Bird());
		Animal.moveAnimal(new Fish());
		Animal.moveAnimal(new Cat());
		//will throw RunTimeException() as we have it coded that way
	//	Animal.moveAnimal(new Lizard());
		
		
		
	}

}
