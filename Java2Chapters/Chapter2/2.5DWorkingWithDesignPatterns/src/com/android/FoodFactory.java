package com.android;

public class FoodFactory {
	/*
	 * each of these methods return a food object, what type of food is dependant on what Animal is sent to the 
	 * method, this is determined at runtime via a case statement
	 */
	/*
	 * this method uses a string to determine what food is produced
	 */
	public static Food getFood(String animalName) {
		/*
		 * we don't need a break in this switch statement as when we return we are first and foremost exiting a method.
		 * This is a factory(which is a method that produces objects), different objects will be produced and the type of 
		 * object produced is dependant on the string sent to this method at runtime
		 */
		switch(animalName) {
		case "Zebra":
			return new Hay(100);
		case "Rabbit":
			return new Vegetables(5);
		case "Goat":
			return new Hay(70);
		case "PolarBear":
			return new Fish(15);
		case "Lion":
			return new Meat(15);
			/*
			 * issue with this method is that you are using strings which are all case sensitive and not take into account any
			 * spelling mistakes and also can be any other word not in the list so we would need a default case, but it could
			 * be literally any other animal. so instead of a default we will throw the runtimeException 
			 * throw new UnsupportedOperationException("Unsupported animal: "+animalName);
			 */	
		}
		throw new UnsupportedOperationException("Unsupported animal: "+animalName);
	}
	/*
	 * this method uses the Animal type object to determine what food is produced, this is a more enclosed system as this will
	 * limit you to only the classes of Animal you have in your application (i.e if you have a Dog and Cat class created, then 
	 * the switch statement can be tailored to only have these options)
	 */
	public static Food getFood(Animal myAnimal) {
		//name will String that will be the name of whatever Animal is sent to this method 
		String name=myAnimal.getClass().getSimpleName();
		switch(name) {
		case"Zebra":
			System.out.println("zebra eating hay");
			return new Hay(100);
		case"Rabbit":
			System.out.println("Rabbit eating pellets");
			return new Vegetables(5);
		case"Goat":
			System.out.println("goat eating pellets");
			return new Hay(30);
		case"PolarBear":
			System.out.println("Polar bear eating fish");
			return new Fish(10);
		case "Lion":
			System.out.println("lion eating meat");
			return new Meat(15);
		}
		throw new UnsupportedOperationException("Unsupported animal: "+name);
		
	}
	
	/*
	 * This method uses a Enuma Animal type object to determine what food is produced. The advantage of this method is that this
	 * is a totally enclosed system and it can be nothing else bar these five Animal types
	 */
	public static Food getFood(AnimalType type) {
		
		switch(type) {
		case ZEBRA:
			System.out.println("enum Zebra");
			return new Hay(100);
		case RABBIT:
			System.out.println("enum Rabbit");
			return new Vegetables(5);
		case GOAT:
			System.out.println("enum Goat");
			return new Hay(30);
		case POLARBEAR:
			System.out.println("enum PolarBear");
			return new Fish(10);
		case LION:
			System.out.println("enum Lion");
			return new Meat(30);
		}
		return null;
		
	}

}
