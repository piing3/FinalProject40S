package cards;

import cards.templates.Minion;
import javax.swing.ImageIcon;

/**
 * Project:
 * Author: Davin
 * Date: 1-Jun-2016
 * Teacher: Mr. Wachs 
 */
public class LongBoyMinion extends Minion{
    
    
    public LongBoyMinion() {
        this.visuals();
        this.setName("Long Boy");
        
        this.setAttack(3);
        this.setHealth(2);
        this.setCost(2);
        
        this.setImage(new ImageIcon("src\\Images\\CardIcons\\LongBoyCardImage.png"));
    }
}
