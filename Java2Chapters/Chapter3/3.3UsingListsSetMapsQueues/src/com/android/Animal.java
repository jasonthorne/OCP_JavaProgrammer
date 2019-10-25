package com.android;

public class Animal {
	static int count=0;
	int age;
	String name;
	Animal(int age,String name){
		this.age=age;
		this.name=name;
		count++;
	}
	
	Animal(){
		count++;
	}
	
	@Override
	public String toString() {
		return "name is "+name+" age is "+age;
	}

}

class Hamster extends Animal{
	
	Hamster(int age,String name){
		super(age,name);
	}
	@Override
	public int hashCode() {
		int number=41;
		return age*number;
	}
	
	@Override
	public boolean equals(Object obj) {
		Hamster other=(Hamster)obj;
		return age==other.age;
		
		
	}
}

class Rat extends Animal{
	
	Rat(int age,String name){
		super(age,name);
	}
	
	@Override
	public boolean equals(Object obj) {
		Rat other=(Rat)obj;
		return age==other.age;
		
		
	}
}

class Dog extends Animal{
	String name;
	int age;
	Dog(String  name, int age){
		this.name=name;
		this.age=age;
	}
	
	Dog(){
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dog other = (Dog) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	

	@Override
	public String toString() {
		return "Dog age is " + age + ", name is" + name + "]";
	}

	
}

class Collie extends Dog{
	
}

class Mouse extends Animal implements Comparable{

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

class FieldMouse extends Mouse{
	
}
