package Visuals;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Project:
 * Author: Davin
 * Date: 18-Apr-2016
 * Teacher: Mr. Wachs 
 */
public class Card extends JPanel{

    finalproject.Card card;
    
    ImageIcon cardBackround;
    ImageIcon cardImage;
    public static final int WIDTH = 100;
    public static final int HEIGHT = 160;
    
    public Card(finalproject.Card card) {
        this.card = card;
        
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(new Color(0, 0, 0, 0));
        
        cardBackround = new ImageIcon("src\\Images\\NeutralCardBackround.png");
        JLabel backround = new JLabel();
        backround.setIcon(cardBackround);
        backround.setPreferredSize(this.getPreferredSize());
        backround.setLocation(0, 00);
        this.add(backround, 0);
        
//        cardImage = new ImageIcon("src\\Images\\BlankCardImage.png");
//        JLabel image = new JLabel(cardImage);
//        image.setSize(this.getSize());
//        image.setLocation(0, 0);
//        this.add(image);
        
    }
}
