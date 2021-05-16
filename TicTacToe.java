import java.util.Scanner;

public class TicTacToe {

    private static Scanner sc = new Scanner(System.in);
    private static String board[][] = new String[3][3];
    private static String turn = "X";

    public static void main(String[] args){

        init();
        run();

    }

    private static void init(){

        // Initialize board

        for(int i = 0; i <=2; i++){
            for(int j = 0; j<=2; j++){
                board[j][i] = "_";
            }
        }
    }

    private static void run() {

        int x, y;

        System.out.println("\nWelcome to Tic-Tac-Toe!");

        while (true) {

            printBoard();

            // Input
            while (true) {

                System.out.print("\nEnter X Coordinate: ");
                x = input();

                System.out.print("Enter Y Coordinate: ");
                y = input();

                if (board[x][y].equals("_")) {
                    board[x][y] = turn;
                    break;
                } else
                    System.out.println("\nPosition taken, try again");
            }
                // Win check & switch turns

                if (winCheck() != null) {
                    printBoard();
                    System.out.println("\n" + winCheck() + " wins!");
                    break;
                }
                turn = turn.equals("X") ? "O" : "X";
            }
        }

    private static String winCheck(){

        for(int i = 0; i <=2; i++){

            if(board[0][i].equals(board[1][i]) &&
                    board[1][i].equals(board[2][i]) && !board[2][i].equals("_")){
                return board[0][i];
            }

            if(board[i][0].equals(board[i][1]) &&
            board[i][1].equals(board[i][2]) && !board[i][2].equals("_")){
                return board[i][0];
            }

            if(board[0][0].equals(board[1][1]) &&
            board[1][1].equals(board[2][2]) && !board[2][2].equals("_")){
                return board[0][0];
            }

            if(board[0][2].equals(board[1][1]) &&
                    board[1][1].equals(board[2][0]) && !board[2][0].equals("_")){
                return board[0][2];
            }
        }
        return null;
    }

    private static void printBoard(){

        System.out.println("\n" + turn.toUpperCase() + "'s turn");
        System.out.println("   0  1  2");
        for (int i = 0; i <= 2; i++) {
            System.out.print(i + " ");
            for (int j = 0; j <= 2; j++) {
                System.out.print("[" + board[j][i] + "]");
            }
            System.out.println();
        }
    }

    private static int input(){

        int a;

        while(true) {

            if(sc.hasNextInt())
                a = sc.nextInt();
            else{
                sc.next();
                System.out.println("Invalid input, please try again");
                continue;
            }
            if (a > 2 || a < 0) {
                System.out.println("Invalid input, please try again");
                continue;
            }
            return a;
        }
    }
}
