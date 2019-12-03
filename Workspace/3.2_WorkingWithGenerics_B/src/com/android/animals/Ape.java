package com.android.animals;

import com.android.interfaces.Life;
import com.android.interfaces.Manners;


/*
 * Here we give the manners interface a specific type of Elephant and Life.
 * That means that type T in manners will become a Elephant, and type V will be any object that implements the Life interface.
 * Which can be a FLower, a Rose, an anonymous class implementation of the life interface or a lambda,
 * because Life is a functional interface.
 */
public class Ape implements Manners<Elephant, Life> {

	@Override
	public void thankYou(Elephant t) {
		System.out.println("Ape thankYou method");
		//methods from the Elephant class:
		t.sleep();
		t.eat();
	}

	@Override
	public void sorry(Elephant t, Life v) { //this takes an Elephant and ANY object that implements the Life interface.
		System.out.println("Ape sorry method");
		v.grow(); //calling the grow method of whatever object that implements the Life interface
		
	}

}

/*
 * Here our geeric types can be any Animal or subclass of Animakl which are: 
 * Elephant, Zebra, Cow and any objec that implements the functuinal interface "Life", which will be:
 * Elephant, Zebra, Cow.
 */
class Chimp implements Manners<Animal, Life>{

	@Override
	public void thankYou(Animal t) {
		System.out.println("Chimp thankYou method");
		t.eat();
		t.sleep();
	}

	@Override
	public void sorry(Animal t, Life v) {
		System.out.println("Chimp sorry method");
		v.grow();
	}
	
}