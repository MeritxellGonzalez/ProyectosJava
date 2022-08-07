package sumafinslimit;

import java.util.Scanner;

public class SumaFinsLimit {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Quin és el valor límit? ");
        int valor = entrada.nextInt();
        entrada.nextLine();

        int acumulat = 0;
        int comptador = 0;

        while (acumulat <= valor) {
            acumulat = acumulat + comptador;
            if (acumulat <= valor) {
                System.out.println(comptador);
                comptador++;
            }
        }
        System.out.println(" La suma dels valors positius és " + (acumulat - comptador) + ".");
    }
}
