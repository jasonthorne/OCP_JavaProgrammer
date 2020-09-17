package com.android;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class School implements Serializable{
	/*
	 * all classes that are referred to inside the School clas also have to implement the Serializable
	 * interface.
	 * So Teacher, Pupil and subjects of each school, those classe have to implment serializable interface
	 * Any object of a class that does not implement the serializable interface has to be marked as
	 * Transient
	 */
	String name;//name of school
	
	LocalTime start;
	
	LocalDateTime timeId;
	

}
