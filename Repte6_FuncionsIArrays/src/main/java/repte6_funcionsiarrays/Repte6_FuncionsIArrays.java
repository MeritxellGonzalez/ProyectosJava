/*
Feu un programa que pregunti un número enter pel teclat. Llavors, donat un conjunt de valors dins un array,
ha de calcular quants cops apareix el número introduït. Useu mètodes tant per preguntar el número com per cercar 
el seu nombre d’aparicions. Declareu l’array on cal fer la cerca com una variable dins del mètode inici,
inicialitzada amb valors concrets de la vostra elecció.
 */
package repte6_funcionsiarrays;

import java.util.Scanner;

/**
 *
 * @author Meritxell González
 */
public class Repte6_FuncionsIArrays {

    public static void main(String[] args) {
        Repte6_FuncionsIArrays programa = new Repte6_FuncionsIArrays();
        programa.inci();
    }

    public void inci() {
        int[] valors = {10, 5, 5, 6, 9,};
        //Crida a funció per demanar valor per teclat
        int num = demanaNum();
        //Crida a funció per cercar número de vegades que apareix el nº entrat per teclat
        int res = cercaNumAparicions(valors, num);
        //presentació del resultat
        System.out.println("El nº de vegades que apareix el n1 " + num + " dins de l'array ");
        printIntArray(valors);
        System.out.println(" és: " + res + " vegada/es.");
    }

    public int demanaNum() {
        /*
        -Funció per demanar nº a cercar en array per teclat
        -Retornarà valor entrat per teclar o 0 si no és sencer.
        -Declarem variables
         */
        boolean dadaCorrecta = false;
        int n = 0;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introdueix nº a cercar a l'array (del 1 al 10): ");
        //Comprovem que el valor introduït sigui un sencer.
        dadaCorrecta = entrada.hasNextInt();
        if (dadaCorrecta) {
            n = entrada.nextInt();
        }
        if (!dadaCorrecta) {
            System.out.println("error el nº entrat no és un enter");
        }
        return n;
    }

    public int cercaNumAparicions(int[] arrayV, int num) {
        // Funció per cercar num de vegades que apareix el nº entrat pel teclat
        int acumulador = 0;
        for (int i = 0; i < arrayV.length; i++) {
            if (arrayV[i] == num) {
                acumulador++;
            }
           
        }
         return acumulador;
    }

    void printIntArray(int[] valors2) {
        //Funció per veure els valors de l'array en format {x1, x2, ... xn}

        int limitFor = valors2.length - 1;
        System.out.print("{");
        for (int i = 0; i < limitFor; i++) {
            System.out.print(valors2[i]);
            System.out.print(", ");
        }
        if (limitFor >= 0) {
            System.out.print(valors2[limitFor]);
        }
        System.out.print("}");
    }

}
