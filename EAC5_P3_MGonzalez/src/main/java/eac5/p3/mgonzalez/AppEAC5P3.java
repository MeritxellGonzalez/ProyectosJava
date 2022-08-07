
package eac5.p3.mgonzalez;
/*
* @author Alejandro Santiago
 */

public class AppEAC5P3 {

    static final String MISSATGE_TRII_OPCIO = "\t\tTrii una opcio";
    static final String MISSATGE_TRII_OPCIO_MEDALLES = "\t\tTrii una opcio pel camp medalles de l'atleta";
    static final String MISSATGE_TRII_OPCIO_PAIS = "\t\tTrii una opcio pel camp pais de l'atleta";
    static final String MISSATGE_CODI_ATLETA = "\t\tTrii un codi d'atleta a donar d'alta";
    static final String MISSATGE_ERROR_LECTURA = UtilsES.VERMELL_ERR_P + "Error de lectura" + UtilsES.VERMELL_ERR_F;
    static final String MISSATGE_ATLETA_NO_TROBAT = UtilsES.VERMELL_ERR_P + "No s'ha trobat l'atletaa la vila olimpica" + UtilsES.VERMELL_ERR_F;
    static final String MISSATGE_TITOL_LLISTAT = "\t\t\tLLISTAT D'ATLETES";
    static final String MISSATGE_TITOL_INGRES = "\t\t\tMENU INGRES ATLETA";
    static final String MISSATGE_TITOL_ALTA = "\t\t\tMENU MARXA ATLETA";
    static final String MISSATGE_COMIAT = "\n\t\tFins la propera";
    static final String MISSATGE_TECLA = "\t\nPer finalitzar pressiona qualsevol tecla i despres ENTER";
    static final String MISSATGE_MITJANA = "La mitjana d'atletes de ";
    static final String MISSATGE_PAIS_ATLETES = "El nombre d'atletes del pais ";

    String[] menuPrincipal = {"\t\t\tGESTIO VILA OLIMPICA",
        "1. Registrar Atleta a la Vila",
        "2. Marxa Atleta de la Vila",
        "3. Mostrar Ateletes per pais",
        "4. Mostrar percentatge d'atletes per pais",
        "5. Mostrar dades Atletes",
        "6. Sortir"
    };
    String[] menuPercent = {"\tDE QUE DESITGES SAPIGUER EL PERCENTATGE?",
        "1. Dels Atletes d'un pais concret",
        "2. Resum dels Atletes per paisos"
    };

    public static void main(String[] args) {
        AppEAC5P3 prg = new AppEAC5P3();
        prg.inici();
    }

    public DadesVila inici() {

        int opcio ;
        DadesVila dadesVila = new DadesVila();
        dadesVila.inicialitzarDadesVila();

        do {
            mostrarMenu(menuPrincipal);
            opcio = UtilsES.demanarEnter(MISSATGE_TRII_OPCIO, MISSATGE_ERROR_LECTURA);
            switch (opcio) {
                case 1:
                    menuRegistreAtleta(dadesVila);
                    break;
                case 2:
                    menuMarxaAtleta(dadesVila);
                    break;
                case 3:
                    opcioMostrarAtletesPais(dadesVila);
                    break;
                case 4:
                    menuPercent(dadesVila);
                    break;
                case 5:
                    mostrarAtletesVilaOlimpica(dadesVila);
                    break;
                case 6:
                    System.out.println(MISSATGE_COMIAT);
                    break;
            }
        } while (opcio != 6);
        return dadesVila;
    }

    private void opcioMostrarAtletesPais(DadesVila dadesVila) {
        int posPais = UtilsES.demanarPais(
                dadesVila.valorsPaisos,
                MISSATGE_TRII_OPCIO_PAIS,
                MISSATGE_ERROR_LECTURA
        );

        int atletesCiutat = AtletaUtils.comptarAtletesPais(dadesVila.atletesVilaOlimpica,
                dadesVila.valorsPaisos[0][posPais]);

        mostrarMissatge(MISSATGE_PAIS_ATLETES
                + dadesVila.valorsPaisos[0][posPais] + " es " + atletesCiutat);
    }

    private void opcioMostrarMitAtletesPais(DadesVila dadesVila) {

        int posPais = UtilsES.demanarPais(
                dadesVila.valorsPaisos,
                MISSATGE_TRII_OPCIO_PAIS,
                MISSATGE_ERROR_LECTURA
        );

        mostrarMissatge(MISSATGE_MITJANA + dadesVila.valorsPaisos[1][posPais]
                + " va ser del "
                + String.format("%.2f",
                        AtletaUtils.calculaPercAtletaPais(dadesVila.atletesVilaOlimpica,
                                dadesVila.valorsPaisos[0][posPais], dadesVila)) + "%.");
    }

    private void resumAtletesPais(DadesVila dadesVila) {

        for (int i = 0; i < dadesVila.valorsPaisos[0].length; i++) {

            mostrarMissatge(MISSATGE_MITJANA + dadesVila.valorsPaisos[1][i]
                    + " va ser del "
                    + String.format("%.2f",
                            AtletaUtils.calculaPercAtletaPais(dadesVila.atletesVilaOlimpica,
                                    dadesVila.valorsPaisos[0][i], dadesVila)) + "%.");
        }
    }

    @Deprecated
    private void opcioSeleccioMedalla(DadesVila dadesVila) {
        int posMedalla = UtilsES.demanarTipusMedalla(
                dadesVila.valorsMedalles,
                MISSATGE_TRII_OPCIO_MEDALLES,
                MISSATGE_ERROR_LECTURA
        );

        mostrarMissatge("La medalla triada té codi "
                + posMedalla + " i un valor " + dadesVila.valorsMedalles[posMedalla]);
    }

    @Deprecated
    private void opcioSeleccioPais(DadesVila dadesVila) {
        int posPais = UtilsES.demanarPais(
                dadesVila.valorsPaisos,
                MISSATGE_TRII_OPCIO_PAIS,
                MISSATGE_ERROR_LECTURA
        );

        mostrarMissatge("El pais triat té codi "
                + dadesVila.valorsPaisos[0][posPais] + " i un nom de pais: "
                + dadesVila.valorsPaisos[1][posPais]);
    }

    @Deprecated
    private int generaPais(DadesVila dadesVila) {
        return (int) (Math.random() * dadesVila.valorsPaisos[0].length);
    }

    private static void mostrarMissatge(String missatge) {
        System.out.println(missatge);
    }

    /**
     *
     * @param menu
     */
    private void mostrarMenu(String[] menu) {

        System.out.println();

        System.out.println(UtilsES.LINEAS);
        System.out.println(UtilsES.ANELLES + menu[0] + "\t\t\t" + UtilsES.ANELLES);
        System.out.println(UtilsES.LINEAS);

        for (int i = 1; i < menu.length; ++i) {
            System.out.println(menu[i]);
        }
    }

    /**
     * Generació del proper codi d'atleta a assignar
     *
     * @param codi atleta del darrer atleta assignat
     * @return
     */
    private String generarCodiAtleta(int codiUltatleta) {
        return "AT" + (formataCodi(codiUltatleta + 1));
    }

    /**
     * Formata un integer com a string amb 3 digits
     *
     * @param codi d'atleta
     * @return
     */
    private String formataCodi(int codi) {
        return String.format("%03d", codi);
    }

    /**
     * TODO meterlo en DadesVila
     *
     * @param codiAtleta
     * @param posPais
     * @param posMedalla
     */
    private void registraAtleta(DadesVila dadesVila, String codiAtleta, int posPais, int posMedalla) {
        int espaiDisponible;
        espaiDisponible = cercaHabitacioBuida(dadesVila, dadesVila.atletesVilaOlimpica);
        if (espaiDisponible == -1) {
            System.out.println(UtilsES.LINEAS);
            System.out.println("  Vila Olimpica plena, " + codiAtleta
                    + " no pot ser enregistrat");
            System.out.println(UtilsES.LINEAS);
        } else {
            // Si tenim espais disponibles, mirem que el codi d'aquest atleta no estigui ja al sistema
            int pos = cercaAtleta(dadesVila.atletesVilaOlimpica, codiAtleta);
            if (pos == -1) {
                dadesVila.atletesVilaOlimpica[espaiDisponible][dadesVila.ID_ATLETA] = codiAtleta;
                dadesVila.atletesVilaOlimpica[espaiDisponible][dadesVila.ID_PAIS] = trobaStringArray(posPais, dadesVila.valorsPaisos[0]);
                dadesVila.atletesVilaOlimpica[espaiDisponible][dadesVila.ID_MEDALLES] = trobaStringArray(posMedalla, dadesVila.valorsMedalles);
                dadesVila.numAtletesRegistrats++;
                dadesVila.codiUltimAtleta++;
            } else {
                System.out.println("ERROR! l'ATLETA amb codi " + codiAtleta
                        + " ja es troba a la vila olimpica");
            }
        }
    }
//TODO meterlo en DadesVila

    public void menuRegistreAtleta(DadesVila dadesVila) {

        System.out.println(UtilsES.LINEAS);
        System.out.println(UtilsES.ICON_ARRIBA + MISSATGE_TITOL_INGRES + "\t\t\t" + UtilsES.ICON_ARRIBA);
        System.out.println(UtilsES.LINEAS);

        int codiPais = UtilsES.demanarPais(dadesVila.valorsPaisos, MISSATGE_TRII_OPCIO, MISSATGE_ERROR_LECTURA);
        int codiMedalles = UtilsES.demanarTipusMedalla(dadesVila.valorsMedalles, MISSATGE_TRII_OPCIO, MISSATGE_ERROR_LECTURA);
        String codiAtleta = generarCodiAtleta(dadesVila.codiUltimAtleta);
        registraAtleta(dadesVila, codiAtleta, codiPais, codiMedalles);

    }

    /**
     *
     * @param atlVilaOlimp
     * @param codiAtleta
     * @return
     */
    private int cercaAtleta(String[][] atlVilaOlimp, String codiAtleta) {
        int posIndex = 0;
        boolean trobat = false;

        // Important: Mai fer servir un bucle tipus for, si hem de terminar la seva
        // execucio a mig cami (en aquest cas, el codi d'atleta a l'array)
        while (posIndex < atlVilaOlimp.length && !trobat) {
            trobat = atlVilaOlimp[posIndex][DadesVila.ID_ATLETA].equalsIgnoreCase(codiAtleta);
            posIndex++;
        }

        if (!trobat) {
            return -1;
        } else {
            return (posIndex - 1);
        }
    }

    /**
     * TODO Meterlo en UtilsEs ??????
     *
     * @param atlVilaOlimp
     * @return
     */
    private int cercaHabitacioBuida(DadesVila dadesVila, String[][] atlVilaOlimp) {
        int posIndex = 0;
        boolean habitacioTrobada = false;

        if (dadesVila.numAtletesRegistrats == atlVilaOlimp.length) {
            return -1;
        }

        while (posIndex < atlVilaOlimp.length && !habitacioTrobada) {
            habitacioTrobada = atlVilaOlimp[posIndex][dadesVila.ID_ATLETA].equals("");
            posIndex++;
        }

        if (!habitacioTrobada) {
            return -1;
        } else {
            return (posIndex - 1);
        }
    }

    /**
     *
     */
    private void mostrarAtletesVilaOlimpica(DadesVila dadesVila) {

        System.out.println(UtilsES.LINEAS);
        System.out.println(UtilsES.ICON_LLISTAT + MISSATGE_TITOL_LLISTAT + "\t\t\t"
                + UtilsES.ICON_LLISTAT);
        System.out.println(UtilsES.LINEAS);

        System.out.println(UtilsES.LINEAS);
        System.out.println("NUM_HABITACIO" + "         ATLETA" + "       PAIS D'ORIGEN" + "             MEDALLES");
        System.out.println(UtilsES.LINEAS);

        for (int i = 0; i < dadesVila.atletesVilaOlimpica.length; i++) {
            System.out.println(formataDadesAtleta(dadesVila, dadesVila.atletesVilaOlimpica[i], i));
        }

        System.out.println("Nombre d'atletes a la vila olimpica:" + dadesVila.numAtletesRegistrats);
        System.out.println("Espai disponible a la vila olimpica:" + (dadesVila.atletesVilaOlimpica.length - dadesVila.numAtletesRegistrats));
    }

    /**
     *
     * @param dadaAtleta
     * @param posicio
     * @return
     *
     */
    private String formataDadesAtleta(DadesVila dadesVila, String dadaAtleta[], int posicio) {

        String pais = dadaAtleta[DadesVila.ID_PAIS];
        String medalla = dadaAtleta[DadesVila.ID_MEDALLES];
        String codiAtleta = dadaAtleta[DadesVila.ID_ATLETA];
        String codiHabitacio = "HAB" + formataCodi(posicio);

        String entradaAtleta
                = codiHabitacio + "                "
                + codiAtleta + "                "
                + pais + "                "
                + medalla;

        return entradaAtleta;
    }

    /**
     * Busca la posicio donada en un array de Strings i retorna el seu valor
     *
     * @param posicio posicio a buscar en l'array
     * @param array
     * @return el valor que hi ha a la posicio dins de l'array o un string buit
     * si no es troba
     */
    private String trobaStringArray(int posicio, String array[]) {
        // Fem comprovacions de valors no valids per la posicio del pais
        if (posicio < 0 || posicio >= array.length) {
            return "";
        }
        // si tot correcte retornem la el pais a l'array de paisos a la posicio donada
        return array[posicio];
    }

    public void menuMarxaAtleta(DadesVila dadesVila) {
        System.out.println(UtilsES.LINEAS);
        System.out.println(UtilsES.ICON_MARXA + MISSATGE_TITOL_ALTA + "\t\t\t" + UtilsES.ICON_MARXA);
        System.out.println(UtilsES.LINEAS);

        String codiAtleta = UtilsES.demanarString(MISSATGE_CODI_ATLETA, MISSATGE_ERROR_LECTURA);
        int pos = cercaAtleta(dadesVila.atletesVilaOlimpica, codiAtleta);

        if (pos >= 0) {
            UtilsES.imprimeixMissatgeComiat(codiAtleta, pos, dadesVila);
            UtilsES.demanarString(MISSATGE_TECLA + MISSATGE_COMIAT, codiAtleta);

            dadesVila.numAtletesRegistrats = marxaAtleta(dadesVila, pos, dadesVila.numAtletesRegistrats);
        } else {
            System.out.println(MISSATGE_ATLETA_NO_TROBAT);
        }
    }

    private int marxaAtleta(DadesVila dadesVila, int posicioPerEsborrar, int numAtletesRegistrats) {
        dadesVila.atletesVilaOlimpica[posicioPerEsborrar][DadesVila.ID_ATLETA] = "";
        dadesVila.atletesVilaOlimpica[posicioPerEsborrar][DadesVila.ID_PAIS] = "";
        dadesVila.atletesVilaOlimpica[posicioPerEsborrar][DadesVila.ID_MEDALLES] = "";

        return numAtletesRegistrats - 1;
    }

    private void menuPercent(DadesVila dadesVila) {
        mostraMenuPercent();
        for (int i = 1; i < menuPercent.length; ++i) {
            System.out.println(menuPercent[i]);
        }
        System.out.println("");
        int opcio = 0;
        do {
            opcio = UtilsES.demanarEnter(MISSATGE_TRII_OPCIO, MISSATGE_ERROR_LECTURA);
            switch (opcio) {
                case 1:
                    opcioMostrarMitAtletesPais(dadesVila);
                    break;
                case 2:
                    resumAtletesPais(dadesVila);
                    break;
            }
        } while (opcio > 2);
    }

    private void mostraMenuPercent() {
        System.out.println(UtilsES.ICON_PERCENT + menuPercent[0] + "\t   "
                + UtilsES.ICON_PERCENT);
        System.out.println(UtilsES.LINEAS);
    }

}

