package com.android;

import java.util.Arrays;
import java.util.List;

public class Examples {
	
	static void ex1() {
		System.out.println("Overriding toString method");
		//public String toString(){}
		List<String>names=Arrays.asList("noel","laura","shelly");
		/*
		 * toString() method is a method of object class and is called
		 * automatically whenever a object of any type is placed within
		 * a print statement. you can also explicitly call the toString()
		 * i.e Animal andy=new Animal();
		 * System.out.println(andy.toString());
		 * every object then has a toString method, and overy can 
		 * override the toString() method of the object class. 
		 * the arraylist class overrides the toString() of the object 
		 * class and will print out all of the contents of this list
		 */
		System.out.println(names.toString());
		//same as above
		System.out.println(names);
		
		Cards myCards=new Cards();
		/*
		 * Cards does not have a overriden toString() method so it will
		 * use the Object class toString method, which basically just
		 * prints out the address
		 */
		System.out.println(myCards);
		
		Animal andy=new Animal();
		Animal angela=new Animal(3,"angela");
		System.out.println(andy);
		System.out.println(angela);
	}
	

}
