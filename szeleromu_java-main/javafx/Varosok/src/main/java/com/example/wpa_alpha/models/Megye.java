package com.example.wpa_alpha.models;

public class Megye {
    private int id;
    private String nev;

    public int getId() {
        return id;
    }

    public Megye(int id, String nev) {
        this.id = id;
        this.nev = nev;
    }

    public String getNev() {
        return nev;
    }
}
