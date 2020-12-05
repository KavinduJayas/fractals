//class that handles complex numbers
public class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public static ComplexNumber square(ComplexNumber c) {
        double real = c.real;
        double imaginary = c.imaginary;
        return new ComplexNumber(Math.pow(real, 2) - Math.pow(imaginary, 2), 2 * real * imaginary);
    }

    //returnds the sum two complex numbers
    public static ComplexNumber sum(ComplexNumber c1, ComplexNumber c2) {
        return new ComplexNumber(c1.real + c2.real, c1.imaginary + c2.imaginary);
    }

    //returns the absolute value of a complex number
    public static double absolute(ComplexNumber c) {
        return Math.sqrt(Math.pow(c.real, 2) + Math.pow(c.imaginary, 2));
    }

}
