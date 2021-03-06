package com.android.humans;

public class Nurse {

	String name;
	
	public Nurse(String name) {
		this.name=name;
	}
/*
 * will have same hashCode if have two nurses have the same name
 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Nurse))
			return false;
		Nurse other = (Nurse) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Nurse [name=" + name + "]";
	}
	
	
	
	
}
