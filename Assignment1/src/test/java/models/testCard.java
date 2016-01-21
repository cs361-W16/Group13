package models;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Trevor Hammock on 1/19/16.
 */
public class testCard
{
    @Test
    public void testCardConstruction()
    {
        //2C or 2 of Clubs
        Card c1 = new Card(0,0);
        assertEquals("2C", c1.toString());

        //now lets test all possibilities
        String[] ranks = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
        String[] suits = {"C","S","H","D"};

        for(int i = 0; i < 13; ++i)
        {
            for(int j = 0; j < 4; ++j)
            {
                c1 = new Card(i,j);
                String temp = ranks[i] + suits[j];
                assertEquals(temp,c1.toString());
            }
        }
    }

    @Test
    public void testRankCompare()
    {
        Card c1 = new Card(0,0); //2C
        Card c2 = new Card(1,0); //3C
        Card c3 = new Card(2,0); //4C
        Card c4 = new Card(1,0); //3C
        Card c5 = new Card(1,3); //3D

        //2C < 3C for ranks
        assertTrue(c1.compareRank(c2) < 0);

        //4C > 3C for ranks
        assertTrue(c3.compareRank(c2) > 0);

        //3C == 3C for ranks
        assertTrue(c2.compareRank(c4) == 0);

        //2C < 3D for ranks
        assertTrue(c1.compareRank(c5) < 0);
    }

    @Test
    public void testSameSuit()
    {
        Card c1 = new Card(0,0); //2C
        Card c2 = new Card(0,1); //2S
        Card c3 = new Card(1,0); //3C

        //2C != 2S for suits
        assertFalse(c1.sameSuit(c2));

        //2C == 2C for suits
        assertTrue(c1.sameSuit(c3));

        //2C == 3C for suits
        assertTrue(c1.sameSuit(c3));
    }
}