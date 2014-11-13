
public class FractionCalculatorTest {

	public static void main(String[] args) {
		
		FractionCalculator fc = new FractionCalculator();

		//testParse(FractionCalculator calc, Fraction startTotal, String startOperator, String entry, Fraction result, String operator, Fraction operand, , String message)
		//test Parse Fractions
		testParse(fc, new Fraction(1,2), "+", "1/4",new Fraction(3,4),null, null, "Parse Fraction Test 1 Failed");
		testParse(fc, new Fraction(1,2), "-", "1/4",new Fraction(1,4),null, null, "Parse Fraction Test 2 Failed");
		testParse(fc, new Fraction(1,2), "*", "1/4",new Fraction(1,8),null, null, "Parse Fraction Test 3 Failed");
		testParse(fc, new Fraction(1,2), "/", "1/4",new Fraction(2,1),null, null, "Parse Fraction Test 4 Failed");
		testParse(fc, new Fraction(1,2), "+", "1",new Fraction(3,2),null, null, "Parse Fraction Test 5 Failed");
		testParse(fc, new Fraction(1,2), "*", "a/4",new Fraction(1,2),null, null, "Parse Fraction Test 6 Failed");
		testParse(fc, new Fraction(1,2), "*", "4/a",new Fraction(1,2),null, null, "Parse Fraction Test 7 Failed");		
		testParse(fc, new Fraction(1,2), null, "3/4",new Fraction(3,4),null, null, "Parse Fraction Test 8 Failed");
		
		
		//test Parse Unary Operations
		testParse(fc, new Fraction(1,2), "", "abs",new Fraction(1,2),null, null, "Parse Unary Op Test 1 Failed");
		testParse(fc, new Fraction(1,-2), "", "a",new Fraction(1,2),null, null, "Parse Unary Op Test 2 Failed");
		testParse(fc, new Fraction(1,2), "", "NEG",new Fraction(-1,2),null, null, "Parse Unary Op Test 3 Failed");
		testParse(fc, new Fraction(1,2), "", "clear",new Fraction(0,1),null, null, "Parse Unary Op Test 4 Failed");
	
		testParse(fc, new Fraction(1,2), "", "+",new Fraction(1,2),null, null, "Parse Operator Test 1 Failed");
		testParse(fc, new Fraction(1,2), "", "-",new Fraction(1,2),null, null, "Parse Operator Test 2 Failed");
		testParse(fc, new Fraction(1,2), "", "*",new Fraction(-1,2),null, null, "Parse Operator Test 3 Failed");
		testParse(fc, new Fraction(1,2), "", "/",new Fraction(0,1),null, null, "Parse Operator Test 4 Failed");		
		
		
		
		System.out.println(fc);
		System.out.println("Tests complete");
		

	}

	
//Removed due to change of methods to private

	//Removed due to change to private
	/*
	//test calculate
	//Test add
	testCalc(fc, new Fraction(0,1), "+", new Fraction(1,2), new Fraction(1,2), "Addition test 1 failed");
	testCalc(fc, new Fraction(1,2), "+", new Fraction(1,4), new Fraction(3,4), "Addition test 2 failed");
	testCalc(fc, new Fraction(1,1), "+", new Fraction(1,-2), new Fraction(1,2), "Addition test 3 failed");
	testCalc(fc, new Fraction(1,2), "+", new Fraction(1,2), new Fraction(1,1), "Addition test 4 failed");

	//test subtract
	testCalc(fc, new Fraction(0,1), "-", new Fraction(1,2), new Fraction(1,-2), "Subtract test 1 failed");
	testCalc(fc, new Fraction(1,2), "-", new Fraction(1,4), new Fraction(1,4), "Subtract test 2 failed");
	testCalc(fc, new Fraction(0,1), "-", new Fraction(1,-2), new Fraction(1,2), "Subtract test 3 failed");
	testCalc(fc, new Fraction(1,2), "-", new Fraction(1,2), new Fraction(0,1), "Subtract test 4 failed");
	
	//test divide
	testCalc(fc, new Fraction(0,1), "/", new Fraction(1,2), new Fraction(0,1), "Divide test 1 failed");
	testCalc(fc, new Fraction(1,2), "/", new Fraction(1,4), new Fraction(2,1), "Divide test 2 failed");
	testCalc(fc, new Fraction(1,1), "/", new Fraction(1,2), new Fraction(2,1), "Divide test 3 failed");
	testCalc(fc, new Fraction(1,2), "/", new Fraction(2,1), new Fraction(1,4), "Divide test 4 failed");
	
	//test multiply
	testCalc(fc, new Fraction(0,1), "*", new Fraction(1,2), new Fraction(0,1), "Negate test 1 failed");
	testCalc(fc, new Fraction(1,2), "*", new Fraction(1,4), new Fraction(1,8), "Negate test 2 failed");
	testCalc(fc, new Fraction(1,2), "*", new Fraction(0,1), new Fraction(0,1), "Negate test 3 failed");
	testCalc(fc, new Fraction(1,2), "*", new Fraction(1,2), new Fraction(1,4), "Negate test 4 failed");
	
	//test Absolute - f2 is redundant
	testCalc(fc, new Fraction(0,1), "a", new Fraction(0,1), new Fraction(0,1), "Absolute test 1 failed");
	testCalc(fc, new Fraction(1,-2), "a", new Fraction(0,1), new Fraction(1,2), "Absolute test 2 failed");
	testCalc(fc, new Fraction(1,2), "a", new Fraction(0,1), new Fraction(1,2), "Absolute test 3 failed");
	
	
	//test Negate - f2 is redundant
	testCalc(fc, new Fraction(1,-2), "n", new Fraction(0,1), new Fraction(1,2), "Negate test 1 failed");
	testCalc(fc, new Fraction(1,2), "n", new Fraction(0,1), new Fraction(1,-2), "Negate test 2 failed");
	testCalc(fc, new Fraction(0,1), "n", new Fraction(0,1), new Fraction(0,1), "Negate test 3 failed");		
	
	//test Clear - f2 is redundant
	testCalc(fc, new Fraction(1,-2), "c", new Fraction(0,1), new Fraction(0,1), "Clear test 1 failed");

	
	
	//test doThings
	
	testDoFraction(fc, new Fraction(1,2), "+", "1/2", new Fraction(1,1), "doFraction test 1 failed");
	testDoFraction(fc, new Fraction(1,2), "-", "1/2", new Fraction(0,1), "doFraction test 2 failed");
	testDoFraction(fc, new Fraction(1,2), "*", "1/4", new Fraction(1,8), "doFraction test 3 failed");
	testDoFraction(fc, new Fraction(1,2), "", "1/4", new Fraction(1,4), "doFraction test 4 failed");		
	//testDoFraction(fc, new Fraction(1,2), "", "asds/4", new Fraction(1,4), "doFraction test 4 failed");
*/		
	
	
	
/*	//Test scripts
	static void testDoFraction(FractionCalculator calc, Fraction startValue, String operator,String entry, Fraction result, String message){
    	
		calc.setTotal(startValue);
		
		if (operator.equals("")){
    		calc.setOperator(null);
    	}else{
    		calc.setOperator(operator);
    	}    	
    		calc.doFraction(entry);
    
    	if (! calc.getTotal().equals(result)){
    		System.out.println(message);
    		System.out.println(calc.getTotal() + " != " + result);
    		System.out.println();
    	}
    }*/

//Removed as methods are now private	
	
/*    static void testCalc(FractionCalculator calc, Fraction startValue, String operator, Fraction operand, Fraction result, String message){
    	    	//f2 is redundant for a, n and c
    	calc.setTotal(startValue);
    	
    	if (operator.equals("a") ||
    		operator.equals("c") ||
    		operator.equals("n")){
    		calc.doOperation(operator);
 
    	} else{
    		calc.setOperator(operator);
    		calc.setOperand(operand);
    		calc.calculate();
    	}
    	
    	if (! calc.getTotal().equals(result)){
    		System.out.println(message);
    		System.out.println(calc.getTotal() + " != " + result);
    		System.out.println();
    	}
    }
    */
    

	

	

 
     static void testParse(FractionCalculator calc, Fraction startTotal, String startOperator, String entry, Fraction result, String operator, Fraction operand, String message){
    	
    	 calc.setTotal(startTotal);
    	 calc.setOperator(startOperator);
    	 
    	calc.parseToken(entry);
  
   		if (! (calc.getTotal().equals(result)) &&
   			   calc.getOperator().equals(operator) &&
   			   calc.getOperand().equals(operator)){
   			System.out.println(message);
   			System.out.println("Expected: [Total = "+result+ "] , [Operator = "+ operator + "], [Operand = "+operand + "]");
   			System.out.println("Actual: " + calc);
   			System.out.println();
   		}
   		
   		
   	}
    
 
    
}