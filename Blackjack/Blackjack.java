package Blackjack;

import java.util.ArrayList;
import java.util.Scanner;

public class Blackjack {

    private static Scanner sc = new Scanner(System.in);
    private static boolean running = true;
    private static Deck mainDeck = new Deck();
    private static int playerMoney = 200;
    private static int compMoney = 200;
    private static ArrayList<Card> playerHand = new ArrayList<Card>();
    private static ArrayList<Card> compHand = new ArrayList<Card>();
    private static int bet;

    public static void main(String[] args){

        System.out.println("\nWelcome to Blackjack!");

        while(running) {

            mainDeck = new Deck();
            mainDeck.shuffleDeck();

            addToHand(playerHand, 2);
            addToHand(compHand, 2);

            playerTurn();
            compTurn();
            winCheck();

            while(!playerHand.isEmpty())
                playerHand.remove(0);

            while(!compHand.isEmpty())
                compHand.remove(0);
        }
    }

    private static void winCheck(){

        int compHandAmt = 0;
        int playerHandAmt = 0;

        for(Card i : playerHand)
            playerHandAmt = playerHandAmt + i.value;

        for(Card i : compHand)
            compHandAmt = compHandAmt + i.value;

        if(playerHandAmt <= 21 && compHandAmt <= 21){
            if(playerHandAmt > compHandAmt){
                playerMoney = playerMoney + 2*bet;
                System.out.println("\nYou win!");
            }else if(playerHandAmt < compHandAmt){
                compMoney = compMoney + 2*bet;
                System.out.println("\nYou lose!");
            }else{
                playerMoney = playerMoney + 2*bet;
                compMoney = compMoney + 2*bet;
                System.out.println("\nTie!");
            }

        }else if(playerHandAmt > 21 && compHandAmt > 21){
            playerMoney = playerMoney + 2*bet;
            compMoney = compMoney + 2*bet;
            System.out.println("\nTie!");
        }else if(playerHandAmt > 21){
            compMoney = compMoney + 2*bet;
            System.out.println("\nYou lose!");
        }else{
            playerMoney = playerMoney + 2*bet;
            System.out.println("\nYou win!");
        }

        if (playerMoney <= 0) {
            System.out.println("\nYou went bankrupt, GAME OVER");
            running = false;

        } else if(compMoney <= 0){
            System.out.println("\nComputer went bankrupt, YOU WIN!");
            running = false;
        }

    }

    private static void playerTurn(){

        System.out.println("\nPlayer's Cash:   $" + playerMoney);
        System.out.println("Computer's Cash: $" + compMoney);

        System.out.print("Bet: $");
        bet = input();
        playerMoney = playerMoney - bet;
        compMoney = compMoney - bet;

        while (true) {

            printHand();

            System.out.println("Would you like to hit or stay?");
            String hitOrStay = sc.next();

            if (hitOrStay.equals("hit"))
                addToHand(playerHand, 1);
            else if (hitOrStay.equals("stay"))
                break;
            else
                System.out.println("False entry, try again.");
        }
    }

    private static void compTurn(){

        while(true){

            int handAmt = 0;

            for(Card i : compHand)
                handAmt = handAmt + i.value;

            if (handAmt < 15)
                addToHand(compHand,1);
            else
                break;
        }
    }

    private static void addToHand(ArrayList<Card> hand, int amt){

        for(int i = 0; i < amt; i++){

            int randNum = (int)(Math.random()*mainDeck.getDeck().size());

            hand.add(mainDeck.getDeck().get(randNum));
            mainDeck.getDeck().remove(randNum);
        }

    }

    private static void printHand(){

        System.out.println("\nPlayer's hand:");

        int j = 1;

        for(Card i : playerHand){
            if(!i.special.equals("standard"))
                System.out.println(j + ": " + i.special + " of " + i.type + " (" + i.value + ")");
            else
                System.out.println(j + ": " + i.value + " " + i.type);
            j++;
        }
        System.out.println();
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
            if (a > playerMoney || a > compMoney || a < 1) {
                System.out.println("Invalid input, please try again");
                continue;
            }
            return a;
        }
    }
}
