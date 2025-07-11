package com.java.gestore.eventi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
    
    public int getNumeroEventi() {
        return eventi.size();
    }
    public void svuotaEventi(){
        eventi.clear();
    }

      public String programmaOrdinato() {
        List<Evento> ordinati = new ArrayList<>(eventi);
        Collections.sort(ordinati, Comparator.comparing(Evento::getDataLocal));
        StringBuilder sb = new StringBuilder();
        sb.append(titolo).append("\n");
        for (Evento evento : ordinati) {
            sb.append(evento.getDataLocal().format(Evento.formatter))
              .append(" - ")
              .append(evento.getTitolo())
              .append("\n");
        }
        return sb.toString().trim();
    }
}
