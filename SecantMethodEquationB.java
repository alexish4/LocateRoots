import java.util.Scanner;

public class SecantMethodEquationB {
    public static void main(String[] args) 
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter the value of x0: ");
        double x0 = keyboard.nextDouble();
        System.out.print("Enter the value of x1: ");
        double x1 = keyboard.nextDouble();
        //System.out.print("Enter the number of iterations: ");
        int numOfIterations = 100; //max number of iterations
        System.out.println("n       xi-1     xi     f(xi-1)   f(xi)   xi+1     f(xi+1)   error");
        double xPlusOne = 0; //initialized to random number
        double error = 0; //initialized to random number

        for (int i = 0; i < numOfIterations; i++) 
        {
            if(i > 0)
            {
                x0 = x1;
                x1 = xPlusOne;
            }
            
            xPlusOne = x1 - ( (x1 - x0) / ( func(x1) - func(x0) ) ) * func(x1); 
            error = Math.abs( ( xPlusOne - x1 ) / xPlusOne);

            System.out.print(i + "     ");
            System.out.printf("%.4f  %.4f  %.4f  %.4f  %.4f  %.4f  %.4f\n", x0, x1, func(x0), 
            func(x1), xPlusOne, func(xPlusOne), error);

            if (error < 0.01)
                i = numOfIterations - 1;
        }
        System.out.println("Root is " + x1);

        keyboard.close();
    }
    public static double func(double x) {
        return (x + 10 - (x * Math.cosh(50 / x)));
    }
}
