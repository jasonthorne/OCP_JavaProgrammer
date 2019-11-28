package com.android.generics;

import com.android.animals.Animal;

/*
 * A generic can be defined as a subclass of another class.
 * Here the generic can be an Animal or a subclasss of Animal. 
 * So methods first defined in the Animal class can be used by this object.
 * As well as those first defined in the object class.
 */
public class Box <T extends Animal>{
	
	private T myAnimal;

	//constructor:
	public Box(T myAnimal) {
		this.myAnimal = myAnimal; //assigning whatever animal we passed into the constructor to create the Box object.
		
		/*
		 * This generic data type can only be an animal, 
		 * so that means we do have access to methods first defined in the animal class.
		 * So we can all the eat, sleep and stampede methods. 
		 */
		
		/*
		 * The animal class and all of the subclasses of Elephant, Cow & Zebra all override the eat and sleep method. 
		 * so depending on what Animal we create our box with, these will call that method for that particular animal: 
		 */
		myAnimal.eat();
		myAnimal.sleep();
		myAnimal.stampede();
		
		/*
		 * We can also access the variables of the Animal of wreight and height directly here:
		 */
		
		System.out.println("Height of Animal is: " + myAnimal.height + "weight of Animal is: " + myAnimal.weight);
	}
	
}
