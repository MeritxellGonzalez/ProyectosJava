package p3_mgonzalez;

import java.util.Scanner;

public class ProjecteProvaGrup {

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
    public static final String MATES = "MATEMÃ€TIQUES";
    public static final String DOS_PUNTO_CERO = "LECTURA";
    public static final String DOS_PUNTO_UNO = "ANGLES";
    public static final String CASTE = "CASTELLÃ€";
    public static final String CAT = "CATALÃ€";
    public static final String CIENCIA = "CIÃˆNCIES";
    public static final String PREFE = "INFORMÃ€TICA";
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

        int usrArray[][] = new int[5][USUARIS_MAX];
        /*
        FEM SERVIR TAL I COM L'ENUNCIAT HO DEMANA UN SOL ARRAY. ON [5] ES EL NÚMERO DE COLUMNES
        DE LA "TAULA" i, [USUARIS_MAX] ÉS EL NÚMERO MÁXIM D'USUARIS QUE POSEM COM A MÁXIM.
         */
        int comptador = 0;
        int comptadorVoluntarisRegistrats = 0;
        int resposta = 0;
        int index = 0;
        int aux;
        int ordena = 0;
        //variables per imprimir ordenat

        int conta_primaria = 0;
        int conta_secundaria = 0;
        int conta_superior = 0;
        //semáfors
        boolean dadaCorrecta = false;
        boolean introduirMes = true;
        //Strings
        String sexe = "";
        String nivell = "";
        String area = "";
        String nivellPrim = "- ";
        int mitjana_primaria = 0;
        int comtpador = 0;
        int Resposta_mitjana;
        int suma_primaria = 0;
        int suma_secundaria = 0;
        int suma_superior = 0;
        int mitjana_secundaria = 0;
        int mitjana_superior = 0;
        int primaria = 0;
        int secundaria = 0;
        int superior = 0;
        boolean valorem_mitjana = false;
        /*
        COMENCEM EL PROGRAMA.
         */
        do {
            introduirMes = false;
            do {
                System.out.println("Benvinguts/des al programa de VOLUNTARIS PER L'EDUCACIó!");
                System.out.println("Diguem el teu número de voluntari?");
                dadaCorrecta = entrada.hasNextInt();
                if (dadaCorrecta) {
                    usrArray[0][index] = entrada.nextInt();
                    //EL CAMP DE ID ÉS LA POSICIÓ DE LA COLUMNA [0] I LA POSICIÓ DE LA FILA SERÀ EL QUE MARCA LA VARIABLE INDEX, QUE ES [0].I,
                    //EMMAGATZAMEM LA DADA INTRODUIDA DINTRE DE L'ARRAY BIDIMENSIONAL.
                    if (usrArray[0][index] >= LIMIT_MIN && usrArray[0][index] <= LIMIT_MAX) {
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
                    System.out.println("Quin Ã©s el teu gÃ©nere:\n\tDona--> " + GENERE_DONA + " \n\tHome--> " + GENERE_HOME + "\n\tNo vull respondre --> " + GENERE_NORESPON + " ");
                    dadaCorrecta = entrada.hasNextInt();
                    if (dadaCorrecta) {
                        //EL CAMP DE GENERE ÉS [1] I, LA POSICIÓ DINS DE LA FILA EN LA PRIMERA SEGUEIX SIGUENT [0].
                        usrArray[1][index] = entrada.nextInt();
                        if (usrArray[1][index] >= GENERE_DONA || usrArray[1][index] <= GENERE_NORESPON) {
                            dadaCorrecta = true;
                            if (usrArray[1][index] == GENERE_DONA) {
                                System.out.println("Ha escollit: " + GENERE_DONA + ". Ã‰s a dir: DONA");
                                dadaCorrecta = true;
                            } else if (usrArray[1][index] == GENERE_HOME) {
                                System.out.println("Ha escollit: " + GENERE_HOME + ". Ã‰s a dir: HOME");
                                dadaCorrecta = true;
                            } else if (usrArray[1][index] == GENERE_NORESPON) {
                                System.out.println("Ha escollit: " + GENERE_NORESPON + ". Ã‰s a dir: NO RESPON");
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
                            //[2] CORRESPON A NIVELL I L'INDEX A LA PRIMERA VOLTA SEGUEIX SIGUENT [0].
                            usrArray[2][index] = entrada.nextInt();
                            if ((usrArray[2][index] == PRIMARIA) || (usrArray[2][index] == SECUNDARIA) || (usrArray[2][index] == SUPERIOR)) {
                                dadaCorrecta = true;
                                switch (usrArray[2][index]) {
                                    case PRIMARIA:
                                        
                                        System.out.println("Per a PRIMARIA les materies disponibles a escollir són:\n\t(0).TOTES\n\t(1).MATES\n\t(2).LECTURA\n\t(3).CASTELLÃ€\n\t(4).CATALÃ€");
                                        conta_primaria++;
                                        break;
                                    case SECUNDARIA:
                                        
                                        System.out.println("Per a SECUNDARIA les materies disponibles a escollir són:\n\t(0).TOTES\n\t(1).MATES\n\t(2).ANGLÉS\n\t(3).CASTELLÀ\n\t(4).CATALÀ\n\t(5).CIÈNCIA\n\t(6).INFORMÀTICA");
                                        conta_secundaria++;
                                        break;
                                    case SUPERIOR:
                                        
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
                                            usrArray[3][index] = entrada.nextInt();
                                            switch (usrArray[2][index]) {
                                                case PRIMARIA:
                                                    switch (usrArray[3][index]) {
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

                                                    switch (usrArray[3][index]) {
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

                                                    switch (usrArray[3][index]) {
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
                    System.out.println("Quants anys d'experiéncia pots aportar?");
                    dadaCorrecta = entrada.hasNextInt();
                    if (dadaCorrecta) {
                        usrArray[4][index] = entrada.nextInt();
                        if (usrArray[4][index] >= EXP_MIN && usrArray[4][index] <= EXP_MAX) {
                            dadaCorrecta = true;
                            comptadorVoluntarisRegistrats++;
                            comtpador++;
                        } else {
                            dadaCorrecta = false;
                            System.out.println("El valor del anys d'experiéncia ha d'estar entre: " + EXP_MIN + " i " + EXP_MAX + ". Torna-ho a intentar:");
                        }
                    } else {
                        System.out.println("El valor del anys d'experiéncia ha d'estar entre: " + EXP_MIN + " i " + EXP_MAX + ".");
                        dadaCorrecta = false;
                        entrada.next();
                    }
                    comptador++;
                } while ((dadaCorrecta == false) && (comptador < INTENTS_MAX));
            } else {
                dadaCorrecta = false;

            }
            //AUMENTEM INDEX EN 1.
            if (dadaCorrecta) {
                index++;
            } else {
                System.out.println("Dades erronies.");

            }
            //COMPROVEM INDEX NO SIGUI SUPERIOR A 10 I PREGUNTEM SI VOL INTRODUIR CAP USUARI MES.
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
                            
                            System.out.println("Els ID registrats:\tEls GENERES registrats:\tEls NIVELLS registrats:\tL'AREA resgistrada:\tL'EXPERIENCIA registrada:");
                            System.out.println(usrArray[0][j] + "\t\t\t" + usrArray[1][j] + "\t\t\t" + usrArray[2][j] + "\t\t\t" + usrArray[3][j] + "\t\t\t" + usrArray[4][j]);
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
        
        //TRANSFORMACIÓ DE INT EN STRING.
        for (int i = 0; i < index; i++) {
            switch (usrArray[1][i]) {
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
            switch (usrArray[2][i]) {
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
            switch (usrArray[3][i]) {
                case MAT:
                    area = MATES;
                    break;
                case 2:
                    if (usrArray[2][i] == PRIMARIA) {
                        area = DOS_PUNTO_CERO;
                    }
                    if (usrArray[2][i] == SECUNDARIA) {
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

            System.out.println(usrArray[0][i] + "\t\t" + sexe + "\t\t" + nivell + "\t\t" + area + "\t\t\t" + usrArray[4][i]);
            

        }
        //INICI ORDENACIÓ
        System.out.println("Vols que es mostri ordenat per NIVELL i, per cada NIVELL que es mostri ordenat per EXPERIÃˆNCIA?\n\t(0).NO\n\t(1).SI");
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
                    if (usrArray[2][i] < usrArray[2][j]) {
                        //INTERCANVIEM DADES
                        aux = usrArray[0][i];
                        usrArray[0][i] = usrArray[0][j];
                        usrArray[0][j] = aux;

                        aux = usrArray[1][i];
                        usrArray[1][i] = usrArray[1][j];
                        usrArray[1][j] = aux;

                        aux = usrArray[2][i];
                        usrArray[2][i] = usrArray[2][j];
                        usrArray[2][j] = aux;

                        aux = usrArray[3][i];
                        usrArray[3][i] = usrArray[3][j];
                        usrArray[3][j] = aux;

                        aux = usrArray[4][i];
                        usrArray[4][i] = usrArray[4][j];
                        usrArray[4][j] = aux;

                    }
                }
            }

            for (int i = 0; i < index - 1; i++) {
                //BUCLE INTERN
                for (int j = i + 1; j < index; j++) {
                    //RECORREM I ORDENEM L'ARRAY 
                    if (usrArray[4][i] < usrArray[4][j] && usrArray[2][i] == usrArray[2][j]) {
                        //SI COMPLEIX LA CONDICIÃ“ DEL IF INTERCANVIA DADES.

                        aux = usrArray[0][i];
                        usrArray[0][i] = usrArray[0][j];
                        usrArray[0][j] = aux;

                        aux = usrArray[1][i];
                        usrArray[1][i] = usrArray[1][j];
                        usrArray[1][j] = aux;

                        aux = usrArray[2][i];
                        usrArray[2][i] = usrArray[2][j];
                        usrArray[2][j] = aux;

                        aux = usrArray[3][i];
                        usrArray[3][i] = usrArray[3][j];
                        usrArray[3][j] = aux;

                        aux = usrArray[4][i];
                        usrArray[4][i] = usrArray[4][j];
                        usrArray[4][j] = aux;

                    }
                }
            }
            //RENOMENEM VARIABLE INT A STRING
            for (int k = 0; k < index; k++) {
                switch (usrArray[1][k]) {
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
                switch (usrArray[2][k]) {
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
                switch (usrArray[3][k]) {
                    case 1:
                        area = MATES;
                        break;
                    case 2:
                        if (usrArray[2][k] == PRIMARIA) {
                            area = DOS_PUNTO_CERO;
                        }
                        if (usrArray[2][k] == SECUNDARIA) {
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

                System.out.println(usrArray[0][k] + "\t\t" + sexe + "\t\t" + nivell + "\t\t" + area + "\t\t\t" + usrArray[4][k]);

            }
        }
        //CÁLCUL MITJANA DE L'EXPERIENCIA
        System.out.println("Vols que es mostri la mitjana d'experiencia per a nivell?");
        dadaCorrecta = entrada.hasNextInt();

        if (dadaCorrecta) {
            Resposta_mitjana = entrada.nextInt();
            if (Resposta_mitjana == 1) {
                valorem_mitjana = true;
                for (int m = 0; m < index; m++) {
                    switch (usrArray[2][m]) {
                        case 0:
                            suma_primaria += usrArray[4][m];
                            primaria++;
                            break;
                        case 1:
                            suma_secundaria += usrArray[4][m];
                            secundaria++;
                            break;

                        case 2:
                            suma_superior += usrArray[4][m];
                            superior++;
                            break;

                    }
                }
            } else if (Resposta_mitjana == 0) {
                System.out.println("Gràcies per la teva col·laboració");
            } else {
                System.out.println("Dada errònia");
            }
            
            //IMPRESIÓ MITJANA PER NIVELL.
            if (valorem_mitjana) {

                if (suma_primaria > 0) {
                    // System.out.println("Primària\t-"); 
                    mitjana_primaria = suma_primaria / (primaria);
                    if (mitjana_primaria <= 1) {
                        System.out.println("Primària\t-" + mitjana_primaria + " any");
                    } else if (mitjana_primaria > 1) {
                        System.out.println("Primària\t-" + mitjana_primaria + " anys");
                    }
                } else {
                    //  System.out.println("Primària\t-"); 
                    System.out.println("Primària\t-Sense voluntaris");
                }
                if (suma_secundaria > 0) {
                    //   System.out.println("Secundaria\t-"); 
                    mitjana_secundaria = suma_secundaria / (secundaria);
                    if (mitjana_secundaria == 1) {
                        System.out.println("Secundaria\t-" + mitjana_secundaria + " any");
                    } else if (mitjana_secundaria > 1) {
                        System.out.println("Secundaria\t-" + mitjana_secundaria + " anys");
                    }
                } else {

                    System.out.println("Secundaria\t-Sense voluntaris");
                }
                if (suma_superior > 0) {
                    //   System.out.println("Superior\t-");
                    mitjana_superior = suma_superior / (superior);
                    if (mitjana_superior <= 1) {
                        System.out.println("Superior\t-" + mitjana_superior + " any");
                    } else if (mitjana_superior > 1) {
                        System.out.println("Superior\t-" + mitjana_superior + " anys");
                    }
                } else {

                    System.out.println("Superior\t-Sense voluntaris");
                }
            }
        }

    }
}
