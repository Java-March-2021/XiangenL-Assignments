package com.zookeeper.projectone;

public class Gorilla extends Mammal{
	public Gorilla (int energyLevel) {
		super(energyLevel);
		if (this.energyLevel < 5) {
			System.out.println("I run out my energy, I need banabas.");
			this.eatBananas();
		}
	}
	
	public void throwSomething() {
		System.out.println("throwing something here");
		this.energyLevel -= 5;

	}
	
	public void eatBananas() {
		System.out.println("eating bananas");
		this.energyLevel += 10;
	}

	public void climb() {
		System.out.println("climbing a tree");
		this.energyLevel -= 10;
	}
}
