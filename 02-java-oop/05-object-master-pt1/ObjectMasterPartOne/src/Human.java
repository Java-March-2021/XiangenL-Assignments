
public class Human {
	private String name;
	private int strength = 3;
	private int stealth = 3;
	private int intelligence = 3;
	private int health = 100;
	
	public Human() {
		
	}
	
	public Human(String name) {
		this.name = name;
	}
	
	public Human(String name, int strength, int stealth, int intelligence, int health) {
		this.name = name;
		this.strength = strength;
		this.stealth = stealth;
		this.intelligence = intelligence;
		this.health = health;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getStealth() {
		return stealth;
	}

	public void setStealth(int stealth) {
		this.stealth = stealth;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	public void attack(Human target) {
		int health = target.getHealth() - target.strength;
		target.setHealth(health);
		System.out.printf("%s Attack %s!\n %s Health reduced %d, and current health is %d \n", this.name, target.name, target.name, target.strength, target.getHealth());
	}
}
