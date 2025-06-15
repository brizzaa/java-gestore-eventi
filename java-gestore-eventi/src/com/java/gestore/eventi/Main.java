package com.java.gestore.eventi;

import java.util.Scanner;

import javax.xml.transform.stream.StreamSource;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        try {
            Evento evento = new Evento();
            System.out.println("inserisci nome evento");
            evento.setTitolo((String) (s.nextLine())); 
            System.out.println("Nome evento: " + evento.getTitolo());
            System.out.println("inserire data : (gg/mm/aaaa)");
            evento.setDataLocal(s.nextLine());
            System.out.println(evento.getDataLocal());
            System.out.println("inserire numero posti totali");
            evento.setPostiTotali(s.nextInt());
            System.out.println(evento.getPostiTotali());
            System.out.println("inserisci posti prenotati");
            evento.setPostiPrenotati(s.nextInt());
            System.out.println("prenotati : "   + evento.getPostiPrenotati());
            System.out.println("disponibili : " + evento.getPostiDisponibili());    
            System.out.println("Recap: " + evento.toString());
            evento.disdici();
            System.out.println("Recap: " + evento.toString());
            evento.disdici();
            System.out.println("Recap: " + evento.toString());
            evento.prenota();
            System.out.println("Recap: " + evento.toString());
            evento.prenota();
            System.out.println("Recap: " + evento.toString());
            evento.prenota();
            System.out.println("Recap: " + evento.toString());
        } catch (Exception e) {
            System.err.println("errore nella creazione dell'evento: " + e.getMessage());
        }    
        s.close();
    }
}
