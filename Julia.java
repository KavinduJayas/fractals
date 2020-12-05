import java.util.ArrayList;

public class Julia extends Set implements Runnable {
    public static final ComplexNumber DEFAULT_C;

    static {
        DEFAULT_C = new ComplexNumber(-0.4, 0.6);//default c value (of the equation)
    }

    private static int iterations = DEFAULT_ITER;
    private static Panel panel;
    private static ComplexNumber c = DEFAULT_C;
    //to store user given C values
    private static double cReal;
    private static double cImaginary;
    private static int i;

    public Julia() {

    }

    public Julia(int i, Panel panel) {

        this.i = i;
        this.panel = panel;
    }

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

            panel = new Panel(image);

            super.setPanel(panel);//setting the panel of Set class
            generateJulia();
            super.display();//display content

        } else if (args.length == 1) {//only the set name is given
            panel = new Panel(image);

            super.setPanel(panel);//setting the panel of Set class
            generateJulia();
            super.display();//display content
        } else {//invalid number of arguments
            System.out.println("Invalid number of arguments!\nUsage :Fractal Julia [a b]");
        }
    }

    public static void generateJulia() {
        ArrayList<Thread> threadList = new ArrayList<Thread>();

        for (int i = 0; i < DEFAULT_WIDTH; i++) {

            Thread t = new Thread(new Julia(i, panel));
            t.start();
            threadList.add(t);

            //joining the threads and limiting the threads run in parallel.
            for (Thread thread : threadList) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

        threadList.clear();
    }

    @Override
    public void run() {
        for (int j = 0; j < DEFAULT_HEIGHT; j++) {
            //getting the relevent real and imaginaray coordinates of the pixel 
            //based on the region of interest
            double x = panel.getX(i);
            double y = panel.getY(j);
            //asking a color from the iterator (z note is the complex coordinate)
            int color = iterator(new ComplexNumber(x, y), c, iterations);

            image.setRGB(i, j, color);
        }
    }


}
