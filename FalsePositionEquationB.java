import java.util.Scanner;

public class FalsePositionEquationB {
    public static void main(String[] args) 
    {
        Scanner keyboard = new Scanner(System.in);
        int numOfIterations = 11;
        System.out.print("Please enter value of a: ");
        double a = keyboard.nextDouble();
        System.out.print("Please enter value of b: ");
        double b = keyboard.nextDouble();
        double c = 0;
        keyboard.close();
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
                if (error < 0.01)
                    i = numOfIterations - 1;
            }
            System.out.println();//adding to space out rows

            if(Math.signum(func(a)) == Math.signum(func(c)))
                a = c;
            else   
                b = c;

            cN_MinusOne = c;
        } //end of for loop
        System.out.println("The root is " + c);
            
    }
    public static double func(double x) {
        return (x + 10 - (x * Math.cosh(50 / x)));
    }
}
