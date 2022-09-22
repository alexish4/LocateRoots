import java.util.Scanner;

public class NewtonMethod
{   
    public static void main(String[] args) 
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter the value of x: ");
        double x = keyboard.nextDouble();
        System.out.print("Enter the number of iterations: ");
        double numOfIterations = keyboard.nextDouble();
        System.out.println("n       xi     f(xi)   f(xi+1)   xi+1   error");
        double xPlusOne = 0; //initialized to random number

        for (int i = 0; i < numOfIterations; i++) 
        {
            xPlusOne = x - (func(x)/functionDerrived(x));
            double error = Math.abs( (xPlusOne - x) / xPlusOne );
            System.out.print(i + "     ");
            System.out.printf("%.4f  %.4f  %.4f  %.4f  %.4f\n", x, func(x),
            functionDerrived(x), xPlusOne, error);

            x = xPlusOne;
        }
        
        keyboard.close();
    }
    public static double func(double x) {
        return ( Math.pow(x, 4) + ( 2 * Math.pow(x, 3) ) - ( 7 * Math.pow(x, 2)) 
            + 3);
    }
    public static double functionDerrived(double x) {
        return ( ( 4 * Math.pow(x, 3) ) + ( 6 * Math.pow(x, 2)) 
            - (14 * x));
    }
}