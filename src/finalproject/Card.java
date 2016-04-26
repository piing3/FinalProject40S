/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finalproject;

import java.awt.Image;

/**
 * Project:
 * Author: Davin
 * Date: 6-Apr-2016
 * Teacher: Mr. Wachs 
 */
public class Card{

    // Global-----------------
    
    private int health;
    private int attack;
    private int cost;
    private int type;
    private Image image;
    private String name;
    
    
    // Normal-----------------
    
    /**
     * Makes a new blank card
     */
    public Card() {
        health = 0;
        attack = 0;
        cost = 0;
        type = 0;
        image = null;
        name = "";
    }

    /**
     * Makes a new card with the given stats.
     * @param health
     * @param attack
     * @param cost
     * @param type
     * @param image
     * @param name 
     */
    public Card(int health, int attack, int cost, int type, Image image, String name) {
        this.health = health;
        this.attack = attack;
        this.cost = cost;
        this.type = type;
        this.image = image;
        this.name = name;
    }
    
    /**
     * Get the attack value
     * @return attack value
     */
    public int getAttack() {
        return attack;
    }

    /**
     * Gets the cost value
     * @return the cost value
     */
    public int getCost() {
        return cost;
    }
    
    /**
     * Gets the health value
     * @return the health value
     */
    public int getHealth() {
        return health;
    }

    /**
     * Gets the type value
     * @return the type value
     */
    public int getType() {
        return type;
    }
    
    public void cardPlayed(){}
    
    public void cardDrawn(){}
    
    // Utill---------------------

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Card card) {
        if (this.attack != card.attack) return false;
        if (this.cost != card.cost) return false;
        if (this.health != card.health) return false;
        if (this.type != card.type) return false;
        if (!this.name.equals(card.name)) return false;
        return true;
    }

    @Override
    public String toString() {
        return this.name+": attack - "+this.attack+", health - "
            +this.health+", cost - "+this.cost+", type - "+this.type;
    }
}
