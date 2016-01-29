package models;

import java.util.ArrayDeque;
import java.util.Random;
import java.util.Arrays;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by yichen on 1/21/16.
 */
public class Column {
    public ArrayDeque<Card> columnone = new ArrayDeque<>();
    public ArrayDeque<Card> columntwo = new ArrayDeque<>();
    public ArrayDeque<Card> columnthree = new ArrayDeque<>();
    public ArrayDeque<Card> columnfour = new ArrayDeque<>();
    public int []colCardLoc = new int[52]; //cards we have
    public int colCardNum = 0;
    public Card []topCards = new Card[4]; //top cards in 4 cols

    public Column() {
        Arrays.fill(colCardLoc, -1);
    }

    public int getRandomLocation(){
        Random randomGenerator = new Random();
        int randomlocation = randomGenerator.nextInt(51);
        return randomlocation;
    }

    public void addFourCards(Deck deck) { //add a card to each column
        int randomlocation1 = getRandomLocation();
        while(Arrays.asList(colCardLoc).contains(randomlocation1)){ //if we already have this card then find another one
            randomlocation1 = getRandomLocation();
        }
        Card card1 = deck.cards[randomlocation1];
        columnone.push(card1); //add a random card to col 1
        colCardLoc[colCardNum] = randomlocation1; // to compare
        colCardNum ++;
        topCards[0] = columnone.getLast();

        int randomlocation2 = getRandomLocation();
        while(Arrays.asList(colCardLoc).contains(randomlocation2)){
            randomlocation2 = getRandomLocation();
        }
        Card card2 = deck.cards[randomlocation2];
        columntwo.push(card2); //add a random card to col 2
        colCardLoc[colCardNum] = randomlocation2; // to compare
        colCardNum ++;
        topCards[1] = columntwo.getLast();

        int randomlocation3 = getRandomLocation();
        while(Arrays.asList(colCardLoc).contains(randomlocation3)){
            randomlocation3 = getRandomLocation();
        }
        Card card3 = deck.cards[randomlocation3];
        columnthree.push(card3); //add a random card to col 3
        colCardLoc[colCardNum] = randomlocation3; // to compare
        colCardNum ++;
        topCards[2] = columnthree.getLast();

        int randomlocation4 = getRandomLocation();
        while(Arrays.asList(colCardLoc).contains(randomlocation4)){
            randomlocation4 = getRandomLocation();
        }
        Card card4 = deck.cards[randomlocation4];
        columnfour.push(card4); //add a random card to col 4
        colCardLoc[colCardNum] = randomlocation4; // to compare
        colCardNum ++;
        topCards[3] = columnfour.getLast();
    }

    public boolean discardCard(int column) { //column input by user
        int find = 0;

        switch (column){
            case 1: //user wants to discard top card in columnone
            for(int col = 0; col < 4; col ++){
                if(topCards[column - 1].suit == topCards[col].suit && topCards [column - 1].rank < topCards[col].rank)
                    find = 1;
            }
            if(find == 1){ //find higher-ranked card
                columnone.removeLast();
                topCards[0] = columnone.getLast();
                return true;
            }
            if(find == 0){
                return false;
            }
                break;

            case 2:
                for(int col = 0; col < 4; col ++){
                    if(topCards[column - 1].suit == topCards[col].suit && topCards [column - 1].rank < topCards[col].rank)
                        find = 1;
                }
                if(find == 1){
                    columntwo.removeLast();
                    topCards[1] = columntwo.getLast();
                    return true;
                }
                if(find == 0){
                    return false;
                }
                break;

            case 3:
                for(int col = 0; col < 4; col ++){
                    if(topCards[column - 1].suit == topCards[col].suit && topCards [column - 1].rank < topCards[col].rank)
                        find = 1;
                }
                if(find == 1){
                    columnthree.removeLast();
                    topCards[2] = columnthree.getLast();
                    return true;
                }
                if(find == 0){
                    return false;
                }
                break;

            case 4:
                for(int col = 0; col < 4; col ++){
                    if(topCards[column - 1].suit == topCards[col].suit && topCards [column - 1].rank < topCards[col].rank)
                        find = 1;
                }
                if(find == 1){
                    columnfour.removeLast();
                    topCards[3] = columnfour.getLast();
                    return true;
                }
                if(find == 0){
                    return false;
                }
                break;
            default: break;
        }
        return true;
    }

    public boolean moveCard(int colfrom, int colto){ //colfrom, colto input by users
        if (colfrom == colto){
            return false;
        }
        else if (colfrom != colto){
            switch (colto){
                case 1:
                    if(!columnone.isEmpty()){
                        return false;
                    }
                    else if (columnone.isEmpty()){
                        if (colfrom == 2){ //move columntwo topcard to columnone
                            if (columntwo.isEmpty() || columntwo.size() == 1){
                                return false;
                            }
                            else {
                                Card cardx;
                                cardx = columntwo.pop();
                                columnone.push(cardx);
                                topCards[0] = columnone.getLast();
                                topCards[1] = columntwo.getLast();
                                return true;
                            }
                        }

                        if (colfrom == 3){ //move columnthree topcard to columnone
                            if (columnthree.isEmpty() || columnthree.size() == 1){
                                return false;
                            }
                            else {
                                Card cardx;
                                cardx = columnthree.pop();
                                columnone.push(cardx);
                                topCards[0] = columnone.getLast();
                                topCards[2] = columnthree.getLast();
                                return true;
                            }
                        }

                        if (colfrom == 4){ //move columnfour topcard to columnone
                            if (columnfour.isEmpty() || columnfour.size() == 1){
                                return false;
                            }
                            else {
                                Card cardx;
                                cardx = columnfour.pop();
                                columnone.push(cardx);
                                topCards[0] = columnone.getLast();
                                topCards[3] = columnfour.getLast();
                                return true;
                            }
                        }
                    }
                    break;

                case 2:
                    if(!columntwo.isEmpty()){
                        return false;
                    }
                    else if (columntwo.isEmpty()){
                        if (colfrom == 1){ //move columnone topcard to columntwo
                            if (columnone.isEmpty() || columnone.size() == 1){
                                return false;
                            }
                            else {
                                Card cardx;
                                cardx = columnone.pop();
                                columntwo.push(cardx);
                                topCards[0] = columnone.getLast();
                                topCards[1] = columntwo.getLast();
                                return true;
                            }
                        }

                        if (colfrom == 3){ //move columnthree topcard to columntwo
                            if (columnthree.isEmpty() || columnthree.size() == 1){
                                return false;
                            }
                            else {
                                Card cardx;
                                cardx = columnthree.pop();
                                columntwo.push(cardx);
                                topCards[1] = columntwo.getLast();
                                topCards[2] = columnthree.getLast();
                                return true;
                            }
                        }

                        if (colfrom == 4){ //move columnfour topcard to columntwo
                            if (columnfour.isEmpty() || columnfour.size() == 1){
                                return false;
                            }
                            else {
                                Card cardx;
                                cardx = columnfour.pop();
                                columntwo.push(cardx);
                                topCards[1] = columntwo.getLast();
                                topCards[3] = columnfour.getLast();
                                return true;
                            }
                        }
                    }
                    break;

                case 3:
                    if(!columnthree.isEmpty()){
                        return false;
                    }
                    else if (columnthree.isEmpty()){
                        if (colfrom == 2){ //move columntwo topcard to columnthree
                            if (columntwo.isEmpty() || columntwo.size() == 1){
                                return false;
                            }
                            else {
                                Card cardx;
                                cardx = columntwo.pop();
                                columnthree.push(cardx);
                                topCards[1] = columntwo.getLast();
                                topCards[2] = columnthree.getLast();
                                return true;
                            }
                        }

                        if (colfrom == 1){ //move columnone topcard to columnthree
                            if (columnone.isEmpty() || columnone.size() == 1){
                                return false;
                            }
                            else {
                                Card cardx;
                                cardx = columnone.pop();
                                columnthree.push(cardx);
                                topCards[0] = columnone.getLast();
                                topCards[2] = columnthree.getLast();
                                return true;
                            }
                        }

                        if (colfrom == 4){ //move columnfour topcard to columnthree
                            if (columnfour.isEmpty() || columnfour.size() == 1){
                                return false;
                            }
                            else {
                                Card cardx;
                                cardx = columnfour.pop();
                                columnthree.push(cardx);
                                topCards[2] = columnthree.getLast();
                                topCards[3] = columnfour.getLast();
                                return true;
                            }
                        }
                    }
                    break;

                case 4:
                    if(!columnfour.isEmpty()){
                        return false;
                    }
                    else if (columnfour.isEmpty()){
                        if (colfrom == 2){ //move columntwo topcard to columnfour
                            if (columntwo.isEmpty() || columntwo.size() == 1){
                                return false;
                            }
                            else {
                                Card cardx;
                                cardx = columntwo.pop();
                                columnfour.push(cardx);
                                topCards[3] = columnfour.getLast();
                                topCards[1] = columntwo.getLast();
                                return true;
                            }
                        }

                        if (colfrom == 3){ //move columnthree topcard to columnfour
                            if (columnthree.isEmpty() || columnthree.size() == 1){
                                return false;
                            }
                            else {
                                Card cardx;
                                cardx = columnthree.pop();
                                columnfour.push(cardx);
                                topCards[3] = columnfour.getLast();
                                topCards[2] = columnthree.getLast();
                                return true;
                            }
                        }

                        if (colfrom == 1){ //move columnone topcard to columnfour
                            if (columnone.isEmpty() || columnone.size() == 1){
                                return false;
                            }
                            else {
                                Card cardx;
                                cardx = columnone.pop();
                                columnfour.push(cardx);
                                topCards[0] = columnone.getLast();
                                topCards[3] = columnfour.getLast();
                                return true;
                            }
                        }
                    }
                    break;
            }
        }
        return true;
    }
}
