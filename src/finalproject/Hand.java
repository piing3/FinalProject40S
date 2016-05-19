/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finalproject;

import cards.templates.Card;
import cards.templates.Minion;
import cards.TestCard1;

/**
 * Project:
 * Author: Davin
 * Date: 6-Apr-2016
 * Teacher: Mr. Wachs 
 */
public class Hand {
    
    // Globals-----------------
    
    public static final int MAX_SIZE = 10; 
    public static final int START_SIZE = 3; 
    public final Card[] CARDS = new Card[MAX_SIZE];
    public final Deck deck;
    private int count = 0;
    
    // Normal-----------------

    /**
     * new empty hand;
     */
    public Hand() {
        deck = new Deck();
        for (int i = 0; i < MAX_SIZE; i++) {
            CARDS[i] = new TestCard1();
        }
    }
    
    public Hand(Deck deck) {
        this.deck = deck;
        for (int i = 0; i < MAX_SIZE; i++) {
            CARDS[i] = new TestCard1();
        }
        for (int i = 0; i < START_SIZE; i++) {
            drawCard();
        }
    }
    
    /**
     * Randomly picks a card from the deck, removes it from the
     * deck and adds it to the hand.
     * 
     * If the hand is full, the method ends before picking a card.
     */
    public void drawCard(){
        boolean full = this.checkFull();
        if(!full){
            Card newCard = deck.pickCard();
            deck.removeCard(newCard);
            newCard.cardDrawn(this);
        }
    }
    
    /**
     * Adds the given card to the hand.
     * 
     * Ends if the hand is full.
     * 
     * @param card The card to add. 
     */
    public void addCard(Card card){
        if(count > 0){
            count--;
            CARDS[count] = card;
        }
    }
    
    /**
     * Removes the top card from the hand.
     */
    public void removeCard(){
        if(count < MAX_SIZE){
            CARDS[count] = null;
            count++;
        }
    }
    
    /**
     * Removes the given card from the hand.
     * @param card The card to remove
     */
    public void removeCard(Card card){
        for (int i = 0; i < MAX_SIZE; i++) {
            if (CARDS[i].equals(card)) {
                CARDS[i] = null;
                sort();
            }
        }
    }
    
    /**
     * Checks if the hand is full.
     * @return True if the hand is full.
     */
    private boolean checkFull(){
        for (int i = 0; i < MAX_SIZE; i++) {
            if(CARDS[i] == null) return false;
        }
        return true;
    }
    
    /**
     * Sort the hand.
     */
    private void sort() {
        for (int i = 0; i < MAX_SIZE; i++) {
            if (true) {
                
            }
        }
    }
    
    // Utill--------------------------
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Hand hand) {
        for (int i = 0; i < MAX_SIZE; i++) {
            if(!this.CARDS[i].equals(hand.CARDS[i])) return false; 
        }
        return true; 
    }

    @Override
    public String toString() {
        String string = "";
        for (int i = 0; i < MAX_SIZE; i++) {
            string += this.CARDS[i].toString()+", ";
        }
        string = string.substring(0, string.length()-2);
        return string;
    }

    
    
}
