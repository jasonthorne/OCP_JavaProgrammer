package com.android.generics;


/*
 * You can also create a class of a defined type. 
 * In this case you can only create a Pot object with an Animal type. This can be an Animal or a subclass of Animal.
 * The onyl 1 advantage we can see is that you dont have to import the Animal class.
 */
public class Pot <Animal>{
	
	String myStr;
	Animal myAnimal;
	
	public Pot(Animal myAnimal){
		this.myAnimal=myAnimal;
	}

}
