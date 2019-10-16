package com.android;

import java.io.Serializable;

class Animal{
	/*
	 * this enum has it's own methods
	 */
	Season2 season=Season2.AUTUMN;
	
	{
		season.printExpectedVisitors();
		
	}
	
}
/*
 * enums are you own data types so this data type only has four values
 * WINTER,SPRING,SUMMER,AUTUMN
 * every enum is implicitly static final and public
 */
public enum Season {
		SPRING,SUMMER,AUTUMN,WINTER

}
/*
 * you can't extend a enum or they can't be extended themselves
 */
/*enum decade extends Season{
	
}*/
/*
 * enums CAN implement an interface
 * the java.io package has a interface called Serializable which basically allows us to export or import a class
 * in zipped format, will be covered in greater detail when we come to databases
 */
enum Season2 implements Serializable{
	//the enums have to before variables, constructors or methods
	/*
	 * each of these enum values calls the constructor for the Season2 class which takes a string
	 */
	WINTER("Low") {
		/*
		 * If a overriding an abstract method that is in the interface, you have to have the overriden method
		 * in each of the enum types body as we have here
		 * we have a abstract method abMethod() which we override in WINTER,SPRING, SUMMER and WINTER
		 */
		@Override
		void abMethod() {
			System.out.println("winter abMethod");
			
		}
	}, SPRING("Medium") {
		@Override
		void abMethod() {
			System.out.println("spring abMethod");
		}
		
	
	}, SUMMER("High") {
		@Override
		void abMethod() {
			System.out.println("summer abMethod");
			
		}
	}, AUTUMN("Medium") {
		@Override
		void abMethod() {
			System.out.println("Autumn abMethod");
			//can only access this inside the Autumn enum type
			someMethod();
			
		}
		/*
		 * this can only be accessed inside of the enum
		 */
		public void someMethod() {
			System.out.println("A SomeMethod");
		}
		/*
		 * the enum itself can also override any non abstract method
		 */
		@Override
		public void printExpectedVisitors() {
			System.out.println("Autum printExpectedVisitors method");
		}
	};
	/*
	 * enums can have constructors, variables and methods
	 * these varaible cannot be accessed outside of the enum
	 */
	private String expectedVisitors;
	private double avgTemp;
	/*
	 * this can be accessed outside of the class if in same package
	 */
	protected int num=5;
	/*
	 * this is called for each one of the enum types
	 */
	private Season2(String expectedVisitors) {
		this.expectedVisitors = expectedVisitors;
		System.out.println(this);
		System.out.println("Season2 constructor called");
		printExpectedVisitors();
	}
	
	public void printExpectedVisitors() {
		System.out.println("expected vistor amount is "+expectedVisitors);
	}
	/*
	 * if you have an abstract method you have to implement it in each of the enum types
	 */
	abstract void abMethod();
	
	void sunShining() {
		System.out.println("sunShing method avaliable to all enum types");
	}
	
}

interface Movement{
	void run();
	void walk();
}
/*
 * When an enum immplements an interface, we can have one overriden method for each abstract method
 * see how we override the walk() method inside the body of the enum AnimalTypes, so that means taht
 * each of the enum types will have this walk() method. we Can override this method if we desire in each one
 * of the Enum types , which we have done in the MAMMAL enum type
 * Each of the enum types can also implement the methods of an interface, which is the case we have here with the
 * run() method, we then don't need to put in a single implmentation in the main enum body, as each of the types
 * has a body for the run method in it's own type
 */
enum AnimalTypes implements Movement{
	MAMMAL {
		@Override
		void fly() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void run() {
			
		}
		
		@Override
		public void walk() {
			
		}
	},REPTILE {
		@Override
		void fly() {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void run() {
			
		}
	},AVIAN {
		@Override
		void fly() {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void run() {
			
		}
	};
	
	AnimalTypes(){
		System.out.println("enum AnimalTypes blank constructor called");
	}

/*	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}*/

	@Override
	public void walk() {
		// TODO Auto-generated method stub
		
	}
	/*
	 * can' override a abstract method of interface by the following way
	 */
	/*@Override
	void fly() {
		
	}
	*/
	
	
	abstract void fly();
	
}



