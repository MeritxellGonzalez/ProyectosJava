/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app6hospital;

import java.util.Calendar;

public class COVIDUtils {

    static final short ID_PACIENT = 0;
    static final short ID_DATAINGRES = 1;
    static final short ID_GRAVETAT = 2;

    /*Mètode per calcula les hores entre dues dates donades*/
    public static long calculaDuradaIngres(String dataIngres, String dataAlta) {
        long ingresMilis = milisegonsData(dataIngres);
        long altaMilis = milisegonsData(dataAlta);
        return (altaMilis - ingresMilis) / (1000 * 60 * 60);
    }

    public static long milisegonsData(String dataIngres) {
        Calendar cal = Calendar.getInstance();
        int diaIngres = Integer.parseInt(dataIngres.substring(0, 2));
        int mesIngres = Integer.parseInt(dataIngres.substring(3, 5));
        int anyIngres = Integer.parseInt(dataIngres.substring(6, 10));
        int horaIngres = Integer.parseInt(dataIngres.substring(11, 13));
        int minIngres = Integer.parseInt(dataIngres.substring(14, 16));

        cal.set(anyIngres, mesIngres, diaIngres, horaIngres, minIngres);
        return cal.getTimeInMillis();

    }

    /*Mètode que compta els pacients d'una determinada gravetat dins l'array de pacients Ingressats*/
    public static int contarPacientsGravetat(String[][] pacientCOVID, String gravetat) {
        int numPacients = 0;
        for (int i = 0; i < pacientCOVID.length; i++) {
            if (pacientCOVID[i][ID_GRAVETAT].equals(gravetat)) {
                numPacients++;
            }
        }
        return numPacients;
    }

    public static boolean comprovaCodiPacient(String[][] pacientCOVID, String codiPacient) {
        codiPacient = codiPacient.toUpperCase();
        boolean trobat = false;
        for (int i = 0; i < pacientCOVID.length; i++) {
            if (codiPacient.equals(pacientCOVID[i][ID_PACIENT])) {
                trobat = true;
            }
        }

        return trobat;

    }

    /**
     * Cerca el primer espai buit disponible dins l'array d'urgències
     *
     * @param Array pacients urgències
     * @return int
     */
    public static int cercaEspaiBuit(String[][] paciUrgCOVID) {
        int i = 0;
        boolean espaiTrobat = false;
        while (i < paciUrgCOVID.length && !espaiTrobat) {
            if (paciUrgCOVID[i][ID_PACIENT].equals("")) {
                espaiTrobat = true;
            } else {
                i++;
            }

        }
        return i;

    }

    /**
     * Cerca un codi de pacient a l'array
     *
     * @param Array pacients urgències
     * @param codi pacient que es vol cercar
     * @return int
     */
    public static int cercaPacient(String[][] pacientsUrgencies, String codiPacientCerca) {
        int posIndex = 0;
        boolean trobat = false;

        while (!trobat && posIndex < pacientsUrgencies.length) {
            trobat = pacientsUrgencies[posIndex][ID_PACIENT].equalsIgnoreCase(codiPacientCerca);
            posIndex++;
        }

        if (!trobat) {
            return -1;
        } else {
            return (posIndex - 1);
        }
    }

    /**
     * Generaci� del proper codi de pacient a assignar
     *
     * @param codi pacient del darrer pacient assignat
     * @return
     */
    public static String generarCodiPacient(DadesCOVID dCov) {
        return "PA" + (String.format("%03d", dCov.codiUltimPacient + 1));
    }

    /**
     * Formata un integer com a string amb 3 d�gits
     *
     * @param codi pacient
     * @return
     */
    public static String formataCodi(int codi) {
        return String.format("%03d", codi);
    }
}