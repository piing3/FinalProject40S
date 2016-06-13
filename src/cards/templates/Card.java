package cards.templates;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

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
    protected String name;
    protected String text;
    
    private JLabel costLabel;
    private JLabel cardBackround;
    private JLabel cardImage;
    
    public static final int WIDTH = 100;
    public static final int HEIGHT = 160;
    
    
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
        costLabel.setText(""+this.cost);
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void cardPlayed(boolean b){//battlecry
        
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
    

    public void visuals() {
        
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(new Color(0, 0, 0, 0));
        this.setLayout(null);
        
        cardBackround = new JLabel();
        cardBackround.setIcon(new ImageIcon("src\\Images\\NeutralCardBackround.png"));
        cardBackround.setSize(this.getPreferredSize());
        cardBackround.setLocation(0, 0);
        this.add(cardBackround, 0);
        
        costLabel = new JLabel(""+this.cost);
        costLabel.setBounds(0, 7, 15, 10);
        costLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(costLabel,0);
        
        cardImage = new JLabel();
        cardImage.setIcon(new ImageIcon("src\\Images\\CardIcons\\TodoCardImage.png"));
        cardImage.setSize(69,69);
        cardImage.setLocation(16, 17);
        this.add(cardImage,0);
    }
    
    public void setBackround(ImageIcon icon){
        cardBackround.setIcon(icon);
    }
    
    public void setImage(ImageIcon icon){
        cardImage.setIcon(icon);
    }

    public void setTarget(Minion data) {
    }
}
