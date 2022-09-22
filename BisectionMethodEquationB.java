import java.util.Scanner;

public class BisectionMethodEquationB {
    public static void main(String[] args) 
    {
        Scanner keyboard = new Scanner(System.in);
        int numOfIterations = 100;
        System.out.print("Please enter value of a: ");
        double a = keyboard.nextDouble();
        System.out.print("Please enter value of b: ");
        double b = keyboard.nextDouble();
        double c = 0;
        keyboard.close();
        double cN_MinusOne = 0;
        System.out.println("e is" + Math.E);
        double error = 1; //initialized to a random number
        System.out.println("n       a       b       c       f(a)    f(b)    f(c)    error");
        for(int i = 0; i < numOfIterations; i++)
        {      
            c = (a + b) / 2;
            if(i > 0)
            {    
                error = Math.abs(c-cN_MinusOne)/c;
                if (error < 0.01)
                {    
                    System.out.print(i + "     ");
                    System.out.printf("%.4f  %.4f  %.4f  %.4f  %.4f  %.4f  %.4f\n", a, b, c, func(a),
                    func(b), func(c), error);
                    i = numOfIterations - 1; //end loop
                }
                else //these iterations do show the error
                {
                    System.out.print(i + "     ");
                    System.out.printf("%.4f  %.4f  %.4f  %.4f  %.4f  %.4f  %.4f\n", a, b, c, func(a),
                    func(b), func(c), error);
                }
            }
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
            if (i == 0) //first iteration doesn't show error
            {
                System.out.print(i + "     ");
                System.out.printf("%.4f  %.4f  %.4f  %.4f  %.4f  %.4f\n", a, b, c, func(a),
                func(b), func(c));
            }
            System.out.println();//adding to space out rows

            if( ( func(a) * func(c) ) < 0)
                b = c;
            else
                a = c;
            cN_MinusOne = c;
        } //end of for loop
        System.out.println("The root is " + c);
            

    }
    public static double func(double x) {
        return (Math.pow(Math.E, x) - 2*Math.pow(x, 2));
    }
}
