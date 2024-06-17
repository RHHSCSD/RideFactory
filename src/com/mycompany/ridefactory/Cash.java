/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ridefactory;

/**
 *
 * @author amirb
 */
public class Cash {
    //Variables for holding the value for money and income
    
    //Money is the money that the player is holding
    private long money;
    //Income is how much the player makes per click
    private long income;
    
    //Constructor. Allows for starting amount to be entered
    public Cash(int cash) {
        money = cash;
        income = 5;
    }
    
    //Getters for money and income
    public long getCash() {
        return money;
    }
    
    public long getIncome() {
        return income;
    }
    
    //Setter for money and income
    public void setCash(long amt) {
        money = amt;
    }
    
    public void setIncome(long amt) {
        income = amt;
    }
    
    //Adds amount to money
    public void addCash(int cash) {
        money += cash;
    }
    
    //Removes amount from money
    public void subtractCash(int cash) {
        money -= cash;
    }
    
    //Adds to income
    public void addIncome(int cash) {
        income += cash;
    }
    
    //Removes from income
    public void subtractIncome(int cash) {
        income -= cash;
    }
    
    //Increases income by a percent  amount
    public void percentIncome(int percent) {
        income *= (int)(1 + ((double)0.01*percent));
    }
    
    
    //Method for clicks. For each click, you add income to money
    public void click() {
        money += income;
    }
    
    //Starts a frenzy sale. 10x your earning during this period.
    public void frenzySaleStart() {
        income *= 10;
    }
    
    //Ends the frenzy sale and returns income to normal
    public void frenzySaleEnd() {
        income /= 10;
    }
}
