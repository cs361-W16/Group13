package models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Tanner Fry Jan / 20 / 2016
 *
 * Deck Class that uses the Card class to maintain a sinlge unique deck.
 */
public class Deck implements {
    private ArrayList<Card> deckList;
/* Creating a deckList that holds the array of cards*/
    public Deck() {
        deckList = new ArrayList<>();
    }
/* Grab the cards from array*/
    public ArrayList<Card> getCards(){
        return deckList;
    }
/* Adds a card to the array of cards*/
    public void addCard(Card next_card){
        deckList.add(next_card);
    }




}