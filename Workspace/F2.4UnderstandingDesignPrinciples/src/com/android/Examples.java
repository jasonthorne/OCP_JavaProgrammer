package com.android;

public class Examples {
	
	static void ex1() {
		/*
		 * see Human class for Invariant (every Human has to have a name that will NOT be null, every Human has
		 * to have an age greater than zero). we also should NOT be able to change the name back to null or the
		 * age to a number less than 0
		 */
		
		try {
			//valid arguments will print out  "our Human is created"
			Human harry=new Human("harry",5);
			System.out.println("our Human is created");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			//invalid String
			Human helen=new Human(null,34);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			//invalid String
			Human harriet=new Human(" ",34);
			System.out.println("human with spaces created");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			//invalid string
			Human harriet=new Human("",34);
			System.out.println("human with no length string created");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			//invalid int
			Human harriet=new Human("harriet",-1);
			System.out.println("human with minus age created");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			//only gets to invalid string
			Human harriet=new Human("",-1);
			System.out.println("human with both values invalid");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	static void ex2() {
		System.out.println("IS-A relationship");
		/*
		 * see employee file for all these classes
		 * The object eddie is an employee
		 * the accountant andy is a Employee and a Accounant and an object
		 * the Astronaut annie is a Astronaut and a Employee and an object
		 * and when a class
		 * implements an interface, it is said also to be a "IS-A" relationship
		 * so Astronaut IS-A Movement()
		 */
		Employee eddie=new Employee();
		Accountant andy=new Accountant();
		Astronaut annie=new Astronaut();
		annie.fly();
		annie.walk();
	}
	
	static void ex3() {
		/*
		 * HAS-A relationship
		 * A fish has scales
		 * a bird has feathers
		 * a object has a particular property or value
		 * if a super class object has a public or protected astribute then
		 * the sub class also has this atribute
		 */
		//Bird is in primate File, all Birds have feathers, which is a HAS-A
		//relationship
		Bird tweety=new Bird();
		//all Horses have tails
		Shetland shergar=new Shetland();
	}
	
	static void ex4() {
		System.out.println("Object composition");
		/*
		 * Object composition is the process of constructing classes using 
		 * references to other clases
		 * see Penguin class
		 * if can be an alternative to inheritance, or it can compliment 
		 * inheritnace,and both techniques do have they're place in 
		 * propr software development
		 */
		Penguin percy=new Penguin();
	}
	
	static void ex5() {
		
	}

}
