package Cristina;

public class Studii
{
    private int _pret, _procentHh;
    String _descriere;
    public Studii(int pret, int procentHh, String descriere)
    {
        _pret = pret;
        _procentHh = procentHh;
        _descriere = descriere;
    }
    public Studii( int procentHh, String descriere)
    {
        _pret = 0;
        _procentHh = procentHh;
        _descriere = descriere;
    }
    public Studii(String descriere)
    {
        _pret = 0;
        _procentHh = 0;
        _descriere = descriere;
    }
    public int getPret()
    {
        return _pret;
    }
    public int getProcentHh()
    {
        return _procentHh;
    }
    public String getDescriere()
    {
        return _descriere;
    }
    public void setPret(int pret)
    {
        _pret=pret;
    }
    public void setProcent(int procent)
    {
        _procentHh=procent;
    }
    public void setDescriere(String descriere)
    {
        _descriere=descriere;
    }
    public boolean equals(Object o)
    {
        if(o instanceof Casa)
        {
            Studii c = (Studii) o;
            if(c._descriere.equals(this._descriere)&& c._pret== (this._pret) && c._procentHh==this._procentHh)
            {
                return true;
            }
        }
        return false;
    }
    public String toString()
    {
        return "Studii{" + "Pret='" + _pret + '\'' +  ", Procent=" + _procentHh + ", Descriere=" + _descriere +'}';
    }

}
