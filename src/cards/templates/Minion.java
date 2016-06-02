package cards.templates;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Purpose: 
 * @Date
 * @author Davin
 * Teacher: Mr. Wachs
 */
public abstract class Minion extends Card{
    
    protected int health;
    protected int attack;
    protected boolean ready;
    protected boolean shield;
    protected boolean charge;
    
    protected JLabel attackLabel = new JLabel(""+this.attack);;
    protected JLabel healthLabel = new JLabel(""+this.health);;

    
    
    public void cardAttack(){
        
    }
    
    public void cardAttacked(){
        
    }
    
    public void cardDie(){
        
    }
    
    
    // Utill -------------------------------------
    
    /**
     * Get the attack value
     * @return attack value
     */
    public int getAttack() {
        return attack;
    }
    
    /**
     * Gets the health value
     * @return the health value
     */
    public int getHealth() {
        return health;
    }
    
    /**
     * sets the attack value
     * @param attack 
     */
    public void setAttack(int attack) {
        this.attack = attack;
        attackLabel.setText(""+attack);
    }
    
    /**
     * Sets the health value
     * @param health 
     */
    public void setHealth(int health) {
        this.health = health;
        healthLabel.setText(""+health);
    }
    
    @Override
    public String toString() {
        return super.toString()+ ": attack - "+this.attack+", health - "
        +this.health;
    }

    public boolean equals(Minion minion) {
        if (this.attack != minion.attack) return false;
        if (this.cost != minion.cost) return false;
        if (this.health != minion.health) return false;
        if (this.type != minion.type) return false;
        if (!this.name.equals(minion.name)) return false;
        return true;
    }

    @Override
    public void visuals() {
        super.visuals();
        attackLabel = new JLabel(""+this.attack);
        attackLabel.setBounds(0, 84, 15, 10);
        attackLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(attackLabel,0);
        
        healthLabel = new JLabel(""+this.health);
        healthLabel.setBounds(85, 84, 15, 10);
        healthLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(healthLabel,0);
    }

    public boolean isCharge() {
        return charge;
    }

    public boolean isReady() {
        return ready;
    }

    public boolean isShield() {
        return shield;
    }

    public void attack() {
    }
    
    

    
    
}
