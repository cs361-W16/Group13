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



    public Deck() {
        cards = new Card[NUM_SIZE];
        count = 0;
        for(int i = 0; i < 13; ++i)
        {
            for(int j = 0; j < 4; ++j)
            {
                cards[count++] = new Card(i,j);

            }
        }
        count--;
    }

    public int getCount() {
        return count;
    }
    public String getCard(int c) {
        return cards[c].toString();
    }

    public Card Deal(){
        Card top_card = cards[count];
        cards[count] = null;
        count--;
        return top_card;
    }



}