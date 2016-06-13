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
        this.setName("Exceess Mana");//what is spelling
        this.setCost(1);
        
    }
    
    @Override
    public void cardPlayed(boolean b) {
        finalproject.FinalProject.battleManager.drawCard(); 
    }

}
