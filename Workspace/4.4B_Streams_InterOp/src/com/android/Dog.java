package com.android;

public class Dog implements Comparable<Dog>{
	
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

	@Override
	public int compareTo(Dog d) {
		int result = age - d.age;
		
		if(result !=0) //if they're not the same
			return result; //return result
		result = weight - d.weight; //ELSE
			return result;

	}
	
	
	

}
