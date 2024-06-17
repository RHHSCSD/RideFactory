/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.ridefactory;

import apphelper.Sound;
import apphelper.Sprite;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author amirb
 */
public class GamePanel extends javax.swing.JPanel {
    
    //Create background sprite
    Sprite theBackground = new Sprite(0, 0, "images/Background.png", 1920, 1080);
    
    //Create car sprite
    Sprite car = new Sprite(55, 294, "images/3SeriesSideProfile.png", 799, 599);
    
    //Create button sprites
    Sprite engineeringButton = new Sprite(1020, 236, "images/Engineering.png", 418, 221);
    Sprite costCuttingButton = new Sprite(1020, 474, "images/Cost-Cutting.png", 418, 221);
    Sprite markupButton = new Sprite(1454, 236, "images/Markup.png", 418, 221);
    Sprite automationButton = new Sprite(1454, 474, "images/Automation.png", 418, 221);
    Sprite factoryClickedButton = new Sprite(70, 803, "images/FactoryPressed.png", 342, 127);
    Sprite designButton = new Sprite(511, 803, "images/Design.png", 342, 127);
    
    //Font
    Font customFont3;
    
    //For sharing information
    InformationStored in;
    
    
    /**
     * Creates new form GamePanel
     */
    public GamePanel(InformationStored infor) {
        initComponents();
        //Set preferred size of panel
        setPreferredSize(new Dimension(1920, 1080));
        //Set up info model
        in = infor;
        
        //Setting upgrade buttons invisible so that the image of the button shows through
        jButton1.setOpaque(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setBorderPainted(false);
        jButton2.setOpaque(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setBorderPainted(false);
        jButton3.setOpaque(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setBorderPainted(false);
        jButton4.setOpaque(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setBorderPainted(false);
        jButton5.setOpaque(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setBorderPainted(false);
        jButton6.setOpaque(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setBorderPainted(false);
        
        //Create info for game
        
        //Create cash object
        in.cash = new Cash(0);
        
        //Create upgrade objects
        in.engineering = new Engineering();
        in.costCutting = new CostCutting();
        in.markup = new Markup();
        in.automation = new Automation();
        
        //Create an ArrayList holding all the upgrades
        in.upgrades = new ArrayList(Arrays.asList(in.engineering, in.costCutting, in.markup, in.automation));
        
        //Create parts buttons
        in.body = new Body();
        in.engine = new Engine();
        in.suspension = new Suspension();
        in.wheels = new Wheels();
        
        //Create ArrayList holding parts
        in.parts = new ArrayList(Arrays.asList(in.body, in.engine, in.suspension, in.wheels));
        
        //Create timer for the automate upgrade
        //(Every second it gives you cash)
        in.timer = new Timer();
        in.autoClick = new TimerTask() {
            public void run() {
                in.automation.click(in.cash);
                jLabel1.setText("$" + in.cash.getCash());
            }
        };
        
        //Sets boosts and boost text
        switch (in.vinBoost) {
            case 1:
                jLabel2.setText("Your Boost: Precision Engineering");
                in.engineering.setLevel(2);
                break;
            case 2:
                jLabel2.setText("Your Boost: Government Loan");
                in.cash.addCash(500);
                break;
            case 3:
                jLabel2.setText("Your Boost: Smart Spending");
                in.costCutting.setLevel(2);
                break;
            case 4:
                jLabel2.setText("Your Boost: Mass Production");
                in.automation.setLevel(2);
                in.timer.schedule(in.autoClick, 0, 1000);
                break;
            case 5:
                jLabel2.setText("Your Boost: Status Symbol");
                in.markup.setLevel(2);
                break;
            default:
                break;
        }
        
        //Set Cash text
        jLabel1.setText("$" + in.cash.getCash());
        
        //Sets all the prices and levels text
        jLabel5.setText(""+in.engineering.getLevel());
        jLabel4.setText("$" + in.engineering.getPrice());
        jLabel6.setText("" + in.costCutting.getLevel());
        jLabel7.setText("$" + in.costCutting.getPrice());
        jLabel8.setText("" + in.markup.getLevel());
        jLabel9.setText("$" + in.markup.getPrice());
        jLabel10.setText("" + in.automation.getLevel());
        jLabel11.setText("$" + in.automation.getPrice());
        
        
        //Implementing font. Code adapted from https://stackoverflow.com/questions/5652344/how-can-i-use-a-custom-font-in-java
        final GraphicsEnvironment GE = GraphicsEnvironment.getLocalGraphicsEnvironment();
        try {
            final File fontFile = new File("fonts/Anonymous Pro B.ttf");
            customFont3 = Font.createFont(Font.TRUETYPE_FONT, fontFile);
            GE.registerFont(customFont3);
        } catch (FontFormatException | IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        //The code below sets the buttons and label font to the custom font with custom size
        if (customFont3 != null) {
            jLabel1.setFont(customFont3.deriveFont(Font.PLAIN, 54));
            jLabel2.setFont(customFont3.deriveFont(Font.PLAIN, 34));
            jLabel5.setFont(customFont3.deriveFont(Font.PLAIN, 34));
            jLabel6.setFont(customFont3.deriveFont(Font.PLAIN, 34));
            jLabel8.setFont(customFont3.deriveFont(Font.PLAIN, 34));
            jLabel10.setFont(customFont3.deriveFont(Font.PLAIN, 34));
            jLabel3.setFont(customFont3.deriveFont(Font.PLAIN, 26));
            jLabel4.setFont(customFont3.deriveFont(Font.PLAIN, 21));
            jLabel7.setFont(customFont3.deriveFont(Font.PLAIN, 21));
            jLabel9.setFont(customFont3.deriveFont(Font.PLAIN, 21));
            jLabel11.setFont(customFont3.deriveFont(Font.PLAIN, 21));
        } else {
            System.err.println("Custom font is null. Unable to set font.");
        }
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Drwas the background
        theBackground.draw(g);
        //Draws the car
        car.draw(g);
        //Draws all the buttons
        engineeringButton.draw(g);
        costCuttingButton.draw(g);
        markupButton.draw(g);
        automationButton.draw(g);
        factoryClickedButton.draw(g);
        designButton.draw(g);
    }
    
    //Getter for cash label so that partsPanel can set the cash label
    public JLabel getCashLabel() {
        return jLabel1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(1, 132, 69));
        jLabel1.setText("$0");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 150, -1, -1));

        jLabel2.setText("Your Boost: ");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 236, -1, -1));

        jLabel4.setForeground(new java.awt.Color(1, 132, 69));
        jLabel4.setText("jLabel4");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1284, 396, -1, -1));

        jLabel5.setText("jLabel4");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1312, 330, -1, -1));

        jLabel6.setText("jLabel6");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1312, 568, -1, -1));

        jLabel7.setForeground(new java.awt.Color(1, 132, 69));
        jLabel7.setText("jLabel4");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1284, 634, -1, -1));

        jLabel8.setText("jLabel4");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1746, 330, -1, -1));

        jLabel9.setForeground(new java.awt.Color(1, 132, 69));
        jLabel9.setText("jLabel4");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1718, 396, -1, -1));

        jLabel10.setText("jLabel6");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1746, 568, -1, -1));

        jLabel11.setForeground(new java.awt.Color(1, 132, 69));
        jLabel11.setText("jLabel4");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1718, 634, -1, -1));

        jButton1.setPreferredSize(new java.awt.Dimension(418, 221));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 236, -1, -1));

        jButton2.setPreferredSize(new java.awt.Dimension(418, 221));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 474, -1, -1));

        jButton3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton3.setMaximumSize(new java.awt.Dimension(418, 221));
        jButton3.setMinimumSize(new java.awt.Dimension(418, 221));
        jButton3.setPreferredSize(new java.awt.Dimension(418, 221));
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1454, 236, -1, -1));

        jButton4.setPreferredSize(new java.awt.Dimension(418, 221));
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1454, 474, -1, -1));

        jLabel3.setText("Let's get clicking!");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 722, -1, -1));

        jButton5.setMinimumSize(new java.awt.Dimension(342, 127));
        jButton5.setPreferredSize(new java.awt.Dimension(342, 127));
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(511, 803, -1, -1));

        jButton6.setPreferredSize(new java.awt.Dimension(781, 265));
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 457, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        //Do a "click" and update the cash counter
        in.cash.click();
        jLabel1.setText("$" + in.cash.getCash());
    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        //Check for the lowest level upgrade
        int lowestLevel = 2147483646;
        for (Upgrade u: in.upgrades) {
            lowestLevel = Math.min(u.getLevel(), lowestLevel);
        }
        
        //If player has enough cash and the upgrade is with 2 levels of the lowest level upgrade and max level hasn't been reached
        if (in.cash.getCash() >= in.engineering.getPrice() && in.engineering.getLevel() - lowestLevel < 2 && in.engineering.getLevel() < 10) {
            //Subtract the cash
            in.cash.subtractCash(in.engineering.getPrice());
            //Level up the upgrade
            in.engineering.levelUp();
            //Increase the effectiveness of automation and markup
            // (this is the ability of engineering)
            in.markup.effectivenessUp(in.engineering.getEffectiveness());
            in.automation.effectivenessUp(in.engineering.getEffectiveness());
            //Update labels
            jLabel5.setText("" + in.engineering.getLevel());
            jLabel4.setText("$" + in.engineering.getPrice());
            jLabel1.setText("$" + in.cash.getCash());
            //Load upgrade sound effect
            Sound upgradeSound = new Sound("audio/upgradeSound.wav");
            //Play sound effect for ugprade
            upgradeSound.start();
            //Reset message label
            jLabel3.setText("Let's get clicking!");
            
            //If upgrade has reached max level, change labels to reflect that
            if (in.engineering.getLevel() == 10) {
                jLabel5.setText("Max");
                jLabel4.setText("Max Level");
            }
            
            if (in.costCutting.getLevel() == 10) {
                jLabel6.setText("Max");
                jLabel7.setText("Max Level");
            }
            
            if (in.markup.getLevel() == 10) {
                jLabel8.setText("Max");
                jLabel9.setText("Max Level");
            }
            
            if (in.automation.getLevel() == 8) {
                jLabel10.setText("Max");
                jLabel11.setText("Max Level");
            }
            
            
        } else if (in.cash.getCash() >= in.engineering.getPrice() && in.engineering.getLevel() == 10) {
            jLabel3.setText("Max level reached.");
        } else if (in.cash.getCash() >= in.engineering.getPrice()) {
            jLabel3.setText("All your upgrades must be within 2 levels of eachother.");
        } else {
            jLabel3.setText("Not enough cash.");
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        //Check for the lowest level upgrade
        int lowestLevel = 2147483646;
        for (Upgrade u: in.upgrades) {
            lowestLevel = Math.min(u.getLevel(), lowestLevel);
        }
        
        //If the player has enough cash and the upgrade is within 2 levels of the lowest level upgrade and it hasn't reached max level
        if (in.cash.getCash() >= in.costCutting.getPrice() && in.costCutting.getLevel() - lowestLevel < 2 && in.costCutting.getLevel() < 10) {
            //Subtract the cash
            in.cash.subtractCash(in.costCutting.getPrice());
            //Level up the upgrade
            in.costCutting.levelUp();
            //Reduce the price of engineering, markup, and automation by its effectiveness
            // (this is the ability of cost cutting)
            in.engineering.priceDown(in.costCutting.getEffectiveness());
            in.markup.priceDown(in.costCutting.getEffectiveness());
            in.automation.priceDown(in.costCutting.getEffectiveness());
            //Update labels
            jLabel6.setText("" + in.costCutting.getLevel());
            jLabel7.setText("$" + in.costCutting.getPrice());
            jLabel1.setText("$" + in.cash.getCash());
            jLabel4.setText("$" + in.engineering.getPrice());
            jLabel9.setText("$" + in.markup.getPrice());
            jLabel11.setText("$" + in.automation.getPrice());
            //Load upgrade sound effect
            Sound upgradeSound = new Sound("audio/upgradeSound.wav");
            //Play sound effect for ugprade
            upgradeSound.start();
            //Reset message label
            jLabel3.setText("Let's get clicking!");
            
            //If upgrade has reached max level, change labels to reflect that
            if (in.engineering.getLevel() == 10) {
                jLabel5.setText("Max");
                jLabel4.setText("Max Level");
            }
            
            if (in.costCutting.getLevel() == 10) {
                jLabel6.setText("Max");
                jLabel7.setText("Max Level");
            }
            
            if (in.markup.getLevel() == 10) {
                jLabel8.setText("Max");
                jLabel9.setText("Max Level");
            }
            
            if (in.automation.getLevel() == 8) {
                jLabel10.setText("Max");
                jLabel11.setText("Max Level");
            }
            
        } else if (in.cash.getCash() >= in.costCutting.getPrice() && in.costCutting.getLevel() == 10) {
            jLabel3.setText("Max level reached.");
        } else if (in.cash.getCash() >= in.costCutting.getPrice()) {
            jLabel3.setText("All your upgrades must be within 2 levels of eachother.");
        } else {
            jLabel3.setText("Not enough cash.");
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        //Check for the lowest level upgrade
        int lowestLevel = 2147483646;
        for (Upgrade u: in.upgrades) {
            lowestLevel = Math.min(u.getLevel(), lowestLevel);
        }
        
        //If the player has enough cash and the upgrade is within 2 levels of the lowest level upgrade and it hasn't reached max level
        if (in.cash.getCash() >= in.markup.getPrice() && in.markup.getLevel() - lowestLevel < 2 && in.markup.getLevel() < 10) {
            //Subtract the cost
            in.cash.subtractCash(in.markup.getPrice());
            //Level up the upgrade
            in.markup.levelUp();
            //Increase the income of each click by the effectiveness of markup
            // (this is the ability of markup)
            in.cash.setIncome((int)((double)in.cash.getIncome()*( 1 + (0.01 * in.markup.getEffectiveness()))));
            //Update the labels
            jLabel8.setText("" + in.markup.getLevel());
            jLabel9.setText("$" + in.markup.getPrice());
            jLabel1.setText("$" + in.cash.getCash());
            //Load upgrade sound effect
            Sound upgradeSound = new Sound("audio/upgradeSound.wav");
            //Play sound effect for ugprade
            upgradeSound.start();
            //Reset message label
            jLabel3.setText("Let's get clicking!");
            
            //If upgrade has reached max level, change labels to reflect that
            if (in.engineering.getLevel() == 10) {
                jLabel5.setText("Max");
                jLabel4.setText("Max Level");
            }
            
            if (in.costCutting.getLevel() == 10) {
                jLabel6.setText("Max");
                jLabel7.setText("Max Level");
            }
            
            if (in.markup.getLevel() == 10) {
                jLabel8.setText("Max");
                jLabel9.setText("Max Level");
            }
            
            if (in.automation.getLevel() == 8) {
                jLabel10.setText("Max");
                jLabel11.setText("Max Level");
            }
            
        } else if (in.cash.getCash() >= in.markup.getPrice() && in.markup.getLevel() == 10) {
            jLabel3.setText("Max level reached.");
        } else if (in.cash.getCash() >= in.markup.getPrice()) {
            jLabel3.setText("All your upgrades must be within 2 levels of eachother.");
        } else {
            jLabel3.setText("Not enough cash.");
        }
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        //Check for the lowest level upgrade
        int lowestLevel = 2147483646;
        for (Upgrade u: in.upgrades) {
            lowestLevel = Math.min(u.getLevel(), lowestLevel);
        }
        
        //If the player has enough cash for the upgrade and hasn't reached max level
        if (in.cash.getCash() >= in.automation.getPrice() && in.automation.getLevel() < 8) {
            //Subtract the cost
            in.cash.subtractCash(in.automation.getPrice());
            //Level up the upgrade
            in.automation.levelUp();
            //set labels
            jLabel10.setText("" + in.automation.getLevel());
            jLabel11.setText("$" + in.automation.getPrice());
            jLabel1.setText("$" + in.cash.getCash());
            
            //Start the timer
            if (in.automation.getLevel() == 1) {
                in.timer.schedule(in.autoClick, 0, 1000);
            }
            
            //Load upgrade sound effect
            Sound upgradeSound = new Sound("audio/upgradeSound.wav");
            //Play sound effect for ugprade
            upgradeSound.start();
            //Reset message label
            jLabel3.setText("Let's get clicking!");
            
            //If upgrade has reached max level, change labels to reflect that
            if (in.engineering.getLevel() == 10) {
                jLabel5.setText("Max");
                jLabel4.setText("Max Level");
            }
            
            if (in.costCutting.getLevel() == 10) {
                jLabel6.setText("Max");
                jLabel7.setText("Max Level");
            }
            
            if (in.markup.getLevel() == 10) {
                jLabel8.setText("Max");
                jLabel9.setText("Max Level");
            }
            
            if (in.automation.getLevel() == 8) {
                jLabel10.setText("Max");
                jLabel11.setText("Max Level");
            }
        
        } else if (in.cash.getCash() >= in.markup.getPrice() && in.automation.getLevel() == 8) {
            jLabel3.setText("Max level reached.");
        } else if (in.cash.getCash() >= in.automation.getPrice()) {
            jLabel3.setText("All your upgrades must be within 2 levels of eachother.");
        } else {
            jLabel3.setText("Not enough cash.");
        }
    }//GEN-LAST:event_jButton4MouseClicked
    //If design button is clicked, switch to parts panel and set label to show cash
    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        JLabel cashLabelPartsPanel = in.partsPanel.getCashLabel();
        cashLabelPartsPanel.setText("$" + in.cash.getCash());
        CardLayout cl = (CardLayout) in.mainPanel.getLayout();
        cl.show(in.mainPanel, "parts");
    }//GEN-LAST:event_jButton5MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
