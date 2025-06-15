package com;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.java.gestore.eventi.Evento;


public class Concerto extends Evento {

    private LocalTime ora;
    private double prezzo;
    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
    
    public Concerto(){};

    public Concerto(String titolo, String dataString, int postiTotali, String oraString, double prezzo){
        super(titolo, dataString, postiTotali);
        this.ora = LocalTime.parse(oraString, timeFormatter);
        this.prezzo = prezzo;
    }
    
    public void setOra(LocalTime ora){
        this.ora = ora;
    }

    public LocalTime getOra(){
        return this.ora;
    }
   

    

}
