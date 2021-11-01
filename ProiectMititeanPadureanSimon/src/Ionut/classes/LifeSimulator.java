package Ionut.classes;

import javax.swing.*;
import java.awt.*;
import Cristina.*;

public class LifeSimulator {
    private static LifeSimulator _instance;
    private static Casa[] _casa;
    private static HealthHappiness[] _hh;
    private static Meserie[] _meserii;
    private static Studii[] _studii;
    private LifeSimulator()
    {
        setCasa();
        setHh();
        setStudii();
        setMeserii();
    }
    public static LifeSimulator getInstance()
    {
        if(_instance == null) _instance = new LifeSimulator();
        return _instance;
    }
    public Casa[] getCase()
    {
        return _casa;
    }
    private static void setCasa()
    {
        _casa = new Casa[5];
        ImageIcon img ;
        img = new ImageIcon(new ImageIcon("ProiectMititeanPadureanSimon/src/Ionut/resources/garsoniera-bloc.jpg").getImage().getScaledInstance(125,105, Image.SCALE_DEFAULT));
        _casa[0] = new Casa("Garsoniera",450,img, "O mica garsoniera la periferie. \nNu e cine stie ce, dar e un loc bun pentru inceput" );
        img = new ImageIcon(new ImageIcon("ProiectMititeanPadureanSimon/src/Ionut/resources/apcu2camere.jpg").getImage().getScaledInstance(125,105, Image.SCALE_DEFAULT));
        _casa[1] = new Casa("Apartament mediu", 850, img, "Un apartament cu 2 camere. Ai mai mult spatiu si mai multe utilitati");
        img = new ImageIcon(new ImageIcon("ProiectMititeanPadureanSimon/src/Ionut/resources/apcu3camere.jpg").getImage().getScaledInstance(125,105, Image.SCALE_DEFAULT));
        _casa[2] = new Casa("Apartament mare", 1250, img, "Apartament cu 3 camere.\n Ai loc sa te desfasori, o camera de oaspeti \nsi un living perfect pentru a da o mica petrece");
        img = new ImageIcon(new ImageIcon("ProiectMititeanPadureanSimon/src/Ionut/resources/casa.jpg").getImage().getScaledInstance(125,105, Image.SCALE_DEFAULT));
        _casa[3] = new Casa("Casa cu gradina", 1650, img, "O casa medie la periferie, cu o gradina de invidiat.\n Nu e cea mai mare gradina, dar e destul\n de incapatoare pentru doi caini sa se joace in voie");
        img = new ImageIcon(new ImageIcon("ProiectMititeanPadureanSimon/src/Ionut/resources/vila.jpg").getImage().getScaledInstance(125,105, Image.SCALE_DEFAULT));
        _casa[4] = new Casa("Vila",2500, img, "Este casa visurilor tale.\n Curte imensa, piscina, lux. Ai reusit !");
    }
    private static void setHh()
    {
        _hh = new HealthHappiness[5];
        _hh[0] = new HealthHappiness(3,"Plimbare","O plimbare lunga si vezi \nsi minunile naturii? Sing me up!");
        _hh[1] = new HealthHappiness(8, "Fotbal");
        _hh[2] = new HealthHappiness(15, "Mers la sala",30);
        _hh[3] = new HealthHappiness(21, "Vizita la medic", "Niste analize, cateva vitamine si esti ca nou!", 50);
        _hh[4] = new HealthHappiness(27, "Spa","Un masaj relaxant urmat de 10 minute la sauna.\n Porii tai iti multumesc!",150 );
    }
    public HealthHappiness[] getHH()
    {
        return _hh;
    }
    private static void setStudii()
    {
        _studii = new Studii[5];
        _studii[0] = new Studii("Invatamant liceal");
        _studii[1] = new Studii(150,20, "Scoala de soferi. In ziua \nde azi, unde nu ai nevoie de ea?");
        _studii[2] = new Studii(1500, 40, "Invata CSS, HTML si JavaScript. \n Perfect pentru front end");
        _studii[3] = new Studii(2500, 60, "Invata Java, Python si PHP.\n Perfect pentru back end");
        _studii[4] = new Studii(3000, 80, "Invata bazele de date si programare \navansata. Combina front end cu back end");
    }
    private static void setMeserii()
    {
        _meserii = new Meserie[5];
        _meserii[0] = new Meserie("Vanzator",0,0,"Esti angajat ca vanzator la Kaufland.\n Nu e chiar ce visai, dar pune painea\n pe masa pentru inceput", 1200);
        _meserii[1] = new Meserie("Tester",0,1 ,20,"Lucrezi ca tester la o firma de it.\nNu e chiar de vis, dar macar lucrezi in domeniu",1800);
        _meserii[2] = new Meserie("FrontEndDev",1,2,45, "E timpul in sfarsit sa programezi.\n Vei putea creea site-uri si aplicatii android", 3000);
        _meserii[3] = new Meserie("BackEndDev",2, 3, 65, "Acum ai ocazia sa intrii in miezul programarii.\n Practic vei fi motivul pentru care functioneaza un calculator",4500);
        _meserii[4] = new Meserie("FullStackDev",3,4,80,"Orice proiect ti se cere, tu nu il vei refuza.\n Esti pregatit pentru orice.",8000);
    }
    public Meserie[] getMeserii()
    {
        return _meserii;
    }
    public Studii[] getStudii()
    {
        return _studii;
    }
}
