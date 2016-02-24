package space.game;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Purpose: 
 * @Date
 * @author Davin
 * Teacher: Mr. Wachs
 */
class MainMenu extends JPanel{
        
    public MainMenu() {
        this.setLayout(null);
        this.setBounds(0, 0, Globals.WINDOW_WIDTH, Globals.WINDOW_HEIGHT);
        this.setBackground(Color.black);
        Globals.window.changeDisplay(this);
        
        makeButtons();
    }

    private void makeButtons() {
        JLabel base = new JLabel();
        base.setBackground(new Color(150, 150, 150, 100));
        base.setSize(400, Globals.WINDOW_HEIGHT);
        base.setLocation(Globals.WINDOW_WIDTH - base.getWidth(), 0);
        this.add(base);
        
        JButton play = new JButton("Play");
        play.setSize(350, 200);
        play.setLocation(25, 100);
        play.setBackground(Color.GREEN);
    }

}
