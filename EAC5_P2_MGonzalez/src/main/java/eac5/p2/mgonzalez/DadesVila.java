package eac5.p2.mgonzalez;

public class DadesVila {

    static final short ID_ATLETA = 0;
    public static final short ID_PAIS = 1;
    static final short ID_MEDALLES = 2;

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

    private void inicialitzarDades() {
        for (int i = 0; i < atletesVilaOlimpica.length; i++) {
            for (int j = 0; j < atletesVilaOlimpica[i].length; j++) {
                atletesVilaOlimpica[i][j] = "";
            }
        }
    }
}
