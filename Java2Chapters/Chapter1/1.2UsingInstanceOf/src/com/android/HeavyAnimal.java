package com.android;
//base class
public class HeavyAnimal {

}
//subclass of HeavyAnimal
class Hippo extends HeavyAnimal{
	
}
//subclass of Hippo and also implements Behaviour interface
class PygmyHippo extends Hippo implements Behaviour{
	
}
//subclass of HeavyAnimal
class Elephant extends HeavyAnimal{
	
}
/*
 * there is no relationship between the cow class and the other classes in this file so you cannot use 
 * instanceof for cow in relation to the elephant, hippo or any other type of heavy Animal
 */
class Cow{
	
}