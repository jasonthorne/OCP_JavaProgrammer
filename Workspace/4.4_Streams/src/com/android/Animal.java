package com.android;

public class Animal {
	
	int age;
	String name;
	public Animal(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Animal [age=" + age + ", name=" + name + "]";
	}
	
	

}
