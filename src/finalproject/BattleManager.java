package finalproject;

import cards.templates.Card;
import cards.templates.Minion;
import java.util.ArrayList;

/**
 * Purpose: 
 * @Date
 * @author Davin
 * Teacher: Mr. Wachs
 */
public class BattleManager {

    Deck playerDeck;
    Deck enemyDeck;
    
    Hand playerHand;
    Hand enemyHand;
    
    public BattleManager(Deck player, Deck enemy) {
        playerDeck = player;
        enemyDeck = enemy;
        
        playerHand = new Hand(playerDeck);
        enemyHand = new Hand(playerDeck);
    }

}
