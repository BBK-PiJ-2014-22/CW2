/**
 * Created by keith for the second coursework assignment.
 */
public class FractionTest {
    public static void main(String[] args) {

        // test divide by zero - should print an error and exit
        new Fraction(1, 0);
        // test multiply
	Fraction f = new Fraction(3,10);
	Fraction g = new Fraction(1,2);
	Fraction h = new Fraction(3,5);
	if (!f.equals(g.multiply(h))) System.out.println("Multiply failed");


	// test equals
	test(new Fraction(1, 2),new Fraction(1, 2),"error test equals 1");
	test(new Fraction(1, 2),new Fraction(3, 6),"error test equals 2");
	test(new Fraction(-1, 2),new Fraction(1, -2),"error test equals 3");
	test(new Fraction(-1, -2),new Fraction(1, 2),"error test equals 4");
	test(new Fraction(4, 8),new Fraction(1, 2),"error test 5 equals 5");

	// test add
	test(new Fraction(1, 2).subtract(new Fraction(1,4)),new Fraction(1, 4),"error test subtract 1");
	test(new Fraction(1, 2).subtract(new Fraction(-1,4)),new Fraction(3, 4),"error test subtract 2");
	test(new Fraction(1, 2).subtract(new Fraction(1,-4)),new Fraction(3, 4),"error test subtract 3");
	test(new Fraction(1, 2).subtract(new Fraction(-1,-4)),new Fraction(1, 4),"error test subtract 4");
	test(new Fraction(1, 4).subtract(new Fraction(1,2)),new Fraction(-1, 4),"error test subtract 5");

	System.out.println(new Fraction(1, 4).subtract(new Fraction(1,2)));
	
	
	
    }

    
    static void test(Fraction f1, Fraction f2, String msg){
    	if (! f1.equals(f2))
		System.out.println(msg);
    }
}
