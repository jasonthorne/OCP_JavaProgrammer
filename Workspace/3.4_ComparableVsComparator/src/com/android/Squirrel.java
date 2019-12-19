package com.android;

public class Squirrel implements Comparable<Squirrel>{
	
	private String name;
	private int weight;
	private int height;
	
	public Squirrel(String name, int weight, int height) {
		this.name=name;
		this.weight=weight;
		this.height=height;
	}

	@Override
	public int compareTo(Squirrel s) {
		
		/*
		 * We are only organising lists of squirrels by their name. 
		 * So name is a string, so we are using the compareTo() method of the String class. 
		 * We could if we wanted also the 2  variables of weight and height. 
		 */
		return name.compareTo(s.name);
	}

	public String getName() {
		return name;
	}

	public int getWeight() {
		return weight;
	}

	public int getHeight() {
		return height;
	}

	@Override
	public String toString() {
		return "Squirrel name is: " + name+ " Squirrel weight is: " + weight + "Squirrel height is: " + height;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + height;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + weight;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Squirrel))
			return false;
		Squirrel other = (Squirrel) obj;
		if (height != other.height)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}
	
	
	

}
