package com.android.animals;

import java.util.List;

import com.android.interfaces.Life;
import com.android.interfaces.Manners;
import com.android.plants.Flower;
import com.android.animals.*;

public class Monkey<T extends Animal, V extends Life>implements Manners<T,V> {

	@Override
	public void thankYou(T t) {
		System.out.println("Monkey thankYou method");
		//these are all methods of the Animal class
		t.eat();
		t.sleep();	
	}

	@Override
	public void sorry(T t, V v) {
		System.out.println("monkey sorry method");
		v.grow();
		
	}
}

class SpiderMonkey<Animal,Life> implements Manners{

	@Override
	public void thankYou(com.android.animals.Animal t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sorry(com.android.animals.Animal t, com.android.interfaces.Life v) {
		// TODO Auto-generated method stub
		
	}	
}
/*
 * all this does if force the methods to be only able to take Elephants and Flowers,
 * however it does not affect the output in any, you still are only able to access
 * methods first created in teh Manners interface
 * ALL THIS DOES IS RESTRICTS
 */
class Cappuchin implements Manners<Elephant,Flower>{

	@Override
	public void thankYou(Elephant t) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void sorry(Elephant t, Flower v) {
		// TODO Auto-generated method stub
		
	}
	
}

