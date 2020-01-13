package com.android;

public class Animal {
	
	int age;
	String name;
	public Animal(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Animal [age=" + age + ", name=" + name + "]";
	}
	
	public Animal(){
		
	}

}



class Rat implements Comparable<Rat>{
	Double weight;
	int age;
	String name;
	
	//constructor
	public Rat(int age,  String name, double weight) {
		super();
		this.age = age;
		this.name = name;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Rat [weight=" + weight + ", age=" + age + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
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
		if (!(obj instanceof Rat))
			return false;
		Rat other = (Rat) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}

	@Override
	public int compareTo(Rat r1) {
		
		//if they're the same rats or have the same age, weight and name, return 0.
		if(this.equals(r1))
			return 0;
		
		//compare by names first:
		//if they're not the same name, use the compareTo method of the string class to find out which string comes first. 
		if(!(name.equals(r1.name)))
				return name.compareTo(r1.name);
		
		//If same name, sort by age: //+++++++++++++++CANT use compareTo with age because age is an int not an INTEGER so it cant implement comparable
		if(age!=r1.age)
			return age-r1.age;
		
		/*if both rats are not the same 
		(which we know they are not if we get to this line of code as this.equals(r1) has already returned false if we get to this stage of the code)
		*/
		return weight.compareTo(r1.weight); //Weight is a Double wrapper obj so you CAN use the compareTo method on it.
	}
	

	
}
