package p2_mgonzalez;

import java.util.Scanner;

public class P2_MGonzalez {

    public static final int GENERE_DONA = 1;
    public static final int GENERE_HOME = 2;
    public static final int GENERE_NORESPON = 3;
    public static final int PRIMARIA = 0;
    public static final int SECUNDARIA = 1;
    public static final int SUPERIOR = 2;
    public static final int TOTES = 0;
    public static final int LIMIT_MIN = 21;
    public static final int LIMIT_MAX = 499;
    public static final int EXP_MIN = 0;
    public static final int EXP_MAX = 90;
    public static final int INTENTS_MAX = 3;
    public static final int RESPOSTA_NO = 0;
    public static final int RESPOSTA_SI = 1;

    public static void main(String[] args) {

        //Declarem variables.
        Scanner entrada = new Scanner(System.in);
        int id = 0;
        int genere = 0;
        int nivell = 0;
        int anysExperiencia = 0;
        int assignatura = 0;
        int comptador = 0;
        int comptadorVoluntarisRegistrats = 0;
        int resposta;
        boolean dadaCorrecta = false;
        boolean introduirMes = true;
        boolean error = false;

        do {
            
            do {
                System.out.println("Benvingut/da! Al programa de Voluntaris per l'educació.\nQuin és el teu número de voluntari?");
                dadaCorrecta = entrada.hasNextInt();
                if (dadaCorrecta) {
                    id = entrada.nextInt();
                    if ((id >= LIMIT_MIN) && (id <= LIMIT_MAX)) {
                        dadaCorrecta = true;
                        System.out.println(" ");
                    } else {
                        System.out.println("");
                        dadaCorrecta = false;
                        
                    }
                }else{
                    dadaCorrecta = false;
                    entrada.next();
                }
                comptador += 1;
            } while (!dadaCorrecta && comptador < INTENTS_MAX);
            comptador = 0;

            //FUNCIONAAAAA
            if (dadaCorrecta == true) {
                do {
                    System.out.println("Ets dona " + "(" + GENERE_DONA + ")" + ", home " + "(" + GENERE_HOME + ")" + " o, prefereixes no respondre " + "(" + GENERE_NORESPON + ")?");
                    dadaCorrecta = entrada.hasNextInt();

                    if (dadaCorrecta) {
                        genere = entrada.nextInt();
                        if (genere > 1 || genere < 3) {
                            dadaCorrecta = true;
                            switch (genere) {
                                case 1:

                                    System.out.println("Has seleccionat: DONA ");

                                    break;
                                case 2:

                                    System.out.println("Has seleccionat: HOME");

                                    break;
                                case 3:

                                    System.out.println("Has selecionat: NO RESPON ");

                                    break;
                                default:

                                    dadaCorrecta = false;
                                    System.out.println("El valor introduït no correspon amb cap dada demanada");

                            }
                        }
                    }else{
                        dadaCorrecta = false;
                        entrada.next();
                    }
                    comptador += 1;
                } while (!dadaCorrecta && comptador < INTENTS_MAX);
                comptador = 0;
            }

            //entrada.nextLine();
            if (dadaCorrecta == true) {
                do {
                    System.out.println("Nivell d'educació?\n\t0.Primaria\n\t1.Secundària\n\t2.Superior");
                    dadaCorrecta = entrada.hasNextInt();
                    if (dadaCorrecta) {
                        nivell = entrada.nextInt();
                        if ((nivell >= PRIMARIA) && (nivell <= SUPERIOR)) {
                            dadaCorrecta = true;
                            switch (nivell) {
                                case 0:
                                    comptador = 0;
                                    /*
                        DO-WHILE PRIMARIA
                                     */
                                    if (dadaCorrecta == true) {

                                        do {
                                            System.out.println("Primària.Per educació primaria:\n\t0:Totes\n\t1:Mates\n\t2:Lectura\n\t3:Castellà\n\t4:Català\nEn quina àrea podries aportar?");
                                            dadaCorrecta = entrada.hasNextInt();
                                            assignatura = entrada.nextInt();
                                            System.out.println(assignatura);
                                            if (dadaCorrecta) {
                                                dadaCorrecta = true;
                                                if (assignatura <= 1 || assignatura >= 4) {

                                                    switch (assignatura) {
                                                        case 0:
                                                            System.out.println("Has seleccionat TOTES les matèries");

                                                            break;
                                                        case 1:

                                                            System.out.println("Has seleccionat MATES");

                                                            break;
                                                        case 2:

                                                            System.out.println("Has seleccionat LECTURA");

                                                            break;
                                                        case 3:

                                                            System.out.println("Has seleccionat CASTELLÀ");

                                                            break;
                                                        case 4:

                                                            System.out.println("Has seleccionat CATALÀ");

                                                            break;
                                                        default:
                                                            System.out.println("No existeix aquesta materia.");
                                                            dadaCorrecta = false;

                                                    }
                                                }

                                            }else{
                                                entrada.next();
                                            }
                                            comptador += 1;
                                        } while (!dadaCorrecta && comptador < INTENTS_MAX);
                                    }

                                case 1:
                                    comptador = 0;
                                    /*
                                DO-WHILE SECUNDARIA
                                     */
                                    if (nivell == SECUNDARIA && dadaCorrecta == true) {
                                        do {
                                            System.out.println("Secundària.Per educació secundària:\n\t0:Totes\n\t1:Mates\n\t2:Anglés\n\t3:Castellà\n\t4:Català\n\t5:Ciència\n\t6.Informàtica.\nEn quina àrea podries aportar?");
                                            dadaCorrecta = entrada.hasNextInt();
                                            assignatura = entrada.nextInt();
                                            System.out.println(assignatura);

                                            if (dadaCorrecta) {

                                                if (assignatura >= TOTES && assignatura <= 6) {
                                                    dadaCorrecta = true;
                                                    switch (assignatura) {
                                                        case 0:

                                                            System.out.println("Has seleccionat TOTES les matèries");

                                                            break;
                                                        case 1:

                                                            System.out.println("Has seleccionat MATES");

                                                            break;
                                                        case 2:

                                                            System.out.println("Has seleccionat ANGLÉS");

                                                            break;
                                                        case 3:

                                                            System.out.println("Has seleccionat CASTELLÀ");

                                                            break;
                                                        case 4:

                                                            System.out.println("Has seleccionat CATALÀ");

                                                            break;
                                                        case 5:

                                                            System.out.println("Has seleccionat CIÈNCIA");

                                                            break;
                                                        case 6:

                                                            System.out.println("Has seleccionat INFORMÀTICA");

                                                            break;
                                                        default:

                                                            System.out.println("No existeix aquesta materia.");
                                                            dadaCorrecta = false;
                                                    }

                                                }

                                            }else{
                                               entrada.next();
                                            }
                                            comptador += 1;
                                        } while (!dadaCorrecta && comptador < INTENTS_MAX);
                                    }
                                /*
                                DO-WHILE SUPERIOR
                                 */

                                case 2:
                                    comptador = 0;
                                    if (nivell == SUPERIOR && dadaCorrecta == true) {
                                        do {
                                            System.out.println("Superior. S'impartiràn: totes, premi el 0");
                                            dadaCorrecta = entrada.hasNextInt();
                                            assignatura = entrada.nextInt();
                                            if (assignatura == TOTES) {
                                                dadaCorrecta = true;

                                                if (assignatura != TOTES) {
                                                    dadaCorrecta = false;
                                                } else {
                                                    System.out.println(" ");

                                                }
                                            }else{
                                                System.out.println("No has pres el 0.");
                                                entrada.next();
                                                dadaCorrecta = false;
                                            }
                                            comptador += 1;
                                        } while (!dadaCorrecta && comptador < INTENTS_MAX);
                                    }
                                    break;
                                default:
                                    System.out.println("Error!Aquest nivell no existeix.");

                            }
                            comptador = 0;
                            if (dadaCorrecta == true) {
                                do {
                                    System.out.println("Quants anys d'experiència pots aportar?");
                                    dadaCorrecta = entrada.hasNextInt();
                                    anysExperiencia = entrada.nextInt();

                                    if (anysExperiencia >= EXP_MIN || anysExperiencia <= EXP_MAX) {
                                        dadaCorrecta = true;
                                        System.out.println("Experiència: " + anysExperiencia);
                                    } else {
                                        System.out.println(" ");
                                        dadaCorrecta = false;

                                    }
                                    comptador += 1;
                                } while (!dadaCorrecta && comptador < INTENTS_MAX);
                            }

                        }else{
                            System.out.println("Error!");
                            dadaCorrecta = false;
                        }

                    }else{
                        dadaCorrecta = false;
                        entrada.next();
                    }
                    comptador += 1;
                } while (!dadaCorrecta && comptador < INTENTS_MAX);
            }
            if (dadaCorrecta == true) {
                if (comptador < 3) {
                    if (((id >= LIMIT_MIN || id <= LIMIT_MAX)) && ((genere > GENERE_DONA || genere < GENERE_NORESPON)) && ((nivell >= PRIMARIA && nivell <= SUPERIOR)) && ((assignatura >= TOTES && assignatura <= 6)) && (anysExperiencia >= EXP_MIN || anysExperiencia <= EXP_MAX)) {

                        System.out.println("Id: " + id + " Genere: " + genere + " Nivell: " + nivell + " Àrea: " + assignatura + " Experiència: " + anysExperiencia + ".");

                    } else {
                        System.out.println(" ");
                    }
                }
            }
            
            System.out.println("Vols introduir les dades d'un altre voluntari?");
            dadaCorrecta = entrada.hasNextInt();
            if (dadaCorrecta) {
                resposta = entrada.nextInt();
                
                    switch (resposta) {
                        case 0:
                            introduirMes = false;
                            break;
                        case 1:
                            if(comptador < 3 && resposta == RESPOSTA_SI){
                            comptadorVoluntarisRegistrats++;
                            introduirMes = true;
                            }
                            break;
                        default:
                            System.out.println("Error de resposta");
                            dadaCorrecta = false;
                    }
            }
        } while (introduirMes);
        System.out.println("S'han registrat " + comptadorVoluntarisRegistrats + " voluntaris");
        
            
        
    }
}
