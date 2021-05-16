package Blackjack;

import java.util.ArrayList;

class Deck {

    private ArrayList<Card> deck = new ArrayList<Card>();

    Deck(){

        for(int i = 0; i < 4; i++){
            for(int j = 1; j < 11; j++){

                if(i == 0)
                    deck.add(new Card(j, "clubs", "standard"));
                if(i == 1)
                    deck.add(new Card(j, "diamonds", "standard"));
                if(i == 2)
                    deck.add(new Card(j, "hearts", "standard"));
                if(i == 3)
                    deck.add(new Card(j, "spades", "standard"));
                }
            }

            String type = null;

            for(int i = 0; i < 4; i++){

                if(i == 0)
                    type = "clubs";
                if(i == 1)
                    type = "diamonds";
                if(i == 2)
                    type = "hearts";
                if(i == 3)
                    type = "spades";

                deck.add(new Card(10,type,"Jack"));
                deck.add(new Card(10,type,"Queen"));
                deck.add(new Card(10,type,"King"));
        }
    }

    void printDeck(){

        int j = 1;

        for(Card i : deck){
            if(!i.special.equals("standard"))
                System.out.println(j + ": " + i.special + " of " + i.type + " (" + i.value + ")");
            else
                System.out.println(j + ": " + i.value + " " + i.type);
            j++;
        }

    }

    void shuffleDeck() {

        ArrayList<Card> newDeck = new ArrayList<Card>();

        while (true) {

            int randNum = (int) (Math.random() * deck.size());
            newDeck.add(deck.get(randNum));
            deck.remove(randNum);

            if (deck.isEmpty())
                break;
        }
        deck = newDeck;
    }

    ArrayList<Card> getDeck(){

        return this.deck;

    }
}
