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

	/*
	 * This is exactly the same code as is generated when you go: source > 'generate hashcode & equals':
	 */

	@Override
	public boolean equals(Object obj) {
		
		
		if (this == obj) 
			return true;
		
		//if both objects are not the same obj then return false.
		//This ALSO checks for null. As if obj is null, then they're not the same obj (as null wont have an equals method!!):
		if (!(this == obj))
			return false;
		
		/*
		if (obj == null)
			return false; //Not needed as above also checks for null. 
		*/
		
		/*
		 * If obj sent to method is NOT an animal, then they are not equal, and return false:
		 */
		if (!(obj instanceof Animal))
			return false;
		
		/*
		 * If they are the same objet type (animal), then cast obj to be of type Animal
		 * As obj is at this point: Object obj = new Animal();
		 * So we cannot access the age & name of this animal. 
		 * So we cast it to end up with: Animal other = Animal
		 */
		
		Animal other = (Animal) obj;
		
		/*
		 * If the age of the Animal that calls equals is not the same as the animal sent to the method than the method exits and returns false.
		 * If they are the same age, then go to next statement.
		 */
		if (age != other.age)
			return false;
		
		/*
		 * If name of either but NOT both Animals is null, this will exit and return false:
		 */
		if (name == null) {
			if (other.name != null)
				return false;
			
			
		} else if (!name.equals(other.name))
			return false;
		return true;
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



class Cat extends Animal{
	
	/*
	 * The Cat class uses the equals method from the Animal class. 
	 */
	
	Cat(int age, String name){
		super(age, name);
	}
		
}


class Cow extends Animal{
	
	Cow(int age, String name){
		super(age, name);
	}
	
	/*
	 * 2 cows can be said to be equal if they have the same age, so here we can see how the programmer can take any meaning of equals
	 */
	
	public boolean equals(Object obj) {
		
		if(!(obj instanceof Cow))
			return false;
		Cow bessie = (Cow) obj;
		return bessie.age==age;
	}
	
	
}


/*
 * Butterfly class uses the object class equals method (as it doesnt extend any of the above)
 */
class Butterfly{
	
	String name;
	Butterfly(String name){
		this.name = name;
	}
}



class Pig extends Animal{
	
	Pig(int age, String name){
		super(age, name);
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Pig)) //check if obj is also a pig
				return false; //return false if not
		return super.equals(obj);
	}
}

class Sheep extends Animal{
	double woolWeight;
	Sheep(int age, String name, double woolWeight){
		super(age, name);
		this.woolWeight = woolWeight;
	}
	
	/*
	 *  If you are using a superclass equals method and wish to use it in a subclass, 
	 *  you have to check for all of the vars of the subclass that are unique FIRST b4 you use the super class equals method. 
	 *  Here we first check if the object is  sheep thenwe check to see if the're NOT the same weight of wool, 
	 *  then name and age with the super Animal equals method.
	 */
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Sheep))
				return false;
		Sheep other = (Sheep)obj;
		if(woolWeight != other.woolWeight)
				return false;
		return super.equals(obj);
	}
	
}


