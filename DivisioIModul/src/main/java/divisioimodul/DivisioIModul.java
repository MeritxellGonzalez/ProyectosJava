package divisioimodul;

import java.util.Scanner;

public class DivisioIModul {

    public static void main(String[] args) {
        //Demanem dividend i divisor per pantalla
        Scanner e = new Scanner(System.in);
        System.out.println("Quin serà el dividend?");
        int dividend = e.nextInt();
        e.nextLine();
        System.out.println("Quin serà el divisor?");
        int divisor = e.nextInt();
        e.nextLine();
        //Fem les operacions i, guardem resultat i, continuem.
        int residual = 0;
        while (dividend >= divisor) {
            dividend = dividend - divisor;
            residual++;
            //Anem imprimient en pantalla el resultat
            System.out.println(" Per ara el dividend val: " + dividend + ".\t");
        }
        System.out.println("La divisió és: " + residual + ".");
        System.out.println("El módul és: " + dividend + ".");
    }
}
