package pafmeritxellgon;

import java.io.PrintStream;
import java.io.File;

public class PafMeritxellgon {

    public static void main(String[] args) {
        PafMeritxellgon prg = new PafMeritxellgon();
        prg.inici();
    }

    private void inici() {
        File f = new File("Escriure.txt");
        int[] Array = {1, 2, 3, 4, 5, 6, 7};
        escriure(f, Array);
    }

    public File escriure(File f, int[] array) {
        PrintStream escriptor = null;
        try {

            escriptor = new PrintStream(f);

            for (int i = 0; i < array.length; i++) {
                int valor = array[i];
                escriptor.print(" ");
                valor = valor * 2;
                escriptor.println(valor);
            }

            System.out.println("S'ha imprés correctament");
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        escriptor.close();
        return f;
    }

}
