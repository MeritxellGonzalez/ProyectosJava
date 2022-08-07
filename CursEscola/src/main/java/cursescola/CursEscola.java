package cursescola;

import java.util.Scanner;

public class CursEscola {
//Constants que marquen les edats.

    public static final int EDAT3 = 3;
    public static final int EDAT6 = 6;
    public static final int EDAT7 = 7;
    public static final int EDAT8 = 8;
    public static final int EDAT9 = 9;
    public static final int EDAT10 = 10;
    public static final int EDAT11 = 11;
    public static final int EDAT12 = 12;

    public static void main(String[] args) {
        //Definim variables i inicialitzem.

        int edatMenor = 10, cicle = 0, curs = 0;

        //Classificació de cicle i curs segons edat
        if (edatMenor < EDAT3) {
            System.out.println("És massa petit");
        } else if (edatMenor < EDAT6) {
            cicle = 0;
        } else if (edatMenor < EDAT7) {
            cicle = 1;
            curs = 1;
        } else if (edatMenor < EDAT8) {
            curs = 2;
            cicle = 1;
        } else if (edatMenor < EDAT9) {
            curs = 3;
            cicle = 2;
        } else if (edatMenor < EDAT10) {
            curs = 4;
            cicle = 2;
        } else if (edatMenor < EDAT11) {
            curs = 5;
            cicle = 3;
        } else if (edatMenor < EDAT12) {
            curs = 6;
            cicle = 3;
        } else {
            System.out.println("És massa gran");
            cicle = 4;
            curs = 7;
        }
        //Determinació del cicle a cual correspon.
        switch (cicle) {
            case 0:
                System.out.println("És d'educació infantil");
                break;
            case 1:
                System.out.println("És d'educació primària. Cicle inicial.");
                break;
            case 2:
                System.out.println("És d'educació primària. Cicle mitjà");
                break;
            case 3:
                System.out.println("És d'educació primària. Cicle superior.");
                break;
            default:
                System.out.println("Ja comença l'Educació Secundària Obligatòria");
        }
        //Impresió del curs que li toca per edat.
        if (curs > 0) {
            System.out.println("El curs que ha de cursar és: " + curs);
        }
    }
}
