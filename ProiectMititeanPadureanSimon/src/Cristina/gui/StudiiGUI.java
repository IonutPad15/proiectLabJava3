package Cristina.gui;

import Cristina.Casa;
import Cristina.Studii;
import Ionut.GUI.Hh;
import Ionut.GUI.MeniuPrincipal;
import Ionut.GUI.Meseriigui;
import Ionut.classes.CitireFisier;
import Ionut.classes.LifeSimulator;
import Ionut.classes.ScriereFisier;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StudiiGUI extends CitireFisier
{
    private JPanel panelHh;
    private JButton buton1;
    private JLabel labeldescriere1;
    private JLabel labeldescriere2;
    private JButton buton2;
    private JLabel labeldescriere3;
    private JButton buton3;
    private JLabel labeldescriere4;
    private JButton buton4;
    private JLabel labeldescriere5;
    private JButton buton5;
    private JPanel panelStatus;
    private JLabel labelNume;
    private JLabel iconHh;
    private JLabel labelHh;
    private JLabel iconBani;
    private JLabel labelBani;
    private JLabel labelData;
    private JButton butonInapoi;
    private JLabel labelprocent5;
    private JLabel labelprocent4;
    private JLabel labelprocent3;
    private JLabel labelprocent2;
    private JLabel labelprocent1;
    private JLabel labelpret1;
    private JLabel labelpret3;
    private JLabel labelpret4;
    private JLabel labelpret5;
    private JLabel labelpret2;
    private LifeSimulator ls = LifeSimulator.getInstance();
    private MeniuPrincipal mp = MeniuPrincipal.getInstance();
    private static StudiiGUI _instance;
    private Studii[] studii =ls.getStudii();
    private int index;
    private JFrame jFrame;
    DateTimeFormatter formatter;
    LocalDate ld ;
    private StudiiGUI()
    {
        prepareFrame();
    }
    public static StudiiGUI getInstance()
    {
        if(_instance == null) _instance = new StudiiGUI();
        return _instance;
    }
    private void prepareFrame()
    {
        index = citireFisierInt("ProiectMititeanPadureanSimon/src/Ionut/resources/Studii","succes","eroare");
        jFrame = new JFrame("Education");
        jFrame.setContentPane(panelHh);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setSize(550, 300);
        jFrame.setLocation(650, 250);
        jFrame.setVisible(false);
        jFrame.setResizable(false);
        jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        String s  = mp.getLabelData().getText();
        labelData.setText("");
        ImageIcon img = new ImageIcon(new ImageIcon("ProiectMititeanPadureanSimon/src/Ionut/resources/Hh.png").getImage().getScaledInstance(75,55, Image.SCALE_DEFAULT));
        iconHh.setIcon(img);
        img = new ImageIcon(new ImageIcon("ProiectMititeanPadureanSimon/src/Ionut/resources/moneyIcon.png").getImage().getScaledInstance(75,65,Image.SCALE_DEFAULT));
        iconBani.setIcon(img);
        setTextLabels();
        buton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                activare(index);
                enablebutoane(index);

            }
        });
        buton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                activare(index);
                enablebutoane(index);

            }
        });
        buton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                activare(index);
                enablebutoane(index);

            }
        });
        buton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                activare(index);
                enablebutoane(index);

            }
        });
        buton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                activare(index);
                enablebutoane(index);

            }
        });
    }
    private void setTextLabels()
    {
        String s= studii[0].getDescriere();
        labeldescriere1.setText(("<html>" + s.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>"));
        int p= studii[0].getPret();
        labelpret1.setText(""+p);
        s= studii[1].getDescriere();
        labeldescriere2.setText(("<html>" + s.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>"));
        p= studii[1].getPret();
        labelpret2.setText(""+p);
        s= studii[2].getDescriere();
        labeldescriere3.setText(("<html>" + s.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>"));
        p= studii[2].getPret();
        labelpret3.setText(""+p);
        s= studii[3].getDescriere();
        labeldescriere4.setText(("<html>" + s.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>"));
        p= studii[3].getPret();
        labelpret4.setText(""+p);
        s= studii[4].getDescriere();
        labeldescriere5.setText(("<html>" + s.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>"));
        p= studii[4].getPret();
        labelpret5.setText(""+p);

    }
    public JFrame getjFrame()
    {
        return jFrame;
    }
    public JLabel getLabelData() {
        return labelData;
    }
    public JLabel getLabelBani()
    {
        return labelBani;
    }
    public JLabel getLabelHh()
    {
        return labelHh;
    }
    private void activare(int index)
    {
        int procentHh=Integer.parseInt(labelHh.getText());
        if(procentHh>=studii[index+1].getProcentHh())
        {
            index++;
            scriereFisier("ProiectMititeanPadureanSimon/src/Ionut/resources/Studii", index, "Succes", "Eroare");
            int bani= Integer.parseInt(labelBani.getText());
            bani-=studii[index].getPret();
            JLabel banilabelmp=mp.getLabelBani();
            CasaGUI c=  CasaGUI.getInstance();
            JLabel banilabelcasa= c.getLabelBani();
            Meseriigui meserii=Meseriigui.getInstance();
            JLabel banilabelmeserii=meserii.getLabelBani();
            Hh hh= Hh.getInstance();
            JLabel banilabelhh= hh.getLabelBani();
            banilabelmp.setText(bani+"");
            banilabelcasa.setText(bani+"");
            banilabelmeserii.setText(bani+"");
            banilabelhh.setText(bani+"");
            labelBani.setText(bani+"");
            scriereFisier("ProiectMititeanPadureanSimon/src/Ionut/resources/Bani.txt", bani, "succes", "eroare");
    }
        else {
            JOptionPane.showMessageDialog(null,"procentHh prea mic ", "info ",JOptionPane.WARNING_MESSAGE);
        }
    }
    public void enablebutoane(int index)
    {
        if(index== 0)
        {
            buton1.setEnabled(false);
            buton1.setText("Activ");

        }
        if(index == 1)
        {
            buton2.setEnabled(false);
            buton2.setText("Activ");

        }
        if(index == 2)
        {
            buton3.setEnabled(false);
            buton3.setText("Activ");

        }
        if(index == 3)
        {
            buton4.setEnabled(false);
            buton4.setText("Activ");

        }
        if(index == 4)
        {
            buton5.setEnabled(false);
            buton5.setText("Activ");
        }
    }



}
