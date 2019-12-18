package com.android;

public class Duck {
	String name;
	int weight;
	int height;
	static int counter=0;
	int id;
	
	public Duck(String name, int weight, int height) {
		super();
		this.name = name;
		this.weight = weight;
		this.height = height;
		id=++counter;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + height;
		result = prime * result + id;
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
		if (!(obj instanceof Duck))
			return false;
		Duck other = (Duck) obj;
		if (height != other.height)
			return false;
		if (id != other.id)
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
