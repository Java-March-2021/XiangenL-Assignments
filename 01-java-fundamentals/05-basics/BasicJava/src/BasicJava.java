import java.util.ArrayList;
import java.util.Arrays;

public class BasicJava {
	public static void main(String[] args) {
		printOneTo255(255);
		printOdd(255);
		printSum(255);
		int[] X = {1,3,5,7,9,13};
		int[] m = {-4, -32, 0, 7};
		iterateArray(X);
		findMax(m);
		getAverage(m);
		oddNumArray(255);
		greaterThanY(X, 5);
		int[] x = {1,5, 10, -2};
		squareValue(x);
		int[] xx = {1,5, 10, -2};
		replaceNegative(xx);
		int[] xxx = {1,5, 10, -2};
		newList(xxx);
		int[] y = {1, 5, 10, 7, -2};
		shiftValue(y);
	}
	// print 1-255
	public static int printOneTo255(int num) {
		for (int i = 1; i <= num; i++) {
			System.out.println(i);
		}
		return num;
	}
	// print odd numbers between 1-255
	public static int printOdd(int num) {
		for (int i = 1; i <= num; i++) {
			if (i % 2 != 0) {
			System.out.println(i);
			}
		}
		return num;
	}
	// print sum
	public static String printSum(int num) {
		int sum = 0;
		for (int i = 0; i <= num; i++) {
			sum = sum + i;
			System.out.println(String.format("New number: %d, Sum: %d", i, sum));
		}
		return Integer.toString(num);
	}
    // Iterating through an array
	public static int[] iterateArray(int[] array) {
		for( int num : array) {
			System.out.println(num);
		}
		return array;
	}
	// Find max
	public static int[] findMax(int[] array) {
		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		System.out.println(max);
		return array;
	}
	// Get average
	public static int[] getAverage(int[] array) {
		int sum = 0;
		for (int i=0; i< array.length; i++) {
			sum += array[i];
		}
		System.out.println(sum);
		return array;
	}
	// Array with odd numbers
	public static int oddNumArray(int max) {
		ArrayList<Integer> Y = new ArrayList<Integer>();
		for (int i = 0; i < max; i++) {
			if ( i % 2 != 0) {
				Y.add(i);
			}
		}
		System.out.println("Y: " + Y);
		return max;
	}
	// Greater than Y
	public static int[] greaterThanY(int[] array, int Y) {
		int count = 0;
		for ( int i = 0; i < array.length; i++) {
			if (array[i] > Y) {
				count += 1;
			}
		}
		System.out.println(count);
		return array;
	}
	// Square the values
	public static int[] squareValue(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = array[i] * array[i];

		}
		System.out.println(Arrays.toString(array));
		return array;
	}
	// Eliminate negative numbers
	public static int[] replaceNegative(int[] arr) {
		for (int i=0; i< arr.length; i++) {
			if (arr[i] < 0) {
				arr[i] = 0;
			}
		}
		System.out.println(Arrays.toString(arr));
		return arr;
	}
	// Max, min, and average
	public static ArrayList<Integer> newList(int[] arr) {
		int max = arr[0];
		int min = arr[0];
		int sum = 0;
		ArrayList<Integer> container = new ArrayList<Integer>();
		for (int i=0; i< arr.length; i++) {
			sum += arr[i];
			if (arr[i] < min) {
				min = arr[i];
			}
			if (arr[i] > max) {
				max = arr[i];
			}	
		}
		int avg = sum / arr.length;
		container.add(max);
		container.add(min);
		container.add(avg);
		System.out.println(container);
		return container;
	}
	// Shifting the values in the array
	public static void shiftValue(int[] list) {
		for (int i = 0; i < list.length - 1; i++) {
			list[i] = list[i+1];
		}
		list[list.length-1] = 0;
		System.out.println(Arrays.toString(list));
	}
}
