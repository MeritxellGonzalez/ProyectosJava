package probaraf;

import java.io.File;
import java.io.RandomAccessFile;

public class probaRAFErrorLectura {

    public static void main(String[] args) {
        probaRAFErrorLectura programa = new probaRAFErrorLectura();
        programa.inici();

    }

    private void inici() {
        try {
            File f = new File("Enters.bin");
            RandomAccessFile raf = new RandomAccessFile(f, "rw");
            //Càlcul del nombre d'enters
            long numEnters = f.length() / 8;
            System.out.println("Crec que hi ha " + numEnters + " reals.");
            for (int i = 0; i < numEnters; i++) {
                double valor = raf.readDouble();
                System.out.println("S'ha llegit el valor real " + valor);
            }
            raf.close();
        } catch (Exception e) {
            System.out.println("Error en la lectura: " + e);
        }
    }

}
