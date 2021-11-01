package Ionut.GUI;

import Ionut.classes.CitireFisier;
import Ionut.classes.LifeSimulator;
import Cristina.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Meseriigui extends CitireFisier {
    private JLabel labelLocMuncaprez;
    private JLabel labelSalariuprez;
    private JLabel labelLocMuncaViitor;
    private JLabel labelSalariuViitor;
    private JPanel panelMeserii;
    private JButton butonActivare;
    private JPanel panelStatus;
    private JLabel labelNume;
    private JLabel iconHh;
    private JLabel labelHh;
    private JLabel iconBani;
    private JLabel labelBani;
    private JLabel labelData;
    private JButton butonInapoi;
    private JFrame jFrame;
    private LifeSimulator ls = LifeSimulator.getInstance();
    private Meserie[] meserii = ls.getMeserii();
    private Casa[] casa = ls.getCase();
    private Studii [] studii = ls.getStudii();
    private MeniuPrincipal mp = MeniuPrincipal.getInstance();
    int index = citireFisierInt("ProiectMititeanPadureanSimon/src/Ionut/resources/Meserii","succes","eroare");
    private static Meseriigui _instance;
    private Meseriigui() {
        prepareFrame();
    }
    public static Meseriigui getInstance()
    {
        if(_instance == null) _instance = new Meseriigui();
        return _instance;
    }
    private void prepareFrame()
    {
        jFrame = new JFrame("Meserii");
        jFrame.setContentPane(panelMeserii);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setSize(450, 300);
        jFrame.setLocation(650, 250);
        jFrame.setVisible(false);
        jFrame.setResizable(false);
        jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        labelData.setText("");
        labelNume.setText(mp.getLabelNume().getText());
        int bani = citireFisierInt("ProiectMititeanPadureanSimon/src/Ionut/resources/Bani.txt","succes","eroare");
        labelBani.setText(bani + "");
        int procenthh = citireFisierInt("ProiectMititeanPadureanSimon/src/Ionut/resources/HH.txt","succes","eroare");
        labelHh.setText(""+procenthh);
        ImageIcon img = new ImageIcon(new ImageIcon("ProiectMititeanPadureanSimon/src/Ionut/resources/Hh.png").getImage().getScaledInstance(75,55, Image.SCALE_DEFAULT));
        iconHh.setIcon(img);
        img = new ImageIcon(new ImageIcon("ProiectMititeanPadureanSimon/src/Ionut/resources/moneyIcon.png").getImage().getScaledInstance(75,65,Image.SCALE_DEFAULT));
        iconBani.setIcon(img);
        setTextLabels();
        butonActivare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                activareButon();
            }
        });
        butonInapoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jFrame.setVisible(false);
                MeniuPrincipal mp = MeniuPrincipal.getInstance();
                mp.getjFrame().setVisible(true);
            }
        });
    }
    private void setTextLabels()
    {
        if(index<meserii.length-1) {
            String s = ("Loc de munca prezent:\n" + meserii[index].getNume() + "\n" + meserii[index].getDescriere());
            labelLocMuncaprez.setText(("<html>" + s.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>"));
            labelSalariuprez.setText("+" + Integer.toString(meserii[index].getSalariu()) + " lei/luna");
            s = ("Loc de munca viitor:\n" + meserii[index + 1].getNume() + "\n" + meserii[index + 1].getDescriere());
            labelLocMuncaViitor.setText(("<html>" + s.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>"));
            labelSalariuViitor.setText("+" + Integer.toString(meserii[index + 1].getSalariu()) + " lei/luna");
        }
        else
        {
            String s = ("Loc de munca prezent:\n" + meserii[index].getNume() + "\n" + meserii[index].getDescriere());
            labelLocMuncaprez.setText(("<html>" + s.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>"));
            labelSalariuprez.setText("+" + Integer.toString(meserii[index].getSalariu()) + " lei/luna");
            labelLocMuncaViitor.setText("");
            labelSalariuViitor.setText("");
            butonActivare.setVisible(false);
        }
    }
    public JFrame getjFrame()
    {
        return  jFrame;
    }
    public JLabel getLabelData() {
        return labelData;
    }
    public JLabel getLabelBani()
    {
        return labelBani;
    }
    public int getIndex()
    {
        return index;
    }
    public JLabel getLabelHh()
    {
        return labelHh;
    }
    private void activareButon()
    {
        int procentHh = Integer.parseInt(mp.getLabelHh().getText());
        int indexstudii = citireFisierInt("ProiectMititeanPadureanSimon/src/Ionut/resources/Studii","succes","eroare");
        int indexcasa = citireFisierInt("ProiectMititeanPadureanSimon/src/Ionut/resources/Home","succes","eroare");
        if(procentHh >= meserii[index+1].getProcentHh() && indexstudii>= meserii[index+1].getindexStudii() && indexcasa >=meserii[index+1].getindexCasa())
        {
            index++;
            scriereFisier("ProiectMititeanPadureanSimon/src/Ionut/resources/Meserii",index,"succes","eroare");
            setTextLabels();
        }
        else
        {
            String s = "Nu te poti angaja momentan aici!\n Procentul de H&H trebuie sa fie cel putin " +
                    meserii[index+1].getProcentHh() + "\n Trebuie sa locuiesti macar in " + casa[meserii[index+1].getindexCasa()].getNume()+
                    "\nSi sa ai macar studiile " + meserii[index+1].getindexStudii();
            JOptionPane.showMessageDialog(null,s,"Atentie",JOptionPane.WARNING_MESSAGE);
        }
    }
}
