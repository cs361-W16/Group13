package models;


import java.util.ArrayList;

/**
 * Created by Tanner Fry Jan / 20 / 2016
 *
 * Deck Class that uses the Card class to maintain a sinlge unique deck.
 */
public class Deck {
    private static int NUM_SIZE = 52;
    public Card cards[];
    public int count;

    private ArrayList<Card> deckList;
    /* Creating a deckList that holds the array of cards*/

    /* Grab the cards from array*/
    public ArrayList<Card> getCards(){
        return deckList;
    }
    /* Adds a card to the array of cards*/
    public void addCard(Card next_card){
        //Checking that the card is unique NYI
        deckList.add(next_card);

    }

    Deck() {
        cards = new Card[NUM_SIZE];
        count = 0;
        for(int i = 0; i < 13; ++i)
        {
            for(int j = 0; j < 4; ++j)
            {
                cards[count++] = new Card(i,j);

            }
        }
    }

    public int getCount() {
        return count;
    }
    public String getCard(int c) {
        return cards[c].toString();
    }


    public Card Deal(){
        Card topcard = cards[count];
        cards[count] = null;
        count--;
        return topcard;
    }



}