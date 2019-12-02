package com.android.generics;

import com.android.interfaces.Life;

/*
 * 'Life' is an interface and type T has to implement the interface 'Life'
 */
public class Pan <T extends Life>{
	
	/* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++IMPORTANT! :P
	 * this can be a class that implements the Life interface
	 * This can be an anonymous class that implements the Life interface
	 * or as Life is a functional interface, this can be a lambda.
	 */
	
	private T myLife;
	
	//constructor
	public Pan(T myLife){
		this.myLife = myLife;
		myLife.grow(); //all classes that implement the Life interface have grow methods. THIS CLASS can call whichever of them this class is constructed with. 
	}

}
