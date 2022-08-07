/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgonzalez.eac6.p2;

public class DadesVila {

    static final short NUM_ATLETES = 30;
    static final short ID_ATLETA = 0;
    static final short ID_PAIS = 1;
    static final short ID_MEDALLES = 2;

    static final short ID_ATLETA_LENGTH = 5;
    static final short ID_PAIS_LENGTH = 2;
    static final short ID_MEDALLES_LENGTH = 7;

    public String[][] atletesVilaOlimpica = new String[NUM_ATLETES][3];

    public String[] valorsMedalles = {
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

    public int numAtletesRegistrats;
    public int codiUltimAtleta;
    
    DadesVila() {
        numAtletesRegistrats = 0;
        codiUltimAtleta = 0;
    }

    public DadesVila(int i) {
        atletesVilaOlimpica = new String[i][3];
        for (int j = 0; j < atletesVilaOlimpica.length; j++) {
            atletesVilaOlimpica[j][ID_ATLETA] = "";
            atletesVilaOlimpica[j][ID_PAIS] = "";
            atletesVilaOlimpica[j][ID_MEDALLES] = "";
        }
    }

    

    public void inicialita() {
        numAtletesRegistrats = 0;
        codiUltimAtleta = 0;

        // Inicialitzem totes les dades de la vila olimpica
        for (int i = 0; i < atletesVilaOlimpica.length; ++i) {
            atletesVilaOlimpica[i][ID_ATLETA] = "";
            atletesVilaOlimpica[i][ID_PAIS] = "";
            atletesVilaOlimpica[i][ID_MEDALLES] = "";
        }
    }

    public void addAtleta(String idAtleta, String idpais, String idmedalla, int posicio) {
        if (!idAtleta.equals("")) {
            numAtletesRegistrats++;
            atletesVilaOlimpica[posicio][DadesVila.ID_ATLETA] = idAtleta;
            atletesVilaOlimpica[posicio][DadesVila.ID_PAIS] = idpais;
            atletesVilaOlimpica[posicio][DadesVila.ID_MEDALLES] = idmedalla;
            int numAtleta = Integer.parseInt(idAtleta.replace("AT", ""));
            if (numAtleta > codiUltimAtleta) {
                codiUltimAtleta = numAtleta;
            }
        }
    }

}
