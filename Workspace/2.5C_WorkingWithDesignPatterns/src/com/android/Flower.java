package com.android;

public class Flower {
	
	int age;
	enum types{
		ROSE, TULIP, BAGONIA, THISTLE;
	};
	types type;
	double weight;
	double height;
	enum colour{
		RED,BLUE,GREEN,YELLOW,PURPLE,PINK;
	};
	colour colour;
	boolean smell;
	int petalCount;
	
	//blank constructor
	private Flower(){
		System.out.println("Flower constructor called");
	}
	
	
	
	@Override
	public String toString() {
		return "Flower [age=" + age + ", type=" + type + ", weight=" + weight + ", height=" + height + ", colour="
				+ colour + ", smell=" + smell + ", petalCount=" + petalCount + "]";
	}

	static class FlowerBuilder{
		private Flower myFlower = new Flower(); //create a flower
		
		public FlowerBuilder setAge(int age) {
			myFlower.age=age; //set age
			return this; //return this object
		}
		
		public FlowerBuilder setWeight(double weight) {
			myFlower.weight=weight;
			return this;
		}
		
		public FlowerBuilder setHeight(double height) {
			myFlower.height=height;
			return this;
		}
		
		public Flower Build() {
			return myFlower; //return just a flower
		}
		
		
		
	}

}//end of class Flower


