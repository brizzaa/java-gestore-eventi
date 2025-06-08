package com.java.gestore.eventi;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {

    private String titolo;
    private int postiTotali;
    private int postiPrenotati;
    private LocalDate dataLocal;

    
    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public Evento(String titolo, String dataString, int postiTotali) {
        
        try {
            // creo formatter per la data 
            LocalDate dataConvertita = LocalDate.parse(dataString, formatter);
                // 
    
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

            } catch (IllegalArgumentException e){
                System.err.println("errore : " + e);
            }
        
        
        }






    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getPostiTotali() {
        return postiTotali;
    }

    public void setPostiTotali(int postiTotali) {
        this.postiTotali = postiTotali;
    }

    public int getPostiPrenotati() {
        return postiPrenotati;
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
        } catch (DateTimeException e) {
            System.err.println("errore nella modifica della data, riprova!");
        }
    }
    


    
    }   