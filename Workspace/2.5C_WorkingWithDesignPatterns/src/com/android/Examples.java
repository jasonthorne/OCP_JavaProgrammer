package com.android;

import com.android.Flower.FlowerBuilder;

public class Examples {
	
	static void ex1() {
		Flower myFlower = new FlowerBuilder().setAge(12).build();
		System.out.println(myFlower);
		
		Flower myFlower2 = new FlowerBuilder().setAge(30).setHeight(33).build();
		System.out.println(myFlower2);
		
		//------------
		
		System.out.println("Flower with just an age:");
		Flower myFlower3 = new FlowerBuilder().setAge(12).build();
		System.out.println(myFlower3);
	}
	
	
	static void ex2() {
		//this creates an animal with an age of 12 and name of cow.
		Animal myAnimal=new AnimalBuilder().setAge(12).setName("Cow").build();
		System.out.println("\n" + myAnimal);
		
		Animal myAnimal2 = new AnimalBuilder().build(); //in AnimalBuilder the values are given a default value
	}

}
