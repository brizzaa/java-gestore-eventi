package com.java.gestore.eventi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;


public class ProgrammaEventi {

    private String titolo;
    private List<Evento> eventi;

    public ProgrammaEventi(String titolo) {
        this.titolo = titolo;
        this.eventi = new ArrayList<>();
    }

    public void aggiungiEvento(Evento evento){
        eventi.add(evento);
    }

    // metodo che ritorna una lista di eventi in data specifica
    public List <Evento> eventiInData(LocalDate data){
        List <Evento> eventiInData = new ArrayList<>();
        for (Evento evento : eventi){
            if (evento.getDataLocal().equals(data)){
                eventiInData.add(evento);
            }
        }
        return eventiInData;
    }
    
    public void svuotaEvento(Evento evento){

    }
}
