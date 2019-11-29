package com.android.generics;

import com.android.interfaces.Life;

public class Pan <T extends Life>{
	
	/*
	 * this can be a class that implements the Life interface
	 * This can be an anonymous class that implements the Life interface
	 * or as Life is a functional interface, this can be a lambda.
	 */
	
	private T myLife;
	
	//constructor
	public Pan(T myLife){
		this.myLife = myLife;
		myLife.grow();
	}

}
