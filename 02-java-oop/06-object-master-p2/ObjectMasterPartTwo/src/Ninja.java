
public class Ninja extends Human {
	private int defaultHealth = 10;
	public Ninja() {
		this.stealth = 10;
	}
	
	public Ninja(String name) {
		this.name = name;
		this.stealth = 10;
	}
	
	public void steal(Ninja otherHuman) {
		otherHuman.health -= this.stealth;
		this.health += this.stealth; 
		System.out.printf("Ninja %s stealed %s's %d health, the current health: %d, \n %s healed %d", this.getName(), otherHuman.getName(), this.stealth, otherHuman.getHealth(), this.getName(), this.stealth);
	}
	
	public void runAway() {
		this.health -= defaultHealth;
		System.out.printf("Ninja %s runway , the health decreased %d, the current health: %d \n", this.getName(), this.defaultHealth, this.getHealth());
	}
}
