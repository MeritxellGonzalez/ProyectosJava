package com.mycompany.unitat6_repte_1;

import java.io.File;
import java.util.Scanner;

public class Repte1 {

    public static void main(String[] args) {
        Repte1 prg = new Repte1();
        prg.inici();
    }

    public void inici() {
        File rutaFitxer = llegirNomFitxer();
        if (rutaFitxer.isFile()) {
            File novaRuta = treureExtensio(rutaFitxer);
            rutaFitxer.renameTo(novaRuta);
            System.out.println("Aquest fitxer no existeix!");
        }else{
            System.out.println("ok");
        }
    }

    public File llegirNomFitxer() {
        Scanner lector = new Scanner(System.in);
        System.out.println("Escriu el nom d'una ruta en un fitxer existent: ");
        String nomFitxer = lector.nextLine();
        File f = new File(nomFitxer);
        return f;
    }
    public File treureExtensio(File original){
        String nom = original.getName();
        String pare = original.getParent();
        int posicioPunt = nom.lastIndexOf(".");
        if(posicioPunt >= 0){
            String nouNom = nom.substring(0, posicioPunt);
            String nouText = pare + File.separator + nouNom;
            File novaRuta = new File(nouText);
            return novaRuta;
        }else{
            return original;
        }
    }
}
