package com.android;

public class Cat {
	int age;
	int weight;
	public Cat(int age, int weight) {
		super();
		this.age = age;
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "Cat [age=" + age + ", weight=" + weight + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + weight;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Cat))
			return false;
		Cat other = (Cat) obj;
		if (age != other.age)
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}
	
	

}
