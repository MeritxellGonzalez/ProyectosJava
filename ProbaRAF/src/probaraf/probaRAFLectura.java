package probaraf;

import java.io.File;
import java.io.RandomAccessFile;

public class probaRAFLectura {

    public static void main(String[] args) {
        probaRAFLectura programa = new probaRAFLectura();
        programa.inici();
    }

    private void inici() {
        try {
            File f = new File("Enters.bin");
            RandomAccessFile raf = new RandomAccessFile(f, "r");
            //Càlcul del nombre d'enters
            long numEnters = f.length() / 4;
            System.out.println("Hi ha " + numEnters + " enters.");
            for (int i = 0; i < numEnters; i++) {
                int valor = raf.readInt();
                System.out.println("s'ha llegit el valor " + valor);
            }
            raf.close();
        } catch (Exception e) {
            System.out.println("Error en la lectura: " + e);
        }
    }

}
