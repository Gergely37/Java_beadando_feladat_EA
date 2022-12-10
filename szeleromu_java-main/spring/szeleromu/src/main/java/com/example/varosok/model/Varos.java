package com.example.varosok.model;

import javax.persistence.*;

@Entity
public class Varos {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "nev")
    private String nev;
    @Basic
    @Column(name = "megyeid")
    private int megyeid;
    @Basic
    @Column(name = "megyeszekhely")
    private byte megyeszekhely;
    @Basic
    @Column(name = "megyeijogu")
    private byte megyeijogu;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getMegyeid() {
        return megyeid;
    }

    public void setMegyeid(int megyeid) {
        this.megyeid = megyeid;
    }

    public byte getMegyeszekhely() {
        return megyeszekhely;
    }

    public void setMegyeszekhely(byte megyeszekhely) {
        this.megyeszekhely = megyeszekhely;
    }

    public byte getMegyeijogu() {
        return megyeijogu;
    }

    public void setMegyeijogu(byte megyeijogu) {
        this.megyeijogu = megyeijogu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Varos varos = (Varos) o;

        if (id != varos.id) return false;
        if (megyeid != varos.megyeid) return false;
        if (megyeszekhely != varos.megyeszekhely) return false;
        if (megyeijogu != varos.megyeijogu) return false;
        if (nev != null ? !nev.equals(varos.nev) : varos.nev != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nev != null ? nev.hashCode() : 0);
        result = 31 * result + megyeid;
        result = 31 * result + (int) megyeszekhely;
        result = 31 * result + (int) megyeijogu;
        return result;
    }
}
