//import java.util.Scanner;

public class FalsePosition
{   
    public static void main(String[] args) 
    {
        int numOfIterations = 11;
        double x;
        double a = 0;
        double b = 0.5;
        double c = 0;
        double error = 1; //initialized error to a random numbers
        double cN_MinusOne = 0;

        System.out.println("n       a       b       f(a)    f(b)    c       f(c)    error");
        for(int i = 0; i < numOfIterations; i++)
        {
            c = ((a * func(b)) - (b * func(a))) / (func(b) - func(a));
            if(i > 0)
                error = Math.abs(c-cN_MinusOne)/c;
            System.out.println(); //adding to space out rows

            System.out.print(i + "     ");
            if (i == 0) //first iteration doesn't show error
            {
                System.out.printf("%.4f  %.4f  %.4f  %.4f  %.4f  %.4f\n", a, b, func(a),
                func(b), c, func(c));
            }
            else //these iterations do show the error
            {
                System.out.printf("%.4f  %.4f  %.4f  %.4f  %.4f  %.4f  %.4f\n", a, b, func(a),
                func(b), c, func(c), error);
            }
            System.out.println();//adding to space out rows

            if(Math.signum(func(a)) == Math.signum(func(c)))
                a = c;
            else   
                b = c;

            cN_MinusOne = c;
        } //end of for loop

            
    }
    public static double func(double x) {
        return ( (9 * Math.pow(x, 4) ) + ( 18 * Math.pow(x, 3) ) + ( 38 * Math.pow(x, 2) 
             - ( 57 * x ) + 14));
    }
}