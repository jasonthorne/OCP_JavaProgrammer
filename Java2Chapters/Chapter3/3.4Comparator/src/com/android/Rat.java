package com.android;

public class Rat implements Comparable<Rat>{
	/*
	 * if you want all rats to have something uniquely identifying a Rat then we would give them an 
	 * ID which would be different for each Rat
	 */
	String name;
	/*
	 * here i use wrappers as each of these wrapper classes also implement comparable, you could also use primitives
	 * here and then use a wrapper created from the primitive in the compareTo() class
	 */
	Integer age;
	Double weight;
	
	//implementing compareTo() method of the Comparable interface
	/*
	 * will arrange rats by name,then age, then weight
	 */
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
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
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

	@Override
	public int compareTo(Rat r) {
		//if same Rat or all same values, return 0, which means they are the same
		if(this.equals(r))
			return 0;
		/*
		 * if the two Rats have different names then we can use compareTo and order the Rats by name. use
		 * the String class compareTo() method
		 */
		if(!(name.equals(r.name)))
				return name.compareTo(r.name);
		/*
		 * if the two rats have different ages, then we can use compareTo and we can order the rats by age
		 * age is a Integer wrapper, so has a compareTo() method
		 */
		if(!(age.equals(r.age)))
			return age.compareTo(r.age);
		/*
		 * if both rats are different rats (which we know as if(this.equals(r)) returned false) and if names are
		 * not different and age are not different, that means that the two Rats have to have different weights
		 * so we can use compareTo with weights. Double is a wrapper so we can use the compareTo() method of the 
		 * Double class
		 */
		return weight.compareTo(r.weight);
			
	}

	@Override
	public String toString() {
		return "Rat [name=" + name + ", age=" + age + ", weight=" + weight + "]";
	}

	public Rat(String name, Integer age, Double weight) {
		super();
		this.name = name;
		this.age = age;
		this.weight = weight;
	}

}
