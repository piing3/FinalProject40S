/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Visuals;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import javax.swing.ImageIcon;

/**
 * Project:
 * Author: Davin
 * Date: 26-Apr-2016
 * Teacher: Mr. Wachs 
 */
class CardLarge extends Card{

    Card card;
    
    CardLarge(finalproject.Card card) {
        super(card);
        Point mouse = MouseInfo.getPointerInfo().getLocation();
        this.setLocation(mouse.x - 100, mouse.y - 150);
        this.setSize(200, 300);
        this.cardBackround = new ImageIcon("src\\Images\\NeutralCardBackroundLarge.png");
        finalproject.FinalProject.game.add(this);
    }
    

}
