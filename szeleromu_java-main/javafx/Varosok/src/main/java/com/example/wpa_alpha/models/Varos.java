package com.example.wpa_alpha.models;

public class Varos {

    private int id;
    private String nev;
    private int megyeid;

    public Varos(int id, String nev, int megyeid, boolean megyeszekhely, boolean megyeijogu) {
        this.id = id;
        this.nev = nev;
        this.megyeid = megyeid;
        this.megyeszekhely = megyeszekhely;
        this.megyeijogu = megyeijogu;
    }

    private boolean megyeszekhely;
    private boolean megyeijogu;

    public int getId() {
        return id;
    }

    public String getNev() {
        return nev;
    }

    public int getMegyeid() {
        return megyeid;
    }

    public boolean isMegyeszekhely() {
        return megyeszekhely;
    }

    public boolean isMegyeijogu() {
        return megyeijogu;
    }
}
