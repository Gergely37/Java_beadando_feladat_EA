package com.example.demo;

// package com.example.demo;
import javax.persistence.*;
@Entity
@Table(name="lelekszamok")


public class Lelekszam {
    public Lelekszam() {
    }

    public Lelekszam(int varosid, int ev, int no, int osszesen) {
        this.varosid = varosid;
        this.ev = ev;
        this.no = no;
        this.osszesen = osszesen;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)	// AUTO_INCREMENT
    private int varosid;

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

    private int ev;
    private int no;
    private int osszesen;
}
