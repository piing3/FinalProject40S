package finalproject;

import cards.templates.Card;
import java.awt.Color;
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
        
    }
    

}
