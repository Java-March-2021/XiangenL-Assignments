package com.zookeeper.projecttwo;

public class Bat extends Mammal{
	public Bat (int energyLevel) {
		super(energyLevel);
	}

	public void fly() {
		System.out.println("the sound a bat taking off");
		this.energyLevel -= 50;
	}
	
	public void eatHumans() {
		System.out.println("so- well, never mind");
		this.energyLevel += 25;
	}

	public void attackTown() {
		System.out.println("the sound of a town on fire");
		this.energyLevel -= 100;
	}
}
