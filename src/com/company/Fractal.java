package com.company;

import java.util.HashMap;

public class Fractal {
    public static final int ITERATIONS = 1000;
    public static HashMap<String, Set> sets =
            new HashMap<String, Set>();

    public static void main(String[] args) {
        sets.put("Mandelbrot",new Mandelbrot());
        sets.put("Julia",new Julia());
        Set obj = sets.get(args[0]);
        if(obj == null) {
            System.out.println("Usage:java Fractal [Mandelbrot | Julia] [args]");
            return;
        }

    }
}
