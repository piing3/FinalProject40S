package cards;

import cards.templates.Minion;
import cards.templates.Spell;
import javax.swing.ImageIcon;

/**
 * Purpose: 
 * @Date
 * @author Davin
 * Teacher: Mr. Wachs
 */
public class BananaSpell extends Spell{

    public BananaSpell() {
        this.visuals();
        this.setName("Bananas!");
        this.setImage(new ImageIcon("src\\Images\\CardIcons\\MinionSwarmCardImage.png"));
        this.setCost(1);
        
    }

    @Override
    public void cardPlayed() {
        if (finalproject.FinalProject.battleManager.isRoom(1)) {
            finalproject.FinalProject.battleManager.addMinion(new BananaMinion(), true);
        }
    }
    
    
    

}
