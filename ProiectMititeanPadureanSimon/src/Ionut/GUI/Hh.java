package Ionut.GUI;

import Cristina.gui.Casagu;
import Cristina.gui.Studiigu;
import Ionut.classes.CitireFisier;
import Ionut.classes.LifeSimulator;
import Cristina.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hh extends CitireFisier {
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
    private JLabel labelprocent1;
    private JLabel labelprocent2;
    private JLabel labelprocent3;
    private JLabel labelprocent4;
    private JLabel labelprocent5;
    private JFrame jFrame;
    private LifeSimulator ls = LifeSimulator.getInstance();
    private HealthHappiness[] _hh = ls.getHH();
    private MeniuPrincipal mp = MeniuPrincipal.getInstance();
    private static Hh _instance;
    private Hh() {
        prepareFrame();
    }
    public static Hh getInstance()
    {
        if(_instance == null) _instance = new Hh();
        return _instance;
    }
    private void prepareFrame()
    {
        jFrame = new JFrame("Health&Happiness");
        jFrame.setContentPane(panelHh);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setSize(550, 300);
        jFrame.setLocation(650, 250);
        jFrame.setVisible(false);
        jFrame.setResizable(false);
        jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        labelNume.setText(mp.getLabelNume().getText());
        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //LocalDateTime now = LocalDateTime.now();
        //labelData.setText(dtf.format(now)+"");
        String s  = mp.getLabelData().getText();
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //LocalDate ld = LocalDate.parse(s, formatter);
        labelData.setText("");
        ImageIcon img = new ImageIcon(new ImageIcon("ProiectMititeanPadureanSimon/src/Ionut/resources/Hh.png").getImage().getScaledInstance(75,55, Image.SCALE_DEFAULT));
        iconHh.setIcon(img);
        img = new ImageIcon(new ImageIcon("ProiectMititeanPadureanSimon/src/Ionut/resources/moneyIcon.png").getImage().getScaledInstance(75,65,Image.SCALE_DEFAULT));
        iconBani.setIcon(img);
        int bani = citireFisierInt("ProiectMititeanPadureanSimon/src/Ionut/resources/Bani.txt","succes","eroare");
        labelBani.setText(bani + "");
        int procenthh = citireFisierInt("ProiectMititeanPadureanSimon/src/Ionut/resources/HH.txt","succes","eroare");
        labelHh.setText(""+procenthh);
        setTextLabels();
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
                int procent = _hh[0].getProcentHh();
                crestereHh(procent, 0);
            }
        });
        buton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int procent = _hh[1].getProcentHh();
                crestereHh(procent, 1);
            }
        });
        buton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int procent = _hh[2].getProcentHh();
                crestereHh(procent, 2);
            }
        });
        buton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int procent = _hh[3].getProcentHh();
                crestereHh(procent, 3);
            }
        });
        buton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int procent = _hh[4].getProcentHh();
                crestereHh(procent, 4);
            }
        });
    }
    private void setTextLabels()
    {
        String s = _hh[0].getDescriere();
        labeltitlu1.setText(_hh[0].getActivitate());
        labeltext1.setText(("<html>" + s.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>"));
        labelpret1.setText(_hh[0].getPret() + " lei");
        labelprocent1.setText("+"+_hh[0].getProcentHh());
        s = _hh[1].getDescriere();
        labeltitlu2.setText(_hh[1].getActivitate());
        labeltext2.setText(("<html>" + s.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>"));
        labelpret2.setText(_hh[1].getPret()+ " lei");
        labelprocent2.setText("+"+_hh[1].getProcentHh());
        s = _hh[2].getDescriere();
        labeltitlu3.setText(_hh[2].getActivitate());
        labeltext3.setText(("<html>" + s.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>"));
        labelpret3.setText(_hh[2].getPret()+ " lei");
        labelprocent3.setText("+"+_hh[2].getProcentHh());
        s = _hh[3].getDescriere();
        labeltitlu4.setText(_hh[3].getActivitate());
        labeltext4.setText(("<html>" + s.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>"));
        labelpret4.setText(_hh[3].getPret()+ " lei");
        labelprocent4.setText("+"+_hh[3].getProcentHh());
        s = _hh[4].getDescriere();
        labeltitlu5.setText(_hh[4].getActivitate());
        labeltext5.setText(("<html>" + s.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>"));
        labelpret5.setText(_hh[4].getPret()+ " lei");
        labelprocent5.setText("+"+_hh[4].getProcentHh());
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
    private void crestereHh(int procent, int index)
    {
        Meseriigui meseriigui = Meseriigui.getInstance();
        MeniuPrincipal mp = MeniuPrincipal.getInstance();
        Casagu casagui = Casagu.getInstance();
        Studiigu studiigui = Studiigu.getInstance();
        JLabel labelhhMeserii = meseriigui.getLabelHh();
        JLabel labelhhMp = mp.getLabelHh();
        JLabel labelhhCasa = casagui.getLabelHh();
        JLabel labelhhStudii = studiigui.getLabelHh();
        int hhtemp = Integer.parseInt(labelHh.getText());
        hhtemp += procent;
        if(hhtemp > 100) hhtemp = 100;
        labelHh.setText(hhtemp+"");
        labelhhMeserii.setText(hhtemp+"");
        labelhhMp.setText(hhtemp+"");
        labelhhCasa.setText(hhtemp+"");
        labelhhStudii.setText(hhtemp+"");
        JLabel labelbaniMeserii = meseriigui.getLabelBani();
        JLabel labelbaniPp = mp.getLabelBani();
        JLabel labelbaniCasa = casagui.getLabelBani();
        JLabel labelbaniStudii = studiigui.getLabelBani();
        scriereFisier("ProiectMititeanPadureanSimon/src/Ionut/resources/HH.txt",hhtemp,"succes","eroare");
        int bani = Integer.parseInt(labelbaniPp.getText());
        bani -= _hh[index].getPret();
        labelbaniPp.setText("" + bani);
        labelbaniMeserii.setText("" + bani);
        labelbaniCasa.setText("" + bani);
        labelbaniStudii.setText("" + bani);
        labelBani.setText("" + bani);
        scriereFisier("ProiectMititeanPadureanSimon/src/Ionut/resources/Bani.txt", bani, "succes", "eroare");
    }
}
