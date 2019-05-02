package com.EasyOffer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class AngebotGUI extends JFrame {
    private JButton materialHinzufügenButton1;
    private JButton arbeitskostenEntfernenButton;
    private JButton materialEntfernenButton;
    private JButton arbeitskostenHinzufügenButton;
    private JTable tableArbeit;
    private JTable tableMaterial;
    private JPanel rootPanel;
    private JTextField tfMaterialBennenung;
    private JTextField tfMaterialKosten;
    private JTextField tfArbeitsBezeichnung;
    private JTextField tfArbeitsKosten;
    private JTextField tfMaterialBenennung;
    private JLabel labelMaterialName;
    private JLabel labelArbeitskosten;
    private JLabel labelArbeitsbezeichnung;
    private JLabel labelMaterialKosten;
    private JLabel labelAngebot;

    String materialBenennung;
    double materialKosten;

    String arbeitsBezeichnung;
    double arbeitsKosten;


    // Listen für die Werte der Tabelle
    public List<String> listMaterialName = new ArrayList<>();
    public List<Double> listMaterialKosten = new ArrayList<>();

    public List<Double> listArbeitsKosten = new ArrayList<>();
    public List<String> listArbeitsBezeichnung = new ArrayList<>();


    // Konstuktor
    public AngebotGUI(){

        add(rootPanel);

        //Materialtabellen Spalten
        String[] columnMaterial = {"Materialbennenung", "Preis"};

        //Materialtabellen Inhalt
        Object [][] material = {
                {materialBenennung, materialKosten}
        };

        //Arbeitskostentabellen Spalten
        String[] columnArbeit = {"Arbeitsbezeichnung", "Preis"};

        // Arbeitskostentabellen Inhalt
        Object [][] arbeit = {
                {arbeitsBezeichnung, arbeitsKosten}
        };

        tableArbeit = new JTable(arbeit, columnArbeit);
        tableMaterial = new JTable(material, columnMaterial);



        tfMaterialBennenung = new JTextField("Material Bezeichnung");
        tfMaterialKosten = new JTextField("Material Kosten");

        tfArbeitsBezeichnung = new JTextField("Arbeitsbezeichnung", 15);
        tfArbeitsKosten = new JTextField("Arbeitskosten", 15);

        setTitle("EasyOffer");
        setSize(400,500);


        materialHinzufügenButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                materialBenennung = tfMaterialBenennung.getText();
                try {
                    materialKosten = Double.parseDouble(tfMaterialKosten.getText());
                } catch (NumberFormatException ae){}
                listMaterialName.add(materialBenennung);
                listMaterialKosten.add(materialKosten);
            }
        });

        // Entferne letzten Eintrag der Liste
        materialEntfernenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listMaterialName.remove(listMaterialName.size() -1);
                listMaterialKosten.remove(listMaterialKosten.size() -1);
            }
        });


        arbeitskostenHinzufügenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            arbeitsBezeichnung = tfArbeitsBezeichnung.getText();
            try {
                arbeitsKosten = Double.parseDouble(tfArbeitsKosten.getText());
            } catch(NumberFormatException aa){}
            listArbeitsKosten.add(arbeitsKosten);
            listArbeitsBezeichnung.add(arbeitsBezeichnung);
          }
        });
        arbeitskostenEntfernenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listArbeitsBezeichnung.remove(listArbeitsBezeichnung.size() -1);
                listArbeitsKosten.remove(listArbeitsKosten.size() -1);
            }
        });
    }
}
