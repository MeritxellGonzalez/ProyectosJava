package uf3.fitxer;

import java.io.File;
import java.io.PrintStream;

public class EscriureEntersDobles {

    public static void main(String[] args) {
        EscriureEntersDobles prg = new EscriureEntersDobles();
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
            //File nomFitxer = new File("Escriure.txt");
            escriptor = new PrintStream(f);

            for (int i = 0; i < array.length; i++) {
                int valor = array[i];
                escriptor.print(" ");
                valor = valor * 2;
                escriptor.print(valor);
            }

            System.out.println("S'ha imprés correctament");
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        escriptor.close();
        return f;
    }
}
