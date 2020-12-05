import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Panel extends JPanel {
    private final BufferedImage bimage;

    // a < real axis < b  AND c < imaginary axis <d
    private float a = -1;
    private float b = 1;
    private float c = -1;
    private float d = 1;

    //constructor without the region of interest
    public Panel(BufferedImage bimage) {
        this.bimage = bimage;
        setPreferredSize(new Dimension(Set.DEFAULT_WIDTH, Set.DEFAULT_HEIGHT));//setting the default panel size
    }

    //constructor with the region of interest
    public Panel(BufferedImage bimage, float a, float b, float c, float d) {
        this.bimage = bimage;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        setPreferredSize(new Dimension(Set.DEFAULT_WIDTH, Set.DEFAULT_HEIGHT));//setting the default panel size
    }

    public double getX(int x) {//returns the real coordinate of the pixel based on the region of interest
        return a + ((double) x / Set.DEFAULT_WIDTH) * (b - a);
    }

    public double getY(int y) {//returns the imaginary coordinate of the pixel based on the region of interest
        return d + ((double) y / Set.DEFAULT_HEIGHT) * (c - d);
    }

    @Override
    public void paintComponent(Graphics g) {//to be used by paint method
        g.drawImage(bimage, 0, 0, null);
    }
}
