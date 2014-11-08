
public class FractionCalculatorTest {

	public static void main(String[] args) {
		
		FractionCalculator fc = new FractionCalculator();
		
		System.out.println(fc);
		
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
		testCalc(fc, new Fraction(0,1), "*", new Fraction(1,2), new Fraction(0,1), "Multiply test 1 failed");
		testCalc(fc, new Fraction(1,2), "*", new Fraction(1,4), new Fraction(1,8), "Multiply test 2 failed");
		testCalc(fc, new Fraction(1,2), "*", new Fraction(0,1), new Fraction(0,1), "Multiply test 3 failed");
		testCalc(fc, new Fraction(1,2), "*", new Fraction(1,2), new Fraction(1,4), "Multiply test 4 failed");
		
		
		
		
		//test negate

		System.out.println(fc);
		System.out.println("Tests complete");
	}

	
	
	
	
    static void testCalc(FractionCalculator calc, Fraction f1, String symbol, Fraction f2, Fraction result, String msg){
    	
    	calc.setTotal(f1);
    	calc.calculate(symbol, f2);
    
    	if (! calc.getTotal().equals(result)){
    		System.out.println(msg);
    		System.out.println(calc.getTotal() + " != " + result);
    		System.out.println();
    	}
    }
}