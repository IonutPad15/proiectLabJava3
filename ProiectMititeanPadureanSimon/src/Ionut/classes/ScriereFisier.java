package Ionut.classes;

import Ionut.interfaces.IScriereFisier;

import java.io.FileWriter;
import java.io.IOException;

public class ScriereFisier extends ScriereFisierAbstract {
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
    public void scriereFisier(String numeFisier,int val, String mesaj_succes, String mesaj_eroare){
        try {
            FileWriter myWriter = new FileWriter(numeFisier);
                myWriter.write(Integer.toString(val));
            myWriter.close();
            System.out.println(mesaj_succes);
        } catch (IOException e) {
            System.out.println(mesaj_eroare);
            e.printStackTrace();
        }
    }
}
