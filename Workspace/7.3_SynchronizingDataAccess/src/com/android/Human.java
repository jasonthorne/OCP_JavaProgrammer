package com.android;

public class Human {
	
	int age;
	double weight;
	double height;
	
	enum Nationality{
		IRISH, POLISH, BRITISH, INDIAN, CROATION, RUSSIAN;
	}
	
	Nationality nation;

	public Human(int age, double weight, double height, Nationality nation) {
		super();
		this.age = age;
		this.weight = weight;
		this.height = height;
		this.nation = nation;
	}
	
	

	public void setAge(int age) {
		this.age = age;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public void setNation(Nationality nation) {
		this.nation = nation;
	}




	@Override
	public String toString() {
		return "Human [age=" + age + ", weight=" + weight + ", height=" + height + ", nation=" + nation + "]";
	}
	
	

}
