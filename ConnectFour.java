import java.util.Scanner;

public class ConnectFour {

    private static boolean running = true;
    private static Scanner sc = new Scanner(System.in);
    private static String[][] board = new String[6][7];
    private static String turn = "X";

    public static void main(String[] args){

        init();
        run();

    }

    private static void run(){

        while(running){

            printBoard();
            plot();
            winCheck();
            turn = turn.equals("X") ? "O" : "X";
        }
    }

    private static void init(){

        System.out.println("\nWelcome to Connect Four!\n");

        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                board[i][j] = "_";
            }
        }
    }

    private static void printBoard(){

        System.out.println(" 1  2  3  4  5  6  7");
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                System.out.print("[" + board[i][j] + "]");
            }
            System.out.println();
        }
    }

    private static void plot(){
        System.out.print("\nIt is " + turn + "'s turn.\nChoose X coordinate: ");
        int xCoordinate = (input()-1);

        for(int i = 5; i >= 0; i--){
            if(board[i][xCoordinate].equals("_")){
                board[i][xCoordinate] = turn;
                break;
            }
        }
    }

    private static void winCheck(){

        //Horizontal check
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 4; j++){
                if(
                        board[i][j].equals(board[i][j+1])
                        && board[i][j+1].equals(board[i][j+2])
                        && board[i][j+2].equals(board[i][j+3])
                        && board[i][j+3].equals(turn)){
                    printBoard();
                    System.out.println("\n" + turn + " wins!");
                    running = false;
                }
            }
        }

        //Vertical check
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 7; j++){
                if(
                        board[i][j].equals(board[i+1][j])
                        && board[i+1][j].equals(board[i+2][j])
                        && board[i+2][j].equals(board[i+3][j])
                        && board[i+3][j].equals(turn)){
                    printBoard();
                    System.out.println("\n" + turn + " wins!");
                    running = false;
                }
            }
        }

        //Positive diagonal
        for(int i = 3; i < 6; i++){
            for(int j = 0; j < 4; j++){
                if(
                        board[i][j].equals(board[i-1][j+1])
                        && board[i-1][j+1].equals(board[i-2][j+2])
                        && board[i-2][j+2].equals(board[i-3][j+3])
                        && board[i-3][j+3].equals(turn)){
                    printBoard();
                    System.out.println("\n" + turn + " wins!");
                    running = false;
                }
                if(
                        board[i-3][j].equals(board[i-2][j+1])
                        && board[i-2][j+1].equals(board[i-1][j+2])
                        && board[i-1][j+2].equals(board[i][j+3])
                        && board[i][j+3].equals(turn)){
                    printBoard();
                    System.out.println("\n" + turn + " wins!");
                    running = false;
                }
            }

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
            if (a > 7 || a < 1) {
                System.out.println("Invalid input, please try again");
                continue;
            }
            return a;
        }
    }
}
