package com.android;

public class Duck {
	private int weight;
	private String name;
	
//constructor
	public Duck(int weight, String name) {
		super();
		this.weight = weight;
		this.name = name;
	}
		public int getWeight() {
		return weight;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Duck weight=" + weight + ", name=" + name + "]";
	}
	
	void fly() {
		System.out.println(name+" duck flying");
	}
	
	Duck procreate() {
		return new Duck(0,"babyDuck");
	}

}
