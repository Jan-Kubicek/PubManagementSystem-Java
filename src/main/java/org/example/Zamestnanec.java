package org.example;

public class Zamestnanec {
    //Atributy
    public String jmeno, prijmeni, cisloZamestnance;
    //Konstruktor
    public Zamestnanec(String newJmeno,String newPrijmeni, String newCislo){
        this.jmeno = newJmeno; this.prijmeni = newPrijmeni; this.cisloZamestnance = newCislo;
    }
    //Metody
    public String getJmeno(){return jmeno;}
    public String getPrijmeni(){return prijmeni;}
    public String getCisloZamestnance(){return cisloZamestnance;}
}
