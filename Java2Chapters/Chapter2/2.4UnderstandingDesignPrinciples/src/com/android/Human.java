package com.android;

public class Human {
	private String  name;
	private int age;
	/*
	 * constructors call the setName() method with the string name sent to the constructor, which ensures
	 * that the name is not null and is not just a blank string
	 * Constructor calls the setAge() method with the int age sent to the constructor, which ensures the age 
	 * is greater than 0
	 * or we could assign a default name or a default age, and require that this name and age be replaced at a 
	 * later stage in the code
	 */
	Human(String name,int age){
		this.setName(name);
		this.setAge(age);
		System.out.println("human created with age of "+age+" and name of "+name);
	}
	
	public String getName() {
		return name;
	}
	
	/*
	 * we can add more complex rules in the setters without effecting other users of the class
	 * as long as we don't change the method signature of the setters it will not effect other users of the 
	 * code
	 */
	private void setName(String name) {
		if(name==null||name.trim().length()==0) {
			throw new IllegalArgumentException("a name is required for our Human");
		}
	}
	
	public int getAge() {
		return age;
	}
	
	private void setAge(int age) {
		if(age<0) {
			throw new IllegalArgumentException("age cannot be a negative number, choose zero if younger than 1");
		}
	}
	

}
