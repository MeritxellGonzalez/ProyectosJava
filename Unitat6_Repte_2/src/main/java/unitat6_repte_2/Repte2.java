package unitat6_repte_2;

import java.io.File;
import java.util.Scanner;

public class Repte2 {

    public static void main(String[] args) {
        Repte2 prg = new Repte2();
        prg.inici();
    }

    public void inici() {
        File rutaCarp = llegirRutaCarpeta();
        netejarCarpeta(rutaCarp);
    }

    public File llegirRutaCarpeta() {
        File f = null;
        boolean preguntar = true;
        Scanner lector = new Scanner(System.in);
        while (preguntar) {
            System.out.println("Escriu el nom d'una ruta en una carpeta: ");
            String nomCarpeta = lector.nextLine();
            f = new File(nomCarpeta);
            if (f.isDirectory()) {
                preguntar = false;
            } else {
                System.out.println("Aquesta carpeta no existeix...");
            }
        }
        return f;
    }

    public void netejarCarpeta(File ruta) {
        File[] elements = ruta.listFiles();
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].isFile()) {
                elements[i].delete();
            } else if (elements[i].isDirectory()) {
                netejarCarpeta(elements[i]);
                elements[i].delete();
            }
        }
    }
}
