package org.example;

public class Jidlo {
    //Atributy
    String nazev;
    double cenaKC;
    //Konstruktory
    public Jidlo(String newNazev, double newCenaKc){
        this.nazev = newNazev; this.cenaKC = newCenaKc;
    }
    //Metody
    public String getNazev(){return nazev;}
    public double getCenaKC(){return cenaKC;}
}
