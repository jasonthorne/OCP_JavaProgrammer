package com.android;

public class Flower {
	
	int age;
	enum type{
		ROSE, TULIP, BAGONIA, THISTLE;
	};
	type type;
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
	
	
	/*
	@Override
	public String toString() {
		return "Flower [age=" + age + ", type=" + type + ", weight=" + weight + ", height=" + height + ", colour="
				+ colour + ", smell=" + smell + ", petalCount=" + petalCount + "]";
	}

	*/
	
	
	
	@Override
	public String toString() {
		return "Flower [age=" + age + ", type=" + type + ", weight=" + weight + ", height=" + height + ", colour="
				+ colour + ", smell=" + smell + ", petalCount=" + petalCount + "]";
	}


	//this is a class for building flowers. Naming ocnventiaon is: 'name of the class of objects it's creating', followed by the word 'builder'
	static class FlowerBuilder{
		
		/*
		 * When using the builder class, the first thing you need to do is create an instance of the object you will be creating.
		 *  In this case we create a flower, that calls the blank constructor in the flower class.
		 *  This produces a flower that will have default values for all of it's variables.
		 *  We normally make it private.
		 */
		
	

		private Flower myFlower = new Flower(); //create a flower
		
		/*
		 * We need to create setters for each one of the variables of the Flower class.
		 * Each setter has to return a FlowerBuilder oject. So each of these methods can be chained.
		 * I.E: new FlowerBuilder().setAge(10).setTypes(Types.Rose);
		 * 
		 * each one of these setters returns the same FlowerBuilder object that is calling this method. 
		 * So each one of these methods can call ALL of the methods of the FlowerBuilder class.
		 */
		
		public FlowerBuilder setAge(int age) {
			myFlower.age=age; //set age
			return this; //return this object
		}
		
		public FlowerBuilder setType(type type) {
			myFlower.type = type;
			return this;
		}
		
		public FlowerBuilder setWeight(double weight) {
			myFlower.weight=weight;
			return this;
		}
		
		public FlowerBuilder setHeight(double height) {
			myFlower.height=height;
			return this;
		}
		
		public FlowerBuilder setColour(colour colour) {
			myFlower.colour=colour;
			return this;
		}
		
		/*
		By convention the last method in the builder class is called build.
		This returns the Flower that all the setter methods have given various variable values.
		This returns the flower that has been modified by the setter methods.
		*/
		public Flower build() {
			return myFlower; //return just a flower ++++++++++++++++
		}
		
		
		
	}

}//end of class Flower


