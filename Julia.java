import java.awt.*;

public class Julia extends Set {
    public static final ComplexNumber DEFAULT_C;

    static {
        DEFAULT_C = new ComplexNumber(-0.4, 0.6);//default c value (of the equation)
    }

    private int iterations = DEFAULT_ITER;
    private Panel panel;
    private ComplexNumber c = DEFAULT_C;
    //to store user given C values
    private double cReal;
    private double cImaginary;

    public void Julia() {

    }

    @Override
    public void handleArguments(String args[]) {
        if (args.length == 3) {
            try {//trying to set the parameter C values
                cReal = Double.parseDouble(args[1]);
                cImaginary = Double.parseDouble(args[2]);
            } catch (NumberFormatException e) {//if the inputs are not numeric
                System.out.println("Julia arguments must be numeric!");
                return;
            }
            c = new ComplexNumber(cReal, cImaginary);
            this.generateFractal();
        } else if (args.length == 1) {//only the set name is given
            this.generateFractal();
        } else {//invalid number of arguments
            System.out.println("Invalid number of arguments!\nUsage :Fractal Julia [a b]");
        }
    }

    @Override
    public void generateFractal() {

        panel = new Panel(image);

        super.setPanel(panel);//setting the panel of Set class

        for (int i = 0; i < DEFAULT_WIDTH; i++) {
            for (int j = 0; j < DEFAULT_HEIGHT; j++) {
                //getting the relevent real and imaginaray coordinates of the pixel 
                //based on the region of interest
                double x = panel.getX(i);
                double y = panel.getY(j);
                //asking a color from the iterator (z note is the complex coordinate)
                int color = super.iterator(new ComplexNumber(x, y), c, iterations);

                super.image.setRGB(i, j, color);
            }
        }
        super.display();//display content
    }


}
