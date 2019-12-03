package com.android;

public class Animal {
	
	int age;
	
	@Override
	public String toString() {
		return "this is an Animal";
	}

}


class Dog extends Animal{
	
	@Override
	public String toString() {
		return "This is a Dog";
	}
}


class Poodle extends Dog{
	
	@Override
	public String toString() {
		return "This is a Poodle";
	}
}


class Cat extends Animal{
	
	@Override
	public String toString() {
		return "This is a Cat";
	}
}