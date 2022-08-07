package reptedos;

import java.util.Scanner;

public class RepteDos {
//Control de valors Exercici Repte 3
    public static final int VALORSECRET = 9;

    public static void main(String[] args) {
        //Declarem variables.
        Scanner e = new Scanner(System.in);
        int valorUsuari;
        //Demanem entrada de dades del valor.

        System.out.println("Comencem:\nQuin es el primer número secret: ");
        valorUsuari = e.nextInt();
        //Es detecta si el valor introduit esta dins d'aquests parametres.
        if ((valorUsuari < 0) || (valorUsuari > 10)) {
            System.out.println("Error!El número ha d'estar entre 0 i 10");
        } else {//Si ho esta, pasa a recorrer aquesta estructura if.
            if (VALORSECRET == valorUsuari) {
                System.out.println("Exacte! El número secret era " + VALORSECRET + " .");
            } else {
                System.out.println("T'has equivocat!");
            }
            System.out.println("Hem acabat el joc");
        }

    }
}
