package finalproject;

import cards.templates.Card;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Project:
 * Author: Davin
 * Date: 26-May-2016
 * Teacher: Mr. Wachs 
 */
public class BattleField extends JPanel{

    public BattleField() {
        this.setLayout(null);
        this.setBounds(0, Card.HEIGHT+40, FinalProject.window.getWidth(),
                FinalProject.window.getHeight() - (2*(Card.HEIGHT+40)));
        this.setBackground(utillity.Utill.TAN);
        FinalProject.game.add(this, 0);
        
        JButton jb = new JButton("Draw");
        jb.setBounds(58, 99, 50, 50);
        jb.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                FinalProject.battleManager.drawCard();
            }
        });
        this.add(jb);
        
    }
    

}
