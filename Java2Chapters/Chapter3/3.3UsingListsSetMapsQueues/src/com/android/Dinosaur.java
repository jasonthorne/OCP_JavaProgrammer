package com.android;

public class Dinosaur {
	int age;
	String name;
	double weight;
	double height;
	boolean carnivore;
	public Dinosaur(int age, String name, double weight, double height, boolean carnivore) {
		super();
		this.age = age;
		this.name = name;
		this.weight = weight;
		this.height = height;
		this.carnivore = carnivore;
	}
	
	Dinosaur(){
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + (carnivore ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Dinosaur other = (Dinosaur) obj;
		if(hashCode()!=other.hashCode())
			return false;
	/*	
		if (age != other.age)
			return false;
		if (carnivore != other.carnivore)
			return false;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
			*/
		return true;
	}

	@Override
	public String toString() {
		return "Name of Dinosaur is "+name+" age is "+age+"are you a carnivore"+carnivore+"\n";
	}
	

}
