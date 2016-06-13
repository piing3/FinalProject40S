package visuals;

import utillity.Utill;
import finalproject.*;
import static finalproject.FinalProject.game;
import java.awt.Container;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Project:
 * Author: Davin
 * Date: 13-Apr-2016
 * Teacher: Mr. Wachs 
 */
public class Menu extends Container{

    public Menu() {
        this.setSize(FinalProject.window.getSize());
        this.setLocation(0, 0);
        makeBackground();
                
        FinalProject.game = new Game();
        
        JButton start = new JButton();        
        start.setSize(500, 532);
        start.setLocation((FinalProject.window.getWidth()/2) - start.getWidth()/2,
                          (FinalProject.window.getHeight()/2)- start.getHeight()/2);
        this.add(start,0);
        start.setText("Start");
        start.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                FinalProject.window.setContentPane(FinalProject.game);
                FinalProject.battleManager.refresh();
            }
        });
    }
    
    private void makeBackground() {
        JPanel background = new JPanel();
        background.setSize(this.getSize());
        background.setLocation(0, 0);
        background.setBackground(Utill.ORANGE_BROWN);
        this.add(background);
    }

    private JButton makeButton(Rectangle rectangle) {
        JButton button = new JButton();
        button.setBounds(rectangle);
        this.add(button,0);
        return button;
    }
}
