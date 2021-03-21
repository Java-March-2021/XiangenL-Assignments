package com.zookeeper.projecttwo;

public class BatTest {
public static void main(String[] args) {
	Bat vampire = new Bat(300);
	
	vampire.attackTown();
	vampire.attackTown();
	vampire.attackTown();
	vampire.eatHumans();
	vampire.eatHumans();
	vampire.fly();
	vampire.fly();
	vampire.displayEnergyLevel();
}
}
