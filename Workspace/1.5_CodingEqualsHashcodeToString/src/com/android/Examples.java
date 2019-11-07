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
		
		List<Animal>animals=Arrays.asList(andy, angela, new Animal(4, "Anthony"));
		System.out.println("animals: " + animals);
		
		List<Cards>cards=Arrays.asList(new Cards(), new Cards(), new Cards());
		System.out.println("cards: " + cards);
		
	}
	
	
	static void ex2() {
		
		System.out.println("overriding equals method");
		
		
		/*
		 * public boolean equals(Object obj) is a method of the Object class and again, every object that is created in java will inherit this method. 
		 * This method is used to check if two objects are the same.
		 * If two objects are the same this method will return true. False if not the same.
		 * If a class does NOT override this method, it will take its implementation from the Object class. 
		 * This returns true if they are the same object, and false in all other circumstances. 
		 * 
		 * If a class overrides the equals() method, it is up to the programmer to determine what will constitute if two objects are the same, and return true. 
		 * So equals can be used to only check certain variables of an object if that is what the program requires. 
		 * Equals is usually overridden in conjunction with hashcode. Hashcode can be used in the equals method. 
		 */
		
		/*
		 * == is for checking if 2 PRIMITIVES have the same values, or if 2 references reference to the same object.
		 * 
		 */
		
		//primitives:
		int num = 5;
		int num2 = 5;
		int num3 = 10;
		
		System.out.println(num==num2); //true
		System.out.println(num==num3); //false
		
		
		//objects:
		Animal andy = new Animal();
		Animal angela = andy;
		Animal anthony = new Animal();
		
		System.out.println(andy==angela); //true - checks if the references point to the same object
		System.out.println(angela==anthony); //false 
		
		//++++++++++++++++++++++++++++++++++++++++++++++IMPORTANT
		//String has it's own overridden equals() method, which returns true if the CONTENTS of the string are the same. 
		//It doesnt matter if they are different strings. 
		
		String s1 = new String("lion"); //- not in the string pool
		String s2 = new String("lion"); //- not in the string pool
		String s3 = "lion"; //in string pool
		
		System.out.println(s1==s2); //false
		System.out.println(s1.equals(s2)); //true as equals CHECKS THE CONTENTS
		System.out.println(s1.equals(s3)); 
		
		
		System.out.println("checking cards");
		//at this point, the cards class has no overridden equals() method, so it uses the equals() method from the object class.
		//which just checks to see if they are the same object. 
		
		Cards myCard = new Cards();
		Cards myCard2 = new Cards();
		Cards myCard3 = myCard;
		System.out.println(myCard == myCard2); //false
		System.out.println(myCard == myCard2); //false
		
		System.out.println("Checking StringBuilders");
		
		/*
		 * Stringbuilder doesn not have its own equals method, so it uses the Object class'es equals method.
		 * Whixh only checks if they are the same object. 
		 */
		
		StringBuilder sb1 = new StringBuilder("lion");
		StringBuilder sb2 = new StringBuilder("lion");
		System.out.println(sb1.equals(sb2));
		
		System.out.println("using toString to find if two stringbuilders are the same");
		
		System.out.println(sb1.toString().equals(sb2.toString()));
		
		
		//======================================
		
		System.out.println("comparing Dogs:");
		Dog dog1 = new Dog(1, "spot");
		Dog dog2 = new Dog(1, "spot");
		Dog dog3 = new Dog(2, "rex");
		Dog dog4 = dog1;
		
		System.out.println("dog1 & dog2: " + dog1.equals(dog2)); //same values
		System.out.println("dog2 & dog3: " + dog2.equals(dog3));
		System.out.println("dog4 & dog1: " + dog4.equals(dog1)); //same dog
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
