package com.android;

import java.util.stream.Stream;

public class Dog {
	
	int age;
	String name;
	
	
	private static Stream<Integer>myStream;
	
	{
		/*
		 * This code DOSNT run untill a terminal operator is called on the stream. 
		 * This is called lazy instantiation. So the stream of 10 numbers will not be created until a terminal operator is called on this stream. 
		 */
		myStream = Stream.iterate(1, i->i*2).limit(10).peek(System.out::println);
	}
	
	public Dog(int age, String name) {
		super();
		this.age = age;
		this.name = name;
		/////////System.out.println("Dog created");
		//////////////myStream.forEach((i)->System.out.println("numer is: " + i));
	}
	
	void bark() {
		System.out.println("the bark method calls a terminal operation on the Dog stream");
		myStream.filter(x->x%2 ==0).forEach((n)->System.out.println("number is: " + n));
	}

	@Override
	public String toString() {
		return "Dog [age=" + age + ", name=" + name + "]";
	}
	
	
	

}
