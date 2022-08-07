package probaraf;

import java.io.File;
import java.io.RandomAccessFile;

public class MoureApuntadorSkipBytes {
    public static void main (String[]args){
        MoureApuntadorSkipBytes programa = new MoureApuntadorSkipBytes();
        programa.inici();
    }

    private void inici() {
        try {
            File f = new File("Enters.bin");
            RandomAccessFile raf = new RandomAccessFile(f, "r");
            long skip = raf.skipBytes(20);
            long pos = raf.getFilePointer();
            System.out.println("L'apuntador a avançar " + skip + " posicions. ");
            System.out.println("Està a la posició " + pos +". ");
            skip = raf.skipBytes(8);
            pos = raf.getFilePointer();
            System.out.println("L'apuntador a avançat "+skip+ " posicions. ");
            System.out.println("Està a la posició " +pos+ ". ");
            //S'intenta avançar molt més enllà de la mida del fitxer.
            skip = raf.skipBytes(400);
            pos = raf.getFilePointer();
            System.out.println("L'apuntador ha avançat " + skip + " posicions.");
            System.out.println("Està a la posició " + pos + ". ");
            raf.close();
        } catch (Exception e) {
            System.out.println("Error: " + e + ". ");
        }
    }
}
