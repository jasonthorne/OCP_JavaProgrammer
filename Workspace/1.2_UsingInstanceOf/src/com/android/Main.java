package com.android;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("******InstanceOf*******");
		
		/*
		 * InstanceOf returns a boolean, but will ONLY COMPILE for something that COULD be true.
		 * There has to be some sort of relationship inorder for the code to compile.
		 */
		
		HeavyAnimal heavyHippo = new Hippo(); //this is a heavyAnimal superclass reference to a subclass Hippo object.
		
		System.out.println(heavyHippo instanceof HeavyAnimal); //is heavyHippo a HeavyAnimal object
		
		System.out.println(heavyHippo instanceof Hippo); //is  heavyHippo a Hippo object
		
		
		//this is a HeavyAnimal reference o it COULD BE refering to an Elephant object, as an Elephant is a subclass of HeavyAnimal.
		//so there IS a relationship between this object and the Elephant class. However this particualr object is NOT AN ELEPHANT, so it will compile, but it will be false.
		System.out.println(heavyHippo instanceof Elephant); //is heavyHippo an Elephant object
		
		/*
		 * There is no relationship between a Cow and a Hippo or a HeavyAnimal so this will NOT compile. 
		 * instanceof can only be used for compatible types, or will only compile for something that COULD be true.
		 */
		
		//System.out.println(heavyHippo instanceof Cow);
		
		Hippo henry = new Hippo();
		
		//henry is a Hippo reference to a Hippo object, so this will not compile as henry could NEVER be an Elephant:
		//System.out.println(henry instanceof Elephant); ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	}

}
