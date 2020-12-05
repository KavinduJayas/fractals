#! /bin/sh
java com.company.Fractal Mandelbrot  
sleep 4
java com.company.Fractal Mandelbrot 1.0 2.0 1.0 0.5 500
sleep 4
java com.company.Fractal Mandelbrot 10 10 10 10 500
sleep 4
java com.company.Fractal Mandelbrot 1.5 0.5 -0.1 1 1000
sleep 5
java com.company.Fractal Julia 1.5 0.156 1000
sleep 5
java com.company.Fractal Julia
sleep 5
echo -e "\nInvalid Commands:\n"
java com.company.Fractal Mandelbrot 0 0 -1 0 1000
sleep 5
java com.company.Fractal Mandelbrot 1.5 0.5 -0.1 
sleep 5
java com.company.Fractal Julia 1.5 
sleep 5
java com.company.Fractal Mandelbrot 101
sleep 5
java com.company.Fractal Julia 101
sleep 5
