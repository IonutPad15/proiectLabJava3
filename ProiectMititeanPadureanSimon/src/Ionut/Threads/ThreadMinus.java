package Ionut.Threads;

import Cristina.gui.Casagu;
import Cristina.gui.Studiigu;
import Ionut.GUI.Hh;
import Ionut.GUI.MeniuPrincipal;
import Ionut.GUI.Meseriigui;
import Ionut.classes.CitireFisier;
import Ionut.classes.LifeSimulator;
import Cristina.*;

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
                banilabelpp.setText("" + bani);
                banilabelMeserii.setText("" + bani);
                banilabelhh.setText("" + bani);
                banilabelCasa.setText("" + bani);
                banilabelStudii.setText("" + bani);
                scriereFisier("ProiectMititeanPadureanSimon/src/Ionut/resources/Bani.txt", bani, "succes", "eroare");
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
        hhtemp -= 6;
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
