package space.game;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Purpose: 
 * @Date
 * @author Davin
 * Teacher: Mr. Wachs
 */
class Window extends JFrame{

    public Window() {
        this.setSize(Globals.WINDOW_WIDTH, Globals.WINDOW_HEIGHT);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }

    void changeDisplay(JPanel display) {
        for (int i = 1; i < this.getComponentCount(); i++) {
            this.remove(this.getComponent(i));
        }
        this.add(display);
    }

}
