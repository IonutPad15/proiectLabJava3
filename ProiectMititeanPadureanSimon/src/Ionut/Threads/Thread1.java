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

////creste datele si le scrie
public class Thread1 extends CitireFisier implements Runnable{
    private MeniuPrincipal mp;
    private Meseriigui meserii;
    private Hh hh;
    private JLabel datalabelpp, datalabelMeserii, datalabelhh , datalabelCasa, datalabelStudii;
    private JLabel banilabelpp, banilabelmeserii, banilabelhh, banilabelCasa, banilabelStudii;
    private Casagu casagui;
    private Studiigu studiigui;
    String s ;
    DateTimeFormatter formatter;
    LocalDate ld ;
    int bani;
    Meserie[] m;
    LifeSimulator ls;
    int indexmeserie;
    public Thread1()
    {
        casagui= Casagu.getInstance();
        studiigui = Studiigu.getInstance();
        ls= LifeSimulator.getInstance();
        m= ls.getMeserii();
        indexmeserie = citireFisierInt("ProiectMititeanPadureanSimon/src/Ionut/resources/Meserii","succes","eroare");
        //indexmeserie = meserii.getIndex();
        mp = MeniuPrincipal.getInstance();
        hh = Hh.getInstance();
        meserii = Meseriigui.getInstance();
        datalabelpp = mp.getLabelData();
        datalabelhh = hh.getLabelData();
        datalabelMeserii = meserii.getLabelData();
        datalabelCasa = casagui.getLabelData();
        datalabelStudii = studiigui.getLabelData();
        banilabelhh = hh.getLabelBani();
        banilabelpp = mp.getLabelBani();
        banilabelmeserii = meserii.getLabelBani();
        banilabelCasa = casagui.getLabelBani();
        banilabelStudii = studiigui.getLabelBani();
        s = datalabelpp.getText();
        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        ld = LocalDate.parse(s, formatter);
        bani = Integer.parseInt(banilabelpp.getText());
    }
    public void run()
    {
        while(true)
        {
            indexmeserie = meserii.getIndex();
            if(isPayTime(ld)) {
                bani += m[indexmeserie].getSalariu();
                banilabelpp.setText("" + bani);
                banilabelmeserii.setText("" + bani);
                banilabelhh.setText("" + bani);
                banilabelCasa.setText("" + bani);
                banilabelStudii.setText("" + bani);
                scriereFisier("ProiectMititeanPadureanSimon/src/Ionut/resources/Bani.txt", bani, "succes", "eroare");
            }
            ld = ld.plusDays(1);
            datalabelpp.setText(formatter.format(ld)+"");
            datalabelhh.setText(formatter.format(ld)+"");
            datalabelMeserii.setText(formatter.format(ld)+"");
            datalabelCasa.setText(formatter.format(ld)+"");
            datalabelStudii.setText(formatter.format(ld)+"");
            scriereFisier("ProiectMititeanPadureanSimon/src/Ionut/resources/Data",formatter.format(ld)+"","succes","eroare");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private boolean isPayTime(LocalDate ld)
    {
        String sir = citireFisierString("ProiectMititeanPadureanSimon/src/Ionut/resources/MeseriiData","succes","eroare");
        LocalDate ldangajare = LocalDate.parse(sir, formatter);
        int monthnow = ld.getMonthValue();
        int yearnow = ld.getYear();
        int daynow = ld.getDayOfMonth();
        int monthangajare = ldangajare.getMonthValue();
        int yearangajare = ldangajare.getYear();
        if(yearnow == yearangajare)
        {
            if(monthnow > monthangajare)
            {
                if(daynow == 14)
                {
                    return true;
                }
            }
        }
        else if( daynow == 14) return true;
        return false;

    }
}
