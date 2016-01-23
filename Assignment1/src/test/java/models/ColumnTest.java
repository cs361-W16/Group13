package models;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chrissie on 1/22/16.
 */
public class ColumnTest {

    @Test
    public void testAddFourCards() {
        Column col1 = new Column();
        Deck deck = new Deck();
        col1.addFourCards(deck);
        assertEquals(1, col1.columnone.size());
        assertEquals(4, col1.colCardNum);
    }

    @Test
    public void testAddFourCards1() {
        Column col2 = new Column();
        Deck deck2 = new Deck();
        for(int i = 0; i < 2; i++)
            col2.addFourCards(deck2);
        assertEquals(2, col2.columnone.size());

    }

}