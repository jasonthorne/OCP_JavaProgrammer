package com.android;

import java.util.function.Predicate;

public class Examples {
	
	static void ex1() {
		
		
		/*
		 *ALL installation s of java come with a pre-packaged inteface called predicate. 
		 *Which hhas one abstract method inside it call 'test'.
		 *As this interface only has one abstract method, this means this predicate is a FUNCTIONAL INTERFACE and can be used with lambdas. 
		 *
		 * public interface Predicate<T>{
		 * 	public boolean test(T t);
		 * }
		 * 
		 */
		
		Predicate<Integer>myPred; //with this predicate, the test method becomes: public boolean test(Integer t)
		Predicate<String>strPred; //with this predicate, the test method becomes: public boolean test(String t)

		Predicate objPred; //If you odnt supply it with a type, it becomes an object: public boolean test(Object t)
		
		//------------
		
		//anonymous class implementation of Predicate interface: 
		Predicate<Integer>intPred = new Predicate() {

			/*
			 * The problem here is that t is an object class reference to an Integer object. So if we want this object to behave like an Integer
			 * ie multiplication., division etc) we have to cast this object to be an Integer
			 */
			@Override
			public boolean test(Object t) {
				
				Integer myInt = (Integer)t; //cast t to an Integer
				
				if(myInt>=18) //do stuff with integer
						return true;
				return false;
				
			}//end of test method
			
		}; //end of anonymous inner class
		
		
		
		System.out.println("greater than or equal to 18? " + intPred.test(19));
	}

}
