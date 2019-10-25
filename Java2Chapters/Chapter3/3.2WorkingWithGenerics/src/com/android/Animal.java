package com.android;

public class Animal {
	protected double weight;
	protected double height;
	void eat() {
		System.out.println("Animal eating");
	}
	
	void sleep() {
		System.out.println("Animal sleeping");
	}
	
	static void stampede() {
		System.out.println("Animal stampedge");
	}

}

class Elephant extends Animal{
	int age;
	
	
	Elephant(){
		System.out.println("Elephant created");
	}
	@Override
	void eat() {
		System.out.println("Elephant eating");
	}
	@Override
	void sleep() {
		System.out.println("Elephant sleeping");
	}
	
	public String toString() {
		return "nellie the elephant is my name";
	}
}

class Zebra extends Animal{
	String name;
	
	Zebra(){
		System.out.println("Zebra Created");
	}
	@Override
	void eat() {
		System.out.println("Zebra eating");
	}
	
	@Override 
	void sleep() {
		System.out.println("Zebra sleeping");
	}
}

class Cow extends Animal{
//	private double height;
	//private double weight;
	private int age;
	//can't create a cow outside of the Cow class, will use Builder pattern to create Cow
	private Cow() {
		System.out.println("Cow created");
	}
	//using the Builder pattern to create cows
	public static class CowBuilder{
		private Cow myCow=new Cow();
		
		public CowBuilder setHeight(double height) {
			myCow.height=height;
			return this;
		}
		
		public CowBuilder setWeight(double weight) {
			myCow.weight=weight;
			return this;
		}
		
		public CowBuilder setAge(int age) {
			myCow.age=age;
			return this;
		}
		
		public Cow build() {
			return myCow;
		}
	}
}
