package finalproject;

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
    private final Card[] CARDS = new Card[MAX_SIZE];
    private int count = MAX_SIZE;
    
    // Normal--------------------
    
    /**
     * Makes a new blank deck.
     */
    public Deck() {
        Random r = new Random();
        for (int i = 0; i < MAX_SIZE; i++) {
            addCard(CardList.cardList[r.nextInt(100)]);
        }
    }
    
    /**
     * Randomly picks a card from the deck.
     * @return The picked card.
     */
    public Card pickCard(){
        Card c = CARDS[count];
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
        if(count > 0){
            count--;
            CARDS[count] = card;
            shuffleDeck();
        }
    }
    
    /**
     * Removes the top card from the deck.
     */
    public void removeCard(){
        if(count < MAX_SIZE){
            CARDS[count] = null;
            count++;
        }
        shuffleDeck();
    }
    
    /**
     * Removes the given card from the deck.
     * @param card The card to remove
     */
    public void removeCard(Card card){
        //todo
    }
    
    /**
     * Checks if the deck is full.
     * @return true if deck is full.
     */
    private boolean checkFull(){
        for (int i = 0; i < MAX_SIZE; i++) {
            if(CARDS[i].equals(new Card())) return false;
        }
        return true;
    }
    
    // Utill---------------------

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Deck deck) {
        for (int i = 0; i < MAX_SIZE; i++) {
            if(!this.CARDS[i].equals(deck.CARDS[i])) return false; 
        }
        return true; 
    }

    @Override
    public String toString() {
        String string = "";
        for (int i = 0; i < MAX_SIZE; i++) {
            string +="["+ this.CARDS[i].toString()+"] \n";
        }
        string = string.substring(0, string.length()-2);
        return string;
    }
    
    
}
