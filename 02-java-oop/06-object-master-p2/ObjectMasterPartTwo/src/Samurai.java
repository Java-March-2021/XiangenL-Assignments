import java.util.ArrayList;
public class Samurai extends Human{
	protected static int countSamurai = 0;
	private static int defaultHealth = 200;

	public Samurai() {
		this.health = defaultHealth;
		countSamurai++;
	}
	
	public Samurai( String name) {
		this.name = name;
		this.health = defaultHealth;
		countSamurai++;
	}
	
	public void deathBlow(Human otherHuman) {
		otherHuman.health = 0;
		this.health -= defaultHealth % 2;
		countSamurai --;
		System.out.printf("Ninja %s killed %s and the current health: %d \n", this.getName(), otherHuman.getName(), this.health);
	}
	
	public void meditate() {
		this.health = defaultHealth;
		System.out.println("The health is full.");
	}
	
	public void howMany() {
		System.out.printf("Total current number of Samurai: %i", countSamurai);
	}
}
