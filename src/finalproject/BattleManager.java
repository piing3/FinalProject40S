package finalproject;

import cards.templates.Card;
import cards.templates.Minion;
import static finalproject.FinalProject.game;
import java.util.ArrayList;
import utillity.LinkedList;

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
    
    LinkedList<Minion> allMinions = new LinkedList<>();
    
    public BattleManager(Deck player, Deck enemy) {
        playerDeck = player;
        enemyDeck = enemy;
        
        playerHand = new Hand(playerDeck);
        enemyHand = new Hand(playerDeck);
        
        visuals.Hand handVisual = new visuals.Hand(playerHand);
        handVisual.setLocation(0, game.getHeight()-handVisual.getHeight());
        game.add(handVisual,0);
        
    }
    
    public static void playCard(Card card) {
        for (int i = 0; i < 10; i++) {
            
        }
    }

}
