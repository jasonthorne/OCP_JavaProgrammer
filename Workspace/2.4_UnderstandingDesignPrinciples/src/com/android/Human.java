package com.android;

public class Human {
	
	//ensure that every human has a non null name
	private String name;
	
	//every human has an age greater than 0
	private int age;
	
	Human(String name, int age){
		this.setName(name); //set name
		this.setAge(age); //set name
	}

	
	//getters & setters:
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}


	private void setName(String name) {
		if(name==null||name.trim().length()==0) {
			throw new IllegalArgumentException("A name is required for our Human");
			//this.name = "John Doe";
		}else {
			this.name = name;
		}
		
	}

	private void setAge(int age) {
		if(age<0) {
			throw new IllegalArgumentException("Age can't be a negitive number");
			//this.age=0;
		}else {
			this.age = age;
		}
		
	}
	
	
	
	

}
