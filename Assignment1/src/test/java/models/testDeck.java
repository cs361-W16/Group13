package models;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

//Created by Tanner Fry - deck test - CS361

public class deckTest{
    @Test
    //Testing that the deck has nothing in it
    public void testdeckEmpty(){
        Deck bob = new Deck();
        assertEquals(0, one.getCards().size());
    }


}