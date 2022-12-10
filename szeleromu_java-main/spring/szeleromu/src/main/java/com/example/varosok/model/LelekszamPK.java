package com.example.varosok.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class LelekszamPK implements Serializable {
    @Column(name = "varosid")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int varosid;
    @Column(name = "ev")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ev;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LelekszamPK that = (LelekszamPK) o;

        if (varosid != that.varosid) return false;
        if (ev != that.ev) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = varosid;
        result = 31 * result + ev;
        return result;
    }
}
