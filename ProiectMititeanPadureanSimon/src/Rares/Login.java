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
    JButton myButton2 =new JButton("New Game");
    JTextField textField= new JTextField();

    public Login()
    {
        panell=new MyPanel2();
        textField.setBounds(900,500,500,170);
        textField.setPreferredSize(new Dimension(250,40));
        textField.setFont(new Font("Consolas",Font.PLAIN,35));
        textField.setText("Introduceti numele: ");
       // label.setBounds(0, 0, 500, 50);
        //label.setFont(new Font(null, Font.PLAIN, 25));
        //frame.add(label);
        //textField2.setPreferredSize(new Dimension(250,40));
        //textField.setText("username");
        //textField2.setText("password");
        ///f.setContentPane(new Login().panel1);
        this.setBackground(Color.white);
        myButton.setBounds(100,160,200,40);
        myButton.setFocusable(false);
        myButton.addActionListener(this);
        //myButton2.setBounds(100,160,200,40);
        //myButton2.setFocusable(false);
        //myButton2.addActionListener(this);
        this.add(textField);
        //frame.add(textField2);
        //frame.add(myButton);
        //frame.add(myButton2);
        myButton.setBounds(1150,700,250,60);
        //myButton2.setBounds(1000,700,200,40);
        myButton.setFocusable(false);
        myButton.addActionListener(this);
       // this.add(textField);
        this.add(myButton);
        //this.add(myButton2);
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


