package com.android;

public class Monkey<T extends Glider> {
	
	T myT;
	
	public Monkey(T myT){
		this.myT = myT;
		myT.fly();
		myT.glide();
	}
	
}
