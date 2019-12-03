package com.android.animals;

import com.android.interfaces.Life;
import com.android.interfaces.Manners;

/*
 * Gorilla knows that type T and type V of manners interface has to be an Animal and a Life. 
 * You dont have to define the type here. Unless you want to restrict the type.
 */
public class Gorilla implements Manners {

	@Override
	public void thankYou(Animal t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sorry(Animal t, Life v) {
		// TODO Auto-generated method stub
		
	}

}
