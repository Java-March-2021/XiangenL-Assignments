
public class HumanTest {
	public static void main(String[] args) {
		Human George = new Human("George");
		Human Liam = new Human("Liam");
		
		George.attack(Liam);
		George.attack(Liam);
		Liam.attack(George);
		
		
	}
}
