package com.android;

public class Animal {
	
	int age;
	String name;
	
	//blank constructor:
	Animal(){
		
	}
	
	//consructor that takes an int & string:
	Animal(int age, String name){
		this.age = age;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "age is: " + age + ". name is: " + name;
	}

}

class Dog extends Animal{

	Dog(){
		
	}
	
	Dog(int age, String name){
		super(age, name);
	}
	
	@Override //no errors when using the notation, means that its correctly overridden
	public boolean equals(Object obj) { //overriding the equals method.
		
		if(!(obj instanceof Dog)) //if not a dog 
			return false; //return false
		//if the method has not exited at this point, then you can say that obj IS A DOG OBJECT
		//However, at this point we have an object reference to a Dof object, and we cant access the vars of the Dog class unless it is a Dog reference. 
		//So we cast this object to be a Dog, so we can access the age & name of the Dog. 
		
		Dog otherDog = (Dog)obj; //cast obj to be a Dog obj (so we can access age & name)
		
		/*
		if(!(otherDog == this)) //if the passed dog is not thesame as this dog, return false.
			return false;
		*/
		
		return otherDog.age==age&&otherDog.name.equals(name); 
		
		//return true;
	}
	
}
