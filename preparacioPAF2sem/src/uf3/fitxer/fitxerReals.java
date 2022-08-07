package uf3.fitxer;

import java.io.File;
import java.util.Scanner;

public class fitxerReals {

    public static final float DADES = 15;

    public static void main(String[] args) {
        fitxerReals prg = new fitxerReals();
        prg.inici();

    }

    private void inici() {
        try {
            //S'intenta obrir el fitxer
            File f = new File("Reals.txt");
            Scanner lector = new Scanner(f);
            for (int i = 0; i < DADES; i++) {
                float valor = lector.nextFloat();
                System.out.println("El valor llegit és: " + valor);
            }
            //Cal tancar el fitxer.
            lector.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
