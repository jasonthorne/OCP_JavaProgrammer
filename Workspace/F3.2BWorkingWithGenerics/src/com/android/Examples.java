package com.android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.android.animals.Animal;
import com.android.animals.Ape;
import com.android.animals.Cow;
//import com.android.animals.Cow;
/*
 * this will import everything including the nested static classes, which is the 
 * CowBuilder class
 */
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
import com.android.machines.Android;
import com.android.machines.Car;
import com.android.machines.Robot;
import com.android.machines.Vehicle;
import com.android.plants.Flower;

public class Examples {
	
	static void ex1() {
		Pot<Zebra>potZebra=new Pot<>(new Zebra());
	}
	
	static void ex2() {
		Robot robbie=new Robot();
		Cow myCow=new CowBuilder().build();
		/*
		 * this method can only take a Cow or a subclass  and a Zebra or a sub class of Zebra, 
		 * cannot take anything else
		 */
		robbie.walk(new CowBuilder().build(), new Zebra());
		robbie.fly(new CowBuilder().build());
		/*
		 * this uses the generic class 
		 * class Vehicle<U,X> impments Move<U,X>{
		 * to give the variable T and V in the Move interface values of String and 
		 * Elephant
		 */
		Vehicle<String,Elephant>myVehicle=new Vehicle<>();
		myVehicle.fly("hello");
		myVehicle.walk("hello",new Elephant());
		
		new Vehicle<String,Elephant>().fly("hello");
		/*
		 * the car class neither explicitly specifies the types to be used or uses a 
		 * generic class type
		 * supplied by the car. no where is a type specified so that means that types T 
		 * and V in the interface
		 * become object references when the fly() and walk() method are implemented in 
		 * the Car class
		 */
		Car myCar=new Car();
		myCar.fly("hello");//this will be an object reference to a String object
		/*
		 * here we have a object reference to a String object and a Object reference to a 
		 * Animal object
		 */
		myCar.walk("hello", new Animal());
	}
	
	static void ex3() {
		Ape myApe=new Ape();
		myApe.sorry(new Elephant(), new Flower());
		Flower myFlower=new Flower() 
		{
			@Override
			public void grow() {
				System.out.println("anonymous class grow method");
			}
		};
		//taking a elephant and a anonymous class implementation of the Life interface
		myApe.sorry(new Elephant(),myFlower );
		//taking a Elephant and a lambda 
		myApe.sorry(new Elephant(), ()->System.out.println("lambda grow method"));
		//this implementation can only take an Elephant
	//	myApe.sorry(new Animal(), myFlower);
	}
	
	static void ex4() {
		Android myAndroid=new Android();
		myAndroid.walk(new Whale());
		/*
		 * method signature for this method is 
		 * <S> void talk(S myS){}
		 * so here we have a Object reference to a Zebra object
		 * if you dont' supply a type, you can pass in ANY object
		 */
		myAndroid.talk(new Zebra());
		//here we are saying the generic type is going to be Animal
		myAndroid.<Animal>talk(new Elephant());
		myAndroid.talk(new Flower());
		Android.method2(new Zebra(), new Whale(), new Ape());
		Android.<Zebra,Whale,Ape>method2(new Zebra(),new Whale(),new Ape());
	}
	

}
