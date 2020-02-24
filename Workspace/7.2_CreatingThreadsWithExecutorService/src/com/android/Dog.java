package com.android;

import java.time.LocalTime;

public class Dog implements Runnable{

	@Override
	public void run() {
		System.out.println("time of Dog runnable is: " + LocalTime.now());
		System.out.println("Dog run thread");
	}

}
