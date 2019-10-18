package com.android;
/*
 * here we are creating a class usign object composition rather than using inheritance
 * So all the atributes in each class are directy assigned from other classes and are not inherited from 
 * anywhere, unlike say in the primate and chimp class. with the primate and chimp class we had a tail atribute 
 * for all primates but chimps DO not have tails, and neither do Humans (a way around this of course is to have no
 * tail atribute in the primate class and have a sub class of primate that would have tails)
 */
public class Penguin {
	private Flippers myFlippers;
	private WebbedFeet myWebbedFeet;
	
	Penguin(){
		myFlippers=new Flippers();
		myWebbedFeet=new WebbedFeet();
		myFlippers.flap();
		myWebbedFeet.kick();
	}
	

}

class Flippers{
	public void flap() {
		System.out.println("flapping my fippers to swim");
	}
}

class WebbedFeet{
	public void kick() {
		System.out.println("kicking legs to swim");
	}
}
