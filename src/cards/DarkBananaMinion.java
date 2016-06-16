package cards;

import cards.templates.Minion;
import javax.swing.ImageIcon;

/**
 * Project:
 * Author: Davin
 * Date: 1-Jun-2016
 * Teacher: Mr. Wachs 
 */
public class DarkBananaMinion extends Minion{
    
    
    public DarkBananaMinion() {
        this.visuals();
        this.setName("Dark Minion");
        
        this.setAttack(3);
        this.setHealth(1);
        this.setCost(2);
        
        this.setImage(new ImageIcon("src\\Images\\CardIcons\\DarkMinionCardImage.png"));
    }
}
