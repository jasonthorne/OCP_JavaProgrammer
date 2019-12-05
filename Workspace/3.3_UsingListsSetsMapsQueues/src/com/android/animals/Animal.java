package com.android.animals;

public class Animal {
	
	static int animalCount = 0;
	int id;
	int age;
	String name;

	public Animal(){
		animalCount++;
		id=animalCount;
	}

	public Animal(int age, String name) {
		super();
		this.age = age;
		this.name = name;
		animalCount++;
		id=animalCount;
	}
	
	
	@Override
	public String toString() {
		return "name is: " + name + ". age is: " + age;
	}
	

}
