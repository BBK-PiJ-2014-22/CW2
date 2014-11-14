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
	
	public FractionCalculator(String entry){
		this.setTotal(new Fraction(0,1));
		this.evaluate(this.getTotal(), entry);
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
	
	
	//Input reading methods
	
	public Fraction evaluate(Fraction start, String entry){
	
		int tokenEnd = entry.indexOf(" ");
		
		if (tokenEnd > 0){
			this.parseToken(entry.substring(0,tokenEnd));
			evaluate(this.getTotal(), entry.substring(tokenEnd+1, entry.length()));
	
		}else{
			this.parseToken(entry);	
		}
		return this.getTotal();
	}
	
	
	private void parseToken(String str){
		  try {
			Integer.parseInt(str);
			doFraction(str+"/1");
		} catch(Exception NumberFormatException){
			if (str.equals("+") ||
				str.equals("-") ||
				str.equals("/") ||
				str.equals("*")){
					doOperator(str);
					
			}else if(str.indexOf("/") >= 1 ){	
				doFraction(str);				

			}else if(str.toLowerCase().charAt(0) == 'a' ||
					 str.toLowerCase().charAt(0) == 'n' ||
					 str.toLowerCase().charAt(0) == 'c' ){
					doUnaryOperation(str);
			}else if(str.toLowerCase().charAt(0) == 'q'){
				System.out.println("Thank you for using Fraction calculator!");
				System.exit(0);
			}else{
				this.doError(str);
			}
		}	
	}
	
	
	//do methods
	//Private methods, to be called by the Parse method. These methods 
	//will perform actions based upon the String tokens fed into them, 
	//updating the FractionCalculator.
	
	private void doFraction(String str){
		try{
			Fraction entry = Fraction.parseFraction(str);
			
			if (entry.toString().equals("0/0")){
				this.reset();
			} else if (this.getOperator() != null){
				this.setOperand(entry);
				this.calculate();	
			} else {
				this.setTotal(entry);
			}
		}catch (Exception NumberFormatException){
			this.doError(str);
		}
	}
	
	
	private void doUnaryOperation(String operator){
		
		operator = operator.substring(0,1).toLowerCase();
		
		if (this.getOperator() == null){
	
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

	private void doError(String str){
		if (str.equals("*") || str.equals("/") || str.equals("-") || str.equals("+") ||
			(str.charAt(0) == 'a' || str.charAt(0) == 'c' || str.charAt(0) == 'n') &&
			(str.indexOf("/") < 0)){
			System.out.println("Cannot have two operators in a row");			
		}else{
			System.out.println("'"+str + "' is not a valid entry");
		}		
		this.reset();
	}
	
	
	
	//Internal update methods
	//To be called from the Do methods to make updates to the object
	private void reset(){
		this.setTotal(new Fraction(0,1));
		this.setOperand(null);
		this.setOperator(null);
	}
	
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


	//Main and Launch methods
	
	public static void main(String[] args){
		
		FractionCalculator fc;
		
		if (args.length > 0){
			String entry = "";
			for (int i = 0; i < args.length ; i++){
				entry = entry + args[i] + " ";
			}
			fc = new FractionCalculator(entry);
		}else{
			fc = new FractionCalculator();
		}		
		fc.launch();		
		}

	private void launch(){
		
		System.out.println("Welcome to Fraction Calculator!");
		
		Fraction result;
		
		do{
			System.out.println("Enter calculation:");
			result = this.evaluate(this.getTotal(), System.console().readLine());
			System.out.println("New Total: "+ result);
			System.out.println();
		}while (true);	
	}
	
}
	




