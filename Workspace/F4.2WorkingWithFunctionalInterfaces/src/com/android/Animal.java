package com.android;

public class Animal {
	int age;
	String name;
	public Animal(int age, String name) {
		super();
		this.age = age;
		this.name = name;
		System.out.println("animal with age and name created");
	}
	Animal(){
		System.out.println("animal with no arguements created");
	}
	@Override
	public String toString() {
		return "Animal [age=" + age + ", name=" + name + "]";
	}
	
	static void takeString(String myStr) {
		System.out.println(myStr+" in static method takeString");
	}
	void eat(String food) {
		System.out.println("i eat "+food);
	}
	Integer drink() {
		System.out.println("animal drinking");
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
