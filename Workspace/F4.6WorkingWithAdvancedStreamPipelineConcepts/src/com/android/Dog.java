package com.android;

import java.util.stream.Stream;

public class Dog {
	int age;
	String name;
	Double weight;
	/*
	 * Streams are just another data type, so a class can have as one of it's atributes a Stream
	 * which can be private, public, protected, final or static
	 * 
	 */
	private Stream<Integer>myStream;
	{
		/*
		 * this code DOES NOT run, until a terminal operation is called on the stream
		 * this is called lazy instantiation. so the stream of 10 numbers, will not be created
		 * until a terminal operation is called on this stream
		 */
		myStream=Stream.iterate(1, i->i*2).limit(10).peek(System.out::println);
	}
	
	Dog(int age,String name){
		this.age=age;
		this.name=name;
	//	System.out.println("Dog created");
//		myStream.forEach((i)->System.out.println("number is "+i));
	}
	static int dogCounter=0;
	Dog(int age,String name,double weight){
		this.age=age;
		this.name=name;
		this.weight=weight;
		dogCounter++;
	}
	
	void bark() {
		System.out.println("the bark methods calls a terminal operation on the Dog Stream");
		myStream.filter(x->x%2==0).forEach((n)->System.out.println("number is "+n));
	}

	@Override
	public String toString() {
		return "Dog [age=" + age + ", name=" + name + "]"+"weight is "+weight;
	}
	
	

}
