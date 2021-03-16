public class FizzBuzz {
    public static String fizzBuzz(int number) {
        // count up from 0 to number
        // if we see a numbe that is
        for(int i = 1; i <= number; i++) {
            // divisible by 3 And 5 print "BuzzFizz"
            if(i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            }
            // divisible by 3, print "Buzz"
            else if(i % 3 == 0) {
                System.out.println("Buzz");
            }
            // divisible by 5, print "Fizz            
            else if(i % 5 == 0) {
                System.out.println("Fizz");
            }
            // if none of these are true, just print the number
            else {
                System.out.println(i);
            }
        }
        return "Hello";
    }
}