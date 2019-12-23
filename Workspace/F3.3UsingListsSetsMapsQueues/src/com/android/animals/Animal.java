package com.android.animals;

public class Animal {
	static int animalCount=0;
	int age;
	String name;
	int id;
	public Animal(int age,String name){
		this.age=age;
		this.name=name;
		animalCount++;
		id=animalCount;
		Animal andy=new Animal();
		
	}
	public Animal(){
		animalCount++;
		id=animalCount;
	}
	
	@Override
	public String toString() {
		return "name is "+name+" age is "+age;
	}
	
	

}
