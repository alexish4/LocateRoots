//import java.util.Scanner;

public class BisectionMethod
{   
    public static void main(String[] args) 
    {
        //Scanner keyboard = new Scanner(System.in);
        int numOfIterations = 12;
        double a = 0;
        double b = 0.5;
        double c = 0;
        double cN_MinusOne = 0;
        double error = 1; //initialized to a random number
        System.out.println("n       a       b       c       f(a)    f(b)    f(c)    error");
        for(int i = 0; i < numOfIterations; i++)
        {      
            c = (a + b) / 2;
            if(i > 0)
                error = Math.abs(c-cN_MinusOne)/c;
            //System.out.println("Value of c is: " + c);
            System.out.println(); //adding to space out rows


            //x = a;
            double function = func(a);
            //System.out.println("Function of a is: " + function);
            //x = b;
            function = func(b);
            //System.out.println("Function of b is: " + function);
            //x = c;
            function = func(c);
            //System.out.println("Function of c is: " + function);
            System.out.print(i + "     ");
            if (i == 0) //first iteration doesn't show error
            {
                System.out.printf("%.4f  %.4f  %.4f  %.4f  %.4f  %.4f\n", a, b, c, func(a),
                func(b), func(c));
            }
            else //these iterations do show the error
            {
                System.out.printf("%.4f  %.4f  %.4f  %.4f  %.4f  %.4f  %.4f\n", a, b, c, func(a),
                func(b), func(c), error);
            }
            System.out.println();//adding to space out rows

            if( ( func(a) * func(c) ) < 0)
                b = c;
            else
                a = c;
            cN_MinusOne = c;
        } //end of for loop
            

    }
    public static double func(double x) {
        return ( (9 * Math.pow(x, 4) ) + ( 18 * Math.pow(x, 3) ) + ( 38 * Math.pow(x, 2) 
             - ( 57 * x ) + 14));
    }
}