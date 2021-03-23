
public class HumanTest {
	public static void main(String[] args) {
		Human George = new Human("M");
		Human Liam = new Human("K");
		
		George.attack(Liam);
		George.attack(Liam);
		Liam.attack(George);
		

		
	}
}
