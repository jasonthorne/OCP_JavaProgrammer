package com.android;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

enum Colour{
	BLUE,BLACK,BROWN,WHITE,RED,GREEN;
}


public class Human {
	
	String name;
	int age;
	int shoeAmount;
	
	Set<Shoes>shoeSet;
	
	Stream<Shoes>myShoes;
	
	{
		myShoes = Stream.generate(()-> new Shoes((int)(Math.random()*10+1), Colour.BLACK))
				.filter((s) -> s.size>7);
				
	}
	
	Human(int age, String name, int shoeAmount){
		this.age = age;
		this.name = name;
		this.shoeAmount = shoeAmount;
	}
	
	//our shoes are not created until we call the terminal operation in this method:
	void makeShoes() {
		
		myShoes.limit(shoeAmount).forEach((s) -> System.out.println(s));
		
		/*
		 * We have a set to hold all of the shoes created by the stream. 
		 * If the set is empty that means the stream has not yet hasd a terminal opperation called on it.
		 * if it has been run on it, we recreate the stream.
		 */
		/*
		if(shoeSet.isEmpty()) {
			shoeSet = myShoes.limit(shoeAmount).collect(Collectors.toSet());
		}
		
		shoeSet.stream();
		*/
	}

}

class Shoes{
	
	int size;
	
	Colour shoeColour;
	
	Shoes(int size,Colour shoeColour){
		this.size = size;
		this.shoeColour = shoeColour;
	}

	@Override
	public String toString() {
		return "Shoes [size=" + size + ", shoeColour=" + shoeColour + "]";
	}
	
	
}