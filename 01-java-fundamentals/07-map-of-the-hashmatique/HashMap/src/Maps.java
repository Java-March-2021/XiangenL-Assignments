import java.util.HashMap;
import java.util.Set;
public class Maps {
	public static void main(String[] args) {
		HashMap<String, String> song = new HashMap<String, String>();
		song.put("Let it be", "When I find myself in times of trouble, Mother Mary comes to me");
		song.put("Lemon tree", "I'm sitting here in a boring room");
		song.put("Snowman", "Don't cry, snowman, not in front of me");
		song.put("We Wish You a Merry Christmas", "We wish you a merry Christmas");
		
		Set<String> keys = song.keySet();
		for(String key : keys) {
			System.out.println("Track: " + key  + ", lyrics: " + song.get(key));
		}
	}
}
