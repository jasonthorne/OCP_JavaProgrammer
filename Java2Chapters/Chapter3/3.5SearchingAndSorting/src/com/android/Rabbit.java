package com.android;

public class Rabbit {
	private int id;
	
	Rabbit(int id){
		this.id=id;
	}

	@Override
	public String toString() {
		return "Rabbit [id=" + id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Rabbit other = (Rabbit) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

}
