package uf3.fitxer;

import java.io.File;
import java.util.Scanner;
//PROGRAMA PER A NETEJAR CARPETES
public class repte2Part1 {
    public static void main (String[]args){
        repte2Part1 prg = new repte2Part1();
        prg.inici();
    }

    private void inici() {
        File rutaCarpeta = llegirRutaCarpeta();
        netejarCarpeta(rutaCarpeta);
    }

    private File llegirRutaCarpeta() {
        //Un tipus de dada compost, es pot deixar sense inicialitzar posant 
        //"null"
        File f = null;
        boolean preguntar = true;
        Scanner lector = new Scanner (System.in);
        while(preguntar){
            System.out.println("Escriu el nom d'una ruta en una carpeta: ");
            String nomCarpeta = lector.nextLine();
            f = new File (nomCarpeta);
            if(f.isDirectory()){
                preguntar = false;
            }else{
                System.out.println("Aquesta carpeta no existeix...");
            }
        }
        return f;
    }
    /** Donada una ruta associada a una carpeta, esborra tot el seu contingut.
     * 
     * @param ruta ruta de la carpeta que cal netejar.
     */

    private void netejarCarpeta(File ruta) {
        File [] elements = ruta.listFiles();
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].isFile()) {
                // Si es un fitxer, s'esborra
                elements[i].delete();
            } else if (elements[i].isDirectory()){
                // si es una carpeta, cal buidar-la primer, 
                //o sigui invocar netejarCarpeta!
                netejarCarpeta(elements [i]);
                //Un cop buida es pot esborrar correctament
                elements[i].delete();
            }
            
        }
        
    }
}
