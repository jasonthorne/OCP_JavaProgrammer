package com.android;

import com.android.Flower.Colour;
import com.android.Flower.Type;

public class Flower {
	
	public Flower(int age, Type type, double weight, double height, Colour colour, boolean smell, int petals) {
		super();
		this.age = age;
		this.type = type;
		this.weight = weight;
		this.height = height;
		this.colour = colour;
		this.smell = smell;
		this.petals = petals;
	}


	int age;
	enum Type{
		ROSE,TULIP,PANSY,BAGONIA,VIOLET
	}
	Type type;
	double weight;
	double height;
	enum Colour{
		RED,BLUE,GREEN,YELLOW,PURPLE,WHITE,PINK
	}
	Colour colour;
	//has it a smell or not
	boolean smell;
	int petals;
	
	double price;
	
	Flower(){
		System.out.println("flower constructor called");
	}
	
	
		@Override
	public String toString() {
		return "Flower [age=" + age + ", type=" + type + ", weight=" + weight + ", height=" + height + ", colour="
				+ colour + ", smell=" + smell + ", petals=" + petals + "]";
	}
}
/*
 * this is a class for building flowers, nameing convention is name of the
 * class of Objects it is creating, in this case
 * Flower
 * followed by the word
 * Builder
 * and you end up with 
 * FlowerBuilder
 */
class FlowerBuilder{
	/*
	 * when using the Builder class the first thing you need to do is
	 * to create and instance of the Object you will be creating. In this
	 * case we create a Flower, that calls the blank constructor in
	 * the Flower class
	 * this produces a flower that will have default values for all of it's 
	 * variables
	 * we normally make it private
	 */
			private Flower myFlower=new Flower();
		/*
		 * we need to create setters for each one of the Variables of 
		 * the Flower class. if you don't want to be able to set a value,
		 * then just dont' have a setter for it.	
		 * each setter HAS TO return a Builder object, in this case, each 
		 * setter has to return a FlowerBuilder Object. So each one of these 
		 * methods can be chained
		 * i.e
		 * new FlowerBuilder().setAge(10).setTypes(Types.Rose).
		 */
			/*
			 * each one of these setters returns the same FlowerBuilder
			 * object that is calling this method. So each one of these methods
			 * can call ALL of the methods of the FlowerBuilder class
			 * setAge(10).setColour(Colour.RED)
			 * each one of these setters is giving some variable of the 
			 * flower created in this class (myFlower) a value
			 * for instance setAge is giving myFlowr and age other than the 
			 * default of 0.
			 */
			public FlowerBuilder setAge(int age) {
				//this gives the Flower variable myFlower an age
				myFlower.age=age;
				//this returns the same flowerBuilder object that calls this
				//method
				return this;
			}
			/*
			 * returns same FlowerBuilder object and gives myFlower variable
			 * a type (rose, tulip, etc)
			 */
			public FlowerBuilder setType(Type type) {
				myFlower.type=type;
				return this;
			}
			/*
			 * returns same FlowerBuilder object and gives myFlower variable
			 * a weight
			 */
			public FlowerBuilder setWeight(double weight) {
				myFlower.weight=weight;
				return this;
			}
			/*
			 * returns same FlowerBuilder objects and gives myFlower variable
			 * a Height
			 */
			public FlowerBuilder setHeight(double height) {
				myFlower.height=height;
				return this;
			}
			/*
			 * returns same FlowerBuilder objects and gives myFlower variable
			 * a colour (RED,BLUE,etc)
			 */
			public FlowerBuilder setColour(Colour colour) {
				myFlower.colour=colour;
				return this;
			}
			/*
			 * returns same FlowerBuilder objects and gives myFlower variable
			 * a smell (true/false)
			 */
			public FlowerBuilder setSmell(boolean smell) {
				myFlower.smell=smell;
				return this;
			}
			/*
			 * returns same FlowerBuilder objects and gives myFlower variable
			 * a petals, which is the amount of petals on a flower
			 */
			public FlowerBuilder setPetals(int petals) {
				myFlower.petals=petals;
				return this;
			}
			
			public FlowerBuilder setPrice(double price) {
				myFlower.price=price;
				return this;
			}
			/*
			 * by convention the last method in the Builder class is  called
			 * build
			 * this returns the Flower that all the setter methods have given
			 * it various variable values 
			 * i.e setWeight(12) would give the flower a weight of 12
			 * setColour(Colour.RED) would give the flower a colour of Red
			 * this returns the flower that has been modified by all of the
			 * setter methods
			 */
			public Flower build() {
				return myFlower;
			}
	
		}
