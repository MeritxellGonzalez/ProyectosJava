/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recorreguttotalmentocupat;

import java.util.Scanner;

/**
 *
 * @author 34633
 */
public class MarcProyecto {

    //Declarem constants
    private static final String MATES = "Matematiques";
    private static final String LECT = "Lectura";
    private static final String CAST = "Castellà";
    private static final String CAT = "Català";
    private static final String CIEN = "Ciencies";
    private static final String PROG = "Programació";
    private static final String TOT = "Totes";
    private static final String DONA = "Dona";
    private static final String HOME = "Home";
    private static final String NORESP = "---";
    private static final String PRIM = "primaria";
    private static final String SEC = "secundaria";
    private static final String SUP = "superior";
    private static final int ID_MIN = 21;
    private static final int ID_MAX = 499;
    private static final int GEN_MIN = 1;
    private static final int GEN_MAX = 3;
    private static final int NIV_MIN = 0;
    private static final int NIV_MAX = 2;
    private static final int AREA_PRIM_MIN = 0;
    private static final int AREA_PRIM_MAX = 4;
    private static final int AREA_SEC_MIN = 0;
    private static final int AREA_SEC_MAX = 6;
    private static final int EXP_MIN = 0;
    private static final int EXP_MAX = 90;
    private static final int AREA_SUP = 0;
    private static final int ALTRE_MIN = 0;
    private static final int ALTRE_MAX = 1;
    private static final int MAX_VOLUN = 10;

    public static void main(String[] args) {

        //Declarem variables
        int id[] = new int[MAX_VOLUN];
        int genere[] = new int[MAX_VOLUN];
        int nivell[] = new int[MAX_VOLUN];
        int area[] = new int[MAX_VOLUN];
        int exp[] = new int[MAX_VOLUN];

        int comptador = 0, altreUsu, voluntari = 0, ordena = 0, aux;
        int user = 0;
        int compPrim = 0, compSecu = 0, compSupe = 0;
        int index;
        String genereNom = null, areaNom = null, nivellNom = null;
        String comentari = "- ";
        String nivellPrim = "- ";
        String genereArr[] = null;
        int primaria[] = new int[MAX_VOLUN];
        int secundaria[] = new int[MAX_VOLUN];
        int superior[] = new int[MAX_VOLUN];

        boolean dadesCorrec = false;
        boolean introduirMes = true;

//Necesari per introduir dades pel teclat        
        Scanner entrada = new Scanner(System.in);

        do {        //tots els comentaria dels do while es troben a la part del while de cadascun
            introduirMes = false;
            do {
                System.out.println("Quin es el seu id?");
                /*Analitzem si introduim un valor enter (ho fem per totes les dades demanades per teclat com
  veurem al llarg del codi  */
                dadesCorrec = entrada.hasNextInt();
                if (dadesCorrec = true) {
                    id[user] = entrada.nextInt();
                    if (id[user] < ID_MIN || id[user] > ID_MAX) {
                        // En cas de que sigui menor que 21 o mayor de 499 sortira error i el programa s'atura
                        dadesCorrec = false;

                        comptador = comptador + 1;
                        System.out.println("ERROR!!!");
                    } else {
                        // Pero si està entre 21 i 499 farà la pregunta                
                        System.out.println("""
                                   Quin es el seu gènere?
                                   \t 1- Dona
                                   \t 2- Home
                                   \t 3- Prefereixo no respondre
                                   """);
                        comptador = 0;
                        do {
                            dadesCorrec = entrada.hasNextInt();
                            if (dadesCorrec = true) {
                                genere[user] = entrada.nextInt();
                                entrada.nextLine();
                                if (genere[user] < GEN_MIN || genere[user] > GEN_MAX) {
                                    dadesCorrec = false;

                                    comptador = comptador + 1;
                                    System.out.println("ERROR!!!");

                                } else {
                                    dadesCorrec = true;
                                    // Segons seleccionem ho guardarà a una variable constant, per utilitzar-la al resum final                        
                                    switch (genere[user]) {
                                        case 1:
                                            genereNom = DONA;
                                            break;
                                        case 2:
                                            genereNom = HOME;
                                            break;
                                        case 3:
                                            genereNom = NORESP;
                                            break;
                                    }

// Desprès d'haver introduit un enter entre 1 i 3 farà la pregunta                        
                                    System.out.println("""
                                           Quin es el nivell d'estudis?
                                           \t 0- Primaria
                                           \t 1- Secundaria
                                           \t 2- Superior
                                           """);
                                    comptador = 0;
                                    do {
                                        dadesCorrec = entrada.hasNextInt();
                                        if (dadesCorrec = true) {
                                            nivell[user] = entrada.nextInt();
                                            //entrada.nextLine();
                                            if (nivell[user] < NIV_MIN || nivell[user] > NIV_MAX) {
                                                dadesCorrec = false;
                                                System.out.println("NIVELL NIVELL");
                                                comptador = comptador + 1;
                                                System.out.println("ERROR!!!");
                                            } else {
                                                /* Quan ha evaluat a cert que hem introduit un valor enter entre 0 i 2 emmagatzemara
                                                el valor per ser utilitzat al resum                             
                                                 */
                                                dadesCorrec = true;
                                                switch (nivell[user]) {
                                                    case 0:
                                                        nivellNom = PRIM;
                                                        //compPrim++;
                                                        break;
                                                    case 1:
                                                        nivellNom = SEC;
                                                        //compSecu++;
                                                        break;
                                                    case 2:
                                                        nivellNom = SUP;
                                                        //compSupe++;
                                                        break;
                                                }
                                                if (nivell[user] == 0) {
// En cas d'haver seleccionat 0, sortirà el missatge per pantalla                                    
                                                    System.out.println("""
                                                       Quina es l'area de primaria que domines?
                                                       \t 1- Matemàtiques
                                                       \t 2- Lectura
                                                       \t 3- Castellà
                                                       \t 4- Català
                                                       \t 0- Totes
                                                       """);
                                                    comptador = 0;
                                                    do {
                                                        dadesCorrec = entrada.hasNextInt();
                                                        if (dadesCorrec = true) {
                                                            area[user] = entrada.nextInt();
                                                            entrada.nextLine();
                                                            if (area[user] < AREA_PRIM_MIN || area[user] > AREA_PRIM_MAX) {
                                                                dadesCorrec = false;

                                                                comptador = comptador + 1;
                                                                System.out.println("ERROR!!!");
                                                            } else {
                                                                dadesCorrec = true;
// Com ja es habitual, despres d'evaluar que es correcte els valors, emmagatzemarà el resultat a la constant                                            
                                                                switch (area[user]) {
                                                                    case 1:
                                                                        areaNom = MATES;
                                                                        break;
                                                                    case 2:
                                                                        areaNom = LECT;
                                                                        break;
                                                                    case 3:
                                                                        areaNom = CAST;
                                                                        break;
                                                                    case 4:
                                                                        areaNom = CAT;
                                                                        break;
                                                                    case 0:
                                                                        areaNom = TOT;
                                                                        break;
                                                                }

// Si s'ha complert totes les evaluacions farà la pregunta                                            
                                                                System.out.println("Quants anys té d'experiencia en " + areaNom + " ?");
                                                                comptador = 0;
                                                                do {
                                                                    System.out.println("EXPERIENCIA PRIMARIA");
                                                                    dadesCorrec = entrada.hasNextInt();
                                                                    if (dadesCorrec = true) {
                                                                        exp[user] = entrada.nextInt();
                                                                        entrada.nextLine();
                                                                        if (exp[user] < EXP_MIN || exp[user] > EXP_MAX) {
                                                                            dadesCorrec = false;

                                                                            comptador = comptador + 1;
                                                                            System.out.println("ERROR!!!");
                                                                        } else {
// Un cop evaluades totes les preguntes, si tot ha estat correcte, imprimirem el resum final   
                                                                            dadesCorrec = true;
                                                                            voluntari++;
                                                                        }
                                                                    }
                                                                } //do while per repetir la pregunta de EXPERIENCIA de NIVELL PRIMARIA en cas de que surti error de dades.
                                                                while (!dadesCorrec && comptador < 3);

                                                            }
                                                        }
                                                    } //do while per repetir la pregunta de AREA de NIVELL PRIMARIA en cas de que surti error de dades.
                                                    while (!dadesCorrec && comptador < 3);

                                                } else {
                                                    if (nivell[user] == 1) {
// Si hem seleccionat 1 al nivell, es a dir, SECUNDARIA, ens fara la pregunta                                        
                                                        System.out.println("""
                                                           Quina es l'area de secundaria que domina?
                                                           \t 1- Matemàtiques
                                                           \t 2- Lectura
                                                           \t 3- Castellà
                                                           \t 4- Català
                                                           \t 5- Ciencies
                                                           \t 6- Programació
                                                           \t 0- Totes
                                                           """);
                                                        comptador = 0;
                                                        do {
                                                            dadesCorrec = entrada.hasNextInt();
                                                            if (dadesCorrec = true) {
                                                                area[user] = entrada.nextInt();
                                                                entrada.nextLine();
                                                                if (area[user] < AREA_SEC_MIN || area[user] > AREA_SEC_MAX) {
                                                                    dadesCorrec = false;

                                                                    comptador = comptador + 1;
                                                                    System.out.println("ERROR!!!");
                                                                } else {
// Si es troba entre el 0 i el 6 continuara i emmagatzemara el resultat a la constant areaNom                                                
                                                                    switch (area[user]) {
                                                                        case 1:
                                                                            areaNom = MATES;
                                                                            break;
                                                                        case 2:
                                                                            areaNom = LECT;
                                                                            break;
                                                                        case 3:
                                                                            areaNom = CAST;
                                                                            break;
                                                                        case 4:
                                                                            areaNom = CAT;
                                                                            break;
                                                                        case 5:
                                                                            areaNom = CIEN;
                                                                            break;
                                                                        case 6:
                                                                            areaNom = PROG;
                                                                            break;
                                                                        case 0:
                                                                            areaNom = TOT;
                                                                            break;
                                                                    }
// Un cop es tot correcte preguntara per pantalla l'experiencia com al nivell 0 PRIMARIA                                                
                                                                    System.out.println("Quants anys té d'experiencia en " + areaNom + " ?");
                                                                    comptador = 0;
                                                                    do {
                                                                        dadesCorrec = entrada.hasNextInt();
                                                                        if (dadesCorrec = true) {
                                                                            exp[user] = entrada.nextInt();
                                                                            entrada.nextLine();
                                                                            if (exp[user] < EXP_MIN || exp[user] > EXP_MAX) {
                                                                                dadesCorrec = false;

                                                                                comptador = comptador + 1;
                                                                                System.out.println("ERROR!!!");
                                                                            } else {
                                                                                voluntari++;
                                                                            }
                                                                        }
                                                                    } //do while per repetir la pregunta de EXPERIENCIA de NIVELL SECUNDARIA en cas de que surti error de dades.
                                                                    while (!dadesCorrec && comptador < 3);

                                                                }
                                                            }
                                                        } //do while per repetir la pregunta de AREA de NIVELL SECUNDARIA en cas de que surti error de dades.
                                                        while (!dadesCorrec && comptador < 3);

                                                    } else {
                                                        if (nivell[user] == 2) {
                                                            System.out.println("""
                                                           Quina es l'area de secundaria que domina?
                                                           \t 0- Totes
                                                           """);
                                                            comptador = 0;
                                                            do {
                                                                dadesCorrec = entrada.hasNextInt();
                                                                if (dadesCorrec = true) {
                                                                    area[user] = entrada.nextInt();
                                                                    entrada.nextLine();
                                                                    if (area[user] < AREA_SUP || area[user] > AREA_SUP) {
                                                                        dadesCorrec = false;
                                                                        //En cas que no estigui dins la condicio sumarem 1 al contador d'errors     
                                                                        comptador = comptador + 1;
                                                                        System.out.println("ERROR!!!");
                                                                    } else {
                                                                        switch (area[user]) {
                                                                            case 0:
                                                                                areaNom = TOT;
                                                                                break;
                                                                        }
                                                                        System.out.println("Quants anys té d'experiencia en " + areaNom + " ?");

                                                                        /*Inicialitzem el comptador d'errors a 0, per tal de que no sumi
                                                                   entre unes i altres preguntes que hem posat malament la resposta.*/
                                                                        comptador = 0;
                                                                        do {
                                                                            dadesCorrec = entrada.hasNextInt();
                                                                            if (dadesCorrec = true) {
                                                                                exp[user] = entrada.nextInt();
                                                                                entrada.nextLine();
                                                                                if (exp[user] < EXP_MIN || exp[user] > EXP_MAX) {

                                                                                    dadesCorrec = false;
                                                                                    //En cas que no estigui dins la condicio sumarem 1 al contador d'errors
                                                                                    comptador = comptador + 1;
                                                                                    System.out.println("ERROR!!!");

                                                                                } else {

                                                                                }
                                                                            }
                                                                        } //do while per repetir la pregunta de EXPERIENCIA de NIVELL SUPERIOR en cas de que surti error de dades.     
                                                                        while (!dadesCorrec && comptador < 3);
                                                                    }
                                                                }
                                                            } //do while per repetir la pregunta de AREA de NIVELL SUPERIOR en cas de que surti error de dades.     
                                                            while (!dadesCorrec && comptador < 3);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } //do while per repetir la pregunta de NIVELL en cas de que surti error de dades.
                                    while (!dadesCorrec && comptador < 3);
                                }
                            }
                        } //do while per repetir la pregunta del GENERE en cas de que surti error de dades.     
                        while (!dadesCorrec && comptador < 3);
                    }
                }
                //do while per repetir la pregunta de l'ID en cas de que surti error de dades.    
            } while (!dadesCorrec && comptador < 3);
            
            //Preguntem si vol introduir un altre usuari
            System.out.println("Es vol introduir un altre voluntari?\n\t0- No\n\t1- Si ");
            dadesCorrec = entrada.hasNextInt();
            if (dadesCorrec = true) {
                altreUsu = entrada.nextInt();
                entrada.nextLine();
                if (altreUsu <= ALTRE_MIN || altreUsu >= ALTRE_MAX) {
                    switch (altreUsu) {
                        case 0:
                            introduirMes = false;
                            user++;

                            break;

                        case 1:
                            introduirMes = true;
                            user++;

                            break;

                        default:
                            dadesCorrec = false;
                    }
                    if (dadesCorrec = true) {
                        
                    } else {
                        System.err.println("¡¡Error!!");
                        entrada.nextLine();
                    }
                }
            }

        }//do while per introduïr un altre voluntari
        while (introduirMes);

        System.out.println("\n\033[0;1m\u001B[47;35mId\t\tGenere\t\tNivell\t\t\tArea\t\t\tExperiencia\033[0m");

        for (int i = 0; i < user; i++) {
            switch (genere[i]) {
                case 1:
                    genereNom = DONA;
                    break;
                case 2:
                    genereNom = HOME;
                    break;
                case 3:
                    genereNom = NORESP;
                    break;
            }
            switch (nivell[i]) {
                case 0:
                    nivellNom = PRIM;
                    break;
                case 1:
                    nivellNom = SEC;
                    break;
                case 2:
                    nivellNom = SUP;
                    break;

            }
            switch (area[i]) {
                case 1:
                    areaNom = MATES;
                    break;
                case 2:
                    areaNom = LECT;
                    break;
                case 3:
                    areaNom = CAST;
                    break;
                case 4:
                    areaNom = CAT;
                    break;
                case 5:
                    areaNom = CIEN;
                    break;
                case 6:
                    areaNom = PROG;
                    break;
                case 0:
                    areaNom = TOT;
                    break;
            }

            System.out.println(id[i] + "\t\t" + genereNom + "\t\t" + nivellNom + "\t\t" + areaNom + "\t\t\t" + exp[i]);
            //System.out.println("\n\033[0;1m\u001B[47;35m Comentaris voluntari: \033[0m\n\t" + comentari + ".");

        }

        System.out.println("\n\nVols mostrar de cada nivell endreçats per experiencia?\n\t0- No\n\t1- Si ");
        if (entrada.hasNextInt()) {
            ordena = entrada.nextInt();
            switch (ordena) {
                case 0:
                    dadesCorrec = false;
                    break;
                case 1:
                    dadesCorrec = true;
                    break;

                default:
                    System.out.println("Error");

            }

            System.out.println("\nS'han introduït \033[0;1m\u001B[47;35m" + voluntari + "\033[0m registres de voluntaris");
            
            //comptador++;

        }

        if (ordena == 1 && user < MAX_VOLUN) {
            System.out.println("\n\t---- Voluntaris de cada nivell ordenats per experiència ----");
            for (int i = 0; i < user - 1; i++) {
                for (int j = i + 1; j < user; j++) {
                    if (nivell[i] > nivell[j]) {

                        aux = id[i];
                        id[i] = id[j];
                        id[j] = aux;

                        aux = genere[i];
                        genere[i] = genere[j];
                        genere[j] = aux;

                        aux = nivell[i];
                        nivell[i] = nivell[j];
                        nivell[j] = aux;

                        aux = area[i];
                        area[i] = area[j];
                        area[j] = aux;

                        aux = exp[i];
                        exp[i] = exp[j];
                        exp[j] = aux;

                    }
                }
            }

            for (int i = 0; i < user - 1; i++) {
                for (int j = i + 1; j < user; j++) {
                    if (exp[i] < exp[j]) {

                        aux = id[i];
                        id[i] = id[j];
                        id[j] = aux;

                        aux = genere[i];
                        genere[i] = genere[j];
                        genere[j] = aux;

                        aux = nivell[i];
                        nivell[i] = nivell[j];
                        nivell[j] = aux;

                        aux = area[i];
                        area[i] = area[j];
                        area[j] = aux;

                        aux = exp[i];
                        exp[i] = exp[j];
                        exp[j] = aux;

                    }
                }
            }

            for (int k = 0; k < user; k++) {
                switch (genere[k]) {
                    case 1:
                        genereNom = DONA;
                        break;
                    case 2:
                        genereNom = HOME;
                        break;
                    case 3:
                        genereNom = NORESP;
                        break;
                }
                switch (nivell[k]) {
                    case 0:
                        nivellNom = PRIM;
                        break;
                    case 1:
                        nivellNom = SEC;
                        break;
                    case 2:
                        nivellNom = SUP;
                        break;
                }
                switch (area[k]) {
                    case 1:
                        areaNom = MATES;
                        break;
                    case 2:
                        areaNom = LECT;
                        break;
                    case 3:
                        areaNom = CAST;
                        break;
                    case 4:
                        areaNom = CAT;
                        break;
                    case 5:
                        areaNom = CIEN;
                        break;
                    case 6:
                        areaNom = PROG;
                        break;
                    case 0:
                        areaNom = TOT;
                        break;
                }

                if (nivellPrim != nivellNom) {
                    System.out.println("\n\033[0;1m\u001B[47;35m" + nivellNom + "\033[0m");

                    System.out.println("\033[0;1m\u001B[47;35mId\t\tGenere\t\tNivell\t\t\tArea\t\t\tExperiencia\033[0m");
                    nivellPrim = nivellNom;

                }

                System.out.println(id[k] + "\t\t" + genereNom + "\t\t" + nivellNom + "\t\t" + areaNom + "\t\t\t" + exp[k]);
            }
        }
    }
}
