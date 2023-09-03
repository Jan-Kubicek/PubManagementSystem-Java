package org.example;

import java.util.ArrayList;

public class KolekceStolu {
    static ArrayList<Stul> seznamStoluPodniku = new ArrayList<>();
    static void pridejStul(Stul stul){ seznamStoluPodniku.add(stul); }
    static void odeberStul(int index) { seznamStoluPodniku.remove(index); }

}
