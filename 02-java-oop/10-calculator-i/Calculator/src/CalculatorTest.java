public class CalculatorTest {
	public static void main(String[] args) {
		Calculator math = new Calculator();
		math.setOperandOne(10.5);
		math.setOperation('+');
		math.setOperandTwo(5.2);
		math.performOperation();
		math.getResults();
	}
}
