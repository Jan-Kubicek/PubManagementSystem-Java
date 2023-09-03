package org.example;

import java.util.SimpleTimeZone;

public class Stul {
    //Atributy
    public int pocetMist;
    public String nazev;
    //Konstruktory
    public Stul(String nazev, int pocetMist){
        this.pocetMist= pocetMist; this.nazev = nazev;
    }
    //Metody
    public int getPocetMist(){ return pocetMist; }
    public String getNazev(){ return nazev; }
}
