package com.android;

public class Animal {
	int age;

	@Override
	public String toString() {
		return "this is a Animal";
	}
}

class Dog extends Animal{

	@Override
	public String toString() {
		return "this is a Dog";
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
		return "this is a cat evil cackle";
	}
}
