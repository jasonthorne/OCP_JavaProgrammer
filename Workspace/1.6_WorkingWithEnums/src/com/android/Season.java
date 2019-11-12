package com.android;

import java.io.Serializable;

/*
 * Enums are your own data types.
 * So here we are going to create a data type that has only 4 values. (SPRING, SUMMER, AUTUMN, WINTER)
 */

public enum Season {
	
	
	//Every enum value is implicitly static final & public. ++++++++++++++++
	SPRING, SUMMER, AUTUMN, WINTER
	
	/*
	Enums dont allow inheritence. I.E Enums CANT extend or be extended.++++++++++++++
	*/
	
	

}

/* DOESNT WORK 
enum noEnum extends Season{
	
}
*/

/*
 * Enums can eimplement an Interface
 * 
 * Can't create a LOCAL enum (inside a method).
*/


//This is just to show that an enum CAN implement an interface. Serializable is an interface that allows our classes to become jar files. +++++++++++++++++++++
enum Season2 implements Serializable{
	
	//these are our 4 allowable enum types (MUST be at the START of the enum class) +++++++++++++++++
	WINTER, //calls no args constructor
	SPRING, 
	SUMMER, //calls no args constructor
	AUTUMN;
	
	/*
	 * enums can have variables:
	 * These vars can ONLY be accessed inside this enum.
	 */
	
	private String expectedVisitors; //this wil be low, med or high
	private double avgTemp;
	
	//This variable can be accessed in the same package only. 
	protected int num = 5;
	public double dayLight;
	
	
	//==========CONSTRUCTORS:
	
	//Blank constructor (called by winter & summer)
	Season2(){
		expectedVisitors="low";
		avgTemp=23.4;
		dayLight=8.9;
		System.out.println(this);
		System.out.println("Season2 enum blank constructor called");
		
		
	}
	
	//Constructor that is called by SPRING 7 SUMMER
	Season2(String expectedVisitors){
		this.expectedVisitors = expectedVisitors;
		
		System.out.println("Season2 enum constructor that takes a string was called ");
	}
	
	
}

enum Days{
	
	/*
	 * monday to friday all use the blank no argument constructor
	 */
	MON(),
	TUE,
	
	/*
	 * If your type has a body, you can override 
	 */
	WED(){
		
		
		//this is overriding the sign in method from the main body of the days enum.
		@Override
		public void signIn() {
			System.out.println("sign in method overriden");
		}
		
		public void payDay() {
			System.out.println("Only wed has this method");
		}
		
	},
	THUR,
	FRI,
	
	/*
	 * the below enums call the constructor that takes a string.
	 */
	SAT("yo"),
	SUN("low"){
		
	};
	
	
	private String expectedVisitors; //this wil be low, med or high
	private double avgTemp;
	
	//blank constructor:
	Days(){
		expectedVisitors="medium";
		avgTemp = 17.8;
		System.out.println(this);
		System.out.println("Blank constructor for enum days called");
	}
	
	Days(String expectedVisitors){
		this.expectedVisitors = expectedVisitors;
		System.out.println(this);
		System.out.println("Constructor with string for enum days called");
	}
	
	
	//All days of the week an call this method. Overriden with WED
	public void signIn() {
		System.out.println(this+ " general sign in method");
	}
	
	
}



enum Months{
	
	JAN(){

		@Override
		void absMethod() {
			// TODO Auto-generated method stub
			
		} //calls blank constructor
		
	},
	FEB(){

		@Override
		void absMethod() {
			// TODO Auto-generated method stub
			
		} //calls blank constructor
		
	}, 
	MAR(){

		@Override
		void absMethod() {
			// TODO Auto-generated method stub
			
		} //calls blank constructor
		
	}, 
	APR(12.4){

		@Override
		void absMethod() {
			// TODO Auto-generated method stub
			
		} //calls constructor that takes a double
		
	}
	, 
	MAY(19.5){

		@Override
		void absMethod() {
			// TODO Auto-generated method stub
			
		} //calls constructor that takes a double
		
	},
	JUN(21.5){

		@Override
		void absMethod() {
			// TODO Auto-generated method stub
			
		} //calls constructor that takes a double
		
	},
	JUL() {
		@Override
		void absMethod() {
			// TODO Auto-generated method stub
			
		}
	}, //calls blank constructor
	AUG() {
		@Override
		void absMethod() {
			// TODO Auto-generated method stub
			
		}
	}, //calls blank constructor
	SEPT() {
		@Override
		void absMethod() {
			// TODO Auto-generated method stub
			
		}
	}, //calls blank constructor
	OCT(9.8) {
		@Override
		void absMethod() {
			// TODO Auto-generated method stub
			
		}
	}, //calls constructor that takes a double
	NOV(7.6) {
		@Override
		void absMethod() {
			// TODO Auto-generated method stub
			
		}
	}, //calls constructor that takes a double
	DEC(1.2){

		@Override
		void absMethod() {
			// TODO Auto-generated method stub
			
		} //calls constructor that takes a double
		
		
		@Override
		void printMe() {
			System.out.println("December's printMe");
		}
		
	};
	
	private String expectedVisitors; 
	private double avgTemp;
	private double dayLight;
	
	Months(){
		System.out.println("Blank months constructor called");
		System.out.println(this);
	}
	
	
	Months(double avgTemp){
		System.out.println("Constructor that takes avgTemp called");
		System.out.println(this);
	}
	
	abstract void absMethod();  //++++++++++++++++++++++++++++CAN have an abstract method but each enum types HAS TO HAVE a body, and HAS TO OVERRIDE THIS.
	

	void sunShining() {
		System.out.println("sunShining mwethod avaliable to ALL enum types");
	}
	
	//All of the enum month types has a printMe method, however December decides to override this
	void printMe() {
		System.out.println("Expected visitor level is: " + expectedVisitors);
	}
	
	
}


interface Movement{
	void run();
	void walk();
}

enum AnimalTypes implements Movement{
	
	
	MAMMAL(){
		
		@Override
		public void walk() {
			System.out.println("Reptile overriding walk method");
		}

		@Override
		void fly() {
			// TODO Auto-generated method stub
			
		}
		
	},
	REPTILE(){
		
		@Override
		public void run() {
			System.out.println("Reptile overriding run method"); //overriding method in REPTILE OBJECT ++++++++++++++++
		}

		@Override
		void fly() {
			// TODO Auto-generated method stub
			
		}
	},
	AVIAN {
		@Override
		void fly() {
			// TODO Auto-generated method stub
			
		}
	};
	
	/*
	 * If each of your types has a run & walk method, you would not need the below() and walk() method. 
	 * And if you did not have any overriden methods in any of the types above, you would have to have the below.
	 */

	@Override
	public void run() {
		System.out.println("generic Animal run method"); //overriding method in ENUM BODY +++++++++++++++++++
		
	}

	@Override
	public void walk() {
		System.out.println("generic Animal walk method");
		
	}
	
	//If you have an abstract metyhos in your enum, you HAVE TO implement it in each one of the enum values. 
	//so this has to be implemented in Mammal, Reptile & Avian.
	abstract void fly();
	
	
	/* THIS CANT BE OVERRIDEN HERE as its in the same class as where it's declared.
	@Override
	void fly() {
		
	}*/
	
}














