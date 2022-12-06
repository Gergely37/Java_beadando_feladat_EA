package com.example.wpa_alpha.models;

public class Lelekszam {
    private int varosid;
    private int ev;
    private int no;
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

    public int getEv() {
        return ev;
    }

    public int getNo() {
        return no;
    }

    public int getOsszesen() {
        return osszesen;
    }
}
