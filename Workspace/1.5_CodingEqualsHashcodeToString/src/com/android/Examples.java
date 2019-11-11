package com.android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.android.Employee.Occupation;

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
		
		//Cards myCards = new Cards();
		
		/*
		 * Cards doeant have an overridden toString, so it just prints out the address:
		 */
		
		//System.out.println(myCards);
		
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
		
		
		//These dogs will either be true or cause a nullPointerException. See Dog class for explanation. ++++++++++++++++++++++++++
		Dog noDog1 = new Dog(); //a dog with age of 0 & a name of null
		Dog noDog2 = new Dog(); //a dog with age of 0 & a name of null
		System.out.println("noDog1 & noDog2: " + noDog1.equals(noDog2));
		
		Animal animal1 = new Animal(2, "Andy");
		Animal animal2 = new Animal(2, "Andy");
		System.out.println(animal1.equals(animal2));
		
		animal2 = new Animal(2, "Angela");
		
		
		//==================
		
		Dog spot = new Dog(1, "spot");
		Cat tibbles = new Cat(1, "spot");
		
		System.out.println("Comparing Dog & Cat:");
		System.out.println(spot.equals(tibbles));
		
		System.out.println("Comparing Cat & Dog:");
		System.out.println(tibbles.equals(spot));
		
		
		//==========COMPARIMG PIGS
		
		Pig murty = new Pig(1, "murty");
		Pig bob = new Pig(1, "murty");
		tibbles = new Cat(1, "murty");
		
		/*
		 * This pig calls the equals method, that will always return false if comparing with an Animal that is NOT a pig.
		 * Tibbles is a cat so this is false. 
		 * This uses the pig equals() method which checks first if they're pigs, so this will always be false. 
		 */
		
		System.out.println(murty.equals(tibbles));
		System.out.println(murty.equals(bob));
		
		System.out.println("Comparing cat with a pig: ");
		//this uses the animals equals method which doesnt take into account if the anuimals are different species.
		//it only checks to see if they're both animals with the same name and age so this will return true. 
		System.out.println(tibbles.equals(bob));
		
		
		
		Sheep sheep1 = new Sheep(1, "shawn", 2.56);
		Sheep sheep2 = new Sheep(1, "shawn", 2.56);
		Sheep sheep3 = new Sheep(1, "shawn", 3.2);
		System.out.println(sheep1.equals(sheep2));
		System.out.println(sheep1.equals(sheep3));
		System.out.println(sheep1.equals(tibbles));
		
	}
	
	
	//++++++++++++++++++++++++++++++++HASH CODES: +++++++++++++++++++++++++++++++++++++++++++++++++
	
	/*
	 * A hascode is a method of the object class and is usually overriden with the equals method. 
	 * And can be used in conjunction with the equals method to uniquelt identify an object.
	 * It is used in particular with hashmaps and sets which are covered in detail in chapter 3.  
	 * A hash is a number which is produced usually from variables of an object. Which can be used to identify an object.  
	 */
	
	static void ex3() {
		
		String name1 = "yo";
		System.out.println("String hashcodes:");
		System.out.println("hashcode of name is: " + name1.hashCode());
		
		String name2 = "dawg";
		
		List<String>names1 = new ArrayList<String>();
		names1.add(name1);
		names1.add(name2);
		System.out.println("hashcode of names1 is: " + names1.hashCode());
		
		List<String>names2 = new ArrayList<String>();
		names2.add(name1);
		names2.add(name2);
		System.out.println("hashcode of names2 is: " + names2.hashCode()); //Same hashcode as names1 (list order MATTERS)
		
		/*
		 * The arraylist class uses the hashcode method of whatever data type it contains to determine if both lists are the same.
		 * In this case, the list hashcode is produced by the string hashes of each string in the list.
		 * Lists with the same objects in them will have the same hashcode.
		 */
		
		
		//===========================
		Employee eddie = new Employee(123, "eddie", 234.2, Occupation.NURSE);
		
		/*
		double weight = 12345.678;
		long temp;
		temp = Double.doubleToLongBits(weight); //convert a double to long
		System.out.println(temp);
		
		*/
		Employee emp2 = new Employee(123, "eddie", 234.2, Occupation.NURSE);
		
		
		//same hashcodes as they have the same properties:
		System.out.println(eddie.hashCode());
		System.out.println(emp2.hashCode());
		
	}
	
	
	
	static void ex4() {
		
		int num = 60;
		
		System.out.println("binary version of 60: " + Integer.toBinaryString(num));	//this is binary  number: 111100
		
		System.out.println("right bit shifting >>");
		
		/*
		 * the right shift operator >> moves all of the right most bits 2 places in this situation.
		 * So the number 111100 becomes: 1111
		 */
		System.out.println("60 right bit shift 2 is: " + (num >> 2) + ". In binary: " + Integer.toBinaryString(num >> 2)); 
		
		System.out.println("60 left bit shift 2 is: " + (num << 2) + ". In binary: " + Integer.toBinaryString(num << 2));
		
		//---------------------
		
		/*
		 * Zero fill right shift: Basically does the same thing as the right shift operator, but it fills up the bits with zeros.
		 */
	
		//=======================================+++++++++++++++++++++++++++++++++++++
		//BITWISE XOR
		
		System.out.println("BITWISE XOR");
		
		num = 60;
		int num2 = 15;
		
		System.out.println("60 in binary: " + Integer.toBinaryString(num));
		System.out.println("15 in binary: 00" + Integer.toBinaryString(num2));
		System.out.println("60 XOR 15:    " + Integer.toBinaryString(num^num2));
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
