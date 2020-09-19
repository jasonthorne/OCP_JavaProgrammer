package com.android;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Teacher implements Serializable{
	
	int id;
	String name;
	int age;
	double wage;
	
	Set<Subject>teacherSubjects=new HashSet<>();
	
	Teacher(){
		teacherSubjects.addAll(Arrays.asList(Subject.ART,Subject.WOODWORK,Subject.HOME_ECONOMICS));
	}
	
	void teach() {
		System.out.println("teacher teaching");
	}

}
