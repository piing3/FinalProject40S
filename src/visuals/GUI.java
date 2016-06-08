package visuals;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * Project:
 * Author: Davin
 * Date: 30-May-2016
 * Teacher: Mr. Wachs 
 */
public class GUI{
    
    public JButton turn;

    public GUI() {
        drawButton();
        testButton();
        turnButton();
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
        turn.setBounds(500, 99, 100, 50);
        turn.setEnabled(false);
        turn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                finalproject.FinalProject.battleManager.endTurn();
            }
        });
        finalproject.FinalProject.game.add(turn,0);
    }
}
