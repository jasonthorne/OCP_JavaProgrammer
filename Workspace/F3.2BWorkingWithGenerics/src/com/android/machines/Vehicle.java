package com.android.machines;

import com.android.animals.Animal;
import com.android.interfaces.Behaviour;
import com.android.interfaces.Move;
/*
 * this is implementing the Move interface and supplying a generic type from the generic types
 * in the class that is implmenting the Move interface
 * in this case we have a generic class Vehicle, and when creating a Vehicle and supply 
 * two types for U and X generics in the Vehicle, this is the type that will be supplied
 * to the Move Interface
 * i.e
 * I create a Vehicle by going
 * Vehicle<String,Elephant>myVehicle;
 * this meant that U and X are of type String and Elephant which is the data types that will be
 * used in the Fly() and walk() methods of the Move interface
 */
public class Vehicle<U,X> implements Move<U,X> {

	U myU;
	X myX;
	@Override
	public void fly(U flyId) {
		System.out.println(flyId.getClass().getCanonicalName()+" is flying");

		
	}
	@Override
	public void walk(U walk1, X walk2) {
		System.out.println(walk1.getClass().getCanonicalName()+" is walking");
		System.out.println(walk2.getClass().getCanonicalName()+" is walking");
		
	}
	

}
