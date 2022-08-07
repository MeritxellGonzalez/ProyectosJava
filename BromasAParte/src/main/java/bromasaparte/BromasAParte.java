package bromasaparte;

import java.util.Scanner;

public class BromasAParte {

    public static void main(String[] args) {
        boolean cansado = true;
        boolean hastaLasNarices = true;
        boolean puedesHacerUnaPausa = false;
        Scanner in = new Scanner(System.in);
        boolean entrada = true;
        int respuesta = 1;
        int contador=0;
        do {
            System.out.println("Estas cansado?");
            entrada = in.hasNextInt();
            if (entrada) {
                respuesta = in.nextInt();
                if (respuesta == 1) {
                    cansado = true;
                    System.out.println("Te jodes");
                } else if (respuesta == 2) {
                    cansado = false;
                    hastaLasNarices = true;
                    System.out.println("TE JODES...Sigue programando");
                } else {
                    puedesHacerUnaPausa = false;
                    System.out.println("Vamoh a morir toos...ASI QUE... TE JODEEES");
                }

            }
           contador ++;
        } while (cansado = true && contador<5);
    }
}