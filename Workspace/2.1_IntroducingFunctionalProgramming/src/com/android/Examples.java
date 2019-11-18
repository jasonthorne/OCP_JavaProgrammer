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
		
		/*
		 * We will replace the above anonymous class with a lambda, as Predicate is a Functional Interface and has only 1 abstract method inside it. 
		 */
		
		
		//-----------------------Long form lambda:
		
		Predicate<Integer>intPred2=(Integer a)->{
			/*
			 * If more than one statement in a lambda, you HAVE to have curly braces.
			 */
			System.out.println("Long form lambda implementation of test method");
			
			//NO NEED TO CAST as it's being passed an integer NOT an onbject.
			if(a<=18) { //do stuff with integer
				System.out.println("You're a child");
				return true;
			}else {
				System.out.println("You're an adult");
				return false;
			}
			
		};
		
		intPred2.test(12);
		
		
		//-----------------------Medium form lambda:
		/*
		 * when you give a type on the left hand side, you dont need one one the right, as it knows a is an Integer.
		 * If you DONT GIVE A TYPE then the type is assumed to be object.
		 */
		Predicate<Integer>intPred3 = (a)->{
			
			if(a>=18)
				return true;
			return false;
		};
		
		//-----------------------Short form lambda:
		/*
		 * when you have only one line of code in your lambda body, you dont need curly braces on the right hand side. 
		 */
		
		Predicate<Integer>shortPred = a->a>18?true:false; 
	}
	
	
	static void ex2() {
		
		
	}

}
