package Rares;

import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;

public class MyPanel extends JPanel
{
    Image image;
    MyPanel()
    {
        image=new ImageIcon("ProiectMititeanPadureanSimon/src/Rares/441133-12.jpg").getImage().getScaledInstance(2000,1000,Image.SCALE_DEFAULT);
        this.setPreferredSize(new Dimension(500,500));
    }
    public void paint(Graphics g)
    {
        Graphics2D g2D=(Graphics2D) g;
      //  g2D.setPaint(Color.blue);
       // g2D.setStroke(new BasicStroke(5));
        //g2D.drawLine(0,0,500,500);
       // g2D.drawRect(0,0,100,200);
        g2D.drawImage(image,0,0,null);

    }
}
