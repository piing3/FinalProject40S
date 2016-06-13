package finalproject;

import Multiplayer.Action;
import Multiplayer.Game;
import cards.SanicMinion;
import cards.templates.Card;
import cards.templates.Minion;
import cards.templates.Spell;
import static finalproject.FinalProject.game;
import java.util.ArrayList;
import utillity.LinkedList;
import visuals.GUI;

/**
 * Purpose: 
 * @Date
 * @author Davin
 * Teacher: Mr. Wachs
 */
public class BattleManager {//oops, i've acedentialy put everything in this class


    Deck playerDeck;    
    Hand playerHand;
    LinkedList<Minion> allMinions = new LinkedList<>();
    BattleField bf = new BattleField();
    boolean turn = false;
    GUI gui;
    int[] mana = {0,0,0,0,0,0,0,0,0,0};
    
    public BattleManager(Deck player) {
        playerDeck = player;
        playerHand = new Hand(playerDeck);
        
        playerHand.setLocation(0, FinalProject.game.getHeight()-playerHand.getHeight());
        FinalProject.game.add(playerHand,0);
        
        gui = new GUI();
        new Game();
        
    }
    
    public void playCard(Card card) {
        playCard(card, true);
    }
    
    public void playCard(Card card, boolean b) {
        if ((!isTurn() && b) || (isTurn() && !hasMana(card.getCost())) ){
            return;
        }
        
        if(bf.checkFull(b)){
            System.out.println("Your board is too full!");
            return;
        }
        playerHand.removeCard(card);
        if (card instanceof Minion) {
            bf.addCard((Minion)card, b);
        }
        card.cardPlayed(b);
        changeMana(card.getCost(), 0);
        for (int i = 0; i < allMinions.getLength(); i++) {
            allMinions.getData(i).cardPlayInterupt();
        }
        if(b) Game.sending = new Action(true, card, -1, -1);
        refresh();
    }
    
    public void addMinion(Minion minion, boolean b){
        bf.addCard(minion, b);
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
//        FinalProject.game.repaint();
//        FinalProject.game.validate();
        playerHand.repaint();
        playerHand.validate();
        bf.repaint();
        bf.validate();
    }
    
    public void testing(){
        this.playCard(new SanicMinion(), false);
    }

    public void IO(Action action) {
        if (action.text != null) {
            if (action.text.equalsIgnoreCase("turn")) turn = true; 
            return;
        }
        
        
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
    
    public boolean isRoom(int i){
        return bf.P_CARDS.getLength()+i <= BattleField.MAX_SIZE;
    }

    public void endTurn() {
        if (turn) {
            turn = !turn;
            Game.sending = new Action("turn");
            gui.turn.setEnabled(turn);
            for (int i = 0; i < bf.P_CARDS.getLength(); i++) {
                bf.P_CARDS.getData(i).setReady(true);
            }
        }
    }

    public boolean isTurn() {
        return turn;
    }
    
    public void startTurn(boolean b) {
        turn = b;
        drawCard();
        gui.turn.setEnabled(b);
        changeMana(mana.length, 4);
        changeMana(1, 1);
    }
    
    public boolean hasMana(int amount){
        int count = 0;
        for (int i = mana.length-1; i > 0; i--) {
            if (mana[i] == 2) {
                count++;
            }
        }
        System.out.println(amount <= count);
        return amount <= count;
    }
    
    /**
     * @param amount 
     * @param i 0 = drainFull, 1 = addFull, 2 = addEmpty, 3 = remove, 4 = fill empty
     */
    public void changeMana(int amount, int i){  
        
        boolean b = false;     
        for (int j = 0; j < amount; j++) {
            for (int k = mana.length-1; k > 0; k--) {
                if (i == 0) {
                    if (mana[k] == 2) {
                        mana[k] = 1;
                        gui.updateMana(k, 1);
                        break;
                    }
                }
                if (i == 1) {
                    if (mana[k] == 0) {
                        mana[k] = 2;
                        b = true;
                        gui.updateMana(k, 2);
                        break;
                    }
                }
                if (i == 2) {
                    if (mana[k] == 0) {
                        mana[k] = 1;
                        b = true;
                        gui.updateMana(k, 1);
                        break;
                    }
                }
                if (i == 3) {
                    mana[k] = 0;
                    gui.updateMana(k, 0);
                    break;
                }
                if(i == 4){
                    if (mana[k] == 1){ 
                        mana[k] = 2;
                        gui.updateMana(k, 2);
                        break;
                    }
                }
            }  
        }
        if(b) playerHand.addCard(new cards.DrawSpell());
        
    }
    
    

}
