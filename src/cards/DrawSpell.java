package cards;

import cards.templates.Spell;

/**
 * Purpose: 
 * @Date
 * @author Davin
 * Teacher: Mr. Wachs
 */
public class DrawSpell extends Spell {

    public DrawSpell() {
        this.visuals();
        this.setName("Excess Mana");
        this.setCost(1);
        
    }
    
    @Override
    public void cardPlayed(boolean player) {
        if(player)finalproject.FinalProject.battleManager.drawCard(); 
    }

}
