/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ridefactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TimerTask;
import java.util.Timer;
import javax.swing.JPanel;

/**
 *
 * @author amirb
 */
public class InformationStored {
    Cash cash;
    
    Engineering engineering;
    Markup markup;
    CostCutting costCutting;
    Automation automation;
    
    ArrayList<Upgrade> upgrades;
    
    Body body;
    Engine engine;
    Suspension suspension;
    Wheels wheels;
    
    ArrayList<Parts> parts;
    
    Timer timer;
    TimerTask autoClick;
    
    JPanel mainPanel;
    
    //1 is Precision Engineering
    //2 is Government Loan
    //3 is Smart Spending
    //4 is Mass Production
    //5 is Status Symbol
    int vinBoost;
    
    PartsPanel partsPanel;
    GamePanel gamePanel;
}
