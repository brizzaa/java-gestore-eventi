package com.java.gestore.eventi;
import java.util.Scanner;
import javax.xml.transform.stream.StreamSource;

// Creare una classe Main di test, in cui si chiede all’utente di inserire un nuovo evento con tutti i parametri.
// Dopo che l’evento è stato istanziato, chiedere all’utente se e quante prenotazioni vuole fare e provare ad effettuarle, implementando opportuni controlli
// Stampare a video il numero di posti prenotati e quelli disponibili
// Chiedere all’utente se e quanti posti vuole disdire
// Provare ad effettuare le disdette, implementando opportuni controlli
// Stampare a video il numero di posti prenotati e quelli disponibili

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        try {
            Evento evento = new Evento("titolo", "25/06/2025", 10);

            System.out.println("\n--------");
            System.out.println(evento);
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
            
            System.out.println("prenotati : "   + evento.getPostiPrenotati());
            System.out.println("disponibili : " + evento.getPostiDisponibili());    
            System.out.println("Recap: " + evento.toString());
        } catch (Exception e) {
            System.err.println("errore nella creazione dell'evento: " + e.getMessage());
        } finally{
            s.close();
        }
            
    }
}
