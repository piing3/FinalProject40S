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
public class SanicMinion extends Minion{
    
    
    public SanicMinion() {
        this.visuals();
        this.setName("Sanic");
        
        this.setAttack(4);
        this.setHealth(2);
        this.setCost(3);
        this.ready = true;
        
        this.setImage(new ImageIcon("src\\Images\\CardIcons\\SanicCardImage.png"));
    }
}
