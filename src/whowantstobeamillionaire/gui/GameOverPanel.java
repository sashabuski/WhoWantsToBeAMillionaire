/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whowantstobeamillionaire.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Admin
 */
public class GameOverPanel extends JPanel{
   
    JTextArea winnings;
    JButton backToMain;
    Image bgImage;   
    Font customFont;
   
    public GameOverPanel() throws FontFormatException{
       
        try {
    
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("Commodore Rounded v1.2.ttf")).deriveFont(12f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            
            ge.registerFont(customFont);
            } catch (IOException e) {
                e.printStackTrace();
            }   
        try{
             bgImage = ImageIO.read(new File("gameoverbg.png"));
             } catch(Exception e){e.printStackTrace();}
        
        winnings = new JTextArea("You finished with: $");
        winnings.setBounds(130, 300, 140, 50);
        winnings.setBackground(new Color(47, 59, 64));
        winnings.setForeground(new Color(168, 221, 255));
        winnings.setFont(customFont);
        winnings.setWrapStyleWord(true);
        winnings.setLineWrap(true);
        backToMain = new JButton("BACK TO MAIN");
        backToMain.setBounds(125, 500, 150, 30);
        this.backToMain.setBackground(new Color(15, 60, 139));
        this.backToMain.setForeground(new Color(168, 221, 255));
        this.backToMain.setFont(customFont);
        setLayout(null);
        add(winnings);
        add(backToMain);
}
   
    protected void paintComponent(Graphics g) {

    super.paintComponent(g);
        g.drawImage(bgImage, 0, 0, null);
}
}