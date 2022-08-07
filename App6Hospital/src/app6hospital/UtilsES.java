/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app6hospital;

import java.util.Scanner;

public class UtilsES {

    static final String MISSATGE_LINIA_SEPARACIO = "------------------------------------------------------------------";
    static final String MISSATGE_LINIA_SEPARACIO_FINAL = "===================================================================";
    static final String MISSATGE_LLISTAT_PACIENTS = "-----------------------LLISTAT DE PACIENTS-----------------------";

    static String[] valorsGravetat = {
        "BAIXA",
        "MITJANA",
        "ALTA"
    };

    /**
     *
     * @param missatge
     */
    public static void demanaEnter(String missatge) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(missatge);
        scanner.nextLine();
    }

    public static String demanaString(String missatge, String mError) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(missatge);
        String textIntroduit = scanner.nextLine();
        while (textIntroduit.isEmpty()) {
            System.out.println(mError);
            System.out.println(missatge);
            textIntroduit = scanner.nextLine();
        }
        return textIntroduit;
    }

    public static int demanarEnter(String missatge, String mError) {
        Scanner scanner = new Scanner(System.in);
        int ret;
        boolean correcte = false;
        do {
            System.out.print(missatge + "\n");
            correcte = scanner.hasNextInt();
            if (!correcte) {
                scanner.next();
                System.out.println("\nCal que entris un enter si us plau.");
            }
        } while (!correcte);
        ret = scanner.nextInt();
        scanner.nextLine();
        return ret;
    }

    public static void mostrarMissatge(String titol, String missatge) {
        System.out.println();
        System.out.println();
        System.out.println(MISSATGE_LINIA_SEPARACIO);
        System.out.println(titol);
        System.out.println(MISSATGE_LINIA_SEPARACIO);
        System.out.println(missatge);
        System.out.println(MISSATGE_LINIA_SEPARACIO_FINAL);
    }

    public static void mostrarMenu(String[] menu) {
        System.out.println();
        System.out.println(MISSATGE_LINIA_SEPARACIO);
        System.out.println(menu[0]);
        System.out.println(MISSATGE_LINIA_SEPARACIO);
        for (int pos = 1; pos < menu.length; pos++) {
            System.out.println(menu[pos]);
        }
    }

    public static String demanarGravetat(String missatge, String missatgeError) {
        int ret;
        boolean correcte;
        do {
            ret = demanarEnter(missatge, "Cal que entris un enter si us plau.");
            if (ret > 0 && ret < 4) {
                correcte = true;
            } else {
                System.out.println(missatgeError);
                correcte = false;
            }
        } while (!correcte);
        return valorsGravetat[ret - 1];
    }

    /**
     * Espera a que el programa pitgi la tecla enter per tal de continuar. No
     * retorna el contingut pitjat prèviament a l'enter.
     */
    public static void validarAltaPacient(String missatge) {
        System.out.println(missatge);
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

}
