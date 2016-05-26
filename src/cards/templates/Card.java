package cards.templates;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Project:
 * Author: Davin
 * Date: 6-Apr-2016
 * Teacher: Mr. Wachs 
 */
public abstract class Card extends JPanel implements Serializable{

    // Global-----------------
    
    protected int cost;
    protected int type;
    protected Image image;
    protected String name;
    protected String text;
    
    
    // Normal-----------------
    
    /**
     * Gets the cost value
     * @return the cost value
     */
    public int getCost() {
        return cost;
    }

    /**
     * Gets the type value
     * @return the type value
     */
    public int getType() {
        return type;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void cardPlayed(){//battlecry
        
    }
    
    public void cardDrawn(){//draw effect
    
    }
    
    public void cardPlayInterupt(){
        
    }
    
    public void cardDrawInterupt(){
        
    }
    
    public void cardAttackInterupt(){
        
    }
    
    public void cardDieInterupt(){
        
    }
    
    // Utill---------------------

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Card card) {
        if (this.cost != card.cost) return false;
        if (this.type != card.type) return false;
        if (!this.name.equals(card.name)) return false;
        return true;
    }

    @Override
    public String toString() {
        return this.name+", cost - "+this.cost+", type - "+this.type;
    }
    
    // Visuals--------------------
    
    ImageIcon cardBackround;
    ImageIcon cardImage;
    public static final int WIDTH = 100;
    public static final int HEIGHT = 160;
    
    public void visuals() {
        
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
