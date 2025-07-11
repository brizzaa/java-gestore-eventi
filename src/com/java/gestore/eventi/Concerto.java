package com.java.gestore.eventi;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.text.NumberFormat;
import java.util.Locale;

public class Concerto extends Evento {

    private LocalTime ora;
    private double prezzo;
    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
    

    public Concerto(String titolo, String dataString, int postiTotali, String oraString, double prezzo) {
        super(titolo, dataString, postiTotali);
        this.ora = LocalTime.parse(oraString, timeFormatter);
        this.prezzo = prezzo;
    }
    
    public LocalTime getOra() {
        return ora;
    }

    public void setOra(String oraString) {
        this.ora = LocalTime.parse(oraString, timeFormatter);
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public String getDataOraFormattata() {
        return getDataLocal().format(formatter) + " " + ora.format(timeFormatter);
    }

    public String getPrezzoFormattato() {
        return NumberFormat.getCurrencyInstance(Locale.ITALY).format(prezzo);
    }

    // override del metodo to string per visualizzare le informazioni del concerto in modo leggibile
    @Override
    public String toString() {
        return super.toString() + getDataOraFormattata() + " - " + getTitolo() + " - " + getPrezzoFormattato();
    }

}