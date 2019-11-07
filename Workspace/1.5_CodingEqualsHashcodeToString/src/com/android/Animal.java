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
		
		
		/*
		 * Below will return true if they have the same name & age, however this has an issue, as if we create 2 Dogs using the no arguement constructor,
		 * then that means we have 2 dogs that look like this: 
		 * age = 0
		 * name = null
		 * so according to this code below, these two dogs will be equal. 
		 * So if you create many dogs with the no argument constructor, this equals method will always return true. 
		 */
		//return otherDog.age==age&&otherDog.name.equals(name); //return true if both dogs have the same name and age, OR if both are references to the same Dog object. 
		
		
		/*
		 * Below will cause a NullPointerException if you compare 2 dogs and either one of them was created using the no args constructor.
		 * Because name for one of the Dogs would be null, and a null object cannot call a method.
		 * If name is null then name.equals causes a nullpointerException.
		 * It is VERY IMPORTANT to always check for null values in the equals method.
		 * Need to check that the object you are comparing with is not null.
		 * i.e the dog, or if the variable thats an object is not null.
		 * i.e name of a dog is a string. 
		 */
	
		return otherDog.age==age&&otherDog.name==name;
		//return true;
	}
	
}
