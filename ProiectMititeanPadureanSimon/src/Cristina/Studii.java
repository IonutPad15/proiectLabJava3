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
        pret=_pret;
    }
    public void setProcent(int procent)
    {
        procent=_procentHh;
    }
    public void setDescriere(String descriere)
    {
        descriere=_descriere;
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

}
