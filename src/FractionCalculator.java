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
	

	private void calculate(){
		
		String operator = this.getOperator();
		Fraction operand = this.getOperand();
	
		
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
		
		this.setOperand(null);
		this.setOperator(null);
	}	
	
	
	//Input reading methods
	public void parseToken(String str){
		try {
			Integer.parseInt(str);
			doFraction(str+"/1");
		} catch(Exception NumberFormatException){
			if (str == "+" ||
				str == "-" ||
				str == "/" ||
				str == "*"){
					doOperator(str);
					
			}else if(str.indexOf("/") >= 1 ){	
				doFraction(str);				

			}else if(str.toLowerCase().charAt(0) == 'a' ||
					 str.toLowerCase().charAt(0) == 'n' ||
					 str.toLowerCase().charAt(0) == 'c' ){
					doUnaryOperation(str);
			}else{
				this.doError(str);
			}
		}	
	}
	
	
	//doX methods
	//Private methods intended to perform operations when necessary
	
	private void doFraction(String str){
		try{
			Fraction entry = Fraction.parseFraction(str);

			if (this.getOperator() != null){
				this.setOperand(entry);
				this.calculate();	
			} else {
				this.setTotal(entry);
			}
		}catch (Exception NumberFormatException){
			this.doError(str);
		}
	}
	
	private void doError(String str){
		if (str == "*" || str == "/" || str == "-" || str == "+"){
			System.out.println("Cannot have two operators in a row");
			this.reset();
			
		}else if (! (str.toLowerCase().charAt(0) == 'q')){
			System.out.println("'"+str + "' is not a valid entry");
			this.reset();
		}		
	}
	
	private void doUnaryOperation(String operator){
		
		if (this.getOperator() == null){
	
			char operatorChar = operator.toLowerCase().charAt(0);
			switch (operatorChar){
			case 'a':
				this.setTotal(this.getTotal().absValue());
				break;
			case 'n':
				this.setTotal(this.getTotal().negate());
				break;
			case 'c':
				this.setTotal(new Fraction(0,1));		
				break;
			}
	
		}else {
			this.doError(operator);
		}
	}
	private void doOperator(String operator){
		if (this.getOperator() == null){
			this.setOperator(operator);
		}else{
			this.doError(operator);
		}
	}
	
	private void reset(){
		this.setTotal(new Fraction(0,1));
		this.setOperand(null);
		this.setOperator(null);
	}
	
	
	//Evaluate - 
	//Takes in a fraction (starting value) and a string(calculation instructions)
	//Results in new fraction
	//Recursive?
	
	
	
}
