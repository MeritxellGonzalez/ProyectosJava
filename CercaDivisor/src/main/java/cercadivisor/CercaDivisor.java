package cercadivisor;

import java.util.Scanner;

public class CercaDivisor {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Quin número vols analitzar? ");
        int valor = entrada.nextInt();
        entrada.nextLine();

        boolean trobat = false;
        int divisor = valor - 1;

        while ((!trobat) && (divisor > 1)) {
            if ((valor % divisor) == 0) {
                trobat = true;
            } else {
                divisor--;
            }
        }
        if (divisor == 1) {
            System.out.println("No s'ha trobat cap divisor");
        } else {
            System.out.println("El divisor és: " + divisor + ".");
        }
    }
}
