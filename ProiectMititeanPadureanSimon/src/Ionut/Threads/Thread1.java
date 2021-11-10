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
    private JButton buton1, buton2, buton3, buton4, buton5;
    private Casagu casagui;
    private Studiigu studiigui;
    String s ;
    DateTimeFormatter formatter;
    LocalDate ld ;
    int bani;
    Meserie[] m;
    LifeSimulator ls;
    int indexmeserie, index1, index2, index3, index4, index5;
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
        buton1 = hh.getButon1();
        buton2 = hh.getButon2();
        buton3 = hh.getButon3();
        buton4 = hh.getButon4();
        buton5 = hh.getButon5();
        index1 = 0;
        index2 = 0;
        index3 = 0;
        index4 = 0;
        index5 = 0;
    }
    public void run()
    {
        while(true)
        {
            indexmeserie = meserii.getIndex();
            if(isPayTime(ld)) {
                bani = Integer.parseInt(banilabelpp.getText());
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
            if(!buton1.isEnabled())
            {
                index1++;
                if(index1 == 3)
                {
                    buton1.setEnabled(true);
                    index1=0;
                }
            }
            if(!buton2.isEnabled())
            {
                index2++;
                if(index2 == 6)
                {
                    buton2.setEnabled(true);
                    index2=0;
                }
            }
            if(!buton3.isEnabled())
            {
                index3++;
                if(index3 == 9)
                {
                    buton3.setEnabled(true);
                    index3=0;
                }
            }
            if(!buton4.isEnabled())
            {
                index4++;
                if(index4 == 12)
                {
                    buton4.setEnabled(true);
                    index4=0;
                }
            }
            if(!buton5.isEnabled())
            {
                index5++;
                if(index5 == 15)
                {
                    buton5.setEnabled(true);
                    index5=0;
                }
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
