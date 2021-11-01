package Rares;

import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;

public class MyPanel2 extends JPanel
{
    Image image2;
    Image image3;
    MyPanel2()
    {
        image2=new ImageIcon("ProiectMititeanPadureanSimon/src/Rares/WhatsApp Image 2021-10-26 at 04.39.53.jpeg").getImage().getScaledInstance(700,800,Image.SCALE_DEFAULT);
        this.setPreferredSize(new Dimension(1600,1500));
        image3=new ImageIcon("ProiectMititeanPadureanSimon/src/Rares/nor.png").getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
    }
    public void paint(Graphics g)
    {
        Graphics2D g2D=(Graphics2D) g;

        //  g2D.setPaint(Color.blue);
        // g2D.setStroke(new BasicStroke(5));
        //g2D.drawLine(0,0,500,500);
        // g2D.drawRect(0,0,100,200);
        g2D.drawImage(image2,0,0,null);
        g2D.drawImage(image3,800,200,null);
        g2D.setPaint(Color.BLACK);
        g2D.setFont(new Font("Ink Free",Font.BOLD,20));
        g2D.drawString("Imi doresc sa ajung un informatician liber si fericit!",865,355);
        /*
        g2D.setPaint(Color.white);
        g2D.fillOval(680,50,100,100);
        g2D.setPaint(Color.white);
        g2D.fillOval(650,70,100,100);
        g2D.setPaint(Color.white);
        g2D.fillOval(650,70,100,100);
        g2D.setPaint(Color.white);
        g2D.fillOval(650,70,100,100);
        */


    }
}
