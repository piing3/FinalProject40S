package visuals;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Project:
 * Author: Davin
 * Date: 26-Apr-2016
 * Teacher: Mr. Wachs 
 */
class CardLarge extends JPanel{

    visuals.Card card;
    
    ImageIcon cardBackround;
    ImageIcon cardImage;
    public static final int WIDTH = 100;
    public static final int HEIGHT = 160;
    
    CardLarge(visuals.Card card) {
        Point point = card.getLocation();
        this.setLocation(point.x - 100, point.y - 150);
        this.setSize(200, 300);
        this.cardBackround = new ImageIcon("src\\Images\\NeutralCardBackroundLarge.png");
        finalproject.FinalProject.game.add(this, 0);
    }
    

}
