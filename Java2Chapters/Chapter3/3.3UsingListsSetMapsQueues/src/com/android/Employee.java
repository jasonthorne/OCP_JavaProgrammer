package com.android;

public class Employee {
	int age;
	String name;
	double weight;
	double height;
	public Employee(int age, String name, double weight, double height) {
		super();
		this.age = age;
		this.name = name;
		this.weight = weight;
		this.height = height;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		long temp;
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	
	

}
