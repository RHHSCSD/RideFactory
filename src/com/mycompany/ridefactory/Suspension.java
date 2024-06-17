/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ridefactory;

/**
 *
 * @author amirb
 */
public class Suspension implements Parts{
    //Variables
    //Int value that defines what type of part it is (Economy, Sport, Big).
    //Type 1 is Economy
    //Type 2 is Sport
    //Type 3 is Big
    private int type;
    //Holds the value for the price of the upgrade
    private int price;
    
    //Constructor for body. Sets price at 1000
    public Suspension() {
        price = 1000;
    }
    
    //Gets the type of part (economy, sport, big)
    @Override
    public int getType() {
        return type;
    }
    
    //Sets the type of part (economy, sport, big)
    @Override
    public void setType(int option) {
        type = option;
    }
    
    //Gets price of the part
    @Override
    public int getPrice() {
        return price;
    }
    
    
    
}
