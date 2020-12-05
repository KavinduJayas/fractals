
public class Fractal {

    public static void main(String[] args) {
        Mandelbrot mb;
        Julia j;

        if (args.length > 0) {
            if (args[0].equals("Mandelbrot")) {//mandelbrot 
                mb = new Mandelbrot();
                mb.handleArguments(args);
            } else if (args[0].equals("Julia")) {//julia
                j = new Julia();
                j.handleArguments(args);
            } else {//invalid set name
                System.out.println("Invalid arguments!\nUsage:java Fractal [Mandelbrot | Julia] [args]");
            }
        } else {
            System.out.println("No arguments given!\nUsage:java Fractal [Mandelbrot | Julia] [args]");
        }

    }
}
