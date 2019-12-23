package com.android;

public class Duck {
	private String name;
	private int weight;
	private int height;
	static int counter=0;
	private int id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public static int getCounter() {
		return counter;
	}
	public static void setCounter(int counter) {
		Duck.counter = counter;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	@Override
	public String toString() {
		return "Duck [name=" + name + ", weight=" + weight + ", height=" + height + ", id=" + id + "]";
	}
	
	
	
	
	

}
