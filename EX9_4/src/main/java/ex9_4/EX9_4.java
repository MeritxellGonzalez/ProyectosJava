package ex9_4;

import java.util.Scanner;

public class EX9_4 {

    public static final int VALOR_MAX = 20;
    public static final int VALOR_MIN = 0;
    public static final int VALOR_ESC = -1;

    public static void main(String[] args) {
        //Declarem variables.
        Scanner entrada = new Scanner(System.in);
        int valorUsuari = 0, i = 0;
        boolean dadaCorrecta = true;
        boolean valorEsc = true;
        //Iniciem while
        //Determinem si es un sencer i si esta entre el 0 i el 5.
        while ((dadaCorrecta) && (valorEsc)) {
            System.out.println("Introdueix un valor entre " + VALOR_MIN + " i " + VALOR_MAX + ":");
            valorUsuari = entrada.nextInt();
            entrada.nextLine();

            if ((valorUsuari >= VALOR_MIN) && (valorUsuari <= VALOR_MAX)) {
                dadaCorrecta = false;
            } else {
                i = i + valorUsuari;
            }
            if (valorUsuari == VALOR_ESC) {
                valorEsc = false;
            }
        }
        //Mostrem resultats.
        if (!dadaCorrecta) {
            System.out.println("Dada correcta. El valor introduït és: " + valorUsuari + ".");
        } else {
            System.out.println("La suma dels números introduïts fora de rang és: " + i);
        }
    }
}
