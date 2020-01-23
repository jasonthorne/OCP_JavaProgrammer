package com.android;

import java.util.Optional;

public class Examples {
	
	
	static void ex1() {
		
		//===========================LAZY INSTATIATION
		
		System.out.println("\nex1()");
		
		Dog spot = new Dog(2, "spot");
		
		//-------
		
		Human myHuman = new Human(24, "Jo", 2);
		myHuman.makeShoes();
		
	}
	
	
	
	static void ex2() {
		
		//===========================OPTIONALS - You can use stream-like programming for optionals.
		
		System.out.println("\nex2()");
		
		Optional<Integer>optInt=Optional.of(123);
		
		//check if an optional is present:
		if(optInt.isPresent())
			System.out.println(optInt.get());
			
		/*
		 * We are attempting to check if a number is 3 characters long.		
		 */
		
		if(optInt.isPresent()) {
			Integer num = optInt.get();
			
			String string = "" + num;
			
			if(string.length()==3)
				System.out.println(string+ " is three digits long");
			else
				System.out.println(string+ " is not three digits long");
			
		}//if
		
		
		//----------------------------
		System.out.println("using functional programming with Optional<T>.( Optionals for objects)");
		
		
		//optInt = Optional.empty(); //++++++++evn if the optional is empty, below will still work (as in not fallover :P).
		
		optInt.map(n->""+n) //change optional of type Integer to optional of type String ++++++++++++++++++++++++++++
		.filter((s)->s.length()==3)
		.ifPresent(s->{
			System.out.println("number in string format is: " + s);
			System.out.println("s is a: " + s.getClass().getSimpleName());
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
