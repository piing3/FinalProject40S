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
public class BananaMinion extends Minion{
    
    
    public BananaMinion() {
        this.visuals();
        this.setName("Minion");
        
        this.setAttack(1);
        this.setHealth(3);
        this.setCost(2);
        
        this.setImage(new ImageIcon("src\\Images\\CardIcons\\Minion1CardImage.png"));
    }
}
