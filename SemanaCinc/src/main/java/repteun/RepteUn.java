package repteun;

import java.util.Scanner;

public class RepteUn {
//Codi aprofitat del Repte1 per a fer el Repte4
    //Declaració de les constants
    public static final float DESCOMPTE = 8;
    public static final float COMPRA_MIN = 100;
    public static final float DESC_MAX = 10;

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        float preu, descompteFet;
        System.out.println("Quin és el preu del producte en euros? ");
        //Verificació de les dades introduides per teclat.
        boolean dadaCorrecta = entrada.hasNextFloat();
        if (dadaCorrecta) {
            preu = entrada.nextFloat();
            entrada.nextLine();
            //Si l'anterior es compleix calcula descompte
            if (preu > 0) {
                if (preu >= COMPRA_MIN) {
                    descompteFet = preu * DESCOMPTE / 100;
                    if (descompteFet > DESC_MAX) {
                        descompteFet = DESC_MAX;
                    }
                    preu = preu - descompteFet;
                }
                System.out.println("El preu final per pagar és de " + preu + " euros.");
                //Si l'import es negatiu
            } else {
                System.out.println("Preu incorrecte.És negatiu l'import introduit");
            }
            // si el tipus de dada entrada no correspon amb el demanat, pertany al primer if.
        } else {
            System.out.println("El valor introduit no es un enter");
        }

    }
}
