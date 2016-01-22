package models;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

//Created by Tanner Fry - deck test - CS361

public class testDeck{
    @Test
    //Testing that the deck has nothing in it
    public void testdeckEmpty(){
        Deck bob = new Deck();
        assertEquals(0, bob.getCards().size());
    }

    @Test
    //Testing the add list functionality
    public void testAddList(){
        Deck deck1 = new Deck();
        Card card1 = new Card(1,1);
        deck1.addCard(card1);
        Card card2 = new Card(2,2);
        deck1.addCard(card2);
        assertEquals(2,deck1.getCards().size());

    }
/*
    @Test
    //Testing that two of the same card cannot be in the deck
    public void testUnigueCard(){
        Deck deck1 = new Deck();
        Card card1 = new Card(1,1);
        Card card2 = new Card(1,1);
        deck1.addCard(card1);
        deck1.addCard(card2);
        assertEquals(1,deck1.getCards().size());
    }
*/
}