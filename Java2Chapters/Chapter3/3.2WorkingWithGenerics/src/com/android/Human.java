package com.android;

public class Human {
	private int age;
	private String  name;
	private double weight;
	
	private Human() {
		
	}
	
	static class HumanBuilder{
		private Human myHuman=new Human();
		
		public HumanBuilder setAge(int age) {
			myHuman.age=age;
			return this;
		}
		
		public HumanBuilder setName(String name) {
			myHuman.name=name;
			return this;
		}
		
		public HumanBuilder setWeight(double weight) {
			myHuman.weight=weight;
			return this;
		}
		
		public Human build() {
			return myHuman;
		}
	}

}
