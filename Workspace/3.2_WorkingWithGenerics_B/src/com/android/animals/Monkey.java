package com.android.animals;

import com.android.interfaces.Life;
import com.android.interfaces.Manners;
import com.android.plants.Flower;
import com.android.animals.*;

public class Monkey<T extends Animal, V extends Life>implements Manners<T,V> {

	@Override
	public void thankYou(T t) {
		System.out.println("Monkey thankYou method");
		//methods of the Animal class:
		t.eat();
		t.sleep();
	}

	@Override
	public void sorry(T t, V v) {
		System.out.println("Monkey sorry method");
		v.grow(); 
	}

}


/*
All this does is to force the methods to only take Elephants & Flowers. However it doesn't effect the output in any way. 
You're still only able to access methods first created in the Manners interface. 
All this does is restricts.
*/
class Cappuchin implements Manners<Elephant, Flower>{

	@Override
	public void thankYou(Elephant t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sorry(Elephant t, Flower v) {
		// TODO Auto-generated method stub
		
	}
	
}


class SpiderMonkey implements Manners<Animal, Life>{

	@Override
	public void thankYou(Animal t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sorry(Animal t, Life v) {
		// TODO Auto-generated method stub
		
	}

	

	
}