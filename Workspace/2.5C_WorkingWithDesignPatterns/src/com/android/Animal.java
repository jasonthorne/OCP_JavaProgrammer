package com.android;

//IMMUTABLE CLASS: 
public final class Animal {
	
	private final String name;
	private final int age;
	
	Animal(String name, int age){
		this.name=name;
		this.age=age;
	}
	
	//string is an immutable class itself, so its fine to return a string.
	public String getName() {
		return name;
	}
	
	//primitives are returned by value, so this is fine to return as well.
	public int getAge() {
		return age;
	}

	
	@Override
	public String toString() {
		return "Animal [name=" + name + ", age=" + age + "]";
	}
	
	

	
	
}
