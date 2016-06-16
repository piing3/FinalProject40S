package cards;

import cards.templates.Minion;
import cards.templates.Spell;
import finalproject.BattleManager;
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
        this.setCost(5);
        
    }
    
    @Override
    public void cardPlayed(boolean b) {
        BattleManager bm = finalproject.FinalProject.battleManager;
        if (bm.isRoom(1)) {
            bm.addMinion(new BananaMinion(), b);
            bm.addMinion(new BananaMinion(), b);
            bm.addMinion(new BananaMinion(), b);
        }
    }
    
    
    

}
