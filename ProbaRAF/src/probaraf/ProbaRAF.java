package probaraf;

import java.io.File;
import java.io.RandomAccessFile;

public class ProbaRAF {

    public static void main(String[] args) {
        ProbaRAF programa = new ProbaRAF();
        programa.inici();
    }

    private void inici() {
        try {
            File f = new File("Enters.bin");
            RandomAccessFile raf = new RandomAccessFile(f,"rw");
            //Ara no hi ha delimitadors. S'escriuen els valors consecutius.
            //Es van generant els valors i escrivint
            int valor = 1;
            for (int i = 0; i < 20; i++) {
                raf.writeInt(valor);
                valor = valor*2;
            }
            System.out.println("Fitxer creat satisfactoriament. ");
            //La mida d'un enter són 4 bytes.
            //La mida del fitxer haurai de ser 20*4 = 80 bytes
            //No oblida-se de tancar el fitxer
            raf.close();
        } catch (Exception e) {
            System.out.println("Error escrivint dades: " + e);
        }
    }

}
