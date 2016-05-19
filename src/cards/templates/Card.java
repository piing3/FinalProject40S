package cards.templates;

import finalproject.BattleManager;
import finalproject.Hand;
import java.awt.Image;
import java.util.ArrayList;

/**
 * Project:
 * Author: Davin
 * Date: 6-Apr-2016
 * Teacher: Mr. Wachs 
 */
public abstract class Card{

    // Global-----------------
    
    protected int cost;
    protected int type;
    protected Image image;
    protected String name;
    protected String text;
    
    
    // Normal-----------------
    
    /**
     * Gets the cost value
     * @return the cost value
     */
    public int getCost() {
        return cost;
    }

    /**
     * Gets the type value
     * @return the type value
     */
    public int getType() {
        return type;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void cardPlayed(){
        BattleManager.playCard(this);
    }
    
    public void cardDrawn(Hand hand){
        hand.addCard(this);
    }
    
    public void cardPlayInterupt(){
        
    }
    
    public void cardDrawInterupt(){
        
    }
    
    public void cardAttackInterupt(){
        
    }
    
    public void cardDieInterupt(){
        
    }
    
    // Utill---------------------

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Card card) {
        if (this.cost != card.cost) return false;
        if (this.type != card.type) return false;
        if (!this.name.equals(card.name)) return false;
        return true;
    }

    @Override
    public String toString() {
        return this.name+", cost - "+this.cost+", type - "+this.type;
    }
}
