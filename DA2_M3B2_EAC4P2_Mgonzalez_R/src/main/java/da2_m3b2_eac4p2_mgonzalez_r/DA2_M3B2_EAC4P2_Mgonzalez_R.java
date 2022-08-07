package da2_m3b2_eac4p2_mgonzalez_r;

import java.util.Scanner;

public class DA2_M3B2_EAC4P2_Mgonzalez_R {

    static final short NUM_ATLETES = 30;
    static final short CONTROL_ERROR = 999;
    static final String MISSATGE_LINIA_SEPARACIO = "-----------------------------------------------------------------------";
    static final String LLISTAT_PAÏSOS = "1. DE \t 2.FR \t 3.US \t 4.CH \t 5.ES \t 6.JP";
    static final String MEDALLES = "\t1.Diploma \t2.Bronze \t 3.Plata \t 4.Or";
    static final String MISSATGE_COMIAT = "Gràcies per formar-ne part.";
    static final String PREGUNTA_PAIS = "De quin país ets representant?\n\t" + LLISTAT_PAÏSOS;
    static final String PREGUNTA_MEDALLA = "Has aconseguit alguna medalla?\n\t" + "1.SI 2.NO";
    static final String NO_ENTER = "Dada introduïda incorrecte.";
    static final String TIPUS_MEDALLA = "Quina es la medalla que has guanyat?\n\t" + MEDALLES;

    int numAtletesRegistrats = 0;
    int codiUltimAtleta = 0;

    String[][] atletesVilaOlimpica = new String[NUM_ATLETES][4];

    String[] valorsMedalles = {
        "CAP",
        "DIPLOMA",
        "BRONZE",
        "PLATA",
        "OR"
    };

    String[] valorsPaisos = {"DE", "FR", "US", "CH", "ES", "JP"};

    public static void main(String[] args) {
        DA2_M3B2_EAC4P2_Mgonzalez_R  prg = new DA2_M3B2_EAC4P2_Mgonzalez_R();
        prg.inici();
    }

    private void inici() {
        inicialitzarAtletes();
        int opcio_menu = 0;

        String[] menuPrincipal = {"\t\tGESTIÓ VILA OLÍMPICA",
            "1.Registrar Atleta", "2.Marxar Atleta",
            "3.Llistat d'Atletes de la Vila Olímpica", "4.Sortir"};

        while (opcio_menu != 4) {
            Scanner teclat = new Scanner(System.in);
            mostrarMenu(menuPrincipal);
            if (!comprovarEnter(teclat)) {
                System.out.println(NO_ENTER);
                continue;
            }
            opcio_menu = teclat.nextInt();
            switch (opcio_menu) {
                case 1:
                    menuIngres();
                    break;
                case 2:
                    menuMarxaAtleta();
                    break;
                case 3:
                    mostrarAtletesVilaOlimpica();
                    break;
                case 4:
                    System.out.println(MISSATGE_COMIAT);
            }
        }
    }

    private void inicialitzarAtletes() {
        for (int i = 0; i < atletesVilaOlimpica.length; ++i) {
            for (int j = 0; j < atletesVilaOlimpica[i].length; ++j) {
                borrarAtleta(i, j);
            }
        }
    }

    private void borrarAtleta(int posAtleta, int posInfo) {
        atletesVilaOlimpica[posAtleta][posInfo] = "";
        atletesVilaOlimpica[posAtleta][0] = generarCodiHabitacio(posAtleta);
    }

    private boolean comprovarEnter(Scanner teclat) {
        return teclat.hasNextInt();
    }

    private int generarPais() {
        return (int) (Math.random() * valorsPaisos.length);
    }

    private String generarCodiHabitacio(int codiUltAtleta) {
       
        return "HAB" + formataCodi(codiUltAtleta);
    }

    private String generarCodiAtleta(int codiUltatleta) {
        return "TO" + (formataCodi(codiUltatleta));
    }

    private String formataCodi(int codi) {
        return String.format("%03d", codi);
    }

    private int comprovarEspaiBuit() {
        for (int i = 0; i < NUM_ATLETES; i++) {
            if (atletesVilaOlimpica[i][1] == "") {
                return i;
            }
        }
        return CONTROL_ERROR;
    }

    private void registraAtleta(int posPais, int posMedalla) {
        int espaiBuit = comprovarEspaiBuit();
        if (espaiBuit != CONTROL_ERROR) {
            atletesVilaOlimpica[espaiBuit][1] = generarCodiAtleta(espaiBuit + 1);
            atletesVilaOlimpica[espaiBuit][2] = valorsPaisos[posPais];
            atletesVilaOlimpica[espaiBuit][3] = valorsMedalles[posMedalla];
            System.out.println("Atleta registrat correctament");
            numAtletesRegistrats++;
            return;
        }
        System.out.println("Ja no hi han mes espais disponibles");
    }

    private void mostrarAtletesVilaOlimpica() {
        System.out.println(MISSATGE_LINIA_SEPARACIO + "\n\t\t\tLLISTAT ATLETES\n" + MISSATGE_LINIA_SEPARACIO);
        System.out.println("NUM_HABITACIO" + "         ATLETA" + "       PAIS D'ORIGEN" + "             MEDALLES\n" + MISSATGE_LINIA_SEPARACIO);

        for (int i = 0; i < NUM_ATLETES; i++) {
            System.out.println(atletesVilaOlimpica[i][0] + "\t\t\t"
                    + atletesVilaOlimpica[i][1] + "\t\t" + atletesVilaOlimpica[i][2]
                    + "\t\t" + atletesVilaOlimpica[i][3]
            );
        }

        System.out.println("Nombre d'atletes a la vila olimpica:" + numAtletesRegistrats);
        System.out.println("Espai disponible a la vila olimpica:" + (NUM_ATLETES - numAtletesRegistrats));
    }

    public void mostrarMenu(String[] menu) {
        System.out.println();
        System.out.println(MISSATGE_LINIA_SEPARACIO);
        System.out.println(menu[0]);
        System.out.println(MISSATGE_LINIA_SEPARACIO);
        for (int pos = 1; pos < menu.length; pos++) {
            System.out.println(menu[pos]);
        }
    }

    private void menuIngres() {
        int pais = demanarPais();
        int medalles = demanarMedalla(valorsMedalles);

        registraAtleta(pais, medalles);
    }

    private int solicitarValor(String pregunta, int min, int max) {
        while (true) {
            System.out.println(pregunta);
            Scanner teclat = new Scanner(System.in);
            if (!comprovarEnter(teclat)) {
                System.out.println(NO_ENTER);
                continue;
            }
            int valor = teclat.nextInt();
            if (valor >= min && valor <= max) {
                return valor - 1;
            }
            System.out.println("NO ES CORRECTE");
        }
    }

    private int demanarPais() {
        return solicitarValor(PREGUNTA_PAIS, 1, 6);
    }

    
    private int demanarMedalla(String[] valorMedalles) {
        int opcio = solicitarValor(PREGUNTA_MEDALLA, 1, 2);
        if (opcio == 1) {
            return 0;
        }
        return aprovacioMedalla();
    }

    private int aprovacioMedalla() {
        return solicitarValor(TIPUS_MEDALLA, 1, 4) + 1;
    }

   
    private void menuMarxaAtleta() {

        while (true) {
            System.out.println("Quin es el codi D'atleta que marxa?");
            Scanner teclat = new Scanner(System.in);
            String valor = teclat.next();

            boolean trobat = false;

            for (int i = 0; i < atletesVilaOlimpica.length; i++) {
                if (atletesVilaOlimpica[i][1].equalsIgnoreCase(valor)) {
                    for (int j = 0; j < atletesVilaOlimpica[i].length; j++) {
                        borrarAtleta(i, j);
                    }
                    System.out.println("L'atleta amb codi " + valor + " ha marxat!");
                    numAtletesRegistrats--;
                    trobat = true;
                    break;

                }
            }
            if (trobat) {
                break;
            }
            trobat = true;
            System.err.println("\tAquest atleta amb codi " + valor + " no existeix");

        }
    }

}
