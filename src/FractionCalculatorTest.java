
public class FractionCalculatorTest {

	public static void main(String[] args) {
		
		//test calculation
		test(FractionCalculator.calculate(new Fraction(1,2),"+",new Fraction(1,4)),new Fraction(3,4), "error test calc +");
		test(FractionCalculator.calculate(new Fraction(1,2),"*",new Fraction(1,4)),new Fraction(1,8), "error test calc *");
		test(FractionCalculator.calculate(new Fraction(1,2),"/",new Fraction(1,4)),new Fraction(2,1), "error test calc /");
		test(FractionCalculator.calculate(new Fraction(1,2),"-",new Fraction(1,4)),new Fraction(1,4), "error test calc -");
		test(FractionCalculator.calculate(new Fraction(1,2),"t",new Fraction(-1,4)),new Fraction(3,4), "error test calc t");				test(FractionCalculator.calculate(new Fraction(1,8),"-",new Fraction(2,1)),new Fraction(-15,8), "error test calc sub 3");
		
		
	System.out.println("Tests complete");
	}

	
    static void test(Fraction f1, Fraction f2, String msg){
    	if (! f1.equals(f2))
		System.out.println(msg);
    }
}
