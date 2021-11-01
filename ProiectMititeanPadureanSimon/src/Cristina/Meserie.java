package Cristina;

public class Meserie
{
    private int _indexCasa ;
    private int _indexStudii;
    private int _procentHh;
    private String _descriere;
    private String _nume;
    private int _salariu;
    public Meserie(String nume, int _indexCasa,int _indexStudii,int procentHH,String descriere, int salariu)
    {
        _nume = nume;
        this._indexCasa=_indexCasa;
        this._indexStudii = _indexStudii;
        _descriere = descriere;
        _procentHh = procentHH;
        _salariu = salariu;
    }
    public Meserie(String nume,int _indexCasa, int _indexStudii,String descriere, int salariu)
    {
        _nume = nume;
        this._indexCasa=_indexCasa;
        this._indexStudii=_indexStudii;
        _descriere = descriere;
        _procentHh = 0;
        _salariu = salariu;
    }
    public int  getindexCasa()
    {
        return _indexCasa;
    }
    public int  getindexStudii()
    {
        return _indexStudii;
    }
    public int getProcentHh()
    {
        return _procentHh;
    }
    public String getDescriere()
    {
        return _descriere;
    }
    public String getNume()
    {
        return _nume;
    }
    public int getSalariu()
    {
        return _salariu;
    }
    public void setCasa(int casa)
    {
        _indexCasa=casa;
    }
    public void setStudii(int studii)
    {
        _indexStudii=studii;
    }
    public void setProcent(int procent)
    {
        _procentHh=procent;
    }
    public void setDescriere(String descriere)
    {
        _descriere=descriere;
    }
    public void setNume(String nume)
    {
        _nume=nume;
    }
    public void setSalariu(int salariu)
    {
        _salariu=salariu;
    }
    public boolean equals(Object o)
    {
        if(o instanceof Casa)
        {
            Meserie c = (Meserie) o;
            if(c._indexCasa==this._indexCasa && c._indexStudii==this._indexStudii && c._procentHh==this._procentHh && c._descriere.equals(this._descriere) && c._nume.equals(this._nume) && c._salariu==this._salariu)
            {
                return true;
            }
        }
        return false;
    }
    public String toString()
    {
        return "Meserie{" + "Nume='" + _nume + '\'' +  ", Procent=" + _procentHh + ", Descriere=" + _descriere + "Salariu= " + _salariu+'}';
    }


}
