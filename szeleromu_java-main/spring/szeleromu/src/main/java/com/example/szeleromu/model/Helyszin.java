package com.example.szeleromu.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Helyszin {
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

    @OneToOne
    @JoinColumn(name = "megyeid", referencedColumnName = "id", insertable = false, updatable = false)
    private Megye megye;

    public Megye getMegye() {
        return megye;
    }

    public void setMegye(Megye megye) {
        this.megye = megye;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Helyszin helyszin = (Helyszin) o;
        return id == helyszin.id && megyeid == helyszin.megyeid && Objects.equals(nev, helyszin.nev);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nev, megyeid);
    }

    @Override
    public String toString() {
        return "Helyszin{" +
                "id=" + id +
                ", nev='" + nev + '\'' +
                ", megyeid=" + megyeid +
                '}';
    }
}
