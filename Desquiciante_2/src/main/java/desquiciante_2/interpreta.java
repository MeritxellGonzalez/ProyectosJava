package desquiciante_2;

import java.util.Scanner;

public class interpreta {

    public static void main(String[] args) {
        int comptador, puntuacio;
        boolean seguir = true;
        comptador = puntuacio = 0;
        Scanner lector = new Scanner(System.in);
        do {
            System.out.print("Puntuacio: ");
            puntuacio = lector.nextInt();
            System.out.println("Intent " + comptador + ": " + puntuacio + " ");
            if (puntuacio > 100) {
                puntuacio = puntuacio - 100;
            }
            comptador++;
        } while ((comptador < 5) && (puntuacio < 10));
        if (puntuacio >= 10) {
            System.out.println("Puntuacio correcta:" + puntuacio);
        }
    }
}
