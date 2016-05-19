package visuals;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 * Project:
 * Author: Davin
 * Date: 18-Apr-2016
 * Teacher: Mr. Wachs 
 */
public class Card extends JPanel{

    cards.templates.Card card;
    
    ImageIcon cardBackround;
    ImageIcon cardImage;
    CardLarge cardLarge;
    public static final int WIDTH = 100;
    public static final int HEIGHT = 160;
    
    public Card(final cards.templates.Card card) {
        this.card = card;
        //this.cardLarge = new CardLarge(this);
        
        this.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                card.cardPlayed();
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                //hoverCard();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //cardLarge.setVisible(false);
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
    
    private void hoverCard() {
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        cardLarge.setVisible(true);
                    }
                });
            }
        };

        java.util.Timer timer = new java.util.Timer(true);
        timer.schedule(task, 1000);
    }
}
