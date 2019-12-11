package com.android.animals;

public class Hamster extends Animal{

	private int age;
	private String name;
	private double weight;
	private int id;
	private static int counter=0;
	
	public Hamster(int age, String name, double weight){
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
		if (obj == null)
			return false;
		if (!(obj instanceof Hamster))
			return false;
		Hamster other = (Hamster) obj;
		
		//doing below is the same as what was commented out, as the hashcode is produced from the below vars (name, age & weight)
		
		/*
		 * Noel's comment:
		 * As the hashcode is produced from ALL of the vars of Hamster, we can use this syntax to check if the 2 hamsters have the same age, id, name and weight: 
		 */
		if(hashCode()!=other.hashCode())
			return false;
		
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
		*/
		
		return true;
		
	}
	
	
}
