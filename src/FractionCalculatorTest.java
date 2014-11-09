
public class FractionCalculatorTest {

	public static void main(String[] args) {
		
		FractionCalculator fc = new FractionCalculator();
				
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
		
		//test Negate
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
		

	    //removed as parse is now fully tested and private
/*		//test Parse

		testParse(fc, "+", "Calculation", "Parse Calc test 1 failed");
		testParse(fc, "-", "Calculation", "Parse Calc test 2 failed");
		testParse(fc, "*", "Calculation", "Parse Calc test 3 failed");
		testParse(fc, "/", "Calculation", "Parse Calc test 4 failed");
		
		testParse(fc, "a", 		 "Operation", "Parse Operation test 1 failed");
		testParse(fc, "abs",	 "Operation", "Parse Operation test 2 failed");
		testParse(fc, "Absolute","Operation", "Parse Operation test 3 failed");
		testParse(fc, "q", 		 "Operation", "Parse Operation test 4 failed");
		testParse(fc, "Q", 		 "Operation", "Parse Operation test 5 failed");
		testParse(fc, "quit",	 "Operation", "Parse Operation test 6 failed");
		testParse(fc, "N",		 "Operation", "Parse Operation test 7 failed");
		testParse(fc, "n", 		 "Operation", "Parse Operation test 8 failed");
		testParse(fc, "neg", 	 "Operation", "Parse Operation test 9 failed");
		testParse(fc, "c",		 "Operation", "Parse Operation test 10 failed");
		testParse(fc, "C", 		 "Operation", "Parse Operation test 11 failed");
		testParse(fc, "clr", 	 "Operation", "Parse Operation test 12 failed");
	
		testParse(fc, "1", 		"Integer", "Parse Integer test 1 failed");
		testParse(fc, "0",		"Integer", "Parse Integer test 2 failed");
		testParse(fc, "-1",		"Integer", "Parse Integer test 3 failed");
		
		testParse(fc, "1/1", 		"Fraction", "Parse Fraction test 1 failed");
		testParse(fc, "0/2",		"Fraction", "Parse Fraction test 2 failed");
		testParse(fc, "1/0",		"Fraction", "Parse Fraction test 3 failed")*/;
		

		
		
		System.out.println(fc);
		System.out.println("Tests complete");
	}

	
	
	

	
	
	
    static void testCalc(FractionCalculator calc, Fraction startValue, String symbol, Fraction operand, Fraction result, String message){
    	    	//f2 is redundant for a and n 
    	calc.setTotal(startValue);
    	
    	if (symbol.equals("a")){
    		calc.absolute();
    	} else if (symbol.equals("n")){
    		calc.negate();
    	} else{
    		calc.calculate(symbol, operand);
    	}
    	
    	if (! calc.getTotal().equals(result)){
    		System.out.println(message);
    		System.out.println(calc.getTotal() + " != " + result);
    		System.out.println();
    	}
    }
    
 
    //removed as parse is now fully tested and private
/*    static void testParse(FractionCalculator calc, String entry, String result, String message){
    	
    	String parsed = calc.parse(entry);
    	
   		if (! parsed.equals(result)){
   			System.out.println(message);
   			System.out.println(parsed + " != "+result);
   			System.out.println();
   		}			
   	}*/
    
}