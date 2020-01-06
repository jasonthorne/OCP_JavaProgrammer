package com.android;


/*
 * RULES FOR ACCESSING LAMBDAS:
 * 
 * Lambdas can acess fields of a class, as they always have a default value even if none are given
 * (ie string has a default value of null, uin has default val of 0 etc).
 * Lambdas can access method parameters, as long as the method parameter's values dont change inside the method
 * Lambdas can access local variables that have been given a value and are effectively final. 
 * However if you change the value of a local variable, a lambda can no longer access this variable. 
 */


public class Gorilla {
	

	String name = "magilla"; // any lambda will be able to access this variable
	
	{
		name = "george"; //initialiser changes name to george
	}
	
	int age; //given default value of 0, so any lambda can access this variable.
	
	
	static int statInt; //any lambda can also access this
	double weight;
	
	//-------
	//this method takes a method parameter true or false, which a lambda can access as long as you DONT CHANGE IT.
	void everyOneMove(boolean baby) {
		
		
		System.out.println("ACESSING METHOD PARAMS");
		
		//baby = true; //lambda can no longer access this (if changed), as its value is changed so it is no longer EFFECTIVELY FINAL ++++++++++++++++
		
		/*
		 * play method takes an object that implements the Movement interface.
		 * This can be an object of a class that implements the movement interface
		 * An anonymous class that implements the movement interface
		 * or a lambda.
		 */
		play(()->{
			System.out.println("can access method parameters");
			System.out.println("baby is: " + baby);
			return "baby is: " + baby;
		});
		
		//baby = true; //lambda can no longer access this if changed here (or anywhere else) as well ++++++++++++++++
		
		//------------------------------------------------------------
		
		/*
		 * A lambda in a method in a class can access ALL fields of the object.
		 * Here it can access: name. age & weight & statInt.
		 * Also it doesn't matter if these variables are changes anywhere, the lambda can STILL ACCESS THEM.
		 */
		name = "bob";//can change field values without preventing access +++++++++
		
		System.out.println("ACESSING METHOD FIELDS");
		
		play(()->{
			System.out.println("access name: " + name);
			System.out.println("access age: " + age);
			System.out.println("access statInt: " + statInt);
			age=45; //can change field values without preventing access ++++++++++++++++
			System.out.println("age is now: " + age);
			return "play lambda can access all fileds of an object";
		});
		
		//----------------------------------------------------------------
		
		System.out.println("ACESSING LOCAL VARIABLES");
		
		int num=230;
		double number; //local vars are NOT given a default value
		boolean check = true;
		check = false;
		
		play(()->{
			System.out.println("accessing num: " + num); //num is EFFECTIVELY FINAL, as final wasnt changed
			//System.out.println("accessing number: " + number); //number has no default value so this cannot be accessed +++++++++
			//System.out.println("accessing check: " + check); //given a new value, so no longer EFFECTIVELY FINAL, so this cannot be accessed ++++++++++
			return "accessing local variables in a lambda";
		});
		
		//num = 33; //will prevent num being effectively final, so cant be used in lambda +++++++++++++++++
		
	}
	
	//-----------------
	/*
	 * this method can take an object of a class that implements the Movement interface
	 * OR a lambda that implements the movement interface
	 * OR an anonymous class object thaty implements the Movement interface
	 */
	String play(Movement m) {
		return m.move();
	}

}

/*
 * A functional interface is an interface that has only 1 abstract method, and you can create lambdas from this interface. 
 */
@FunctionalInterface
interface Movement{
	String move();
}

