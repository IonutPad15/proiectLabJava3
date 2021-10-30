package Cristina;

public class Meserie
{
    private Casa _casa;
    private Studii _studii;
    private int _procentHh;
    private String _descriere;
    private String _nume;
    private int _salariu;
    public Meserie(String nume, Casa casa, Studii studii,int procentHH,String descriere, int salariu)
    {
        _nume = nume;
        _casa = casa;
        _studii = studii;
        _descriere = descriere;
        _procentHh = procentHH;
        _salariu = salariu;
    }
    public Meserie(String nume,Casa casa, Studii studii,String descriere, int salariu)
    {
        _nume = nume;
        _casa = casa;
        _studii = studii;
        _descriere = descriere;
        _procentHh = 0;
        _salariu = salariu;
    }
    public Casa getCasa()
    {
        return _casa;
    }
    public Studii getStudii()
    {
        return _studii;
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
    public void setCasa(Casa casa)
    {
        casa=_casa;
    }
    public void setStudii(Studii studii)
    {
        studii=_studii;
    }
    public void setProcent(int procent)
    {
        procent=_procentHh;
    }
    public void setDescriere(String descriere)
    {
        descriere=_descriere;
    }
    public void setNume(String nume)
    {
        nume=_nume;
    }
    public void setSalariu(int salariu)
    {
        salariu=_salariu;
    }


}
