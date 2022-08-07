package eac5.p1.mgonzalez;

import java.util.Scanner;

public class UtilsES {

    public static int demanarEnter(String missatge, String missatgeError) {

        Scanner teclat = new Scanner(System.in);
        int valor;
        boolean correcte;

        do {
            System.out.println(missatge);
            correcte = teclat.hasNextInt();
            if (!correcte) {
                teclat.next();
                System.out.println(missatgeError);
            }
        } while (!correcte);
        valor = teclat.nextInt();
        teclat.nextLine();

        return valor; // Aixo es temporal, haureu de retornar el valor correcte		 
    }

    public static String demanarString(String missatge, String missatgeError) {

        Scanner teclat = new Scanner(System.in);
        System.out.println(missatge);
        String text = teclat.nextLine();

        while (text.isEmpty()) {
            System.out.println(missatgeError);
            System.out.println(missatge);
            text = teclat.nextLine();
        }

        return text; // Aixo es temporal, haureu de retornar el valor correcte		 
    }

    public static int demanarTipusMedalla(String[] valorsMedalles, String missatge, String missatgeError) {

        int valor = 0;
        boolean correcte = false;

        do {
            imprimirIncrementNumeric(valorsMedalles);
            valor = demanarEnter(missatge, missatgeError);
            if (valor >= 1 && valor < valorsMedalles.length + 1) {
                correcte = true;
            }
        } while (!correcte);

        return valor - 1; // Aixo es temporal, haureu de retornar el valor correcte		 
    }

    public static int demanarPais(String[][] paisos, String missatge, String missatgeError) {

        int valor = 0;
        boolean correcte = false;

        do {

            imprimirIncrementNumeric(paisos[1]);
            valor = demanarEnter(missatge, missatgeError);
            if (valor >= 1 && valor < paisos[1].length + 1) {
                correcte = true;
            } else {
                System.out.println(missatgeError);
            }
        } while (!correcte);

        return valor - 1; // Aixo es temporal, haureu de retornar el valor correcte		 
    }

    public static void imprimirIncrementNumeric(String arrayAImprimir[]) {
        for (int i = 0; i < arrayAImprimir.length; ++i) {
            System.out.println(String.format("%1$" + 3 + "s", i + 1 + ".")
                    + arrayAImprimir[i]);
        }
    }
}
