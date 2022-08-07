package app6hospital;

import java.text.DecimalFormat;
import java.text.ParseException;

public class App6Hospital {

    static final short NUM_BOXES = 25;

    static final String MISSATGE_ERROR_LECTURA = "Error de lectura";
    static final String MISSATGE_CODI_PACIENT = "Introdueixi codi del pacient: ";
    static final String MISSATGE_MALALTIA = "Introdueixi malaltia del pacient: ";
    static final String MISSATGE_TRII_GRAVETAT = "Trii la gravetat del pacient (1.BAIXA, 2.MITJA, 3.ALTA): ";
    static final String MISSATGE_TRII_OPCIO = "Trii una opció";
    static final String MISSATGE_PREGUNTA_ALTAPACIENT = "Validar alta pacient ";
    static final String MISSATGE_PREGUNTA_HORA = "Quina hora és ara?";
    static final String MISSATGE_PACIENT_NO_TROBAT = "No s'ha trobat el pacient al servei d'urgències";
    static final String MISSATGE_COMIAT = "Fins la propera";
    static final String MISSATGE_PACIENT_EXISTENT = "ERROR! Aquest codi de pacient ja existeix.";
    static final String MISSATGE_SERVEI_PLE = "             Servei d'urgències ple               ";
    static final String MISSATGE_BUSCA_PACIENT = "Introdueix el codi pacient a buscar: ";
    static final String MISSATGE_LINIA_SEPARACIO = "------------------------------------------";
    static final String MISSATGE_CONTINUAR = "\nPresiona [ENTRAR] per continuar";
    static final String MISSATGE_INTRODUIR_OPCIO = "\nEsculliu una opció i premeu [ENTRAR]";
    static final String MISSATGE_LLISTAT_FITXERS = "--------------LLISTAT DE FITXERS----------";
    static final String MISSATGE_LLISTAT_DIRECTORIS = "--------------LLISTAT DE DIRECTORIS-------";
    static final String MISSATGE_LLISTAT_FITXERS_CAPSALERA = "          NOM                 MIDA (bytes)";
    static final String MISSATGE_LLISTAT_DIRECTORIS_CAPSALERA = "   OPCIO          DIRECTORI";

    static final int PREU_HORA_URGENCIES = 50;

    GeneraDates gData;
    FileUtils fileUtils;
    static String[] valorsGravetat = {
        "BAIXA",
        "MITJANA",
        "ALTA"
    };

    public static void main(String[] args) {
        App6Hospital prg = new App6Hospital();
        prg.inici();
    }

    private void inici() {
        int opcio;
        gData = new GeneraDates();
        fileUtils = new FileUtils();
        fileUtils.inicialitza();

        DadesCOVID dCovid = fileUtils.carregaOcupacio();

        String[] menuPrincipal = {"GESTIÓ COVID URGÈNCIES",
            "1. Ingrés de pacient",
            "2. Alta de pacient",
            "3. Llistat de pacients ingressats",
            "4. Mostrar nombre de pacients segons gravetat",
            "5. Buscar pacient historic",
            "",
            "",
            "9. Gestió de dades",
            "",
            "0. Sortir"
        };

        do {
            UtilsES.mostrarMenu(menuPrincipal);
            opcio = UtilsES.demanarEnter(MISSATGE_TRII_OPCIO, MISSATGE_ERROR_LECTURA);
            switch (opcio) {
                case 1:
                    menuIngres(dCovid);
                    break;
                case 2:
                    menuAlta(dCovid);
                    break;
                case 3:
                    mostrarOcupacioUrgencies(dCovid);
                    break;
                case 4:
                    menuNombrePacients(dCovid);
                    break;
                case 5:
                    buscaPacientHistoric(dCovid);
                    break;
                case 9:
                    subMenuDades();
                    break;
                case 0:
                    System.out.println(MISSATGE_COMIAT);
                    fileUtils.guardaOcupacio(dCovid);
            }
        } while (opcio != 0);
    }

    private void buscaPacientHistoric(DadesCOVID dCovid) {
        String codiPacient = UtilsES.demanaString(MISSATGE_BUSCA_PACIENT, MISSATGE_ERROR_LECTURA);

        String[] pacient = fileUtils.getHistoricPacient(codiPacient);

        if (pacient[DadesCOVID.ID_PACIENT] == null || pacient[DadesCOVID.ID_PACIENT].equals("")) {
            UtilsES.mostrarMissatge("DADES DE L'ALTA HOSPITALARIA", "No s'ha trobat el pacient");
        } else {
            // UtilsES.mostrarMissatge(titol, missatge);
            UtilsES.mostrarMissatge("DADES DE L'ALTA HOSPITALARIA",
                    "Codi Pacient: " + pacient[DadesCOVID.ID_PACIENT] + System.getProperty("line.separator")
                    + "GRAVETAT: " + pacient[DadesCOVID.ID_GRAVETAT] + System.getProperty("line.separator")
                    + "Data Ingres: " + pacient[DadesCOVID.ID_DATAINGRES] + System.getProperty("line.separator")
                    + "Data Alta " + pacient[DadesCOVID.ID_DATAALTA] + System.getProperty("line.separator")
                    + "Cost estada:" + pacient[DadesCOVID.ID_COST]
            );
        }
    }

    private void menuNombrePacients(DadesCOVID dCovid) {

        String gravetat = UtilsES.demanarGravetat(MISSATGE_TRII_GRAVETAT, MISSATGE_ERROR_LECTURA);
        int numPacGrav = COVIDUtils.contarPacientsGravetat(dCovid.pacientsUrgenciesCOVID, gravetat);
        UtilsES.mostrarMissatge("NOMBRE DE PACIENTS AMB GRAVETAT " + gravetat, "Total pacients: " + numPacGrav);

    }

    private void menuIngres(DadesCOVID dCovid) {
        String horaIngres = gData.novaData();
        String gravetat = UtilsES.demanarGravetat(MISSATGE_TRII_GRAVETAT, MISSATGE_ERROR_LECTURA);
        String codiPacient = COVIDUtils.generarCodiPacient(dCovid);
        ingressaPacient(dCovid, codiPacient, horaIngres, gravetat);
    }

    private void menuAlta(DadesCOVID dCovid) {
        String codiPacient = UtilsES.demanaString(MISSATGE_CODI_PACIENT, MISSATGE_ERROR_LECTURA);
        int pos = COVIDUtils.cercaPacient(dCovid.pacientsUrgenciesCOVID, codiPacient);
        long costEstada;
        long horesEstada;
        if (pos >= 0) {
            UtilsES.validarAltaPacient(MISSATGE_PREGUNTA_ALTAPACIENT + codiPacient + " ingressat el " + dCovid.pacientsUrgenciesCOVID[pos][COVIDUtils.ID_DATAINGRES] + " amb gravetat " + dCovid.pacientsUrgenciesCOVID[pos][COVIDUtils.ID_GRAVETAT]);
            String dataIngres = dCovid.pacientsUrgenciesCOVID[pos][COVIDUtils.ID_DATAINGRES];
            String dataAlta = gData.novaData();
            horesEstada = COVIDUtils.calculaDuradaIngres(dataIngres, dataAlta);
            costEstada = horesEstada * PREU_HORA_URGENCIES;
            UtilsES.mostrarMissatge("DADES DE L'ALTA HOSPITALARIA", "Data Ingres: " + dataIngres + "  Data Alta " + dataAlta + "  Hores estada:" + horesEstada + " Cost estada:" + DecimalFormat.getCurrencyInstance().format(costEstada));
            fileUtils.guardarAltaEnHistoric(dCovid.pacientsUrgenciesCOVID[pos], costEstada, dataAlta);
            altaPacient(pos, dCovid);

        } else {
            System.out.println(MISSATGE_PACIENT_NO_TROBAT);
        }
    }

    /**
     * A partir del codi pacient rebut cerca si el pacient es troba dins l'array
     * pacientsUrgencies, en cas contrari en far la inserció a la darrera
     * posició incrementant el nombre de pacients ingressats. Si s'arriba al
     * màxim ja no farà cap més inserció.
     *
     * @param codi pacient del pacient a ingressar
     * @param malaltia diagnosticada al pacient a ingressar
     * @param gravetat estimada al pacient a ingressar
     */
    private void ingressaPacient(DadesCOVID dCovid, String codiPacient, String horaIngres, String gravetat) {
        int espaiDisponible;
        if (dCovid.numPacientsIngressats == dCovid.pacientsUrgenciesCOVID.length) {
            System.out.println("------------------------------------------");
            System.out.println("  Servei d'urgències ple, " + codiPacient + " no pot ser ingressat");
            System.out.println("------------------------------------------");
        } else {
            int pos = COVIDUtils.cercaPacient(dCovid.pacientsUrgenciesCOVID, codiPacient);
            if (pos == -1) {  // S'han recorregut tots els pacients i no s'ha trobat coincidencia
                espaiDisponible = COVIDUtils.cercaEspaiBuit(dCovid.pacientsUrgenciesCOVID);
                dCovid.pacientsUrgenciesCOVID[espaiDisponible][COVIDUtils.ID_PACIENT] = codiPacient;
                dCovid.pacientsUrgenciesCOVID[espaiDisponible][COVIDUtils.ID_DATAINGRES] = horaIngres;
                dCovid.pacientsUrgenciesCOVID[espaiDisponible][COVIDUtils.ID_GRAVETAT] = gravetat;

                // fileUtils.afegirAccioLog( dCovid.pacientsUrgenciesCOVID[espaiDisponible], "INGRES");
                dCovid.numPacientsIngressats++;
                dCovid.codiUltimPacient++;
            } else {
                System.out.println("ERROR! El PACIENT amb codi " + codiPacient + " ja es troba ingressat");
            }
        }
    }

    /**
     * Mostra un llistat dels pacients que hi ha ingressats dins el servei
     * d'urgències
     *
     * @param Array pacients urgències
     */
    private void mostrarOcupacioUrgencies(DadesCOVID dCovid) {
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("----------------------------LLISTAT DE PACIENTS--------------------------");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("NUMBOX" + "         PACIENT" + "       DATA ENTRADA" + "             GRAVETAT");
        System.out.println("-------------------------------------------------------------------------");
        for (int i = 0; i < dCovid.pacientsUrgenciesCOVID.length; i++) {
            System.out.print("BOX" + COVIDUtils.formataCodi(i));
            System.out.print("         ");
            System.out.print(dCovid.pacientsUrgenciesCOVID[i][DadesCOVID.ID_PACIENT]);
            System.out.print("         ");
            System.out.print(dCovid.pacientsUrgenciesCOVID[i][DadesCOVID.ID_DATAINGRES]);
            System.out.print("         ");
            System.out.println(dCovid.pacientsUrgenciesCOVID[i][DadesCOVID.ID_GRAVETAT]);
        }
        System.out.println("Nombre pacients ingressats:" + dCovid.numPacientsIngressats);
        System.out.println("Espai disponible al servei:" + (dCovid.pacientsUrgenciesCOVID.length - dCovid.numPacientsIngressats));

        /**
         * altaPacient realitza l'alta hospitalària del pacient (baixa de
         * l'array)
         *
         * @param array pacientsUrgencies
         * @param int posició a esborrar
         * @return nombre actual de pacients ingressats
         */
    }

    public void altaPacient(int posicioPerEsborrar, DadesCOVID dCovid) {

        dCovid.pacientsUrgenciesCOVID[posicioPerEsborrar][DadesCOVID.ID_PACIENT] = "";
        dCovid.pacientsUrgenciesCOVID[posicioPerEsborrar][DadesCOVID.ID_DATAINGRES] = "";
        dCovid.pacientsUrgenciesCOVID[posicioPerEsborrar][DadesCOVID.ID_GRAVETAT] = "";

        dCovid.numPacientsIngressats--;
    }

    private void subMenuDades() {
        int opcio;
        String[] subMenuDades = {"GESTIO COVID URGENCIES - DADES",
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
            "GESTIO COVID URGENCIES - DADES - CANVI DIRECTORI",};
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
            "GESTIO COVID URGENCIES - DADES - MOSTRAR DIRECTORI DADES",};
        mostrarMenu(subMenuMostraDirectori);

        String dir = fileUtils.getDirectoryDades();
        System.out.println("\nEl directori de dades es: " + dir);
        UtilsES.demanaEnter(MISSATGE_CONTINUAR);
    }

    /**
     *
     */
    private void eliminarFitxers() {
        String[] subMenuEliminarFitxers = {
            "GESTIO COVID URGENCIES - DADES - ELIMINAR FITXER",};

        mostrarMenu(subMenuEliminarFitxers);

        String nomFitxer = UtilsES.demanaString("\n\nIntrodueix el nom del fitxer a esborrar (del directori de dades)", MISSATGE_ERROR_LECTURA);
        boolean result = fileUtils.esborraFitxer(nomFitxer);

        if (result) {
            System.out.println("\nCORRECTE! Fitxer esborrat correctament");
        } else {
            System.out.println("\nERROR! no s'ha pogut esborrar el fitxer");
        }

        UtilsES.demanaEnter(MISSATGE_CONTINUAR);
    }

    /**
     *
     */
    private void llistarFitxers() {
        String[] subMenuLlistarFitxers = {
            "GESTIO COVID URGENCIES - DADES - LLISTAR FITXERS",};
        mostrarMenu(subMenuLlistarFitxers);

        String[][] llistat = fileUtils.getLlistaContingut(fileUtils.getDirectoryDades());

        mostraLListatFitxers(llistat);
        UtilsES.demanaEnter(MISSATGE_CONTINUAR);
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
    private void mostrarMenu(String[] menu) {
        System.out.println();
        System.out.println(MISSATGE_LINIA_SEPARACIO);
        System.out.println(menu[0]);
        System.out.println(MISSATGE_LINIA_SEPARACIO);
        for (int pos = 1; pos < menu.length; pos++) {
            System.out.println(menu[pos]);
        }
    }
}
