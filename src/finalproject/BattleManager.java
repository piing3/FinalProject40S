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
    
    Hand playerHand;
    
    LinkedList<Minion> allMinions = new LinkedList<>();
    
    public BattleManager(Deck player) {
        playerDeck = player;
        
        playerHand = new Hand(playerDeck);
        
        playerHand.visuals();
        playerHand.setLocation(0, game.getHeight()-playerHand.getHeight());
        game.add(playerHand,0);
        
    }
    
    public void playCard(Card card) {
        playerHand.removeCard(card);
        card.cardPlayed();
        for (int i = 0; i < allMinions.getLength(); i++) {
            allMinions.getData(i).cardPlayInterupt();
        }
    }
    
    public void drawCard(){
        Card c = playerDeck.pickCard();
        playerHand.addCard(c);
        playerDeck.removeCard(c);
    }
}
