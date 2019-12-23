package com.android;

public class Animal {
	int age;
	
	@Override
	public String toString() {
		return "This is an Animal";
	}
	
	public void move() {
		System.out.println("Animal moving");
	}

}

class Dog extends Animal{
	final public int age=0;
	@Override
	public String toString() {
		//age=age+15;
		return "this is a dog";
	}
	
	public void move() {
		System.out.println("Dog moving");
	}
	
}

class Poodle extends Dog{
	@Override
	public String toString() {
		return "this is a poodle";
	}
}

class Cat extends Animal{
	@Override
	public String toString() {
		return "this is a Cat";
	}
}
