package com.android;

public class Ostrich implements Comparable<Ostrich>{
	int id;
	String name;
	int age;
	double weight;
	static int counter=0;
	
	Ostrich(String name,int age,double weight){
		this.age=age;
		this.name=name;
		this.weight=weight;
		id=++counter;
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
		if (!(obj instanceof Ostrich))
			return false;
		Ostrich other = (Ostrich) obj;
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
		return true;
	}

	@Override
	public int compareTo(Ostrich o) {
		if(this.equals(o))
		return 0;
		//comparing strings
		if(!(name.equals(o.name)))
			return name.compareTo(o.name);
		Integer age1=age;
		Integer age2=o.age;
		if(!(age1.equals(age2)))
			return age1.compareTo(age2);
		Double weight1=weight;
		Double weight2=o.weight;
		if(!(weight1.equals(weight2)))
			return weight1.compareTo(weight2);
		Integer id1=id;
		Integer id2=o.id;
		return id1.compareTo(id2);
	//	return 0;
	}

	@Override
	public String toString() {
		return "Ostrich [id=" + id + ", name=" + name + ", age=" + age + ", weight=" + weight + "]";
	}
	
	
	
	

}
