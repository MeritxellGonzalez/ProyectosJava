package eac5.p1.mgonzalez;

import eac5.p1.mgonzalez.UtilsES.*;
import eac5.p1.mgonzalez.AtletaUtils.*;

/*
* @author Alejandro Santiago
 */
public class EAC5_P1_MGonzalez {

    static final short ID_ATLETA = 0;
    public static final short ID_PAIS = 1;
    static final short ID_MEDALLES = 2;

    static final String MISSATGE_TRII_OPCIO = "Trii una opcio";
    static final String MISSATGE_TRII_OPCIO_MEDALLES = "Trii una opcio pel camp medalles de l'atleta";
    static final String MISSATGE_TRII_OPCIO_PAIS = "Trii una opcio pel camp pais de l'atleta";
    static final String MISSATGE_CODI_ATLETA = "Trii un codi d'atleta a donar d'alta";
    static final String MISSATGE_ERROR_LECTURA = "Error de lectura";
    static final String MISSATGE_ATLETA_NO_TROBAT = "No s'ha trobat l'atletaa la vila olimpica";
    static final String MISSATGE_TITOL_MENU = "GESTIO VILA OLIMPICA";
    static final String MISSATGE_PREGUNTA_MARXAATLETA = "Validar marxa d'atleta";
    static final String MISSATGE_TITOL_INGRES = "MENU INGRES ATLETA";
    static final String MISSATGE_TITOL_ALTA = "MENU MARXA ATLETA";
    static final String MISSATGE_TITOL_LLISTAT = "LLISTAT D'ATLETES";
    static final String MISSATGE_COMIAT = "Fins la propera";
    static final String MISSATGE_MITJANA = "La mitjana de'atletes ";
    static final String MISSATGE_PAIS_ATLETES = "El nombre d'atletes del pais ";
    static final String MISSATGE_LINIA_SEPARACIO = "-----------------------------------------------------------------------";

    int numAtletesRegistrats = 0;
    int codiUltimAtleta = 0;

    static final short NUM_ATLETES = 30;
    String[][] atletesVilaOlimpica = new String[NUM_ATLETES][3];

    String[] valorsMedalles = {
        "CAP",
        "DIPLOMA",
        "BRONZE",
        "PLATA",
        "OR"
    };

    String[][] valorsPaisos
            = {
                {"DE", "FR", "US", "CH", "ES", "JP"},
                {"Alemanya", "França", "Estats Units", "Xina", "Espanya", "Japo"}
            };

    String[] menuPrincipal = {
        "1. Mostrar atletes x pais",
        "2. Mostrar mitjana atletes / pais",
        "3. Selecció de pais",
        "4. Selecció de medalla",
        "5. Mostrar dades Atletes",
        "9. Sortir"
    };

    public static void main(String[] args) {
        EAC5_P1_MGonzalez prg = new EAC5_P1_MGonzalez();
        prg.inici();
    }

    private void inici() {

        inicialitzaDades();

        int opcio = 0;

        do {
            mostrarMenu(menuPrincipal);
            opcio = UtilsES.demanarEnter(MISSATGE_TRII_OPCIO, MISSATGE_ERROR_LECTURA);
            switch (opcio) {
                case 1:
                    opcioMostrarAtletesPais();
                    break;
                case 2:
                    opcioMostrarMitAtletesPais();
                    break;
                case 3:
                    opcioSeleccioPais();
                    break;
                case 4:
                    opcioSeleccioMedalla();
                    break;
                case 5:
                    mostrarAtletesVilaOlimpica();
                    break;
                case 9:
                    System.out.println(MISSATGE_COMIAT);
                    break;
            }
        } while (opcio != 9);
    }

    private void inicialitzaDades() {
        // Inicialitzem totes les dades de la vila olimpica
        for (int i = 0; i < atletesVilaOlimpica.length; ++i) {
            for (int j = 0; j < atletesVilaOlimpica[i].length; ++j) {
                atletesVilaOlimpica[i][j] = "";
            }
        }

        // Despres es simula l'entrada de tots els atletes de la vila olimpica
        for (int i = 0; i < NUM_ATLETES; i++) {
            registraAtleta(generarCodiAtleta(codiUltimAtleta), generaPais(), 0);
        }

        mostrarAtletesVilaOlimpica();
    }

    private void opcioMostrarAtletesPais() {
        int posPais = UtilsES.demanarPais(
                valorsPaisos,
                MISSATGE_TRII_OPCIO_PAIS,
                MISSATGE_ERROR_LECTURA
        );

        int atletesCiutat = AtletaUtils.comptarAtletesPais(atletesVilaOlimpica, valorsPaisos[0][posPais]);

        mostrarMissatge(MISSATGE_PAIS_ATLETES
                + valorsPaisos[0][posPais] + " es " + atletesCiutat);
    }

    private void opcioMostrarMitAtletesPais() {
        int posPais = UtilsES.demanarPais(
                valorsPaisos,
                MISSATGE_TRII_OPCIO_PAIS,
                MISSATGE_ERROR_LECTURA
        );

        mostrarMissatge(
                MISSATGE_MITJANA + valorsPaisos[1][posPais] + " va ser "
                + String.format("%.2f",
                        AtletaUtils.calculaPercAtletaPais(atletesVilaOlimpica, valorsPaisos[0][posPais])));
    }

    private void opcioSeleccioMedalla() {
        int posMedalla = UtilsES.demanarTipusMedalla(
                valorsMedalles,
                MISSATGE_TRII_OPCIO_MEDALLES,
                MISSATGE_ERROR_LECTURA
        );

        mostrarMissatge("La medalla triada té codi "
                + posMedalla + " i un valor " + valorsMedalles[posMedalla]);
    }

    private void opcioSeleccioPais() {
        int posPais = UtilsES.demanarPais(
                valorsPaisos,
                MISSATGE_TRII_OPCIO_PAIS,
                MISSATGE_ERROR_LECTURA
        );

        mostrarMissatge("El pais triat té codi "
                + valorsPaisos[0][posPais] + " i un nom de pais: " + valorsPaisos[1][posPais]);
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

        System.out.println(MISSATGE_LINIA_SEPARACIO);
        System.out.println(MISSATGE_TITOL_MENU);
        System.out.println(MISSATGE_LINIA_SEPARACIO);

        for (int i = 0; i < menu.length; ++i) {
            System.out.println(menu[i]);
        }
    }

    /**
     * Generació aleatoria del codi d'un pais dels disponibles a l'array paisos
     *
     * @return
     */
    private int generaPais() {
        return (int) (Math.random() * valorsPaisos[0].length);
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
     *
     * @param codiAtleta
     * @param posPais
     * @param posMedalla
     */
    private void registraAtleta(String codiAtleta, int posPais, int posMedalla) {

        // Primer comprovem si tenim espai a la vila olimpica per el nou atleta
        int espaiDisponible;
        espaiDisponible = cercaHabitacioBuida(atletesVilaOlimpica);
        if (espaiDisponible == -1) {
            System.out.println("------------------------------------------");
            System.out.println("  Vila Olimpica plena, " + codiAtleta + " no pot ser enregistrat");
            System.out.println("------------------------------------------");
        } else {
            // Si tenim espais disponibles, mirem que el codi d'aquest atleta no estigui ja al sistema
            int pos = cercaAtleta(atletesVilaOlimpica, codiAtleta);
            if (pos == -1) {  // S'han recorregut tots els atletes i no s'ha trobat coincidencia
                atletesVilaOlimpica[espaiDisponible][ID_ATLETA] = codiAtleta;
                atletesVilaOlimpica[espaiDisponible][ID_PAIS] = trobaStringArray(posPais, valorsPaisos[0]);
                atletesVilaOlimpica[espaiDisponible][ID_MEDALLES] = trobaStringArray(posMedalla, valorsMedalles);
                numAtletesRegistrats++;
                codiUltimAtleta++;
            } else {
                System.out.println("ERROR! l'ATLETA amb codi " + codiAtleta + " ja es troba a la vila olimpica");
            }
        }
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
            trobat = atlVilaOlimp[posIndex][ID_ATLETA].equalsIgnoreCase(codiAtleta);
            posIndex++;
        }

        if (!trobat) {
            return -1;
        } else {
            return (posIndex - 1);
        }
    }

    /**
     *
     * @param atlVilaOlimp
     * @return
     */
    private int cercaHabitacioBuida(String[][] atlVilaOlimp) {
        int posIndex = 0;
        boolean habitacioTrobada = false;

        if (numAtletesRegistrats == atlVilaOlimp.length) {
            return -1;
        }

        // Important: Mai fer servir un bucle tipus for, si hem de terminar la seva
        // execucio a mig cami (en aquest cas, quan trobem habitacio lliure)
        while (posIndex < atlVilaOlimp.length && !habitacioTrobada) {
            habitacioTrobada = atlVilaOlimp[posIndex][ID_ATLETA].equals("");
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
    private void mostrarAtletesVilaOlimpica() {

        System.out.println(MISSATGE_LINIA_SEPARACIO);
        System.out.println(MISSATGE_TITOL_LLISTAT);
        System.out.println(MISSATGE_LINIA_SEPARACIO);

        System.out.println(MISSATGE_LINIA_SEPARACIO);
        System.out.println("NUM_HABITACIO" + "         ATLETA" + "       PAIS D'ORIGEN" + "             MEDALLES");
        System.out.println(MISSATGE_LINIA_SEPARACIO);

        for (int i = 0; i < atletesVilaOlimpica.length; i++) {
            System.out.println(formataDadesAtleta(atletesVilaOlimpica[i], i));
        }

        System.out.println("Nombre d'atletes a la vila olimpica:" + numAtletesRegistrats);
        System.out.println("Espai disponible a la vila olimpica:" + (atletesVilaOlimpica.length - numAtletesRegistrats));
    }

    /**
     *
     * @param dadaAtleta
     * @param posicio
     * @return
     */
    private String formataDadesAtleta(String dadaAtleta[], int posicio) {

        String pais = dadaAtleta[ID_PAIS];
        String medalla = dadaAtleta[ID_MEDALLES];
        String codiAtleta = dadaAtleta[ID_ATLETA];
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
}
