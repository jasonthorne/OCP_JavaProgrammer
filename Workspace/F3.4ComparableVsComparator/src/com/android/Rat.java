package com.android;

public class Rat implements Comparable<Rat>{
	/*
	 * if you are going to implement the Comparable interface and have a compareTo method, you should
	 * also always overriden the equals() and the hashCode() method.
	 */
/*
 * if we wanted to have all rats to be unique, i would put in some unique idenifier such as a Id, which
 * would be different for every Rat
 */
	String name;
	/*
	 * we are using wrappers, instead of primitives, so we can use the compareTo() methods of the 
	 * Integer and Double class. You could also use primitives here, but when using compareTo we woudl
	 * have to use them in conjuction with wrappers.
	 */
	Integer age;
	Double weight;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Rat))
			return false;
		Rat other = (Rat) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}
	/*
	 * arrange Rats by name, then age, then weight
	 */
	@Override
	public int compareTo(Rat r) {
		/*
		 * if we use ints instead of Integer we have to do somethign like the following, where we 
		 * assign the int to a Integer, so we can then call the compareTo() method of the 
		 * Integer class
		 */
		int num=5;
		Integer number=num;
		//if same Rat or have same name,age and weight, will return 0
		//clones, which are different rat but all same values, will not be inserted
		/*
		 * this is calling the equals() method of the Rat class. returns true if same Rat or if 
		 * two Rats have the same name,age and weight
		 */
		if(this.equals(r))
			return 0;
		/*
		 * if two rats have different names then we can use compareTo of the String class to see
		 * the order of strings and use this to order by the name of the Rat
		 */
		if(!(name.equals(r.name)))//if different names
			return name.compareTo(r.name);//order by names
		/*
		 * if two rats have a different age, then we can use the compareTo of the Integer class to see
		 * the order of Integers and use this to order by the age of the Rat
		 */
		if(!(age.equals(r.age)))
			return age.compareTo(r.age);
		/*
		 * if both Rats are different (which we know as this.equals(r) has returned false if we get to
		 * this point) and if the names and ages are different (which again we know if we have got to this
		 * point) then we do not need to check if weight is different, as if it gets to this point 
		 * WEIGHT CAN ONLY BE THE ONLY POINT OF DIFFERENCE BETWEEN THE TWO RATS
		 */
		return weight.compareTo(r.weight);
		
	//	return 0;
	}
	
	@Override
	public String toString() {
		return "name is "+name+" age is "+age+" weight is "+weight;
	}
	
	public Rat(String name,Integer age,Double weight) {
		super();
		this.name=name;
		this.age=age;
		this.weight=weight;
	}

	
	
}
