package com.android.animals;

public class Elephant extends Animal{
	public int age;
	//constructor of elephant class
	public Elephant(){
		System.out.println("Elephant created");
	}
	/*
	 * Overriding eat() method from super class Animal
	 */
	@Override
	public void eat() {
		System.out.println("Elephant eating");
	}
	/*
	 * Overriding sleep() method from the super class Animal
	 */
	@Override
	public void sleep() {
		System.out.println("Elephant sleeping");
	}
	/*
	 * Overriding the toString() method of the Object class
	 */
	@Override
	public String toString() {
		return "nellie the elephant is my name";
	}

}
