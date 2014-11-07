//Needs string tokenizer


public class FractionCalculator {

	//Needs constructor method to be able to read in a single line 
	
	
	private Fraction total;
	private Fraction operand;
	private String operator;
	
	//temp constructor whilst testing
	public void FractionCalculatre(Fraction total, String operator, Fraction operand){
		this.setTotal(total);
		this.setOperator(operator);
		this.setOperand(operand);
	}
	
	
	public Fraction getTotal() {
		return total;
	}
	public void setTotal(Fraction total) {
		this.total = total;
	}
	public Fraction getOperand() {
		return operand;
	}
	public void setOperand(Fraction operand) {
		this.operand = operand;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	
	public static Fraction calculate(Fraction operand1, String operator, Fraction operand2){
		
		//Case switch on operators
		
		if (operator == "+"){
			return operand1.add(operand2);
		}else {
			return new Fraction(99,100);

		}
	}
	
	
}
