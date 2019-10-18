package com.android;
/**
 * A DESIGN PRINCIPLE 
 * is an established idea or best practices that facilitates the software design process.
 * we deal with Five main ones
 * INVARIANTS
 * IS-A RELATIONSHIP
 * HAS-A RELATIONSHIP
 * OBJECT COMPOSITION
 * JavaBean
 * an Invariants is a property of truth that is maintained even after the data is being
 * modified
 * i.e every Human has an age greater than zero, same goes for weight, height
 * every Human has a name, which in programming terms is a non null String field
 * @author noelf
 *
 */
public class Main {

	public static void main(String[] args) {
		/*
		 *  an Invariants is a property of truth that is maintained even after the data is being
		 * modified
		 * i.e every Human has an age greater than zero, same goes for weight, height
		 * every Human has a name, which in programming terms is a non null String field
		 */
		Examples.Ex1();//INVARIANTS
		
		/*
		 * Is-a relationship
		 * anything that extends or implements is said to have a "IS-A" relationship
		 * i.e
		 * a Dog IS A Animal (is uni directional which means you can't say "a Animal IS A Dog, which does not make
		 * sense either in a purely logical way)
		 * if a class implements an interface, it is also said to have a IS-A relationship
		 * So an Astronaut IS A Movement (but it's not actually a Movement as you can't have an instance of a 
		 * Interface as an Interface is an abstract class and you can't have an instance of the class
		 */
		Examples.ex2();
		/*
		 * Has-a relationship
		 * A fish has fins
		 * a bird has feathers
		 * a object has a particular property or value
		 * if a super class object has a public or protected atribute then the sub class
		 * also has this atribute
		 */
		/*
		 * see primate class for Bird and has-a relationship with the feather class
		 */
		Examples.ex3();
		/*
		 * object composition is the process of constructing classes using references to other classes 
		 * See Penguin class.
		 * it can be a alternative to inhertiance, but both techniques do have they're place in proper software
		 * dvelopment
		 */
		Examples.ex4();

	}

}
