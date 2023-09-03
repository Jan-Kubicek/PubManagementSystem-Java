package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MainFrame extends JFrame {
    //Komponenty
    JButton btnPridejDoUctu, btnVytvorUctenku, btnZaplat, btnPrihlas;
    JTextField tfStulId, tfKsJidla, tfKsPiti, tfIdKarty, tfJmeno, tfPrijmeni, tfCisloZamestnance;
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
                //TODO
            });
        add(pnlNorth,BorderLayout.NORTH);

        pnlWest = new JPanel(new GridLayout(3,1));
            pnlRow1 = new JPanel(new GridLayout(1,2));
                lblStul = new JLabel("Zadej ID stolu: "); pnlRow1.add(lblStul);
                tfStulId = new JTextField(); pnlRow1.add(tfStulId);
            pnlWest.add(pnlRow1);
            pnlRows = new JPanel(new GridLayout(4,2));
                lblVyberPiti = new JLabel("Vyber pití:"); pnlRows.add(lblVyberPiti);
                Choice piti = new Choice();
                //TODO doplnit piti
                pnlRows.add(piti);
                lblKsPiti = new JLabel("Počet nápojů"); pnlRows.add(lblKsPiti);
                tfKsPiti = new JTextField(); pnlRows.add(tfKsPiti);
                lblVyberJidlo = new JLabel("Vyber jídlo:"); pnlRows.add(lblVyberJidlo);
                Choice jidlo = new Choice();
                //TODO dopln jidlo
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
                //TODO
            });
        add(pnlCenter,BorderLayout.CENTER);

        pnlEast = new JPanel(new GridLayout(4,1));
            pnlRow2 = new JPanel(new GridLayout(1,2));
                lblVyberMenu = new JLabel("Vyber měnu");pnlRow2.add(lblVyberMenu);
                Choice mena = new Choice();
                //TODO
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
        new MainFrame().setVisible(true);
    }
}
