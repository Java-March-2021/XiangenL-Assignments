import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.lang.CharSequence;

public class PuzzleJava {
	public static void main(String[] args) {
		
		int[] arr = {3,5,1,2,7,9,8,13,25,32};
		greaterTen(arr, 10);
		String[] names = { "Nancy", "Jinchi", "Fujibayashi", "Momochi", "Ishikawa" };
		printName(names);
		printAlphabet();
		randomInteger(55, 100);
		randomString(5);
		randomStringArr(10);
	}
	public static ArrayList<Integer> greaterTen(int[] arr, int num) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int sum = 0;
		for (int i : arr) {
			sum = sum + i;
			if ( num < i) {
				System.out.println(i);
			}
		}
		System.out.println("Sum: " + sum);
		return list;
	}
	
	public static ArrayList<String> printName(String[] names) {
		ArrayList<String> allName = new ArrayList<String>();
		Collections.shuffle(allName);
		for (String name : names) {
			System.out.println(name);
			if ( name.length() > 5) {
				System.out.println(name + "is more than 5 Characters!"); // display names that are longer than 5 characters.
			}
		}
		return allName;
	}
	
	public static ArrayList<Character> printAlphabet() {
		ArrayList<Character> alphabet = new ArrayList<Character>();
		for(char ch = 'a'; ch <= 'z'; ++ch) {
			alphabet.add(ch);
		}
		System.out.println(alphabet);
		Collections.shuffle(alphabet);
		System.out.println(alphabet);
		System.out.println(alphabet.get(25)); // last letter
		System.out.println(alphabet.get(0)); // first letter
		// if the first letter is vowel, display a message.
		Character[] vowels = {'a', 'e', 'i', 'o', 'u'};
		for(int i = 0; i < vowels.length; i++) {
			if ( alphabet.get(0) == vowels[i]) {
				System.out.println("The first letter is vowel " + alphabet.get(0));
			}
		}		
		return alphabet;
	}
	//Generate and return an array with 10 random numbers between 55-100
	public static Random randomInteger( int min, int max) {
		Random r = new Random();
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		for(int i = 0; i < 10; i++) {
			int randomNum = r.nextInt(max-min) + min;
			numbers.add(randomNum);
		}
		System.out.println(numbers);
		// be sorted
		Collections.sort(numbers);
		System.out.println(numbers);
		// min, max
		System.out.println("Minimum value: " + numbers.get(0) +", " + "Maximum value: " + numbers.get(9));
		return r;
	}
	// Create a random string that is 5 characters long.
	public static String randomString(int n) {
		Random r = new Random();
		StringBuilder ranName = new StringBuilder();
		ArrayList<Character> alphabet = new ArrayList<Character>();
		for(char ch = 'a'; ch <= 'z'; ++ch) {
			alphabet.add(ch);
		}
		for(int i = 0; i <n; i++) {
			int number = r.nextInt(25);
			ranName.append(alphabet.get(number));		
		}
		System.out.println(ranName.toString());
		return ranName.toString();	
	}
	// Generate an array with 10 random strings that are each 5 characters long
	public static void randomStringArr(int n) {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			String ranName = randomString(5);
			String name = ranName.toString();
			list.add(name);	
		}
		System.out.println(list); 
	}
}
