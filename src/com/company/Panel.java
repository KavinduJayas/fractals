package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Panel extends JPanel {
    private final BufferedImage bimage;
    private float a = -1;
    private float b = 1;
    private float c = -1;
    private float d = 1;
// a < real axis < b  AND c < imaginary axis <d

    public Panel(BufferedImage bimage, float a, float b, float c, float d) {
        this.bimage = bimage;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        setPreferredSize(new Dimension(Set.DEFAULT_WIDTH, Set.DEFAULT_HEIGHT));
    }

    public double getX(int x){
        return a+((double)x/Set.DEFAULT_WIDTH )* (b -a);
    }

    public double getY(int y){
        return d+((double)y/Set.DEFAULT_HEIGHT )* (c -d);
    }

    public Panel(BufferedImage bimage) {
        this.bimage = bimage;
        setPreferredSize(new Dimension(Set.DEFAULT_WIDTH, Set.DEFAULT_HEIGHT));
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(bimage, 0, 0, null);
    }
}
