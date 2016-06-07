package Multiplayer;

import cards.templates.Card;
import cards.templates.Minion;
import java.io.Serializable;

/**
 * Purpose: 
 * @Date
 * @author Davin
 * Teacher: Mr. Wachs
 */
public class Action implements Serializable{
    public boolean cardPlayed;
    public Card card;
    public int minion1;  
    public int minion2;
    public String text;

    public Action(boolean cardPlayed, Card card, int minion1, int minion2) {
        this.cardPlayed = cardPlayed;
        this.card = card;
        this.minion1 = minion1;
        this.minion2 = minion2;
        
        this.text = null;
    }

    public Action(String string) {
        this.text = string;
        
        this.cardPlayed = false;
        this.card = null;
        this.minion1 = -1;
        this.minion2 = -1;
    }
    
    
}
