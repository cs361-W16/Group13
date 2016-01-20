package models;

/**
 * Created by Trevor Hammock on 1/19/16.
 */
public class Card
{
    public int rank;
    public int suit;

    /**
     * rank: 2,3,4,5,6,7,8,9,10,J,Q,K,A
     * suit: Club, Spade, Heart, Diamond
     * for now this assumes rank is between 0-12
     * for now this assumes suit is between 0-3
     */
    public Card(int rank, int suit)
    {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * Card c = new Card(0,0); //2C or 2 of Clubs
     * c.toString() == "2C"
     */
    @Override
    public String toString()
    {
        String result = "";

        //handle rank
        if(rank <= 8)
        {
            result += String.valueOf(rank+2);
        }
        else
        {
            switch(rank)
            {
                case  9: result += "J"; break;
                case 10: result += "Q"; break;
                case 11: result += "K"; break;
                case 12: result += "A"; break;
            }
        }

        //handle suit
        switch(suit)
        {
            case 0: result += "C"; break;
            case 1: result += "S"; break;
            case 2: result += "H"; break;
            case 3: result += "D"; break;
        }

        return result;
    }

    /**
     * if c1.compareRank(c2) >  0 then c1 > c2
     * if c1.compareRank(c2) == 0 then c1 == c2
     * if c1.compareRank(c2) <  0 then c1 < c2
     */
    public int compareRank(Card c)
    {
        return this.rank - c.rank;
    }

    public boolean sameSuit(Card c)
    {
        return this.suit == c.suit;
    }
}