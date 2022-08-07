package uf2;

import java.util.Scanner;

public class repte1 {

    int arrayEnters[] = new int[10];

    public static void main(String[] args) {
        repte1 prg = new repte1();
        prg.inici();
    }

    private void inici() {
        entradaEnters();
        ordenarArray();
        mostrarArray();
        comptarMeitatMaxim();
        
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
        System.out.println("L'array ordenat és: ");
        for (int i = 0; i < arrayEnters.length; i++) {
            System.out.print("[ " + arrayEnters[i] + " ]");
        }
        //System.out.println("]");
    }

    private boolean validarEnter(Scanner in) {
        return in.hasNextInt();
    }
    public void comptarMeitatMaxim(){
        int valorMaxim = arrayEnters[arrayEnters.length -1]/2;
        int i = 0;
        while((arrayEnters[i] < valorMaxim)&&(i<arrayEnters.length)){
            i++;
        }
        System.out.println(" El nombre de valors inferiors a la meitat del màxim és: " + i + ". ");
    }
}
