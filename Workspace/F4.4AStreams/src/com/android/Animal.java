package com.android;

public class Animal {
	
	int age;
	String name;
	
	Animal(){
		
	}
	
	Animal(int age,String name){
		this.age=age;
		this.name=name;
		System.out.println("Constructor called");
	}

	@Override
	public String toString() {
		return "Animal [age=" + age + ", name=" + name + "]";
	}
	

}
//Rat implements the Rat compareTo(Rat r1) method
class Rat implements Comparable<Rat>{
	Double weight;
	int age;
	String name;
	
	Rat(){
		
	}
	
	//constructor
	public Rat(int age,String name,double weight) {
		super();
		this.age=age;
		this.name=name;
		this.weight=weight;
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
	public String toString() {
		return "Rat name is "+name+" age is "+age+" weight is "+weight;
	}

	@Override
	public int compareTo(Rat r1) {
		//if they are the same rat or both rats have same age, weight and name
		//then return 0
		if(this.equals(r1))
			return 0;
		/*
		 * compare by names first
		 * if not the same name, use the compareTo method of the String class to 
		 * find out which string comes first
		 * the String class does implement Comparable, so you can use the 
		 * compareTo() method to sort rats
		 */
		if(!(name.equals(r1.name)))
			return name.compareTo(r1.name);
		/*
		 * if same name, sort by age
		 */
		if(age!=r1.age)
			/*
			 * can't use compareTo with age because age is an int, and int is not
			 * a class, so it can't implement Comparable
			 */
			return age-r1.age;
		/*
		 * if both rats are not the same, which we know they are not if we get to this
		 * line of code as 
		 * this.equals(r1) has already returned false if we get to this stage of the code
		 *weight is a Double wrapper object and this class implements comparabled
			so we can use compareTo with this variable
		 */
		return weight.compareTo(r1.weight);
	}
	
	
}

class Badger extends Animal implements Comparable<Badger>{

	@Override
	public int compareTo(Badger arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
