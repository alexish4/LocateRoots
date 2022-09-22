import java.util.Scanner;

public class NewtonMethodEquationB {
    public static void main(String[] args) 
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter the value of x: ");
        double x = keyboard.nextDouble();
        //System.out.print("Enter the number of iterations: ");
        int numOfIterations = 100;
        System.out.println("n       xi     f(xi)   f(xi+1)   xi+1   error");
        double xPlusOne = 0; //initialized to random number

        for (int i = 0; i < numOfIterations; i++) 
        {
            if(i > 0)
                x = xPlusOne;
            xPlusOne = x - (func(x)/functionDerrived(x));
            double error = Math.abs( (xPlusOne - x) / xPlusOne );
            System.out.print(i + "     ");
            System.out.printf("%.4f  %.4f  %.4f  %.4f  %.4f\n", x, func(x),
            functionDerrived(x), xPlusOne, error);

            if (error < 0.01)
                i = numOfIterations - 1;
        }
        System.out.println("Root is " + xPlusOne);
        
        keyboard.close();
    }
    public static double func(double x) {
        return (x + 10 - (x * Math.cosh(50 / x)));
    }
    public static double functionDerrived(double x) {
        return ( ( (50 * Math.sinh(50 / x)) / x ) - Math.cosh(50 / x) + 1);
    }
}
