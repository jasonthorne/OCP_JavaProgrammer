package com.android.animals;

public class Elephant  extends Animal{

	int age;
	
	//constructor:
	public Elephant(){
		System.out.println("Elephant created");
	}
	
	@Override //overriding eat method from superclass Animal
	public void eat() {
		System.out.println("Elephant eating");
	}
	
	@Override //overriding sleep method from superclass Animal
	public void sleep() {
		System.out.println("Elephant sleeping");
	}
	
	@Override //overriding the toString method of the object class
	public String toString() {
		return "Nellie the Elephant is my name";
	}
	
	
	
	
}
