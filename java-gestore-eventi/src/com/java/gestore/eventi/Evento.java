package com.java.gestore.eventi;

import java.sql.Time;
import java.time.LocalDate;

// Consegna
// Stiamo lavorando a un programma che deve 
// gestire eventi (ad esempio concerti, conferenze, spettacoli etc.).


// Vanno inoltre implementati dei metodi public 
// che svolgano le seguenti funzioni:
// prenota: aggiunge uno ai posti prenotati. 
// Se l’evento è già passato o non ha posti
//  disponibili deve restituire un messaggio di avviso.
// disdici: riduce di uno i posti prenotati.
//  Se l’evento è già passato o non ci sono 
//  prenotazioni restituisce un messaggio di avviso.
// l’override del metodo toString() in modo 
// che venga restituita una stringa contenente:
//  data formattata - titolo
// Aggiungete eventuali metodi (public e private)
//  che vi aiutino a svolgere le funzioni richieste.


public class Evento {
    
    private String titoloEvento;
    private String dataEvento;
    private int postiTotali;
    private int postiPrenotati;
    private String dataLocale;

        // Inserire il controllo che la data non sia 
        // già passata e che il numero di posti totali 
        // sia positivo. In caso contrario mostrare i dovuti avvisi all’utente
        // Aggiungere metodi getter e setter in modo che:
        // titolo sia in lettura e in scrittura
        // data sia in lettura e scrittura
        // numero di posti totale sia solo in lettura
        // numero di posti prenotati sia solo in lettura
    


    public Evento (String titolo, String data, int posti){


        LocalDate dataLocale = LocalDate.now();
        
        this.dataLocale = dataLocale.toString();
        this.dataEvento = data;
        this.titoloEvento = titolo;
        this.postiTotali = posti;
        this.postiPrenotati = 0;        
        
    }

    public Evento (){

    }

    public static void main(String[] args) {
        Evento num1 = new Evento("evento", "09/01/25", 33);
        System.out.println(num1.dataLocale);
    }

    

}
