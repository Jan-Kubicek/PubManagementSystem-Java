package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

import static org.example.KolekceNabidka.*;
import static org.example.KolekceZamestnancu.*;
import static org.example.KolekceStolu.*;

public class MainFrame extends JFrame {
    //Komponenty
    JButton btnPridejDoUctu, btnVytvorUctenku, btnZaplat, btnPrihlas;
    JTextField tfKsJidla, tfKsPiti, tfIdKarty, tfJmeno, tfPrijmeni, tfCisloZamestnance;
    JPanel pnlNorth, pnlCenter, pnlWest, pnlEast, pnlSouth, pnlRow1, pnlRow2,  pnlRows;
    JTable table;
    JLabel lblStul, lblVyberPiti, lblKsPiti, lblVyberJidlo, lblPorciJidla, lblVyberMenu, lblSouth;
    //Konstruktor
    public  MainFrame(){
        InitGui();
        setTitle("Pub Management System - GUI");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(640,480);
    }
    //GUI
    public void InitGui(){
        pnlNorth = new JPanel(new GridLayout(1,4));
            tfJmeno = new JTextField("Jméno"); pnlNorth.add(tfJmeno);
            tfPrijmeni = new JTextField("Přijmení"); pnlNorth.add(tfPrijmeni);
            tfCisloZamestnance = new JTextField("Zaměstnanecké Číslo"); pnlNorth.add(tfCisloZamestnance);
            btnPrihlas = new JButton("Přihlášení"); pnlNorth.add(btnPrihlas);
            btnPrihlas.addActionListener(e -> {
                String jmeno = tfJmeno.getText();
                String prijmeni = tfPrijmeni.getText();
                String cislo = tfCisloZamestnance.getText();
                for(Zamestnanec zamestnanec : seznamZamestnancu){
                    if(zamestnanec.getJmeno().equals(jmeno)){
                        if(zamestnanec.getPrijmeni().equals(prijmeni)){
                            if(zamestnanec.getCisloZamestnance().equals(cislo)){
                                JOptionPane.showMessageDialog(this,"Zaměstnanec byl úspěšně přihlášen","CORRECT",JOptionPane.INFORMATION_MESSAGE);
                            }
                            else{ JOptionPane.showMessageDialog(this,"Nedošlo k přihlášení","ERROR",JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        else{ JOptionPane.showMessageDialog(this,"Nedošlo k přihlášení","ERROR",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else{ JOptionPane.showMessageDialog(this,"Nedošlo k přihlášení","ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                }
            });
        add(pnlNorth,BorderLayout.NORTH);

        pnlWest = new JPanel(new GridLayout(3,1));
            pnlRow1 = new JPanel(new GridLayout(1,2));
                lblStul = new JLabel("Vyber stůl:"); pnlRow1.add(lblStul);
                Choice stoly = new Choice();
                for(Stul stulO : seznamStoluPodniku){
                    stoly.add(stulO.nazev);
                }pnlRow1.add(stoly);
            pnlWest.add(pnlRow1);
            pnlRows = new JPanel(new GridLayout(4,2));
                lblVyberPiti = new JLabel("Vyber pití:"); pnlRows.add(lblVyberPiti);
                Choice piti = new Choice();
                    for (Napoj napoj : kolekceNapoju) {
                        piti.add(napoj.getNazev()); //přidání možností do výběru => Pití
                    }
                pnlRows.add(piti);
                lblKsPiti = new JLabel("Počet nápojů"); pnlRows.add(lblKsPiti);
                tfKsPiti = new JTextField(); pnlRows.add(tfKsPiti);
                lblVyberJidlo = new JLabel("Vyber jídlo:"); pnlRows.add(lblVyberJidlo);
                Choice jidlo = new Choice();
                    for (Jidlo jidloO : kolekceJidel){
                        jidlo.add(jidloO.getNazev()); //přidání možností do výběru => Jídlo
                    }
                pnlRows.add(jidlo);
                lblPorciJidla = new JLabel("Porcí jídla"); pnlRows.add(lblPorciJidla);
                tfKsJidla = new JTextField(); pnlRows.add(tfKsJidla);
            pnlWest.add(pnlRows);
            btnPridejDoUctu = new JButton("Přidej do Systému"); pnlWest.add(btnPridejDoUctu);
        add(pnlWest,BorderLayout.WEST);

        pnlCenter = new JPanel(new GridLayout(1,1));
            DefaultTableModel model = new DefaultTableModel();
                model.addColumn("Objednávka");
                model.addColumn("Stůl");
                model.addColumn("Pití");
                model.addColumn("Počet Nápojů");
                model.addColumn("Jídlo");
                model.addColumn("Počet porcí");
                model.addColumn("Cena");
            table = new JTable(model);
            pnlCenter.add(new JScrollPane(table));
            btnPridejDoUctu.addActionListener(e -> {
                //Validace
                boolean add = false;
                String stul = stoly.getSelectedItem();
                int napoju =  Integer.parseInt(tfKsPiti.getText());
                int porci = Integer.parseInt(tfKsJidla.getText());
                for ( Stul stulO : seznamStoluPodniku){
                    if(stulO.getNazev().equals(stul)){
                        if(napoju >= 0){
                            if(porci >= 0){
                                add = true;
                            }
                        }
                    }
                }
                double cena = 0;
                if(add){
                    String nazevZvolenehoPiti = piti.getSelectedItem();
                    int indexNapoje = -1;
                    int indexPorce = -1;
                    for(Napoj napoj : kolekceNapoju){
                        if(napoj.getNazev().equals(nazevZvolenehoPiti)) {
                            cena += napoj.getCenaKC() * napoju;             //Cena za nápoje
                            indexNapoje = kolekceNapoju.indexOf(napoj);
                        }
                    }
                    String nazevZolenehoJidla = jidlo.getSelectedItem();
                    for(Jidlo jidl01 : kolekceJidel){
                        if(jidl01.getNazev().equals(nazevZolenehoJidla)){
                            cena += jidl01.getCenaKC() * porci;             //Cena za porce
                            indexPorce = kolekceJidel.indexOf(jidl01);
                        }
                    }
                    int indexObjednavky = table.getRowCount(); indexObjednavky++;
                    model.addRow(new Object[]{indexObjednavky,stul,kolekceNapoju.get(indexNapoje).getNazev(),napoju,kolekceJidel.get(indexPorce).getNazev(),porci,cena});
                }
            });
        add(pnlCenter,BorderLayout.CENTER);

        pnlEast = new JPanel(new GridLayout(4,1));
            pnlRow2 = new JPanel(new GridLayout(1,2));
                lblVyberMenu = new JLabel("Vyber měnu");pnlRow2.add(lblVyberMenu);
                Choice mena = new Choice();
                mena.add("YEN"); mena.add("EUR"); mena.add("USD"); mena.add("PLN");
                pnlRow2.add(mena);
            pnlEast.add(pnlRow2);
            btnVytvorUctenku = new JButton("Vytvoř Účtenku"); pnlEast.add(btnVytvorUctenku);
            btnVytvorUctenku.addActionListener(e -> {
                //TODO
            });
            tfIdKarty = new JTextField("Karta"); pnlEast.add(tfIdKarty);
            btnZaplat = new JButton("Zaplat"); pnlEast.add(btnZaplat);
            btnZaplat.addActionListener(e -> {
                //TODO
            });
        add(pnlEast,BorderLayout.EAST);

        pnlSouth = new JPanel(new GridLayout(1,1));
            lblSouth = new JLabel("Jan Kubicek @2023"); pnlSouth.add(lblSouth);
        add(pnlSouth,BorderLayout.SOUTH);
        pack();
    }
    //Main
    public static void main(String[] args){
        nabidka(); // Vytvoření nabídky
        zamestnanci(); //Vytvoření seznamu zaměstnanců
        stoly(); //Vytvoření seznamu stolů
        new MainFrame().setVisible(true);
    }

    public static void nabidka(){
        //Napoje
        Napoj svijany1005 = new Napoj("Svijany 10 0.5l",45); pridejNapoj(svijany1005);
        Napoj svijany1003 = new Napoj("Svijany 10 0.3l",35); pridejNapoj(svijany1003);
        Napoj svijany1105 = new Napoj("Svijany 11 0.5l", 50); pridejNapoj(svijany1105);
        Napoj svijany1103 = new Napoj("Svijany 11 0.3l",40); pridejNapoj(svijany1103);
        Napoj birelPomeloGrep05 = new Napoj("Birell Pomelo-Grep 0.5l", 35); pridejNapoj(birelPomeloGrep05);
        Napoj birelPomeloGrep03 = new Napoj("Birell Pomelo-Grep 0.3l",30); pridejNapoj(birelPomeloGrep03);
        Napoj kofola05 = new Napoj("Kofola 0.5l", 45); pridejNapoj(kofola05);
        Napoj kofola03 = new Napoj("Kofola 0.3l",40); pridejNapoj(kofola03);
        //Jidlo
        Jidlo hranolkyVelke = new Jidlo("Hranolky Velké",65); pridejJidlo(hranolkyVelke);
        Jidlo hranolkyMale = new Jidlo("Hranolky Malé", 50); pridejJidlo(hranolkyMale);
        Jidlo gulasovaPolevka = new Jidlo("Gulášová polévka",67); pridejJidlo(gulasovaPolevka);
        Jidlo segedinskyGulas = new Jidlo("Segedínský Guláš",95); pridejJidlo(segedinskyGulas);
        Jidlo svickova = new Jidlo("Svíčková",105); pridejJidlo(svickova);
        Jidlo houskovyKnedlik = new Jidlo("Houskový knedlík", 40); pridejJidlo(houskovyKnedlik);
        Jidlo rohlik = new Jidlo("Rohlík",5); pridejJidlo(rohlik);
        }
    public static void zamestnanci(){ // iniciály z random generatoru
        Zamestnanec janKoudelka = new Zamestnanec("Jan","Koudelka","janKoudelka01"); pridejZamestnance(janKoudelka);
        Zamestnanec jiriPenc = new Zamestnanec("Jiří","Penc","jiriPenc02"); pridejZamestnance(jiriPenc);
        Zamestnanec martinaZitkova = new Zamestnanec("Martina","Zítková","martinaZitkova03"); pridejZamestnance(martinaZitkova);
        Zamestnanec pavelNovotny = new Zamestnanec("Pavel","Novotný","pavelNovotny04"); pridejZamestnance(pavelNovotny);
        Zamestnanec janaNovakova = new Zamestnanec("Jana","Nováková","janaNovakova05"); pridejZamestnance(janaNovakova);
    }

    public static void stoly(){
        Stul terasa01 = new Stul("Terasa 01",5); pridejStul(terasa01);
        Stul terasa02 = new Stul("Terasa 02",4); pridejStul(terasa02);
        Stul terasa03 = new Stul("Terasa 03",4); pridejStul(terasa03);
        Stul terasa04 = new Stul("Terasa 04",4); pridejStul(terasa04);
        Stul vnitrni01 = new Stul("Vnitřní 01",6); pridejStul(vnitrni01);
        Stul vnitrni02 = new Stul("Vnitřní 02",4); pridejStul(vnitrni02);
        Stul vnitrni03 = new Stul("Vnitřní 03",4); pridejStul(vnitrni03);
        Stul vnitrni04 = new Stul("Vnitřní 04",4); pridejStul(vnitrni04);
        Stul vnitrni05 = new Stul("Vnitřní 05",2); pridejStul(vnitrni05);
    }
}
