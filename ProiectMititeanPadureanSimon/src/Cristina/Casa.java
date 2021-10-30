package Cristina;

import javax.swing.*;

public class Casa
{
    private int _chirie;
    private ImageIcon _img;
    private String _descriere;
    private String _nume;
    public Casa(String nume, int chirie, ImageIcon img, String descriere)
    {
        _nume = nume;
        _chirie = chirie;
        _img = img;
        _descriere = descriere;
    }
    public Casa(String nume, int chirie, ImageIcon img)
    {
        _nume = nume;
        _chirie = chirie;
        _img = img;
        _descriere = "";
    }
    public void setChirie(int chirie)
    {
        _chirie = chirie;
    }
    public void setImg(ImageIcon img)
    {
        _img = img;
    }
    public void setNume(String nume)
    {
        _nume=nume;
    }
    public void setDescriere(String descriere)
    {
        _descriere=descriere;
    }
    public int getChirie()
    {
        return _chirie;
    }
    public ImageIcon getImg()
    {
        return _img;
    }
    public String getNume()
    {
        return _nume;
    }
    public String getDescriere()
    {
        return _descriere;
    }
    public boolean equals(Object o)
    {
        if(o instanceof Casa)
        {
            Casa c = (Casa) o;
            if(c._descriere.equals(this._descriere)&& c._chirie== this._chirie && c._img.equals(this._img )&& c._nume.equals(this._nume))
            {
                return true;
            }
        }
        return false;
    }
    public String toString()
    {
        return "Casa{" + "Nume='" + _nume + '\'' +  ", Chirie=" +_chirie + ", Descriere=" + _descriere +'}';
    }
}
