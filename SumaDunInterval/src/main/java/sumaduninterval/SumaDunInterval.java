package sumaduninterval;

import java.util.Scanner;

public class SumaDunInterval {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int n1;
        int n2;
        int acumula = 0;

        System.out.println("Quin valor li vols donar a n1?");
        n1 = entrada.nextInt();
        entrada.nextInt();

        System.out.println("Quin valor li vols donar a n2?");
        n2 = entrada.nextInt();
        entrada.nextInt();

        if (n1 < n2) {
            for (int i = n1; n1 < n2; i++) {
                acumula = acumula + i;                      
            }
            System.out.println("La suma total és: " + acumula);
        }else{
            System.out.println("Oh! n2 no és més gran que n1...");
        }
    }

}
