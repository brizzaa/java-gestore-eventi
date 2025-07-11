package com.java.gestore.eventi;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Evento {
    
    private String titolo;
    private int postiTotali;
    private int postiPrenotati;
    private LocalDate dataLocal;
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public int getPostiDisponibili() {
        return this.postiTotali - this.postiPrenotati;
    }


    public Evento(String titolo, String dataString, int postiTotali) {

        
            // creo formatter per la data
            LocalDate dataConvertita = LocalDate.parse(dataString, formatter);
            // controllo se la data è prima di oggi e lancio eccezione
            setDataLocal(dataString);
            // stessa cosa per i posti
            if (postiTotali <= 0) {
                throw new IllegalArgumentException("il numero dei posti è negativo");
            }
            // se superano i controlli assegno le variabili all istanza
            this.titolo = titolo;
            
            this.postiTotali = postiTotali;
            this.postiPrenotati = 0;

        

    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) throws IllegalArgumentException {
        try {
            this.titolo = titolo;
            if (titolo == null) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.err.println("il titolo non puo essere nullo");
        }
    }

    public int getPostiTotali() {
        return postiTotali;
    }

    public void setPostiTotali(int postiTotali) {
        try {
            if (postiTotali < 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.err.println("gli ospiti non possono essere meno di 0");
        }
        this.postiTotali = postiTotali;
    }

    public int getPostiPrenotati() {
        return this.postiPrenotati;
    }

    public LocalDate getDataLocal() {
        return dataLocal;
    }

    public void setDataLocal(String dataNuova) {
        
            LocalDate nuovaDataLocal = LocalDate.parse(dataNuova, formatter);
            if (dataLocal.isBefore(LocalDate.now())) {
                throw new DateTimeException("");
            }
            this.dataLocal = nuovaDataLocal;
    }

      public void prenota(int nPosti) {
        if (dataLocal.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Errore: data prenotazione passata");
        }
        if (nPosti <= 0) {
            throw new IllegalArgumentException("Numero di posti da prenotare deve essere positivo");
        }
        if (getPostiDisponibili() < nPosti) {
            throw new IllegalArgumentException("Errore: non ci sono abbastanza posti disponibili");
        }
        this.postiPrenotati += nPosti;
    }

    public void disdici(int nPosti) {
        if (dataLocal.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Errore: data prenotazione passata");
        }
        if (nPosti <= 0) {
            throw new IllegalArgumentException("Numero di posti da disdire deve essere positivo");
        }
        if (postiPrenotati < nPosti) {
            throw new IllegalArgumentException("Errore: non ci sono abbastanza prenotazioni da disdire");
        }
        this.postiPrenotati -= nPosti;
    }

    

    // override del tostring con formattazione giusta
    @Override
    public String toString() {
        return "Evento: " + this.titolo + " in data " + dataLocal.format(formatter) +
                " (Posti totali: " + this.postiTotali + ", Prenotati: " + this.postiPrenotati + ", Disponibili: "
                + this.getPostiDisponibili() + ")";
    }
}