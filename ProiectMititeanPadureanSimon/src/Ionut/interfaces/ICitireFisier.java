package Ionut.interfaces;

public interface ICitireFisier {
    public double citireFisierDouble(String numeFisier, String mesaj_succes, String mesaj_eroare);
    public String citireFisierString(String numeFisier, String mesaj_succes, String mesaj_eroare);
    public int citireFisierInt(String numeFisier, String mesaj_succes, String mesaj_eroare);
}
