package Ionut.interfaces;

public interface IScriereFisier {
    public void scriereFisier(String numeFisier, String text, String mesaj_succes, String mesaj_eroare);
    public void scriereFisier(String numeFisier,double val, String mesaj_succes, String mesaj_eroare);
    public void scriereFisier(String numeFisier,int val, String mesaj_succes, String mesaj_eroare);
}
