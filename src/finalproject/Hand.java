/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finalproject;

import cards.templates.Card;
import cards.templates.Minion;
import cards.TestCard1;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.MouseInfo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;
import utillity.LinkedList;

/**
 * Project:
 * Author: Davin
 * Date: 6-Apr-2016
 * Teacher: Mr. Wachs 
 */
public class Hand extends JPanel{
    
    // Globals-----------------
    
    public static final int MAX_SIZE = 10; 
    public static final int START_SIZE = 3; 
    public final LinkedList<Card> CARDS = new LinkedList<>();
    public final Deck deck;
    
    // Normal-----------------

    /**
     * new empty hand;
     */
    public Hand() {
        deck = new Deck();
        for (int i = 0; i < MAX_SIZE; i++) {
            CARDS.addDataEnd(new TestCard1());
        }
        visuals();
    }
    
    public Hand(Deck deck) {
        this.deck = deck;
        for (int i = 0; i < START_SIZE; i++) {
            drawCard();
        }
        visuals();
    }
    
    /**
     * Randomly picks a card from the deck, removes it from the
     * deck and adds it to the hand.
     * 
     * If the hand is full, the method ends before picking a card.
     */
    public void drawCard(){
        if(!checkFull()){
            Card newCard = deck.pickCard();
            deck.removeCard(newCard);
            addCard(newCard);
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
        if(!checkFull()){
            CARDS.addDataEnd(card);
            this.add(card, 0);
        }
    }
    
    /**
     * Removes the given card from the hand.
     * @param card The card to remove
     */
    public void removeCard(Card card){
        CARDS.removeFirst(card);
        this.remove(card);
    }
    
    /**
     * Checks if the hand is full.
     * @return True if the hand is full.
     */
    private boolean checkFull(){
        return CARDS.getLength() >=  MAX_SIZE;
    }
    
    // Utill--------------------------
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Hand hand) {
        for (int i = 0; i < MAX_SIZE; i++) {
            if(!this.CARDS.getData(i).equals(hand.CARDS.getData(i))) return false; 
        }
        return true; 
    }

    @Override
    public String toString() {
        String string = "";
        for (int i = 0; i < MAX_SIZE; i++) {
            string += this.CARDS.getData(i).toString()+", ";
        }
        string = string.substring(0, string.length()-2);
        return string;
    }

    // Visual--------------------------
    
    public void visuals(){
        this.setLayout(new GridLayout(1, Hand.MAX_SIZE));
        this.setSize(finalproject.FinalProject.game.getWidth(), Card.HEIGHT);
        this.setBackground(Color.gray);
        
        
        MouseInputListener listener = new MouseInputListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                checkClick(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

            @Override
            public void mouseDragged(MouseEvent e) {
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        };
        this.addMouseListener(listener);
    }
    
    public void checkClick(MouseEvent e){
        int mX = e.getX();
        for (int i = 0; i < MAX_SIZE; i++) {
            if (CARDS.getData(i) != null) {
                if (mX >= CARDS.getData(i).getX() && mX <= CARDS.getData(i).getX()+ Card.WIDTH) {
                    FinalProject.battleManager.playCard(CARDS.getData(i));
                }
            }
        }
    }
    
}
