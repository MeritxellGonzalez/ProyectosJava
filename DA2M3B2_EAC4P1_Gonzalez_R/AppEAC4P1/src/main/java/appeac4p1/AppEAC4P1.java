package appeac4p1;

public class AppEAC4P1 {

    int numAtletesRegistrats = 0;
    int codiUltimAtleta = 0;

    static final short NUM_ATLETES = 30;
    static final String LINEAS = "-----------------------------------------------------------------------";
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
        AppEAC4P1 prg = new AppEAC4P1();
        prg.inici();
    }

    private void inici() {

        // Inicialitzem totes les dades de la vila olimpica
        for (int i = 0; i < atletesVilaOlimpica.length; ++i) {
            for (int j = 0; j < atletesVilaOlimpica[i].length; ++j) {
                atletesVilaOlimpica[i][j] = "";
                atletesVilaOlimpica[i][0] = generarCodiHabitacio(i);
            }
        }

        // Primer es mostra l'ocupacie de la vila Olimpica. Aquest ha de ser buit per començar
        mostrarAtletesVilaOlimpica();

        // Despres es simula l'entrada de tots - 1 de la mida de la vila olimpica
        for (int i = 0; i < NUM_ATLETES - 1; i++) {
            codiUltimAtleta++;
            registraAtleta(generarCodiAtleta(codiUltimAtleta), generaPais(), 0);
            mostrarAtletesVilaOlimpica();
        }

        // Error, atleta ja existeix:
        registraAtleta("TO023", generaPais(), 0);
        mostrarAtletesVilaOlimpica();
        codiUltimAtleta++;

        // Afegim un mes manualmente, en l'ultim espai buit
        registraAtleta(generarCodiAtleta(codiUltimAtleta), generaPais(), 0);
        mostrarAtletesVilaOlimpica();
        codiUltimAtleta++;

        // Hem arribat al maxim d'ocupacio, aquesta darrera entrada no hauria
        // de permetre inserir-la.
        registraAtleta(generarCodiAtleta(codiUltimAtleta), generaPais(), 0);
        mostrarAtletesVilaOlimpica();
    }

    /**
     * Generació aleatoria del codi d'un pais dels disponibles a l'array paisos
     *
     * @return
     */
    private int generaPais() {
        return (int) (Math.random() * valorsPaisos.length);
    }

    private String generarCodiHabitacio(int codiUltatleta) {
        return "HAB" + formataCodi(codiUltatleta);
    }

    //Mètode a implementar
    private String generarCodiAtleta(int codiUltatleta) {
        return "TO" + formataCodi(codiUltatleta);
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

    //Mètode a implementar
    private void registraAtleta(String codiAtleta, int posPais, int posMedalla) {
        if (numAtletesRegistrats > NUM_ATLETES - 1) {
            System.out.println("Vila Olimpica plena, " + codiAtleta + " no es pot enregistrar.");
            return;
        }
        for (int i = 0; i < NUM_ATLETES; i++) {
            if (atletesVilaOlimpica[i][1].equalsIgnoreCase(codiAtleta)) {
                System.out.println("Aquest atleta " + codiAtleta + " ja esta registrat");
                return;
            }
        }
        if (atletesVilaOlimpica[numAtletesRegistrats][1] != "") {
            System.out.println("Aquesta posició no esta buida");
            return;
        }
        atletesVilaOlimpica[numAtletesRegistrats][1] = codiAtleta;
        atletesVilaOlimpica[numAtletesRegistrats][2] = valorsPaisos[posPais];
        atletesVilaOlimpica[numAtletesRegistrats][3] = valorsMedalles[posMedalla];
        numAtletesRegistrats++;
    }

    //Mètode a implementar 
    private void mostrarAtletesVilaOlimpica() {
        System.out.println(LINEAS);
        System.out.println("LLISTAT ATLETES");
        System.out.println(LINEAS);
        System.out.println(LINEAS);
        System.out.println("NUM HABITACIÓ        CODI ATLETA        PAIS         MEDALLES");
        System.out.println(LINEAS);

        for (int i = 0; i < NUM_ATLETES; i++) {
            System.out.println(atletesVilaOlimpica[i][0] + "\t\t\t" + atletesVilaOlimpica[i][1] + "\t\t\t" + atletesVilaOlimpica[i][2] + "\t\t" + atletesVilaOlimpica[i][3]);
        }
        System.out.println("\n\tNombre d'atletes a la vila olimpica: " + numAtletesRegistrats);
        System.out.println("\tEspai disponible a la vila olimpica: " + (NUM_ATLETES - numAtletesRegistrats) + "\n");
        
    }
}
