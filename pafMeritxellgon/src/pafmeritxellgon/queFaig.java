package pafmeritxellgon;

import java.io.File;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class queFaig {

    public static void main(String[] args) {
        queFaig prg = new queFaig();
        prg.inici();
    }

    private void inici() {
        String entrada = "Entrada.txt";
        String sortida = "Sortida.bin";
        int max = 8;
        queHago(entrada, sortida, max);

    }

    private void queHago(String entrada, String sortida, int max) {
        int lin = 1;
        File f = new File(entrada);
        try {
            Scanner scan = new Scanner(f);
            RandomAccessFile raf = new RandomAccessFile(sortida, "rw");

            raf.setLength(0);
            while (scan.hasNext()) {
                int valor = 0;
                int num = scan.nextInt();
                for (int i = 0; i < num; i++) {
                    valor += scan.nextInt();
                }
                if (valor >= max) {
                    valor = max;
                }
                raf.writeInt(lin);
                raf.writeInt(valor);
                lin++;

            }
            raf.close();
            scan.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

}
