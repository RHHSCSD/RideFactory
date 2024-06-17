/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ridefactory;

/**
 *
 * @author amirb
 */
public interface Upgrade {
    //Getters for level, effectiveness, and price
    public int getLevel();
    public int getEffectiveness();
    public int getPrice();
    //Setters
    public void setPrice(int amount);
    public void setLevel(int amount);
    public void setEffectiveness(int amount);
    //Function that defines how the upgrade levels up
    public void levelUp();
    //Increases the effectiveness by a percent amount
    public void effectivenessUp(int percent);
    //Reduces the price by a percent amount
    public void priceDown(int percent);
    //Increases the price by a percent amount
    public void priceUp(int percent);
}
