package com.android.animals;

public class Mouse extends Animal implements Comparable<Mouse> {

	private String name;
	private Integer age;
	
	public Mouse(String name, Integer age){
		this.name = name;
		this.age=age;
	}
	
	
	@Override
	public int compareTo(Mouse mickey) {
		// TODO Auto-generated method stub
		return name.compareTo(mickey.name); //comparing on the name
		
		//return age.compareTo(mickey.age); //comparing by age
	}


	@Override
	public String toString() {
		return "Mouse [name=" + name + ", age=" + age + "]";
	}
	
	
	
}
