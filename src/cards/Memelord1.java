package cards;

import cards.templates.Hero;
import javax.swing.ImageIcon;

/**
 * Purpose: 
 * @Date
 * @author Davin
 * Teacher: Mr. Wachs
 */
public class Memelord1 extends Hero{

    public Memelord1() {
        visuals();
        setImage(new ImageIcon("src\\Images\\heros\\Memelord1.png"));
        setHealth(30);
        setAttack(0);
    }

}
