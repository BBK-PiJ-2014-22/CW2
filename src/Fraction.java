/**
 * Created by keith for the second coursework assignment. Modified by Jamie.
 */

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

	//Added because the two different prints of negative fractions irritates me
	
	}

	@Override
	public String toString() {

		if (getDenominator() == 1) {
			return Integer.toString(getNumerator());
		} else {

			return Integer.toString(getNumerator()) + '/' + Integer.toString(getDenominator());

		}

	}

	public int getNumerator() {
		return numerator;
	}

	public void setNumerator(int num) {
		numerator = num;
	}

	public int getDenominator() {
		return denominator;
	}

	public void setDenominator(int num) {
		denominator = num;
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

	public Fraction multiply(Fraction other) {

		int num = this.getNumerator() * other.getNumerator();
		int denom = this.getDenominator() * other.getDenominator();
		return new Fraction(num, denom);
	}

	private int myGcd(int a, int b) {
		// Finds Greatest Common Denominator - does this work?
		while (b != 0) {
			int t = b;
			b = a % b;
			a = t;
		}
		return a;
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

}
