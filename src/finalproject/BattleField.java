package finalproject;

import cards.templates.Card;
import cards.templates.Minion;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import utillity.LinkedList;

/**
 * Project:
 * Author: Davin
 * Date: 26-May-2016
 * Teacher: Mr. Wachs 
 */
public class BattleField extends JPanel{// Needs to be recommented
    
    // Globals-----------------
    
    public static final int MAX_SIZE = 10; 
    public static final int START_SIZE = 3; 
    public final LinkedList<Minion> P_CARDS = new LinkedList<>();
    public final LinkedList<Minion> O_CARDS = new LinkedList<>();
    private JPanel P_Minions;
    private JPanel O_Minions;
    
    JLabel selected;
    JLabel targeted;
    
    int target = -1;
    int attacker = -1;
    boolean targetP = false;
    
    // Normal-----------------
    
    public BattleField() {
        visuals();
    }
    
    /**
     * Adds the given card to the hand.
     * 
     * Ends if the hand is full.
     * 
     * @param minion The card to add. 
     */
    public void addCard(Minion minion, boolean player){
        if (player) {
            if(!checkFull(player)){
                P_CARDS.addDataEnd(minion);
                P_Minions.add(minion, 0);
            }
        }
        else{
            if(!checkFull(player)){
                O_CARDS.addDataEnd(minion);
                O_Minions.add(minion, 0);
            }
        }
        
    }
    
    /**
     * Removes the given card from the hand.
     * @param card The card to remove
     */
    public void removeCard(Minion minion, boolean player){
        if (player) {
            P_CARDS.removeFirst(minion);
            P_Minions.remove(minion);
        }
        else{
            O_CARDS.removeFirst(minion);
            O_Minions.remove(minion);
        }

    }
    
    /**
     * Checks if the hand is full.
     * @return True if the hand is full.
     */
    public boolean checkFull(boolean player){
        if (player) return P_CARDS.getLength() >=  MAX_SIZE;
        else return O_CARDS.getLength() >=  MAX_SIZE;
        
    }
    
    // Utill--------------------------
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(BattleField bf) {
        for (int i = 0; i < MAX_SIZE; i++) {
            if(!this.P_CARDS.getData(i).equals(bf.P_CARDS.getData(i))) return false; 
            if(!this.O_CARDS.getData(i).equals(bf.O_CARDS.getData(i))) return false; 
        }
        return true; 
    }

    @Override
    public String toString() {//todo
        String string = "";
//        for (int i = 0; i < MAX_SIZE; i++) {
//            string += this.CARDS.getData(i).toString()+", ";
//        }
//        string = string.substring(0, string.length()-2);
        return string;
    }
    // Visual--------------------------
    
    public void visuals(){
        this.setLayout(new GridLayout(2, 1));
        this.setBounds(0, Card.HEIGHT+40, FinalProject.window.getWidth() - 165,
                FinalProject.window.getHeight() - (2*(Card.HEIGHT+40)));
        this.setBackground(utillity.Utill.TAN);
        FinalProject.game.add(this, 0);
        
        O_Minions = new JPanel(new GridLayout(1, BattleField.MAX_SIZE));
        O_Minions.setBounds(0, 0, this.getWidth(), Card.HEIGHT);
        O_Minions.setBackground(new Color(0, 0, 0, 0));
        this.add(O_Minions,0);
        
        P_Minions = new JPanel(new GridLayout(1, BattleField.MAX_SIZE));
        P_Minions.setBounds(0, Card.HEIGHT+20, this.getWidth(), Card.HEIGHT);
        P_Minions.setBackground(new Color(0, 0, 0, 0));
        this.add(P_Minions,1);
        
        selected = new JLabel();
        selected.setSize(Card.WIDTH,Card.HEIGHT);
        selected.setIcon(new ImageIcon("src\\Images\\CardSelected.png"));
        selected.setVisible(false);
        finalproject.FinalProject.game.add(selected,0);
        
        targeted = new JLabel();
        targeted.setSize(Card.WIDTH,Card.HEIGHT);
        targeted.setIcon(new ImageIcon("src\\Images\\CardTargeted.png"));
        targeted.setVisible(false);
        finalproject.FinalProject.game.add(targeted,0);
        
        MouseListener listener = new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                checkClick(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };
        this.addMouseListener(listener);
    }
     
    private void checkClick(MouseEvent e){
        int mX = e.getX();
        
        if (FinalProject.battleManager.forceTarget) {
            
        }
        
        if (e.getY() < Card.HEIGHT) {
            for (int i = 0; i < O_CARDS.getLength(); i++) {
                if (O_CARDS.getData(i) != null) {
                    if (mX >= O_CARDS.getData(i).getX() && mX <= O_CARDS.getData(i).getX()+ Card.WIDTH) {
                       if(FinalProject.battleManager.canTarget(i, false)) pickTarget(i, false);
                       else attacker = -1;
                       break;
                    }
                }
            }
        }
        
        else{
            for (int i = 0; i < P_CARDS.getLength(); i++) {
                if (P_CARDS.getData(i) != null) {
                    if (mX >= P_CARDS.getData(i).getX() && mX <= P_CARDS.getData(i).getX()+ Card.WIDTH) {   
                        if(FinalProject.battleManager.canTarget(i, true)) pickTarget(i, true);
                        else if(FinalProject.battleManager.canAttack(i))pickAttacker(i);
                    }
                }
            }
        }
    }
    
    public void pickAttacker(int attacker){
        this.attacker = attacker;
        selected.setLocation(P_CARDS.getData(attacker).getX(), this.P_Minions.getY()+ Card.HEIGHT +50);
        selected.setVisible(true);
        FinalProject.game.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        System.out.println("Pick a target");
    }
    
    public void pickTarget(int target, boolean b){
        if (target == attacker && b) {
            attacker = -1;
            selected.setVisible(false);
            FinalProject.battleManager.refresh();
            return;
        }
                
        if (target == this.target && (!targetP == b)) {
            target = -1;
            targeted.setVisible(false);
            FinalProject.battleManager.gui.attack.setEnabled(false);
            FinalProject.game.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
            FinalProject.battleManager.refresh();
            return;
        }
                
        this.target = target;
        this.targetP = b;
        if(b) targeted.setLocation(P_CARDS.getData(target).getX(), this.P_Minions.getY()+ Card.HEIGHT +50);
        else  targeted.setLocation(O_CARDS.getData(target).getX(), this.O_Minions.getY()+ Card.HEIGHT +50);
        targeted.setVisible(true);
        FinalProject.game.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        FinalProject.battleManager.gui.attack.setEnabled(true);
        
    }
}
