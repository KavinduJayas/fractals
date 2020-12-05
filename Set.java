import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Set implements Runnable{
    //deafult constants
    public static final int DEFAULT_WIDTH = 800;
    public static final int DEFAULT_HEIGHT = 800;
    public static final int DEFAULT_ITER = 1000;

    //a BufferedImage, a JFrame and a ponter to a panel
    public static JFrame frame = new JFrame();
    public BufferedImage image = new BufferedImage(DEFAULT_WIDTH, DEFAULT_HEIGHT, BufferedImage.TYPE_INT_RGB);
    private Panel panel;

    //setter for panel
    public void setPanel(Panel panel) {
        this.panel = panel;
    }

    public Set() {
    }

    //implemented by the inherited Julia and Mandelbrot classes
    public abstract void handleArguments(String args[]);

    public abstract void generateFractal();

    public void display() {//display the content after creating the fractal
        frame.setSize(DEFAULT_HEIGHT, DEFAULT_WIDTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);
        frame.setResizable(false);

        panel.paint(image.getGraphics());

        frame.setContentPane(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    //returns a color based on the equation Z(n+1)=(Zn)^2+C
    public int iterator(ComplexNumber zNote, ComplexNumber c, int n) {
        ComplexNumber zSquared;
        ComplexNumber z = zNote;

        int i;
        for (i = 0; i <= n; i++) {
            zSquared = ComplexNumber.square(z);
            z = ComplexNumber.sum(zSquared, c);
            if (ComplexNumber.absolute(zSquared) >= 4) break;//break if the point is not in the set
        }
        if (i < n) return pickColor(i);//pick color based on the iteration
        else return Color.BLACK.getRGB();//if not black color

    }

    private int pickColor(int i) {//takes the iteration and returns a color

        int pallet = 0b011011100001100101101000;
        int mask = 0b000000000000010101110111;
        return pallet | (mask << i);//each point with the same diverged iteration get the same color

    }
}
