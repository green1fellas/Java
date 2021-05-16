public class Recursion {

    public static void main(String[] args) {

        System.out.println("Count Up:");
        countUp(1,5);
        System.out.println("Count Down:");
        countDown(5, 1);
        System.out.println("\nAdd 9+7: " + add(9, 7));
        System.out.println("Subtract 9-7 : " + subtract(9, 7));
        System.out.println("Multiply 9*7 : " + multiply(9, 7));
        System.out.println("Divide 6/2 : " + divide(6, 2));
        System.out.println("Exponent 2^9 : " + exponent(2,9));
        System.out.println("Factorial(5): " + factorial(5));
        System.out.println("\nFibonacci -> 10");
        fibonacci(10);

    }

    private static void countUp(int x, int y){

        if(x>y)
            return;

        System.out.println(x);
        countUp(x + 1, y);

    }

    private static void countDown(int x, int y){

        if(x<y)
            return;

        System.out.println(x);
        countDown(x - 1, y);

    }

    private static int add(int x, int y) {

        x += 1;
        y -= 1;
        if (y <= 0)
            return x;
        else
            return add(x, y);
    }

    private static int subtract(int x, int y) {

        x -= 1;
        y -= 1;
        if (y <= 0)
            return x;
        else
            return subtract(x, y);

    }

    private static int multiply(int x, int y) {

        if (x == 0 || y == 0)
            return 0;
        if (y < 0)
            return -x + multiply(x, y - 1);
        else
            return x + multiply(x, y - 1);
    }

    private static int divide(int x, int y) {

        if (y == 0)
            return 0;
        else if (x - y == 0)
            return 1;
        else if (x < y)
            return 0;
        else
            return (1 + divide(x - y, y));
    }

    private static int exponent(int x, int y){

        return exponentRec(x, y, x);

    }

    private static int exponentRec(int x, int y, int z){

        if(y == 1)
            return x;

        return exponentRec(x*z, --y, z);
    }

    private static int factorial(int x){

        return factorialRec(x, --x);

    }

    private static int factorialRec(int x, int y){

        if(y == 1)
            return x;

        return factorialRec(x*y, --y);
    }

    private static void fibonacci(int amt){

        int x = 1;
        int y = 0;
        System.out.println();
        fibonacciRec(x, y, amt);

    }

    private static void fibonacciRec(int x, int y, int amt) {

        if(amt <= 0)
            return;

        System.out.println(x);
        fibonacciRec(x + y, x, --amt);

    }
}

