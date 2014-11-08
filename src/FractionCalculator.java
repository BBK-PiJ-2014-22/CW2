//Needs string tokenizer


public class FractionCalculator {

	//Needs constructor method to be able to read in a single line 
	
	
	private Fraction total;
	private Fraction operand;
	private String operator;
	
	//temp constructor whilst testing
	public FractionCalculator(){
		this.setTotal(new Fraction(0,1));
	}
	
	@Override
	public String toString() {
		return "FractionCalculator [total=" + total + ", operand=" + operand
				+ ", operator=" + operator + "]";
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
	
	
	public void calculate(String operator, Fraction operand){
		
		this.setOperand(null);
		this.setOperator(null);
		
		switch (operator){		
		case "+":
			this.setTotal(this.getTotal().add(operand));
		case "-":
			this.setTotal(this.getTotal().subtract(operand));
		case "/":
			this.setTotal(this.getTotal().divide(operand));
		case "*":
			this.setTotal(this.getTotal().multiply(operand));
		}				
	}	
	
	public void absolute(){
		this.setTotal(this.getTotal().absValue());	
	}
	
	public void negate(){
		this.setTotal(this.getTotal().multiply(new Fraction(1,-1)));
		}
	
	public void clear(){
		this.setTotal(new Fraction(0,1));
	}






	
		

	
	//Evaluate - 
	//Takes in a fraction (starting value) and a string(calculation instructions)
	//Results in new fraction
	//Recursive?
	
	//Parse
	//Takes a substring and says "What is this?" Fraction/Operator/Number
	//
	
	
	
}
