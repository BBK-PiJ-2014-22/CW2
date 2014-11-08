
public class FractionCalculatorTest {

	public static void main(String[] args) {
		
		FractionCalculator fc = new FractionCalculator();
		
		System.out.println(fc);
		
		fc.calculate("+", new Fraction(1,2));
		System.out.println(fc);
		
		fc.calculate("+", new Fraction(1,2));
		System.out.println(fc);
		
		fc.calculate("+", new Fraction(1,2));
		System.out.println(fc);
		
		fc.calculate("+", new Fraction(1,2));
		System.out.println(fc);

		

		
		System.out.println("Tests complete");
	}

	
	
	
	
    static void test(Fraction f1, Fraction f2, String msg){
    	if (! f1.equals(f2))
		System.out.println(msg);
    }
}
