/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visuals;

import finalproject.*;
import static finalproject.FinalProject.window;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;
import utillity.Settings;

/**
 * Project:
 * Author: Davin
 * Date: 15-Mar-2016
 * Teacher: Mr. Wachs 
 */
public class Window extends JFrame{
    
    public Window(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setUndecorated(false);
        
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int width  = (int) screenSize.getWidth();
            int height  = (int) screenSize.getHeight();
        if (Settings.fullscreen) {
            this.setBounds(0, 0, width, height);
            this.setUndecorated(true);
        }else{
            this.setSize(Settings.width, Settings.height);
            this.setLocation((width - this.getWidth())/2, (height - this.getHeight())/2);
        }
        
        
//        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
//        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
//        this.setCursor(blankCursor);
        

    }


    
}
