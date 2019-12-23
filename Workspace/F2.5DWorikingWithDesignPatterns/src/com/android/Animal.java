package com.android;
/*
 * this is going to be used with using the factory pattern with classes
 */
public abstract class Animal {

}

abstract class Carnivore extends Animal{
	
}

class Lion extends Animal{
	
}

abstract class Bear extends Carnivore{
	
}

class PolarBear extends Bear{
	
}

abstract class Herbivore extends Animal{
	
}

class Rabbit extends Herbivore{
	
}

class Zebra extends Herbivore{
	
}

class Goat extends Herbivore {
	
}
