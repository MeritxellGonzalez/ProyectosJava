package uf3.fitxer;

import java.io.File;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class PrimerLecturaDespresTractar {

    public static void main(String[] args) {
        PrimerLecturaDespresTractar prg = new PrimerLecturaDespresTractar();
        prg.inici();
    }

    public void inici() {
        int[] valors = llegirDades("Enters.txt");
        if (valors != null) {
            Arrays.sort(valors);
            escriureArrauy("EntersOrdenats.txt", valors);
        } else {
            System.out.println("Ha succeït un error");
        }
    }

    /**
     * Donat el nom d'un fitxer, llegeix els seus valors i el carrega en un
     * array d'enters
     *
     * @param nom Nom del fitxer
     * @return Array amb les dades carregades des del fitxer
     */
    public int[] llegirDades(String nom) {
        try {
            File f = new File (nom);
            Scanner lector = new Scanner (f);
            int mida = lector.nextInt();
            int []dades = new int [mida];
            for (int i = 0; i < mida; i++) {
                dades[i] = lector.nextInt(); 
            }
            return dades;
        } catch (Exception e) {
            return null;
        }
    }
    /**
     * Donat un nom de fitxer i un array d'enters, l'escriu en aquest fitxer.
     * @param nom Nom de la ruta del fitxer destinació.
     * @param dades Array amb les dades que cal escriure.
     */
    public void escriureArrauy(String nom, int[] dades) {
        try {
            File f = new File(nom);
            PrintStream escriptor = new PrintStream(f);
            escriptor.print(dades.length);
            for (int i = 0; i < dades.length; i++) {
                escriptor.print(" " + dades[i]);
            }
            System.out.println("Fitxer generat correctament.");
            escriptor.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }

}
