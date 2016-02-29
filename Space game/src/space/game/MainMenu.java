package space.game;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        
        makeButtons();
    }

    private void makeButtons() {
        JPanel base = new JPanel();
        base.setSize(Globals.WINDOW_WIDTH/5, Globals.WINDOW_HEIGHT/2);
        base.setLocation(Globals.WINDOW_WIDTH - base.getWidth(), Globals.WINDOW_HEIGHT/8);
        base.setBackground(new Color(0, 0, 0, 0));
        base.setLayout(new GridLayout(4, 1, 0, 10));
        this.add(base);
        
        JButton play = new JButton("Play");
        play.setBackground(Color.GREEN);
        base.add(play);
        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SpaceGame.newGame();
            }
        });
        
        JButton load = new JButton("Load");
        load.setBackground(Color.cyan);
        base.add(load);
        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SpaceGame.loadGame();
            }
        });
        
        JButton options = new JButton("Options");
        options.setBackground(Color.gray);
        base.add(options);
        options.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SpaceGame.options();
            }
        });
        
        JButton exit = new JButton("Exit");
        exit.setBackground(Color.red);
        base.add(exit);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SpaceGame.exit();
            }
        });
        
    }

}
