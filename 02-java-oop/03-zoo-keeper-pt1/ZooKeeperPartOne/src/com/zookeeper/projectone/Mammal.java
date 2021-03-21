package com.zookeeper.projectone;

public class Mammal {
	protected int energyLevel = 100;
	
	public Mammal(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	
	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	
	public int getEnergyLevel() {
		return energyLevel;
	}
	
	public int displayEnergyLevel() {
		System.out.println("Energy level: " + this.energyLevel);
		return this.energyLevel;
	}
}
