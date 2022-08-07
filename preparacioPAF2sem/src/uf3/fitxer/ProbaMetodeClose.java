package uf3.fitxer;

import java.io.File;
import java.util.Scanner;

public class ProbaMetodeClose {

    public static final int NUM_VALORS = 10;

    public static void main(String[] args) {
        ProbaMetodeClose prg = new ProbaMetodeClose();
        prg.inici();
    }

    private void inici() {
        try {
            //S'intenta obrir el fitxer
            File f = new File("Enters.txt");
            Scanner lector = new Scanner(f);
            for (int i = 0; i < NUM_VALORS; i++) {
                int valor = lector.nextInt();
                System.out.println("El valor llegit és: " + valor);
            }
            //Cal tancar el fitxer.
            lector.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
