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
    BattleField bf = new BattleField();
    
    public BattleManager(Deck player) {
        playerDeck = player;
        
        playerHand = new Hand(playerDeck);
        
        playerHand.setLocation(0, game.getHeight()-playerHand.getHeight());
        game.add(playerHand,0);
        
    }
    
    public void playCard(Card card) {
        if(bf.checkFull(true)){
            System.out.println("Your board is too full!");
            return;
        }
        playerHand.removeCard(card);
        if (card instanceof Minion) {
            bf.addCard((Minion)card, true);
        }
        card.cardPlayed();
        for (int i = 0; i < allMinions.getLength(); i++) {
            allMinions.getData(i).cardPlayInterupt();
        }
        refresh();
    }
    
    public void drawCard(){
        Card c = playerDeck.pickCard();
        playerHand.addCard(c);
        playerDeck.removeCard(c);
        c.cardDrawn();
        for (int i = 0; i < allMinions.getLength(); i++) {
            allMinions.getData(i).cardDrawInterupt();
        }
        refresh();
    }
    
    public void refresh(){
        FinalProject.game.repaint();
        FinalProject.game.validate();
    }
    
    public void testing(){
        for (int i = 0; i < bf.P_CARDS.getLength(); i++) {
            Minion m = bf.P_CARDS.getData(i);
            m.setAttack(m.getAttack()+1);
            m.setHealth(m.getHealth()+1);
            refresh();
        }
//        for (int i = 0; i < bf.O_CARDS.getLength(); i++) {
//            Minion m = bf.P_CARDS.getData(i);
//            m.setAttack(m.getAttack()+1);
//            refresh();
//        }
    }
}
