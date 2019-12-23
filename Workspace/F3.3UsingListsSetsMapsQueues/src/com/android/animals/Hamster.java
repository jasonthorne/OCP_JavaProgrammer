package com.android.animals;

public class Hamster extends Animal{
	private int age;
	private String name;
	private double weight;
	private int id;
	private static int counter=0;
	//constructor
	public Hamster(int age,String name,double weight){
		this.age=age;
		this.name=name;
		this.weight=weight;
		counter++;
		id=counter;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Hamster))
			return false;
		Hamster other = (Hamster) obj;
		/*
		 * as the hashCode is produced from ALL the variables of the Hamster, we can use this syntax to
		 * check if the two hamsters have the same age,id,name and weight.
		 */
		if(hashCode()!=other.hashCode())
			return false;
		return true;
		/*
		if (age != other.age)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;*/
	}
	

}
