package com.example.varosok.model;

import javax.persistence.*;

@Entity
@IdClass(LelekszamPK.class)
public class Lelekszam {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "varosid")
    private int varosid;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ev")
    private int ev;
    @Basic
    @Column(name = "no")
    private int no;
    @Basic
    @Column(name = "osszesen")
    private int osszesen;

    public Lelekszam(int varosid, int ev, int no, int osszesen) {
        this.varosid = varosid;
        this.ev = ev;
        this.no = no;
        this.osszesen = osszesen;
    }

    public int getVarosid() {
        return varosid;
    }

    public void setVarosid(int varosid) {
        this.varosid = varosid;
    }

    public int getEv() {
        return ev;
    }

    public void setEv(int ev) {
        this.ev = ev;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getOsszesen() {
        return osszesen;
    }

    public void setOsszesen(int osszesen) {
        this.osszesen = osszesen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lelekszam lelekszam = (Lelekszam) o;

        if (varosid != lelekszam.varosid) return false;
        if (ev != lelekszam.ev) return false;
        if (no != lelekszam.no) return false;
        if (osszesen != lelekszam.osszesen) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = varosid;
        result = 31 * result + ev;
        result = 31 * result + no;
        result = 31 * result + osszesen;
        return result;
    }
}
