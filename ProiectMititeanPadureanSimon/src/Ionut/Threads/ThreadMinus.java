package Ionut.Threads;

import Cristina.gui.Casagu;
import Cristina.gui.Studiigu;
import Ionut.GUI.Hh;
import Ionut.GUI.MeniuPrincipal;
import Ionut.GUI.Meseriigui;
import Ionut.classes.CitireFisier;
import Ionut.classes.LifeSimulator;
import Cristina.*;
import Rares.StartGame;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

////scade datele si le scrie
public class ThreadMinus extends CitireFisier implements Runnable{
    private MeniuPrincipal mp;
    private Hh hh;
    private Meseriigui meseriigui;
    private JLabel datalabelpp;
    private JLabel banilabelpp,  banilabelMeserii, banilabelhh, banilabelCasa, banilabelStudii;
    private JLabel hhlabelMeserii, hhlabelMp, hhlabelCasa, hhlabelHh, hhlabelStudii;
    private JButton buton1, buton2, buton3, buton4, buton5;
    private Casagu casagui;
    private Studiigu studiigui;
    private String s ;
    private DateTimeFormatter formatter;
    private LocalDate ld ;
    private int bani;
    private Casa[] casa ;
    private LifeSimulator ls;
    int indexcasa;
    int indexhh;
    public ThreadMinus()
    {
        meseriigui = Meseriigui.getInstance();
        casagui= Casagu.getInstance();
        studiigui = Studiigu.getInstance();
        ls= LifeSimulator.getInstance();
        casa = ls.getCase();
        indexcasa = citireFisierInt("ProiectMititeanPadureanSimon/src/Ionut/resources/Home","succes","eroare");
        //indexcasa = casagui.getIndex();
        mp = MeniuPrincipal.getInstance();
        hh = Hh.getInstance();
        datalabelpp = mp.getLabelData();
        banilabelpp = mp.getLabelBani();
        banilabelCasa = casagui.getLabelBani();
        banilabelStudii = studiigui.getLabelBani();
        banilabelMeserii = meseriigui.getLabelBani();
        banilabelhh = hh.getLabelBani();
        s = datalabelpp.getText();
        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        ld = LocalDate.parse(s, formatter);
        bani = Integer.parseInt(banilabelpp.getText());
        hhlabelCasa = casagui.getLabelHh();
        hhlabelStudii = studiigui.getLabelHh();
        hhlabelHh = hh.getLabelHh();
        hhlabelMp = mp.getLabelHh();
        hhlabelMeserii = meseriigui.getLabelHh();
        indexhh = 0;
        buton1 = casagui.getButon1();
        buton2 = casagui.getButon2();
        buton3 = casagui.getButon3();
        buton4 = casagui.getButon4();
        buton5 = casagui.getButon5();
    }
    public void run()
    {

        while(true)
        {
            indexcasa = casagui.getIndex();
            formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            bani = Integer.parseInt(banilabelpp.getText());
            ld = LocalDate.parse(datalabelpp.getText(), formatter);
            if(indexhh == 14)
            {
                setProcentHh();
                indexhh = 0;
            }
            else
            {
                indexhh++;
            }
            if(isPayTime(ld)) {
                bani -= casa[indexcasa].getChirie();
                if(bani <0)
                {
                    JOptionPane.showMessageDialog(null,"Ai dat faliment! Ai noroc, propietarul garsonierei te primeste inapoi","Atentie!",JOptionPane.WARNING_MESSAGE);
                    bani = 1000;
                    banilabelpp.setText("" + bani);
                    banilabelMeserii.setText("" + bani);
                    banilabelhh.setText("" + bani);
                    banilabelCasa.setText("" + bani);
                    banilabelStudii.setText("" + bani);
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
                    scriereFisier("ProiectMititeanPadureanSimon/src/Ionut/resources/Home", 0, "succes", "eroare");
                    scriereFisier("ProiectMititeanPadureanSimon/src/Ionut/resources/Bani.txt", bani, "succes", "eroare");
                }
                else {
                    banilabelpp.setText("" + bani);
                    banilabelMeserii.setText("" + bani);
                    banilabelhh.setText("" + bani);
                    banilabelCasa.setText("" + bani);
                    banilabelStudii.setText("" + bani);
                    scriereFisier("ProiectMititeanPadureanSimon/src/Ionut/resources/Bani.txt", bani, "succes", "eroare");
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private void setProcentHh()
    {
        int hhtemp = Integer.parseInt(hhlabelMp.getText());
        hhtemp -= 100;
        if(hhtemp < 0)
        {
            Meserie[] meseries = ls.getMeserii();
            String rezfinal = "Viata ta s-a incheiat! Ai strans "+bani+"lei, ai trait pana in "+formatter.format(ld)+
                    ", ai ajuns " + meseries[meseriigui.getIndex()].getNume()+" si ai locuit in " +casa[indexcasa].getNume();
            JFrame jFramepp, jFrameCasa, jFrameHH, jFrameMeserii, jFrameStudii;
            jFrameCasa = casagui.getjFrame();
            jFrameHH = hh.getjFrame();
            jFrameMeserii = meseriigui.getjFrame();
            jFramepp = mp.getjFrame();
            jFrameStudii = studiigui.getjFrame();
            jFrameCasa.setVisible(false);
            jFrameStudii.setVisible(false);
            jFrameMeserii.setVisible(false);
            jFrameHH.setVisible(false);
            jFramepp.setVisible(false);
            JOptionPane.showMessageDialog(null,rezfinal,"Final",JOptionPane.INFORMATION_MESSAGE);
            scriereFisier("ProiectMititeanPadureanSimon/src/Ionut/resources/Data",formatter.format(ld) +"","succes","eorare");
            scriereFisier("ProiectMititeanPadureanSimon/src/Ionut/resources/HomeData",formatter.format(ld) +"","succes","eorare");
            scriereFisier("ProiectMititeanPadureanSimon/src/Ionut/resources/MeseriiData",formatter.format(ld) +"","succes","eorare");
            scriereFisier("ProiectMititeanPadureanSimon/src/Ionut/resources/Bani.txt",1000,"succes","eroare");
            scriereFisier("ProiectMititeanPadureanSimon/src/Ionut/resources/HH.txt",50,"succes","eroare");
            scriereFisier("ProiectMititeanPadureanSimon/src/Ionut/resources/Meserii",0,"succes","eroare");
            scriereFisier("ProiectMititeanPadureanSimon/src/Ionut/resources/Studii",0,"succes","eroare");
            //scriereFisier("ProiectMititeanPadureanSimon/src/Ionut/resources/Nume","","succes","eroare");
            System.exit(0);

            /*int result = JOptionPane.showConfirmDialog(null,"Doriti sa incepeti un joc nou?","FINAL",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION)
            {
                StartGame startGame = new StartGame();
            }
            else
            {
                System.exit(0);
            }*/
        }
        hhlabelMp.setText(hhtemp+"");
        hhlabelHh.setText(hhtemp+"");
        hhlabelCasa.setText(hhtemp+"");
        hhlabelStudii.setText(hhtemp+"");
        hhlabelMeserii.setText(hhtemp+"");
        scriereFisier("ProiectMititeanPadureanSimon/src/Ionut/resources/HH.txt",hhtemp,"succes","eroare");
    }
    private boolean isPayTime(LocalDate ld)
    {
        String sir = citireFisierString("ProiectMititeanPadureanSimon/src/Ionut/resources/HomeData","succes","eroare");
        LocalDate ldchirie = LocalDate.parse(sir, formatter);
        int monthnow = ld.getMonthValue();
        int yearnow = ld.getYear();
        int daynow = ld.getDayOfMonth();
        int daychire = ldchirie.getDayOfMonth();
        int monthchirie = ldchirie.getMonthValue();
        int yearchirie = ldchirie.getYear();
        if(yearnow == yearchirie)
        {
            if(monthnow > monthchirie)
            {
                if(daynow == 20)
                {
                    return true;
                }
            }
        }
        else if( daynow == 20) return true;
        return false;
    }
}
