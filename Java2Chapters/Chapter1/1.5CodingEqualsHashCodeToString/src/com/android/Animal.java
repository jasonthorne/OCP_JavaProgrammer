package com.android;

public class Animal {
	int age;
	String name;
	//constructor that takes an int and a string
	Animal(int age,String name){
		this.age=age;
		this.name=name;
	}
	//blank constructor that takes no arguments
	Animal(){
		
	}
	/*
	 * you can automatically override these methods in eclipse by going to source and click on 
	 * generate hashcode() and equals()
	 * this is what was done to produce this code
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	//this object calls the equals method to see if it the same as object sent to this method
	public boolean equals(Object obj) {
		//if both same object return true
		if (this == obj)
			return true;
		//if object being compared to this object is null return false
		if (obj == null)
			return false;
		//if not same classes of object return false
		if (getClass() != obj.getClass())
			return false;
		/*
		 * if both objects are the same object then we know that the object sent to this method is also a 
		 * Animal. However the object obj is a object reference to a Animal object. so in it's current state we
		 * do not have access to either the age or name of obj (as obj is a Object reference so we only have 
		 * access to variables and methods of the Object class, and not the Animal class).
		 * so we cast this object to be a Animal reference, and assign it to a new Animal variable (Animal other)
		 *  and we then can access that age and name of the Animal sent to this method

		 */
		Animal other = (Animal) obj;
		/*
		 * if the ages of both animal are not the same, return false
		 */
		if (age != other.age)
			return false;
		/*
		 * if name of this Animal is null, return false
		 */
		if (name == null) {
			if (other.name != null)
				return false;
		/*
		 * if they both have valid names and are NOT the same, return false
		 */
		} else if (!name.equals(other.name))
			return false;
		/*
		 * if we get through all the checks without any of them triggering then the two objects will determine
		 * to be the same 
		 */
		return true;
	}
	
	@Override
	public String toString() {
		return "age is "+age+" name is "+name;
	}
	
}

class Dog extends Animal{
	//constructor for Dog
	Dog(int age,String name){
		super(age,name);
	}
	//consturctor for Dog
	Dog(){
		
	}
	@Override
	
	public boolean equals(Object obj) {
		/*
		 * if the object we are comparing with is NOT a dog then return false
		 * obj is a object reference which means it COULD be any object, which is why insanceof here WILL compile
		 * as it COULD be a Dog
		 */
		if(!(obj instanceof Dog))
			return false;
		/*
		 * if it is an instance of Dog we can cast the object to be of type Dog and assign it to a dog variable spot
		 * (obj is a Object reference to a Dog object)
		 */
		Dog spot=(Dog)obj;
		//will return true if they have the same age and name
		/*
		 * however this has an issue, as if we create a dog using the no arguments constructor then
		 * that means we have a dog that looks like this
		 * age=0
		 * name=null
		 * so if we create many dogs using the default no arguement constructor, using this equals method
		 * they will always be equals
		 */
		return spot.age==age&&spot.name==name;
		/*
		 * if we use this and we have created dogs using the no arugment constuctor this will cause a 
		 * nullPointerException as again we have all dogs with the following:
		 * age=0
		 * name=null
		 * this issue then is with the code
		 * spot.name.equals(name);
		 * as name is NULL for both Dog and if we call the equals() method on a null object we will get 
		 * a NullPointerException
		 * so it is important to have a check for null values in equals method
		 */
	//	return spot.age==age&&spot.name.equals(name);
		
	}
}
/*
 * takes it's equals method from the Animal class, and it is comprehensive
 */
class Cat extends Animal{
	Cat(int age,String name){
		super(age,name);
	}
}

class Cow extends Animal{
	
	Cow(int age,String name){
		super(age,name);
	}
	/*
	 two cows will be said to be equal if they have the same age, so here we can see how the programmer can
	 take any meaning of equals 
	 */
	@Override
	public boolean equals(Object obj) {
		//if both object are NOT a cow return false
		if(!(obj instanceof Cow))
			return false;
		Cow bessie=(Cow)obj;
		/*
		 * here we will return true if they are the same age, s
		 */
		return bessie.age==age;

	}
}
/*
 * this class will takes it's equals method from the Object class, will return true if same object, false if not
 */
class Butterfly{
	String name;
	Butterfly(String name){
		this.name=name;
	}
}


