package omplearrayteclat;

import java.util.Scanner;

public class OmpleArrayTeclat {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int[] aOmpleTeclat = new int[20];
        int ind = 0;
        System.out.println("Quin número vols introduir? Què no sigui major a " +aOmpleTeclat.length +" posicions .");
        System.out.println("Escriu-los en una mateixa línea");
        //Indiquem la que si l'index es menor que 20, faci la condició del if, valorant que sigui un sencer.
        while (ind < aOmpleTeclat.length) {
            if (entrada.hasNextInt()) {
                aOmpleTeclat[ind] = entrada.nextInt();
                ind++;
            } else {
                entrada.next();
                System.out.println("error");
            }
        }
        //Si es un sencer entra a la condició del for i ens imprimeix la següència.
        entrada.nextLine();
        System.out.println("La següencia és:");
        for (int i = 0; i <aOmpleTeclat.length; i++){
            System.out.println(aOmpleTeclat[i]);
        }
    }
}
