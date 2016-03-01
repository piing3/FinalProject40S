/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package space.game;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 * Project:
 * Author: Davin
 * Date: 29-Feb-2016
 * Teacher: Mr. Wachs 
 */
class Game extends JPanel{

    public Game() {    
        this.setLayout(null);
        this.setBounds(0, 0, Globals.WINDOW_WIDTH, Globals.WINDOW_HEIGHT);
        this.setBackground(Color.gray);
        this.addPlayer();
    }
    public void addPlayer(){
        JPanel player = new JPanel();
        player.setBackground(Color.blue);
        player.setBounds(0, 0, 100, 100);
        Globals.window.addArrowKeys(player);
        this.add(player);
//        for (int i = 0; i < Globals.window.getComponentCount(); i++) {
//            System.out.println(Globals.window.getKeyListeners().length);
//        }
    }


}
