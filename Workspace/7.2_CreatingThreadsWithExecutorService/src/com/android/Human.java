package com.android;

import java.util.concurrent.Callable;

public class Human implements Callable<Human>{

	@Override
	public Human call() throws Exception {
		System.out.println("Human call method");
		return new Human();
	}

}
