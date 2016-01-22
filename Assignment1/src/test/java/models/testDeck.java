package models;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

//Created by Tanner Fry - deck and deal test - CS361 - 01/20/2016

public class testDeck{
    @Test
    //Testing that the deck has a full 52 cards
    public void testdeckEmpty(){
        Deck bob = new Deck();
        int expect_deck_count = 51;
        int received_deck_count;
        received_deck_count = bob.getCount();
        assertEquals(52,bob.cards.length);
        assertEquals(expect_deck_count,received_deck_count);
        assertEquals("AD", bob.getCard(51));

    }

    /*@Test
    //Testing the add list functionality
    //Test no long valid as cards are created in the constructor
    public void testAddList(){
        Deck deck1 = new Deck();
        Card card1 = new Card(1,1);
        deck1.addCard(card1);
        Card card2 = new Card(2,2);
        deck1.addCard(card2);
        assertEquals(52,deck1.getCards().size());

    }*/
    @Test
    //This test checks that the deck is initialized correctly
    public void testDeckClassInitialization(){
        // Creating new deck and assigning variables for assert
        Deck deck = new Deck();
        int expected = 51;
        int received;
        received = deck.getCount();
        // Assert
        assertEquals(expected, received);
    }

    @Test
    //This test should test the basic functionality of the deck as a whole
    public void testDeckClassMakeDeck(){
        //Creating new deck
        Deck deck = new Deck();
        // Setting the expected
        int expect_deck_count = 51;
        String expect_card_first = "2C";
        String expect_card_last = "AD";

        // Setting variables that check the expected VS the received
        int received_deck_count;
        String received_card_first;
        String received_card_last;

        received_deck_count = deck.getCount();
        received_card_first = deck.getCard(0);
        received_card_last = deck.getCard(51);

        // Assert statements if values are incorrect.
        assertEquals(expect_deck_count,received_deck_count);
        assertEquals(expect_card_first,received_card_first);
        assertEquals(expect_card_last,received_card_last);
    }

    @Test
    //This test checks that the deck will correctly "deal" a card out to the users interface.
    public void testDeckClassDeal(){
        Deck deck = new Deck();
        int expect_deck_count = 50;
        int received_deck_count;
        deck.Deal();
        received_deck_count = deck.getCount();
        assertEquals(expect_deck_count, received_deck_count);

    }
}