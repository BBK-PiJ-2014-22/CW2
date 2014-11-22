
public class FractionCalculatorTest {

	public static void main(String[] args) {
		
		FractionCalculator fc = new FractionCalculator();
		
		testEvaluateFull(fc, new Fraction(1,2), "1/2 + 1/2 + 1/2", new Fraction(3,2), null, "Evaluate Full Test 1 Failed");
		testEvaluateFull(fc, fc.getTotal(), "- 1/2 - 1/2 - 1/2", new Fraction(0,1), null, "Evaluate Full Test 3 Failed");
		testEvaluateFull(fc, fc.getTotal(), "1/2 + 1/2 * 1/2 +", new Fraction(1,2), "+", "Evaluate Full Test 3 Failed");
		testEvaluateFull(fc, fc.getTotal(), "+ 1/2 + 1/2", new Fraction(0,1), null, "Evaluate Full Test 4 Failed");
		testEvaluateFull(fc, fc.getTotal(), "-1/2 + abs 1/2 +", new Fraction(0,1), "+", "Evaluate Full Test 5 Failed");
		
		
		System.out.println(fc);
		System.out.println("Tests complete");
	}
	
	
	static void testEvaluateFull(FractionCalculator calc, Fraction start, String entry, Fraction total, String operator, String message){
		
		Fraction result = calc.evaluate(start, entry);
		boolean failed = false;
		
		if (!result.equals(calc.getTotal())){
			System.out.println("Calc total doesn't match result");
			failed = true;
		}
		if (!result.equals(total)){
			System.out.println(result + "!=" + total);
			failed = true;
		}
		if (calc.getOperator() != null && operator != null){
			if (!calc.getOperator().equals(operator)){
				System.out.println(operator != calc.getOperator());
				failed = true;
			}
		}else if (calc.getOperator() != operator){
			System.out.println(calc.getOperator() + "!=" + operator);
		}
		
			
		if (failed){
			System.out.println(message);
			System.out.println();
		}
		
	}
	
	
	
}	


		//Removed due to change of methods to private
		
		
		
		//testParse(FractionCalculator calc, Fraction startTotal, String startOperator, String entry, Fraction result, String operator, Fraction operand, , String message)
		//test Parse Fractions
	
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
	
/*	static void testEvaluate(FractionCalculator calc, Fraction startTotal, String startOperator, String entry, Fraction result, String operator, Fraction operand, String message){
    	
	   	 calc.setTotal(startTotal);
	   	 calc.setOperator(startOperator);
	   	 
	   	 boolean error = false;
	   	 
	   	 calc.evaluate(new Fraction(0,1), entry);

	  		if (! (calc.getTotal().equals(result))){
	  			error = true;
	  		} else if(operand == null && operand != calc.getOperand() ||
	  				  operator == null && operator != calc.getOperator()){
	  			error = true;
	  		} else if (operand != null && !operand.equals(calc.getOperand()) ||
	  				   operator != null && !operator.equals(calc.getOperator())){
	  			error = true;
	  		}
	  			
	  		if (error){
				System.out.println(message);
				System.out.println("Expected: FractionCalculator [total="+result+ "] ,[operand="+operand + "],"+ "[operator="+ operator + "] ");
				System.out.println("Actual:   " + calc);
				System.out.println();
	  		}
	  	}
	}		*/
	
/*	testEvaluate(fc, new Fraction(0,1), null, "1/2 * 1/2", new Fraction(1,4), null, null, "Evaluate test 8 failed");
	testEvaluate(fc, new Fraction(0,1), null, "1/2 * 1/2 + 1/4", new Fraction(1,2), null, null, "Evaluate test 9 failed");
	testEvaluate(fc, new Fraction(0,1), null, "1/2 * 1/2 n", new Fraction(1,-4), null, null, "Evaluate test 10 failed");
	testEvaluate(fc, new Fraction(0,1), null, "1/2 * 1/2 c", new Fraction(0,1), null, null, "Evaluate test 11 failed");
	testEvaluate(fc, new Fraction(0,1), null, "1/2 * 1/2 * 1/2 * 1/2", new Fraction(1,16), null, null, "Evaluate test 12 failed");
	
	//FractionCalculator calc, Fraction startTotal, String startOperator, String entry, Fraction result, String operator, Fraction operand,  String message
	testEvaluate(fc, new Fraction(0,1), null, "1/2 n", new Fraction(1,-2), null, null, "Evaluate test 1 failed");
	testEvaluate(fc, new Fraction(0,1), null, "1/-2 a", new Fraction(1,2), null, null, "Evaluate test 2 failed");
	testEvaluate(fc, new Fraction(0,1), null, "1/2 c", new Fraction(0,1), null, null, "Evaluate test 3 failed");
	
	testEvaluate(fc, new Fraction(0,1), null, "1/2 1/4", new Fraction(1,4), null, null, "Evaluate test 4 failed");
	testEvaluate(fc, new Fraction(0,1), null, "1/2 c 1/2", new Fraction(1,2), null, null, "Evaluate test 5 failed");
	testEvaluate(fc, new Fraction(0,1), null, "1/2 1/2 c", new Fraction(0,1), null, null, "Evaluate test 6 failed");
	
	//Tests solo operators
	testEvaluate(fc, new Fraction(1,2), "+", "1/4",new Fraction(3,4),null, null, "Parse Fraction Test 1 Failed");
	testEvaluate(fc, new Fraction(1,2), "-", "1/4",new Fraction(1,4),null, null, "Parse Fraction Test 2 Failed");
	testEvaluate(fc, new Fraction(1,2), "*", "1/4",new Fraction(1,8),null, null, "Parse Fraction Test 3 Failed");
	testEvaluate(fc, new Fraction(1,2), "/", "1/4",new Fraction(2,1),null, null, "Parse Fraction Test 4 Failed");
	testEvaluate(fc, new Fraction(1,2), "+", "1",new Fraction(3,2),null, null, "Parse Fraction Test 5 Failed");
	testEvaluate(fc, new Fraction(1,2), "*", "a/4",new Fraction(0,1),null, null, "Parse Fraction Test 6 Failed");
	testEvaluate(fc, new Fraction(1,2), "*", "4/a",new Fraction(0,1),null, null, "Parse Fraction Test 7 Failed");		
	testEvaluate(fc, new Fraction(1,2), null, "3/4",new Fraction(3,4),null, null, "Parse Fraction Test 8 Failed");
		
	//test Parse Unary Operations
	testEvaluate(fc, new Fraction(1,2), null, "abs",new Fraction(1,2),null, null, "Parse Unary Op Test 1 Failed");
	testEvaluate(fc, new Fraction(1,-2), null, "a",new Fraction(1,2),null, null, "Parse Unary Op Test 2 Failed");
	testEvaluate(fc, new Fraction(1,2), null, "NEG",new Fraction(-1,2),null, null, "Parse Unary Op Test 3 Failed");
	testEvaluate(fc, new Fraction(1,2), null, "clear",new Fraction(0,1),null, null, "Parse Unary Op Test 4 Failed");

	//test Parse Operators
	testEvaluate(fc, new Fraction(1,2), null, "+",new Fraction(1,2),"+", null, "Parse Operator Test 1 Failed");
	testEvaluate(fc, new Fraction(1,2), null, "-",new Fraction(1,2),"-", null, "Parse Operator Test 2 Failed");
	testEvaluate(fc, new Fraction(1,2), null, "*",new Fraction(1,2),"*", null, "Parse Operator Test 3 Failed");
	testEvaluate(fc, new Fraction(1,2), null, "/",new Fraction(1,2),"/", null, "Parse Operator Test 4 Failed");		
	testEvaluate(fc, new Fraction(1,2), "/", "/",new Fraction(0,1),null, null, "Parse Operator Test 5 Failed");		
	
	//test morons
	testEvaluate(fc, new Fraction(1,2), "/", "dasdsad",new Fraction(0,1),null, null, "Parse moron Test 1 Failed");		
	*/

 
