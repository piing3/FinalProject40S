package cards.templates;

import static cards.templates.Card.HEIGHT;
import static cards.templates.Card.WIDTH;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Purpose: 
 * @Date
 * @author Davin
 * Teacher: Mr. Wachs
 */
public abstract class Hero extends Minion{

    @Override
    public void visuals() {
        super.visuals();
        this.setSize(100, 100);
        this.setBackground(new Color(0, 0, 0, 0));
        this.setLayout(null);
        
        cardBackround.setVisible(false);
        costLabel.setVisible(false);
        
        attackLabel.setLocation(0, 80);
        healthLabel.setLocation(85, 80);
        
        
        cardImage.setSize(100, 100);
        cardImage.setLocation(0, 0);
        
    }
 
}
