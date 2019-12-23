package com.android.animals;

import com.android.interfaces.Life;
import com.android.interfaces.Manners;
/*
 * here we give the Manners interface a specific type of Elephant and Life
 * that means type T in Manners will become a Elephant
 * and type V will be any object that implements the Life interface (which can be
 * a Flower, a Rose,a anonymous class implementation of Life interface or a lambda because
 * Life is a functional interface
 */
public class Ape implements Manners<Elephant,Life>{

	@Override
	public void thankYou(Elephant t) {
		System.out.println("Ape thankYOu method");
		t.sleep();//call sleep method of elephant class
		t.eat();//eat method of Elephant class
		System.out.println(t);
		
	}

	@Override
	public void sorry(Elephant t, Life v) {
		System.out.println("Ape sorry method");
		v.grow();//the grow method of whatever object that implements the Life interface
		
		
	}

}
/*
 * here our generic types can be 
 * Any Animal or sub class of Animal which are Elephant, Zebra, Cow
 * and any object that implemetns the functional interface life, which will be 
 * Elephant, Zebra Cow
 */
class Chimp implements Manners<Animal,Life>{

	@Override
	public void thankYou(Animal t) {
		System.out.println("chimp thankyou method");
		t.eat();
		t.sleep();
		
	}

	@Override
	public void sorry(Animal t, Life v) {
		System.out.println("chimp sorry method");
		v.grow();
		
	}
	
}
