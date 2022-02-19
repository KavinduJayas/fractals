# Fractals: A multithreaded application that paints fractal patterns

This command-line application generates and visualizes the most popular fractals Mandelbrot set and the Julia set. 

Mandelbrot set is defined as the set of complex numbers C such that: Z<sub>n+1</sub> = Z<sub>n</sub><sup>2</sup>+C, 
starting with Z<sub>0</sub> = 0 remains bounded when n reaches infinity.
(When performing the caculation, instead of infinity the programme takes in an argument for the number of iterations which defaults to 1000)
All Mandelbrot numbers are within a region of the complex plane; -1 < real part < 1 and -1 < complex part < 1. We call this the region of interest. 
These values can be passed to the programme (optional) separated with spaces in the above order. Last argument will be the number of interations.

A point on the display is first mapped onto a point within the region of interest. Once that is done that value is used as C and the above computation 
Z<sub>n+1</sub> = Z<sub>n</sub><sup>2</sup>+C is performed the specified number of iterations and then see if ABS(Zn) > 2 for any n < iterations. 
If so C is not a Mandelbrot number and therefor assign some colour to it based on value of n when ABS(Zn) > 2. Else assign black. 
This process is repeated for all points on the canvas.

The Julia set is similar to the Mandelbrot set in that it uses the same equation, but Z<sub>0</sub> is the point in the complex plane corresponding to the pixel 
and C is a constant. Real and imaginary parts of C can be passed (optional) as aguments to the programme separated with spaves, by default its value will be -0.4 + 0.6i.  

To install llocally:

  ```git clone https://github.com/KavinduJayas/fractals.git```
  
  ```cd fractals```
  
  ```javac Fractal.java```
  
  ```java Fractal [ Mandelbrot | Julia ] [args]```
  

Class diagram of the Java implementation:

![class diagram](https://github.com/KavinduJayas/fractals/blob/main/class%20diagram.png)
