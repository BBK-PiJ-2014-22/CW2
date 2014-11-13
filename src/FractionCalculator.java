/**
 * 
 *Calculations
 *Operations
 *
 * 
 * 
 */


public class FractionCalculator {
	
	private Fraction total;
	private Fraction operand;
	private String operator;
	
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
	

	public void calculate(){
		
		String operator = this.getOperator();
		Fraction operand = this.getOperand();
		
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
	
	
	//Input reading methods
	private String parse(String str){
		try {
			Integer.parseInt(str);
			return str;
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
	
	
	//doX methods
	//Private methods intended to perform operations when necessary
	
	public void doFraction(String str){
		try{
			Fraction entry = Fraction.parseFraction(str);
			
			if (this.getOperator() != null){
				this.setOperand(entry);
				this.calculate();	
			} else {
				this.setTotal(entry);
			}
		
		}catch (Exception NumberFormatException){
			this.doExit(str);
		}
	}
	
	public void doExit(String str){
		if (str == "*" || str == "/" || str == "-" || str == "+"){
			System.out.println("Cannot have two operators in a row");
		}else if (! (str.toLowerCase().charAt(0) == 'q')){
			System.out.println("'"+str + "' is not a valid entry");
		}
		System.out.println("Ending program.");
		System.exit(0);
	}
	
	public void doOperation(String operator){
		switch (operator){
		case "a":
			this.setTotal(this.getTotal().absValue());
			break;
		case "n":
			this.setTotal(this.getTotal().negate());
			break;
		case "c":
			this.setTotal(new Fraction(0,1));		
			break;
		}
	}
	
	public void doOperator(String operator){
		if (this.getOperator() == null){
			this.setOperator(operator);
		}else{
			doExit(operator);
		}
		
	}
	
	
	//Evaluate - 
	//Takes in a fraction (starting value) and a string(calculation instructions)
	//Results in new fraction
	//Recursive?
	
	
	
}
