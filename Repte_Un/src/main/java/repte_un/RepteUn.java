package repte_un;

import java.util.Scanner;

public class RepteUn {

    public static void main(String[] args) {
        Scanner e = new Scanner(System.in);
        System.out.println("Quantes interaccions vols fer?");
        boolean entrada = e.hasNextInt();//La dada introduida es un sencer?
        if (entrada) {//Si es sencer fa aixó
            int interaccions = e.nextInt();
            int i = 0;
            while (i < interaccions) {// Mentre que el contador sigui menor que el número de interaccions introduïdes per teclat imprimeix "-"
                System.out.println(" - ");
                i = i + 1; // Al contador anterior suma 1.
            }
            System.out.println(" ");
        } else {//El número introduït no és un SENCER 
            System.out.println("El valor introduït no és correcte");
        }
        e.nextLine();
    }
}
