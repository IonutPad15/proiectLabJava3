package Ionut.GUI;

import Cristina.gui.Casagu;
import Cristina.gui.Studiigu;
import Ionut.Threads.*;
import Ionut.classes.CitireFisier;
import Ionut.classes.LifeSimulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MeniuPrincipal extends CitireFisier {
    private JPanel panelMeniuP;
    private JPanel panelStatus;
    private JLabel labelNume;
    private JLabel iconHh;
    private JLabel labelHh;
    private JLabel iconBani;
    private JLabel labelBani;
    private JLabel labelData;
    private JPanel panelImg;
    private JPanel panelButoane;
    private JButton butonMeserii;
    private JButton butonCasa;
    private JButton butonHh;
    private JButton butonStudii;
    private JLabel Imagine;
    private JFrame jFrame;
    private LifeSimulator ls = LifeSimulator.getInstance();
    private static MeniuPrincipal _instance;
    private MeniuPrincipal(){
        /*if(SwingUtilities.isEventDispatchThread())
        {
            prepareFrame();
        }
        else
        {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    prepareFrame();
                }
            });
        }*/
        prepareFrame();
    }
    public static MeniuPrincipal getInstance()
    {
        if(_instance == null) _instance = new MeniuPrincipal();
        return _instance;
    }
    private void prepareFrame()
    {
        jFrame = new JFrame("LifeSimulator");
        jFrame.setContentPane(panelMeniuP);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setSize(550, 300);
        jFrame.setLocation(650, 250);
        jFrame.setVisible(false);
        jFrame.setResizable(false);
        jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //LocalDateTime now = LocalDateTime.now();
        //labelData.setText(dtf.format(now)+"");
        String s = citireFisierString("ProiectMititeanPadureanSimon/src/Ionut/resources/Data", "succes", "eroare");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate  ld = LocalDate.parse(s, formatter);
        labelData.setText(formatter.format(ld)+"");
        int bani = citireFisierInt("ProiectMititeanPadureanSimon/src/Ionut/resources/Bani.txt","succes","eroare");
        labelBani.setText(bani + "");
        s = citireFisierString("ProiectMititeanPadureanSimon/src/Ionut/resources/Nume","succes","eroare");
        labelNume.setText(s);
        int procenthh = citireFisierInt("ProiectMititeanPadureanSimon/src/Ionut/resources/HH.txt","succes","eroare");
        labelHh.setText(""+procenthh);
        ImageIcon img = new ImageIcon(new ImageIcon("ProiectMititeanPadureanSimon/src/Ionut/resources/Hh.png").getImage().getScaledInstance(75,55,Image.SCALE_DEFAULT));
        iconHh.setIcon(img);
        img = new ImageIcon(new ImageIcon("ProiectMititeanPadureanSimon/src/Ionut/resources/moneyIcon.png").getImage().getScaledInstance(75,65,Image.SCALE_DEFAULT));
        iconBani.setIcon(img);
        img = new ImageIcon(new ImageIcon("ProiectMititeanPadureanSimon/src/Ionut/resources/workIcon.png").getImage().getScaledInstance(35,35,Image.SCALE_DEFAULT));
        butonMeserii.setIcon(img);
        img = new ImageIcon(new ImageIcon("ProiectMititeanPadureanSimon/src/Ionut/resources/homeIcon.png").getImage().getScaledInstance(35,35,Image.SCALE_DEFAULT));
        butonCasa.setIcon(img);
        img = new ImageIcon(new ImageIcon("ProiectMititeanPadureanSimon/src/Ionut/resources/EducationIcon.png").getImage().getScaledInstance(45,35,Image.SCALE_DEFAULT));
        butonStudii.setIcon(img);
        img = new ImageIcon(new ImageIcon("ProiectMititeanPadureanSimon/src/Ionut/resources/hhIcon.png").getImage().getScaledInstance(45,35,Image.SCALE_DEFAULT));
        butonHh.setIcon(img);
        butonMeserii.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jFrame.setVisible(false);
                Meseriigui m = Meseriigui.getInstance();
                //SwingUtilities.invokeLater(m);
                m.getjFrame().setVisible(true);
            }
        });
        butonHh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jFrame.setVisible(false);
                Hh h = Hh.getInstance();
                //SwingUtilities.invokeLater(m);
                h.getjFrame().setVisible(true);
            }
        });
        butonCasa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jFrame.setVisible(false);
                Casagu c = Casagu.getInstance();
                //SwingUtilities.invokeLater(m);
                c.getjFrame().setVisible(true);
            }
        });
        butonStudii.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jFrame.setVisible(false);
                Studiigu s = Studiigu.getInstance();
                //SwingUtilities.invokeLater(m);
                s.getjFrame().setVisible(true);
            }
        });
    }
    public JFrame getjFrame()
    {
        return jFrame;
    }

    public JLabel getLabelData() {
        return labelData;
    }

    /*public static void main(String[] args) {
        MeniuPrincipal mp = MeniuPrincipal.getInstance();
        mp.getjFrame().setVisible(true);
        Thread1 r1 = new Thread1();
        Thread t1 = new Thread(r1);
        ThreadMinus r2 = new ThreadMinus();
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }*/
    public void start() {
        MeniuPrincipal mp = MeniuPrincipal.getInstance();
        mp.getjFrame().setVisible(true);
        Thread1 r1 = new Thread1();
        Thread t1 = new Thread(r1);
        ThreadMinus r2 = new ThreadMinus();
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }
    public JLabel getLabelBani()
    {
        return labelBani;
    }
    public JLabel getLabelNume(){ return labelNume;}
    public JLabel getLabelHh()
    {
        return labelHh;
    }
}
