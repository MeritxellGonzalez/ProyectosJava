package horaridetreball;

import java.util.Scanner;
//Codi aprofitat del anterior exercici per a fer el Horari partit

public class HorariDeTreball {
//Declarem Constants

    public static final int HORA_INICI_MATI = 9;
    public static final int HORA_FIN_MATI = 14;
    public static final int HORA_INICI_TAR = 16;
    public static final int HORA_FIN_TAR = 19;

    public static void main(String[] args) {
        int hora;
        Scanner entrada = new Scanner(System.in);
        hora = entrada.nextInt();
        System.out.println("Quina hora és?");
        //Delimitem al programa sobre quines hores volem que ho apliqui
        if ((hora > 23) || (hora < 0)) {
            System.out.println("L'hora introduïda es incorrecte");
        } else {
            //Si la hora introduida es correcta, recorrera aquesta part perque es troba dins del else de la primera estructura condicional
            if ((hora >= HORA_INICI_MATI) && (hora <= HORA_FIN_MATI) || (hora >= HORA_INICI_TAR) && (hora <= HORA_FIN_TAR)) {
                System.out.println("Treball.");
            } else {
                System.out.println("Temps lliure");
            }
        }
    }
}
