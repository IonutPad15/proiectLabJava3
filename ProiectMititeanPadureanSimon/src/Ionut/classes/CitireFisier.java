package Ionut.classes;

import Ionut.interfaces.ICitireFisier;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CitireFisier extends ScriereFisier implements ICitireFisier {
    public double citireFisierDouble(String numeFisier, String mesaj_succes, String mesaj_eroare){
        Scanner sc = null;
        try {
            sc = new Scanner(new File(numeFisier));
            double d = sc.nextDouble();
            System.out.println(mesaj_succes);
            return d;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(mesaj_eroare);
            return -1;
        }
        catch (Exception ex){
            ex.printStackTrace();
            System.out.println(mesaj_eroare);
            return -1;
        }
        finally {
            sc.close();
        }
    }
    public String citireFisierString(String numeFisier, String mesaj_succes, String mesaj_eroare){
        Scanner sc = null;
        try {
            sc = new Scanner(new File(numeFisier));
            String s = sc.next();
            System.out.println(mesaj_succes);
            return s;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(mesaj_eroare);
            return "";
        }
        catch (Exception ex){
            ex.printStackTrace();
            System.out.println(mesaj_eroare);
            return "";
        }
        finally {
            sc.close();
        }
    }
    public int citireFisierInt(String numeFisier, String mesaj_succes, String mesaj_eroare){
        Scanner sc = null;
        try {
            sc = new Scanner(new File(numeFisier));
            int n = sc.nextInt();
            System.out.println(mesaj_succes);
            return n;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(mesaj_eroare);
            return -1;
        }
        catch (Exception ex){
            ex.printStackTrace();
            System.out.println(mesaj_eroare);
            return -1;
        }
        finally {
            sc.close();
        }
    }
}
