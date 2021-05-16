import java.util.Random;

public class Main {

    /* input[y][x]
       y = samples
       x = traits

       w1[y][x]
       y = connected weights
       x = samples

       hidden1[y][x]
       y = samples
       x =

    */

    private static double x[][] = new double[3][2];
    private static double w1[][] = new double[2][3];
    private static double a2[][] = new double[3][3];
    private static double z2[][] = new double[3][3];
    private static double w2[][] = new double[3][1];
    private static double z3[][] = new double[3][1];
    private static double yHat[][] = new double[3][1];
    private static double y [][] = new double[3][1];
    private static double[][] dJdW2;
    private static double[][] dJdW1;


    public static void main(String[] args) {

        double[][] epoch = {{.1,.2,.10},
                            {.3,.4,.23},
                            {.9,.10,.96}};

        init();
        for(int i = 0; i < 100000; i++) {
            epochToBatch(epoch);
        }
        printArray(y, "y:");
        printArray(yHat, "yHat:");
        System.out.println("\nCost: " + cost());

        // Test
        for(int i = 0; i < x.length; i++){
            for(int j = 0; j < x[0].length; j++){
                x[i][j] = .1;
            }
        }

        forwardPropagation();
        printArray(yHat, "yHat:");

    }

    private static void train(double scalar){

        forwardPropagation();
        backPropagation(scalar);
    }

    private static void init(){

        randomizeWeights(w1);
        randomizeWeights(w2);
    }

    // NEURAL NET FUNCTIONS

    private static void randomizeWeights(double[][] w){

        Random rand = new Random();
        for(int i = 0; i < w.length; i++){
            for(int j = 0; j < w[0].length; j++){
                w[i][j] = rand.nextDouble();
            }
        }
    }

    private static void forwardPropagation(){

        z2 = dotProduct(x, w1);
        a2 = activation(z2);
        z3 = dotProduct(a2, w2);
        yHat = activation(z3);
    }

    private static void backPropagation(double scalar){ //*****

        costPrime();

        for(int i = 0; i < w2.length; i++){
            for(int j = 0; j < w2[0].length; j++){
                w2[i][j] = w2[i][j] - (scalar*dJdW2[i][j]);
            }
        }
        for(int i = 0; i < w1.length; i++){
            for(int j = 0; j < w1[0].length; j++){
                w1[i][j] = w1[i][j] - (scalar*dJdW1[i][j]);
            }
        }
    }


    private static void costPrime(){ // ****

        double[][] delta3 = new double[yHat.length][yHat[0].length];
        double[][] delta2;


        for(int i = 0; i < yHat.length; i++){

            delta3[i][0] = ((-1)*(y[i][0] - yHat[i][0]))*sigmoidPrime(z3[i][0]);
        }

        dJdW2 = dotProduct(transpose(a2), delta3);
        delta2 = dotProduct(delta3, transpose(w2));

        for(int i = 0; i < delta2.length; i++){
            for(int j = 0; j < delta2[0].length; j++){
                delta2[i][j] *= sigmoidPrime(z2[i][j]);
            }
        }
        dJdW1 = dotProduct(transpose(x), delta2);
    }

    private static double cost(){

        double result = 0;
        for(int i = 0; i < yHat.length; i++){
            result += Math.pow(y[i][0] - yHat[i][0], 2)/2;
        }
        return result;
    }

    private static double[][] activation(double[][] arr){

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                arr[i][j] = sigmoid(arr[i][j]);
            }
        }
        return arr;
    }

    // ---- MATH ----

    private static double sigmoid(double x) {
        return (1/( 1 + Math.pow(Math.E,(-1*x))));
    }

    private static double sigmoidPrime(double x){

        return sigmoid(x)*(1 - sigmoid(x));
    }

    private static double[][] matrixSigmoidPrime(double[][] arr){

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                arr[i][j] = sigmoidPrime(arr[i][j]);
            }
        }
        return arr;
    }

    private static double[][] dotProduct(double[][] arr1, double[][] arr2){

        // new = 1-y, 2-x
        double[][] result = new double[arr1.length][arr2[0].length];

        for(int i = 0; i < arr1.length; i++){
            for(int j = 0; j < arr2[0].length; j++){
                for(int k = 0; k < arr1[0].length; k++){
                    result[i][j] += (arr1[i][k]*arr2[k][j]);
                }
            }
        }
        return result;
    }

    private static double[][] transpose(double[][] arr){

        double[][] result = new double[arr[0].length][arr.length];

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                result[j][i] = arr[i][j];
            }
        }
        return result;
    }

    private static void epochToBatch(double[][] epoch){

        int k = 0;
        while(k < epoch.length) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 2; j++) {
                    x[i][j] = epoch[k][j];
                }
                y[i][0] = epoch[k][2];
                train(.01);
                k++;
            }
        }
    }

    // ---- PRINTING ----

    private static void printArray(double[][] arr, String msg){

        System.out.println("\n" + msg);

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print("[" + arr[i][j] + "] ");
            }
            System.out.println();
        }
    }
}
//