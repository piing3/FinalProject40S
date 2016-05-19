package finalproject;

import cards.templates.Card;
import cards.TestCard1;
import cards.TestCard2;
import cards.templates.DataPacket;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import utillity.LinkedList;

/**
 * Project:
 * Author: Davin
 * Date: 7-Apr-2016
 * Teacher: Mr. Wachs 
 */
public class Deck {
    
    // Globals-------------------
    
    private final int MAX_SIZE = 40; 
    private final LinkedList<Card> CARDS = new LinkedList<>();
    
    // Normal--------------------
    
    /**
     * Makes a new blank deck.
     */
    public Deck() {
        for (int i = 0; i < MAX_SIZE; i++) {
            addCard(new TestCard1());
        }
    }
    
    /**
     * Randomly picks a card from the deck.
     * @return The picked card.
     */
    public Card pickCard(){
        Random r = new Random();
        Card c = CARDS.getData(r.nextInt(MAX_SIZE));
        return c;
    }
    
    /**
     * Adds the given card to the deck.
     * 
     * Ends if the deck is full.
     * 
     * @param card The card to add. 
     */
    public void addCard(Card card){
        CARDS.addDataEnd(card);
    }
    
    /**
     * Removes the given card from the deck.
     * @param card The card to remove
     */
    public void removeCard(Card card){
        CARDS.removeFirst(card);
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
            string +="["+ this.CARDS.getData(i).toString()+"] ";
        }
        string = string.substring(0, string.length()-2);
        return string;
    }
    
    public void setDefault1(){
        for (int i = 0; i < MAX_SIZE; i++) {
            addCard(new TestCard1());
        }
    }
    
    public void setDefault2(){
        for (int i = 0; i < MAX_SIZE; i++) {
            addCard(new TestCard2());
        }
    }
    
    public void readDeck(String file) {
        String s = null;
        try
        {
           FileInputStream fileIn = new FileInputStream(file);
           ObjectInputStream in = new ObjectInputStream(fileIn);
           DataPacket<String> p = (DataPacket<String>) in.readObject();
           s = p.getData();
           in.close();
           fileIn.close();
        }catch(IOException i){
           i.printStackTrace();
           return;
        }catch(ClassNotFoundException c){
           c.printStackTrace();
           return;
        }
        System.out.println(s);
    }
    
    public void saveDeck(){
        try{
           FileOutputStream fileOut = new FileOutputStream("C:\\Users\\d.holmberg\\Desktop\\GitHub\\FinalProject40S\\GameSaves\\test.txt");
           ObjectOutputStream out = new ObjectOutputStream(fileOut);
           out.writeObject(new DataPacket<>("Hello, this is a test"));
           out.close();
           fileOut.close();
            System.out.println("Deck saved");
        }catch(IOException i){
            i.printStackTrace();
        }
    }
    
    
}
