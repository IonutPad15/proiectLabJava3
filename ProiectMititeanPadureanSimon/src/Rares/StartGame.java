package Rares;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartGame extends JFrame implements ActionListener
{
    MyPanel panel;
    JButton myButton =new JButton("Start");
    public StartGame()
    {
        panel=new MyPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(20,10);
        myButton.setBounds(650,350,200,40);
        myButton.setFocusable(false);
        myButton.addActionListener(this);
        myButton.setBackground(Color.pink);
        this.add(myButton);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //this.setResizable(false);
    }
    public static void main(String[] args)
    {
       StartGame start =new StartGame();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==myButton)
        {
            this.dispose();
            Login login=new Login();

        }

    }
}
