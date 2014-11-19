/**
 * 
 *Calculations
 *Operations
 *
 * 
 * 
 */

public class FractionCalculator {
	
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
	
		if (! this.getTotal().equals(new Fraction(0,1))){
			System.out.println(this.getTotal());
		}
		
		Fraction result;
		
		do{
			System.out.println("Enter calculation:");
			result = this.evaluate(this.getTotal(), System.console().readLine());
			//out temporarily for debugging System.out.println(result);
			System.out.println(this);//temporary for debugging
			System.out.println();
		}while (!quit);	
		
		System.out.println("Thank you for using Fraction Calculator.");
	}
	
	
	
	
	private Fraction total;
	private Fraction operand;
	private String operator;
	private boolean quit = false;
	
	
	
	//Constructors, toString, Getters & Setters
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
	private void setTotal(Fraction total) {
		this.total = total;
	}
	public Fraction getOperand() {
		return operand;
	}
	private void setOperand(Fraction operand) {
		this.operand = operand;
	}
	public String getOperator() {
		return operator;
	}
	private void setOperator(String operator) {
		this.operator = operator;
	}
	
	
	//Input reading methods
	
	public Fraction evaluate(Fraction start, String entry){
	
		entry = entry.trim();		
		int tokenEnd = entry.indexOf(" ");
		
		if (entry.length() == 0){ // do nothing - blank token
		}else if (tokenEnd > 0){
			this.parseToken(entry.substring(0,tokenEnd));
			evaluate(this.getTotal(), entry.substring(tokenEnd+1, entry.length()));
		}else{
			this.parseToken(entry);	
		}
		return this.getTotal();
	}
	
	
	private void parseToken(String str){
				
			if (str.equals("+") ||
				str.equals("-") ||
				str.equals("/") ||
				str.equals("*")){
					doOperator(str);
					
			}else if (isNumber(str)){
				doFraction(str + "/1");
			}else if(str.indexOf("/") >= 1 ){	
				doFraction(str);				

			}else if(str.toLowerCase().charAt(0) == 'a' ||
					 str.toLowerCase().charAt(0) == 'n' ||
					 str.toLowerCase().charAt(0) == 'c' ){
					doUnaryOperation(str);
			}else if(str.toLowerCase().charAt(0) == 'q'){
				this.quit = true;
			}else{
				this.doError(str);
			
		}	
	}
	

	//do methods
	//Private methods, to be called by the Parse method. These methods 
	//will perform actions based upon the String tokens fed into them, 
	//updating the FractionCalculator as appropriate.
	
	private void doFraction(String str){
		
		boolean parsable = true;
		Fraction entry;
		
		if (!isNumber(str.substring(0, str.indexOf("/"))) ||
			!isNumber(str.substring(str.indexOf("/")+1, str.length()))){
			parsable = false;
		}
		if (parsable){	
				entry = Fraction.parseFraction(str);
			if (entry.toString().equals("0/0")){
				this.reset();
			} else if (this.getOperator() != null){
				this.setOperand(entry);
				this.calculate();	
			} else {
				this.setTotal(entry);
			}
		}
	}
	
	
	private void doUnaryOperation(String operator){
		
		operator = operator.substring(0,1).toLowerCase();
		
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

	private void doOperator(String operator){
		if (this.getOperator() == null){
			this.setOperator(operator);
		}else{
			this.doError(operator);
		}
	}

	private void doError(String str){
		System.out.println("Error");
		this.reset();
	}
	
	
	
	//Internal update methods
	//To be called from the Do methods to make specific updates to the object
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

	//Used in Fraction and Numeral parsing to get around lack of exception handling
	private static boolean isNumber(String token){
		
		if (!Character.isDigit(token.charAt(0))){
			return false;
		}else{
			if (token.length() == 1){
				return true;
			}else{
				return isNumber(token.substring(1, token.length()));
			}
		}
	}
	
}
	




