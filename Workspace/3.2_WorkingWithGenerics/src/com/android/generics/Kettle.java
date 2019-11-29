package com.android.generics;

import com.android.animals.Animal;
import com.android.interfaces.Behaviour;

/*
 * We can have more than one generic type. Here we have 3 generic types:
 * T will be a type that extends the Animal class
 * V will be a type that implements thhe Behaviour interface
 * E can be any type
 */

public class Kettle <T extends Animal, V extends Behaviour, E>{
	
	T myT;
	V myV;
	E myE;
	
	public Kettle(T myT, V myV, E myE){
		this.myT = myT;
		this.myE = myE;
		this.myV = myV;
	}
}
