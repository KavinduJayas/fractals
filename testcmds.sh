#! /bin/sh
javac *.java
java Fractal Mandelbrot
java Fractal Mandelbrot 1.0 2.0 1.0 0.5 500
java Fractal Mandelbrot 10 10 10 10 500
java Fractal Mandelbrot 1.5 0.5 -0.1 1 1000
java Fractal Julia
java Fractal Mandelbrot 0.5 0.5 -1 0 1000
echo "\nInvalid Commands:\n"
java Fractal Mandelbrot  sdfdf
java Fractal Julia 1.5 0.156 1000
java Fractal Mandelbrot 1.5 0.5 -0.1 
java Fractal Julia 1.5 
java Fractal Mandelbrot 101
java Fractal Julia 101
java Fractal Julia safgdag sf
java Fractal Julia dsfg
java Fractal Mandelbrot 0.5 0.5 -1 0 1000 asdfa
java Fractal Mandelbrot 0.5asdf 0.5 -1 0 1000
java Fractal Mandelbrot 0.5 0..5 -1 0 10.00
rm *.class