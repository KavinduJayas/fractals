import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Mandelbrot extends Set {
    private int iterations = DEFAULT_ITER;
    private Panel panel;
    // a < real axis < b  AND c < imaginary axis <d
    private float a;
    private float b;
    private float c;
    private float d;

    public void Mandelbrot() {
    }

    @Override
    public void handleArguments(String args[]) {
        if (args.length == 1) {//only the set name is given
            panel = new Panel(image);
            this.generateFractal();
        } else if (args.length == 5) {//if, only the region of interest is given
            try {//trying to set region of interest
                a = Float.parseFloat(args[1]);
                b = Float.parseFloat(args[2]);
                c = Float.parseFloat(args[3]);
                d = Float.parseFloat(args[4]);
            } catch (NumberFormatException e) {//if the inputs are not numeric
                System.out.println("Mandelbrot arguments must be numeric!");
                return;
            }
            panel = new Panel(image, a, b, c, d);
            this.generateFractal();
        } else if (args.length == 6) {//if all parameters are given
            try {//trying to set region of interest
                a = Float.parseFloat(args[1]);
                b = Float.parseFloat(args[2]);
                c = Float.parseFloat(args[3]);
                d = Float.parseFloat(args[4]);
                iterations = Integer.parseInt(args[5]);
            } catch (NumberFormatException e) {//if the inputs are not numeric
                System.out.println("Mandelbrot arguments must be numeric!");
                return;
            }
            panel = new Panel(image, a, b, c, d);
            this.generateFractal();
        } else {//invalid number of arguments
            System.out.println("Invalid number of arguments!\nUsage :Fractal Mandelbrot [a b c d] [n]");
        }
    }

    @Override
    public void generateFractal() {

        super.setPanel(panel);//setting the panel of Set class

        for (int i = 0; i < DEFAULT_WIDTH; i++) {//iteration over each pixel the image
            for (int j = 0; j < DEFAULT_HEIGHT; j++) {

                //getting the relevent real and imaginaray coordinates of the pixel 
                //based on the region of interest
                double x = panel.getX(i);
                double y = panel.getY(j);
                //asking a color from the iterator (z note = 0  and C value is the complex coordinate)
                int color = super.iterator(new ComplexNumber(0, 0), new ComplexNumber(x, y), iterations);

                image.setRGB(i, j, color);
            }
        }
        super.display();//display content
    }


}
