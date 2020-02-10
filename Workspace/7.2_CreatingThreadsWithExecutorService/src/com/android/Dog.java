package com.android;

public class Dog implements Runnable{

	@Override
	public void run() {
		System.out.println("Dog run thread");
	}

}
