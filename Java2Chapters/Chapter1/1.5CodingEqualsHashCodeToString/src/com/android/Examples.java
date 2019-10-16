package com.android;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

import com.android.Employee.Occupation;

public class Examples {
	
	static void toStringEx() {
		List<String>names=new ArrayList<String>();
		names.add("noel");
		names.add("pat");
		names.add("mary");
		/*
		 * public String toString() is a method of the Object class and is called automatically whenever a 
		 * object of anytime is placed within a print statement. you can also explictly call the toString method
		 * i.e Animal andy=new Animal()
		 * System.out.print(andy.toString());
		 * every object then has a toString method, and every objects class can override the toString method of the
		 * object class. 
		 * The ArrayList class overrides the toString() method of the object class and will print out all the contents
		 * of the arraylist
		 */
		System.out.println(names);
		//same as the above
		System.out.println(names.toString());
		
		Animal andy=new Animal(4,"andy");
		/*
		 * the Animal class overrides the toString method and the overriden toString method will return a string
		 * that displays the age and name of the Animla
		 */
		System.out.println(andy);
		//same as the above
		System.out.println(andy.toString());
		/*
		 * the Human class does NOT	OVERRIDE the toString method so any human will take its toString method from
		 * the object class, which will just print out the address of the object. Any class that does not 
		 * override the toString() method will just print out the address of the object, when an object of the class
		 * is placed in a print statement
		 */
		Human harry=new Human();
		System.out.println(harry);//use's object class toString method
		System.out.println(harry.toString());//same as above
	}
	
	static void equalsMe() {
		/*
		 * public boolean equals(object obj) is a method of the Object class and again every object that is 
		 * created in java will inherit this object. the method is used to check if two objects are the same. 
		 * if the two objects are the same this method returns true, false if not the same. if a class does NOT
		 * overrride this method, it will take its implementation from the Object class, this returns true if the
		 * two objects are the same object, and false in all other circumstances.
		 * if a class overrides the equals() method, it is up to the programmer to determine what will constitute
		 * if two objects are the same and return true
		 * i.e we may determine that two people are the same if they have the same name and age, and disregard
		 * the address of the two people, or we may determine that if they all the same variable them they are the
		 * same. So equals can be  used to only check certain variables of a object if that is what the programs
		 * requires. Equals is usually overloaded in conjucttion with hashcode and also when it comes to 
		 * different types of list such as hashMap
		 */
		/*
		 * ==is for checking if two primitives have same value or if two objects references to the same object
		 * the equals() method of the string class checks if the two strings contain the same values
		 */
		String s1=new String("lion");
		String s2=new String("lion");
		//will return true
		System.out.println("two Strings "+s1.equals(s2));
		System.out.println(s1==s2);//will return false, as not the same object
		/*
		 * StringBuilder does NOT provide its own implementation of equals() so it uses the Object class equals()
		 * method which just checks if they are the same object
		 */
		StringBuilder sb1=new StringBuilder("lion");
		StringBuilder sb2=new StringBuilder("lion");
		System.out.println("two stringBuilders "+sb1.equals(sb2));//false
		//toString returns a String which can be used to check and will return true
		System.out.println("using toString with StringBuilders "+sb1.toString().equals(sb2.toString()));//true
		
		Dog spot=new Dog(3,"spot");
		Dog rex=new Dog(3,"spot");
		System.out.println("comparing two dogs with same age and name");
		System.out.println(spot.equals(rex));
		System.out.println("comparing two dogs with different age and name");
		Dog lassie=new Dog(4,"lassie");
		System.out.println(lassie.equals(spot));
		System.out.println("comparing one Dog with two references");
		spot=rex;
		System.out.println(spot.equals(rex));//true same dog
		System.out.println("comparing a cat and dog always false");
		Cat tibbles=new Cat(3,"spot");
		/*
		 * even though they have the same name and age, this will always return false as two different
		 * objects
		 */
		System.out.println(spot.equals(tibbles));
		/*
		 * and false if the Cat calls the equals method, 
		 */
		System.out.println(tibbles.equals(spot));
		/*
		 * the Cat class takes it's equals method from the Animal class and this equals() method is more
		 * comprehensive than the equals method of the Dog class
		 */
		System.out.println("comparing two cats");
		tibbles=new Cat(3,"tibbles");
		Cat tom=new Cat(3,"tibbles");
		System.out.println(tibbles.equals(tom));//true
		Cat puss=new Cat(4,"puss");
		System.out.println(puss.equals(tibbles));//false
		tibbles=tom;
		System.out.println(tibbles.equals(tom));//same cat so true
		
		System.out.println("comparing two Cows");
		/*
		 * the equals() method of the Cow class is a much simplier affair than the equals() for Cat or Dog class.
		 * if the two objects are both cows and have the same age then the equals() method returns true
		 */
		Cow bessie=new Cow(3,"bessie");
		Cow daisy=new Cow(3,"daisy");
		System.out.println(bessie.equals(daisy));//both cows and same age so true
		bessie=new Cow(4,"bessie");
		daisy=new Cow(5,"bessie");
		System.out.println(bessie.equals(daisy));//different ages so false
		System.out.println("comparing two Humans");
		/*
		 * the Human class has no overridden equals() method so it takes its equals method from the Object class,
		 * which only returns true if its the same object
		 */
		Human harry=new Human(34,"Harry");
		Human henry=new Human(34,"Harry");
		System.out.println(harry.equals(henry));//false as only check if same object
		harry=henry;
		System.out.println(harry.equals(henry));//true as  harry and henry are the same human
		/*
		 * the way we have the equals method done for dog means that it does not take into account null values
		 * for the String name of each Dog. so if each dog has a null for name the equals method we have for Dog
		 * will state that both Dogs have the same name. The Animal equals() method does not allow this to happen
		 */
		spot=new Dog();
		rex=new Dog();
		System.out.println(spot.equals(rex));
	}
	
	static void hashMe() {
		/*
		 * hashCode() is a method of the object class that is usually overriden with the equals() method and
		 * can be used in conjuction with the equals() method to uniquely identify an object. it is used in particular
		 * with hashMaps which are covered in detail in chapter 3. A hash is a number that is produced usually
		 * from the varialbes of a object (which can be used to identify the object
		 */
		String name="noel";
		/*
		 * the string class has it's own overridden hashCode() method
		 */
		System.out.println("hashcode of string noel is "+name.hashCode());
		name="mary";
		System.out.println("hashCode of string mary is "+name.hashCode());
		name="Mary";
		System.out.println("hashCode of String Mary is "+name.hashCode());
		
		List<String>names=new ArrayList<String>();
		names.add("pat");
		names.add("mary");
		names.add("john");
		List<String>names2=new ArrayList<String>();
		names2.add("pat");
		names2.add("mary");
		names2.add("john");
		System.out.println("Arraylist class also has it's own hashCode method");
		/*
		 * both these produce the same hash, so equals() will return true for these two arraylists
		 */
		System.out.println("names hashCode is "+names.hashCode());//
		System.out.println("names2 hashCode is "+names2.hashCode());
		/*
		 * the arrayList class uses the hashCode method to determine if the two arraylists are the same. the 
		 * hashCode is produced, by in this case, each string in the list producing a hash code, and all of these
		 * hashs produces are combined to produce a final hash for the whole arraylist
		 */
		System.out.println(names.equals(names2));
		try {
			/*
			 * this throws illegalArgument exception
			 */
			Cards nullCards=new Cards(null,null);
		}
		catch(Exception e) {
			System.out.println("creating cards with default options");
			Cards notNullCards=new Cards("Queen","Diamonds");
		}
		
		Occupation job=Occupation.Doctor;
		Employee eddie=new Employee(23,"eddie",123.4,job);
	}
	
	static void bitwise() {
		int num=60;
		/*
		 * this number in binary is 111100
		 */
		System.out.println("binary version of 60 is "+(Integer.toBinaryString(num)));
		/*
		 * The right shift operator >>, moves all the right most bits 2 places in this situation
		 * so the number 
		 * 111100
		 * becomes
		 * 1111
		 * the left shift operator << does the exact opposite
		 */
		System.out.println(num>>2);
		/*
		 * which is in binary 10_000_000
		 */
		System.out.println(Integer.toBinaryString(num>>2));
		/*
		 * this zero fill right shift does the same as the left shift operator, but it fills  up the shifted
		 * bits with 0's, so 
		 * 111100
		 * becomes
		 * 001111
		 * (in effect it does the same
		 */
		System.out.println(num>>>2);
		/*
		 * bitwise XOR
		 */
		num=60;
		int num2=15;
		/*
		 * if both are 1 then produce will be zero, otherwise will be 1
		 * so we have
		 * 111100
		 *   1111 produces
		 * 110011  
		 *   
		 */
		System.out.println("60 in binary "+Integer.toBinaryString(num));
		System.out.println("15 in binary "+Integer.toBinaryString(num2));
		System.out.println(Integer.toBinaryString(num^num2));

	}

}
