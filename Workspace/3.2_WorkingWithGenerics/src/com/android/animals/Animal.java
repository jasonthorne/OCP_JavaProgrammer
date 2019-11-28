package com.android.animals;

public class Animal {
	
	int age;
	Animal partner;
	
	public Animal(int age) {
		this.age = age;
	}
	
	
	public Animal(Animal partner) {
		this.partner = partner;
	}

}
