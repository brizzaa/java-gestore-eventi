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
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public int getPostiDisponibili(){
        return this.postiTotali - this.postiPrenotati;
    }

    public Evento(){

    };

    public Evento(String titolo, String dataString, int postiTotali) {
        
        try {
            // creo formatter per la data
            LocalDate dataConvertita = LocalDate.parse(dataString, formatter);
            // controllo se la data è prima di oggi e lancio eccezione
            if (dataConvertita.isBefore(LocalDate.now())) {
                throw new IllegalArgumentException("data evento già passata");
            }
            // stessa cosa per i posti
            if (postiTotali <= 0) {
                throw new IllegalArgumentException("il numero dei posti è negativo");
            }
            // se superano i controlli assegno le variabili all istanza
            this.titolo = titolo;
            this.dataLocal = dataConvertita;
            this.postiTotali = postiTotali;
            this.postiPrenotati = 0;

        } catch (IllegalArgumentException e) {
            System.err.println("errore : " + e.getMessage());
        }
        
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
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
            this.postiTotali = postiTotali;
            if (postiTotali < 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.err.println("gli ospiti non possono essere meno di 0");
        }
    }

    public int getPostiPrenotati() {
        return this.postiPrenotati;
    }

    public void setPostiPrenotati(int postiPrenotati) {
        this.postiPrenotati = postiPrenotati;
    }
    
    public LocalDate getDataLocal() {
        return dataLocal;
    }

    public void setDataLocal(String dataNuova) {
        try {
            LocalDate nuovaDataLocal = LocalDate.parse(dataNuova, formatter);
            this.dataLocal = nuovaDataLocal;
            if (dataLocal.isBefore(LocalDate.now())) {
                throw new DateTimeException("");
            }
        } catch (DateTimeException e) {
            System.err.println("errore nella modifica della data, riprova!");
        }
    }

    // funzione per prenotare
    public void prenota() {
        try {
            this.postiPrenotati++;
            if (this.dataLocal.isBefore(LocalDate.now())) {
                throw new IllegalArgumentException("errore: data prenotazione passata");
            } else if (this.getPostiDisponibili() <= 0) {
                throw new IllegalArgumentException("errore : non ci sono posti disponibili");
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage() + ", riprova!");
        }
    }
    // metodo per disdire 
    public void disdici() {
        try {
            this.postiPrenotati--;
            if (this.dataLocal.isBefore(LocalDate.now())) {
                throw new IllegalArgumentException("errore: data prenotazione passata");
            } else if (this.getPostiDisponibili() <= 0) {
                throw new IllegalArgumentException("errore : 0 posti ");
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage() + ", riprova!");
        }
    }


     public static DateTimeFormatter getFormatter() {
        return formatter;
    }
    
    // override del tostring con formattazione giusta
    @Override
    public String toString() {
    return "Evento: " + this.titolo + " in data " + dataLocal.format(formatter) +
        " (Posti totali: " + this.postiTotali + ", Prenotati: " + this.postiPrenotati + ", Disponibili: " + this.getPostiDisponibili() + ")";
    }


    
}