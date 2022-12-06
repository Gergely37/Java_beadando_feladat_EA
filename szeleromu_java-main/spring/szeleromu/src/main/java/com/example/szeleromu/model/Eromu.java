package com.example.szeleromu.model;

public class Eromu {
    private Helyszin helyszin;
    private Megye megye;
    private Torony torony;

    public Eromu(Helyszin helyszin, Megye megye, Torony torony) {
        this.helyszin = helyszin;
        this.megye = megye;
        this.torony = torony;
    }

    public Helyszin getHelyszin() {
        return helyszin;
    }

    public void setHelyszin(Helyszin helyszin) {
        this.helyszin = helyszin;
    }

    public Megye getMegye() {
        return megye;
    }

    public void setMegye(Megye megye) {
        this.megye = megye;
    }

    public Torony getTorony() {
        return torony;
    }

    public void setTorony(Torony torony) {
        this.torony = torony;
    }
}
