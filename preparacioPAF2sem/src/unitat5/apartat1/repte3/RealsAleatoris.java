package unitat5.apartat1.repte3;

import java.util.Random;

public class RealsAleatoris {

    public static void main(String[] args) {
        RealsAleatoris prg = new RealsAleatoris();
        prg.inici();
    }

    private void inici() {
        Random rnd = new Random();
        int valorA = rnd.nextInt() * 100;
        int valorB = rnd.nextInt() * 100;
        System.out.println("S'han generat els valors " + valorA + " i "
                + valorB);
    }
}
