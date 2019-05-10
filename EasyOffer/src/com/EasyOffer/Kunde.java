/*
 * @Author Mark Wagner
 * 
 */

package com.EasyOffer;

public class Kunde {
    private String vorname;
    private String nachname;
    private int kundennummer;
    private String andresszusatz;
    private int postleitzahl;
    private String ort;
    private String strasse;
    private int hausnummer;
    private char postfach;

    public Kunde(String vorname, String nachname, int kundennummer, String andresszusatz, int postleitzahl, String ort, String strasse, int hausnummer, char postfach) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.kundennummer = kundennummer;
        this.andresszusatz = andresszusatz;
        this.postleitzahl = postleitzahl;
        this.ort = ort;
        this.strasse = strasse;
        this.hausnummer = hausnummer;
        this.postfach = postfach;
    }

    public String getName() {
        return String.valueOf(this.vorname) + this.nachname;
    }

    public int getKundennummer(String Name) {
        return this.kundennummer;
    }

    public void adresse() {
        System.out.println(this.andresszusatz);
        System.out.println(this.strasse);
        System.out.println(this.hausnummer);
        System.out.println(this.postfach);
        System.out.println(this.postleitzahl);
        System.out.println(this.ort);
    }

    public String getAdresszusatz(int Kundennummer) {
        return this.andresszusatz;
    }

    public int getPostleitzahl() {
        return this.postleitzahl;
    }

    public String getOrt() {
        return this.ort;
    }

    public String getStra\u00dfe() {
        return this.strasse;
    }

    public int getHausnummer() {
        return this.hausnummer;
    }

    public char getPostfach() {
        return this.postfach;
    }
}

