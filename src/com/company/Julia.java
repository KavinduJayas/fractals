package com.company;

import java.awt.*;

public class Julia extends Set{
    public static final ComplexNumber DEFAULT_C;
    private int iterations=DEFAULT_ITER;
    private Panel panel;
    private ComplexNumber c = DEFAULT_C;

    static {
        DEFAULT_C = new ComplexNumber(-0.4, 0.6);
    }

    public void Julia(){

    }
    @Override
    public void handleArguments(String args[]) {
        if(args.length == 3){
            c = new ComplexNumber(Double.parseDouble(args[1]),Double.parseDouble(args[2]));
        }else if(args.length!=1){
            System.out.println("Invalid number of arguments!\nUsage :Fractal Mandelbrot [a b c d] [n]");
        }
    }
    public void generateFractal(){

        panel = new Panel(image);

        super.setPanel(panel);

        for (int i = 0; i < DEFAULT_WIDTH; i++ ) {
            for (int j = 0; j < DEFAULT_HEIGHT; j++ ) {

                double x = panel.getX(i);
                double y =panel.getY(j);
                //System.out.println("x:"+x+"  y:"+y);
                int color = super.iterator( new ComplexNumber(x,y),c,iterations);

                super.image.setRGB(i, j,color);
            }
        }
        super.display();
    }


}
