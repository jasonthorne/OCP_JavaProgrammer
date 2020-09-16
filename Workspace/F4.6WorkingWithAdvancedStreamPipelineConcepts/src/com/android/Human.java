package com.android;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

enum Colour{
		BLUE,BLACK,BROWN,WHITE,RED,GREEN
	}



public class Human {
	
	String name;
	int age;
	int shoeAmt;
	Stream<Shoes>myShoes;
	Set<Shoes>shoeSet;
	{
		myShoes=Stream.generate(()->new Shoes((int)(Math.random()*10+1),Colour.BLACK)).
				filter((s)->s.size>7).filter(s->s.size<9);
				
	}
	
	Human(int age,String name,int shoeAmt){
		this.age=age;
		this.name=name;
		this.shoeAmt=shoeAmt;
	}
	/*
	 * this is lazy instantiation, our shoes are NOT created until we call the terminal operation in 
	 * this method.
	 */
	void makeShoes() {
		/*
		 * we have a set to hold all of the shoes created by the stream, if the set is empty that means
		 * the stream has not yet had a terminal operation on it
		 */
	//	if(shoeSet.isEmpty())
			shoeSet=myShoes.limit(shoeAmt).collect(Collectors.toSet());
			System.out.println(shoeSet);
		/*
		 * if a terminal opeation has been run on the stream, we recreated the stream
		 */
	/*	shoeSet=Stream.generate(()->new Shoes((int)(Math.random()*10+1),Colour.BLACK)).
				filter((s)->s.size>7).filter(s->s.size<9).
				limit(shoeAmt)
				.collect(Collectors.toSet());*/
		
		
	}

}

class Shoes{
	int size;
	
	
	Colour shoeColour;
	
	Shoes(int size,Colour shoeColour ){
		this.size=size;
		this.shoeColour=shoeColour;
	}

	@Override
	public String toString() {
		return "Shoes [size=" + size + ", shoeColour=" + shoeColour + "]";
	}
	
	
}
