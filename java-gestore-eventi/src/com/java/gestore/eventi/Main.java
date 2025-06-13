package com.java.gestore.eventi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         /* Creare una classe Main di test, in cui si chiede all’utente di inserire un nuovo evento con tutti i parametri.
        Dopo che l’evento è stato istanziato, chiedere all’utente se e quante prenotazioni vuole fare e provare ad effettuarle, implementando opportuni controlli
        Stampare a video il numero di posti prenotati e quelli disponibili
        Chiedere all’utente se e quanti posti vuole disdire
        Provare ad effettuare le disdette, implementando opportuni controlli
        Stampare a video il numero di posti prenotati e quelli disponibili */
        Scanner s = new Scanner(System.in);
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
    }
}
