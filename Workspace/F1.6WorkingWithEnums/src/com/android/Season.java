package com.android;

import java.io.Serializable;

/*
 * enums are your own data types, so here we are going to create a 
 * data typ0e that has only four values
 * WINTER,SPRING,SUMMER,AUTUMN
 */
public enum Season {
	/*
	 * Every enum value is implicitly static final and public
	 * SPRING is ordinal() 0
	 * SUMMER is ordinal()1
	 * AUTUMN is ordinal()2
	 * WINTER is ordinal()3
	 */
	SPRING,SUMMER,AUTUMN,WINTER
}

/*
 * enums can't extend or be extended
 * enums dont' allow inheritance
 * this will not compile
 */
/*//will not compile
enum noEnun extends Season{
	
}*/
//enums CAN implement an interface
/*
 * can't create a LOCAL enum (create an enun inside a method), you can
 * only create an enum inside a top level class or you can create a
 * enum inside a inner static class but not inside a normal inner class
*/
/*
 * this is just to show that a enum CAN implement an interface
 * Serializable is a interface which allows our classes to become
 * jar files (zipped format basically), this will be covered in details
 * in the last chapter when we come to databases
 */
enum Season2 implements Serializable{
	//these are our four alloweable enum types
	//these these four call the no args constructor
	WINTER,//call no args constructor
	SPRING,
	SUMMER(),//call no args constructor
	AUTUMN;//
	/*
	 * enums can have variables
	 * these variables can only be accessed inside of this enum
	 */
	private String expectedVisitors;//this will be low, medium or high
	private double avgTemp;
	//this variable can be accessed in same package only
	protected int num=5;
	public double dayLight;
	//blank constructor called by WINTER AND SUMMER
	Season2(){
		expectedVisitors="low";
		avgTemp=23.4;
		dayLight=8.9;
		System.out.println(this);
		System.out.println("season2 enum blank constructor called");
	}
	//constructor that is called by SPRING AND SUMMER
	Season2(String expectedVisitors){
		this.expectedVisitors=expectedVisitors;
		System.out.println(this);
		System.out.println("season2 enum constructor that takes a string called");
	}	
}

enum Days{
	/*
	 * monday to friday, inclusive all use the blank no arguement
	 * constructors
	 */
	MON(),
	TUE,
	/*
	 * if you type has a body {}, you can override the methods that
	 * exist in the enum main body, for instance 
	 * signIN
	 */
	WED(){
		/*
		 * this is overriding the signin method from the main body
		 * of the Days enum
		 */
		@Override
		public void signIn() {
			System.out.println("signIn for wednesday only");
		}
		/*
		 * only the wednesday type that has the payday method
		 */
		public void payDay() {
			System.out.println("this is the day i get paid");
		}
	},
	THUR,
	FRI,
	/*
	 * saturday and sunday call the constructor that takes a string
	 */
	SAT("high"),
	SUN("low"){
		
	};
	
	private String expectedVisitors;//this will be low, medium or high
	private double avgTemp;
	//blank constructor
	Days(){
		expectedVisitors="medium";
		avgTemp=17.8;
		System.out.println(this);
		System.out.println("blank constructor for enum days called");
	}
	
	Days(String expectedVisitors){
		this.expectedVisitors=expectedVisitors;
		System.out.println(this);
		System.out.println("constructor with a string for enum days called "
				+ " others word, the weekend");
	}
	/*
	 * all days of the week can call this method
	 * only WED overrides this method, all other days of the week
	 * uses this exact method when calling signIn
	 */
	public void signIn() {
		System.out.println(this+" general sign in method");
	}
	
}

enum Months{
	/*
	 * if you enum has an abstract method in it, each one of your enum
	 * types HAS to have a body, to override the abstract method in
	 * here we have a abstract method in the Months enum, with the 
	 * method signature
	 * abstract void absmethod();
	 * each one of the months, has to have a body, as we have an abstract
	 * method in the enum, and each type HAS TO override that abstract
	 * method
	 * 
	 */
	JAN(){

		@Override
		void absMethod() {
			// TODO Auto-generated method stub
			
		}//calls blank constructor
		
	},FEB(){

		@Override
		void absMethod() {
			// TODO Auto-generated method stub
			
		}//calls blank constructor
		
	},MAR(){

		@Override
		void absMethod() {
			// TODO Auto-generated method stub
			
		}//calls blank constructor
		
	},APR(12.4){

		@Override
		void absMethod() {
			// TODO Auto-generated method stub
			
		}//calls constructor that takes a double
		
	},MAY(19.5){

		@Override
		void absMethod() {
			// TODO Auto-generated method stub
			
		}//calls constructor that takes a double
		
	},JUN(21.5){

		@Override
		void absMethod() {
			// TODO Auto-generated method stub
			
		}//calls constructor that takes a double
		
	},JUL(){

		@Override
		void absMethod() {
			// TODO Auto-generated method stub
			
		}//calls blank constructor
		
	},AUG(){

		@Override
		void absMethod() {
			// TODO Auto-generated method stub
			
		}//calls blank constructor
		
	},SEPT(){

		@Override
		void absMethod() {
			// TODO Auto-generated method stub
			
		}//calls blank constructor
		
	},OCT(9.8){

		@Override
		void absMethod() {
			// TODO Auto-generated method stub
			
		}//calls constructor that takes a double
		
	},NOV(7.6){

		@Override
		void absMethod() {
			// TODO Auto-generated method stub
			
		}//calls constructor that takes a double
		
	},DEC(1.2){

		@Override
		void absMethod() {
			// TODO Auto-generated method stub
			
		}//calls constructor that takes a double
		
		@Override
		void printMe() {
			System.out.println("yahoo christmas");
		}
		
	};
	
	private String expectedVisitors;//this will be low, medium or high
	private double avgTemp;
	private double dayLight;
	
	Months(){
		System.out.println("blank months constructor called");
		System.out.println(this);
	}
	Months(double avgTemp){
		System.out.println("constructor that takes a double avgTemp called");
		System.out.println(this);
	}
	/*
	 * this HAS TO BE overridden in each one of the enum types, so you
	 * have to have 12 absMethod(). each type HAS TO A BODY {}
	 */
	abstract void absMethod();
	//available to all months, same for every month
	void sunShining() {
		System.out.println("sunShining method available to all enum types");
	}
	/*
	 * all the enum month types, has a printMe method, however
	 * Decemeber decides to override this method
	 */
	void printMe() {
		System.out.println("expected visitors level is "+expectedVisitors);
	}
	
}

interface Movement{
	void run();
	void walk();
}

enum AnimalTypes implements Movement{
	/*
	 * these methods can be implemented either inside each one of the
	 * enum types or in greater enum body. however they have to be
	 * implemented in at least ONE of those places, but they can be 
	 * implmented in both, see walk() in mammal and main enum body
	 * and run() in reptile and main enum body.
	 */
	MAMMAL(){
		@Override
		public void walk() {
			System.out.println("mammal walk method");
		}

		@Override
		void fly() {
			// TODO Auto-generated method stub
			
		}
	},
	REPTILE(){
		@Override
		public void run() {
			System.out.println("reptile run method");
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
	 * if each one of your types has a run and a walk method you would
	 * not need the below run() and walk() method. 
	 * and if you did not have any overridden methods in any of the 
	 * types above, you would have to have the below
	 */
	@Override
	public void run() {
		System.out.println("general run method for AnimalTypes");	
	}
	@Override
	public void walk() {
		System.out.println("general walk method for AnimalTypes");	
	}
	/*
	 * if you have an abstract method in your enum, you have to 
	 * implement it in each one of the enum values. So this has to be
	 * implemented in MAMMAL,REPTILE and AVIAN
	 */
	abstract void fly();
	/*
	 * this will not compile as can't override in the same scope
	 * or can't override in same class (you CAN override in an inner 
	 * class)
	 */
/*	@Override
	void fly() {
		
	}*/
	
}



