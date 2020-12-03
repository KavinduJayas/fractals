package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Set {

    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private BufferedImage image = new BufferedImage(800, 800, BufferedImage.TYPE_INT_RGB);


    public Set() {
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);
    }


    private Color iterator(ComplexNumber zNote, ComplexNumber c, int n) {

        ComplexNumber z;

        for (int i = 0; i <= n; i++) {
            ComplexNumber zSquared = ComplexNumber.square(zNote);
            z = ComplexNumber.sum(zSquared, c);
            if (ComplexNumber.absolute(zSquared) > 4) break;

        }
        return Color.BLACK;
    }
}
