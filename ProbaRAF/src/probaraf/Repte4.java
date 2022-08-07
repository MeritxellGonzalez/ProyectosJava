package probaraf;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Random;

public class Repte4 {

    public static void main(String[] args) {
        Repte4 programa = new Repte4();
        programa.inici();
    }

    private void inici() {
        File f = new File("Reals.bin");
        crearReals(f);
        double[] valors = llegirReals(f);
        if (valors != null) {
            //Tot correcte
            Arrays.sort(valors);
            for (int i = valors.length - 1; i >= 0; i--) {
                System.out.println(valors[i]);
            }
        } else {
            //Hi ha hagut un error en la lectura
            System.out.println("Error llegint dades.");
        }
    }

    /**
     * Donat un fitxer orientat a byte amb reals, els llegeix tots i els posa a
     * un aray.
     *
     * @param f Ruta del fitxer a llegir
     * @return Array de reals
     */
    private double[] llegirReals(File f) {
        try {
            RandomAccessFile raf = new RandomAccessFile(f, "r");
            //Càlcul del nombre de reals
            long numReals = f.length() / 8;
            //per inicialitzar un array cal un "int", no un "long"
            int n = (int) numReals;
            double[] array = new double[n];
            for (int i = 0; i < numReals; i++) {
                array[i] = raf.readDouble();
            }
            raf.close();
            return array;
        } catch (Exception e) {
            return null;
        }
    }

    private void crearReals(File f) {
        try {
            RandomAccessFile raf = new RandomAccessFile(f, "rw");
            Random r = new Random();
            for (int i = 0; i < 20; i++) {

                raf.writeDouble(100 * r.nextDouble());

            }
            raf.close();
        } catch (Exception e) {
            System.out.println("Error generant fitxer: " + e);
        }
    }
}
