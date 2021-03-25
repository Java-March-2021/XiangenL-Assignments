public class Calculator implements java.io.Serializable {
	private double results;
	private double operandOne;
	private double operandTwo;
	private char operation; 
	
	public Calculator() {
		
	}
	public void setOperandOne(double input) {
		this.operandOne = input;
	}
	public void setOperandTwo(double input) {
		this.operandTwo = input;
	}
	public void setOperation(char input) {
		this.operation = input;
	}
	public void performOperation() {
		if( this.operation == '+') {
			this.results = (operandOne) + (operandTwo);
		}
		if( this.operation == '-') {
			this.results = (operandOne) - (operandTwo);
		}
	}
	public void getResults() {
		System.out.println(results);
	}
}
