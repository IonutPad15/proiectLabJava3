package Cristina;

public class HealthHappiness
{
    private int _procentHh,  _pret;
    private String _activitate, _descriere;
    public HealthHappiness(int procentHh, String activitate, String descriere, int pret)
    {
        _procentHh = procentHh;
        _activitate = activitate;
        _descriere = descriere;
        _pret = pret;
    }
    public HealthHappiness(int procentHh, String activitate)
    {
        _procentHh = procentHh;
        _activitate = activitate;
        _descriere = "";
        _pret = 0;
    }
    public HealthHappiness(int procentHh, String activitate, int pret)
    {
        _procentHh = procentHh;
        _activitate = activitate;
        _descriere = "";
        _pret = pret;
    }
    public HealthHappiness(int procentHh, String activitate, String descriere)
    {
        _procentHh = procentHh;
        _activitate = activitate;
        _descriere = descriere;
        _pret = 0;
    }
    public int getProcentHh()
    {
        return _procentHh;
    }
    public String getActivitate()
    {
        return _activitate;
    }
    public String getDescriere()
    {
        return _descriere;
    }
    public int getPret()
    {
        return _pret;
    }
    public void setProcent(int procent)
    {
        procent=_procentHh;
    }
    public void setPret(int pret)
    {
        pret=_pret;
    }
    public void setActivitate(String activitate)
    {
        activitate=_activitate;
    }
    public void setDescriere(String descriere)
    {
        descriere=_descriere;
    }
    public boolean equals(Object o)
    {
        if(o instanceof Casa)
        {
            HealthHappiness c = (HealthHappiness) o;
            if(c._descriere.equals(this._descriere)&& c._pret== this._pret &&  c._activitate.equals(this._activitate) && c._procentHh==this._procentHh)
            {
                return true;
            }
        }
        return false;
    }
    public String toString()
    {
        return "HealthHappiness{" + "Procent='" + _procentHh + '\'' +  ", Activitate=" + _activitate + ", Descriere=" + _descriere + "Pret= " + _pret+'}';
    }
}
