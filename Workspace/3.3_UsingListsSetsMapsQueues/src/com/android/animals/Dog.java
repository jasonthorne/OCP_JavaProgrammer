package com.android.animals;

public class Dog extends Animal{
	
	int age;
	String name;
	static int dogCount=0;
	int id;
	
	public Dog(String name, int age){
		//super(age, name);
		this.name=name;
		this.age=age;
		dogCount++;
		id=dogCount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Dog))
			return false;
		Dog other = (Dog) obj;
		if (age != other.age)
			return false;
		if (id != other.id)
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
		return "name is: " + name + ". age is: " + age;
	}
	
	

}
