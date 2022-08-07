package p3_mgonzalez;

import java.util.Scanner;

/*
@MERITXELL GONZALEZ
 */
public class P3_MGonzalez {

    public static final int VALOR_MIN = 1;
    public static final int VALOR_MAX = 10;
    public static final int GENERE_DONA = 1;
    public static final int GENERE_HOME = 2;
    public static final int GENERE_NORESPON = 3;
    public static final String GEN_DONA = "DONA";
    public static final String GEN_HOME = "HOME";
    public static final String GEN_NRESP = "---";
    public static final int PRIMARIA = 0;
    public static final int SECUNDARIA = 1;
    public static final int SUPERIOR = 2;
    public static final String EDU_PRIMARIA = "PRIMARIA";
    public static final String EDU_SECUNDARIA = "SECUNDARIA";
    public static final String EDU_SUPERIOR = "SUPERIOR";
    public static final int TOTES = 0;
    public static final int MAT = 1;
    public static final int LEC_PRIMARIA = 2;
    public static final int ANG = 2;
    public static final int CASTELLA = 3;
    public static final int CATALA = 4;
    public static final int CIEN = 5;
    public static final int PREFERIDA = 6;
    public static final String TOT = "TOTES";
    public static final String MATES = "MATEMÀTIQUES";
    public static final String DOS_PUNTO_CERO = "LECTURA";
    public static final String DOS_PUNTO_UNO = "ANGLES";
    public static final String CASTE = "CASTELLÀ";
    public static final String CAT = "CATALÀ";
    public static final String CIENCIA = "CIÈNCIES";
    public static final String PREFE = "INFORMÀTICA";
    public static final int LIMIT_MIN = 21;
    public static final int LIMIT_MAX = 499;
    public static final int EXP_MIN = 0;
    public static final int EXP_MAX = 90;
    public static final int INTENTS_MAX = 3;
    public static final int RESPOSTA_NO = 0;
    public static final int RESPOSTA_SI = 1;
    public static final int USUARIS_MAX = 10;

    public static void main(String[] args) {
        //Declarem variables.
        Scanner entrada = new Scanner(System.in);
        //Variable array per a cada pregunta.
        //int NumVoluntaris = 0;
        int idArray[] = new int[USUARIS_MAX];
        int genereArray[] = new int[USUARIS_MAX];
        int nivellArray[] = new int[USUARIS_MAX];
        int anysExp[] = new int[USUARIS_MAX];
        int areaArray[] = new int[USUARIS_MAX];
        int comptador = 0;
        int comptadorVoluntarisRegistrats = 0;
        int resposta = 0;
        int index = 0;
        int aux;
        int ordena = 0;
        //variables per imprimir ordenat
        int ind = 0;
        int conta_primaria = 0;
        int conta_secundaria = 0;
        int conta_superior = 0;
        //semàfors
        boolean dadaCorrecta = false;
        boolean introduirMes = true;
        //Strings
        String sexe = null;
        String nivell = null;
        String area = null;
        String nivellPrim = "- ";

        /*
        COMENCEM EL PROGRAMA.
         */
        do {
            introduirMes = false;
            do {
                System.out.println("Benvinguts/des al programa de VOLUNTARIS PER L'EDUCACIÓ!");
                System.out.println("Diguem el teu número de voluntari?");
                dadaCorrecta = entrada.hasNextInt();
                if (dadaCorrecta) {
                    idArray[index] = entrada.nextInt();
                    if (idArray[index] >= LIMIT_MIN && idArray[index] <= LIMIT_MAX) {
                        dadaCorrecta = true;
                    } else {
                        dadaCorrecta = false;
                        System.out.println("Error");

                    }
                } else {
                    dadaCorrecta = false;
                    entrada.next();
                    System.out.println("Entrada no reconeguda com a dada ");
                }
                comptador++;
            } while ((!dadaCorrecta) && (comptador < INTENTS_MAX));

            /*
        SI LES DADES ANTERIORS SON CORRECTES, CONTINUA.
        PREGUNTEM EL GENERE.
             */
            if (dadaCorrecta == true) {
                comptador = 0;
                do {

                    //PREGUNTEM EL GENERE DEL VOLUNTARI QUE S'ESTA REGISTRANT
                    System.out.println("Quin és el teu génere:\n\tDona--> " + GENERE_DONA + " \n\tHome--> " + GENERE_HOME + "\n\tNo vull respondre --> " + GENERE_NORESPON + " ");
                    dadaCorrecta = entrada.hasNextInt();
                    if (dadaCorrecta) {
                        genereArray[index] = entrada.nextInt();
                        if (genereArray[index] >= GENERE_DONA || genereArray[index] <= GENERE_NORESPON) {
                            dadaCorrecta = true;
                            if (genereArray[index] == GENERE_DONA) {
                                System.out.println("Ha escollit: " + GENERE_DONA + ". És a dir: DONA");
                                dadaCorrecta = true;
                            } else if (genereArray[index] == GENERE_HOME) {
                                System.out.println("Ha escollit: " + GENERE_HOME + ". És a dir: HOME");
                                dadaCorrecta = true;
                            } else if (genereArray[index] == GENERE_NORESPON) {
                                System.out.println("Ha escollit: " + GENERE_NORESPON + ". És a dir: NO RESPON");
                                dadaCorrecta = true;
                            } else {
                                dadaCorrecta = false;
                                System.out.println(" Dada no valida.");
                            }

                        }
                    } else {

                        //SI LA DADA INTRODUÏDA NO ES CORRECTA.
                        System.out.println("Error dada introduïda");
                        dadaCorrecta = false;
                        entrada.next();
                    }
                    comptador++;
                } while ((dadaCorrecta == false) && (comptador < INTENTS_MAX));//CONDICIÓ DEL bucle
            }

            do {
                if (dadaCorrecta) {
                    comptador = 0;
                    do {
                        System.out.println("Quin és el Nivell en el que podries aportar: \n\t(0).PRIMARIA\n\t(1).SECUNDARIA\n\t(2).SUPERIOR");

                        dadaCorrecta = entrada.hasNextInt();
                        if (dadaCorrecta) {
                            nivellArray[index] = entrada.nextInt();
                            if ((nivellArray[index] == PRIMARIA) || (nivellArray[index] == SECUNDARIA) || (nivellArray[index] == SUPERIOR)) {
                                dadaCorrecta = true;
                                switch (nivellArray[index]) {
                                    case PRIMARIA:
                                        //nivellArray[inte] = primariaArray[inte];
                                        System.out.println("Per a PRIMÀRIA les matèries disponibles a escollir són:\n\t(0).TOTES\n\t(1).MATES\n\t(2).LECTURA\n\t(3).CASTELLÀ\n\t(4).CATALÀ");
                                        conta_primaria++;
                                        break;
                                    case SECUNDARIA:
                                        //nivellArray[inte] = secundariaArray[inte];
                                        System.out.println("Per a SECUNDARIA les matèries disponibles a escollir són:\n\t(0).TOTES\n\t(1).MATES\n\t(2).ANGLÉS\n\t(3).CASTELLÀ\n\t(4).CATALÀ\n\t(5).CIÈNCIA\n\t(6).INFORMÀTICA");
                                        conta_secundaria++;
                                        break;
                                    case SUPERIOR:
                                        // nivellArray[i] = superiorArray[i];
                                        System.out.println("Per a SUPERIOR és necessari que es cobreixin TOTES. Si us plau, premeu el " + TOTES + ". ");
                                        conta_superior++;
                                        break;
                                    default:
                                        System.out.println("Ops! En aquests moment només cobrim PRIMARIA,SECUNDARIA o SUPERIOR. ");
                                        comptador++;
                                        dadaCorrecta = false;
                                }

                                if (dadaCorrecta == true) {
                                    do {
                                        System.out.println("En quina ÀREA vols participar?");
                                        dadaCorrecta = entrada.hasNextInt();
                                        if (dadaCorrecta) {
                                            areaArray[index] = entrada.nextInt();
                                            switch (nivellArray[index]) {
                                                case PRIMARIA:
                                                    switch (areaArray[index]) {
                                                        case TOTES:
                                                        case MAT:
                                                        case LEC_PRIMARIA:
                                                        case CASTELLA:
                                                        case CATALA:
                                                            break;
                                                        default:
                                                            System.out.println("No es contempla aquesta materia");
                                                            dadaCorrecta = false;
                                                    }
                                                    break;

                                                case SECUNDARIA:

                                                    switch (areaArray[index]) {
                                                        case TOTES:
                                                        case MAT:
                                                        case ANG:
                                                        case CASTELLA:
                                                        case CATALA:
                                                        case CIEN:
                                                        case PREFERIDA:
                                                            break;
                                                        default:
                                                            System.out.println("No es contempla aquesta materia");
                                                            dadaCorrecta = false;
                                                    }
                                                    break;
                                                case SUPERIOR:

                                                    switch (areaArray[index]) {
                                                        case TOTES:
                                                            dadaCorrecta = true;
                                                            break;
                                                        default:
                                                            System.out.println("Recorda que per aquest nivell, s'ha d'inscriure a TOTES.");
                                                            dadaCorrecta = false;
                                                    }
                                                    break;

                                            }
                                        }
                                        comptador++;
                                    } while ((dadaCorrecta == false) && (comptador < INTENTS_MAX));
                                }
                            } else {
                                dadaCorrecta = false;
                                System.out.println("No es contempla com a dadaCorrecta.");
                                entrada.nextLine();
                            }
                        } else {
                            System.out.println("Error dada introduïda");
                            dadaCorrecta = false;
                            entrada.nextLine();
                        }
                        comptador++;
                    } while ((!dadaCorrecta) && (comptador < INTENTS_MAX));

                } else {
                    System.out.println("Error dada introduïda");
                    dadaCorrecta = false;
                    entrada.nextLine();

                }
                comptador++;
            } while ((dadaCorrecta == false) && (comptador < INTENTS_MAX));
            if (dadaCorrecta == true) {
                do {
                    comptador = 0;
                    System.out.println("Quants anys d'experiencia pots aportar?");
                    dadaCorrecta = entrada.hasNextInt();
                    if (dadaCorrecta) {
                        anysExp[index] = entrada.nextInt();
                        if (anysExp[index] >= EXP_MIN && anysExp[index] <= EXP_MAX) {
                            dadaCorrecta = true;
                            comptadorVoluntarisRegistrats++;
                        } else {
                            dadaCorrecta = false;
                            System.out.println("El valor del anys d'experiencia ha d'estar entre: " + EXP_MIN + " i " + EXP_MAX + ". Torna-ho a intentar:");
                        }
                    } else {
                        System.out.println("El valor del anys d'experiencia ha d'estar entre: " + EXP_MIN + " i " + EXP_MAX + ".");
                        dadaCorrecta = false;
                        entrada.next();
                    }
                    comptador++;
                } while ((dadaCorrecta == false) && (comptador < INTENTS_MAX));
            } else {
                dadaCorrecta = false;

            }
            if (dadaCorrecta) {
                index++;
            } else {
                System.out.println("Dades erronies.");

            }

            if (index < USUARIS_MAX) {
                System.out.println("Vols introduïr les dades d'un altre voluntari?\n\t(1).SI\n\t(0).NO");
                dadaCorrecta = entrada.hasNextInt();
                if (dadaCorrecta) {
                    resposta = entrada.nextInt();
                    if (resposta == RESPOSTA_SI) {
                        introduirMes = true;
                        System.out.println("D'acord.");

                    } else if (resposta == RESPOSTA_NO) {
                        introduirMes = false;
                        System.out.println("Moltes gràcies");
                        System.out.println("Els usuaris/es registrats són:\n");
                        for (int j = 0; j < index; j++) {
                            System.out.println("Els ID registrats:      Els GENERES registrats:       Els NIVELLS registrats:       L'AREA resgistrada:       L'EXPERIENCIA registrada:");
                            System.out.println(idArray[j] + "                             " + genereArray[j] + "                            " + nivellArray[j] + "                            " + areaArray[j] + "                              " + anysExp[j]);
                        }
                    }

                } else {
                    dadaCorrecta = false;
                    entrada.next();
                }

            }
        } while ((introduirMes) && (index < USUARIS_MAX) && (resposta == RESPOSTA_SI));

        System.out.println("\nS'han registrat: " + comptadorVoluntarisRegistrats + " voluntaris.");
        System.out.println("\n\033[0;1m\u001B[47;35mId\t\tGenere\t\tNivell\t\t\tArea\t\t\tExperiencia\033[0m");

        for (int i = 0; i < index; i++) {
            switch (genereArray[i]) {
                case GENERE_DONA:
                    sexe = GEN_DONA;
                    break;
                case GENERE_HOME:
                    sexe = GEN_HOME;
                    break;
                case GENERE_NORESPON:
                    sexe = GEN_NRESP;
                    break;
            }
            switch (nivellArray[i]) {
                case PRIMARIA:
                    nivell = EDU_PRIMARIA;
                    break;
                case SECUNDARIA:
                    nivell = EDU_SECUNDARIA;
                    break;
                case SUPERIOR:
                    nivell = EDU_SUPERIOR;
                    break;

            }
            switch (areaArray[i]) {
                case MAT:
                    area = MATES;
                    break;
                case 2:
                    if (nivellArray[i] == PRIMARIA) {
                        area = DOS_PUNTO_CERO;
                    }
                    if (nivellArray[i] == SECUNDARIA) {
                        area = DOS_PUNTO_UNO;
                    }
                    break;
                case CASTELLA:
                    area = CASTE;
                    break;
                case CATALA:
                    area = CAT;
                    break;
                case CIEN:
                    area = CIENCIA;
                    break;
                case PREFERIDA:
                    area = PREFE;
                    break;
                case TOTES:
                    area = TOT;
                    break;
            }

            System.out.println(idArray[i] + "\t\t" + sexe + "\t\t" + nivell + "\t\t" + area + "\t\t\t" + anysExp[i]);
            //System.out.println("\n\033[0;1m\u001B[47;35m Comentaris voluntari: \033[0m\n\t" + comentari + .");

        }
        System.out.println("Vols que es mostri ordenat per NIVELL i, per cada NIVELL que es mostri ordenat per EXPERIÈNCIA?\n\t(0).NO\n\t(1).SI");
        dadaCorrecta = entrada.hasNextInt();
        if (dadaCorrecta) {

            ordena = entrada.nextInt();
            switch (ordena) {
                case 0:
                    dadaCorrecta = false;
                    break;
                case 1:
                    dadaCorrecta = true;
                    break;
                default:
                    System.out.println("Error");
                    entrada.next();
            }

        } else {
            entrada.nextLine();
        }
        if (ordena == 1 && index < USUARIS_MAX) {
            //SI DIU QUE SI A ORDENAR, ORDENEM;

            for (int i = 0; i < index - 1; i++) {
                //BUCLE INTERN
                for (int j = i + 1; j < index; j++) {
                    //RECORREM POSICIONS DE L'ARRAY I ORDENEM NIVELL
                    if (nivellArray[i] < nivellArray[j]) {
                        //INTERCANVIEM DADES
                        aux = idArray[i];
                        idArray[i] = idArray[j];
                        idArray[j] = aux;

                        aux = genereArray[i];
                        genereArray[i] = genereArray[j];
                        genereArray[j] = aux;

                        aux = nivellArray[i];
                        nivellArray[i] = nivellArray[j];
                        nivellArray[j] = aux;

                        aux = areaArray[i];
                        areaArray[i] = areaArray[j];
                        areaArray[j] = aux;

                        aux = anysExp[i];
                        anysExp[i] = anysExp[j];
                        anysExp[j] = aux;

                    }
                }
            }

            for (int i = 0; i < index - 1; i++) {
                //BUCLE INTERN
                for (int j = i + 1; j < index; j++) {
                    //RECORREM I ORDENEM L'ARRAY 
                    if (anysExp[i] < anysExp[j] && nivellArray[i] == nivellArray[j]) {
                        //SI COMPLEIX LA CONDICIÓ DEL IF INTERCANVIA DADES.

                        aux = idArray[i];
                        idArray[i] = idArray[j];
                        idArray[j] = aux;

                        aux = genereArray[i];
                        genereArray[i] = genereArray[j];
                        genereArray[j] = aux;

                        aux = nivellArray[i];
                        nivellArray[i] = nivellArray[j];
                        nivellArray[j] = aux;

                        aux = areaArray[i];
                        areaArray[i] = areaArray[j];
                        areaArray[j] = aux;

                        aux = anysExp[i];
                        anysExp[i] = anysExp[j];
                        anysExp[j] = aux;

                    }
                }
            }
            //RENOMENEM VARIABLE INT A STRING
            for (int k = 0; k < index; k++) {
                switch (genereArray[k]) {
                    case GENERE_DONA:
                        sexe = GEN_DONA;
                        break;
                    case GENERE_HOME:
                        sexe = GEN_HOME;
                        break;
                    case GENERE_NORESPON:
                        sexe = GEN_NRESP;
                        break;
                }
                switch (nivellArray[k]) {
                    case 0:
                        nivell = EDU_PRIMARIA;
                        break;
                    case 1:
                        nivell = EDU_SECUNDARIA;
                        break;
                    case 2:
                        nivell = EDU_SUPERIOR;
                        break;
                }
                switch (areaArray[k]) {
                    case 1:
                        area = MATES;
                        break;
                    case 2:
                        if (nivellArray[k] == PRIMARIA) {
                            area = DOS_PUNTO_CERO;
                        }
                        if (nivellArray[k] == SECUNDARIA) {
                            area = DOS_PUNTO_UNO;
                        }
                        break;
                    case CASTELLA:
                        area = CASTE;
                        break;
                    case CATALA:
                        area = CAT;
                        break;
                    case CIEN:
                        area = CIENCIA;
                        break;
                    case PREFERIDA:
                        area = PREFE;
                        break;
                    case TOTES:
                        area = TOT;
                        break;
                }
                //AGRUPEM PER NIVELL I IMPRIMIM.
                if (nivellPrim != nivell) {
                    System.out.println("\t\t\t" + nivell + "\t\t\t");

                    System.out.println("Id\t\tGenere\t\tNivell\t\t\tArea\t\t\tExperiencia");
                    nivellPrim = nivell;

                }

                System.out.println(idArray[k] + "\t\t" + sexe + "\t\t" + nivell + "\t\t" + area + "\t\t\t" + anysExp[k]);
            }
        }
    }
}
