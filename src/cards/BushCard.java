/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cards;

import cards.templates.Minion;
import javax.swing.ImageIcon;

/**
 * Project:
 * Author: Davin
 * Date: 1-Jun-2016
 * Teacher: Mr. Wachs 
 */
public class BushCard extends Minion{
    
    
    public BushCard() {
        this.visuals();
        this.setName("Bush");
        
        this.setAttack(10);
        this.setHealth(1);
        this.setCost(4);
        
        this.setImage(new ImageIcon("src\\Images\\CardIcons\\BushCardImage.png"));
    }
}
