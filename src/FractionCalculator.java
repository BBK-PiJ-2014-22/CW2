import java.util.StringTokenizer;


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
	
	
	//Calculations & other operators

	public void calculate(String operator, Fraction operand){
		
		this.setOperand(null);
		this.setOperator(null);
		
		switch (operator){		

		case "-":
			this.setTotal(this.getTotal().subtract(operand));
			break;
		case "/":
			this.setTotal(this.getTotal().divide(operand));
			break;
		case "*":
			this.setTotal(this.getTotal().multiply(operand));
			break;
		case "+":
			this.setTotal(this.getTotal().add(operand));
			break;
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

	
	//Input reading methods
	
	public String parse(String str){


		try {
			Integer.parseInt(str);
			return "Integer";
		} catch(Exception NumberFormatException){
		
			if (str == "+" ||
				str == "-" ||
				str == "/" ||
				str == "*"){
					return "Calculation";
				
			}else if(str.toLowerCase().charAt(0) == 'a' ||
					 str.toLowerCase().charAt(0) == 'n' ||
					 str.toLowerCase().charAt(0) == 'c' ||
					 str.toLowerCase().charAt(0) == 'q'){
					return "Operation";
					
			}else if(str.indexOf("/") >= 1 ){	
				
				return "Fraction";
			}else{
					return "Error";
			}

			
			
		}
		
	}
	
	//Evaluate - 
	//Takes in a fraction (starting value) and a string(calculation instructions)
	//Results in new fraction
	//Recursive?
	
	
	
}
