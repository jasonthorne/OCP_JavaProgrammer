package com.android;

public class Dog implements Comparable<Dog>{
	
	int age;
	int weight;
	
	//constructor for Dog class
	public Dog(int age, int weight) {
		super();
		this.age = age;
		this.weight=weight;
	}
	
	Cat makeCat() {
		return new Cat(age,weight);
	}

	@Override
	public String toString() {
		return "Dog [age=" + age + ", weight=" + weight + "]";
	}

	@Override
	public int compareTo(Dog d) {
		int result=age-d.age;
		if(result!=0)
			return result;
		result=weight-d.weight;
		return result;
	}
	
	

}
