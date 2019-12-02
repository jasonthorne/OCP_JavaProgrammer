package com.android.machines;

import com.android.animals.Animal;
import com.android.interfaces.Behaviour;
import com.android.interfaces.Move;


/*
 * This is implementing the move interface and supplying a generic type from the generic tpyes in the class that is impolementing the Move interface. 
 * In this case we havea generic class Vehicle & when creating a vehicle and syupply 2 tpyes for U & X generics in the vehicle class,
 * this is the type that will be supplied to the Move interface. 
 * i.e I create a vehicle by going:
 * Vehicle< String, Elephant>myVehicle;
 * This means U & X are type String & Elephant which are the data types which will be used in the fly & walk methods of the move interface. 
 */

public class Vehicle<U,X> implements Move<U,X>{

	@Override
	public void fly(U myFlyType) {
		System.out.println("vehicle fyling method");
		System.out.println(myFlyType.getClass().getSimpleName() + " is flying");
		
	}

	@Override
	public void walk(U walk1, X walk2) {
		System.out.println("vehicle walking method");
		System.out.println(walk1.getClass().getSimpleName() + " is walking");
		System.out.println(walk2.getClass().getSimpleName() + " is walking");
	}
	
	

}
