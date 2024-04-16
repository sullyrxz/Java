import java.math.BigInteger;
import java.util.Scanner;

public class Rational extends Number implements Comparable<Rational> {
    // Data fields for numerator and denominator
    private BigInteger numerator = new BigInteger("0");
    private BigInteger denominator = new BigInteger("1");

    /** Construct a rational with default properties */
    public Rational(int numerator, int denominator) {
        this.numerator = new BigInteger(Integer.toString(numerator));
        this.denominator = new BigInteger(Integer.toString(denominator));
    }

    /** Construct a rational with specified numerator and denominator */
    public Rational(BigInteger numerator, BigInteger denominator) {
        BigInteger gcd = numerator.gcd(denominator);
        this.numerator = new BigInteger(
                String.valueOf((denominator.intValue() > 0 ? 1 : -1) * numerator.intValue() / gcd.intValue()));
        this.denominator = new BigInteger(String.valueOf(Math.abs(denominator.intValue()) / gcd.intValue()));
    }

    /** Find GCD of two numbers */
    private static BigInteger gcd(BigInteger n, BigInteger d) {

        return n.gcd(d);
    }

    /** Return numerator */
    public BigInteger getNumerator() {
        return numerator;
    }

    /** Return denominator */
    public BigInteger getDenominator() {
        return denominator;
    }

    /** Add a rational number to this rational */
    public Rational add(Rational secondRational) {

        BigInteger first = numerator.multiply(secondRational.getDenominator());
        BigInteger second = denominator.multiply(secondRational.getNumerator());

        BigInteger n = first.add(second);
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    /** Subtract a rational number from this rational */
    public Rational subtract(Rational secondRational) {

        BigInteger third = numerator.multiply(secondRational.getDenominator());
        BigInteger fourth = denominator.multiply(secondRational.getNumerator());

        BigInteger n = third.subtract(fourth);
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    /** Multiply a rational number by this rational */
    public Rational multiply(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getNumerator());
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    /** Divide a rational number by this rational */
    public Rational divide(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator());
        BigInteger d = denominator.multiply(secondRational.numerator);
        return new Rational(n, d);
    }

    @Override
    public String toString() {
        if (denominator == new BigInteger("1"))
            return numerator + "";
        else
            return numerator + "/" + denominator;
    }

    @Override // Override the equals method in the Object class
    public boolean equals(Object other) {
        if ((this.subtract((Rational) (other))).getNumerator().intValue() == 0)
            return true;
        else
            return false;
    }

    @Override // Implement the abstract intValue method in Number
    public int intValue() {

        BigInteger divided = numerator.divide(denominator);
        return divided.intValue();
    }

    @Override // Implement the abstract floatValue method in Number
    public float floatValue() {

        float num = numerator.floatValue();
        float denom = denominator.floatValue();
        return num / denom;
    }

    @Override // Implement the doubleValue method in Number
    public double doubleValue() {

        double num = numerator.doubleValue();
        double denom = denominator.doubleValue();
        return num / denom;
    }

    @Override // Implement the abstract longValue method in Number
    public long longValue() {
        return (long) doubleValue();
    }

    @Override // Implement the compareTo method in Comparable

    public int compareTo(Rational o) {
        if (this.subtract(o).getNumerator().intValue() > 0)
            return 1;
        else if (this.subtract(o).getNumerator().intValue() < 0)
            return -1;
        else
            return 0;
    }

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);

        System.out.println("Enter a fraction with the numerator and denominator split with a space");
        String[] input1 = myObj.nextLine().split(" ");
        System.out.println("Enter a fraction with the numerator and denominator split with a space");
        String[] input2 = myObj.nextLine().split(" ");

        Rational rational1 = new Rational(new BigInteger(input1[0]), new BigInteger(input1[1]));
        Rational rational2 = new Rational(new BigInteger(input2[0]), new BigInteger(input2[1]));

        String str = "";

        str = rational1.toString() + " + " + rational2.toString() + " = " + rational1.add(rational2).toString();
        System.out.println(str);

        str = rational1.toString() + " - " + rational2.toString() + " = " + rational1.subtract(rational2).toString();
        System.out.println(str);

        str = rational1.toString() + " * " + rational2.toString() + " = " + rational1.multiply(rational2).toString();
        System.out.println(str);

        str = rational1.toString() + " / " + rational2.toString() + " = " + rational1.divide(rational2).toString();
        System.out.println(str);

        str = rational2.toString() + " is " + rational2.doubleValue()3;
        System.out.println(str);

    }
}
