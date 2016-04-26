package Visuals;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

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
    CardLarge cardLarge;
    public static final int WIDTH = 100;
    public static final int HEIGHT = 160;
    
    public Card(final finalproject.Card card) {
        this.card = card;
        
        this.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                Timer timer = new Timer(1000, new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (cardLarge == null) {
                            cardLarge = new CardLarge(card);
                        }
                        cardLarge.setVisible(true);
                    }
                });
                timer.start();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                cardLarge.setVisible(false);
            }
        });
        
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
