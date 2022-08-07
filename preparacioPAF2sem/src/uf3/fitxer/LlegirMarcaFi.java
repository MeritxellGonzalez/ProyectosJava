package uf3.fitxer;

import java.io.File;
import java.util.Scanner;

public class LlegirMarcaFi {
    public static final int MARCA_FI = -100;
    public static void main (String[]args){
        LlegirMarcaFi prg = new LlegirMarcaFi();
        prg.inici();
    }

    void inici() {
        try {
            File f = new File("EntersMarca.txt");
            Scanner lector = new Scanner(f);
            boolean llegir = true;
            while (llegir) {
                int valor = lector.nextInt();
                if(valor == MARCA_FI){
                    llegir = false;
                }else{
                    System.out.println("El valor llegit és: " + valor);
                }
            }
            lector.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
