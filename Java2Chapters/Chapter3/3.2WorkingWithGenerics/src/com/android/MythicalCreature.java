package com.android;

public class MythicalCreature {
	
	void doMagic() {
		System.out.println("mythical creature does magic");
	}

}

class Dragon extends MythicalCreature{
	@Override
	void doMagic() {
		System.out.println("Dragon do magic");
	}
}

class Unicorn extends MythicalCreature{
	@Override
	void doMagic() {
		System.out.println("unicorn do Magic");
	}
}
