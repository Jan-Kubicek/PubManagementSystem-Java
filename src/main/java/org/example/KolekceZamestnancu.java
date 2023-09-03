package org.example;

import java.util.ArrayList;

public class KolekceZamestnancu {
    static ArrayList<Zamestnanec> seznamZamestnancu = new ArrayList<>();

    static void pridejZamestnance(Zamestnanec zamestnanec){ seznamZamestnancu.add(zamestnanec); }
    static void odeberZamestnance(int index){ seznamZamestnancu.remove(index); }
    static Zamestnanec vyhledejZamestnance(String jmeno, String prijmeni, String cislo){
        int index = -1;
        for ( Zamestnanec zamestnanec : seznamZamestnancu){
            if(zamestnanec.getJmeno().equals(jmeno)){
                if(zamestnanec.getPrijmeni().equals(prijmeni)){
                    if(zamestnanec.getCisloZamestnance().equals(cislo)){
                        index = seznamZamestnancu.indexOf(zamestnanec);
                    }
                }
            }
        }
        return seznamZamestnancu.get(index);
    }
}
