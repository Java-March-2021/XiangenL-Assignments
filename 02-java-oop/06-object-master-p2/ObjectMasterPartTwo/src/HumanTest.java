public class HumanTest {
	public static void main(String[] args) {
		Human George = new Human("George");
		Human Liam = new Human("Liam");
		
		George.attack(Liam);
		George.attack(Liam);
		Liam.attack(George);
		
		Ninja Kawayi = new Ninja("Kawayi");
		Ninja Kimsung = new Ninja("Kimsung");
		
		Kawayi.runAway();
		Kimsung.steal(Kawayi);
		
		
		Wizard Katie = new Wizard("Katie");
		Wizard Lucy = new Wizard("Lucy");
		
		Katie.fireball(Lucy);
		Katie.fireball(Lucy);
		Katie.heal(Lucy);
		
		Samurai Liu = new Samurai("Liu");
		Samurai Huang = new Samurai("Huang");
		Samurai Jacob = new Samurai("Jacob");
		
		Liu.deathBlow(Huang);
		Liu.deathBlow(Jacob);
		Liu.meditate();
		System.out.println(Samurai.countSamurai);
	
		
	}
}