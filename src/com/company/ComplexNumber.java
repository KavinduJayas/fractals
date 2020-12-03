package com.company;

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
        return new ComplexNumber(Math.pow(real,real) - Math.pow(imaginary,imaginary) , 2 * real * imaginary);
    }

    public static ComplexNumber sum(ComplexNumber c1, ComplexNumber c2) {
        return new ComplexNumber(c1.real + c2.real, c1.imaginary + c2.imaginary);
    }

    public static double absolute(ComplexNumber c){
        return Math.sqrt(c.real*c.real + c.imaginary*c.imaginary);
    }

//    public double getReal() {
//        return real;
//    }
//
//    public double getImaginary() {
//        return imaginary;
//    }
}
