package probaraf;

import java.io.File;
import java.io.RandomAccessFile;

public class LlegirEntersRelatiu {

    public static void main(String[] args) {
        LlegirEntersRelatiu prg = new LlegirEntersRelatiu();
        prg.inici();
    }

    private void inici() {
        try {
            File f = new File("Enters.bin");
            RandomAccessFile raf = new RandomAccessFile(f, "r");
            long numEnters = f.length() / 4;
            long meitat = numEnters / 2;
            //Apuntador a l'inici de l'enter a la meitat del fitxer
            raf.seek(meitat * 4);
            long pos = raf.getFilePointer();
            //Es llegeix fins a arribar al final del fitxer.
            do {
                System.out.println("(apuntador a la posició " + pos + " ) ->");
                //Es llegeix un enter
                int valor = raf.readInt();
                System.out.println("S'ha llegit el valor " + valor);
                //Se salta l'enter següent (4 bytes)
                raf.skipBytes(4);
                pos = raf.getFilePointer();
            } while (pos < f.length());
        } catch (Exception e) {
            System.out.println("Error llegint dades: " + e);
        }
    }

}
