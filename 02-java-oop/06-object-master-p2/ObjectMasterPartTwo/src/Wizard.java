
public class Wizard extends Human {
	private int damage;
	public Wizard() {
		this.health = 50;
		this.intelligence = 8;
	}
	
	public Wizard(String name) {
		this.damage = damage;
		this.name = name;
	}
	public void heal(Wizard otherHuman) {
		otherHuman.health += this.intelligence;
		System.out.printf("Wizard %s healed %s, the health increased %d, current health: %d \n", this.getName(), otherHuman.getName(), this.intelligence, otherHuman.getHealth());
	}
	
	public void fireball(Wizard otherHuman) {

		otherHuman.health -= this.intelligence * 3;
		System.out.printf("%s attacked %s, the health decreased %d, current health: %d \n", this.name, otherHuman.getName(), otherHuman.intelligence * 3, otherHuman.getHealth());
	}
}
