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

    public GUI() {
        drawButton();
    }
    
    
    public void drawButton(){
        JButton jb = new JButton("Draw");
        jb.setBounds(58, 99, 50, 50);
        jb.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                finalproject.FinalProject.battleManager.drawCard();
            }
        });
        finalproject.FinalProject.game.add(jb,0);
    }
}
