import java.util.Scanner;

public class ModifiedSecantMethodEquationB {
    public static void main(String[] args) 
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter the value of xi: ");
        double x = keyboard.nextDouble();
        //System.out.print("Enter the number of iterations: ");
        int numOfIterations = 100;
        System.out.println("n       xi     f(xi)     xi+1     f(xi+1)   error");
        double xPlusOne = 0; //initialized to random number
        double error = 0; //initialized to random number
        double delta = 0.01;

        for (int i = 0; i < numOfIterations; i++) {
            if (i > 0)
                x = xPlusOne;
            xPlusOne = x - ( func(x) * ( delta / (func(x + delta) - func(x)) ));
            error = Math.abs( ( xPlusOne - x ) / xPlusOne);

            System.out.print(i + "     ");
            System.out.printf("%.4f  %.4f  %.4f  %.4f  %.4f\n", x, func(x), 
            xPlusOne, func(xPlusOne), error);

            if (error < 0.01) //end loop if error is less than 0.01
                i = numOfIterations - 1;
        }
        System.out.println("The root is " + x);
        keyboard.close();
    }
    public static double func(double x) {
        return (x + 10 - (x * Math.cosh(50 / x)));
    }
}
