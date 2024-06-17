/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ridefactory;

/**
 *
 * @author amirb
 */
public class Markup implements Upgrade {
    //Variables
    //The level that the upgrade is at
    private int level;
    //Holds percent value for how much more effective it is. Can be increased by upgrades
    private int percentEffectiveness;
    //Holds percent value for how much the cost of the upgrade is reduced by. Increased by upgrades
    private int percentPrice;
    //Holds value for price of the upgrade
    private int price;
    
    //Constructor that allows to choose starting level
    public Markup() {
        level = 0;
        price = 175;
        percentPrice = 0;
        percentEffectiveness = 0;
    }
    
    //Getter for level
    @Override
    public int getLevel() {
        return level;
    }
    
    //Getter for effectiveness
    @Override
    public int getEffectiveness() {
        return percentEffectiveness;
    }
    
    //Getter for price
    @Override
    public int getPrice() {
        return price;
    }
    
    //Setter for price
    @Override
    public void setPrice(int amount) {
        price = amount;
    }
    
    //Setter for level
    @Override
    public void setLevel(int amount) {
        level = amount;
        effectivenessUp(10 * amount);
    }
    
    //Setter for effectiveness
    @Override
    public void setEffectiveness(int amount) {
        level = amount;
    }
    
    
    //This method is used to increase the level of the upgrade. Higher level
    //means it becomes more effective while also costing more
    @Override
    public void levelUp() {
        level += 1;
        effectivenessUp(20);
        priceUp(100 - percentPrice);
    }
    
    //Adds a percent amount to how effective the upgrade is.  This comes from other upgrades
    //that can make upgrades more effective (E.x. Sports car parts make Engineering
    //more effective)
    @Override
    public void effectivenessUp(int percent) {
        percentEffectiveness += percent;
    }
    
    //Adds a percent value to how much less the price of the upgrade becomes. This is used 
    //by other upgrades
    @Override
    public void priceDown(int percent) {
        percentPrice += percent;
        price = (int)((double)price*(1-(0.01*percent)));
    }
    
    //This increases the price of the upgrade by a percent amount.
    @Override
    public void priceUp(int percent) {
        price = (int)((double)price*(1 + (0.01 * percent)));
    }
    
}
