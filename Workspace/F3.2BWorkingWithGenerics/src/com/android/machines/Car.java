package com.android.machines;

import com.android.interfaces.Move;
/*
 * if no type information is supplied both T and V are going to be Objects
 */
public class Car implements Move{

	@Override
	public void fly(Object t) {
		System.out.println("car flying");
		System.out.println(t.getClass().getSimpleName()+" is flying");
		
	}

	@Override
	public void walk(Object t, Object v) {
		System.out.println("car walking");
		System.out.println(t.getClass().getSimpleName()+" is walking");
		System.out.println(v.getClass().getSimpleName()+" is walking");
		
	}

}
