package com.android.animals;

public class Mouse extends Animal implements Comparable<Mouse>{
	private String name;
	private Integer age;
	private int id;
	static int counter=0;
	public Mouse(String name,Integer age){
		this.name=name;
		this.age=age;
		id=counter++;
	}
	@Override
	public int compareTo(Mouse mickey) {
		// TODO Auto-generated method stub
		return name.compareTo(mickey.name);//will list mice by name alphabetically
	//	return age.compareTo(mickey.age);//will list mice by age in ascending order 1,2,3
	}
	@Override
	public String toString() {
		return "Mouse [name=" + name + ", age=" + age + "]";
	}
	
	
	

}
