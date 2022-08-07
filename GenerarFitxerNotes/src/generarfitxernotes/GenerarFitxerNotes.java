package generarfitxernotes;

import java.io.File;
import java.util.Scanner;
import java.io.PrintStream;

public class GenerarFitxerNotes {

    public static final String MARCA_FI = "fi";
    public static final double MARCA_FI_NOTES = -1;

    public static void main(String[] args) {
        GenerarFitxerNotes programa = new GenerarFitxerNotes();
        programa.inici();
    }

    private void inici() {
        try {
            File in = new File("NotesMarca.txt");
            Scanner lector = new Scanner(in);
            File out = new File("NotesMitjana.txt");
            //Es genera el fitxer de sortida
            PrintStream escriptor = new PrintStream(out);
            boolean llegir = true;
            //Només cal canviar les escriptures a pantalla per al fitxer de sortida
            //O sigui, on posa "System.out" posar "escriptor"
            while (llegir) {
                String nom = lector.next();
                if (MARCA_FI.equals(nom)) {
                    llegir = false;
                } else {
                    String cognom = lector.next();
                    escriptor.print("Estudiant: " + nom + " " + cognom);
                    //Noteu com un Scanner es pot passar coma paràmetre
                    double mitjana = llegirNotes(lector);
                    escriptor.println("-Mitjana: " + mitjana);
                }

            }
            lector.close();
            escriptor.close();
            System.out.println("Fitxer escrit satisfactòriament.");

        } catch (Exception e) {
            System.out.println("Error llegint estudiants: " + e);
        }
    }

    /**
     * Donat un Scanner en n fitxer quan l'apuntador és sobre l'inici de les
     * notes, s'extreuen i es calcula la mitjana
     *
     * @param lector - Scanner a processar
     * @return Mitjana de notes
     */
    public double llegirNotes(Scanner lector) {
        double res = 0;
        try {
            //Ara es llegeix fins a una marca de fi (-1)
            boolean llegir = true;
            int numNotes = 0;
            while (llegir) {
                double valor = lector.nextDouble();
                if (valor == MARCA_FI_NOTES) {
                    llegir = false;
                } else {
                    res = res + valor;
                    numNotes++;
                }

            }
            res = res / numNotes;
        } catch (Exception e) {
            System.out.println("Error llegint notes: " + e);
        }
        return res;
    }

}
