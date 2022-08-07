package p2_mgonzalez;

import java.util.Scanner;

public class provapr4 {

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
    public static final int COLUMNES = 5;
    public static final int USUARIS_MAX = 10;

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int unicArray[][] = new int[10][5];
        int id = 0;
        int genere = 0;
        int nivell = 0;
        int area = 0;
        int exp = 0;
        int comptador = 0;
        int comptadorVoluntarisRegistrats = 0;
        int resposta = 0;
        int index = 0;
        int ordena;
        int filas = 0;
        int columnes = 0;
        int conta_primaria = 0;
        int mitjana_prim = 0;
        int mitjana_sec = 0;
        int mitjana_sup = 0;
        int mitj_pr = 0;
        int mitj_sc = 0;
        int mitj_sp = 0;
        int conta_secundaria = 0;
        int conta_superior = 0;
        int mitjanaSi = 0;
        boolean dadaCorrecta = false;
        boolean introduirMes = true;
        boolean mitjana;
        String sexe = "";
        String nivell_nom = "";
        String area_nom = "";

        do {
            introduirMes = false;
            do {

                System.out.println("Diguem el número de voluntari?");
                dadaCorrecta = entrada.hasNextInt();

                if (dadaCorrecta) {
                    id = entrada.nextInt();

                    if (id >= LIMIT_MIN && id <= LIMIT_MAX) {
                        dadaCorrecta = true;
                        unicArray[filas][columnes] = id;
                        columnes++;
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
                        genere = entrada.nextInt();

                        if (genere >= GENERE_DONA || genere <= GENERE_NORESPON) {
                            dadaCorrecta = true;

                            if (genere == GENERE_DONA) {
                                System.out.println("Ha escollit: " + GENERE_DONA + ". És a dir: DONA");
                                dadaCorrecta = true;
                                unicArray[filas][columnes] = genere;
                            } else if (genere == GENERE_HOME) {
                                System.out.println("Ha escollit: " + GENERE_HOME + ". És a dir: HOME");
                                dadaCorrecta = true;
                                unicArray[filas][columnes] = genere;
                            } else if (genere == GENERE_NORESPON) {
                                System.out.println("Ha escollit: " + GENERE_NORESPON + ". És a dir: NO RESPON");
                                dadaCorrecta = true;
                                unicArray[filas][columnes] = genere;
                            } else {
                                dadaCorrecta = false;
                                System.out.println(" Dada no valida.");
                            }
                            columnes++;
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
                            nivell = entrada.nextInt();

                            if ((nivell == PRIMARIA) || (nivell == SECUNDARIA) || (nivell == SUPERIOR)) {
                                dadaCorrecta = true;

                                unicArray[filas][columnes] = nivell;
                                columnes++;

                                switch (nivell) {
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
                                            area = entrada.nextInt();
                                            unicArray[filas][columnes] = area;
                                            columnes++;
                                            switch (nivell) {
                                                case PRIMARIA:

                                                    switch (area) {
                                                        case TOTES:
                                                        case MAT:
                                                        case LEC_PRIMARIA:
                                                        case CASTELLA:
                                                        case CATALA:
                                                            // area = unicArray[area][index];
                                                            break;
                                                        default:
                                                            System.out.println("No es contempla aquesta materia");
                                                            dadaCorrecta = false;
                                                    }
                                                    break;

                                                case SECUNDARIA:

                                                    switch (area) {
                                                        case TOTES:
                                                        case MAT:
                                                        case ANG:
                                                        case CASTELLA:
                                                        case CATALA:
                                                        case CIEN:
                                                        case PREFERIDA:
                                                            //area = unicArray[area][index];
                                                            break;
                                                        default:
                                                            System.out.println("No es contempla aquesta materia");
                                                            dadaCorrecta = false;
                                                    }
                                                    break;
                                                case SUPERIOR:

                                                    switch (area) {
                                                        case TOTES:
                                                            dadaCorrecta = true;
                                                            //area = unicArray[area][index];
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
                        exp = entrada.nextInt();
                        if (exp >= EXP_MIN && exp <= EXP_MAX) {
                            dadaCorrecta = true;
                            unicArray[filas][columnes] = exp;
                            columnes++;
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
                filas++;
            } else {
                System.out.println("Dades erronies.");

            }

            if (filas < USUARIS_MAX) {
                System.out.println("Vols introduïr les dades d'un altre voluntari?\n\t(1).SI\n\t(0).NO");
                dadaCorrecta = entrada.hasNextInt();
                if (dadaCorrecta) {
                    resposta = entrada.nextInt();
                    if (resposta == RESPOSTA_SI) {
                        introduirMes = true;
                        System.out.println("D'acord.");

                        columnes = 0;

                    } else if (resposta == RESPOSTA_NO) {
                        introduirMes = false;
                        System.out.println("Moltes gràcies");
                        System.out.println("Els usuaris/es registrats són:\n");
                        System.out.println("Els ID registrats:      Els GENERES registrats:       Els NIVELLS registrats:         L'AREA resgistrada:         L'EXPERIENCIA registrada:");
                        for (int i = 0; i < filas; i++) {
                            System.out.println(" ");
                            for (int j = 0; j < columnes; j++) {
                                //System.out.print("["+ i +"]"+"["+ j+"]\t\t");
                                System.out.print("\t" + unicArray[i][j] + "\t\t            ");

                            }
                        }

                    } else {
                        dadaCorrecta = false;
                        entrada.next();

                    }

                }
            }

        } while ((introduirMes) && (filas < USUARIS_MAX) && (resposta == RESPOSTA_SI));

        System.out.println(
                "\nS'han registrat: " + comptadorVoluntarisRegistrats + " voluntaris.");

//NO FUNCIONA A PARTIR D'AQUI
        System.out.println(
                "Vols que es mostri ordenat per NIVELL i, per cada NIVELL que es mostri ordenat per EXPERIÈNCIA?\n\t(0).NO\n\t(1).SI");
        dadaCorrecta = entrada.hasNextInt();
        if (dadaCorrecta) {
            ordena = entrada.nextInt();
            if (ordena == 1) {
            }
        }
        for (int j = 0; j < 3; j++) {
            if (nivell == 0) {
                System.out.println("PRIMARIA");
                System.out.println("ID \t GENERE \t NIVELL \t AREA \t EXPERIENCIA");
                for (int i = 0; i < filas; i++) {
                    for (int x = 0; x < columnes; x++) {
                        if (unicArray[i][2] == 0) {
                            //System.out.print(unicArray[i][x] + "\t");
                            mitjana_prim += unicArray[i][4];
                            conta_primaria++;
                            switch (unicArray[i][1]) {
                                case 1:
                                    sexe = GEN_DONA;
                                    break;
                                case 2:
                                    sexe = GEN_HOME;
                                    break;
                                case 3:
                                    sexe = GEN_NRESP;
                            }
                            switch (unicArray[i][2]) {
                                case 0:
                                    nivell_nom = EDU_PRIMARIA;
                                    break;
                            }
                            switch (unicArray[i][3]) {
                                case 0:
                                    area_nom = TOT;
                                    break;
                                case 1:
                                    area_nom = MATES;
                                    break;
                                case 2:
                                    area_nom = DOS_PUNTO_CERO;
                                    break;
                                case 3:
                                    area_nom = CASTE;
                                    break;
                                case 4:
                                    area_nom = CAT;
                                    break;
                            }
                        }
                        System.out.println(unicArray[i][0] + "\t" + sexe + "\t" + nivell_nom + "\t" + area_nom + "\t" + unicArray[i][4]);
                    }
                    mitj_pr = mitjana_prim / conta_primaria;
                }
                
            }
            if (nivell == 1) {
                System.out.println("SECUNDARIA");
                System.out.println("ID \t GENERE \t NIVELL \tAREA \tEXPERIENCIA");
                for (int i = 0; i < filas; i++) {
                    for (int x = 0; x < filas; x++) {
                        if (unicArray[i][2] == 1) {
                            //System.out.println(unicArray[i][x] + "\t");
                            mitjana_sec += unicArray[i][4];
                            conta_secundaria++;

                            switch (unicArray[i][1]) {
                                case 1:
                                    sexe = GEN_DONA;
                                    break;
                                case 2:
                                    sexe = GEN_HOME;
                                    break;
                                case 3:
                                    sexe = GEN_NRESP;
                            }
                            switch (unicArray[i][2]) {
                                case 0:
                                    nivell_nom = EDU_SECUNDARIA;
                                    break;
                            }
                            switch (unicArray[i][3]) {
                                case 0:
                                    area_nom = TOT;
                                    break;
                                case 1:
                                    area_nom = MATES;
                                    break;
                                case 2:
                                    area_nom = DOS_PUNTO_UNO;
                                    break;
                                case 3:
                                    area_nom = CASTE;
                                    break;
                                case 4:
                                    area_nom = CAT;
                                    break;
                                case 5:
                                    area_nom = CIENCIA;
                                    break;
                                case 6:
                                    area_nom = PREFE;
                                    break;
                            }
                        }
                        System.out.println(unicArray[i][0] + "\t" + sexe + "\t" + nivell_nom + "\t" + area_nom + "\t" + unicArray[i][4]);
                    }
                    mitj_sc = mitjana_sec / conta_secundaria;

                }

            }
            

            if (nivell == 2) {
                System.out.println("SUPERIOR");
                System.out.println("ID \t GENERE \t NIVELL \t AREA \t EXPERIENCIA");
                for (int i = 0; i < filas; i++) {
                    for (int x = 0; x < filas; x++) {
                        if (unicArray[i][2] == 2) {
                            // System.out.println(unicArray[i][x] + "\t");
                            mitjana_sup += unicArray[i][4];
                            conta_secundaria++;
                            switch (unicArray[i][1]) {
                                case 1:
                                    sexe = GEN_DONA;
                                    break;
                                case 2:
                                    sexe = GEN_HOME;
                                    break;
                                case 3:
                                    sexe = GEN_NRESP;
                            }
                            switch (unicArray[i][2]) {
                                case 0:
                                    nivell_nom = EDU_SUPERIOR;
                                    break;
                            }
                            switch (unicArray[i][3]) {
                                case 0:
                                    area_nom = TOT;
                                    break;

                            }
                        }
                        System.out.println(unicArray[i][0] + "\t" + sexe + "\t" + nivell_nom + "\t" + area_nom + "\t" + unicArray[i][4]);
                    }
                    mitj_sp = mitjana_sup / conta_secundaria;
                }

            }

        }

        System.out.println("\n\n");
        System.out.println("Mostrar la mitjana de l'esperièriencia per nivell");
        dadaCorrecta = entrada.hasNextInt();
        if (dadaCorrecta) {
            mitjanaSi = entrada.nextInt();
            if (mitjanaSi == 1) {
                System.out.println("MITJANA PRIMARIA");
                System.out.println(mitj_pr + " anys.");
                System.out.println("");
                System.out.println("MITJANA SECUNDARIA");
                System.out.println(mitj_sc + " anys.");
                System.out.println("");
                System.out.println("MITJANA SUPERIOR");
                System.out.println(mitj_sp + " anys.");
            } else {
                dadaCorrecta = false;
                entrada.nextLine();
            }
        }
    }

}
//for (int m = 0; m < index; m++) {
//System.out.println(
//"Els ID registrats:      Els GENERES registrats:       Els NIVELLS registrats:       L'AREA resgistrada:       L'EXPERIENCIA registrada:");
// System.out.println(id
//+ "                             " + genere + "                            " + nivell + "                            " + area + "                              " + exp);
//}
//}
/*} else {
            System.out.println("Error dada introduïda");
            entrada.next();*/
