package com.android;

public class Animal {
	
	int age;
	String name;
	
	//blank constructor:
	Animal(){
		
	}
	
	//consructor that takes an int & string:
	Animal(int age, String name){
		this.age = age;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "age is: " + age + ". name is: " + name;
	}

}
