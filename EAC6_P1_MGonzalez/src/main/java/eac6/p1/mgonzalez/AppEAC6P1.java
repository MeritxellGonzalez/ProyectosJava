package eac6.p1.mgonzalez;

import java.text.ParseException;

/**
 *
 * @author David Amoros
 */
public class AppEAC6P1 {

    static final String MISSATGE_LINIA_SEPARACIO = "------------------------------------------";
    static final String MISSATGE_CONTINUAR = "\nPresiona [ENTRAR] per continuar";
    static final String MISSATGE_INTRODUIR_OPCIO = "\nEsculliu una opció i premeu [ENTRAR]";
    static final String MISSATGE_LLISTAT_FITXERS = "--------------LLISTAT DE FITXERS----------";
    static final String MISSATGE_LLISTAT_DIRECTORIS = "--------------LLISTAT DE DIRECTORIS-------";
    static final String MISSATGE_LLISTAT_FITXERS_CAPSALERA = "          NOM                 MIDA (bytes)";
    static final String MISSATGE_LLISTAT_DIRECTORIS_CAPSALERA = "   OPCIO          DIRECTORI";
    static final String MISSATGE_ERROR_LECTURA = "Error de lectura";

    private FileUtils fileUtils;

    /**
     * @param args the command line arguments
     * @throws ParseException
     */
    public static void main(String[] args) {
        AppEAC6P1 prg = new AppEAC6P1();
        prg.inici();
    }

    /**
     *
     */
    private void inici() {
        fileUtils = new FileUtils();
        fileUtils.inicialitza();

        int opcio;
        String[] menuPrincipal = {"GESTIO ATLETES VILA OLIMPICA",
            "\n9. Gestió de dades\n",
            "0. Sortir\n\n"
        };
        do {
            mostrarMenu(menuPrincipal);
            opcio = UtilsES.demanarEnter("Esculliu una opció i premeu [ENTRAR]: ", MISSATGE_ERROR_LECTURA);
            if (opcio == 9) {
                subMenuDades();
            }
        } while (opcio != 0);
    }

    /**
     *
     */
    private void subMenuDades() {
        int opcio;
        String[] subMenuDades = {"GESTIO ATLETES VILA OLIMPICA - DADES",
            "\n1. Mostrar la carpeta de dades",
            "2. Canviar la carpeta de dades",
            "3. Llistar fitxers",
            "4. Eliminar fitxer\n",
            "0. Enrere\n\n"
        };

        do {
            mostrarMenu(subMenuDades);
            opcio = UtilsES.demanarEnter(MISSATGE_INTRODUIR_OPCIO, MISSATGE_ERROR_LECTURA);
            switch (opcio) {
                case 1:
                    mostraDirectoriDades();
                    break;
                case 2:
                    canviaDirectori();
                    break;
                case 3:
                    llistarFitxers();
                    break;
                case 4:
                    eliminarFitxers();
                    break;
            }
        } while (opcio != 0);
    }

    /**
     *
     */
    private void canviaDirectori() {

        String[] subMenuDirectoris = {
            "GESTIO ATLETES VILA OLIMPICA - DADES - CANVI DIRECTORI",};
        String[] opcionsDefecte = {
            String.format("%1$" + 4 + "s", "1.") + String.format("%1$" + 25 + "s", ".."),
            String.format("%1$" + 4 + "s", "0.") + String.format("%1$" + 25 + "s", "Enrere"),};

        int opcio = 0;

        do {
            String[][] contingutDirectori = fileUtils.getLlistaContingut(fileUtils.getDirectoryDades());

            mostrarMenu(subMenuDirectoris);
            mostrarLlistatDirectoris(contingutDirectori, opcionsDefecte);

            opcio = UtilsES.demanarEnter(MISSATGE_INTRODUIR_OPCIO, MISSATGE_ERROR_LECTURA);

            if (opcio == 1) {
                fileUtils.canviarDirectori("..");
            } else if (opcio > 1 && (opcio - 2) < contingutDirectori.length) {
                fileUtils.canviarDirectori(contingutDirectori[opcio - 2][0]);
            }

        } while (opcio != 0);
    }

    /**
     *
     */
    private void mostraDirectoriDades() {

        String[] subMenuMostraDirectori = {
            "GESTIO ATLETES VILA OLIMPICA - DADES - MOSTRAR DIRECTORI DADES",};
        mostrarMenu(subMenuMostraDirectori);

        String dir = fileUtils.getDirectoryDades();
        System.out.println("\nEl directori de dades es: " + dir);
        UtilsES.demanaReturn(MISSATGE_CONTINUAR);
    }

    /**
     *
     */
    private void eliminarFitxers() {
        String[] subMenuEliminarFitxers = {
            "GESTIO ATLETES VILA OLIMPICA - DADES - ELIMINAR FITXER",};

        mostrarMenu(subMenuEliminarFitxers);

        String nomFitxer = UtilsES.demanarString("\n\nIntrodueix el nom del fitxer a esborrar (del directori de dades)", MISSATGE_ERROR_LECTURA);
        boolean result = fileUtils.esborraFitxer(nomFitxer);

        if (result) {
            System.out.println("\nCORRECTE! Fitxer esborrat correctament");
        } else {
            System.out.println("\nERROR! no s'ha pogut esborrar el fitxer");
        }

        UtilsES.demanaReturn(MISSATGE_CONTINUAR);
    }

    /**
     *
     */
    private void llistarFitxers() {
        String[] subMenuLlistarFitxers = {
            "GESTIO ATLETES VILA OLIMPICA - DADES - LLISTAR FITXERS",};
        mostrarMenu(subMenuLlistarFitxers);

        String[][] llistat = fileUtils.getLlistaContingut(fileUtils.getDirectoryDades());

        mostraLListatFitxers(llistat);
        UtilsES.demanaReturn(MISSATGE_CONTINUAR);
    }

    /**
     *
     * @param directoris
     * @param opcionsDefecte
     */
    public void mostrarLlistatDirectoris(String[][] contingutDirectori, String[] opcionsDefecte) {
        System.out.println("\n\n" + MISSATGE_LINIA_SEPARACIO);
        System.out.println(MISSATGE_LLISTAT_DIRECTORIS);
        System.out.println(MISSATGE_LINIA_SEPARACIO);
        System.out.println("\n\n" + MISSATGE_LLISTAT_DIRECTORIS_CAPSALERA + "\n");

        for (int i = 0; i < contingutDirectori.length; ++i) {
            if (contingutDirectori[i][FileUtils.FITXER_TIPUS_POS].equals("d")) {
                String opcio = Integer.toString(i + opcionsDefecte.length) + ".";
                String nomDirectori = contingutDirectori[i][FileUtils.FITXER_NOM_POS];

                opcio = String.format("%1$" + 4 + "s", opcio);
                nomDirectori = String.format("%1$" + 25 + "s", nomDirectori);

                System.out.print(opcio);
                System.out.println(nomDirectori);
            }
        }

        System.out.println("\n\n\n");
        for (String opcionStr : opcionsDefecte) {
            System.out.println(opcionStr);
        }
    }

    /**
     *
     * @param llistatFitxers
     */
    public void mostraLListatFitxers(String[][] llistatFitxers) {
        System.out.println("\n\n" + MISSATGE_LINIA_SEPARACIO);
        System.out.println(MISSATGE_LLISTAT_FITXERS);
        System.out.println(MISSATGE_LINIA_SEPARACIO);
        System.out.println("\n\n" + MISSATGE_LLISTAT_FITXERS_CAPSALERA + "\n");

        for (int i = 0; i < llistatFitxers.length; ++i) {
            if (llistatFitxers[i][FileUtils.FITXER_TIPUS_POS].equals("f")) {
                String nomFixter = llistatFitxers[i][FileUtils.FITXER_NOM_POS];
                String midaFixter = llistatFitxers[i][FileUtils.FITXER_MIDA_POS];

                nomFixter = String.format("%1$" + 20 + "s", nomFixter);
                midaFixter = String.format("%1$" + 20 + "s", midaFixter);

                System.out.print(nomFixter);
                System.out.println(midaFixter);
            }
        }
    }

    /**
     *
     * @param menu
     */
    public void mostrarMenu(String[] menu) {
        System.out.println();
        System.out.println(MISSATGE_LINIA_SEPARACIO);
        System.out.println(menu[0]);
        System.out.println(MISSATGE_LINIA_SEPARACIO);
        for (int pos = 1; pos < menu.length; pos++) {
            System.out.println(menu[pos]);
        }
    }
}
