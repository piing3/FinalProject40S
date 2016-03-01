package space.game;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
        for (int i = 0; i < this.getComponentCount(); i++) {
            if (this.getComponent(i).equals(Globals.mainMenu)) Globals.window.remove(Globals.mainMenu);
            if (this.getComponent(i).equals(Globals.game)) Globals.window.remove(Globals.game);
        }
        this.add(display);
        Globals.window.repaint();
    }
    
    public void addArrowKeys(final JPanel player){
        KeyListener kl = new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyChar()+" = "+e.getKeyCode());
                if (e.getKeyCode() == 37) {//left
                    if(player.getX() > 0)player.setLocation(player.getX()-50, player.getY());
                }
                if (e.getKeyCode() == 38) {//up                                        
                    if(player.getY() > 0)player.setLocation(player.getX(), player.getY()-50);
                }
                if (e.getKeyCode() == 39) {//right
                    if(player.getX() < getWidth()-50) player.setLocation(player.getX()+50, player.getY()); 
                }
                if (e.getKeyCode() == 40) {//down
                    if(player.getY() < getHeight()-50) player.setLocation(player.getX(), player.getY()+50);     
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };
        this.addKeyListener(kl);
    }

}
