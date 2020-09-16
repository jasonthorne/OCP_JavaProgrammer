package com.android;

public class Dog implements Comparable<Dog>{
	int age;
	String name;
	Dog(String name,int age){
		this.name=name;
		this.age=age;
	}
	@Override
	public int compareTo(Dog d) {
		int result=name.compareTo(d.name);
		if(result!=0)
			return result;
		result=age-d.age;
		return result;
	}
	@Override
	public String toString() {
		return "Dog [age=" + age + ", name=" + name + "]";
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
	
	

}
