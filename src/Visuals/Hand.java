/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Visuals;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 * Project:
 * Author: Davin
 * Date: 25-Apr-2016
 * Teacher: Mr. Wachs 
 */
public class Hand extends JPanel{

    finalproject.Hand hand;
    
    public Hand(finalproject.Hand hand) {
        this.hand = hand;
        this.setLayout(new GridLayout(1, finalproject.Hand.MAX_SIZE));
        this.setSize(finalproject.FinalProject.game.getWidth(), Card.HEIGHT);
        this.setBackground(Color.red);
        
        for (int i = 0; i < finalproject.Hand.MAX_SIZE; i++) {
            if (hand.CARDS[i] != null) {
                Card card = new Card(hand.CARDS[i]);
                this.add(card);
            }
        }
    }
    

}
