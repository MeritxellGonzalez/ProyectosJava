package preparaciopaf2sem;

import java.util.Scanner;

public class PreparacioPAF2sem {

    //VARIABLE GLOBAL
    private int arrayEnters[] = new int[10];

    public static void main(String[] args) {
        PreparacioPAF2sem prg = new PreparacioPAF2sem();
        prg.inici();
    }

    private void inici() {

        entradaEnters();
        ordenarArray();
        mostrarArray();

    }

    public void entradaEnters() {

        Scanner in = new Scanner(System.in);

        for (int i = 0; i < arrayEnters.length; i++) {
            System.out.print("Introdueix el valor que va a la posició " + i + " : ");
            if (validarEnter(in)) {
                arrayEnters[i] = in.nextInt();
                System.out.println("");
            } else {
                System.out.println("Error al introduïr els valors. No és un sencer.");
            }

        }
    }

    private void ordenarArray() {
        for (int i = 0; i < arrayEnters.length - 1; i++) {
            for (int j = i; j < arrayEnters.length; j++) {
                if (arrayEnters[i] > arrayEnters[j]) {
                    int aux = arrayEnters[i];
                    arrayEnters[i] = arrayEnters[j];
                    arrayEnters[j] = aux;

                }

            }

        }

    }

    private void mostrarArray() {
        System.out.println("L'array ordenat és: [");
        for (int i = 0; i < arrayEnters.length; i++) {
            System.out.print(arrayEnters[i] + " ");
        }
        System.out.println("]");
    }

    private boolean validarEnter(Scanner in) {
        return in.hasNextInt();
    }
}
