/*
REPTE 5:
Feu un programa que, donat un fitxer orientat a byte que conté qualsevol
nombre de valors reals, els ordeni de menor a major. Aquesta tasca l’ha de dur
directament sobre el fitxer, i no pas carregant les dades a un array, ordenant i
després escrivint-les de nou al fitxer. Per veure que funciona, fer que mostri per
pantalla els valors continguts abans i després de l’ordenació.
 */
package probaraf;

import java.io.File;
import java.io.RandomAccessFile;

public class repte5 {

    public static void main(String[] args) {
        repte5 prg = new repte5();
        prg.inici();
    }

    private void inici() {
        File f = new File("Reals.bin");
        System.out.println("Contingut original del fitxer:");
        mostrarFitxer(f);
        ordenarFitxer(f);
        System.out.println("-------------------------------");
        System.out.println("Contingut ordenat del fitxer: ");
        mostrarFitxer(f);
    }

    /**
     * Donat un fitxer orientat a byte que conté reals, ordena directament sobre
     * el fitxer tots els seus valors, de menor a major.
     *
     * @param f Ruta al fitxer am les dades a ordenar
     */
    private void ordenarFitxer(File f) {
        try {
            RandomAccessFile raf = new RandomAccessFile(f, "rw");
            //Cada real ocupa 8 bytes, per tant, cal avançar de 8 en 8
            for (long i = 0; i < f.length(); i = i + 8) {
                for (long j = i + 8; j < f.length(); j = j + 8) {
                    //Es llegeix el valor a la posició "i"
                    raf.seek(i);
                    double valorI = raf.readDouble();
                    //Es llegeix el valor a la posició "j"
                    raf.seek(j);
                    double valorJ = raf.readDouble();
                    //Es comparen
                    if (valorI > valorJ) {
                        //si es true, es canvien el lloc
                        raf.seek(i);
                        raf.writeDouble(valorJ);
                        raf.seek(j);
                        raf.writeDouble(valorI);

                    }

                }
            }
            raf.close();
        } catch (Exception e) {
            System.out.println("Error ordenant fitxer: " + e);
        }
    }

    /**
     * Donat un fitxer orientat a byte que conté reals, mostra els valors per
     * pantalla
     *
     * @param f Ruta del fitxer a mostrar
     */
    private void mostrarFitxer(File f) {
        try {
            RandomAccessFile raf = new RandomAccessFile(f, "r");
            long numReals = f.length() / 8;
            for (int i = 0; i < numReals; i++) {
                System.out.println(raf.readDouble());
            }
            raf.close();
        } catch (Exception e) {
            System.out.println("Error mostrant fitxer: " + e);
        }

    }

}
