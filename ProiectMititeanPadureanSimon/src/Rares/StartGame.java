package Rares;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartGame extends JFrame implements ActionListener
{
    MyPanel panel;
    JButton myButton =new JButton("Start");
    JButton myButton2 =new JButton("Continue");
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
        myButton2.setBounds(650,400,200,40);
        myButton2.setFocusable(false);
        myButton2.addActionListener(this);
        myButton2.setBackground(Color.pink);
        this.add(myButton2);
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
            int answer=JOptionPane.showConfirmDialog(null,"Daca selectezi aceasta varianta ,tot prograsul va fi sters","esti sigur?",JOptionPane.YES_NO_OPTION);

            if(answer==0)
            {
                this.dispose();
                Login login = new Login();
            }

        }
        if(e.getSource()==myButton2)
        {
                this.dispose();
                Login login = new Login();
        }

    }
}
