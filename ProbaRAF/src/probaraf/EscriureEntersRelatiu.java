package probaraf;

import java.io.File;
import java.io.RandomAccessFile;

public class EscriureEntersRelatiu {

    public static void main(String[] args) {
        EscriureEntersRelatiu prg = new EscriureEntersRelatiu();
        prg.inici();
    }

    private void inici() {
        try {
            File f = new File("Enters.bin");
            //Es mostra el contingut original(si existeix)
            System.out.println("Els valors originals del fitxer: ");
            mostrarFitxerBinari(f);
            //Es fan les modificacions.
            modificaFitxerBinari(f);
            //I ara es mostra el nou contingut
            System.out.println("Nous valors del fitxer.");
            mostrarFitxerBinari(f);

        } catch (Exception e) {
            System.out.println("Error escrivint dades: " + e);
        }
    }

    /**
     * mostra per pantalla tots els valors d'un fitxer orientat a byte que conté
     * enters
     *
     * @param f Ruta del fitxer a mostrar.
     */
    private void mostrarFitxerBinari(File f) {
        try {
            RandomAccessFile raf = new RandomAccessFile(f, "r");
            long pos = raf.getFilePointer();
            while (pos < f.length()) {
                int valor = raf.readInt();
                System.out.println("" + valor);
                pos = raf.getFilePointer();
            }
            raf.close();
            System.out.println();
        } catch (Exception e) {
            System.out.println("Error llegint dades: " + e);
        }
    }

    /**
     * modifica el contingut d'un fitxer orientat a byte que conté enters, de
     * manera que cada 5 posicions se sobreescriu el valor pel número de la
     * propia posició.
     *
     * @param f ruta del fitxer a modificar.
     */
    private void modificaFitxerBinari(File f) {
        try {
            RandomAccessFile raf = new RandomAccessFile(f, "rw");
            //S'avança fins a l'inici del cinquè enter
            //valor 1 = posicio 0, valor 2 = posicio 4, valor 3 = posició 8
            //valor 4 = posicio 12, valor 5 = posicio 16;
            raf.seek(16);
            long pos = raf.getFilePointer();
            int i = 1;
            while (pos < f.length()) {
                //S'escriu un valor a l'apuntador actual
                raf.writeInt(i * 5);
                i++;
                //se salten 4 valors enters. Aquests no es toquen
                raf.skipBytes(4 * 4);
                //En total, l'apuntador ha avançat 5 valors (escrit + saltats)
                pos = raf.getFilePointer();
            }
            //Escriptura finalitzada
            raf.close();
        } catch (Exception e) {
            System.out.println("Error escrivint dades: " + e);
        }
    }
}
