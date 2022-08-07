package p2_mgonzalez;

import java.util.Scanner;

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
    

    public static final void main(String[] args) {
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
        int i = 0;
        int aux;
        int ordena;
        //variables per imprimir ordenat
        int ind;
        int conta_primaria = 0;
        int conta_secundaria = 0;
        int conta_superior = 0;
        //semàfors
        boolean dadaCorrecta = false;
        boolean introduirMes = true;
        //Strings
        String sexe;
        String nivell;
        String area;
        
        /*
        COMENCEM EL PROGRAMA.
         */
        
        do {
            introduirMes = false;
            do {

                System.out.println("Diguem el número de voluntari?");
                dadaCorrecta = entrada.hasNextInt();
                if (dadaCorrecta) {
                    idArray[i] = entrada.nextInt();
                    if (idArray[i] >= LIMIT_MIN && idArray[i] <= LIMIT_MAX) {
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
                        genereArray[i] = entrada.nextInt();
                        if (genereArray[i] >= GENERE_DONA || genereArray[i] <= GENERE_NORESPON) {
                            dadaCorrecta = true;
                            if (genereArray[i] == GENERE_DONA) {
                                System.out.println("Ha escollit: " + GENERE_DONA + ". És a dir: DONA");
                                dadaCorrecta = true;
                            } else if (genereArray[i] == GENERE_HOME) {
                                System.out.println("Ha escollit: " + GENERE_HOME + ". És a dir: HOME");
                                dadaCorrecta = true;
                            } else if (genereArray[i] == GENERE_NORESPON) {
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
                } while ((dadaCorrecta == false) && (comptador < INTENTS_MAX));
            }
            do {
                if (dadaCorrecta) {
                    comptador = 0;
                    do {
                        System.out.println("Quin és el Nivell en el que podries aportar: \n\t(0).PRIMARIA\n\t(1).SECUNDARIA\n\t(2).SUPERIOR");

                        dadaCorrecta = entrada.hasNextInt();
                        if (dadaCorrecta) {
                            nivellArray[i] = entrada.nextInt();
                            if ((nivellArray[i] == PRIMARIA) || (nivellArray[i] == SECUNDARIA) || (nivellArray[i] == SUPERIOR)) {
                                dadaCorrecta = true;
                                switch (nivellArray[i]) {
                                    case PRIMARIA:
                                        System.out.println("Per a PRIMÀRIA les matèries disponibles a escollir són:\n\t(0).TOTES\n\t(1).MATES\n\t(2).LECTURA\n\t(3).CASTELLÀ\n\t(4).CATALÀ");
                                        conta_primaria++;
                                        break;
                                    case SECUNDARIA:
                                        System.out.println("Per a SECUNDARIA les matèries disponibles a escollir són:\n\t(0).TOTES\n\t(1).MATES\n\t(2).ANGLÉS\n\t(3).CASTELLÀ\n\t(4).CATALÀ\n\t(5).CIÈNCIA\n\t(6).INFORMÀTICA");
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
                                            areaArray[i] = entrada.nextInt();
                                            switch (nivellArray[i]) {
                                                case PRIMARIA:

                                                    switch (areaArray[i]) {
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
                                                    
                                                    switch (areaArray[i]) {
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
                                                    
                                                    switch (areaArray[i]) {
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
                        anysExp[i] = entrada.nextInt();
                        if (anysExp[i] >= EXP_MIN && anysExp[i] <= EXP_MAX) {
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
                i++;
            } else {
                System.out.println("Dades erronies.");

            }

            if (i < USUARIS_MAX) {
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
                        for (int j = 0; j < i; j++) {
                            System.out.println("Els ID registrats:      Els GENERES registrats:       Els NIVELLS registrats:       L'AREA resgistrada:       L'EXPERIENCIA registrada:");
                            System.out.println(idArray[j] + "                             " + genereArray[j] + "                            " + nivellArray[j] + "                            " + areaArray[j] + "                              " + anysExp[j]);
                        }
                    }

                } else {
                    dadaCorrecta = false;
                    entrada.next();
                }

            }
        } while ((introduirMes) && (i < USUARIS_MAX) && (resposta == RESPOSTA_SI));

        System.out.println("\nS'han registrat: " + comptadorVoluntarisRegistrats + " voluntaris.");

        System.out.println("Vols que es mostri ordenat per NIVELL i, per cada NIVELL que es mostri ordenat per EXPERIÈNCIA?\n\t(0).NO\n\t(1).SI");
        dadaCorrecta = entrada.hasNextInt();
        if (dadaCorrecta) {
            ordena = entrada.nextInt();
            if (ordena == 1) {
                for (int k = 0; k < i - 1; k++) {
                    for (int j = k + 1; j < i; j++) {
                        if (nivellArray[k] < nivellArray[j]) {
                            aux = nivellArray[k];
                            nivellArray[k] = nivellArray[j];
                            nivellArray[j] = aux;
                            
                            aux = idArray[k];
                            idArray[k] = idArray[j];
                            idArray[j] = aux;

                            aux = genereArray[k];
                            genereArray[k] = genereArray[j];
                            genereArray[j] = aux;


                            aux = areaArray[k];
                            areaArray[k] = areaArray[j];
                            areaArray[j] = aux;

                            aux = anysExp[k];
                            anysExp[k] = anysExp[j];
                            anysExp[j] = aux;
                        }
                    }
                }
                for (int k = 0; k < i - 1; k++) {
                    for (int j = k + 1; j < i; j++) {
                        if (anysExp[k] < anysExp[j]) {
                            
                            aux = anysExp[k];
                            anysExp[k] = anysExp[j];
                            anysExp[j] = aux;
                            
                            aux = nivellArray[k];
                            nivellArray[k] = nivellArray[j];
                            nivellArray[j] = aux;
                            
                            aux = idArray[k];
                            idArray[k] = idArray[j];
                            idArray[j] = aux;

                            aux = genereArray[k];
                            genereArray[k] = genereArray[j];
                            genereArray[j] = aux;


                            aux = areaArray[k];
                            areaArray[k] = areaArray[j];
                            areaArray[j] = aux;

                            
                        }
                    }
                }
                for (int m = 0; m < i; m++) {

                    System.out.println("Els ID registrats:      Els GENERES registrats:       Els NIVELLS registrats:       L'AREA resgistrada:       L'EXPERIENCIA registrada:");
                    System.out.println(idArray[m] + "                             " + genereArray[m] + "                            " + nivellArray[m] + "                            " + areaArray[m] + "                              " + anysExp[m]);
                }
            }
        } else {
            System.out.println("Error dada introduïda");
            entrada.next();
        }

    }
}
