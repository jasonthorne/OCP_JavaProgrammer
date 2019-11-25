package com.android;

import com.android.Flower.FlowerBuilder;
import com.android.Flower.colour;
import com.android.Human.HumanBuilder;

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
		
		Flower myFlower4 = new FlowerBuilder().setColour(colour.GREEN).build();
		System.out.println(myFlower4);
	}
	
	
	static void ex2() {
		//this creates an animal with an age of 12 and name of cow.
		Animal myAnimal=new AnimalBuilder().setAge(12).setName("Cow").build();
		System.out.println("\n" + myAnimal);
		
		Animal myAnimal2 = new AnimalBuilder().build(); //in AnimalBuilder the values are given a default value
	}
	
	static void ex3() {
		System.out.println("creating immutable class objects with a builder class");
		

		//You can create an AnimalBuilder object
		AnimalBuilder cowBuilder = new AnimalBuilder(); 
		
		/*Its common to chain methods with the builder pattern:
		NOT that we HAVE NOT yet created a Cow. 
		this is just assigning the value of 12 to the int age var inside the cow builder class,
		and string "bessie" to the name var*/
		cowBuilder.setAge(12).setName("Bessie");
		
		//creating cow object:
		//Animal test = new Animal(); //You CANT make an animal without using a builder.
		Animal cow = cowBuilder.build(); //cow1 (12, bessie)
		cow=cowBuilder.build(); //cow2 made. Changing cow reference to point to a new cow. Returned with cowbuilder
		System.out.println(cow);
		cow=cowBuilder.setAge(4).build(); //cow 3
		System.out.println(cow);
	    
		
		//-------------
		
		
		///You dont have to create an animal builder reference when creating an animal:
		Animal sheep = new AnimalBuilder().setAge(3).setName("flossie").build();
		System.out.println(sheep);
		
		//an Animal of name "goat" and age of 0:
		Animal goat = new AnimalBuilder().setName("goat").build();
		System.out.println(goat);

	}
	
	
	static void ex4() {
		
		HumanBuilder humanBuilder = new HumanBuilder();
		
		Human me = new HumanBuilder().setAge(33).setName("yo").setWeight(3.3).build();
		System.out.println(me);
		
		
	}

}
