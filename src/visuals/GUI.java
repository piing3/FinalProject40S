package visuals;

import cards.templates.Card;
import finalproject.FinalProject;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import utillity.Utill;

/**
 * Project:
 * Author: Davin
 * Date: 30-May-2016
 * Teacher: Mr. Wachs 
 */
public class GUI{
    
    public JButton turn;
    public JButton attack;
    private JPanel base;
    
    private JLabel[] mana = new JLabel[10];

    public GUI() {
        base();
        //drawButton();
        //testButton();
        turnButton();
        attackButton();
        mana();
    }
    
    
    public void drawButton(){
        JButton jb = new JButton("Draw");
        jb.setBounds(58, 99, 100, 50);
        jb.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                finalproject.FinalProject.battleManager.drawCard();
            }
        });
        finalproject.FinalProject.game.add(jb,0);
    }
    
    public void testButton(){
        JButton test = new JButton("Test");
        test.setBounds(200, 99, 100, 50);
        test.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                finalproject.FinalProject.battleManager.testing();
            }
        });
        finalproject.FinalProject.game.add(test,0);
    }
    
    public void turnButton(){
        turn =  new JButton("End Turn");
        turn.setBounds(0, base.getHeight()/2-25, base.getWidth(), 50);
        turn.setEnabled(false);
        turn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                finalproject.FinalProject.battleManager.endTurn();
            }
        });
        base.add(turn,0);
    }
    
    public void attackButton(){
        attack =  new JButton("Attack");
        attack.setBounds(0, turn.getY() + 60, base.getWidth(), 50);
        attack.setEnabled(false);
        attack.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                finalproject.FinalProject.battleManager.attack();
            }
        });
        base.add(attack,0);
    }
    
    public void base(){
        base =  new JPanel();
        base.setLayout(null);
        base.setBounds(FinalProject.window.getWidth()-165, Card.HEIGHT + 40, 150, FinalProject.window.getHeight() - (2*(Card.HEIGHT+40)));
        base.setBackground(Color.gray);
        finalproject.FinalProject.game.add(base,0);
    }

    private void mana() {
        JPanel manaBase = new JPanel();
        manaBase.setBounds(0, base.getHeight()-(base.getWidth()/mana.length), base.getWidth(), base.getWidth()/mana.length);
        manaBase.setLayout(new GridLayout(1, mana.length));
        base.add(manaBase);
        for (int i = 0; i < mana.length; i++) {
            mana[i] = new JLabel();
            manaBase.add(mana[i]);
            mana[i].setIcon(new ImageIcon(""));
        }
    }

    public void updateMana(int index, int value) {
        if (value == 0) {
            mana[index].setIcon(new ImageIcon(""));
        }
        if (value == 1) {
            mana[index].setIcon(new ImageIcon("src\\Images\\ManaIcons\\Empty.png"));
        }
        if (value == 2) {
            mana[index].setIcon(new ImageIcon("src\\Images\\ManaIcons\\Filled.png"));
        }
        base.repaint();
        base.validate();
    }
    
    
}
