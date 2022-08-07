package uf2;

import java.util.Scanner;

public class declaracionDiferidaVGlobal {

    //Variables globals. Array inicialitzat com a null.
    private int[] llistaEnters = null;
    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        declaracionDiferidaVGlobal prg = new declaracionDiferidaVGlobal();
        prg.inici();
    }

    private void inici() {
        llegirLlista();
        ordenarLlista();
        mostrarLlista();

    }

    private void llegirLlista() {
        System.out.println("Introdueix una llista de valors enters i pren [ENTER]: ");
        System.err.println("""
                           ALERTA
                            El primer valor indica la mida de la seq\u00fc\u00e8ncia.""");
        /** invoquem aquí els dos mètodes, ja que donen funcionalitat a aquesta funció.   
         *  NO CAL QUE S'INVOQUIN EN EL MÈTODE DE INICI.
         */
        llegirMida();
        llegirValors();
    }

    public void llegirMida() {
        int mida = 0;
        if (validarEnter()) { //Igual que amb les funcions llegiMida() o llegirValors.
            mida = in.nextInt();
        } else {
            in.next();
        }
        //inicialització diferida de l'array;
        llistaEnters = new int[mida];
    }

    public void llegirValors() {
        int index = 0;
        while (index < llistaEnters.length) {
            if (in.hasNextInt()) {
                llistaEnters[index] = in.nextInt();
                index++;
            } else {
                in.next();
            }
        }
        in.nextLine();
    }

    private void ordenarLlista() {
        for (int i = 0; i < llistaEnters.length - 1; i++) {
            for (int j = i; j < llistaEnters.length; j++) {
                int aux = llistaEnters[i];
                llistaEnters[i] = llistaEnters[j];
                llistaEnters[j] = aux;

            }

        }
    }

    private void mostrarLlista() {
        System.out.println("L'array ordenat és: \n [");
        for (int i = 0; i < llistaEnters.length; i++) {
            System.out.print(llistaEnters[i] + " ");
        }
        System.out.println(" ]");
    }

    private boolean validarEnter() {
        return in.hasNextInt();
    }

}
