import com.java.gestore.eventi.Evento;

public class App {

    public static void main(String[] args) {
        Evento uno = new Evento("evento", "12/02/2026", 21);
        System.out.println(uno.getDataLocal());
        uno.setDataLocal("21/02/002");
        System.out.println(uno.getDataLocal());
    }
}
