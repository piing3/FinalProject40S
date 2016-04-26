/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Visuals;

import finalproject.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

/**
 * Project:
 * Author: Davin
 * Date: 15-Mar-2016
 * Teacher: Mr. Wachs 
 */
public class Game extends Container{
    
    public Game() {
        this.setSize(FinalProject.window.getWidth() - 15, FinalProject.window.getHeight()- 40);
        this.setLocation(0, 0);
        this.setLayout(null);
        makeBackground();
        
        KeyListener kl = new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };
        this.addKeyListener(kl);
    }

    private void makeBackground() {
        JPanel background = new JPanel();
        background.setSize(this.getSize());
        background.setLocation(0, 0);
        background.setBackground(Utill.BROWN);
        this.add(background);
    }

}
