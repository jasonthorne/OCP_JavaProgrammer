package com.android;

public class Rocket {
	
	static<T>void rise(T t){
		
	}
	
	static<T> T myType(T t) {
		System.out.println("t is "+t.getClass().getSimpleName());
	//	t=(t.getClass().getSimpleName())t;
	//	System.out.println(t.getClass().getSimpleName());
		return t;
	}

}
