package com.company;

import java.util.HashMap;

public class Fractal {
    public static final int ITERATIONS = 1000;

    public static void main(String[] args) {
        Mandelbrot mb;
        Julia j;

//        ComplexNumber c = new ComplexNumber(8,6);
//        ComplexNumber d = new ComplexNumber(8,6);
//        System.out.println(ComplexNumber.absolute(ComplexNumber.sum(c,d)));

        if (args.length > 0) {
            if (args[0].equals("Mandelbrot")){
                mb = new Mandelbrot();
                mb.handleArguments(args);
                mb.generateFractal();}
            else if (args[0].equals("Julia")) {
                j = new Julia();
                j.handleArguments(args);
                j.generateFractal();
            }
            else {
                System.out.println("Invalid arguments!\nUsage:java Fractal [Mandelbrot | Julia] [args]");
            }
        } else {
            System.out.println("No arguments given!\nUsage:java Fractal [Mandelbrot | Julia] [args]");
        }

    }
}
