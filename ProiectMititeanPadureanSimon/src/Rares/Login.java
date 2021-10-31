package Rares;

import java.awt.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.*;

public class Login extends JFrame implements ActionListener
{
    MyPanel2 panell;
    JButton myButton =new JButton("START");
    JButton myButton2 =new JButton("Admin");
    JTextField textField= new JTextField();

    public Login()
    {
        panell=new MyPanel2();
        textField.setBounds(500,100,800,200);
       // textField.setPreferredSize(new Dimension(250,40));
        textField.setText("Toata viata mea nimeni nu a avut incredere in mine,le voi demonstra ca voi ajunge sa fiu fericit!!");
       /* label.setBounds(0, 0, 500, 50);
        label.setFont(new Font(null, Font.PLAIN, 25));
        frame.add(label);
        textField.setPreferredSize(new Dimension(250,40));
        textField2.setPreferredSize(new Dimension(250,40));
        textField.setText("username");
        textField2.setText("password");
        ///f.setContentPane(new Login().panel1);
        myButton.setBounds(100,160,200,40);
        myButton.setFocusable(false);
        myButton.addActionListener(this);
        myButton2.setBounds(100,160,200,40);
        myButton2.setFocusable(false);
        myButton2.addActionListener(this);
        frame.add(textField);
        frame.add(textField2);
        frame.add(myButton);
        frame.add(myButton2);*/
        myButton.setBounds(1200,700,200,40);
        myButton.setFocusable(false);
        myButton.addActionListener(this);
        this.add(textField);
        this.add(myButton);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(2000,850);
        ///frame.pack();
       // this.setLayout(new FlowLayout());
        this.add(panell);
        //frame.setResizable(false);
        //f.add(new JButton("press me!"));
        this.setVisible(true);

    }
    public static int pretScanduraCumparare=5;
    public static int pretScanduraVanzare=10;

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==myButton)
        {
            this.dispose();
        }
        if(e.getSource()==myButton2)
        {
            this.dispose();

        }
    }
}


