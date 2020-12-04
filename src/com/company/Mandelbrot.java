package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Mandelbrot extends Set {
    private int iterations=DEFAULT_ITER;
    private Panel panel;

    public void Mandelbrot() {
    }

    @Override
    public void handleArguments(String args[]) {
        if(args.length == 1){
            panel = new Panel(image);
        }else if(args.length==5){
            panel = new Panel(
                    image,
                    Float.parseFloat(args[1]),
                    Float.parseFloat(args[2]),
                    Float.parseFloat(args[3]),
                    Float.parseFloat(args[4])
            );
        }else if(args.length==6){
            panel = new Panel(
                    image,
                    Float.parseFloat(args[1]),
                    Float.parseFloat(args[2]),
                    Float.parseFloat(args[3]),
                    Float.parseFloat(args[4])
            );
            iterations = Integer.parseInt(args[5]);
        }else{
            System.out.println("Invalid number of arguments!\nUsage :Fractal Mandelbrot [a b c d] [n]");
        }
    }

    @Override
    public void generateFractal(){

        super.setPanel(panel);

        for (int i = 0; i < DEFAULT_WIDTH; i++ ) {
            for (int j = 0; j < DEFAULT_HEIGHT; j++ ) {

                double x = panel.getX(i);
                double y =panel.getY(j);
                //System.out.println("x:"+x+"  y:"+y);
                int color = super.iterator(new ComplexNumber(0,0), new ComplexNumber(x,y),iterations);

                image.setRGB(i, j,color);
            }
        }
        super.display();
    }



}
