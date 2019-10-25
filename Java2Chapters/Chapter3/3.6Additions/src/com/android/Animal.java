package com.android;

public class Animal implements Comparable<Animal>{
	protected int age;
	protected String name;
	
	Animal(int age,String name){
		this.age=age;
		this.name=name;
	}

	@Override
	public String toString() {
		return "Animal [age=" + age + ", name=" + name + "]";
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
		Animal other = (Animal) obj;
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
	public int compareTo(Animal a) {
		Integer dAge=age;
		if(this.equals(a))
			return 0;
		if(age!=a.age)
			return age-a.age;
		return name.compareTo(a.name);
	//	return 0;
	}

}

class Dog extends Animal{
	
	@Override
	public String toString() {
		return "Dog name is "+name+" age is "+age;
	}

	Dog(int age, String name) {
		super(age, name);
		// TODO Auto-generated constructor stub
	}

	void  eat(Integer num) {
		System.out.println("dog "+name+" eat method");
	}
}

class Poodle extends Dog{

	@Override
	public String toString() {
		return "Poodle []";
	}

	Poodle(int age, String name) {
		super(age, name);
		// TODO Auto-generated constructor stub
	}
	
}
