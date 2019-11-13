package com.android;

import com.android.Animal.Liver;

public class Examples {
	
	static void ex1() {
		System.out.println("local member classes");
		Animal andy = new Animal(12, "Andy", 3.33);
		
		Animal.Liver liver = new Animal().new Liver();
		
		andy.myLiver.cleanse();
		
		/*
		 * The inner class Liver is a public class, so we have access to any members of this class as long as they are public, protected or package level.
		 * cleanse() is a public method of the liver class, so we can access this method. 
		 */
		//andy.myLiver.recycle(); //doesnt have access to this
		
		//andy.myHeart.beat(); //cant be accessed as the heart class is private. And you cant access any members of the Heart class outside of the Heart class or the Animal class. 
		System.out.println(andy.myHeart); // The inner heart class is private, however the myHeart variable itself isn't private. 
		
		System.out.println("id of any's liver: " + andy.myLiver.id);
		
		Liver liver1 = andy.myLiver;
		System.out.println(liver1.id); //1
		System.out.println(andy.myLiver.id); //1
		System.out.println(andy.myLiver.equals(liver1)); //true
		
		//You cant create a new liver without an Animal. 
		//Liver liver2 = new Animal().new Liver();
		
		//System.out.println("id of liver2 is " + liver2.id);
		
		
		/*
		 * This is using andy to create a new liver, but it is NOT andy's liver. It is a standalone liver, existing outside of an Animal.
		 */
		Liver liver3 = andy.new Liver();
		System.out.println("id of andy's liver is: " + andy.myLiver.id);
		System.out.println(liver3.id);
		
		/*
		 * When you have a public inner class, you can create a standalone object that can exist without it's outser class.
		 * I.E we can create a Liver that doesnt belong to a particular Animal, because it is a public inner class.
		 * We CANT create a stand alone heart as it is a private class,
		 * We cant create a Heart outside ofd the Animal class.
		 */
		
		andy.myLungs.alive();
		
		Dog myDog = new Dog();
	}
	
	
	
	static void ex2() {
		System.out.println("local inner classes ");
		Human harry = new Human();
		harry.eat();
	}
	
	
	
}


