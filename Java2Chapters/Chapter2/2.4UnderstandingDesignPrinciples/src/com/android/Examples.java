package com.android;

public class Examples {
	
	static void Ex1(){
		/*
		 * see Human class for Invariant (every Human has to have a name that will NOT be null, every Human has
		 * to have an age greater than zero). we also should NOT be able to change the name back to null or the
		 * age to a number less than 0
		 */
		try {
			/*
			 * will throw illegalargument exception and just print out the message
			 * " a name is required for our Human"
			 */
			Human harry=new Human(null,-5);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			/*
			 * will throw illegalargument exception and just print out the message
			 * " age cannot be a negative number, choose zero if younger than 1"
			 */
			Human harry=new Human("harry",-1);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		Human hanna=new Human("hanna",0);
		
	}
	
	static void ex2() {
		/*
		 * see Employee class
		 *the object eddie is an Employee
		 *the Accountant eddie is an Employee
		 *The Astronaut flys which is a method of the Movement Interface
		 *all of these are a "Is-a" relationship
		 */
		Employee eddie=new Employee();
		Accountant andy=new Accountant();
		Astronaut annie=new Astronaut();
		annie.fly();
		
	}
	
	static void ex3() {
		
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
		 * all birds have feathers
		 */
		Bird tweety=new Bird();
		//all horse have tails
		Shetland shergar=new Shetland();	
	}
	
	static void ex4() {
		/*
		 * object composition is the process of constructing classes using references to other classes 
		 * See Penguin class.
		 * it can be a alternative to inhertiance, but both techniques do have they're place in proper software
		 * dvelopment
		 */
		Penguin pingu=new Penguin();
	}
	/*
	 * a common standard for the structure of your class is JavaBean
	 * which is make properties private, getters for non boolean begins with get, etc
	 * see JavaBean class for example (most of the classes we have developed already adhere to all these rules)
	 */
	static void ex5() {
		
	}

}
