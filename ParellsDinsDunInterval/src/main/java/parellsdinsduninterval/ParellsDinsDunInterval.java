package parellsdinsduninterval;

import java.util.Scanner;

public class ParellsDinsDunInterval {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Quin és el valor de n1? ");
        int n1 = lector.nextInt();
        lector.nextLine();

        System.out.print("Quin és el valor de n2 (més gran que n1)? ");
        int n2 = lector.nextInt();
        lector.nextLine();

        if (n1 < n2) {
            int i = n2;
            //Es comença pel primer parell més proper a n2, dins de l'interval.
            if (n2 % 2 != 0) {
                i--;
            }
            while (i >= n1) {
                System.out.println(i);
                //S'avança de dos en dos, per recórrer només els parells.
                i = i - 2;
            }
        } else {
            System.out.println("n2 no és més gran que n1!");
        }
    }
}
