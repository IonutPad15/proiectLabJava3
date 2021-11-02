package Ionut.classes;

import Ionut.interfaces.IScriereFisier;

import java.io.FileWriter;
import java.io.IOException;

public abstract class ScriereFisierAbstract implements IScriereFisier {
    public void scriereFisier(String numeFisier, String text, String mesaj_succes, String mesaj_eroare){
        try {
            FileWriter myWriter = new FileWriter(numeFisier);
            myWriter.write(text);
            myWriter.close();
            System.out.println(mesaj_succes);
        } catch (IOException e) {
            System.out.println(mesaj_eroare);
            e.printStackTrace();
        }
    }
    public void scriereFisier(String numeFisier,double val, String mesaj_succes, String mesaj_eroare){
        try {
            FileWriter myWriter = new FileWriter(numeFisier);
            myWriter.write(Double.toString(val));
            myWriter.close();
            System.out.println(mesaj_succes);
        } catch (IOException e) {
            System.out.println(mesaj_eroare);
            e.printStackTrace();
        }
    }
    public abstract void scriereFisier(String numeFisier,int val, String mesaj_succes, String mesaj_eroare);
}
