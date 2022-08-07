package metodoburbuja;

import java.util.Scanner;

public class MetodoBurbuja {

    public static void main(String[] args) {
        int arreglo[] = new int[5];
        int aux = 0;
        Scanner in = new Scanner(System.in);

        //introducir valores desde teclado
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("Introduce el valor de la posición " + i + " : ");
            arreglo[i] = in.nextInt();
            System.out.println("");
        }
        //Aplicando método burbuja
        //Este -1 nos limita para que no llegue al final del recorrido del array del apuntador i.
        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = i; j < arreglo.length; j++) {
                if (arreglo[i] > arreglo[j]) {
                    aux = arreglo[i];
                    arreglo[i] = arreglo[j];
                    arreglo[j] = aux;

                }

            }

        }
        //Mostrar arreglo ordenado;
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i]+ " ");
        }
        
    }

}
