/**
 * Created by keith for the second coursework assignment.
 * Modified by Jamie for the second coursework assignment
 */

public class Fraction {
    private int numerator;
    private int denominator;

    
    public Fraction(int num, int denom) {
        boolean negative;
    	
    	if (denom == 0) {
            System.out.println("Invalid fraction with denominator 0"); 
	    // this should use exceptions
            return;
        }
        
        //this has been modified to handle negative numbers (so -1/10 = 1/-10)
        //Negative fractions will always have a negative numerator
 
        if (num < 0 || denom < 0){
        	negative = true;
        	num = Math.abs(num);
        	denom = Math.abs(denom);
        }else {
        	negative = false;
        }
        
        int gcd = myGcd(num, denom);
        setNumerator(num / gcd);
        setDenominator(denom / gcd);
        
        if (negative){
        	setNumerator(0-getNumerator());
        }
        
    }

    
    @Override
    public String toString() {
    	//requires addition to make sure that it return correctly for denominator 1
       String str;
    	
    	if (getDenominator() == 1){
    		str = Integer.toString(getNumerator());
    	}else{  	
    	
    	str = "" + Math.abs(getNumerator()) + '/' + getDenominator();
    	
    	}
    	
    	return str;
    			
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fraction fraction = (Fraction) o;

        if (getDenominator() != fraction.getDenominator()) return false;
        if (getNumerator() != fraction.getNumerator()) return false;
        

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
    	//Finds Greatest Common Denominator - does this work?
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    public Fraction add(Fraction other){
    	
    	int denom = this.getDenominator() * other.getDenominator();
    	int num = this.getNumerator() * other.getDenominator() +
    			  other.getNumerator() * this.getDenominator();
    	
    	return new Fraction(num, denom);
    }
    
    public Fraction subtract(Fraction other){
    	int denom = this.getDenominator() * other.getDenominator();
    	System.out.println(denom);
    	int num = (this.getNumerator() * other.getDenominator()) -
    			  (other.getNumerator() * this.getDenominator());
    	
    	System.out.println(num);
    	
    	return new Fraction(num, denom);    
    
    
    }
    
    public Fraction divide(Fraction other){
    	return other;//temp
    }
    
    public Fraction absValue(){
    	return this;//temp
    }
    
    


}


	

