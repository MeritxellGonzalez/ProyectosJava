package uf3.fitxer;

import java.io.File;
import java.util.Scanner;

public class part2TryCatch {

    public static void main(String[] args) {
        part2TryCatch prg = new part2TryCatch();
        prg.inici();

    }

    private void inici() {
        try {
            // Bloc "try": operacions entrada/sortida
            //S'intenta obrir un fitxer per a lectura
            File f = new File("Document.txt");
            Scanner lector = new Scanner(f);
            // El fitxer existeix. TOT correcte.
            System.out.println("Fitxer obert correctament.");
            System.out.println("Enhorabona");

        } catch (Exception e) {
            //Bloc catch: tractament d'errors.
            // S'ha produit una excepció en algun lloc del bloc "try"
            System.out.println("Error: " + e);
        }
        System.out.println("Fi.");
    }
}
