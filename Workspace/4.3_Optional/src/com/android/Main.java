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
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
