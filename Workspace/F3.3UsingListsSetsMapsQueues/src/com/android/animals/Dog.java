package com.android.animals;

public class Dog extends Animal implements Behaviour{
	public int age;
	public String name;
	//static int count=0;
	//int id;
	public Dog(String name,int age){
		this.name=name;
		this.age=age;
	//	count++;
	//	id=count;
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
		if (!(obj instanceof Dog))
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

	public Dog() {
		
	}
	
	public String toString() {
		return "name is "+name+" age is "+age;
	}

	@Override
	public void sad() {
		System.out.println("dog sad");
		
	}
	

}
