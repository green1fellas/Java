import java.util.Scanner;

public class Shapes {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("What would you like the size to be?");
        int size = sc.nextInt();

        square(size);
        System.out.println();
        rightTriangle(size);
        System.out.println();
        equilateralTriangle(size);
        System.out.println();
        diamond(size);
        System.out.println();
        hollowDiamond(size);

    }

    private static void square(int size){

        for(int i = 1; i <=size; i++){
            System.out.print("* ");
            for(int j = 1; j <=size; j++){
                if(i==1 || i == size || j == size){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    private  static void rightTriangle(int size){

        for(int i = 1; i <= size; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void equilateralTriangle(int size){

        for(int i = 1; i <= size; i++){
            for(int j = size; j >= i; j--){
                System.out.print(" ");
                }
            for(int k = 1; k <= i; k++){
                    System.out.print("* ");
            }
                System.out.println();
            }
        }

        private static void diamond(int size){

            equilateralTriangle(size);

            for(int i = size-1; i >= 1; i--){
                for(int j = size; j >= i; j--){
                    System.out.print(" ");
                }
                for(int k = 1; k <= i; k++){
                    System.out.print("* ");
                }
                System.out.println();
            }
        }

        private static void hollowDiamond(int size){

            for(int i = 1; i <= size; i++){
                for(int j = size; j >= i; j--){
                    System.out.print(" ");
                }
                for(int k = 1; k <= i; k++){
                    if(k==1 || k==i) {
                        System.out.print("* ");
                    }else{
                        System.out.print("  ");
                    }
                }
                System.out.println();
            }


            for(int i = size-1; i >= 1; i--){
                for(int j = size; j >= i; j--){
                    System.out.print(" ");
                }
                for(int k = 1; k <= i; k++){
                    if(k ==1 || k == i) {
                        System.out.print("* ");
                    }else{
                        System.out.print("  ");
                    }
                }
                System.out.println();
            }
        }
}
