package Rares;

import java.awt.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.*;

import Ionut.GUI.MeniuPrincipal;
import Ionut.classes.ScriereFisier;

public class Login extends JFrame implements ActionListener
{
    MyPanel2 panell;
    JButton myButton =new JButton("START");
    JTextField textField= new JTextField();
    JTextField textFieldnume= new JTextField();
    JLabel label= new JLabel();
    public Login()
    {
        panell=new MyPanel2();
        label.setText("Introduceti numele: ");
        textField.setBounds(1100,500,300,120);
        textField.setPreferredSize(new Dimension(250,40));
        textField.setFont(new Font("Consolas",Font.PLAIN,35));
        textField.setText("");
        label.setBounds(890,470,500,170);
        label.setFont(new Font(null, Font.PLAIN, 25));
        this.add(label);
        //textField2.setPreferredSize(new Dimension(250,40));
        //textField.setText("username");
        //textField2.setText("password");
        ///f.setContentPane(new Login().panel1);
        this.setBackground(Color.white);
        myButton.setBounds(120,160,200,40);
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
        String s = textField.getText();
        System.out.println(s);

    }
    public static int pretScanduraCumparare=5;
    public static int pretScanduraVanzare=10;
    private void newgame()
    {
        ScriereFisier sc = new ScriereFisier();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate ld = LocalDate.now();
        String s = textField.getText();
        //System.out.println(s);
        sc.scriereFisier("ProiectMititeanPadureanSimon/src/Ionut/resources/Data",formatter.format(ld) +"","succes","eorare");
        sc.scriereFisier("ProiectMititeanPadureanSimon/src/Ionut/resources/HomeData",formatter.format(ld) +"","succes","eorare");
        sc.scriereFisier("ProiectMititeanPadureanSimon/src/Ionut/resources/MeseriiData",formatter.format(ld) +"","succes","eorare");
        sc.scriereFisier("ProiectMititeanPadureanSimon/src/Ionut/resources/Bani.txt",1000,"succes","eroare");
        sc.scriereFisier("ProiectMititeanPadureanSimon/src/Ionut/resources/HH.txt",50,"succes","eroare");
        sc.scriereFisier("ProiectMititeanPadureanSimon/src/Ionut/resources/Meserii",0,"succes","eroare");
        sc.scriereFisier("ProiectMititeanPadureanSimon/src/Ionut/resources/Studii",0,"succes","eroare");
        sc.scriereFisier("ProiectMititeanPadureanSimon/src/Ionut/resources/Nume",s,"succes","eroare");
        sc.scriereFisier("ProiectMititeanPadureanSimon/src/Ionut/resources/Home",0,"succes","eroare");
        MeniuPrincipal.start();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==myButton)
        {
            newgame();
            this.dispose();

        }
    }
}



