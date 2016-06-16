package finalproject;

import cards.Memelord1;
import cards.Memelord2;
import cards.templates.Card;
import cards.templates.Hero;
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
    
    Hero pHero;
    Hero oHero;
    
    int target = -1;
    int attacker = -1;
    boolean targetPlayer = false;
    
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
    public String toString() {
        return super.toString();
    }
    // Visual--------------------------
    
    public void visuals(){
        this.setLayout(null);
        this.setBounds(0, 0, FinalProject.window.getWidth() - 165,
                FinalProject.window.getHeight() - (Card.HEIGHT+40));
        this.setBackground(utillity.Utill.TAN);
        FinalProject.game.add(this, 0);
        
        JLabel outlines = new JLabel(new ImageIcon("C:\\Users\\Davin\\Desktop\\FinalProject40S\\src\\Images\\BattleField.png"));
        outlines.setBounds(this.getBounds());
        this.add(outlines,0);
        
        O_Minions = new JPanel(new GridLayout(1, BattleField.MAX_SIZE));
        O_Minions.setBounds(0, 100, this.getWidth(), Card.HEIGHT);
        O_Minions.setBackground(new Color(0, 0, 0, 0));
        this.add(O_Minions,0);
        
        P_Minions = new JPanel(new GridLayout(1, BattleField.MAX_SIZE));
        P_Minions.setBounds(0, 100 + Card.HEIGHT, this.getWidth(), Card.HEIGHT);
        P_Minions.setBackground(new Color(0, 0, 0, 0));
        this.add(P_Minions,0);
        
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
        
        pHero = new Memelord1();
        pHero.setLocation(this.getWidth()/2 - 50, 100+ 2*(Card.HEIGHT));
        this.add(pHero,0);
        
        oHero = new Memelord1();
        oHero.setLocation(this.getWidth()/2 - 50, 0);
        this.add(oHero,0);
        
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
        
        if (e.getY() < P_Minions.getY()) {
            if (mX >= oHero.getX() && mX <= oHero.getX()+ oHero.getWidth()) {
                if(FinalProject.battleManager.canTarget(-2, false)) pickTarget(-2, false);
            }
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
            if (mX >= pHero.getX() && mX <= pHero.getX()+ pHero.getWidth()) {
                if(FinalProject.battleManager.canTarget(-2, true)) pickTarget(-2, true);
            }
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
        selected.setLocation(P_CARDS.getData(attacker).getX(), this.P_Minions.getY());
        selected.setVisible(true);
        FinalProject.game.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        System.out.println("Pick a target");
    }
    
    public void pickTarget(int target, boolean player){
        if (target == attacker && player) {
            attacker = -1;
            selected.setVisible(false);
            FinalProject.battleManager.refresh();
            return;
        }
                
        if (target == this.target && (targetPlayer == player)) {
            target = -1;
            targeted.setVisible(false);
            FinalProject.battleManager.gui.attack.setEnabled(false);
            FinalProject.game.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
            FinalProject.battleManager.refresh();
            return;
        }
                
        this.target = target;
        this.targetPlayer = player;
        if(player) {
            if(target == -2) targeted.setLocation(pHero.getLocation());
            else targeted.setLocation(P_CARDS.getData(target).getX(), this.P_Minions.getY());
        }
        else  {
            if(target == -2) targeted.setLocation(oHero.getLocation());
            else targeted.setLocation(O_CARDS.getData(target).getX(), this.O_Minions.getY());
        }
        targeted.setVisible(true);
        FinalProject.game.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        FinalProject.battleManager.gui.attack.setEnabled(true);
        
    }
}
