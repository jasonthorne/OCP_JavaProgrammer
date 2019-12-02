package com.android.animals;

public class Cow extends Animal {

	private int age;
	
	//cant create a cow outside of the cow class
	private Cow() {
		System.out.println("Cow created");
	}
	
	public static class CowBuilder{
		private Cow myCow = new Cow();
		
		public CowBuilder setHeight(double height) {
			myCow.height = height;
			return this;
		}
		
		
		public CowBuilder setWeight(double weight) {
			myCow.weight = weight;
			return this;
		}
		
		
		public CowBuilder setAge(int age) {
			myCow.age = age;
			return this;
		}
		
		public Cow build() {
			return myCow;
		}
		
	}
	
}
