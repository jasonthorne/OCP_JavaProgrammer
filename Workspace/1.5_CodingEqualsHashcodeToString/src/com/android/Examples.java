package com.android;

import java.util.Arrays;
import java.util.List;

public class Examples {
	
	static void ex1() {
		
		//OVERRIDING TOSTRING METHOD
		
		System.out.println("OVERRIDING TOSTRING METHOD:");
		
		List<String>names=Arrays.asList("noel", "laura", "shelly");
		
		System.out.println(names); //println implicitly calls the String Object's toString method
		
		System.out.println(names.toString()); //println implicitly calls the String toString method
		
		/*
		 * toString() method is a method of the string class and is called automatically whenever an object of any type is placed within a print statement. 
		 * You can also explicitly call the toString()
		 * i.e Animal andy = new Animal();
		 * every object then has a toString method and everyone can override the toString() method of the object class.
		 * The arraylist class overrides the toString of the object class and will print out all of the contents of this list. 
		 */
		
		
		Cards myCards = new Cards();
		
		/*
		 * Cards doeant have an overridden toString, so it just prints out the address:
		 */
		
		System.out.println(myCards);
		
		
		
		Animal andy = new Animal();
		Animal angela = new Animal(3, "angela");
		
		System.out.println(andy);
		System.out.println(angela);
		
	}

}
