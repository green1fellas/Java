// Battle Ships

import java.util.Scanner;

public class BattleShip {
// Initialize boards

    private static Scanner sc = new Scanner(System.in);
    private static String[][] playerBoard = new String[10][10];
    private static String[][] enemyBoard = new String[10][10];
    private static String[][] enemyBoardInvisible = new String[10][10];

    public static void main(String[] args) {

        initialize();
        run();
    }

    private static void initialize() {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                playerBoard[i][j] = "_";
                enemyBoard[i][j] = "_";
                enemyBoardInvisible[i][j] = "_";
            }
        }
    }

    // Function that plots random boats for
    // the enemy/computer player

    private static void randomBoat(int size) {

        int direction = (int) (Math.random() * 2);
        int posX = (int) (Math.random() * (11 - size));
        int posY = (int) (Math.random() * (11 - size));

        if (direction == 1) {
            for (int i = 0; i < size - 1; i++) {
                if (!enemyBoard[posX * i][posY].equals("_")) {
                    randomBoat(size);
                    return;
                }
            }
            for (int i = 0; i < size; i++) {
                enemyBoard[posX + i][posY] = "O";
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (!enemyBoard[posX][posY + i].equals("_")) {
                    randomBoat(size);
                    return;
                }
            }
            for (int i = 0; i < size; i++) {
                enemyBoard[posX][posY + i] = "O";
            }
        }
    }

    // Prints board, takes a board type, and an ID,
    // which is only used for the board title
    private static void printBoard(String[][] boardType, String ID) {
        System.out.println("\n-------- " + ID + " Board ---------");
        System.out.println("   0  1  2  3  4  5  6  7  8  9");
        for (int i = 0; i < boardType.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < boardType.length; j++) {
                System.out.print("[" + boardType[i][j] + "]");
            }
            System.out.println();
        }
    }


    // Player plots boat, asks for direction, X coordinate
    // and y coordinate. Checks if in range


    private static void plotBoat(int size) {

        System.out.println("Boat size: " + size);
        System.out.print("Type in right or down");
        String direction = inputString();
        System.out.print("Type in X coordinate: ");
        int posX = inputInt();
        System.out.print("Type in Y coordinate");
        int posY = inputInt();

        if (direction.toLowerCase().equals("down")) {

            for (int i = 0; i < size; i++) {
                if (posY >= 11 - size || posX > 9 || !playerBoard[posY + i][posX].equals("_")) {
                    System.out.println("Position is either taken or out of range, please try again.");
                    plotBoat(size);
                    return;
                }
            }
            for (int i = 0; i < size; i++) {
                playerBoard[posY + i][posX] = "O";
            }
        } else if (direction.equals("right")) {

            for (int i = 0; i < size; i++) {

                if (posY > 9 || posX >= 11 - size || playerBoard[posY][posX + i] != "_") {
                    System.out.println("Position is either taken or out of range, please try again.");
                    plotBoat(size);
                    return;
                }
            }
            for (int i = 0; i < size; i++) {
                playerBoard[posY][posX + i] = "O";
            }
        }
        printBoard(playerBoard, "Player");
    }
    // Enemy/computer attacks player, plots randomly
    // but does not attack in the same place twice

    private static void attackPlayer() {
        int xAttack = (int) (Math.random() * 10);
        int yAttack = (int) (Math.random() * 10);

        if (!playerBoard[yAttack][xAttack].equals("_") || !playerBoard[yAttack][xAttack].equals("#")) {
            playerBoard[yAttack][xAttack] = "X";
        } else {
            playerBoard[yAttack][xAttack] = "#";
        }
        printBoard(enemyBoardInvisible, "Enemy");
        printBoard(playerBoard, "Player");
    }

    // Player attacks enemy, asks for X and Y coordinates, will
    // not break out of while loop until a new place is hit/plot
    // is in range


    private static void attackEnemy() {

        while (true) {

            System.out.println("\nYour turn to attack!");
            System.out.print("Type in X coordinate: ");
            int xAttack = inputInt();
            System.out.print("Type in Y coordinate: ");
            int yAttack = inputInt();

            if (xAttack < 10 && yAttack < 10) {
                if (!enemyBoard[yAttack][xAttack].equals("_") || !enemyBoard[yAttack][xAttack].equals("#")) {
                    enemyBoard[yAttack][xAttack] = "X";
                    enemyBoardInvisible[yAttack][xAttack] = "X";
                } else {
                    enemyBoard[yAttack][xAttack] = "#";
                    enemyBoardInvisible[yAttack][xAttack] = "#";
                }
                break;
            }
        }
    }
    // Checks who wins, if there are no ships (O) left, it will
    // return "(ID) wins!"

    private static void winCheck(String[][] boardType, String ID) {
        for (int i = 0; i < boardType.length; i++) {
            for (int j = 0; j < boardType.length; j++) {
                if (boardType[i][j].equals("O")) {
                    return;
                }
            }
        }
        System.out.println(ID + " wins!");
        System.exit(0);
    }


    // The main function; enemy plots boats first, then player
    // plots boats. Player cannot see enemy's ships, only a
    // board that represents hits and misses. Checks if anyone
    // wins at the end of the while loop. Program ends when one
    // side wins.

    private static void run() {

        randomBoat(5);
        randomBoat(4);
        randomBoat(3);
        randomBoat(3);
        randomBoat(2);

        printBoard(playerBoard, "Player");

        plotBoat(5);
        plotBoat(4);
        plotBoat(3);
        plotBoat(3);
        plotBoat(2);

        printBoard(enemyBoardInvisible, "Enemy");
        printBoard(playerBoard, "Player");

        while (true) {
            attackEnemy();
            attackPlayer();
            printBoard(enemyBoardInvisible, "INV");
            winCheck(playerBoard, "You");
            winCheck(enemyBoard, "Enemy");
        }
    }

    private static int inputInt() {

        int a;

        while (true) {

            if (sc.hasNextInt())
                a = sc.nextInt();
            else {
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

    private static String inputString() {

        while (true) {

            String a = sc.next();

            if (a.toLowerCase().equals("right") || a.toLowerCase().equals("down")) {
                return a;
            }
            System.out.println("Invalid input, please try again");
        }
    }
}
