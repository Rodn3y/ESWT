package com.EasyOffer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Angebot  {


    String ueberschrift;


    public List<String> materialName = new ArrayList<>();
    public List<Double> materialKosten = new ArrayList<>();

    public List<Double> arbeitsKosten = new ArrayList<>();
    public List<String> arbeitsBezeichnung = new ArrayList<>();

    public int position;

    public void addMaterial(String name, double kosten) {
        materialName.add(name);
        materialKosten.add(kosten);

    }

    public void addArbeit(String bezeichnung, double kosten) {
        arbeitsKosten.add(kosten);
        arbeitsBezeichnung.add(bezeichnung);
    }

}
