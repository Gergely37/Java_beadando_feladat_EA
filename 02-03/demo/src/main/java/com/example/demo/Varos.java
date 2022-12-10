package com.example.demo;
import javax.persistence.*;
@Entity
@Table(name="varosok")

public class Varos {
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

    public boolean isMegyeszekhely() {
        return megyeszekhely;
    }

    public void setMegyeszekhely(boolean megyeszekhely) {
        this.megyeszekhely = megyeszekhely;
    }

    public boolean isMegyeijogu() {
        return megyeijogu;
    }

    public void setMegyeijogu(boolean megyeijogu) {
        this.megyeijogu = megyeijogu;
    }

    public Varos(int id, String nev, int megyeid, boolean megyeszekhely, boolean megyeijogu) {
        this.id = id;
        this.nev = nev;
        this.megyeid = megyeid;
        this.megyeszekhely = megyeszekhely;
        this.megyeijogu = megyeijogu;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)	// AUTO_INCREMENT
    private int id;
    private String nev;
    private int megyeid;
    private boolean megyeszekhely;

    public Varos() {
    }

    private boolean megyeijogu;

}
