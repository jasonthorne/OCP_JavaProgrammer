package com.android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.android.animals.Animal;
import com.android.animals.Ape;
import com.android.animals.Cow;
import com.android.animals.Cow.*;
import com.android.animals.Elephant;
import com.android.animals.Lemur;
import com.android.animals.Whale;
import com.android.animals.Zebra;
import com.android.generics.Box;
import com.android.generics.Bucket;
import com.android.generics.Container;
import com.android.generics.Crate;
import com.android.generics.Kettle;
import com.android.generics.Pan;
import com.android.generics.Pot;
import com.android.interfaces.Behaviour;
import com.android.interfaces.Life;
import com.android.machines.Car;
import com.android.machines.Robot;
import com.android.machines.Vehicle;
import com.android.plants.Flower;

public class Examples {
	
	static void ex1() {
		
		Pot<Zebra>potZebra = new Pot<>(new Zebra());
	}
	
	
	static void ex2() {
		System.out.println("ex2:");
		
		//Don't need to supply the type here, as its given in the Class type definition +++++
		Robot robbie= new Robot();
		robbie.fly(new CowBuilder().build());
		robbie.walk(new CowBuilder().build(), new Zebra()); //this method can only take a Cow or a subclass or Cow, and a Zebra or a subclass of Zebra.
		
		System.out.println();
		/*
		 * This uses the generic class:
		 * class Vehicle<U,X> implements Move(U, X>
		 * to give the variable T and V in the Move interface the values String & Elephant.
		 */
		
		Vehicle<String, Elephant>myVehicle=new Vehicle<>(); //myVehicle now becomes String and Elephant)
		
		myVehicle.fly("yo");
		myVehicle.walk("dawg", new Elephant());
		
		
		//----------------
		System.out.println();
		
		Car myCar = new Car();
		myCar.fly("yo");
		myCar.walk("hello", new Animal());
		
	}
	
	
	static void ex3() {
		
		Ape myApe = new Ape();
		
		myApe.sorry(new Elephant(), new Flower()); 
		
		Flower myFlower = new Flower() {
			
			@Override
			public void grow() {
				System.out.println("Anonymous class grow method");
			}
		};
		
		myApe.sorry(new Elephant(), myFlower); //taking an Elephant nad an anonymous class implementation of the Life interface.
		
		myApe.sorry(new Elephant(), ()->System.out.println("Lanbda grow method")); //taking an Elephant and a lambda.
		
		
		//this implementation can ONLY take an Elephant
		//myApe.sorry(new Monkey(), myFlower);
	}
}
