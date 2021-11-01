package Cristina.gui;

import Ionut.GUI.Hh;
import Ionut.GUI.MeniuPrincipal;
import Ionut.GUI.Meseriigui;
import Ionut.classes.CitireFisier;
import Ionut.classes.LifeSimulator;
import Cristina.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CasaGUI extends CitireFisier{
    private JLabel labeltitlu1;
    private JLabel labeltext1;
    private JButton buton1;
    private JLabel labeltitlu2;
    private JLabel labelpret1;
    private JLabel labeltext2;
    private JLabel labelpret2;
    private JButton buton2;
    private JLabel labeltext3;
    private JLabel labelpret3;
    private JButton buton3;
    private JLabel labeltitlu4;
    private JLabel labeltext4;
    private JLabel labelpret4;
    private JButton buton4;
    private JLabel labeltitlu5;
    private JLabel labeltext5;
    private JLabel labelpret5;
    private JButton buton5;
    private JPanel panelHh;
    private JLabel labeltitlu3;
    private JPanel panelStatus;
    private JLabel labelNume;
    private JLabel iconHh;
    private JLabel labelHh;
    private JLabel iconBani;
    private JLabel labelBani;
    private JLabel labelData;
    private JButton butonInapoi;
    private JLabel labelimagine1;
    private JLabel labelimagine2;
    private JLabel labelimagine3;
    private JLabel labelimagine4;
    private JLabel labelimagine5;
    private JFrame jFrame;
    private LifeSimulator ls = LifeSimulator.getInstance();
    private MeniuPrincipal mp = MeniuPrincipal.getInstance();
    private static CasaGUI _instance;
    private Casa[] casa=ls.getCase();
    private int index;
    DateTimeFormatter formatter;
    LocalDate ld ;
    private CasaGUI()
    {
        prepareFrame();
    }
    public static CasaGUI getInstance()
    {
        if(_instance == null) _instance = new CasaGUI();
        return _instance;
    }
    private void prepareFrame()
    {
        index = citireFisierInt("ProiectMititeanPadureanSimon/src/Ionut/resources/Home","succes","eroare");
        jFrame = new JFrame("Home");
        jFrame.setContentPane(panelHh);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setSize(550, 300);
        jFrame.setLocation(650, 250);
        jFrame.setVisible(false);
        jFrame.setResizable(false);
        jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        enablebutoane(index);
        String s  = mp.getLabelData().getText();
        labelData.setText("");
        ImageIcon img = new ImageIcon(new ImageIcon("ProiectMititeanPadureanSimon/src/Ionut/resources/Hh.png").getImage().getScaledInstance(75,55, Image.SCALE_DEFAULT));
        iconHh.setIcon(img);
        img = new ImageIcon(new ImageIcon("ProiectMititeanPadureanSimon/src/Ionut/resources/moneyIcon.png").getImage().getScaledInstance(75,65,Image.SCALE_DEFAULT));
        iconBani.setIcon(img);
        setTextLabels();
        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        int bani = citireFisierInt("ProiectMititeanPadureanSimon/src/Ionut/resources/Bani.txt","succes","eroare");
        labelBani.setText(bani + "");
        int procenthh = citireFisierInt("ProiectMititeanPadureanSimon/src/Ionut/resources/HH.txt","succes","eroare");
        labelHh.setText(""+procenthh);
        butonInapoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jFrame.setVisible(false);
                MeniuPrincipal mp = MeniuPrincipal.getInstance();
                mp.getjFrame().setVisible(true);
            }
        });
        buton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                index = 0;
                scriereFisier("ProiectMititeanPadureanSimon/src/Ionut/resources/Home",index,"succes","eroare");
                plataAvans(index);
                ld = LocalDate.parse(labelData.getText(), formatter);
                scriereFisier("ProiectMititeanPadureanSimon/src/Ionut/resources/HomeData",formatter.format(ld)+"","succes","eroare");
                enablebutoane(index);
            }
        });
        buton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                index = 1;
                scriereFisier("ProiectMititeanPadureanSimon/src/Ionut/resources/Home",index,"succes","eroare");
                plataAvans(index);
                ld = LocalDate.parse(labelData.getText(), formatter);
                scriereFisier("ProiectMititeanPadureanSimon/src/Ionut/resources/HomeData",formatter.format(ld)+"","succes","eroare");
                enablebutoane(index);
            }
        });
        buton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                index = 2;
                scriereFisier("ProiectMititeanPadureanSimon/src/Ionut/resources/Home",index,"succes","eroare");
                plataAvans(index);
                ld = LocalDate.parse(labelData.getText(), formatter);
                scriereFisier("ProiectMititeanPadureanSimon/src/Ionut/resources/HomeData",formatter.format(ld)+"","succes","eroare");
                enablebutoane(index);
            }
        });
        buton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                index = 3;
                scriereFisier("ProiectMititeanPadureanSimon/src/Ionut/resources/Home",index,"succes","eroare");
                plataAvans(index);
                ld = LocalDate.parse(labelData.getText(), formatter);
                scriereFisier("ProiectMititeanPadureanSimon/src/Ionut/resources/HomeData",formatter.format(ld)+"","succes","eroare");
                enablebutoane(index);
            }
        });
        buton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                index = 4;
                scriereFisier("ProiectMititeanPadureanSimon/src/Ionut/resources/Home",index,"succes","eroare");
                plataAvans(index);
                ld = LocalDate.parse(labelData.getText(), formatter);
                scriereFisier("ProiectMititeanPadureanSimon/src/Ionut/resources/HomeData",formatter.format(ld)+"","succes","eroare");
                enablebutoane(index);
            }
        });
    }
    private void setTextLabels()
    {
        String s = casa[0].getDescriere();
        labeltitlu1.setText(casa[0].getNume());
        labeltext1.setText(("<html>" + s.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>"));
        labelpret1.setText(casa[0].getChirie() + " lei");
        labelimagine1.setIcon(casa[0].getImg());
        s = casa[1].getDescriere();
        labeltitlu2.setText(casa[1].getNume());
        labeltext2.setText(("<html>" + s.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>"));
        labelpret2.setText(casa[1].getChirie()+ " lei");
        labelimagine2.setIcon(casa[1].getImg());
        s = casa[2].getDescriere();
        labeltitlu3.setText(casa[2].getNume());
        labeltext3.setText(("<html>" + s.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>"));
        labelpret3.setText(casa[2].getChirie()+ " lei");
        labelimagine3.setIcon(casa[2].getImg());
        s = casa[3].getDescriere();
        labeltitlu4.setText(casa[3].getNume());
        labeltext4.setText(("<html>" + s.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>"));
        labelpret4.setText(casa[3].getChirie()+ " lei");
        labelimagine4.setIcon(casa[3].getImg());
        s = casa[4].getDescriere();
        labeltitlu5.setText(casa[4].getNume());
        labeltext5.setText(("<html>" + s.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>"));
        labelpret5.setText(casa[4].getChirie()+ " lei");
        labelimagine5.setIcon(casa[4].getImg());
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
    public void enablebutoane(int index)
    {
        if(index== 0)
        {
            buton1.setEnabled(false);
            buton1.setText("Activ");
            buton2.setEnabled(true);
            buton3.setEnabled(true);
            buton4.setEnabled(true);
            buton5.setEnabled(true);
            buton2.setText("Activare");
            buton3.setText("Activare");
            buton4.setText("Activare");
            buton5.setText("Activare");
        }
        if(index == 1)
        {
            buton2.setEnabled(false);
            buton2.setText("Activ");
            buton1.setEnabled(true);
            buton3.setEnabled(true);
            buton4.setEnabled(true);
            buton5.setEnabled(true);
            buton1.setText("Activare");
            buton3.setText("Activare");
            buton4.setText("Activare");
            buton5.setText("Activare");
        }
        if(index == 2)
        {
            buton3.setEnabled(false);
            buton3.setText("Activ");
            buton2.setEnabled(true);
            buton1.setEnabled(true);
            buton4.setEnabled(true);
            buton5.setEnabled(true);
            buton1.setText("Activare");
            buton2.setText("Activare");
            buton4.setText("Activare");
            buton5.setText("Activare");
        }
        if(index == 3)
        {
            buton4.setEnabled(false);
            buton4.setText("Activ");
            buton2.setEnabled(true);
            buton3.setEnabled(true);
            buton1.setEnabled(true);
            buton5.setEnabled(true);
            buton1.setText("Activare");
            buton3.setText("Activare");
            buton2.setText("Activare");
            buton5.setText("Activare");
        }
        if(index == 4)
        {
            buton5.setEnabled(false);
            buton5.setText("Activ");
            buton2.setEnabled(true);
            buton3.setEnabled(true);
            buton4.setEnabled(true);
            buton1.setEnabled(true);
            buton1.setText("Activare");
            buton3.setText("Activare");
            buton4.setText("Activare");
            buton2.setText("Activare");
        }
    }
    private void plataAvans(int index)
    {
        Meseriigui meseriigui = Meseriigui.getInstance();
        MeniuPrincipal mp = MeniuPrincipal.getInstance();
        Hh hh = Hh.getInstance();
        JLabel labelbaniMeserii = meseriigui.getLabelBani();
        JLabel labelbaniPp = mp.getLabelBani();
        JLabel labelbaniHh = hh.getLabelBani();
        int bani = Integer.parseInt(labelbaniPp.getText());
        bani -= casa[index].getChirie();
        labelbaniPp.setText("" + bani);
        labelbaniMeserii.setText("" + bani);
        labelbaniHh.setText("" + bani);
        labelBani.setText("" + bani);
        scriereFisier("ProiectMititeanPadureanSimon/src/Ionut/resources/Bani.txt", bani, "succes", "eroare");
    }
    public int getIndex()
    {
        return index;
    }
}
