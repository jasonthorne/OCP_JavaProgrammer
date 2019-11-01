package com.android;
/*
 * NAMING CONVENTIONS
 * E for element
 * K for a map key
 * V for a map value
 * N for a number
 * T for generic data type
 * S,U,V and so forth for multiple generic types
 * this is a generic, we create a Crate class object and we have to supply a generic type with it
 * i.e
 * Crate<Elephant>crateElephant=new Crate<Elephant>();
 * T in Crate class can be any OBJECT type we want, in the above case T will be of type Elephant
 */
public class Crate<T> {
	/*
	 * we can create an object of type T
	 * this object will be whatever generic type we create our class with
	 * i.e we create a crate with a Elephant, type T will be an Elephant
	 */
	private T contents;
	/*
	 * we can't go 
	 * private t=new T();
	 * as we have no idea what type T will be so we don't know what constructor will be used to create this object
	 */
	Crate(T contents){
		this.contents=contents;
		System.out.println("created a Crate with a "+contents.getClass().getSimpleName());
	}
	/*
	 * you can use the generic type in methods and constructors and in this case you can call any overriden methods of 
	 * the OBJECT class, as the only thing we know about this class before we run it is that type T, is that is a member of 
	 * the Object class
	 * here we set T to be an elephant, so the toString of and Elephant class prints "nellie the Elephant is my name"
	 */
	T returnMe() {
		System.out.println("calling toString method for this class of object "+contents);
		return contents;
	}

}
/*
 * a generic can be defined as a subclass of another class
 * here this generic will be a Animal
 * so only methods that were first defined in the Animal class can be used in this method
 * */
class Box<T extends Animal>{
	
	private T myAnimal;
	
	Box(T myAnimal){
		/*
		 * we assign a animal object to the animal reference myAnimal
		 */
		this.myAnimal=myAnimal;
		/*
		 * this generic data type can only be a Animal so we can call methods first defined in the Animal class, so we 
		 * can call the eat(), sleep() and stampede() methods
		 */
		myAnimal.eat();
		myAnimal.sleep();
		myAnimal.stampede();
		/*
		 * can access the height and weight variables
		 */
		System.out.println("height is "+myAnimal.height+" weight is "+myAnimal.weight);
		
	}
	
}
/*
 * this class takes a generic data type whose class implements the Behaviour interface, notice it is NOT IMPLEMENTS it's EXTENDS.
 * whether a class is using a generic type that eiher extends a class or implements a interface, we use the same keyword "EXTENDS"
 */
class Bucket<T extends Behaviour>{
	/*
	 * this variable of type T will only have access to the methods in the Behaviour interface, which are 
	 * happy(),mad() and sad()
	 */
	private T myBehave;
	
	Bucket(T myBehave){
		this.myBehave=myBehave;
		myBehave.happy();
		myBehave.mad();
		myBehave.sad();
	}
	
}
/*
 * this can be sent a lambda that implements the grow method
 */
class Pan<T extends Life>{
	
	private T myLife;
	
	Pan(T myLife){
		this.myLife=myLife;
		myLife.grow();
	}
}
/*
 * you can also create a class with a defined class type, in this case you can only create a Pot object with a Animal type, this
 * can be a Animal or a sub class of Animal
 */
class Pot<Animal>{
	
	String myStr;
	
	Animal myAnimal;
	
	Pot(Animal myAnimal){
		this.myAnimal=myAnimal;
	}
}
/*
 * can have more than one generic type, here we have three generic types
 * T is a type that extends Animal
 * V implments the Behaviour interface
 * and E can be any object we want
 * T will be an Elephant
 * V will be a Whale
 * E will be a String
 */
class Kettle<T extends Animal,V extends Behaviour,E>{
	/*
	 * this is a constructor that takes three generic types
	 */
	T myT;
	V myV;
	E myE;

	/*
	 * constructor that takes three generic types
	 */
	Kettle(T myT,V myV, E myE){
		this.myT=myT;
		this.myV=myV;
		this.myE=myE;
	}
	/*
	 * we are returning a object to be of generic type type, we can't create T object by going
	 * new T();
	 * as we don't know what type of object this is, so we don't know what constructor to call, however we do know that
	 * type T is some type of Animal (as we have said T extends Animal), so we can cast a Animal to be of Type T, as we know
	 * T will be a Animal of some type
	 */
	T method() {
		//will not compile as does not know which constructor to call
	//	return new T();
		/*
		 * this will not compile as if you send it a sub class of Animal, then T will be subclass of Animal
		 * you can't cast a super class object to be a sub class
		 * i.e
		 * T is type Elephant, Elephant subclass of Animal
		 * so this would be
		 * (Elephant)new Animal()
		 */
	//	return (T)new Animal();
		/*
		 * we could also return the myT object, which we know will be a Animal or sub class of Animal
		 */
		//System.out.println((Elephant)new Animal());//this is the same as the above code, and will not compile
		//will return the myT object
		return myT;
	}
	/*
	 * a method can have it's own generic type, S here can be any object type
	 */
	<S>void method2(S myS){
		System.out.println("method with a generic type called");
		System.out.println("the type is "+myS.getClass().getSimpleName());
	}
	
	/*
	 * you can't use generic types supplied when creating an object with statics, 
	 * as you can call statics without creating a member of the 
	 * class, and the types are only assigned when you create an object of the class
/*	static void callStats(T myT,V myV) {
		
	}*///will not compile
	/*
	 * this is a static method that has three of it's own generic types and each of the types eiher extends or implements an 
	 * interface (but use the keyword "EXTENDS" for both circumstances
	 */
	static<S extends Animal,V extends Behaviour, U extends Manners>void method3(S myS,V myV,U myU){
		
		Monkey<String>strMonkey=new Monkey<>();
		Ape andy=new Ape();
		/*
		 * myS is Animal, so can call methods of the Animal class
		 */
		System.out.println("myS is "+myS.getClass().getSimpleName());
		myS.eat();
		myS.sleep();
		myS.stampede();
		/*
		 * myV is a class that implements Behaviour, which is a whale or a Lemur
		 */
		System.out.println("myV is "+myV.getClass().getSimpleName());
		myV.happy();
		myV.sad();
		myV.mad();
		/*
		 * myU is a class that implements Manners, which is a Ape, Gorilla or Monkey, it can take any two objects
		 * in our case it is a Monkey whose type V was set to be a String
		 * class Monkey<V>implements Manners<Animal,V>{

				@Override
				public void thankYou(Animal t) {
				
				public void sorry(Animal t, V v) {
		 */
		System.out.println(myU.getClass().getSimpleName());//this is a monkey
		//can take a Animal or subclass of Animal
		myU.thankYou(new Animal());
		//takes a Animal or subclass of Animal and we have set type V to be a String
		myU.sorry(new Elephant(),"hello");
	//	myU.thankYou(andy);
	}
	
	static<S extends Animal>S method4(S myS){
		/*we have to cast this object to be of type Elephant as 
		 * we don't know what type of Animal S will be sent to this method
		 * so if we are returning type S and we want it to be an Elephant 
		 * we have to cast it to be of type S
		 * 
		 */
		System.out.println("method4");
		System.out.println("myS at start is a "+myS.getClass().getSimpleName());
		myS.sleep();
		myS.stampede();
		/*
		 * can't do this as myS is type S and this could be a sub class of Animal and you can't have a 
		 * sub class reference to a super class object, also you can't cast a super class to a be a sub class, it will compile
		 * but you will get ClassCastException
		 */
	//	myS=new Animal();
	//	Zebra zed=(Zebra)new Animal();//will give classCastException
		/*
		 * this WILL COMPILE as S can Animal or a subclass of Animal
		 */
		myS=(S) new Animal();
		System.out.println("myS after first cast "+myS.getClass().getSimpleName());
		myS.sleep();
	//	myS=(Zebra)new Animal();
		/*
		 * only have access to the Elephant class implementations of Animal class methods
		 * or Animal class implementations if no Elephant class implemenations are not avaiable
		 */
		myS=(S)new Elephant();
		System.out.println("myS after second cast "+myS.getClass().getSimpleName());
		myS.sleep();
		//and can change it back to Zebra
	//	myS=(S)new Zebra();
	//	myS.sleep();
		/*
		 * myS can be any animal and we can cast it to be any animal
		 */
		return myS;
	}
}

class Field<T extends Animal,U extends Crop>{
	/*
	 * T will be a type of crop
	 * U will be a type of Animal
	 */
	private T crop;
	private U animal;
	
	public Field(T crop,U animal) {
		this.crop=crop;
		this.animal=animal;
	}
}
