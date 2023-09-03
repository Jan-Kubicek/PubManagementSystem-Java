package org.example;

public class Napoj {
    //Atributy
    String nazev;
    double cenaKC;
    //Konstruktory
    public Napoj(String newNazev, double newCenaKc){
        this.nazev = newNazev; this.cenaKC = newCenaKc;
    }
    //Metody
    public String getNazev(){return nazev;}
    public double getCenaKC(){return cenaKC;}
}
