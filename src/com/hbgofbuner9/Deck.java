package com.hbgofbuner9;


import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

enum Suit {
    HEARTS(1), SPADES(2), DIAMONDS(3), CLUBS(4);
    private int suit_order;
    Suit(int order) {
        this.suit_order = order;
    }

    public int getOrder() {
        return suit_order;
    }
}

enum Rank {
    ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13);
    private int rank_order;
    Rank(int order) {
        this.rank_order = order;
    }

    public int getOrder() {
        return rank_order;
    }
}

class Card implements Comparable<Card>{
    private final Suit suit;
    private final Rank rank;
    private final int order;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
        this.order = suit.getOrder()*100+rank.getOrder();
    }

    public Suit getSuit() { return this.suit; }

    public Rank getRank() { return this.rank; }

    public int getOrder() { return this.order; }

    public String print() {
        String suit = String.valueOf(this.getSuit());
        String rank = String.valueOf(this.getRank());
        String order = String.valueOf(this.getOrder());
        return "("+ suit + ","+ rank +","+order+")";
    }

    @Override
    public int compareTo(@NotNull Card card) {
        int compareQuantity = ((Card) card).getOrder();
        //ascending order
        return this.order - compareQuantity;

        //descending order
        //return compareQuantity - this.quantity;
    }
}


public class Deck {

    static List<Card> cards = new ArrayList<Card>();
    static public void createDeck()
    {
        for(Suit s : Suit.values())
        {
            for(Rank r : Rank.values())
            {
                cards.add(new Card(s,r));
            }
        }
    }
    static public void shuffleDeck()
    {
        Collections.shuffle(cards);
    }
    public static void main(String[] args) {
        //Card card = new Card(Suit.HEARTS, Rank.ACE);
        //String a = String.valueOf(card.getSuit());
        //System.out.println(a);
        //System.out.println(card.getRank());
        //System.out.println(card.print());

        //create Deck
        System.out.println("Creating Deck...");
        createDeck();
        int i=1;
        /*for(Card c : cards) {
            System.out.println(i + " " +c.print());
            i++;
        }*/
       // Shuffle Deck
        System.out.println("Shuffling:");
        shuffleDeck();
        i=1;
        for(Card c : cards) {
            System.out.println(i + " " +c.print());
            i++;
        }
        System.out.println("Sorting:");
        Collections.sort(cards);
        i=1;
        for(Card c : cards) {
            System.out.println(i + " " +c.print());
            i++;
        }
    }
}