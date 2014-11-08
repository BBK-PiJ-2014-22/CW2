
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
		
		System.out.println(fc);
		System.out.println("Tests complete");
	}

	
	
	
	static void testTokens(String str, Token tok){

	}
	
	
	
    static void testCalc(FractionCalculator calc, Fraction f1, String symbol, Fraction f2, Fraction result, String msg){
    	    	//f2 is redundant for a and n 
    	calc.setTotal(f1);
    	
    	if (symbol.equals("a")){
    		calc.absolute();
    	} else if (symbol.equals("n")){
    		calc.negate();
    	} else{
    		calc.calculate(symbol, f2);
    	}
    	
    	if (! calc.getTotal().equals(result)){
    		System.out.println(msg);
    		System.out.println(calc.getTotal() + " != " + result);
    		System.out.println();
    	}
    }
}