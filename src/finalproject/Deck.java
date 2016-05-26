package finalproject;

import cards.templates.Card;
import cards.TestCard1;
import cards.TestCard2;
import java.io.File;
import utillity.DataPacket;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;
import utillity.LinkedList;
import utillity.Settings;

/**
 * Project:
 * Author: Davin
 * Date: 7-Apr-2016
 * Teacher: Mr. Wachs 
 */
public class Deck implements Serializable{
    
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
            CARDS.getData(i).visuals();
        }
    }
    
    /**
     * Randomly picks a card from the deck.
     * @return The picked card.
     */
    public Card pickCard(){
        Random r = new Random();
        Card c = null;//CARDS.getData(r.nextInt(CARDS.getLength()))
        while (c == null) {            
            c = CARDS.getData(r.nextInt(CARDS.getLength()));
        }
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
    
    public static Deck readDeck(String file) {
        Deck d = null;
        try
        {
           FileInputStream fileIn = new FileInputStream(file);
           ObjectInputStream in = new ObjectInputStream(fileIn);
           DataPacket<Deck> p = (DataPacket<Deck>) in.readObject();
           d = p.getData();
           in.close();
           fileIn.close();
        }catch(IOException i){
           i.printStackTrace();
           return null;
        }catch(ClassNotFoundException c){
           c.printStackTrace();
           return null;
        }
        System.out.println(d.toString());
        return d;
    }
    
    public static void saveDeck(Deck d){
        try{
            File file = new File(Settings.saves);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOut = new FileOutputStream(Settings.saves);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(new DataPacket<>(d));
            out.close();
            fileOut.close();
            System.out.println("Deck saved");
        }catch(IOException i){
            i.printStackTrace();
        }
    }
    
    
}
