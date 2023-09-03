package org.example;

import java.util.ArrayList;

public class KolekceNabidka {
    static ArrayList<Napoj> kolekceNapoju = new ArrayList<>();
    static ArrayList<Jidlo> kolekceJidel = new ArrayList<>();

    static void pridejNapoj(Napoj napoj){ kolekceNapoju.add(napoj); }
    static void odeberNapoj(int index){ kolekceNapoju.remove(index); }
    static void pridejJidlo(Jidlo jidlo){ kolekceJidel.add(jidlo); }
    static void odeberJidlo(int index){ kolekceJidel.remove(index); }

}
