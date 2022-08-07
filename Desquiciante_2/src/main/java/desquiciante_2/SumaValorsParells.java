package desquiciante_2;

import java.util.Scanner;

public class SumaValorsParells {

    public static final int MIN = 0;
    public static final int MAX = 20;

    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);
        int valorUsuari = 0;
        int llegit;
        int numIntents = 0;
        int intentsCorrectes = 0;

        boolean valorNOk = true;

        do {
            System.out.println("Introdueix valor (entre 0 i 20):");
            llegit = lector.nextInt();
            lector.nextLine();

            if ((llegit % 2 == 0) && (llegit >= MIN) && (llegit <= MAX)) {
                valorUsuari += llegit;
                intentsCorrectes++;
                System.out.println("Intents correctes: " + intentsCorrectes);
                valorNOk = true;

            } else if ((llegit % 2 == 1) && (llegit >= MIN) && (llegit <= MAX)) {
                System.out.println("Valor impar");
                valorNOk = false;
                valorUsuari -= llegit;
                numIntents++;
                System.out.println("Intents incorrectes: " + numIntents);

            } else {                
                System.out.println("No esta entre 0 i 20");
                valorNOk = false;
                //lector.next();
            }

        } while (numIntents < 5 && intentsCorrectes < 5);
        System.out.println("dada correcta. has escrit " + valorUsuari);

    }
}
