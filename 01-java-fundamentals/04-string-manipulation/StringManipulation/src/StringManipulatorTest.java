public class StringManipulatorTest {
    public static void main(String[] args) {
        StringManipulator manipulator = new StringManipulator();
        String str = manipulator.trimAndConcat("    Hello     ","     World    ");
        System.out.println(str); 
        
        StringManipulator manipulator1 = new StringManipulator();
        char letter = 'o';
        Integer a = manipulator1.getIndexOrNull("Coding", letter);
        Integer b = manipulator1.getIndexOrNull("Hello World", letter);
        Integer c = manipulator1.getIndexOrNull("Hi", letter);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        
        StringManipulator manipulator2 = new StringManipulator();
    	String word = "Hello";
    	String subString = "llo";
    	String notSubString = "world";
    	Integer x = manipulator2.getIndexOrNull(word, subString);
    	Integer y = manipulator2.getIndexOrNull(word, notSubString);
    	System.out.println(x);
    	System.out.println(y);
    	
    	StringManipulator manipulator3 = new StringManipulator();
    	String word1 = manipulator3.concatSubstring("Hello", 1, 2, "world");
    	System.out.println(word1);
    } 
}