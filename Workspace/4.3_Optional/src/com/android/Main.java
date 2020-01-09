package com.android;

import java.util.ArrayList;
import java.util.Optional;

/*
 * In java 8 you can have an optional type, which may or may not have a value.
 */

public class Main {
	
	/*
	 * The optional data type can only have as it's generic, a object. 
	 * CANNOT be a primitive (as is the case with all generic types).
	 */
	
	/*
	 * Below 
	 */
	static Optional<Integer>intOpt; //is an Optional that has a data type of Integer. So IF it has a value it will be an Integer
	static Optional<Double>dblOpt; //is an Optional that has a data type of Double. So IF it has a value it will be an Double
	static Optional opt; //No data type given, so if this optional has a value it will be an Object. So assigning a string will give an Object reference to a String object
	static Optional<String>strOpt; //Optional of string type
	
	//initialiser
	//static
	{
		/*
		 * You CANT assign a value directly to an optional: intOpt = 3 womnt work
		 * 
		 * You can use the static method of() of the optional class to give a value to an Optional variable:
		 */
		intOpt=Optional.of(12); //has a data type of integer, so you can only assign Integers to it.
		dblOpt=Optional.of(2.5); //data type of double
		opt=Optional.of("string"); //optional of object type, so can be given a value of anything, but will be an Object ref to that type.
		opt=Optional.of(new ArrayList<Integer>());
		strOpt=Optional.of("yo dawg");
		
	}
	 
	public static void main(String[] args) {
		
		/*
		 * All our variables are given values in an instance intialiser, which only runs when we create an object of this class. 
		 */
		
		Main myMain=new Main();
		
		//+++++GET METHOD ++++++++++++++++++++++++
		//Optional is NOT a number. Its an Option which may or may not have a value ++++++++++++++++++
		
		System.out.println("get() method"); 
		System.out.println("value of intOpt is: " + intOpt.get());
		System.out.println("adding 4 to intOpt: " + intOpt.get()+4);
		
		int num = intOpt.get();
		System.out.println(num++);
		
		//----
		/*
		 * As this is an optional of type String, if we use the get() method then we have a string,
		 * which has access to all the methods of the string class.
		 */
		strOpt.get().concat("another string");
		
		//========================================creating local optional:
		
		System.out.println("creating local optional");
		Optional<Integer>optInt=Optional.of(23);
		System.out.println("print the optional:" + optInt); //this is NOT a number. 
		System.out.println("using get:" + optInt.get()); 
		num=optInt.get();
		System.out.println("num is now: " + num);
		
		//=================EMPTY OPTIONAL: ++++++++++++++
		
		Optional<Double>optDbl = Optional.empty(); //creating an optional with no value
		System.out.println(optDbl); //prints: Optional.empty
		//System.out.println(optDbl.get()); //gives runtime exception: NoSuchElementException because there is no value to get. ++++++++++++++++++++
		
		//----------------is present() ----------------------
		/*
		 * Is present is a method of the optional class which returns a boolean:
		 * true if the optional has a value, false if not. 
		 */
		System.out.println(optDbl.isPresent()); //returns false, as there is no value
		System.out.println(optInt.isPresent()); //returns true, as there is a value
		
		//only get the value from the optional if it's present:
		if(optDbl.isPresent()) {
			System.out.println(optDbl.get());
		}else {
			System.out.println("no value was present");
		}
		
		//-------
		
		//Optional<Double>oDbl=(optDbl.isPresent())
		
		String value = null;
		//assign optional to be emtpy if value has a value of null, or assign it to be the value of value
		Optional o=(value==null)?Optional.empty():Optional.of(value); 
		
		//if optional has a value, assign that value to dNum, otherwise assign 0.0 to dNum
		Double dNum=(optDbl.isPresent()?optDbl.get():0.0);
		
		//------------------
		
		Optional<Double>dblOpt = Optional.of(12.34);
		optInt=Optional.empty(); //this optional now has NO value +++++++++++++++
		
		//System.out.println(optInt.get());
		
		
		//================================OR ELSE:
		
		System.out.println("orElse");
		
		//if optInt has no value, this will use the int value of 23. 
		//HOWEVER optInt is STILL EMPTY
		System.out.println(optInt.orElse(23));
		
		System.out.println(optInt); //still empty
		System.out.println(dblOpt.orElse(100.00));
		
		//+++++++++++++++++++++++++++++++++++++++++++++can be used like a get:
		dNum=dblOpt.orElse(100.00); //same as a get. If no value exists, then 100 is assigned
		System.out.println(dNum);
		
		
		//================================OR ELSE GET: 
		
		/*
		 * gets the value of an Optional if the optional has a value. 
		 */
		
		dblOpt=Optional.empty(); //dblOpt now has NO value
		//dblOpt.get(); //generates NOSuchElement exception
		
		System.out.println(dblOpt.orElseGet( ()->Math.random()*10));
		
		//==========================================================================
		
		//calling method below:
		
		System.out.println("sending numbers to method that returns an optional");
		
		System.out.println("calling average with some numbers:");
		System.out.println(average(10,20,30,40));
		
		System.out.println("calling average with one number:");
		System.out.println(average(3));
		
		System.out.println("calling average with array:");
		System.out.println(average(new int[] {67,89,99,1000}));
		
		System.out.println("calling average with no numbers:");
		System.out.println(average());
		System.out.println(average().orElse(3.3)); //using oElse 

		
	}//end of main
	
	
	//This returns an optional variable, which may or may not have a value.
	/*
	 * This takes a varArgs which may be a number of ints, a single int, an array or ints or NO ints.
	 * If we send no ints to this method (average()) this can't return an average of nothing.
	 * That is why we make the return type an option. As it may or may not have a return value.
	 */
	static Optional<Double>average(int...scores){
		
		//have to check if any numbers are sent to this method:
		if(scores.length==0) {
			System.out.println("No numbers sent to this method");
			return Optional.empty(); //return an optional value with no values
		}
		System.out.println("Numbers have been sent to this metohd");
		
		int sum=0;
		for(int score:scores)
			sum+=score;
		
		
		return Optional.of((double)sum/scores.length); //return the avarage as a double to the optional
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
