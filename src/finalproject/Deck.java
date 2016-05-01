package finalproject;

import cards.templates.Card;
import cards.TestCard;
import java.util.ArrayList;
import java.util.Random;

/**
 * Project:
 * Author: Davin
 * Date: 7-Apr-2016
 * Teacher: Mr. Wachs 
 */
public class Deck {
    
    // Globals-------------------
    
    private final int MAX_SIZE = 40; 
    private final ArrayList<Card> CARDS = new ArrayList<>();
    
    // Normal--------------------
    
    /**
     * Makes a new blank deck.
     */
    public Deck() {
        for (int i = 0; i < MAX_SIZE; i++) {
            addCard(new TestCard());
        }
    }
    
    /**
     * Randomly picks a card from the deck.
     * @return The picked card.
     */
    public Card pickCard(){
        Random r = new Random();
        Card c = CARDS.get(r.nextInt(MAX_SIZE));
        return c;
    } 
    
    /**
     * Shuffle the deck.
     */
    private void shuffleDeck(){
        //todo
    }
    
    /**
     * Adds the given card to the deck.
     * 
     * Ends if the deck is full.
     * 
     * @param card The card to add. 
     */
    public void addCard(Card card){
        CARDS.add(card);
        shuffleDeck();
    }
    
    /**
     * Removes the given card from the deck.
     * @param card The card to remove
     */
    public void removeCard(Card card){
        CARDS.remove(card);
        shuffleDeck();
    }
    
    // Utill---------------------

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Deck deck) {
        
        return this.CARDS.equals(deck.CARDS); 
    }

    @Override
    public String toString() {
        String string = "";
        for (int i = 0; i < MAX_SIZE; i++) {
            string +="["+ this.CARDS.get(i).toString()+"] ";
        }
        string = string.substring(0, string.length()-2);
        return string;
    }
    
    
}
