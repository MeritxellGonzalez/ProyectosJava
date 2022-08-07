package p1_gonzalezm;

import java.util.Scanner;

public class P1_MGonzalez {

    //Declarem les constants.
    public static final int PRIMARIA = 0;
    public static final int SECUNDARIA = 1;
    public static final int SUPERIOR = 2;

    public static void main(String[] args) {

        //Declarem variables.
        Scanner entrada = new Scanner(System.in);
        int id = 0, genere, nivell, nivellEmmagatzem, area, anysExperiencia = 0, comptador = 0, numIntents = 3;
        boolean dadaCorrecta;
        do {
            //Preguntem ID.
            System.out.println("Quin és el teu codi identificatiu com a voluntari?");
            //Correcció Errors ID.
            dadaCorrecta = entrada.hasNextInt();
            if (dadaCorrecta) {
                id = entrada.nextInt();
                if ((id < 21) || (id > 499)) {
                    System.out.println("Error1");
                    dadaCorrecta = false;
                }if(numIntents < comptador){
                        System.out.println("error dades");
                    
                    //Si el número es superior a 21 o menor a 499, el programa s'executa
                }else {
                    dadaCorrecta = true;
                  

                    //Correcció error Genere.
                }
            }
            //entrada.nextLine();
            comptador += 1;
        } while (!dadaCorrecta && comptador < 3);
        
        System.out.println("És dona (1), home (2), o prefereix no respondre (3)?");
        dadaCorrecta = entrada.hasNextInt();
        if (dadaCorrecta) {
            genere = entrada.nextInt();
            //Si genere està entre 0 i 2, continua.
            if ((genere >= 1) && (genere <= 3)) {
                System.out.println("Nivell d'educació?\n\t0.Primaria\n\t1.Secundària\n\t2.Superior");
                dadaCorrecta = entrada.hasNextInt();
                //Correcció errors Nivell.
                if (dadaCorrecta) {
                    nivell = entrada.nextInt();
                    if ((nivell >= 0) && (nivell <= 2)) {
                        //Estructura switch pel nivell
                        switch (nivell) {
                            case 0:
                                System.out.println("Primària.Per educació primaria:\n\t0:Totes\n\t1:Mates\n\t2:Lectura\n\t3:Castellà\n\t4:Català\nEn quina àrea podries aportar?");
                                break;
                            case 1:
                                System.out.println("Secundària.Per educació secundària:\n\t0:Totes\n\t1:Mates\n\t2:Anglés\n\t3:Castellà\n\t4:Català\n\t5:Ciència\n\t6.Informàtica.\nEn quina àrea podries aportar?");
                                break;
                            case 2:
                                System.out.println("Superior. S'impartiràn: totes, premi el 0");
                                break;
                            default:
                                System.out.println("Error!Aquest nivell no existeix.");
                        }
                        //variable que emmagatzema la selecció del nivell + correcció d'errors d'àrea.
                        nivellEmmagatzem = nivell;
                        dadaCorrecta = entrada.hasNextInt();
                        if (dadaCorrecta) {
                            area = entrada.nextInt();
                            //Primària
                            if ((area >= 0 || area <= 6) && (nivellEmmagatzem == PRIMARIA)) {

                                switch (area) {
                                    case 0:
                                        System.out.println("Totes");
                                        break;
                                    case 1:
                                        System.out.println("Mates");
                                        break;
                                    case 2:
                                        System.out.println("Lectura");
                                        break;
                                    case 3:
                                        System.out.println("Castellà");
                                        break;
                                    case 4:
                                        System.out.println("Català");
                                        break;
                                    default:
                                        System.out.println("No hi ha cap assignatura amb aquesta ID");

                                }
                                if (area < 0 || area > 6) {
                                    System.out.println("Error");
                                } else {
                                    //Experiéncia
                                    System.out.println("Quants anys d'experiència aportes?");
                                    dadaCorrecta = entrada.hasNextInt();
                                    if (dadaCorrecta) {
                                        anysExperiencia = entrada.nextInt();
                                        if (anysExperiencia >= 0 && anysExperiencia <= 90) {
                                            System.out.println("Experiència: " + anysExperiencia);
                                        } else {
                                            System.out.println("Error5");
                                        }
                                    }
                                }

                                //Secundària
                            } else if ((area > 0) && (nivellEmmagatzem == SECUNDARIA)) {
                                switch (area) {
                                    case 0:
                                        System.out.println("Totes");
                                        break;
                                    case 1:
                                        System.out.println("Mates");
                                        break;
                                    case 2:
                                        System.out.println("Anglés");
                                        break;
                                    case 3:
                                        System.out.println("Castellà");
                                        break;
                                    case 4:
                                        System.out.println("Català");
                                        break;
                                    case 5:
                                        System.out.println("Ciéncia");
                                        break;
                                    case 6:
                                        System.out.println("Informàtica");
                                        break;
                                    default:
                                        System.out.println("No hi ha cap assignatura amb aquesta identificació");

                                }
                                if (area < 0 || area > 6) {
                                    System.out.println("Error");
                                } else {
                                    //Experiéncia
                                    System.out.println("Quants anys d'experiència aportes?");
                                    dadaCorrecta = entrada.hasNextInt();
                                    if (dadaCorrecta) {
                                        anysExperiencia = entrada.nextInt();
                                        if (anysExperiencia >= 0 && anysExperiencia <= 90) {
                                            System.out.println("Experiència: " + anysExperiencia);
                                        } else {
                                            System.out.println("Error5");
                                        }
                                    }
                                }
                                //Superior
                            } else if ((area == 0) && (nivellEmmagatzem == SUPERIOR)) {
                                switch (area) {
                                    case 0:
                                        System.out.println("Totes:");

                                    case 1:
                                        System.out.println("\tMates");

                                    case 2:
                                        System.out.println("\tAnglés");

                                    case 3:
                                        System.out.println("\tCastellà");

                                    case 4:
                                        System.out.println("\tCatalà");

                                    case 5:
                                        System.out.println("\tCiéncia");

                                    case 6:
                                        System.out.println("\tInformàtica");
                                        break;
                                    default:
                                        System.out.println("No hi ha cap assignatura amb aquesta identificació");

                                }
                                if (area < 0 || area > 6) {
                                    System.out.println("Error");
                                } else {
                                    //Experiéncia
                                    System.out.println("Quants anys d'experiència aportes?");
                                    dadaCorrecta = entrada.hasNextInt();
                                    if (dadaCorrecta) {
                                        anysExperiencia = entrada.nextInt();
                                        if (anysExperiencia >= 0 && anysExperiencia <= 90) {

                                            System.out.println("Experiència: " + anysExperiencia);
                                        } else {
                                            System.out.println("Error5");
                                        }
                                    }
                                }
                            } else {
                                System.out.println("Error area");

                            }

                            //Impresió en pantalla.
                            if (((id >= 21) || (id <= 499)) && ((genere >= 1) && (genere <= 3)) && ((nivell >= 0) && (nivell <= 2)) && ((area >= 0) && (area <= 6)) && (anysExperiencia >= 0 && anysExperiencia <= 90)) {

                                System.out.println("Id: " + id + " Genere: " + genere + " Nivell: " + nivell + " Àrea: " + area + " Experiència: " + anysExperiencia + ".");

                            } else {
                                System.out.println("error");
                            }
                        }

                    }
                }
            }
        }

    }
}
