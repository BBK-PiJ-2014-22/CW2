/**
 * Created by keith for the second coursework assignment. Modified by Jamie.
 * 
 * Allows mathematical based upon fractions, by storing fractions with Numerator/Denominator. 
 * 
 * 
 * Fractions are immutable and cannot be changed. Methods should be used to return a new fraction instead
 * Public Methods (beyond overrides of standard public methods), which perform normal mathematical
 * functions and return a new fraction:
 * 		multiply(Fraction)
 * 		add(Fraction)
 * 		subtract(Fraction)
 * 		divide(Fraction)
 * 		absValue(Fraction)
 * 		negate(Fraction)
 * 		
 * And the public static method
 * 		parseFraction(String) - Converts String of format "1/2" and returns a Fraction
 * 
 */


//Overrides
public class Fraction {
	private int numerator;
	private int denominator;

	public Fraction(int num, int denom) {
		if (denom == 0) {
			System.out.println("Invalid fraction with denominator 0");
			// this should use exceptions
			return;
		}
		
		int gcd = myGcd(num, denom);
		setNumerator(num / gcd);
		setDenominator(denom / gcd);
	}

	@Override
	public String toString() {

		if (getDenominator() == 1) {
			return Integer.toString(getNumerator());
		} else {
			return Integer.toString(getNumerator()) + '/' + Integer.toString(getDenominator());
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Fraction fraction = (Fraction) o;

		if (getDenominator() != fraction.getDenominator())
			return false;
		if (getNumerator() != fraction.getNumerator())
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = numerator;
		result = 31 * result + denominator;
		return result;
	}

	
	
	//Get/Sets
	private int getNumerator() {
		return numerator;
	}

	private void setNumerator(int num) {
		numerator = num;
	}

	private int getDenominator() {
		return denominator;
	}

	private void setDenominator(int num) {
		denominator = num;
	}

	//Public methods
	
	public Fraction multiply(Fraction other) {

		int num = this.getNumerator() * other.getNumerator();
		int denom = this.getDenominator() * other.getDenominator();
		return new Fraction(num, denom);
	}

	public Fraction add(Fraction other) {

		int denom = this.getDenominator() * other.getDenominator();
		int num = (this.getNumerator() * other.getDenominator())
				+ (other.getNumerator() * this.getDenominator());
		return new Fraction(num, denom);
	}

	public Fraction subtract(Fraction other) {
		int denom = this.getDenominator() * other.getDenominator();
		int num = (this.getNumerator() * other.getDenominator())
				- (other.getNumerator() * this.getDenominator());
		return new Fraction(num, denom);
	}

	public Fraction divide(Fraction other) {
		Fraction reciprocal = new Fraction(other.getDenominator(), other.getNumerator());
		return this.multiply(reciprocal);
	}

	public Fraction absValue() {
		return new Fraction(this.getNumerator(), Math.abs(this.getDenominator()));
	}
	
	public Fraction negate() {
		return new Fraction(this.getNumerator(), this.getDenominator()*-1);
	}

	public static Fraction parseFraction(String str){	
			int position = str.indexOf("/");
			int numerator = Integer.parseInt(str.substring(0, position));
			int denominator = Integer.parseInt(str.substring(position+1, str.length()));
			return new Fraction(numerator, denominator);
	}
	
	
	//private methods
	private int myGcd(int a, int b) {
		while (b != 0) {
			int t = b;
			b = a % b;
			a = t;
		}
		return a;
	}
	
	
}
