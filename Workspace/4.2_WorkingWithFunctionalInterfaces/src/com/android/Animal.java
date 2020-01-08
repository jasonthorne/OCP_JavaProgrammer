package com.android;

public class Animal {
	
	int age; 
	String name;
	
	
	public Animal(int age, String name) {
		super();
		this.age = age;
		this.name = name;
		System.out.println("Animal with age and name provided created");
	}
	
	public Animal() {
		System.out.println("Animal withh no args created");
	}

	
	@Override
	public String toString() {
		return "Animal [age=" + age + ", name=" + name + "]";
	}
	
	static void takeString(String myStr) {
		System.out.println(myStr+ " in static method takeString()");
	}
	
	void eat(String food) {
		System.out.println("I eat: " + food);
	}
	
	
	Integer drink() {
		System.out.println("Animal drinking");
		return 1;
	}
	
	
	static Double statMethod() {
		return 12.3;
	}

}



class Hamster extends Animal{
	
}


class Cat extends Animal{
	
}

