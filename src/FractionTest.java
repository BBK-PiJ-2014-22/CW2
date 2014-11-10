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
	test(new Fraction(4, 8),new Fraction(1, 2),"error test equals 5");

	// test add
	test(new Fraction(1, 2).add(new Fraction(1,4)),new Fraction(3, 4),"error test add 1");
	test(new Fraction(0, 1).add(new Fraction(1,4)),new Fraction(1, 4),"error test add 2");
	test(new Fraction(1, 2).add(new Fraction(1,-4)),new Fraction(1, 4),"error test add 3");
	test(new Fraction(1, 2).add(new Fraction(-1,-4)),new Fraction(3, 4),"error test add 4");
	test(new Fraction(1, 4).add(new Fraction(1,2)),new Fraction(3, 4),"error test add 5");
	
	// test subtract
	test(new Fraction(1, 2).subtract(new Fraction(1,4)),new Fraction(1, 4),"error test subtract 1");
	test(new Fraction(1, 2).subtract(new Fraction(-1,4)),new Fraction(3, 4),"error test subtract 2");
	test(new Fraction(1, 2).subtract(new Fraction(1,-4)),new Fraction(3, 4),"error test subtract 3");
	test(new Fraction(1, 2).subtract(new Fraction(-1,-4)),new Fraction(1, 4),"error test subtract 4");
	test(new Fraction(1, 4).subtract(new Fraction(1,2)),new Fraction(-1, 4),"error test subtract 5");
	
	//test divide
	test(new Fraction(1, 2).divide(new Fraction(1,4)),new Fraction(2, 1),"error test divide 1");
	test(new Fraction(1, 2).divide(new Fraction(-1,4)),new Fraction(-2, 1),"error test divide 2");
	test(new Fraction(1, 2).divide(new Fraction(1,-4)),new Fraction(-2, 1),"error test divide 3");
	test(new Fraction(1, 2).divide(new Fraction(-1,-4)),new Fraction(2, 1),"error test divide 4");
	test(new Fraction(-1, -2).divide(new Fraction(-1,-4)),new Fraction(2, 1),"error test divide 5");

	//test absValue

	test(new Fraction(1, 2).absValue(),new Fraction(1, 2),"error test abs 1");
	test(new Fraction(-1, 2).absValue(),new Fraction(1, 2),"error test abs 2");
	test(new Fraction(1, -2).absValue(),new Fraction(1, 2),"error test abs 3");
	test(new Fraction(-1, -2).absValue(),new Fraction(1, 2),"error test abs 4");
	
	
	//test negate
	test(new Fraction(1, 2).negate(),new Fraction(1, -2),"error test negate 1");
	test(new Fraction(-1, 2).negate(),new Fraction(1, 2),"error test negate 2");
	test(new Fraction(1, -2).negate(),new Fraction(1, 2),"error test negate 3");
	test(new Fraction(-1, -2).negate(),new Fraction(1, -2),"error test negate 4");
	
	
/*	//test Print - commented out for ease of testing
	System.out.println();
	System.out.println("Print Tests:");
	System.out.println(new Fraction(1,2));
	System.out.println(new Fraction(2,1));
	System.out.println(new Fraction(-1,2));
	System.out.println(new Fraction(1,-2));
	System.out.println(new Fraction(-1,-2));
	System.out.println(new Fraction(10,2));
*/	
	test(Fraction.parseFraction("1/2"), new Fraction(1,2),"error test parse 1");
	test(Fraction.parseFraction("-1/2"), new Fraction(1,-2),"error test parse 3");
	test(Fraction.parseFraction("0/2"), new Fraction(0,1),"error test parse 4");

	
    }

    
    static void test(Fraction f1, Fraction f2, String msg){
    	if (! f1.equals(f2))
		System.out.println(msg);
    }
}
