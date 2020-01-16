package com.android;

public class Dog {
	
	int age;
	int weight;
	
	public Dog(int age, int weight) {
		super();
		this.age = age;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Dog [age=" + age + ", weight=" + weight + "]";
	}
	
	Cat makeCat() {
		return new Cat(age, weight);
	}
	
	
	

}
