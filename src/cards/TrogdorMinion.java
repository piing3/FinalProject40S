package cards;

import cards.templates.Minion;
import javax.swing.ImageIcon;

/**
 * Project:
 * Author: Davin
 * Date: 1-Jun-2016
 * Teacher: Mr. Wachs 
 */
public class TrogdorMinion extends Minion{
    
    
    public TrogdorMinion() {
        this.visuals();
        this.setName("Trogdor");
        
        this.setAttack(9);
        this.setHealth(6);
        this.setCost(7);
        
        this.setImage(new ImageIcon("src\\Images\\CardIcons\\TrogdorCardImage.png"));
    }
}
