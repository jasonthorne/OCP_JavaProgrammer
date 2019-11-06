package com.android;

//'instanceOf' checks if an object CAN BE an instance of a class. +++++++++++++++++++++++++++


//base class:
public class HeavyAnimal {

}

//subclass:
class Hippo extends HeavyAnimal{
	
}

//subclass of Hippo which implements Behaviour Interface:
class PygmyHippo extends Hippo implements Behaviour{
	
}

//subclass of HeavyAnimal:
class Elephant extends HeavyAnimal{
	
}

//this is NO RELATIONSHIP between the Cow class and the other classes and interfaces in this file.
class Cow{
	
}

