package finalproject;

import Multiplayer.Action;
import Multiplayer.Game;
import cards.SanicCard;
import cards.templates.Card;
import cards.templates.Minion;
import cards.templates.Spell;
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
        
        playerHand.setLocation(0, FinalProject.game.getHeight()-playerHand.getHeight());
        FinalProject.game.add(playerHand,0);
        new Game();
        
    }
    
    public void playCard(Card card) {
        playCard(card, true);
    }
    
    public void playCard(Card card, boolean b) {
        if(bf.checkFull(b)){
            System.out.println("Your board is too full!");
            return;
        }
        playerHand.removeCard(card);
        if (card instanceof Minion) {
            bf.addCard((Minion)card, b);
        }
        card.cardPlayed();
        for (int i = 0; i < allMinions.getLength(); i++) {
            allMinions.getData(i).cardPlayInterupt();
        }
        Game.sending = new Action(true, card, -1, -1);
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
        this.playCard(new SanicCard(), false);
    }

    public void IO(Action action) {
        if(action.cardPlayed){
            if (action.card instanceof Spell) {
                action.card.setTarget(allMinions.getData(action.minion1));
            }
            playCard(action.card, false);
        }
    }

    public void minionClicked(boolean b) {
        if (b) {
            Minion c = bf.P_CARDS.getData(bf.target);
            if (c.isReady()) {
                bf.forceSelect();
                c.attack();
            }
        }
    }

}
