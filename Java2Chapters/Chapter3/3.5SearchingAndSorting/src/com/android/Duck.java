package com.android;

public class Duck implements Comparable<Duck>{
	private String name;
	private int age;
	public Duck(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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
		Duck other = (Duck) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	@Override
	public String toString() {
		return "Duck [name=" + name + ", age=" + age + "]";
	}
	//compare by int (age) then by String (name)
	@Override
	//1 put at end, -1 put at beginning, 0 same
	public int compareTo(Duck d1) {
		Integer age1=age;
		Integer age2;
		
		if(d1==null)
			throw new  IllegalArgumentException();
		//if same return 0
		if(this==d1)
			return 0;
		age2=d1.age;
		//if not same class will be put in at the top of the list
		/*
		 * try if(getClass().equals(d1.getClass())
		 */
	//	if(getClass().equals(d1.getClass()))
		//if(getClass()!=d1.getClass())
		//	return -999999;
		//if(d1.getClass().getSimpleName().equals("Duck"))
		//	age2=d1.age;
		//if notr same age, compare ages
		if(!(age1.equals(age2)))
			return age1.compareTo(age2);
		//if none of the above is true then names have to be different
		return name.compareTo(d1.name);
	}
}

class Eider extends Duck{

	public Eider(String name, int age) {
		super(name, age);
		
	}
	
}
