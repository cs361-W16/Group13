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
    @Test
    public void testDeckClassInitialization(){
        // Arrange
        Deck deck = new Deck();
        int expected = 0;
        int received;
        // Act
        received = deck.getCount();
        // Assert if
        assertEquals(expected, received);
    }

    @Test
    public void testDeckClassMakeDeck(){

        // Arrange
        Deck deck = new Deck();

        // Expect
        int expect_deck_count = 52;
        String expect_card_first = "AD";
        String expect_card_last = "KC";

        // Received
        int received_deck_count;
        String received_card_first;
        String received_card_last;


        // Act

        received_deck_count = deck.getCount();
        received_card_first = deck.getCard(0);
        received_card_last = deck.getCard(51);

        // Assert
        assertEquals(expect_deck_count,received_deck_count);
        assertEquals(expect_card_first,received_card_first);
        assertEquals(expect_card_last,received_card_last);

    }

    @Test
    public void testDeckClassDeal(){

        // Arrange
        Deck deck = new Deck();

        // Expect
        int expect_deck_count = 51;

        // Received
        int received_deck_count;

        // Act

        deck.Deal();

    }
}