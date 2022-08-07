package taulamultiplicarinversa;

import java.util.Scanner;

public class TaulaMultiplicarInversa {

    public static void main(String[] args) {
        System.out.println("Quina taula de multiplicar vols?");
        Scanner e = new Scanner(System.in);
        //Demanem el número que vol multiplicar i declarem variables posteriorment
        int taula = e.nextInt();
        int i = 10;
        while (i >= 1) {
            int resultat = taula * i;
            System.out.println(taula + " X " + i + " = " + resultat);
            i = i - 1;
        }//Un cop que l'estructura del While arriba al objectiu que a es a la taula de l'1, imprimeix això en pantalla
        System.out.println("Aquí esta la taula del : " + taula);
    }
}
